package xyz.jfshare.demos.send.email.shiro.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import xyz.jfshare.demos.send.email.entity.UserTable;
import xyz.jfshare.demos.send.email.service.UserService;

//public class UserRealm extends AuthorizingRealm {
//
////    /**
////     * 执行授权逻辑
////     * @param principalCollection
////     * @return
////     */
////    @Override
////    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
////        return null;
////    }
////
////    @Autowired
////    private UserService userService;
////
////    /**
////     * 执行认证逻辑
////     * @param authenticationToken
////     * @return
////     * @throws AuthenticationException
////     */
////    @Override
////    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
////
////        //编写shiro逻辑判断，判断用户名和密码
////        //判断用户名
////        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
////
////        UserTable userTable = userService.getByEmail(token.getUsername());
////
////        if (userTable == null){
////            //邮箱不存在
////            return null;
////        }
////
////        //判断密码
////        return new SimpleAuthenticationInfo("",userTable.getPassword(),"");
////    }
//}
