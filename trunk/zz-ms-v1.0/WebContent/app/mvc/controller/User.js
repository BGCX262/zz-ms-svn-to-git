Ext.define('Jzz.controller.User', {
    extend: 'Ext.app.Controller',
    
     views: ['user.List'],
   
   test: function(id) {
       var workspacePanel = Ext.getCmp(id);
       var userView = Ext.createByAlias('widget.userlist');
       workspacePanel.add(userView);
   },
   
   init: function() {
   }
});