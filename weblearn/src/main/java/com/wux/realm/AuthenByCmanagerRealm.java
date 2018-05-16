package com.wux.realm;

import com.wux.dao.CmanagerDao;
import com.wux.dao.UserDao;
import com.wux.entity.Cmanager;
import com.wux.entity.User;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by wuxiang
 * on 2018/4/20.
 */
public class AuthenByCmanagerRealm extends AuthorizingRealm {
    @Autowired
    private CmanagerDao cmanagerDao;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String principal = (String) token.getPrincipal();
        Cmanager cmanager = cmanagerDao.showCmanagerByUsername(principal);
        if (cmanager != null){
            SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(cmanager.getUsername(), cmanager.getPassword(), ByteSource.Util.bytes(cmanager.getSalt()), "AuthenByCmanagerRealm");
            new SimpleAuthenticationInfo();
            return info;
        } else {
            return null;
        }
    }
}
