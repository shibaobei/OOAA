package com.oa.result;

import javax.servlet.http.HttpServletResponse;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.Result;
import org.apache.struts2.ServletActionContext;

/**
 * Created by Administrator on 2017-10-15.
 */
public class AjaxResult implements Result{
    @Override
    public void execute(ActionInvocation actionInvocation) throws Exception {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("utf-8");
        String message = ActionContext.getContext().getValueStack().peek().toString();
        response.getWriter().print(message);
    }
}
