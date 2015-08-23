Ext.define('Jzz.view.user.List' ,{
    extend: 'Ext.grid.Panel',
    alias : 'widget.userlist',

    title : '用户管理',
    
    dockedItems: [{
                        xtype: 'toolbar',
                        items: [{
                            text: '增加信息',
                            iconCls: 'icon-add',
                            handler: function(){
                               
                            }
                        }, '-', {
                            itemId: 'delete',
                            text: '删除信息',
                            iconCls: 'icon-delete',
                            disabled: true,
                            handler: function(){
                               
                            }
                        }, '-' ,{
                            text:'刷新数据',
                            iconCls:'icon-refresh',
                            handler:function(){
                              
                            }
                        }]
                    }],
    bbar: Ext.create('Ext.PagingToolbar', {
                        //store: record.get('stores'),
                        displayInfo: true,
                        displayMsg: '显示 {0} - {1} 条，共计 {2} 条',
                        emptyMsg: "没有数据"
                    }),
    initComponent: function() {
        this.store = {
            fields: ['name', 'email'],
            data  : [
                {name: 'Ed',    email: 'ed@sencha.com'},
                {name: 'Tommy', email: 'tommy@sencha.com'}
            ]
        };

        this.columns = [
            {header: '用户名',  dataIndex: 'name',  flex: 1},
            {header: '邮箱', dataIndex: 'email', flex: 1}
        ];
        
        

        this.callParent(arguments);
    }
});