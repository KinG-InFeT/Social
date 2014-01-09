/* 
 *
 *
 *
 */

module.exports = new Social();


var exec = require('cordova/exec');

module.exports = {

    Social: function(args) {
        exec( function(args) {
			success(args);
		}, function(args) {
			error(args);
		}, 'Social', '', [args]);
    },
};