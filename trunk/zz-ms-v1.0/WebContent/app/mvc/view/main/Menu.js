Ext.define('Jzz.view.main.Menu', {
    extend: 'Ext.panel.Panel',
    alias : 'widget.mainMenu',
    region: 'west',
    stateId: 'navigation-panel',
    id: 'westPanel', 
    title: '菜单导航',
    split: true,
    width: 200,
    minWidth: 175,
    maxWidth: 400,
    collapsible: true,
    animCollapse: true,
    margins: '0 0 0 5',
    layout: 'accordion',
    
    
    
});