package com.example.barcodescanner;

import java.io.IOException;

import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.semantics3.api.Products;

public class MainActivity extends Activity {

	private Button scan;
	JSONObject results = null;
	Products products = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		scan = (Button) findViewById(R.id.scan_button);

		scan.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(
						"com.google.zxing.client.android.SCAN");
				startActivityForResult(intent, 0);
			}
		});

	}

	public void onActivityResult(int requestCode, int resultCode, Intent intent) {

		if (requestCode == 0) {
			if (resultCode == RESULT_OK) {

				String contents = intent.getStringExtra("SCAN_RESULT");
				String format = intent.getStringExtra("SCAN_RESULT_FORMAT");

				// Handle successful scan

				products = new Products("SEM3FC0B1C0BDD9030D3D13AFF309362D3CC",
						"NzgyYzdkNWZmNDJjZjg4ZTI1ZTQzZWI2OGMxYjM3MWE");

				try {
					products.productsField("cat_id", 4992).productsField(
							"brand", "Toshiba");
					products.add( "offers", "currency", "USD");
				} catch (JSONException e) {
					e.printStackTrace();
				}

				Log.i("Scanner prodcuts", products.toString());

				Thread t = new Thread(new Runnable() {
					public void run() {
						try {
							Log.i("Scanner", "getProducts(");
							//results = new JSONObject(products.get().toString());
							//Log.i("Scanner after result",  "   " + products.get().toString()); //even this is giving error
							results = products.get();
						} catch (OAuthMessageSignerException
								| OAuthExpectationFailedException
								| OAuthCommunicationException | IOException
								| JSONException e) {
							e.printStackTrace();
						}
					}
				});

				t.start();
				while (t.isAlive()) {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				Log.i("Scanner t ", "thread resulting finished=" + t.isAlive());
				if (results != null) {
					//Log.i("Scanner after result", results.toString());
				}

			} else if (resultCode == RESULT_CANCELED) {
				// Handle cancel
				Log.i("App", "Scan unsuccessful");
			}
		}
	}

}
