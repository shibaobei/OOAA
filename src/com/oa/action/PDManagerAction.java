package com.oa.action;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Collection;

import javax.annotation.Resource;

import com.oa.service.PDManager;
import com.opensymphony.xwork2.ActionSupport;
import org.jbpm.api.ProcessDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.opensymphony.xwork2.ActionContext;

@Controller("pDManagerAction")
@Scope("prototype")
public class PDManagerAction extends ActionSupport {
    @Resource(name="pDManager")
    private PDManager pdManager;

    private File file;
    public File getFile() {
        return file;
    }
    public void setFile(File file) {
        this.file = file;
    }

    private String key;
    public String getKey() {
        return key;
    }
    public void setKey(String key) {
        this.key = key;
    }
    private InputStream inputStream;
    public InputStream getInputStream() {
        return inputStream;
    }
    private String deploymentId;
    public String getDeploymentId() {
        return deploymentId;
    }
    public void setDeploymentId(String deploymentId) {
        this.deploymentId = deploymentId;
    }

    public String getLasterVersions(){
        Collection<ProcessDefinition> pdList = this.pdManager.getLasterVersions();
        ActionContext.getContext().put("pdList", pdList);
        return "listAction";
    }
    public String deployUI(){
        return "deployUI";
    }
    public String deploy() throws FileNotFoundException {
        this.pdManager.deploy(this.file);
        return "action2action";
    }
    public String delete(){
        this.pdManager.deletePDKEY(this.getKey());
        return "action2action";
    }
    public String showImage(){
        this.inputStream = this.pdManager.showImage(this.deploymentId);
        return SUCCESS;
    }
}
