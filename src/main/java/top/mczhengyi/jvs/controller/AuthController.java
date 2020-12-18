package top.mczhengyi.jvs.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.mczhengyi.jvs.bean.Result;
import top.mczhengyi.jvs.bean.User;
import top.mczhengyi.jvs.service.AuthService;
import top.mczhengyi.jvs.utils.ResultUtils;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    /**
     * 登录接口
     */
    @PostMapping("/login")
    public Result doLogin(User user) {
        try {
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
            subject.login(token);
            String authorization = (String) subject.getSession().getId();
            return ResultUtils.success(authorization);
        } catch (IncorrectCredentialsException e) {
            return ResultUtils.fail("密码错误");
        } catch (AuthenticationException e) {
            return ResultUtils.fail("该用户不存在");
        }
    }

    @PostMapping("/register")
    public Result doRegister(User user) {
        if (authService.getUserByUsername(user.getUsername()) != null) {
            return ResultUtils.fail("用户已存在");
        }
        ByteSource salt = ByteSource.Util.bytes(user.getUsername());
        String newPassword = new SimpleHash("MD5", user.getPassword(), salt, 1024).toHex();
        user.setPassword(newPassword);
        if (authService.saveUser(user) != 0) {
            return ResultUtils.success();
        }else {
            return ResultUtils.fail();
        }
    }

    @GetMapping("/logout")
    public Result logout() {
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();
        return ResultUtils.success();
    }

    @GetMapping("/getUserInfo")
    public Result getUserInfo() {
        String user = (String) SecurityUtils.getSubject().getPrincipal();
        return ResultUtils.success(authService.getUserInfoByUsername(user));
    }

    @GetMapping("/notLogin")
    public Result notLogin() {
        return ResultUtils.fail("您还没有登录哦");
    }
}
