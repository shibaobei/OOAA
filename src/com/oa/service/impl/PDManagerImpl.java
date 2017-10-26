package com.oa.service.impl;

import com.oa.service.PDManager;

import org.jbpm.api.ProcessDefinition;
import org.jbpm.api.ProcessDefinitionQuery;
import org.jbpm.api.ProcessEngine;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipInputStream;

/**
 * Created by Administrator on 2017-10-23.
 */
@Service("pDManager")
public class PDManagerImpl implements PDManager{
    @Resource(name="processEngine")
    private ProcessEngine processEngine;
    @Override
    public Collection<ProcessDefinition> getLasterVersions() {
        List<ProcessDefinition> pdList = this.processEngine.getRepositoryService()
                .createProcessDefinitionQuery()
                .orderAsc(ProcessDefinitionQuery.PROPERTY_VERSION)
                .list();
        Map<String,ProcessDefinition> maps = new HashMap<String,ProcessDefinition>();
        for(ProcessDefinition pd:pdList){
            maps.put(pd.getKey(),pd);
        }
        return maps.values();
    }

    @Override
    public void deploy(File file) throws FileNotFoundException {
        InputStream inputStream = new FileInputStream(file);
        ZipInputStream zipInputStream = new ZipInputStream(inputStream);
        this.processEngine.getRepositoryService()
                .createDeployment()
                .addResourcesFromZipInputStream(zipInputStream)
                .deploy();
    }

    @Override
    public void deletePDKEY(String pdKEY) {
        List<ProcessDefinition> pdList = this.processEngine.getRepositoryService()
                .createProcessDefinitionQuery()
                .processDefinitionKey(pdKEY)
                .list();
        for(ProcessDefinition processDefinition:pdList){
            this.processEngine.getRepositoryService()
                    .deleteDeploymentCascade(processDefinition.getDeploymentId());
        }
    }
    public InputStream showImage(String deploymentId) {
        ProcessDefinition pd = this.processEngine.getRepositoryService()
                .createProcessDefinitionQuery()
                .deploymentId(deploymentId)
                .uniqueResult();
        return this.processEngine.getRepositoryService()
                .getResourceAsStream(deploymentId, pd.getImageResourceName());
    }
}
