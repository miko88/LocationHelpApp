package com.mb.locationhelpapp;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.net.Uri;
import android.telephony.SmsManager;

public class UserAction {
	
	private Context context;
	
	public UserAction(Context context) {
		this.context = context;
	}
	
	public void makeCall(String phoneNumber) {
		AudioManager audioManager = (AudioManager) this.context.getSystemService(Context.AUDIO_SERVICE);
		audioManager.setSpeakerphoneOn(true);
		
		Intent intent = new Intent(Intent.ACTION_CALL);
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		intent.setData(Uri.parse("tel:" + phoneNumber));
		this.context.startActivity(intent);
	}
	
	public void sendTextMessage(String phoneNumber, String messageBody) {
		SmsManager manager = SmsManager.getDefault();
		manager.sendTextMessage(phoneNumber, null, messageBody, null, null);
	}

}
