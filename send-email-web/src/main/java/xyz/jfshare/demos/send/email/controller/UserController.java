package xyz.jfshare.demos.send.email.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.jfshare.demos.send.email.entity.UserTable;
import xyz.jfshare.demos.send.email.service.UserService;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@RestController(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    private UserTable user = new UserTable();

    @PostMapping("/login")
    public Object login(String email,String password){
        UserTable userTable = userService.login(email, password);
        if (userTable!=null){
            Map<String,UserTable> map = new HashMap<>();
            map.put("user",userTable);
            return map;
        }
        return "{\"error\":\"邮箱或密码错误\"}";
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
        }
        return "{\"error\":\"网络超时，请稍后再试\"}";
    }

    @PostMapping("/sendCode")
    public String sendCode(String email){
        int code = (new Random()).nextInt(899999) + 100000;
        user.setCode(code);
        String subject = "验证码";
        String content = "您的验证码为: " + code + ",请在30分钟内完成注册!";
        userService.sendCode(email,subject,content);
        return "{\"ok\":\"发送成功\"}";
    }
}
