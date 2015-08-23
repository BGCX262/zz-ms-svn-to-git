// 错误提示
ShowErrorMsg = function(title, msg) {
    Ext.MessageBox.show({
                title : title,
                msg : msg,
                buttons : Ext.MessageBox.OK,
                icon : Ext.MessageBox.ERROR
            })
}
// 错误提示
ShowWarningMsg = function(title, msg) {
    Ext.MessageBox.show({
                title : title,
                msg : msg,
                buttons : Ext.MessageBox.OK,
                icon : Ext.MessageBox.WARNING
            })
}
// 普通提示
ShowInfoMsg = function(title, msg) {
    Ext.MessageBox.show({
                title : title,
                msg : msg,
                buttons : Ext.MessageBox.OK,
                icon : Ext.MessageBox.INFO
            })
}

// 删除
DoDelete = function(url, params, store) {
    Ext.MessageBox.confirm('操作确认', '确定要删除选择的项吗?', function(btn) {
        if (btn == 'yes') {
            Ext.Ajax.request({
                        url : url,
                        async : false,
                        params : params,
                        success : function(response) {
                            var result = Ext.JSON.decode(response.responseText);
                            if (Ext.isDefined(result)) {
                                store.load();
                            };

                        }
                    });
        }
    }, this);
}

// 获取grid当前选中行的数据(单行)
GetGridSelectedRowData = function(grid) {
    var selModel = grid.getSelectionModel();
    if (Ext.isDefined(selModel.getSelection()[0])){
        return selModel.getSelection()[0].data;
    }
    else {
        return null;
    }
}

// 返回枚举列
GetEnumCm = function(cmc) {
    var cm = cmc;
    var list;
    Ext.Ajax.request({
                url : cm.url,
                async : false,
                success : function(response) {
                    list = Ext.JSON.decode(response.responseText);
                }
            });
    var filterOptions = new Array();
    Ext.each(list, function(item) {
                filterOptions[filterOptions.length] = {
                    id : item.Value,
                    text : item.Key
                };
            })
    cm.filter = {
        type : 'list',
        options : filterOptions,
        phpMode : true
    }
    cm.renderer = function(v) {
        var rr;
        Ext.each(list, function(item) {
                    if (v == item.Value) {
                        rr = item.Key;
                    }
                })
        if (!rr)
            return "";
        return rr;
    };
    return cm
};
// 树结点全选子节点帮助类
ChildCheck = function(node, checked) {
    node.eachChild(function(child) {
                if (child.get('checked') != checked) {
                    child.set('checked', checked);
                    node.expand();
                    ChildCheck(child, checked);
                }
            });
};
// 树结点全选父节点帮助类
ParentCheck = function(node, checked) {
    if (checked) {
        node.parentNode.set('checked', true);
    } 
    else {
        var flag = false;
        node.parentNode.eachChild(function(child) {
                    if (child.get('checked') == true) {
                        flag = true;
                        return;
                    }
                }, this);
        node.parentNode.set('checked', flag);
    }
    if (node.get('depth') > 1) {
        ParentCheck(node.parentNode, checked);
    }
}

// 列的金额格式化
CnMoneyRenderer = function(s, n) {
    n = n > 0 && n <= 20 ? n : 2;
    s = parseFloat((s + "").replace(/[^\d\.-]/g, "")).toFixed(n) + "";
    var l = s.split(".")[0].split("").reverse(), r = s.split(".")[1];
    t = "";
    for (i = 0; i < l.length; i++) {
        t += l[i] + ((i + 1) % 3 == 0 && (i + 1) != l.length ? "," : "");
    }
    return t.split("").reverse().join("") + "." + r;

};


// 保存cookie
function SetCookie(name, value)// 两个参数，一个是cookie的名子，一个是值
{
    var Days = 3000; // 此 cookie 将被保存 30 天
    var exp = new Date(); // new Date("December 31, 9998");
    exp.setTime(exp.getTime() + Days * 24 * 60 * 60 * 1000);
    document.cookie = name + "=" + escape(value) + ";expires="
            + exp.toGMTString();
}
// 获取cookie
function getCookie(name)// 取cookies函数
{
    var arr = document.cookie
            .match(new RegExp("(^| )" + name + "=([^;]*)(;|$)"));
    if (arr != null)
        return unescape(arr[2]);
    return null;

}
// 移除cookie
function delCookie(name)// 删除cookie
{
    var exp = new Date();
    exp.setTime(exp.getTime() - 1);
    var cval = getCookie(name);
    if (cval != null)
        document.cookie = name + "=" + cval + ";expires=" + exp.toGMTString();
}

//获取浏览器类型
function getBrowserName() {
    var name = '未知浏览器';
    if (Ext.isIE6)
        name = "IE6";
    if (Ext.isIE7)
        name = "IE7";
    if (Ext.isIE8)
        name = "IE8";
    if (Ext.isIE9)
        name = "IE9";
    if (Ext.isChrome)
        name = "Chrome";
    if (Ext.isOpera)
        name = "Opera";
    if (Ext.isSafari)
        name = "Safari";
    if (Ext.isGecko)
        name = "FireFox";
    return name;
};

/**
 * 显示请求等待进度条窗口
 * 
 * @param {}
 *            msg
 */
function showWaitMsg(msg) {
    Ext.MessageBox.show({
        title : '系统提示',
        msg : msg == null ? '正在处理数据,请稍候...' : msg,
        progressText : 'processing now,please wait...',
        width : 300,
        wait : true,
        waitConfig : {
            interval : 150
        }
    });
}

/**
 * 隐藏请求等待进度条窗口
 */
function hideWaitMsg() {
    Ext.MessageBox.hide();
}

//这个可以验证15位和18位的身份证，并且包含生日和校验位的验证。
function isIdCardNo(num) {
    if (Ext.isEmpty(num)){
        return false;
    }
    num = num.toUpperCase();
    // 身份证号码为15位或者18位，15位时全为数字，18位前17位为数字，最后一位是校验位，可能为数字或字符X。
    if (!(/(^\d{15}$)|(^\d{17}([0-9]|X)$)/.test(num))) {
        ShowWarningMsg('提示','输入的身份证号长度不对，或者号码不符合规定！\n15位号码应全为数字，18位号码末位可以为数字或X');
        return false;
    }
    // 校验位按照ISO 7064:1983.MOD 11-2的规定生成，X可以认为是数字10。
    // 下面分别分析出生日期和校验位
    var len, re;
    len = num.length;
    if (len == 15) {
        re = new RegExp(/^(\d{6})(\d{2})(\d{2})(\d{2})(\d{3})$/);
        var arrSplit = num.match(re);
        // 检查生日日期是否正确
        var dtmBirth = new Date('19' + arrSplit[2] + '/' + arrSplit[3] + '/' + arrSplit[4]);
        var bGoodDay;
        bGoodDay = (dtmBirth.getYear() == Number(arrSplit[2])) && 
            ((dtmBirth.getMonth() + 1) == Number(arrSplit[3])) && 
            (dtmBirth.getDate() == Number(arrSplit[4]));
        if (!bGoodDay) {
            ShowWarningMsg('提示', '输入的身份证号里出生日期不对！');
            return false;
        } 
        else {
            // 将15位身份证转成18位
            // 校验位按照ISO 7064:1983.MOD 11-2的规定生成，X可以认为是数字10。
            var arrInt = new Array(7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2);
            var arrCh = new Array('1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2');
            var nTemp = 0, i;
            num = num.substr(0, 6) + '19' + num.substr(6, num.length - 6);
            for (i = 0; i < 17; i++) {
                nTemp += num.substr(i, 1) * arrInt[i];
            }
            num += arrCh[nTemp % 11];
            return num;
        }
    }
    if (len == 18) {
        re = new RegExp(/^(\d{6})(\d{4})(\d{2})(\d{2})(\d{3})([0-9]|X)$/);
        var arrSplit = num.match(re);
        // 检查生日日期是否正确
        var dtmBirth = new Date(arrSplit[2] + "/" + arrSplit[3] + "/" + arrSplit[4]);
        var bGoodDay;
        bGoodDay = (dtmBirth.getFullYear() == Number(arrSplit[2]))
                && ((dtmBirth.getMonth() + 1) == Number(arrSplit[3]))
                && (dtmBirth.getDate() == Number(arrSplit[4]));
        if (!bGoodDay) {
            ShowWarningMsg('提示', '输入的身份证号里出生日期不对！');
            return false;
        } else {
            // 检验18位身份证的校验码是否正确。
            // 校验位按照ISO 7064:1983.MOD 11-2的规定生成，X可以认为是数字10。
            var valnum;
            var arrInt = new Array(7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2);
            var arrCh = new Array('1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2');
            var nTemp = 0, i;
            for (i = 0; i < 17; i++) {
                nTemp += num.substr(i, 1) * arrInt[i];
            }
            valnum = arrCh[nTemp % 11];
            if (valnum != num.substr(17, 1)) {
                ShowWarningMsg('提示', '18位身份证的校验码不正确！应该为:' + valnum);
                return false;
            }
            return num;
        }
    }
    return false;
}

function initTheme(){
    if (getCookie('theme_def') != null) {
        if (getCookie('theme_def') == 'blue'){
            Ext.getCmp('btn_login_skin').toggle(true, false);
            Ext.util.CSS.swapStyleSheet('theme','resources/css/ext-all.css');
        }
        else{
            Ext.util.CSS.swapStyleSheet('theme','resources/css/ext-all-gray.css');
        }
    }
}


function jZzMsAddTab(id, title, controller, action, closable){
    var tabs = Ext.getCmp('mainTabs');
    if(id == '' || id == null){
        ShowWarningMsg('提示', '数据不正确');
        return;
    }
    id = 'function_' + id;
    var tab = Ext.getCmp(id);
    if(tab){
        tabs.setActiveTab(tab);
        return;
    }
    action = action || 'execute';
    
    controller = JzzApp.getController(controller);
    if(!controller){
        ShowWarningMsg('提示', '此菜单还没有指定请求地址,无法为您打开页面');
        return;
    }
    tabs.add({
        id: id,
        title: title,
        closable: closable,
        layout:'fit',
        listeners : {
            activate : function(contentObj, eventObj) {
            //var mainContent = Ext.getCmp('mainContent');
            //mainContent.setTitle( '|-JZZMS -> ' + contentObj.title) ;
            }
        }
        
    }).show();
   
   controller[action].apply(controller, arguments);
}