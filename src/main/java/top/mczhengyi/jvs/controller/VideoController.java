package top.mczhengyi.jvs.controller;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import top.mczhengyi.jvs.bean.Result;
import top.mczhengyi.jvs.bean.Video;
import top.mczhengyi.jvs.service.AuthService;
import top.mczhengyi.jvs.service.VideoService;
import top.mczhengyi.jvs.utils.ResultUtils;

import java.io.IOException;

@RestController
@RequestMapping("/video")
public class VideoController extends BaseController {
    @Autowired
    VideoService videoService;

    @Autowired
    private AuthService authService;

    @GetMapping("/getAll")
    public Result getAll() {
        return ResultUtils.success(videoService.getAll());
    }

    @GetMapping("/get/uid/{id}")
    public Result getVideosByUid(@PathVariable("id") Integer id) {
        return ResultUtils.success(videoService.getVideoByUid(id));
    }

    @GetMapping("/get/{id}")
    public Result getVideoByVid(@PathVariable("id") Integer id) {
        return ResultUtils.success(videoService.getVideo(id));
    }

    @PostMapping("/insert")
    public Result insertVideo(@RequestParam(value = "file", required = false) MultipartFile multipartFile, Video video) {
        Integer uid = (Integer) SecurityUtils.getSubject().getPrincipal();
        video.setUploaderId(uid);
        if (video.getName()==null) {
            return ResultUtils.fail("请填写视频名称");
        }
        if (video.getType() == null) {
            return ResultUtils.fail("请选择视频类型");
        }
        try {
            return ResultUtils.success(videoService.saveVideo(multipartFile, video));
        } catch (IOException e) {
            return ResultUtils.fail("ERROR");
        }
    }

    @PutMapping("/update/{vid}")
    public Result updateVideo(@PathVariable("vid") Integer vid, Video video) {
        Integer uid = (Integer) SecurityUtils.getSubject().getPrincipal();
        if (!videoService.getVideoUid(vid).equals(uid)) {
            return ResultUtils.fail("权限不足");
        }
        if (video.getName()==null && video.getType()==null  && video.getGid()==null && video.getInfo()==null) {
            return ResultUtils.fail("请传入要修改的参数");
        }
        return ResultUtils.success(videoService.update(vid, video));
    }

    @DeleteMapping("/delete/{vid}")
    public Result deleteByVid(@PathVariable("vid") Integer vid) {
        Integer uid = (Integer) SecurityUtils.getSubject().getPrincipal();
        if (!videoService.getVideoUid(vid).equals(uid)) {
            return ResultUtils.fail("权限不足");
        }
        try {
            return ResultUtils.success(videoService.deleteByVid(vid));
        } catch (IOException e) {
            e.printStackTrace();
            return ResultUtils.fail();
        }
    }
}
