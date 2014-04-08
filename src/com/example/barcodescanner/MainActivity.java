package com.example.barcodescanner;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	private Button scan;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		scan= (Button)findViewById(R.id.scan_button);
		
		scan.setOnClickListener(new View.OnClickListener() {
            
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub  
                Intent intent = new Intent("com.google.zxing.client.android.SCAN");
                //intent.putExtra("SCAN_MODE", "QR_CODE_MODE");
                Log.i("Scanner" , "starting intent");
                startActivityForResult(intent, 0);
            }
        });
		
	
	}
	
	public void onActivityResult(int requestCode, int resultCode, Intent intent) {
		Log.i("Scanner" , "yeah enetering on result now");
        if (requestCode == 0) {
           if (resultCode == RESULT_OK) {
               
              String contents = intent.getStringExtra("SCAN_RESULT");
              String format = intent.getStringExtra("SCAN_RESULT_FORMAT");
           
              // Handle successful scan
              Log.i("Scanner" , contents);
                                        
           } else if (resultCode == RESULT_CANCELED) {
              // Handle cancel
              Log.i("App","Scan unsuccessful");
           }
      }
   }



	/**
	 * A placeholder fragment containing a simple view.
	 */


}
