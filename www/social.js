/* 
 *
 *
 *
 */

module.exports = new Social();


var exec = require('cordova/exec');

module.exports = {

    StartShare: function(subject, text) {
        exec( null, null, 'Social', 'startshare', [subject, text]);
    },
};