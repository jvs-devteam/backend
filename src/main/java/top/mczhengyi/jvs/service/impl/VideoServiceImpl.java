package top.mczhengyi.jvs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.mczhengyi.jvs.bean.Video;
import top.mczhengyi.jvs.mapper.VideoMapper;
import top.mczhengyi.jvs.service.VideoService;

import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {
    @Autowired
    VideoMapper videoMapper;

    @Override
    public List<Video> getAll() {
        return videoMapper.queryVideo();
    }

    @Override
    public Video getVideo(Integer vid) {
        return videoMapper.queryVideoByVid(vid);
    }

    @Override
    public Video saveVideo(Video video) {
        videoMapper.save(video);
        return video;
    }

    @Override
    public Integer update(Integer vid, Video video) {
        return videoMapper.update(vid, video);
    }

    @Override
    public Integer deleteByVid(Integer vid) {
        return videoMapper.deleteByVid(vid);
    }
}
