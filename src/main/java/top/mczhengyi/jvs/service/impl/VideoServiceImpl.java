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
}
