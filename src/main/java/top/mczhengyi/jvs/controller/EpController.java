package top.mczhengyi.jvs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import top.mczhengyi.jvs.bean.Ep;
import top.mczhengyi.jvs.bean.Result;
import top.mczhengyi.jvs.service.EpService;
import top.mczhengyi.jvs.utils.ConvertVideo;
import top.mczhengyi.jvs.utils.ResultUtils;

@RestController
@RequestMapping("/ep")
public class EpController {
    @Autowired
    EpService epService;

    @PostMapping("/insert")
    public Result insertEp(@RequestParam("file") MultipartFile multipartFile, Ep ep){
        if (multipartFile.isEmpty()) {
            return ResultUtils.fail("请选择要上传的文件!");
        }
        if (ep.getVid() == null) {
            return ResultUtils.fail("请指定要上传到的vid");
        }
        String filename = multipartFile.getOriginalFilename();
        if (ConvertVideo.checkVideoFormat(filename)==0) {
            return ResultUtils.fail("请上传视频格式!(支持mp4)");
            // ,webm,avi,mkv
        }
        if (ep.getName() == null) {
            ep.setName(filename);
        }
        try {
            epService.insertVideo(multipartFile, ep);
            return ResultUtils.success();
        }catch (Exception e) {
            e.printStackTrace();
            return ResultUtils.fail();
        }
    }

    @PutMapping("/update/{id}")
    public Result update(@PathVariable("id") Integer eid, Ep ep) {
        if (ep.getName() == null) {
            return ResultUtils.fail("一共就这一个属性，你不改它请求我干啥?");
        }
        ep.setEid(eid);
        epService.updateEp(ep);
        return ResultUtils.success();
    }

    @PutMapping("/updateSource/{id}")
    public Result updateSource(@PathVariable("id") Integer eid, @RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResultUtils.fail("请选择要上传的文件!");
        }
        String filename = file.getOriginalFilename();
        if (ConvertVideo.checkVideoFormat(filename)==0) {
            return ResultUtils.fail("请上传视频格式!(支持mp4)");
            // ,webm,avi,mkv
        }
        try {
            epService.updateSource(file, eid);
            return ResultUtils.success();
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtils.fail();
        }
    }
}
