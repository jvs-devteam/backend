package top.mczhengyi.jvs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.mczhengyi.jvs.bean.Group;
import top.mczhengyi.jvs.mapper.GroupMapper;
import top.mczhengyi.jvs.service.GroupService;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {
    @Autowired
    GroupMapper groupMapper;

    @Override
    public List<Group> getAll() {
        return groupMapper.queryGroups();
    }

    @Override
    public Group getGroupByGid(Integer gid) {
        return groupMapper.queryGroupByGid(gid);
    }

    @Override
    public Integer insertGroup(Group group) {
        return groupMapper.insertGroup(group);
    }

    @Override
    public Integer updateGroup(Integer gid, Group group) {
        group.setGid(gid);
        return groupMapper.updateGroup(group);
    }

    @Override
    public Integer deleteGroup(Integer gid) {
        return groupMapper.deleteGroupByGid(gid);
    }

    @Override
    public Integer getUidByGid(Integer gid) {
        Group group = groupMapper.queryGroupByGid(gid);
        if (group == null) {
            return -1;
        }
        return group.getCreator().getUid();
    }
}
