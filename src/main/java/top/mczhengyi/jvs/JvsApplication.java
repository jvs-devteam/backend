package top.mczhengyi.jvs;

import org.apache.commons.io.FileUtils;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import top.mczhengyi.jvs.utils.ConfigUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@MapperScan("top.mczhengyi.jvs.mapper")
public class JvsApplication {

    private static final Logger log = LoggerFactory.getLogger(JvsApplication.class);

    public static void main(String[] args) {
        // 文件夹存在检查
        List<String> checkList = new ArrayList<>();
        // 文件夹检查表
        checkList.add("/");
        checkList.add("/cover_img");
        checkList.add("/video");
        for (String check : checkList) {
            File file = new File(ConfigUtils.getBasePath() + check);
            if (!file.exists()) {
                try {
                    FileUtils.forceMkdir(file);
                    log.info("{} 文件夹不存在，已经重新创建", check);
                } catch (IOException e) {
                    e.printStackTrace();
                    log.error("{} 文件夹创建失败!", check);
                }
            }
        }
        SpringApplication.run(JvsApplication.class, args);
    }

}
