package xyz.jfshare.demos.send.email.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import tk.mybatis.mapper.entity.Example;
import xyz.jfshare.demos.send.email.entity.UserTable;
import xyz.jfshare.demos.send.email.mapper.UserTableMapper;
import xyz.jfshare.demos.send.email.service.UserService;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class UserServiceImpl implements UserService {

    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserTableMapper userTableMapper;

    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.from}")
    private String from;

    @Override
    public UserTable getByEmail(String email) {
        if(email!=null){
            Example example = new Example(UserTable.class);
            example.and().andEqualTo("email",email);
            UserTable userTable = userTableMapper.selectOneByExample(example);
            if (userTable!=null){
                logger.info("从数据库获取UserTable成功");
                return userTable;
            }
            logger.warn("数据库中没有此Email");
            return null;
        }
        logger.warn("Email为空");
        return null;
    }

    @Override
    public UserTable login(String email,String password) {
        UserTable userTable = getByEmail(email);
        if (userTable!=null){
            //将用户输入的密码进行一次MD5加密并和数据库中得到的密码比较
            if (userTable.getPassword().equals(DigestUtils.md5DigestAsHex(password.getBytes()))){
                //登录成功
                logger.info(String.format("%s登录成功",email));
                return userTable;
            }
            logger.info(String.format("%s密码输入错误",email));
        }
        return null;
    }

    @Override
    public int register(String email, String password, int code, String name,UserTable userTable) {
        if (!email.equals(userTable.getEmail())){
            logger.warn(String.format("邮箱%s和发送验证码的邮箱%s不一致",email,userTable.getEmail()));
            return -3;
        }
        if (getByEmail(email)!=null){
            logger.warn(String.format("%s邮箱已经注册过",email));
            return -2;
        }
        if (code==userTable.getCode()){
            userTable.setName(name);
            userTable.setEmail(email);
            userTable.setPassword(DigestUtils.md5DigestAsHex(password.getBytes()));
            int result = userTableMapper.insertSelective(userTable);
            if (result == 1){
                logger.info("注册成功");
                return result;
            }
            logger.error("注册失败，数据库操作错误");
            return result;
        }else {
            logger.warn(String.format("%s验证码输入错误",email));
            return -1;
        }
    }

    @Override
    public void sendCode(String to, String subject, String content) {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper;
        try {
            helper = new MimeMessageHelper(message,true);
            helper.setFrom(from);
            System.out.println(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content);
            mailSender.send(message);
            logger.info("验证码成功发送！");
        } catch (MessagingException e) {
            logger.error("验证码发送失败！");
        }
    }
}
