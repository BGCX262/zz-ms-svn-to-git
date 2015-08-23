Ext.define('Demo.view.Person', {
    name: 'Unknown',

    constructor: function(name) {
        if (name) {
            this.name = name;
        }

        return this;
    },

    eat: function(foodType) {
        alert(this.name + " is eating: " + foodType);

        return this;
    }
});



