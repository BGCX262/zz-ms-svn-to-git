//系统登录
Ext.QuickTips.init();
Ext.form.Field.prototype.msgTarget = 'side';

Ext.define('JZzMs.Login',
	{
		extend : 'Ext.window.Window',
		id : 'extLoginWin',
		title : '系统登录',
		width : 500,
		height : 400,
		resizable : false,
		draggable : true,
		layout : 'border',
		bodyStyle : 'padding:5px;',
		plain : false,
		closable : false,
		iconCls : 'lock',
		initComponent : function() {
			var me = this;
			me.logo = me.createLogo();
			me.form = me.createLoginPanel();
			me.items = [ me.logo, me.form];
			this.dockedItems = [
				{
					xtype : 'toolbar',
					dock : 'bottom',
					items : [
						'->',
						{
							text : '皮肤',
							id : 'btn_login_skin',
							icon : rootPath + '/resources/images/icons16Icons/163.png',
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
						}, '-', getBrowserName() ]
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
					} ]
			} ];
			me.callParent();
		},
		createLoginPanel:function(){
			var me = this;
			var loginTab = Ext.create('Ext.tab.Panel', {
		        activeTab: 0,
		        contentEl:'login-tabs',
		        defaults :{
		            bodyPadding: 10
		        },
		        items: [
		        {
		        	contentEl:'login-login',
		        	title:'登录'
		        },
		        {
		            contentEl:'login-info', 
		            title: '信息',
		        },{
		            contentEl:'login-about', 
		            title: '关于'
		        }]
		    });
		},
		createLogo : function() {
			return Ext.create('Ext.panel.Panel', {
				layout:'fit',
				contentEl:'login-logo'
			});
		},
		createForm : function() {
			var me = this;
			var form = new Ext.form.FormPanel({
				id : 'loginform',
				region : 'south',
				border : false,
				bodyStyle : 'padding: 20px 100px',
				baseCls : 'x-plain',
				defaults : {
					width : 280,
					labelWidth : 60,
					labelAlign : 'right'
				},
				height : 200,
				items : [ 
				{
					id : 'txtCompanyId',
					xtype : 'textfield',
					fieldLabel : '企业代号 ',
					name : 'j_comname',
					blankText : '企业代号不能为空',
					allowBlank : false
				},
				{
					id : 'txtLoginName',
					xtype : 'textfield',
					fieldLabel : '登录名 ',
					name : 'j_username',
					blankText : '登录名不能为空',
					allowBlank : false
				}, {
					id : 'txtPwd',
					xtype : 'textfield',
					inputType : 'password',
					name : 'j_password',
					fieldLabel : '密码 ',
					allowBlank : false
				}, {
					id : 'uiType',
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
						},
						]
					},
					valueField : 'value',
					displayField : 'text',
					queryMode : 'local',
					typeAhead : true,
					value : '0',
					editable : false
				},
				{
					id : 'txtValidateName',
					xtype : 'textfield',
					fieldLabel : '验证码 ',
					name : 'validateName',
					allowBlank : false
				},
				{
					xtype : 'container',
					id : 'codeContainer',
					layout : 'table',
					defaultType : 'textfield',
					hideLabel : false,
					layoutConfig : {
						columns : 3
					}
				}
				]
			});
			
			var items = [{
				width : 60,
				xtype : 'label',
				text : '　　　　'// 这里的排序以后再改
			}, {
				width : 150,
				id : 'loginCode',
				xtype : 'panel',
				border : false,
				bodyStyle : 'margin-left:10px',
				html : '<img border="0" height="30" width="140" src="/zzms/scaptcha/?' + Math.random() + '"/>'
			}, {
				width : 50,
				xtype : 'panel',
				border : false,
				bodyStyle : 'font-size:12px; padding-left:0px',
				html : '<a href="javascript:refeshCode()">看不清</a>'
			}];
			var codeContainer = Ext.getCmp('codeContainer');
			codeContainer.add(items);
			codeContainer.doLayout();
			
			return form;
		},
		onLogin : function() {
			var me = this;
			var mask = new Ext.LoadMask(me, {
				msg : '登录验证中...',
				removeMask : true
			});
			if (me.form.form.isValid()) {
				mask.show();
	
				// 记住用户名密码
				if (Ext.getCmp('btn_login_rememberme').pressed) {
					SetCookie('txtLoginName', Ext.getCmp(
							'txtLoginName').getValue());
					SetCookie('txtPwd', Ext.getCmp('txtPwd')
							.getValue());
					SetCookie('uiType', Ext.getCmp('uiType')
							.getValue());
				} else {
					delCookie('txtLoginName');
					delCookie('txtPwd');
					delCookie('uiType');
				}
	
				me.form.form.submit({
							url : rootPath + '/j_spring_security_check',
							success : function(form, action) {
								ShowInfoMsg('info','sucess');
								if (Ext.getCmp('uiType').getValue() == 1)
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
	
		},
		onReset : function() {
			var me = this;
			me.form.form.reset();
		}
	}
);

Ext.onReady(function() {
	var win = new JZzMs.Login();
	win.show();
	var el = Ext.get('extLoginWin');
	var map = new Ext.KeyMap(el, {
		key : Ext.EventObject.ENTER,
		fn : function() {
			win.onLogin();
		}
	});
	// 默认焦点
	var f = Ext.getCmp('txtLoginName');
	f.focus(false, 100);

	// 皮肤
	if (getCookie('theme_def') != null) {
		if (getCookie('theme_def') == 'blue')
			Ext.getCmp('btn_login_skin').toggle(true, false);
	}
	// 记住我
	if (getCookie('txtLoginName') != null) {
		Ext.getCmp('btn_login_rememberme').toggle(true, false);
		Ext.getCmp('txtLoginName').setValue(getCookie('txtLoginName'));
		Ext.getCmp('txtPwd').setValue(getCookie('txtPwd'));
		Ext.getCmp('uiType').setValue(getCookie('uiType'));
	}

});

function refeshCode() {
	var loginCode = Ext.getCmp('loginCode');
	loginCode.body.update('<img border="0" height="30" width="140" src="' + rootPath + '"/zzms/scaptcha/?' + Math.random() + '"/>');
}