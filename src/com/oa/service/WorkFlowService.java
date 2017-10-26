package com.oa.service;

import com.oa.entity.Approve;
import com.oa.entity.Form;
import com.oa.entity.TaskView;

import java.io.File;
import java.util.Collection;

/**
 * Created by Administrator on 2017-10-25.
 */
public interface WorkFlowService {
    public void submit(Long ftid,File file);
    public Collection<TaskView> getAllFormByAssignee();
    public void approve(String taskId, Approve approve);
    public Form getFormById(Long fid);
}
