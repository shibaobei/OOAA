package com.oa.action;

import javax.annotation.Resource;

import com.oa.entity.User;
import com.oa.service.LoginService;
import com.oa.utils.StringUtil;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;



@Controller("loginAction")
@Scope("prototype")
public class LoginAction extends BaseAction<User>{
	@Resource(name="loginService")
	private LoginService loginService;
	
	public String login(){
		User user = this.loginService.checkUAndP(this.getModel().getUsername(),this.getModel().getPassword());
		if(user!=null){//成功
			StringUtil.putUser2Session(user);
			return "index";
		}else{//失败
			//自己实现
			return null;
		}
	}
}
