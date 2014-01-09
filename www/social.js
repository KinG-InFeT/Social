/* 
 *
 *
 *
 */

var exec = require('cordova/exec');

module.exports = {

    StartShare: function(subject, text) {
		var options = { "subject": subject, "text": text};
        exec( null, null, 'Social', 'startshare', [options]);
    },
};