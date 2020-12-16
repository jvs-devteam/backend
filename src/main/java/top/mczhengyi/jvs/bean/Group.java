package top.mczhengyi.jvs.bean;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Group {
    private Integer gid;
    private String name;
    private String info;
    private Integer creatorId;
    private User creator;
    private List<Video> videoList;

    public Group() {
    }

    public Group(Integer gid, String name, String info, Integer creatorId, User creator, List<Video> videoList) {
        this.gid = gid;
        this.name = name;
        this.info = info;
        this.creatorId = creatorId;
        this.creator = creator;
        this.videoList = videoList;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
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

    public Integer getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public List<Video> getVideoList() {
        return videoList;
    }

    public void setVideoList(List<Video> videoList) {
        this.videoList = videoList;
    }

    @Override
    public String toString() {
        return "Group{" +
                "gid=" + gid +
                ", name='" + name + '\'' +
                ", info='" + info + '\'' +
                ", creatorId=" + creatorId +
                ", creator=" + creator +
                ", videoList=" + videoList +
                '}';
    }
}
