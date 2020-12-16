package top.mczhengyi.jvs.utils;

import java.util.UUID;

public class FileNameUtils {
    /**
     * 获取一个随机的视频文件名
     * @return 返回一个随机文件名
     */
    public static String getRandomVideoFileName() {
        return String.valueOf(UUID.randomUUID());
    }
}
