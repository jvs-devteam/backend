package top.mczhengyi.jvs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.mczhengyi.jvs.bean.Result;
import top.mczhengyi.jvs.bean.Video;
import top.mczhengyi.jvs.service.VideoService;
import top.mczhengyi.jvs.utils.ResultUtils;

@RestController
@RequestMapping("/video")
public class VideoController {
    @Autowired
    VideoService videoService;

    @GetMapping("/getAll")
    public Result getAll() {
        return ResultUtils.success(videoService.getAll());
    }

    @GetMapping("/get/{id}")
    public Result getVideoByVid(@PathVariable("id") Integer id) {
        return ResultUtils.success(videoService.getVideo(id));
    }

    @PostMapping("/insert")
    public Result insertVideo(Video video) {
        if (video.getName()==null) {
            return ResultUtils.fail("请填写视频名称");
        }
        if (video.getType() == null) {
            return ResultUtils.fail("请选择视频类型");
        }
        if (video.getUploaderId() == null) {
            return ResultUtils.fail("未指定上传者");
        }
        return ResultUtils.success(videoService.saveVideo(video));
    }

    @PutMapping("/update/{vid}")
    public Result updateVideo(@PathVariable("vid") Integer vid, Video video) {
        return ResultUtils.success(videoService.update(vid, video));
    }

    @DeleteMapping("/delete/{vid}")
    public Result deleteByVid(@PathVariable("vid") Integer vid) {
        return ResultUtils.success(videoService.deleteByVid(vid));
    }
}
