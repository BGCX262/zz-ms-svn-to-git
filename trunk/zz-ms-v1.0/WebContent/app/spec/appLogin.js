//系统登录
Ext.QuickTips.init();
//Ext.form.Field.prototype.msgTarget = 'side';
Ext.form.Field.prototype.msgTarget = 'qtip';
Ext.define('MyApp.view.MyWindow', {
    extend: 'Ext.window.Window',

    width : 480,
	height : 410,
    closable: false,
    iconCls: 'lock',
    title: 'JZZMS &reg - 登录系统',
    resizable : false,
    initComponent: function() {
        var me = this;
        Ext.applyIf(me, {
            items: [
                {
                    xtype: 'panel',
                    height: 70,
                    html: '<img border="0" width="480" height="70" src="'+ rootPath + '/resources/images/login/login-logo.png" />'
                },
                {
                	id: 'extLoginTabs',
                    xtype: 'tabpanel',
                    height: 220,
                    activeTab: 0,
                    items: [
                    		me.createLoginForm()
                    	,
                    	{
                            xtype: 'panel',
                            title: '提示信息',
                            contentEl: 'login-info'
                        },
                        {
                            xtype: 'panel',
                            title: '关于系统',
                            contentEl: 'login-about'
                        }
                    ]
                },
                {
                	xtype : 'toolbar',
    				dock : 'bottom',
    				ui : 'footer',
    				height : 50,
    				layout : {
    					pack : 'center'
    				},
    				items : [
    					{
    						id : 'btnOnLogin',
    						text : '登 录',
    						handler : me.onLogin,
    						scale : 'medium',
    						width : 100,
    						height : 30,
    						icon : rootPath + '/resources/images/icons/24Icons/gnome-keyring-manager.png',
    						scope : me
    					},
    					{
    						text : '重 置',
    						handler : me.onReset,
    						scale : 'medium',
    						width : 100,
    						height : 30,
    						icon : rootPath + '/resources/images/icons/24Icons/new-view-refresh.png',
    						scope : me
    					} 
    				]
                }
            ],
            dockedItems: [
                {
                    xtype: 'toolbar',
                    dock: 'bottom',
                    items : [
     						'->',
     						{
     							text : '皮肤',
     							id : 'btn_login_skin',
     							icon : rootPath + '/resources/images/icons/16Icons/163.png',
     							tooltip: '切换皮肤',
     							enableToggle : true,
     							height : 30,
     							toggleHandler : function(btn, state) {
     								if (state) {
     									btn.setIcon(rootPath + '/resources/images/icons/16Icons/157.png');
     									SetCookie('theme_def', 'blue');
     									Ext.util.CSS.swapStyleSheet('theme',rootPath + '/resources/css/ext-all.css');
     								} 
     								else {
     									btn.setIcon(rootPath + '/resources/images/icons/16Icons/163.png');
     									SetCookie('theme_def', 'gray');
     									Ext.util.CSS.swapStyleSheet('theme',rootPath + '/resources/css/ext-all-gray.css');
     								}
     							}
     						},
     						'-',
     						{
     							text : '记住我',
     							id : 'btn_login_rememberme',
     							icon : rootPath + '/resources/images/icons/16Icons/emoticon_smile.png',
     							tooltip: '为了安全，请勿在公共电脑上使用此功能',
     							enableToggle : true,
     							height : 30
     						},
     						'-',
     						{
     							text : '使用Chrome™(Google)浏览器运行本系统',
     							cls : "x-btn-text-icon",
     							height : 30,
     							icon : rootPath + '/resources/images/login/google-chrome.png',
     							tooltip : '本系统在Chrome™(Google)浏览器下运行,速度是普通浏览器的3倍以上',
     							handler : function() {
     								var googleWin = Ext
     										.create(
     												'Ext.window.Window',
     												{
     													title : 'Google浏览器安装',
     													width : 850,
     													height : 450,
     													closable : true,
     													html : "<iframe src='http://www.google.com' style='width:100%; height:100%;'></iframe>"
     												});
     								googleWin.show();
     							}
     						}, '-', getBrowserName() 
     					]
                }
            ]
        });

        me.callParent(arguments);
    },
    createLoginForm : function(){
    	return Ext.create('Ext.form.Panel', {
    	    extend: 'Ext.form.Panel',
    	    id : 'extLoginForm',
    	    xtype: 'form',
    	    border : false,
    	    bodyStyle : 'padding: 20px 80px',
    	    baseCls : 'x-plain',
    	    labelWidth : 100,
    	    labelSeparator : '：',
    	    title: '用户登录',
    	    height : 200,
    	    defaultType : 'textfield',
    	    items : [{
    	    		id : 'txtCompanyId',
					xtype : 'textfield',
					fieldLabel : '企业代号 ',
					name : 'j_comname',
					blankText : '企业代号不能为空',
					allowBlank : false,
					cls : 'company',
					listeners : {
						specialkey : function(field, e) {
							if (e.getKey() == Ext.EventObject.ENTER) {
								Ext.getCmp('txtLoginName').focus();
							}
						}
					}
				},
				{
					id : 'txtLoginName',
					xtype : 'textfield',
					fieldLabel : '登录名 ',
					name : 'j_username',
					blankText : '登录名不能为空',
					allowBlank : false,
					cls : 'username',
					listeners : {
						specialkey : function(field, e) {
							if (e.getKey() == Ext.EventObject.ENTER) {
								Ext.getCmp('txtPwd').focus();
							}
						}
					}
				}, 
				{
					id : 'txtPwd',
					xtype : 'textfield',
					inputType : 'password',
					name : 'j_password',
					fieldLabel : '密码 ',
					blankText : '密码不能为空',
					allowBlank : false,
					cls : 'password',
					listeners : {
						specialkey : function(field, e) {
							if (e.getKey() == Ext.EventObject.ENTER) {
								Ext.getCmp('txtUiType').focus();
							}
						}
					}
				}, 
				{
					id : 'txtUiType',
					xtype : 'combo',
					fieldLabel : '界面模式 ',
					store : {
						fields : [ {
							type : 'string',
							name : 'text'
						}, {
							type : 'string',
							name : 'value'
						} ],
						data : [ {
							text : '经典菜单',
							value : '1'
						}, {
							text : '酷炫桌面',
							value : '0'
						}
						]
					},
					valueField : 'value',
					displayField : 'text',
					queryMode : 'local',
					typeAhead : true,
					value : '0',
					editable : false,
					cls : 'appstyle',
					listeners : {
						specialkey : function(field, e) {
							if (e.getKey() == Ext.EventObject.ENTER) {
								Ext.getCmp('txtValidateName').focus();
							}
						}
					}
				},
				{
					id : 'txtValidateName',
					xtype : 'textfield',
					fieldLabel : '验证码 ',
					name : 'validateName',
					blankText : '验证码不能为空',
					allowBlank : false,
					cls : 'verifycode',
					listeners : {
						specialkey : function(field, e) {
							if (e.getKey() == Ext.EventObject.ENTER) {
								Ext.getCmp('btnOnLogin').focus();
							}
						}
					}
				},
				{
					xtype : 'container',
					id : 'codeContainer',
					layout : 'table',
					defaultType : 'textfield',
					hideLabel : false,
					layoutConfig : {
						columns : 3
					},
					items: [{
							width : '100',
							xtype : 'label',
							text : '  '
						}, 
						{
							width : 200,
							id : 'loginCode',
							xtype : 'panel',
							border : false,
							bodyStyle : 'padding-left:103px',
							html : '<img border="0" height="30" width="80" src="' + rootPath + '/scaptcha/?' + Math.random() + '"/>'
						}, 
						{
							xtype : 'panel',
							border : false,
							bodyStyle : 'font-size:12px',
							html : '<a href="javascript:refeshCode()">看不清</a>'
						}
					]
				}       
	         ]
    	});
    },
    onLogin: function(){
    	var me = Ext.getCmp('extLoginForm');
		var mask = new Ext.LoadMask(me, {
			msg : '登录验证中...',
			removeMask : true
		});
		if (me.form.isValid()) {
			mask.show();
			// 记住用户名密码
			if (Ext.getCmp('btn_login_rememberme').pressed) {
				SetCookie('txtCompanyId', Ext.getCmp('txtCompanyId').getValue());
				SetCookie('txtLoginName', Ext.getCmp('txtLoginName').getValue());
				SetCookie('txtPwd', Ext.getCmp('txtPwd').getValue());
				SetCookie('txtUiType', Ext.getCmp('txtUiType').getValue());
			} 
			else {
				delCookie('txtCompanyId');
				delCookie('txtLoginName');
				delCookie('txtPwd');
				delCookie('txtUiType');
			}
			//做登录
			me.form.submit({
						url : rootPath + '/j_spring_security_check',
						success : function(form, action) {
							ShowInfoMsg('info','sucess');
							if (Ext.getCmp('txtUiType').getValue() == 1)
								window.location.href = rootPath + '/index.jsp';// 桌面
							else
								window.location.href = rootPath + '/index.jsp';// 经典菜单
						},
						failure : function(form, action) {
							ShowInfoMsg('info','failure');
							mask.hide();
						}
					});
		}
		else{
			Ext.getCmp('extLoginTabs').setActiveTab(0);
			ShowErrorMsg("错误","您的输入项不完整，无法完成登录！");
		}
    },
    onReset: function(){
    	ShowInfoMsg('info','rest');
    	var me = this;
		me.form.form.reset();
    }
});

Ext.onReady(function() {
	var win = new MyApp.view.MyWindow();
	win.show();
	
	// 默认焦点
	var f = Ext.getCmp('txtCompanyId').focus(false, 100);;
	// 皮肤
	initTheme();
	// 记住我
	if (getCookie('txtCompanyId') != null) {
		Ext.getCmp('btn_login_rememberme').toggle(true, false);
		Ext.getCmp('txtCompanyId').setValue(getCookie('txtCompanyId'));
		Ext.getCmp('txtLoginName').setValue(getCookie('txtLoginName'));
		Ext.getCmp('txtPwd').setValue(getCookie('txtPwd'));
		Ext.getCmp('txtUiType').setValue(getCookie('txtUiType'));
	}
});

function refeshCode() {
	var loginCode = Ext.getCmp('loginCode');
	loginCode.body.update('<img border="0" height="30" width="80" src="' + rootPath + '/scaptcha/?' + Math.random() + '"/>');
}