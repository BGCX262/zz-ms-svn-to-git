Ext.define('Jzz.store.Menu', {
    extend: 'Ext.data.TreeStore',
    model : 'Jzz.model.Menu',
    proxy: {
        type: 'memory',
        data : [{
            text : '组织架构管理',
            leaf: true,
            controller : 'User',
            action: 'test',
            id: '1',
        },{
            text : '用户管理',
            leaf: true,
            controller : 'User',
            action: 'test',
            id: '2',
        }]
    },
    root: {
        text: '系统设置',
        controller : 'User',
        action: 'test',
        leaf: false,
        expanded: true,
        id: '1',
    },
    listeners:{
        expand : function(node){
           
            //切换内容页面
            //alert(1);
            //changePage(node.get('url'), node.get('text'));
        }
    }
});