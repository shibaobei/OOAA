package com.oa.entity;

import java.io.Serializable;
import java.util.Set;

/**
 * Created by Administrator on 2017-10-23.
 * 表单模板
 */
public class FormTemplate implements Serializable{
    private Long ftid;
    private String name;//表单模板名称
    private String processKey;//jbpm中的pdkey
    private String url;//表单模板的存储路径

    private Set<Form> forms;


    public Long getFtid() {
        return ftid;
    }

    public void setFtid(Long ftid) {
        this.ftid = ftid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProcessKey() {
        return processKey;
    }

    public void setProcessKey(String processKey) {
        this.processKey = processKey;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Set<Form> getForms() {
        return forms;
    }

    public void setForms(Set<Form> forms) {
        this.forms = forms;
    }
}
