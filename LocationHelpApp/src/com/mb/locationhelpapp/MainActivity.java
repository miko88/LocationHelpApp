package com.mb.locationhelpapp;

import java.math.BigDecimal;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import android.os.Build;

public class MainActivity extends ActionBarActivity {

	private UserInformation userInfo;
	private UserAction userAction;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
        
        userInfo = new UserInformation(getApplicationContext());
        userAction = new UserAction(getApplicationContext());
    }
    
    
    private void showConfirmDialog() {
    	new AlertDialog.Builder(this)
        .setMessage("Naozaj chcete vykonaù zvolen˙ akciu?")
        .setCancelable(false)
        .setPositiveButton("¡no", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
            	getCurrentLocation();
            }
        })
        .setNegativeButton("Nie", null)
        .show();   	
    }
    
    private void doAction () {
    	if (userInfo.getPreference("pref_mode").compareTo("secure") == 0)
    		showConfirmDialog();
    	else
    		getCurrentLocation();   	
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.       
        switch (item.getItemId()) {
        
        case R.id.action_settings:
            Intent i = new Intent(this, Preferens.class);
            startActivity(i);
            break;
        }
        
        return true;  
    }
    
    
   public void getCurrentLocation() {
	   //Toast.makeText(this, userInfo.getDeviceId(), Toast.LENGTH_LONG).show();
	   userAction.sendTextMessage("0948515187", "TEST");
	   userAction.makeCall("0948515187");
	   
		/*GPSTracker gps = new GPSTracker(MainActivity.this);
		String NAMESPACE = "http://locationhelp.mb.com/";
		String METHOD_NAME = "getNumber";
		String SOAP_ACTION = "http://locationhelp.mb.com/getNumber";
		String URL = "http://localhost:8080/LocationHelp/services/LocationManagerPort";
		
		// check if GPS enabled
		if (gps.canGetLocation()) {
			double latitude = gps.getLatitude();
			double longitude = gps.getLongitude();
			
			SoapObject Request = new SoapObject(NAMESPACE, METHOD_NAME);
			
			PropertyInfo pi = new PropertyInfo();
	        pi.setName("arg0");
	        pi.setValue(latitude);
	        pi.setType(double.class);
	        Request.addProperty(pi);

	        PropertyInfo pi2 = new PropertyInfo();
	        pi2.setName("arg1");
	        pi2.setValue(longitude);
	        pi2.setType(double.class);
	        Request.addProperty(pi2);
	        
	        PropertyInfo pi3 = new PropertyInfo();
	        pi3.setName("arg2");
	        pi3.setValue("PZ");
	        pi3.setType(String.class);
	        Request.addProperty(pi3);
	        
	        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
	        envelope.dotNet = false;
	        envelope.setOutputSoapObject(Request);
	        
	        HttpTransportSE httpTransport = new HttpTransportSE(URL);
	        
	        try
            {
	        	httpTransport.call(SOAP_ACTION, envelope);
                SoapObject response = (SoapObject)envelope.getResponse();
    			Toast.makeText(
    					getApplicationContext(),
    					response.getProperty(0).toString(), Toast.LENGTH_LONG).show();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
			// \n is for new line

		} else {
			// can't get location
			// GPS or Network is not enabled
			// Ask user to enable GPS/network in settings
			gps.showSettingsAlert();
		}*/

	}
	
    
    
    public void medOnClick(View view) {
    	doAction();
    }
    
    
    public void polOnClick(View view) {
    	doAction();
    }


    public void firOnClick(View view) {
    	doAction();
    }
    
    

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }
    
  
}
