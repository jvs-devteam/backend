package top.mczhengyi.jvs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.mczhengyi.jvs.bean.User;

public interface AuthService {
    User getUserByUsername(String username);
    Integer saveUser(User user);
    User getUserInfoByUsername(String username);
}
