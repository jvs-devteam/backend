package top.mczhengyi.jvs.mapper;

import org.apache.ibatis.annotations.Mapper;
import top.mczhengyi.jvs.bean.User;

@Mapper
public interface UserMapper {
    User queryUserByUid(Integer uid);
    User queryUserByUsername(String username);
    Integer saveUser(User user);
    User queryUserInfoByUsername(String username);
}
