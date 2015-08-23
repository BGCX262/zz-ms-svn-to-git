Ext.define('Demo.view.Computer', {
    statics: {
        instanceCount: 0,
        factory: function(brand) {
            // 'this' in static methods refer to the class itself
        	alert(1);
            return new this({brand: brand});
        }
    },

    config: {
        brand: null
    },

    constructor: function(config) {
        this.initConfig(config);

        // the 'self' property of an instance refers to its class
        this.self.instanceCount ++;

        return this;
    }
});