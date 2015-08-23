Ext.define('Jzz.controller.Main', {
    extend: 'Ext.app.Controller',
    views: ['main.Footer', 'main.Online', 'main.Header', 'main.Menu', 'main.Content'],
    models: ['Menu'],
    stores: ['Menu'],

    init: function() {
        this.control({
            '#westPanel': {
                render: this.initMenu
            }});
        this.control({
            '#mainContent': {
                render: this.initMainTabs
            }});
    },
    
    initMainTabs: function() {
        var mainContent = Ext.getCmp('mainContent');
        mainTabs = Ext.create('Ext.tab.Panel',{
	        region:'center', 
	        activeTab:0,
	        id:'mainTabs',
	        enableTabScroll:true,
	        layout: 'fit',
	        border:false,
	        items:[]
        });
     
     //<img src="' + rootPath + '/resources/images/pages/user.png" style="display:inline"/>
        var title1 = '我的工作台';
     
        jZzMsAddTab('myDeskMainTab', title1, 'User', 'test', false);
     
     //var title2 = '在线用户';
     //jZzMsAddTab('onlineMainTab', mainTabs, title2, '/online.jsp', true, 'lock', '<img src="' + rootPath + '/resources/images/pages/user.png"/>', 'JZZMS -> 在线用户');
     
       mainContent.add(mainTabs);
    },

    initMenu: function() {
        var menuPanel = Ext.getCmp('westPanel');
        var menuStore = Ext.create('Jzz.store.Menu');
        
        var p1 = Ext.create('Ext.tree.Panel', {
        title: '系统设置',
        store : menuStore,
        iconCls: 'settings',
        listeners : {
            itemclick : function(view, rec, item, index, e){
                jZzMsAddTab(rec.get('id'), rec.get('text'), rec.get('controller'), rec.get('action'), true);
            }
          }
       });
        menuPanel.add(p1);
    
        var p1 = Ext.create('Ext.panel.Panel', {
            title: '权根管理',
            html: '<p>Some settings in here.</p>',
            iconCls: 'nav'
        });
        menuPanel.add(p1);
    
        var p1 = Ext.create('Ext.panel.Panel', {
            title: '流程管理',
            html: '<p>Some settings in here.</p>',
            iconCls: 'info'
        });
           menuPanel.add(p1);
        }
});