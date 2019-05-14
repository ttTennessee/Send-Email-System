package xyz.jfshare.demos.send.email.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import xyz.jfshare.demos.send.email.entity.UserTable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class AfterLoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //从request中获取Session
        HttpSession session = request.getSession();
        //从session中获取user
        UserTable user = (UserTable) session.getAttribute("user");

        if (user == null) {
            //这个方法返回false表示忽略当前请求，如果一个用户调用了需要登陆才能使用的接口，如果他没有登陆这里会直接忽略掉
            //也可以利用response给用户返回一些提示信息，告诉他没登陆
            System.out.println("未登录，可以访问login");
            return true;
        }else {
            //如果session里面有user说明用户已经登录
            response.sendRedirect("/user/alreadyLogin");
            System.out.println("已经登录，拦截");
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
