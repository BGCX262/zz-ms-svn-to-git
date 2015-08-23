Ext.define('Jzz.model.Menu', {
    extend: 'Ext.data.Model',
    fields: [
        { name: 'id', type: 'int'},
        { name: 'text', type: 'string'},
        { name: 'controller', type: 'string'},
        { name: 'action', type: 'string'},
    ]
});