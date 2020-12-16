package top.mczhengyi.jvs.service;

import top.mczhengyi.jvs.bean.Video;

import java.util.List;

public interface VideoService {
    List<Video> getAll();
    Video getVideo(Integer vid);
    Video saveVideo(Video video);
    Integer update(Integer vid, Video video);
    Integer deleteByVid(Integer vid);
}
