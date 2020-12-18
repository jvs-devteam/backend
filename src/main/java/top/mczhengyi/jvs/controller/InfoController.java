package top.mczhengyi.jvs.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.security.krb5.Config;
import top.mczhengyi.jvs.bean.Result;
import top.mczhengyi.jvs.utils.ConfigUtils;
import top.mczhengyi.jvs.utils.ResultUtils;

@RestController
public class InfoController {
    @GetMapping("/getFileServer")
    public Result getFileServer() {
        return ResultUtils.success(ConfigUtils.getBaseUrl());
    }
}
