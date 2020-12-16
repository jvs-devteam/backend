package top.mczhengyi.jvs.service.impl;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import top.mczhengyi.jvs.bean.Ep;
import top.mczhengyi.jvs.mapper.EpMapper;
import top.mczhengyi.jvs.service.EpService;
import top.mczhengyi.jvs.utils.ConfigUtils;
import top.mczhengyi.jvs.utils.FileNameUtils;

import java.io.File;

@Service
public class EpServiceImpl implements EpService {
    @Autowired
    EpMapper epMapper;

    @Override
    public void insertVideo(MultipartFile multipartFile, Ep ep) throws Exception {
        String fileName = FileNameUtils.getRandomVideoFileName() + "-unprocessed."
                + FilenameUtils.getExtension(multipartFile.getOriginalFilename());
        File dest = new File(ConfigUtils.getBasePath() + "/" + fileName);
        multipartFile.transferTo(dest);
        ep.setLink("/" + fileName);
        epMapper.insertEp(ep);
    }

    @Override
    public void updateEp(Ep ep) {
        epMapper.updateEp(ep);
    }

    @Override
    public void updateSource(MultipartFile file, Integer eid) throws Exception {
        String fileName = FileNameUtils.getRandomVideoFileName() + "-unprocessed."
                + FilenameUtils.getExtension(file.getOriginalFilename());
        File dest = new File(ConfigUtils.getBasePath() + "/" + fileName);
        file.transferTo(dest);
        String link = "/" + fileName;
        String oldLink = epMapper.queryEpByEid(eid).getLink();
        epMapper.updateSource(eid, link);
        FileUtils.forceDelete(new File(ConfigUtils.getBasePath() + oldLink));
    }
}
