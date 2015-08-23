Ext.define('Jzz.view.main.Online', {
    extend: 'Ext.panel.Panel',
    alias : 'widget.mainOnline',
    id: 'chatTabs',
    region: 'east',
    title: '在线交流',
    animCollapse: true,
    collapsible: true,
    collapsed: true,
    split: true,
    width: 180,
    minSize: 150,
    maxSize: 200,
    margins: '0 5 0 0',
    activeTab: 0,
    tabPosition: 'bottom',

    initComponent: function() {
        this.items = [
           
        ];

        this.buttons = [
        ];

        this.callParent(arguments);
    }
});