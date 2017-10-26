package com.oa.service;

import org.jbpm.api.ProcessDefinition;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Collection;

/**
 * Created by Administrator on 2017-10-23.
 */
public interface PDManager {
    public Collection<ProcessDefinition> getLasterVersions();
    public void deploy(File file) throws FileNotFoundException;
    public  void deletePDKEY(String pdKEY);
    public InputStream showImage(String deploymentId);
}
