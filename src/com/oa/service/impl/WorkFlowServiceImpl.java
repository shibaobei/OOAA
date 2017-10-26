package com.oa.service.impl;

import com.oa.dao.FormTemplateDao;
import com.oa.dao.WorkFlowDao;
import com.oa.entity.*;
import com.oa.service.WorkFlowService;
import com.oa.utils.StringUtil;
import com.oa.utils.UploadUtils;
import org.jbpm.api.ProcessEngine;
import org.jbpm.api.ProcessInstance;
import org.jbpm.api.task.Task;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.File;
import java.util.*;

/**
 * Created by Administrator on 2017-10-25.
 */
@Service("workFlowService")
public class WorkFlowServiceImpl implements WorkFlowService{
    @Resource(name="workFlowDao")
    private WorkFlowDao workFlowDao;
    @Resource(name="formTemplateDao")
    private FormTemplateDao formTemplateDao;
    @Resource(name = "processEngine")
    private ProcessEngine processEngine;

    @Override
    @Transactional(readOnly = false)
    public void submit(Long ftid, File file) {
        /**
         *  *  上传表单
         *     往form表中插入一行数据
               applicatetime  当前时间
               applicator   就是登入系统的人
               state        审批中
               url          上传表单以后可以生成该值
               ftid         表单模板ID(在页面上应该用隐藏域)
         *     jbpm
         *  启动流程实例
         根据pdkey启动流程实例，因为页面上传递到后台的参数只有pdkey
         把form作为流程变量，保存到流程实例中
         *  完成请假申请的任务
         completeTask(String taskId);
         */
         //文件上传
        String  url = UploadUtils.saveUploadFile(file);
        //从session中获取user
        User user = StringUtil.fromSession();
        //往表中插入一条数据
        Form form = new Form();
        form.setApplicatetime(new Date());
        form.setApplicator(user.getUsername());
        form.setState("申请中");
        form.setUrl(url);
        //把formTemplate提取出来
        FormTemplate formTemplate = (FormTemplate) this.formTemplateDao.getEntityById(ftid);
        //建立form与formTemplate之间的联系
        form.setFormTemplate(formTemplate);
        String title = formTemplate.getName()+"_"+user.getUsername()+"_"+new Date();
        form.setTitle(title);
        this.workFlowDao.saveEntity(form);
     /**************************************************************************/
        /**
         *jbpm的事情
         */
        //启动流程实例
        Map<String,Form> variables = new HashMap<String,Form>();
        variables.put("form",form);
        ProcessInstance pi = this.processEngine.getExecutionService()
                .startProcessInstanceByKey(formTemplate.getProcessKey(),variables);
        //根据当前正在执行的实例获取正在执行的任务
        Task task = this.processEngine.getTaskService()
                .createTaskQuery()
                .executionId(pi.getId()).uniqueResult();
        //完成请假申请的任务
        this.processEngine.getTaskService()
                .completeTask(task.getId());
    }

    @Override
    public Collection<TaskView> getAllFormByAssignee() {
        /**
         * 1、根据登录人查询当前执行的所有的任务
         * 2、遍历所有的任务，得到executionId
         * 3、通过executionId和"form"的值把流程变量form提取出来
         * 4、form和task共同组成taskView
         */
        User user = StringUtil.fromSession();
        List<Task> taskList = this.processEngine.getTaskService()
                .createTaskQuery()
                .assignee(user.getUsername())
                .list();
        List<TaskView> taskViewList = new ArrayList<TaskView>();
        for(Task task:taskList){
            TaskView taskView = new TaskView();
            Form form = (Form) this.processEngine.getExecutionService()
                    .getVariable(task.getExecutionId(),"form");
            taskView.setForm(form);
            taskView.setTask(task);
            taskViewList.add(taskView);
        }
        return taskViewList;
    }

    @Override
    @Transactional(readOnly=false)
    public void approve(String taskId, Approve approve) {
        /**
         * 1、插入一行数据到approve中
         * 2、如果页面点击的是不同意
         *      则流程实例直接结束
         *      把相应的form表中的状态变成"未通过"
         *   如果页面点击的是同意
         *      *  完成任务
         *      *  判断该流程实例是否结束
         *          如果结束，把相应的form表的状态变成"已完成"
         */
        Task task = this.processEngine.getTaskService()
                .getTask(taskId);
        if("不同意".equals(approve.getIsapprove())){
            this.processEngine.getExecutionService()
                    .endProcessInstance(task.getExecutionId(), "ended");
            approve.getForm().setState("未通过");
        }else{
            //完成任务
            this.processEngine.getTaskService()
                    .completeTask(taskId);
            //得到流程实例
            ProcessInstance pi = this.processEngine.getExecutionService()
                    .createProcessInstanceQuery()
                    .processInstanceId(task.getExecutionId())
                    .uniqueResult();
            if(pi==null){//该流程实例已经结束了
                approve.getForm().setState("已通过");
            }
        }
        this.workFlowDao.saveEntity(approve);


    }
    public Form getFormById(Long fid) {
        return (Form)this.workFlowDao.getEntityById(fid);
    }
}
