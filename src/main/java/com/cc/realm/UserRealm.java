package com.cc.realm;

import com.cc.entity.User;
import com.cc.mapper.PermMapper;
import com.cc.mapper.UserMapper;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;
import java.util.UUID;

/**
 * @Author cc
 * @PackageName spring
 * @Package com.cc.realm
 * @Date 2022/5/24 17:52
 * @Version 1.0
 */
public class UserRealm extends AuthorizingRealm {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PermMapper permMapper;
    //认证方法
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("===========认证方法得到执行===========");
     UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
     //获取用户名
        String username = token.getUsername();
     //根据用户名在db中查找
        User user = userMapper.getByName(username);//数据库中的user
     //交给shiro去比对
        //principal 主体  credentials 密码  realmName realm 的名字
        ByteSource salt = ByteSource.Util.bytes(user.getSalt());
        SimpleAuthenticationInfo simpleAuthenticationInfo =new SimpleAuthenticationInfo(user,user.getPwd(),salt,getName());

        return simpleAuthenticationInfo;
    }

   //授权方法
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("===========授权方法得到执行===========");

        User principal = (User) principalCollection.getPrimaryPrincipal();
        Set<String> perms = this.permMapper.queryPerms(principal.getName());

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setStringPermissions(perms);

        return simpleAuthorizationInfo;
    }



    /*加密*/
    public static void main(String[] args){
        String hashAlgorithmName = "MD5";
        Object credentials = "12345";
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid);
        Object salt = ByteSource.Util.bytes(uuid.toString());
        Object result = new SimpleHash(hashAlgorithmName,credentials,salt,1024);
        System.out.println(result);

    }

}
