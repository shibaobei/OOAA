package com.oa.action;

import com.oa.entity.Menuitem;
import com.oa.service.MenuitemService;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.Collection;

/**
 * Created by Administrator on 2017-10-17.
 */
@Controller("menuitemAction")
@Scope("prototype")
public class MenuitemAction extends BaseAction<Menuitem>{
    @Resource(name = "menuitemService")
    private MenuitemService menuitemService;
    private Collection<Menuitem> menuitems;

    public Collection<Menuitem> getMenuitems() {
        return menuitems;
    }

    @JSON(serialize = false)
    public String getAllMenuitem(){
        this.menuitems = this.menuitemService.getAllMenuitem();
        return SUCCESS;
    }
    public String showMenuitemsByPid(){
        this.menuitems = this.menuitemService.getMenuitemsByPid(this.getModel().getPid());
        return SUCCESS;
    }
    public String showMenuitemsByUser(){
        this.menuitems = this.menuitemService.getMenuitemsByUser();
        return SUCCESS;
    }
}
