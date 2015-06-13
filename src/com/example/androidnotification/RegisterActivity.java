package com.example.androidnotification;

import com.google.android.gms.gcm.GoogleCloudMessaging;
import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class RegisterActivity extends Activity {

	EditText etRegId;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		etRegId = (EditText) findViewById(R.id.etRegId);
		RegisterUser(null);
	}

	public void RegisterUser(View view) {
		new AsyncTask<Void, Void, String>() {
			@Override
            protected String doInBackground(Void... params) {
                String msg = "";
                GoogleCloudMessaging gcm = GoogleCloudMessaging.getInstance(getApplicationContext());
                String regid;
                String PROJECT_NUMBER = "284872346977";
                try {
                    if (gcm == null) {
                        gcm = GoogleCloudMessaging.getInstance(getApplicationContext());
                    }
                   
                    Log.e("ProjectID", "Project ID: " + PROJECT_NUMBER );
                    Log.e("Gcm", "GCM ID: " + gcm );
                    
                  //  regid = gcm.getToken(PROJECT_NUMBER, "INSTANCE_ID_SCOPE");
                    
                    regid = gcm.register(PROJECT_NUMBER);
                 
                    msg = "Device registered:- " + regid;
                    Log.i("GCM",  msg);
                    System.out.println(""+msg);
                } catch (Exception ex) {
                    msg = "Error :" + ex.getMessage();

                }
                Log.e("MSG", msg);
                return msg;
            }

            @Override
            protected void onPostExecute(String msg) {
                etRegId.setText(msg + "\n");
            }
        }.execute(null, null, null);
/*
		String regId;
		String msg = "";
		String GOOGLE_PROJ_ID = "284872346977";
		//GoogleCloudMessaging gcmObj;
		
		Log.e("Proj", "proj Id"+GOOGLE_PROJ_ID);
		
		try {
			InstanceID instanceID = InstanceID.getInstance(getApplicationContext());
			Log.e("Proj", "proj Id"+GOOGLE_PROJ_ID);
			regId = instanceID.getToken(GOOGLE_PROJ_ID,
                    GoogleCloudMessaging.INSTANCE_ID_SCOPE, null);
			Log.e("Proj", "proj Id"+GOOGLE_PROJ_ID);

			msg = "Registration ID :" + regId;
			
			Log.i("RrgID", "Registration Id = "+msg);

		}catch (Exception e) {
			e.printStackTrace();
						}
	}*/
	}
}
