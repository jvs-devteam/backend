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
import top.mczhengyi.jvs.service.VideoService;
import top.mczhengyi.jvs.utils.ConfigUtils;
import top.mczhengyi.jvs.utils.JvsFileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {
    @Autowired
    VideoMapper videoMapper;

    @Autowired
    EpMapper epMapper;

    @Override
    public List<Video> getAll() {
        return videoMapper.queryVideo();
    }

    @Override
    public Video getVideo(Integer vid) {
        return videoMapper.queryVideoByVid(vid);
    }

    @Override
    public Video saveVideo(MultipartFile file, Video video) throws IOException {
        if (file != null) {
            String fileName = JvsFileUtils.getRandomVideoFileName() + "-unprocessed."
                    + FilenameUtils.getExtension(file.getOriginalFilename());
            File dest = new File(ConfigUtils.getBasePath() + "/cover_img/" + fileName);
            file.transferTo(dest);
            String filePath = "/cover_img/" + fileName;
            video.setCoverImg(filePath);
        }
        videoMapper.save(video);
        return video;
    }

    @Override
    public Integer update(Integer vid, Video video) {
        return videoMapper.update(vid, video);
    }

    @Override
    public Integer deleteByVid(Integer vid) throws IOException {
        List<Ep> eps = epMapper.queryEpByVid(vid);
        for (Ep ep : eps) {
            FileUtils.forceDelete(new File(ConfigUtils.getBasePath() + ep.getLink()));
            epMapper.deleteEpByEid(ep.getEid());
        }
        return videoMapper.deleteByVid(vid);
    }

    @Override
    public Integer getVideoUid(Integer vid) {
        return videoMapper.queryVideoByVid(vid).getUploader().getUid();
    }
}
