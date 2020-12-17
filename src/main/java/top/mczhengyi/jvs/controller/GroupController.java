package top.mczhengyi.jvs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.mczhengyi.jvs.bean.Group;
import top.mczhengyi.jvs.bean.Result;
import top.mczhengyi.jvs.service.GroupService;
import top.mczhengyi.jvs.utils.ResultUtils;

import java.util.List;

@RestController
@RequestMapping("/group")
public class GroupController {
    @Autowired
    GroupService groupService;

    @GetMapping("/getAll")
    public Result getAll() {
        List<Group> groups = groupService.getAll();
        return ResultUtils.success(groups);
    }

    @GetMapping("/get/{id}")
    public Result getGroup(@PathVariable("id") Integer gid) {
        Group group = groupService.getGroupByGid(gid);
        return ResultUtils.success(group);
    }

    @PostMapping("/insert")
    public Result insertGroup(Group group) {
        if (groupService.insertGroup(group) == 0) {
            return ResultUtils.fail();
        } else {
            return ResultUtils.success();
        }
    }

    @PutMapping("/update/{id}")
    public Result updateGroup(@PathVariable("id") Integer gid, Group group) {
        if (groupService.updateGroup(gid, group) == 0) {
            return ResultUtils.fail();
        } else {
            return ResultUtils.success();
        }
    }

    @DeleteMapping("/delete/{id}")
    public Result deleteGroup(@PathVariable("id") Integer gid) {
        if (groupService.deleteGroup(gid)==0) {
            return ResultUtils.fail();
        } else {
            return ResultUtils.success();
        }
    }
}
