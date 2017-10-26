package com.oa.entity;

import org.jbpm.api.task.Task;

/**
 * Created by Administrator on 2017-10-26.
 */
public class TaskView {
    private Form form;
    private Task task;

    public Form getForm() {
        return form;
    }

    public void setForm(Form form) {
        this.form = form;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}
