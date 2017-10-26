package com.oa.entity;

import org.apache.struts2.json.annotations.JSON;

import java.io.Serializable;
import java.util.Set;

/**
 * Created by Administrator on 2017-10-20.
 */
public class Kynamic implements Serializable{
    private Long kid;
    private Long pid;
    private String name;
    private Boolean isParent;
    private Set<Version> versions;

    public Long getKid() {
        return kid;
    }

    public void setKid(Long kid) {
        this.kid = kid;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getIsParent() {
        return isParent;
    }

    public void setIsParent(Boolean parent) {
        isParent = parent;
    }
    @JSON(serialize = false)
    public Set<Version> getVersions() {
        return versions;
    }

    public void setVersions(Set<Version> versions) {
        this.versions = versions;
    }
}
