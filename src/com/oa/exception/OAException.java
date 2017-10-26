package com.oa.exception;

import org.apache.struts2.json.JSONResult;

import com.opensymphony.xwork2.ActionContext;

/**
 * 切面
 * @author Administrator
 *
 */
public class OAException {
	public void getExceptionMessage(Throwable ex){
		/**
		 * 把获取到的异常的信息放入到栈顶
		 */
		ActionContext.getContext().getValueStack().push(ex.getMessage());
	} 
}
