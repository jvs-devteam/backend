package top.mczhengyi.jvs.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 自定义配置文件
 * @author 正义桑
 * @version 1.0.0
 */

@Component
@ConfigurationProperties(prefix = "jvs")
public class Config {
    private String url;
    private String redisHost;
    private int redisExpire;
    private int redisTimeout;
    private String uploadUrl;

    public String getRedisHost() {
        return redisHost;
    }

    public void setRedisHost(String redisHost) {
        this.redisHost = redisHost;
    }

    public int getRedisExpire() {
        return redisExpire;
    }

    public void setRedisExpire(int redisExpire) {
        this.redisExpire = redisExpire;
    }

    public int getRedisTimeout() {
        return redisTimeout;
    }

    public void setRedisTimeout(int redisTimeout) {
        this.redisTimeout = redisTimeout;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUploadUrl() {
        return uploadUrl;
    }
}
