package com.wux.realm;

import com.wux.dao.UserDao;
import com.wux.entity.User;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by wuxiang
 * on 2018/4/20.
 */
public class AuthenByAccountRealm extends AuthorizingRealm {
    @Autowired
    private UserDao userDao;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {


        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String principal = (String) token.getPrincipal();
        User user = userDao.findUserByName(principal);
        if (user != null){
            SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user.getName(), user.getPassword(), "AuthenByAccountRealm");
            return info;
        } else {
            return null;
        }
    }
}
