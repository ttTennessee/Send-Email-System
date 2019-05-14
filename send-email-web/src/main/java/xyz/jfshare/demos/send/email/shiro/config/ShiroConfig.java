package xyz.jfshare.demos.send.email.shiro.config;

//import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
//import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import xyz.jfshare.demos.send.email.shiro.realm.UserRealm;
//
//import java.util.LinkedHashMap;
//import java.util.Map;
//
//public class ShiroConfig {
//
//    /**
//     * 创建ShiroFilterFactoryBean
//     */
//    @Bean(name = "shiroFilterFactoryBean")
//    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager){
//        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
//        //设置安全管理器
//        shiroFilterFactoryBean.setSecurityManager(securityManager);
//
//        /**
//         * 添加Shiro内置过滤器，可以实现权限的相关拦截器
//         *      常用的拦截器：
//         *      anon：无需认证(登录)即可访问
//         *      authc：必须认证才能访问
//         *      user：如果使用rememberMe可以直接访问
//         *      perms：该资源必须得到资源权限才能访问
//         *      role：该资源必须得到角色权限才能访问
//         */
//        Map<String,String> filterMap = new LinkedHashMap<>();
//
//        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
//        shiroFilterFactoryBean.setLoginUrl("/login");
//
//        filterMap.put("user/success","authc");
//        filterMap.put("user/login","anon");
//
//        return shiroFilterFactoryBean;
//    }
//
//    /**
//     * 创建DefaultWebSecurityManager
//     */
//    @Bean(name = "securityManager")
//    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
//        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
//        securityManager.setRealm(userRealm);
//
//        return securityManager;
//    }
//
//
//    /**
//     * 创建Realm
//     */
//    @Bean(name = "userRealm")
//    public UserRealm getUserRealm(){
//        return new UserRealm();
//    }
//
//}
