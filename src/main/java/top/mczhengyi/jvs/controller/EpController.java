package top.mczhengyi.jvs.controller;

import org.apache.ibatis.annotations.Delete;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import top.mczhengyi.jvs.bean.Ep;
import top.mczhengyi.jvs.bean.Result;
import top.mczhengyi.jvs.bean.Video;
import top.mczhengyi.jvs.service.AuthService;
import top.mczhengyi.jvs.service.EpService;
import top.mczhengyi.jvs.service.VideoService;
import top.mczhengyi.jvs.utils.ConvertVideo;
import top.mczhengyi.jvs.utils.ResultUtils;

//FIXME: 上传视频无挂载权限认证

@RestController
@RequestMapping("/ep")
public class EpController {
    @Autowired
    EpService epService;

    @Autowired
    private AuthService authService;

    @PostMapping("/insert")
    public Result insertEp(@RequestParam("file") MultipartFile multipartFile, Ep ep){
        if (multipartFile.isEmpty()) {
            return ResultUtils.fail("请选择要上传的文件!");
        }
        if (ep.getVid() == null) {
            return ResultUtils.fail("请指定要上传到的vid");
        }
        // 用户认证
        Integer uid = (Integer) SecurityUtils.getSubject().getPrincipal();
        String filename = multipartFile.getOriginalFilename();
        if (ConvertVideo.checkVideoFormat(filename)==0) {
            return ResultUtils.fail("请上传视频格式!(支持mp4)");
            // ,webm,avi,mkv
        }
        if (ep.getName() == null) {
            ep.setName(filename);
        }
        try {
            if (epService.insertVideo(multipartFile, ep, uid)) {
                return ResultUtils.success();
            }else  {
                return ResultUtils.fail("权限不足");
            }
        }catch (Exception e) {
            e.printStackTrace();
            return ResultUtils.fail();
        }
    }

    @PutMapping("/update/{id}")
    public Result update(@PathVariable("id") Integer eid, Ep ep) {
        Integer uid = (Integer) SecurityUtils.getSubject().getPrincipal();
        if (ep.getName() == null) {
            return ResultUtils.fail("请传入name参数");
        }
        ep.setEid(eid);
        if (epService.updateEp(ep, uid)) {
            return ResultUtils.success();
        }else {
            return ResultUtils.fail("权限不足");
        }
    }

    @PutMapping("/updateSource/{id}")
    public Result updateSource(@PathVariable("id") Integer eid, @RequestParam("file") MultipartFile file) {
        Integer uid = (Integer) SecurityUtils.getSubject().getPrincipal();
        if (file.isEmpty()) {
            return ResultUtils.fail("请选择要上传的文件!");
        }
        String filename = file.getOriginalFilename();
        if (ConvertVideo.checkVideoFormat(filename)==0) {
            return ResultUtils.fail("请上传视频格式!(支持mp4)");
            // ,webm,avi,mkv
        }
        try {
            if(epService.updateSource(file, eid, uid)) {
                return ResultUtils.success();
            }else {
                return ResultUtils.fail("权限不足");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtils.fail();
        }
    }

    @DeleteMapping("/delete/{id}")
    public Result deleteEp(@PathVariable("id") Integer eid) {
        String user = (String) SecurityUtils.getSubject().getPrincipal();
        Integer uid = authService.getUserInfoByUsername(user).getUid();
        if (epService.deleteEp(eid, uid)) {
            return ResultUtils.success();
        }else {
            return ResultUtils.fail("权限不足");
        }
    }
}
