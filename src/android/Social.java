package org.apache.cordova.social;


import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import android.content.Intent;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


//import android.provider.Settings;

public class Social extends CordovaPlugin {

	/**
     * Constructor.
     */
    public Social() {
    }

	@Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		
		if (action.equals("startshare")) {
		
            //args.getLong(0)
			
			JSONObject jo = args.getJSONObject(0);
			this.StartShare(jo.getString("subject"), jo.getString("text")); 
        }else {
            return false;
        }
		
		
		
		callbackContext.success();
		return true;
		
    }
	
	public void StartShare(String subject, String text) {
		Intent sendIntent = new Intent(android.content.Intent.ACTION_SEND);
		sendIntent.setType("text/plain");
		sendIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, subject);
		sendIntent.putExtra(android.content.Intent.EXTRA_TEXT, text);
		this.cordova.startActivityForResult(this, sendIntent, 0);
	}
	
}
