package top.mczhengyi.jvs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.mczhengyi.jvs.bean.Result;
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
}
