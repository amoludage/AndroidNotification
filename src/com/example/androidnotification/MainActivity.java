package com.example.androidnotification;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
	
	Button btnGetRegId;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btnGetRegId = (Button) findViewById(R.id.btnGetRegId);
		btnGetRegId.setOnClickListener(new View.OnClickListener() {
			@Override
		      public void onClick(View view) {
		        Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
		        startActivity(intent);
		      }

		    });
		//Button orderButton = (Button)findViewById(R.id.order);

	}
	
	
			
}
