package top.mczhengyi.jvs.service.impl;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import top.mczhengyi.jvs.bean.Ep;
import top.mczhengyi.jvs.bean.Video;
import top.mczhengyi.jvs.mapper.EpMapper;
import top.mczhengyi.jvs.mapper.VideoMapper;
import top.mczhengyi.jvs.service.EpService;
import top.mczhengyi.jvs.utils.ConfigUtils;
import top.mczhengyi.jvs.utils.JvsFileUtils;

import java.io.File;

@Service
public class EpServiceImpl implements EpService {
    @Autowired
    EpMapper epMapper;

    @Autowired
    private VideoMapper videoMapper;

    @Override
    public Boolean insertVideo(MultipartFile multipartFile, Ep ep, Integer uid) throws Exception {
        // 校验上传者是否是在自己的视频上操作
        Integer videoUid = videoMapper.queryVideoByVid(ep.getVid()).getUploader().getUid();
        if (!videoUid.equals(uid)) {
            return false;
        }
        String fileName = JvsFileUtils.getRandomVideoFileName() + "-unprocessed."
                + FilenameUtils.getExtension(multipartFile.getOriginalFilename());
        File dest = new File(ConfigUtils.getBasePath() + "/video/" + fileName);
        multipartFile.transferTo(dest);
        ep.setLink("/video/" + fileName);
        epMapper.insertEp(ep);
        return true;
    }

    @Override
    public Boolean updateEp(Ep ep, Integer uid) {
        if (!videoMapper.queryVideoByVid(ep.getVid()).getUploader().getUid().equals(uid)) {
            return false;
        }
        epMapper.updateEp(ep);
        return true;
    }

    @Override
    public Boolean updateSource(MultipartFile file, Integer eid, Integer uid) throws Exception {
        if (!videoMapper.queryVideoByVid(epMapper.queryEpByEid(eid).getVid()).getUploader().getUid().equals(uid)) {
            return false;
        }
        String fileName = JvsFileUtils.getRandomVideoFileName() + "-unprocessed."
                + FilenameUtils.getExtension(file.getOriginalFilename());
        File dest = new File(ConfigUtils.getBasePath() + "/video/" + fileName);
        file.transferTo(dest);
        String link = "/video/" + fileName;
        String oldLink = epMapper.queryEpByEid(eid).getLink();
        epMapper.updateSource(eid, link);
        FileUtils.forceDelete(new File(ConfigUtils.getBasePath() + oldLink));
        return true;
    }

    @Override
    public Boolean deleteEp(Integer eid, Integer uid) {
        if (!videoMapper.queryVideoByVid(epMapper.queryEpByEid(eid).getVid()).getUploader().getUid().equals(uid)) {
            return false;
        }
        epMapper.deleteEpByEid(eid);
        return true;
    }
}
