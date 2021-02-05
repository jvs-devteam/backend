package top.mczhengyi.jvs.service.impl;

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
import top.mczhengyi.jvs.utils.EnvUtils;
import top.mczhengyi.jvs.utils.JvsFileUtils;

import java.io.File;

@Service
public class EpServiceImpl implements EpService {
    @Autowired
    EpMapper epMapper;

    @Autowired
    private VideoMapper videoMapper;

    @Override
    public void insertVideo(MultipartFile multipartFile, Ep ep) throws Exception {
        String fileName = JvsFileUtils.getRandomVideoFileName() + "-unprocessed."
                + FilenameUtils.getExtension(multipartFile.getOriginalFilename());
        File dest = new File(EnvUtils.getUploadPath() + "/video/" + fileName);
        multipartFile.transferTo(dest);
        ep.setLink("/video/" + fileName);
        epMapper.insertEp(ep);
    }

    @Override
    public void updateEp(Ep ep) {
        epMapper.updateEp(ep);
    }

    @Override
    public void updateSource(MultipartFile file, Integer eid) throws Exception {
        String fileName = JvsFileUtils.getRandomVideoFileName() + "-unprocessed."
                + FilenameUtils.getExtension(file.getOriginalFilename());
        File dest = new File(EnvUtils.getUploadPath()+ "/video/" + fileName);
        file.transferTo(dest);
        String link = "/video/" + fileName;
        String oldLink = epMapper.queryEpByEid(eid).getLink();
        epMapper.updateSource(eid, link);
        FileUtils.forceDelete(new File(EnvUtils.getUploadPath() + oldLink));
    }

    @Override
    public void deleteEp(Integer eid) {
        epMapper.deleteEpByEid(eid);
    }

    @Override
    public Integer getUidByEid(Integer eid) {
        Ep ep = epMapper.queryEpByEid(eid);
        if (ep == null) {
            return -1;
        }
        Video video = videoMapper.queryVideoByVid(ep.getVid());
        if (video == null) {
            return -1;
        }
        return video.getUploader().getUid();
    }

    @Override
    public Integer getUidByVid(Integer vid) {
        Video video = videoMapper.queryVideoByVid(vid);
        if (video == null) {
            return -1;
        }
        return video.getUploader().getUid();
    }
}
