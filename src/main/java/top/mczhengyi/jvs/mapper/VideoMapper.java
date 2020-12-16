package top.mczhengyi.jvs.mapper;

import org.apache.ibatis.annotations.Mapper;
import top.mczhengyi.jvs.bean.Video;

import java.util.List;

@Mapper
public interface VideoMapper {
    List<Video> queryVideo();
}
