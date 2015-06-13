package com.example.androidnotification;



import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Log;

public class GcmBroadcastReceiver extends WakefulBroadcastReceiver{

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		Log.e("GCM", "brodcast receiver");
		ComponentName comp = new ComponentName(context.getPackageName(),
                GCMNotificationIntentService.class.getName());
		Log.e("GCM", "brodcast receiver");
        startWakefulService(context, (intent.setComponent(comp)));
        Log.e("GCM", "brodcast receiver");
        setResultCode(Activity.RESULT_OK);
	}

}
