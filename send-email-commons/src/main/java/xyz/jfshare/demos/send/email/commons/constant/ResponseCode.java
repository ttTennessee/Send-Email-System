package xyz.jfshare.demos.send.email.commons.constant;

public class ResponseCode {

    /**
     * 注册返回的JSON
     */
    public static final String REGISTER_SEND_SUCCESS = "{\"ok\":\"发送成功\"}";
    public static final String REGISTER_SUCCESS = "{\"ok\":\"注册成功\"}";
    public static final String REGISTER_ERROR_CODE = "{\"error\":\"验证码错误\"}";
    public static final String REGISTER_EMAIL_EXISTS = "{\"error\":\"该邮箱已经注册，请换其他邮箱\"}";
    public static final String REGISTER_EMAIL_DIFFER = "{\"error\":\"注册的邮箱和发送验证码的邮箱不一致\"}";
    public static final String REGISTER_DATABASE_ERROR = "{\"error\":\"网络超时，请稍后再试\"}";


    /**
     * 登录返回的JSON
     */
    public static final String LOGIN_SUCCESS = "{\"ok\":\"登录成功\"}";
    public static final String LOGIN_EMAIL_ERROR = "{\"error\":\"邮箱输入错误\"}";
    public static final String LOGIN_PASSWORD_ERROR = "{\"error\":\"密码输入错误\"}";
    public static final String LOGIN_INPUT_ERROR = "{\"error\":\"邮箱或密码错误\"}";
    public static final String LOGIN_REPEAT_LOGIN = "{\"error\":\"用户已经登录不能重复登录\"}";

    /**
     * 访问主页返回的JSON
     */
    public static final String HOME_SUCCESS = "{\"ok\":\"个人主页\"}";
    public static final String HOME_NOT_LOGIN = "{\"error\":\"用户未登录\"}";
}
