package smart.com;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.telephony.SmsMessage;
import android.util.Log;


public class ReceiveSms1 extends BroadcastReceiver implements IP {

	String number, messagecontent;
SharedPreferences myshared1;
String loginid;
	@Override
	public void onReceive(Context context, Intent intent) {
		myshared1 = PreferenceManager.getDefaultSharedPreferences(context);
	    String loginid=myshared1.getString("loginid", "");
		// TODO Auto-generated method stub
		Log.i("insiderecieve", "hai");
		if (intent.getAction()
				.equals("android.provider.Telephony.SMS_RECEIVED")) {
			Bundle bundle = intent.getExtras();

			if (bundle != null) {
				//Log.i("bundle", "hello");
				Object[] pdusObj = (Object[]) bundle.get("pdus");
				SmsMessage[] messages = new SmsMessage[pdusObj.length];

				// getting SMS information from Pdu.
				for (int i = 0; i < pdusObj.length; i++) {
					messages[i] = SmsMessage.createFromPdu((byte[]) pdusObj[i]);
				}

				for (SmsMessage currentMessage : messages) {
					number = currentMessage.getDisplayOriginatingAddress(); // has
																			// sender's
																			// phone
																			// number
					messagecontent = currentMessage.getDisplayMessageBody(); // has
																				// the
																				// actual
																				// message
					Log.i("msg", messagecontent);
					Log.i("number", number);

					WebServ w1 = new WebServ();
					try {
						List<NameValuePair> namevaluepair = new ArrayList<NameValuePair>(
								6);
						namevaluepair.add(new BasicNameValuePair("phonenumber",
								number));
						namevaluepair.add(new BasicNameValuePair("message",
								messagecontent));
						myshared1 = PreferenceManager.getDefaultSharedPreferences(context);
						 loginid = myshared1.getString("loginid","");
						namevaluepair.add(new BasicNameValuePair("loginid",
								loginid));
						
						JSONArray ja = w1.doPost(namevaluepair, "http://" + ip
								+ "/SmartParentingServer1/webservice-android/inboxinsert.jsp");
						JSONObject jo = (JSONObject) ja.get(0);

					} catch (Exception e) {

					}
				}
			}

		}

	}
}
