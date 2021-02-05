package top.mczhengyi.jvs.utils;

import org.springframework.boot.system.ApplicationHome;
import top.mczhengyi.jvs.JvsApplication;

import java.io.File;

public class EnvUtils {
    private static final ApplicationHome applicationHome = new ApplicationHome(JvsApplication.class);

    public static String getBasePath() {
        File jarF = applicationHome.getSource();
        return jarF.getParentFile().toString();
    }

    public static String getUploadPath() {
        File jarF = applicationHome.getSource();
        return jarF.getParentFile().toString();
    }
}
