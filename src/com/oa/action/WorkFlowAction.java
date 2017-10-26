package com.oa.action;

import com.oa.entity.*;
import com.oa.service.FormTemplateService;
import com.oa.service.WorkFlowService;
import com.oa.utils.StringUtil;
import com.opensymphony.xwork2.ActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.swing.text.TabableView;
import java.io.File;
import java.util.Collection;
import java.util.Date;

/**
 * Created by Administrator on 2017-10-25.
 */
@Controller("workFlowAction")
@Scope("prototype")
public class WorkFlowAction extends BaseAction<Form>{
    @Resource(name="formTemplateService")
     private FormTemplateService formTemplateService;
    @Resource(name = "workFlowService")
     private WorkFlowService workFlowService;

    private Long ftid;
    private Long taskId;
    private File resource;
    public Long getFtid() {
        return ftid;
    }
    public void setFtid(Long ftid) {
        this.ftid = ftid;
    }
    public File getResource() {
        return resource;
    }
    public void setResource(File resource) {
        this.resource = resource;
    }
    public Long getTaskId() {
        return taskId;
    }
    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    private String comment;
    private String isApprove;
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
    public String getIsApprove() {
        return isApprove;
    }
    public void setIsApprove(String isApprove) {
        this.isApprove = isApprove;
    }

    public String getAllFormTemplate(){
        Collection<FormTemplate> ftList = this.formTemplateService.getFormTemplate();
        ActionContext.getContext().put("ftList",ftList);
        return "workFlow_formTemplateList";
    }

    public String submitUI(){
        return "submitUI";
    }
    public String submit(){
        this.workFlowService.submit(ftid,resource);
        return null;
    }
    public String MyTaskList(){
        Collection<TaskView> tabableViewList = this.workFlowService.getAllFormByAssignee();
        ActionContext.getContext().put("tabableViewList",tabableViewList);
        return "myTaskList";
    }
    public String approveUI(){
        return "approveUI";
    }
    public String approve(){
        Approve approve = new Approve();
        approve.setComment(this.comment);
        approve.setIsapprove(this.isApprove);
        Form form = this.workFlowService.getFormById(this.getModel().getFid());
        approve.setForm(form);
        User user = StringUtil.fromSession();
        approve.setApprovename(user.getUsername());
        approve.setApprovetime(new Date());
        this.workFlowService.approve(this.taskId.toString(),approve);
        return null;
    }
}
