package top.mczhengyi.jvs.mapper;

import org.apache.ibatis.annotations.Mapper;
import top.mczhengyi.jvs.bean.Group;

import java.util.List;

@Mapper
public interface GroupMapper {
    List<Group> queryGroups();
    Group queryGroupByGid(Integer gid);
    Integer insertGroup(Group group);
    Integer updateGroup(Group group);
    Integer deleteGroupByGid(Integer gid);
}
