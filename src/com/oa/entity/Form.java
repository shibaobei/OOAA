package com.oa.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * Created by Administrator on 2017-10-23.
 */
public class Form implements Serializable{
    private Long Fid;
    private String title;
    private String applicator;
    private Date applicatetime;
    private String state;

    private String url;

    private FormTemplate formTemplate;
    private Set<Approve> approves;

    public Long getFid() {
        return Fid;
    }

    public void setFid(Long fid) {
        Fid = fid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getApplicator() {
        return applicator;
    }

    public void setApplicator(String applicator) {
        this.applicator = applicator;
    }

    public Date getApplicatetime() {
        return applicatetime;
    }

    public void setApplicatetime(Date applicatetime) {
        this.applicatetime = applicatetime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public FormTemplate getFormTemplate() {
        return formTemplate;
    }

    public void setFormTemplate(FormTemplate formTemplate) {
        this.formTemplate = formTemplate;
    }

    public Set<Approve> getApproves() {
        return approves;
    }

    public void setApproves(Set<Approve> approves) {
        this.approves = approves;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
