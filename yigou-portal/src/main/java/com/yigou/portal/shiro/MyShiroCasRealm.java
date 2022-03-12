package com.yigou.portal.shiro;

import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cas.CasRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.HashSet;
import java.util.Set;

public class MyShiroCasRealm extends CasRealm {

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String loginName = (String) super.getAvailablePrincipal(principals);
        // 权限信息对象info，用来存放查出的用户的所有的角色及权限
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //下面就是查询用户的权限
        Set<String> roles = new HashSet<>();
        roles.add("admin");
        roles.add("normal");
        //下面也就可以查询用户的角色
        Set<String> perms = new HashSet<>();
        perms.add("del");
        perms.add("query");
        perms.add("user:query");
        info.setRoles(roles);
        info.setStringPermissions(perms);
        System.out.println("这里是授权的地方..............................");
        return info;
    }


}
