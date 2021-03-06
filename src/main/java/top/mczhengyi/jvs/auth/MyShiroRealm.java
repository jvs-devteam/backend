package top.mczhengyi.jvs.auth;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import top.mczhengyi.jvs.bean.User;
import top.mczhengyi.jvs.mapper.UserMapper;

public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserMapper userMapper;


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String) authenticationToken.getPrincipal();
        User user = userMapper.queryUserByUsername(username);
        if (user == null) {
            return null;
        }
        return new SimpleAuthenticationInfo(
                user.getUid(),
                user.getPassword(),
                ByteSource.Util.bytes(username),
                getName()
        );
    }
}
