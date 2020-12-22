package top.mczhengyi.jvs.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.mczhengyi.jvs.bean.Result;
import top.mczhengyi.jvs.utils.ConfigUtils;
import top.mczhengyi.jvs.utils.ResultUtils;

@RestController
public class InfoController extends BaseController {
    @GetMapping("/getFileServer")
    public Result getFileServer() {
        return ResultUtils.success(ConfigUtils.getBaseUrl());
    }
}
