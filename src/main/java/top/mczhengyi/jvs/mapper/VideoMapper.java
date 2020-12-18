package top.mczhengyi.jvs.mapper;

import org.apache.ibatis.annotations.Mapper;
import top.mczhengyi.jvs.bean.Ep;
import top.mczhengyi.jvs.bean.Video;

import java.util.List;

@Mapper
public interface VideoMapper {
    List<Video> queryVideo();
    Video queryVideoByVid(Integer vid);
    Integer save(Video video);
    Integer update(Integer vid, Video video);
    Integer deleteByVid(Integer vid);
}
