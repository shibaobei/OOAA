package com.oa.entity;

import java.io.Serializable;
import java.util.Set;

/**
 * Created by Administrator on 2017-10-09.
 */
public class Department implements Serializable{
    private Long did;
    private String dname;
    private String description;
    private Set<User> users;

    public Long getDid() {
        return did;
    }

    public void setDid(Long did) {
        this.did = did;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
