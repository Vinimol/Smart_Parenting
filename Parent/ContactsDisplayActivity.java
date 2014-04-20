package com.Parent;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

public class ContactsDisplayActivity extends Activity implements IP{
	JSONArray ja;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.contacts);
		
		ListView myListView1 = (ListView) findViewById(R.id.myContacts);
		WebServ w1 = new WebServ();
		try {
			int id=ParentActivity.loginid;
			Log.i("my id","hi....."+id);

			List<NameValuePair> namevaluepair = new ArrayList<NameValuePair>(1);

			namevaluepair.add(new BasicNameValuePair("loginid",""+id));

			ja = w1.doPost(namevaluepair, "http://" + ip
					+ "/SmartParentingServer1/webservice-android/ContactsDisplay.jsp");
			//JSONObject jo = (JSONObject) ja.get(0);
								ContactsNameAdapter adapter = new ContactsNameAdapter(ContactsDisplayActivity.this, ja);
			myListView1.setAdapter(adapter);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}

}
