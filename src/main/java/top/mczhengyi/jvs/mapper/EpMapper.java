package top.mczhengyi.jvs.mapper;

import org.apache.ibatis.annotations.Mapper;
import top.mczhengyi.jvs.bean.Ep;

import java.util.List;

@Mapper
public interface EpMapper {
    List<Ep> queryEpByVid(Integer vid);
    Ep queryEpByEid(Integer eid);
    Integer insertEp(Ep ep);
    Integer updateEp(Ep ep);
    Integer updateSource(Integer eid, String path);
}
