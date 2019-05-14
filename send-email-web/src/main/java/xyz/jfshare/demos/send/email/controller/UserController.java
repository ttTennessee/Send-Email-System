package xyz.jfshare.demos.send.email.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.jfshare.demos.send.email.commons.constant.ResponseCode;
import xyz.jfshare.demos.send.email.entity.UserTable;
import xyz.jfshare.demos.send.email.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    private UserTable user = new UserTable();

    @PostMapping("/login")
    public Object login(String email, String password, HttpServletRequest request){
        UserTable userTable = userService.login(email, password);
        if (userTable!=null){
            Map<String,UserTable> map = new HashMap<>();
            map.put("user",userTable);
            HttpSession session = request.getSession();
            session.setAttribute("user",userTable);
            return map;
        }
        return ResponseCode.LOGIN_INPUT_ERROR;
    /*    //1.获取Subject
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(email,password);
        //
        try{
            subject.login(token);

            return "{\"ok\":\"登录成功\"}";
        }catch (UnknownAccountException e){
            return "{\"error\":\"邮箱输入错误\"}";
        }catch (IncorrectCredentialsException e){
            return "{\"error\":\"密码输入错误\"}";
        }*/
    }

    @PostMapping("/register")
    public Object register(String email,String password,int code,String name){
        int result = userService.register(email,password,code,name,user);
        if (result == -1){
            return ResponseCode.REGISTER_ERROR_CODE;
        }else if (result == 1){
            return  ResponseCode.REGISTER_SUCCESS;
        }else if (result == -2){
            return  ResponseCode.REGISTER_EMAIL_EXISTS;
        }else if (result == -3){
            return  ResponseCode.REGISTER_EMAIL_DIFFER;
        }
        return  ResponseCode.REGISTER_DATABASE_ERROR;
    }

    @PostMapping("/sendCode")
    public String sendCode(String email){
        if (userService.getByEmail(email)!=null){
            return  ResponseCode.REGISTER_EMAIL_EXISTS;
        }
        int code = (new Random()).nextInt(899999) + 100000;
        user.setCode(code);
        user.setEmail(email);
        String subject = "验证码";
        String content = "您的验证码为: " + code + ",请在30分钟内完成注册!";
        userService.sendCode(email,subject,content);
        return  ResponseCode.REGISTER_SEND_SUCCESS;
    }

    @GetMapping("/success")
    public String success(){
        return ResponseCode.HOME_SUCCESS;
    }

    @GetMapping("/notLogin")
    public String notLogin() {
        return ResponseCode.HOME_NOT_LOGIN;
    }

    @GetMapping("/alreadyLogin")
    public String alreadyLogin() {
        return ResponseCode.LOGIN_REPEAT_LOGIN;
    }
}
