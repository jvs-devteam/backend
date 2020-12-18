package top.mczhengyi.jvs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.mczhengyi.jvs.bean.User;
import top.mczhengyi.jvs.mapper.UserMapper;
import top.mczhengyi.jvs.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private UserMapper userMapper;


    @Override
    public User getUserByUsername(String username) {
        return userMapper.queryUserByUsername(username);
    }

    @Override
    public Integer saveUser(User user) {
        return userMapper.saveUser(user);
    }

    @Override
    public User getUserInfoByUsername(String username) {
        return userMapper.queryUserInfoByUsername(username);
    }

    @Override
    public User getUserByUid(Integer uid) {
        return userMapper.queryUserByUid(uid);
    }
}
