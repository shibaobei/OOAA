package com.oa.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 这里封装一些共用的内容
 * @author Administrator
 *
 */
public class BaseAction extends ActionSupport{
	public static final String LISTACTION = "listAction";  
	public static final String ADDUI = "addUI";
	public static final String UPDATEUI = "updateUI";
	public static final String ACTION2ACTION = "action2action";
	public String listAction = LISTACTION;
	public String updateUI = UPDATEUI;
	public String addUI = ADDUI;
	public String action2action = ACTION2ACTION;
}
