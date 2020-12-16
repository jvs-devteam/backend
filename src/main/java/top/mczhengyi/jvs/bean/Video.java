package top.mczhengyi.jvs.bean;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Video {
    private Integer vid;
    private String name;
    private String info;
    private Integer uploaderId;
    private User uploader;
    private Integer gid;
    private Integer type;
    private List<Ep> epList;

    public Video() {
    }

    public Video(Integer vid, String name, String info, Integer uploaderId, User uploader, Integer gid, Integer type, List<Ep> epList) {
        this.vid = vid;
        this.name = name;
        this.info = info;
        this.uploaderId = uploaderId;
        this.uploader = uploader;
        this.gid = gid;
        this.type = type;
        this.epList = epList;
    }

    public Integer getVid() {
        return vid;
    }

    public void setVid(Integer vid) {
        this.vid = vid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Integer getUploaderId() {
        return uploaderId;
    }

    public void setUploaderId(Integer uploaderId) {
        this.uploaderId = uploaderId;
    }

    public User getUploader() {
        return uploader;
    }

    public void setUploader(User uploader) {
        this.uploader = uploader;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public List<Ep> getEpList() {
        return epList;
    }

    public void setEpList(List<Ep> epList) {
        this.epList = epList;
    }

    @Override
    public String toString() {
        return "Video{" +
                "vid=" + vid +
                ", name='" + name + '\'' +
                ", info='" + info + '\'' +
                ", uploaderId=" + uploaderId +
                ", uploader=" + uploader +
                ", gid=" + gid +
                ", type=" + type +
                ", epList=" + epList +
                '}';
    }
}
