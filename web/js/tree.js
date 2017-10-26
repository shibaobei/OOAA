var tree = {
    zTree:'',
	pNode:'',
	setting:{
		isSimpleData: true,
		treeNodeKey: "mid",
		treeNodeParentKey: "pid",
		showLine: true,
		root:{ 
			isRoot:true,
			nodes:[]
		},
		callback:{
            /**
             * @param event鼠标事件
             * @param treeId树容器id
             * @param treeNode当前点击的节点
             */
			expand:function (event,treeId,treeNode) {
				tree.pNode = treeNode;
				tree.loadNodeByNode();
            }
		}
	},
	/**
	 * 1、回调函数是由服务器端触发的，什么时候执行由服务器决定
	 * 2、回调函数是由jQuery内核调用的
	 * 3、客户端存在两个线程
	 * 4、如果在js代码中，有一些代码要用到回调函数中的数据，那么这些代码必须放在回调函数中
	 */
	loadTree:function(){
		$.post("menuitemAction_getAllMenuitem.action",{},function(data){
			$("#tree").zTree(tree.setting,data.menuitems);
		});
	},
    /**
	 * 一般情况下，如果一段代码中要用到一个变量，而这个变量的值是在回调函数中赋值的，
	 * 这时一定要确保使用该函数时，回调函数已经执行了
     */
	loadRootNode:function () {
		var parameter = {
			pid:0
		};
        $.post("menuitemAction_showMenuitemsByPid.action",parameter,function(data){
            tree.zTree = $("#tree").zTree(tree.setting,data.menuitems);
        });
    },
    /**
	 * 该方法是在点击父节点前的+号时执行的，这意味着在执行该方法的时候，树早已经生成了，所以才能用tree.zTree
     */
	loadNodeByNode:function () {
        var parameter = {
            pid:tree.pNode.mid
        };
        if(!tree.zTree.getNodeByParam("pid",tree.pNode.mid)){
            $.post("menuitemAction_showMenuitemsByPid.action",parameter,function(data){
                /**
                 * 拔查询出来的子节点追加到父节点
                 */
                tree.zTree.addNodes(tree.pNode,data.menuitems,true);
            });
		}

    }
};
$().ready(function(){
	//tree.loadTree();
	tree.loadRootNode();
});

