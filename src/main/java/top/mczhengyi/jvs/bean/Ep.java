package top.mczhengyi.jvs.bean;

public class Ep {
    private Integer eid;
    private String name;
    private String link;
    private Integer vid;

    public Ep() {
    }

    public Ep(Integer eid, String name, String link, Integer vid) {
        this.eid = eid;
        this.name = name;
        this.link = link;
        this.vid = vid;
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Integer getVid() {
        return vid;
    }

    public void setVid(Integer vid) {
        this.vid = vid;
    }

    @Override
    public String toString() {
        return "Ep{" +
                "eid=" + eid +
                ", name='" + name + '\'' +
                ", link='" + link + '\'' +
                ", vid=" + vid +
                '}';
    }
}
