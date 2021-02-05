package top.mczhengyi.jvs.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import top.mczhengyi.jvs.bean.Config;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigUtils {
    private static final Properties properties = new Properties();

    static {
        InputStream is = null;
        try {
            System.out.println("Runing Config");
            ClassPathResource classPathResource = new ClassPathResource("config" + File.separator + "config.properties");
            is = classPathResource.getInputStream();
            properties.load(is);
        } catch (IOException e) {
            System.out.println("无法找到文件");
        }finally {
            try {
                if (is != null)
                    is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String getBaseUrl() {
        return properties.getProperty("videoServer.url");
    }

    public static String getFfmpegPath() {
        return properties.getProperty("ffmpeg.rootPath");
    }
}
