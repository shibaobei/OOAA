package com.oa.action;

import com.oa.entity.FormTemplate;
import com.oa.service.FormTemplateService;
import com.oa.service.PDManager;
import com.oa.utils.UploadUtils;
import com.opensymphony.xwork2.ActionContext;
import org.jbpm.api.ProcessDefinition;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Collection;

/**
 * Created by Administrator on 2017-10-24.
 */
@Controller("formTemplateAction")
@Scope("prototype")
public class FormTemplateAction extends BaseAction<FormTemplate>{
    @Resource(name="formTemplateService")
    private FormTemplateService formTemplateService;
    @Resource(name = "pDManager")
    private PDManager pdManager;

    private File file;
    public File getFile() {
        return file;
    }
    public void setFile(File file) {
        this.file = file;
    }

    private InputStream inputStream;
    public InputStream getInputStream() {
        return inputStream;
    }

    public String getAllFormTemplate(){
        Collection<FormTemplate> ftList = this.formTemplateService.getFormTemplate();
        ActionContext.getContext().put("ftList",ftList);
        return listAction;
    }
    public String addUI(){
        Collection<ProcessDefinition> pdList = this.pdManager.getLasterVersions();
        ActionContext.getContext().put("pdList",pdList);
        return addUI;
    }
    public String add(){
        FormTemplate formTemplate = new FormTemplate();
        BeanUtils.copyProperties(this.getModel(),formTemplate);
        this.formTemplateService.saveFormTemplate(formTemplate,file);
        return action2action;
    }
    public String downLoad() throws FileNotFoundException, UnsupportedEncodingException {
        this.inputStream = this.formTemplateService.downLoad(this.getModel().getFtid());
        return SUCCESS;
    }

}
