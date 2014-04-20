package com.Parent;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ParentActivity extends Activity implements IP {
	static int loginid=0;
	/** Called when the activity is first created. */
	EditText usernameEt, passwordEt;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		usernameEt = (EditText) findViewById(R.id.usernameET);
		passwordEt = (EditText) findViewById(R.id.passwordET);
	}

	public void submitButtonClicked(View v) {
	
		WebServ w1 = new WebServ();
		try {
			String username = usernameEt.getText().toString();
			Log.i("user",""+username);
			String password = passwordEt.getText().toString();
			Log.i("password",""+password);
			List<NameValuePair> namevaluepair = new ArrayList<NameValuePair>(2);

			namevaluepair.add(new BasicNameValuePair("Password", password));
			namevaluepair.add(new BasicNameValuePair("UserName", username));

			JSONArray ja = w1.doPost(namevaluepair, "http://" + ip
					+ "/SmartParentingServer1/webservice-android/Login.jsp");
		//	Toast.makeText(this, "hai", Toast.LENGTH_LONG).show();
			
			JSONObject jo = (JSONObject) ja.get(0);
			String myloginid = jo.get("id").toString();
			String msg = jo.get("resp").toString();
			loginid=Integer.parseInt(myloginid);
			Toast.makeText(this,msg+loginid, Toast.LENGTH_LONG).show();
			Intent myintent = new Intent(ParentActivity.this,
			ParentHomeActivity.class);
			startActivity(myintent);
		} catch (Exception e) {

		}

	}

}