package top.mczhengyi.jvs.utils;

import jdk.internal.instrumentation.Logger;

import java.io.File;
import java.util.UUID;

public class JvsFileUtils {
    /**
     * 获取一个随机的视频文件名
     * @return 返回一个随机文件名
     */
    public static String getRandomVideoFileName() {
        return String.valueOf(UUID.randomUUID());
    }
}
