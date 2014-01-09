
package org.apache.cordova.social;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Intent;

//import org.apache.cordova.api.Plugin;
//import org.apache.cordova.api.PluginResult;

import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaInterface;

//import android.provider.Settings;

public class Share extends CordovaPlugin {

    public static final String TAG = "Share";


	@Override
    public boolean execute(String action, JSONArray args, String callbackId) throws JSONException {
		
		try {
			JSONObject jo = args.getJSONObject(0);
			this.doSendIntent(jo.getString("subject"), jo.getString("text")); 
			return new PluginResult(PluginResult.Status.OK);
		} catch (JSONException e) {
			return new PluginResult(PluginResult.Status.JSON_EXCEPTION);
		}
    }
	
	private void doSendIntent(String subject, String text) {
		Intent sendIntent = new Intent(android.content.Intent.ACTION_SEND);
		sendIntent.setType("text/plain");
		sendIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, subject);
		sendIntent.putExtra(android.content.Intent.EXTRA_TEXT, text);
		this.cordova.startActivityForResult(this, sendIntent, 0);
	}
	
}
