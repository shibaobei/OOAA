package com.oa.entity;

import org.apache.struts2.json.annotations.JSON;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2017-10-20.
 */
public class Version implements Serializable{
    private Long vid;
    private Long version;//版本号
    private String content;
    private String title;
    private Date updatetime;

    private Kynamic kynamic;

    public Long getVid() {
        return vid;
    }

    public void setVid(Long vid) {
        this.vid = vid;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    @JSON(serialize = false)
    public Kynamic getKynamic() {
        return kynamic;
    }

    public void setKynamic(Kynamic kynamic) {
        this.kynamic = kynamic;
    }
}
