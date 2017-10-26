package com.oa.service;

import com.oa.entity.FormTemplate;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Collection;

/**
 * Created by Administrator on 2017-10-24.
 */
public interface FormTemplateService {
    public Collection<FormTemplate> getFormTemplate();
    public void  saveFormTemplate(FormTemplate formTemplate, File file);
    public InputStream downLoad(Long ftid) throws FileNotFoundException, UnsupportedEncodingException;

}
