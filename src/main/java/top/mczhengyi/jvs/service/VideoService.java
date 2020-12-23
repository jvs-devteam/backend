package top.mczhengyi.jvs.service;

import org.springframework.web.multipart.MultipartFile;
import top.mczhengyi.jvs.bean.Video;

import java.io.IOException;
import java.util.List;

public interface VideoService {
    List<Video> getAll();
    Video getVideo(Integer vid);
    Video saveVideo(MultipartFile multipartFile, Video video) throws IOException;
    Integer update(Integer vid, Video video);
    Integer deleteByVid(Integer vid) throws IOException;
    Integer getVideoUid(Integer vid);
    List<Video> getVideoByUid(Integer uid);
}
