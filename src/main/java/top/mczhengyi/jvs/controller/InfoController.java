package top.mczhengyi.jvs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.mczhengyi.jvs.bean.Config;
import top.mczhengyi.jvs.bean.Result;
import top.mczhengyi.jvs.utils.ConfigUtils;
import top.mczhengyi.jvs.utils.ResultUtils;

@RestController
public class InfoController extends BaseController {
    @Autowired
    private Config config;

    @GetMapping("/getFileServer")
    public Result getFileServer() {
        return ResultUtils.success(config.getUploadUrl());
    }

    @GetMapping("/test")
    public String testApi() {
        System.out.println(config.getUrl());
        return config.getUrl();
    }
}
