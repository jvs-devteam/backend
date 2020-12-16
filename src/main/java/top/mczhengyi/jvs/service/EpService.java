package top.mczhengyi.jvs.service;

import org.springframework.web.multipart.MultipartFile;
import top.mczhengyi.jvs.bean.Ep;

public interface EpService {
    void insertVideo(MultipartFile multipartFile, Ep ep) throws Exception;
    void updateEp(Ep ep);
    void updateSource(MultipartFile file, Integer eid) throws Exception;
}