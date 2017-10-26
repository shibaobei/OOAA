package com.oa.entity;

import org.apache.struts2.json.annotations.JSON;

import java.io.Serializable;
import java.util.Set;

/**
 * Created by Administrator on 2017-10-16.
 */
public class Menuitem implements Serializable{
    private Long mid;
    private Long pid;//父节点id
    private String name;//树上的节点
    private Boolean isParent;//是否为文件夹节点
    private String icon;//图标图片路径
    private String url;//跳转路径
    private String target;
    private Boolean checked;

    public Boolean getChecked() {
        return checked;
    }
    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    private Set<User> users;

    public Long getMid() {
        return mid;
    }

    public void setMid(Long mid) {
        this.mid = mid;
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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @JSON(serialize=false)
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }
}
