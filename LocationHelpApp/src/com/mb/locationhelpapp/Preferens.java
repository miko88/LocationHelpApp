package com.mb.locationhelpapp;

import android.os.Bundle;
import android.preference.PreferenceActivity;

public class Preferens extends PreferenceActivity{

	@SuppressWarnings("deprecation")
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);  
        addPreferencesFromResource(R.xml.preferences);
    }  
	
	
}
