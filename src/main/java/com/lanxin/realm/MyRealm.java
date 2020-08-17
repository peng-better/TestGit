package com.lanxin.realm;

import com.lanxin.mapper.UserMapper;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Set;

public class MyRealm extends AuthorizingRealm {

    @Autowired
    private UserMapper userMapper;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username=(String) principalCollection.getPrimaryPrincipal();
        Set<String> roles=userMapper.doGetRoleByUsername(username);
        Set<String> permissions=userMapper.doGetPermissionsByUsername(username);
        SimpleAuthorizationInfo simpleAuthorizationInfo=new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setRoles(roles);
        simpleAuthorizationInfo.setStringPermissions(permissions);
        return simpleAuthorizationInfo;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username=(String) authenticationToken.getPrincipal();
        String password=userMapper.doGetPasswordByUsername(username);
        if(password!=null){
            SimpleAuthenticationInfo authenticationInfo=new SimpleAuthenticationInfo(username,password,getName());
            authenticationInfo.setCredentialsSalt(ByteSource.Util.bytes(username+"skDlksklj&&**@#@#;"));
            return authenticationInfo;
        }
        return null;
    }
}
