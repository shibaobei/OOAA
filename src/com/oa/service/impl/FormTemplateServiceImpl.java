package com.oa.service.impl;

import com.oa.dao.FormTemplateDao;
import com.oa.entity.FormTemplate;
import com.oa.service.FormTemplateService;
import com.oa.utils.UploadUtils;
import com.opensymphony.xwork2.ActionContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.*;
import java.net.URLEncoder;
import java.util.Collection;

/**
 * Created by Administrator on 2017-10-24.
 */
@Service("formTemplateService")
public class FormTemplateServiceImpl implements FormTemplateService{
    @Resource(name = "formTemplateDao")
    private FormTemplateDao formTemplateDao;

    @Override
    public Collection<FormTemplate> getFormTemplate() {
        return this.formTemplateDao.getAllEntity();
    }

    @Override
    @Transactional(readOnly = false)
    public void saveFormTemplate(FormTemplate formTemplate, File file) {
        /**
         * 文件上传
         * 保存到formtemplate表中
         */
        String url = UploadUtils.saveUploadFile(file);
        formTemplate.setUrl(url);
        this.formTemplateDao.saveEntity(formTemplate);
    }

    @Override
    public InputStream downLoad(Long ftid) throws FileNotFoundException, UnsupportedEncodingException {
       FormTemplate formTemplate = (FormTemplate) this.formTemplateDao.getEntityById(ftid);
       String fileName = URLEncoder.encode(formTemplate.getName(),"utf-8");
        ActionContext.getContext().put("fileName",fileName);
       return new FileInputStream(new File(formTemplate.getUrl())) ;
    }
}
