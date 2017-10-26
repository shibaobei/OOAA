var menu = {
	setting:{
		isSimpleData: true,
        treeNodeKey: "mid",
        treeNodeParentKey: "pid",
        showLine: true,
        root: {
            isRoot: true,
            nodes: []
        }
	},
	loadMenuTree:function(){
		$.post("menuitemAction_showMenuitemsByUser.action",null,function(data){
			$("#menuTree").zTree(menu.setting,data.menuitems);
		});
	}
};
$().ready(function(){
	menu.loadMenuTree();
});
