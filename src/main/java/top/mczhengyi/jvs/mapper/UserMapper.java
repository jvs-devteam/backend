package top.mczhengyi.jvs.mapper;

import org.apache.ibatis.annotations.Mapper;
import top.mczhengyi.jvs.bean.User;

@Mapper
public interface UserMapper {
    User queryUserByUid(Integer uid);
}
