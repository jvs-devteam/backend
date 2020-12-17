package top.mczhengyi.jvs.service;

import top.mczhengyi.jvs.bean.Group;

import java.util.List;

public interface GroupService {
    List<Group> getAll();
    Group getGroupByGid(Integer gid);
    Integer insertGroup(Group group);
    Integer updateGroup(Integer gid, Group group);
    Integer deleteGroup(Integer gid);
}
