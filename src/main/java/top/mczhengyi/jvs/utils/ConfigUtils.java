package top.mczhengyi.jvs.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigUtils {
    private static final Properties properties = new Properties();

    static {
        InputStream is = null;
        try {
            is = ClassLoader.getSystemResourceAsStream("config/config.properties");
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

    public static String getBasePath() {
        return properties.getProperty("videoServer.path");
    }
}
