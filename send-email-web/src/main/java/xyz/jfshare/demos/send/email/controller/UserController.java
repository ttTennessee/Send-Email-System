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
        return "{\"error\":\"邮箱或密码错误\"}";
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
            return "{\"error\":\"验证码错误\"}";
        }else if (result == 1){
            return "{\"ok\":\"注册成功\"}";
        }else if (result == -2){
            return "{\"error\":\"该邮箱已经注册，请换其他邮箱\"}";
        }else if (result == -3){
            return "{\"error\":\""+email+"该邮箱和发送验证码邮箱"+user.getEmail()+"不一致\"}";
        }
        return "{\"error\":\"网络超时，请稍后再试\"}";
    }

    @PostMapping("/sendCode")
    public String sendCode(String email){
        if (userService.getByEmail(email)!=null){
            return "{\"error\":\"该邮箱已经注册，请换其他邮箱\"}";
        }
        int code = (new Random()).nextInt(899999) + 100000;
        user.setCode(code);
        user.setEmail(email);
        String subject = "验证码";
        String content = "您的验证码为: " + code + ",请在30分钟内完成注册!";
        userService.sendCode(email,subject,content);
        return "{\"ok\":\"发送成功\"}";
    }

    @GetMapping("/success")
    public String success(){
        return "{\"ok\":\"个人主页\"}";
    }

    @GetMapping("/notLogin")
    public String notLogin() {
        return "{\"error\":\"用户未登录\"}";
    }

    @GetMapping("/alreadyLogin")
    public String alreadyLogin() {
        return "{\"error\":\"用户已经登录不能重复登录\"}";
    }
}
