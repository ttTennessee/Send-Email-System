package xyz.jfshare.demos.send.email.service;

import xyz.jfshare.demos.send.email.entity.UserTable;

public interface UserService {
    UserTable getByEmail(String email);
    UserTable login(String email,String password);
    int register(String email,String password,int code,String name,UserTable userTable);
    void sendCode(String to, String subject, String content);
}
