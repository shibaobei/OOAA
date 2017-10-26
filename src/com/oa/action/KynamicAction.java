package com.oa.action;

import com.oa.entity.Kynamic;
import com.oa.entity.Version;
import com.oa.service.KynamicService;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.Collection;

/**
 * Created by Administrator on 2017-10-21.
 */
@Controller("kynamicAction")
@Scope("prototype")
public class KynamicAction extends BaseAction<Kynamic>{
    @Resource(name="kynamicService")
    private KynamicService kynamicService;
    private Kynamic kynamic;

    public Kynamic getKynamic() {
        return kynamic;
    }
    private String message;
    private Long kid;
    public Long getKid() {
        return kid;
    }
    public String getMessage() {
        return message;
    }
    private Collection<Kynamic> kynamicList;
    public Collection<Kynamic> getKynamicList() {
        return kynamicList;
    }
    private Collection<Version> versions;
    public Collection<Version> getVersions() {
        return versions;
    }

    public String showKynamicTree(){
        this.kynamicList = this.kynamicService.getAllKynamic();
        return SUCCESS;
    }
    public String isExsitName(){
        boolean flag = this.kynamicService.exsitName(this.getModel().getName());
        if(flag){
            this.message = "1";
        }else{
            this.message = "2";
        }
       return SUCCESS;
    }
    public String saveKynamic(){
        Kynamic kynamic = new Kynamic();
        BeanUtils.copyProperties(this.getModel(), kynamic);
        this.kynamicService.saveKynamic(kynamic);
        this.kid = kynamic.getKid();
        this.message = "操作成功";
        return SUCCESS;
    }
    public String deleteKynamic(){
        this.kynamicService.deleteKynamicById(this.getModel().getKid());
        this.message = "操作成功";
        return SUCCESS;
    }
    public String showSiblingNodes(){
        this.kynamicList = this.kynamicService.getSiblingsNodes(this.getModel().getKid());
        return SUCCESS;
    }

    public String showParentNode(){
        this.kynamic = this.kynamicService.getParentNode(this.getModel().getKid());
        return SUCCESS;
    }

    public String updateKynamic(){
        Kynamic kynamic = this.kynamicService.getKynamicById(this.getModel().getKid());
        kynamic.setName(this.getModel().getName());
        this.kynamicService.updateKynamic(kynamic);
        return SUCCESS;
    }

    public String showVersionsByKid(){
        this.versions = this.kynamicService.getVersionsByKid(this.getModel().getKid());
       return  SUCCESS;
    }
}
