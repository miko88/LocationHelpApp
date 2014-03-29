package com.mb.locationhelpapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.telephony.TelephonyManager;

public class UserInformation {
	
	private Context context;
	private SharedPreferences prefs;
	
	public UserInformation(Context context) {
		this.context = context;
		this.prefs = PreferenceManager.getDefaultSharedPreferences(this.context);
	}

	public String getPhoneNumber() {
		return this.prefs.getString("pref_phone_number", "");
	}
	
	public String getDeviceId() {
		return ((TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE)).getDeviceId();
	}
	

	public String getPreference(String name) {
		return this.prefs.getString(name, "");
	}

}
