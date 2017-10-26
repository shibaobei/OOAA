/**
 * Created by Administrator on 2017-10-17.
 */
var privilege = {
    /**
     * 所有的初始化的操作
      */
    init:{
        initEvent:function () { //所有的初始化事件
            //设置权限的click事件
            $("a").each(function () {
               if($(this).text()=="设置权限"){
                   $(this).unbind("click");
                   $(this).bind("click",function () {
                       // var hobj = this;
                       // privilege.init.initData(hobj);//初始化数据
                       privilege.init.initData.call(this);//初始化数据
                       privilege.pFunction.divOption.showDiv();//显示所有的div
                       privilege.pFunction.userOption.setUsername();//动态显示用户名
                       privilege.pFunction.privilegeTree.loadPrivilegeTree();//加载权限树
                       return false;
                   });
               }
            });
            //全选按钮的事件
            $("#allchecked").unbind("click");
            $("#allchecked").bind("click",function () {
                privilege.pFunction.privilegeTree.checkAll.call(this);
            });
            //保存权限的事件
            $("#savePrivilege").unbind("click");
            $("#savePrivilege").bind("click",function(){
                privilege.pFunction.privilegeTree.savePrivilge();
            });
        },
        initData:function () { //初始化数据
            // $(obj).parent().siblings("td:first").text();
            // $(obj).parent().siblings("input[type='hidden']:first").val();
            privilege.data.user.username = $(this).parent().siblings("td:first").text();
            privilege.data.user.uid = $(this).parent().siblings("input[type='hidden']:first").val();

        }
    },
    /**
     * 按照功能划分区域
     */
    pFunction:{
        privilegeTree:{//所有的权限树的功能
            zTree:'',
            setting:{//树的配置
                isSimpleData: true,
                treeNodeKey: "mid",
                treeNodeParentKey: "pid",
                showLine: true,
                root:{
                    isRoot:true,
                    nodes:[]
                },
                checkable:true,
                checkType:{
                    "Y":"p",
                    "N":"s"
                },
                callback:{
                    //再点击树上的复选框之前触发该方法
                    beforeChange:function (treeId,treeNode) {
                        privilege.pFunction.privilegeTree.controlCheckBox({
                            "Y":"p",
                            "N":"s"
                        });
                    },
                    change:function (treeId,treeNode) {
                        if(privilege.pFunction.privilegeTree.zTree.getCheckedNodes(false).length!=0){
                            $("#allchecked").attr("checked",false);
                        }else{
                            $("#allchecked").attr("checked",true);
                        }
                    }
                }
            },
            loadPrivilegeTree:function () {//显示权限树
                var parameter = {
                    uid:privilege.data.user.uid
                };
                $.post("privilegeAction_showPrivilege.action",parameter,function (data) {
                    privilege.pFunction.privilegeTree.zTree = $("#privilegeTree").zTree(privilege.pFunction.privilegeTree.setting,data.privileges)
                    //设置全选按钮默认状态
                    if(privilege.pFunction.privilegeTree.zTree.getCheckedNodes(false).length!=0){
                        $("#allchecked").attr("checked",false);
                    }else{
                        $("#allchecked").attr("checked",true);
                    }
                });
            },
            controlCheckBox:function (checkType) { //对权限复选框的控制
                var setting = privilege.pFunction.privilegeTree.zTree.getSetting();
                setting.checkType = checkType;
                privilege.pFunction.privilegeTree.zTree.updateSetting(setting);
            },
            savePrivilge:function () { //针对某一用户保存权限
                var checkedNodes = privilege.pFunction.privilegeTree.zTree.getCheckedNodes(true);
                var mids = "";
                for(var i=0;i<checkedNodes.length;i++){
                    if(i<checkedNodes.length-1){
                        mids = mids+checkedNodes[i].mid+",";
                    }else{
                        mids = mids+checkedNodes[i].mid;
                    }

                }
                var parameter = {
                    uid:privilege.data.user.uid,
                    mids:mids,
                   // checkedNodes:$.toJSON(checkedNodes)
                };
                 $.post("privilegeAction_savePrivilege.action",parameter,function (data) {

                 })
            },

            checkAll:function () { //全选复选框的控制
                /**
                 * 改变树上的复选框的选择规则,树已经存在了
                 */
                privilege.pFunction.privilegeTree.controlCheckBox({
                    "Y":"ps",
                    "N":"ps"
                });
                 if($(this).attr("checked")){
                     privilege.pFunction.privilegeTree.zTree.checkAllNodes(true);
                 }else{
                     privilege.pFunction.privilegeTree.zTree.checkAllNodes(false);
                 }
            }
        },
        userOption:{ //存放用户的操作
             setUsername:function () {//把用户名动态地显示在div中
                 $("#username").text(privilege.data.user.username);
             }
        },
        divOption:{//显示div操作
            showDiv:function () {
                $("#userTitle").show();
                $("#privilegeTitle").show();
                $("#privilegeContent").show();
            }
        }
    },
    /**
     * json对象对数据的封装
     */
    data:{
        user:{//存放用户的数据
            uid:'',
            username:''

        }
    }
};
$().ready(function(){
    privilege.init.initEvent();
});
