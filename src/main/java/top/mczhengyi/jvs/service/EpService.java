package top.mczhengyi.jvs.service;

import org.springframework.web.multipart.MultipartFile;
import top.mczhengyi.jvs.bean.Ep;

public interface EpService {
    Boolean insertVideo(MultipartFile multipartFile, Ep ep, Integer uid) throws Exception;
    Boolean updateEp(Ep ep, Integer uid);
    Boolean updateSource(MultipartFile file, Integer eid, Integer uid) throws Exception;
    Boolean deleteEp(Integer eid, Integer uid);
}
