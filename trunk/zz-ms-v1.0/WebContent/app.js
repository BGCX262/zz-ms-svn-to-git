Ext.Loader.setConfig({
      enabled: true
  });
var JzzApp = null;
Ext.application({
    name: 'Jzz',
    appFolder: 'app/mvc',
    controllers: ['Main', 'User'],
    launch: function() {
        //Ext.require('Jzz.view.main.Footer');
        JzzApp = this;
        Ext.QuickTips.init();
        Ext.state.Manager.setProvider(Ext.create('Ext.state.CookieProvider'));
        var viewport = Ext.create('Ext.Viewport', {
            id: 'main-app',
            layout: 'border',
            items: [
                {
                   xtype: 'mainHeader'
                },
                //{
                //   xtype: 'mainFooter'
                //},
                //{
                //   xtype: 'mainOnline'
                //},
                {
                  xtype: 'mainMenu'
                },
                {
                   xtype: 'mainContent'
                }
            ]
        });
        
        
        
        //初始化头部按钮
        var mainMenu = Ext.create('Ext.menu.Menu', {
            id : 'mainMenu',
            items : [{
                text : '密码修改',
                iconCls : 'keyIcon',
                handler : function() {
                    //updateUserInit();
                    ShowInfoMsg('info', 'change password');
                }
            }, {
                text : '系统锁定',
                iconCls : 'lockIcon',
                handler : function() {
                    //lockWindow.show();
                    //setCookie("g4.lockflag", '1', 240);
                    ShowInfoMsg('info', 'lock system');
                }
            }]
        });
            
        //创建按钮
        Ext.create('Ext.Button', {
            text : '切换模块',
            iconCls : 'switch24Icon',
            iconAlign : 'left',
            scale : 'medium',
            width : 100,
            tooltip : '切换模块',
            pressed : true,
            renderTo : 'switchModuleDiv',
            menu : mainMenu
         });
         
        Ext.create('Ext.Button', {
            id: 'btn_login_skin',
            text : '皮肤',
            iconAlign : 'left',
            icon : 'resources/images/icons/16Icons/163.png',
            scale : 'medium',
            width : 60,
            tooltip : '更换皮肤',
            pressed : true,
            renderTo : 'themeDiv',
            enableToggle : true,
            toggleHandler : function(btn, state) {
                if (state) {
                    btn.setIcon('resources/images/icons/16Icons/157.png');
                    SetCookie('theme_def', 'blue');
                    Ext.util.CSS.swapStyleSheet('theme','resources/css/ext-all.css');
                } 
                else {
                    btn.setIcon('resources/images/icons/16Icons/163.png');
                    SetCookie('theme_def', 'gray');
                    Ext.util.CSS.swapStyleSheet('theme','resources/css/ext-all-gray.css');
                }
            }
         });
         Ext.create('Ext.Button', {
             text : '首选项',
             iconCls : 'config24Icon',
             iconAlign : 'left',
             scale : 'medium',
             width : 100,
             tooltip : '<span style="font-size:12px">首选项设置</span>',
             pressed : true,
             renderTo : 'configDiv',
             menu : mainMenu
         });
         Ext.create('Ext.Button', {
             iconCls : 'exit24Icon',
             iconAlign : 'left',
             scale : 'medium',
             text: '退出',
             width : 60,
             tooltip : '切换用户,安全退出系统',
             pressed : true,
             arrowAlign : 'right',
             renderTo : 'closeDiv',
             handler : function() {
                 window.location.href = 'j_spring_security_logout';
             }
        });
        //设置皮肤
        initTheme();
    }
});