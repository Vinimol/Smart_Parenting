package smart.com;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

public class BootUpReceiver extends BroadcastReceiver implements IP{
	SharedPreferences mySimPref;
	String loginid,status;
	  @Override
      public void onReceive(Context context, Intent intent) {
              Intent i = new Intent(context, SmartActivity.class);  
              i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
              context.startActivity(i);  
              TelephonyManager tManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
      	    String newsimstatus = tManager.getSimSerialNumber();
      	  mySimPref= PreferenceManager.getDefaultSharedPreferences(context);
      	  String serialNmuber=mySimPref.getString("simstatus","");
      	  Log.i("sim stats on receiver", "" + newsimstatus);
      	  Log.i("sim stats on serialNmuber", "" + serialNmuber);

      	  WebServ w1 = new WebServ();
      	  if(serialNmuber.equals(newsimstatus))
      	  {
      		 String msg = "";
				try {
//					Toast.makeText(context, , Toast.LENGTH_LONG).show();
		      		 msg = "sim not changed";
					Log.i("status","sim not cahnged"+serialNmuber);
					mySimPref = PreferenceManager
							.getDefaultSharedPreferences(context);
					loginid = mySimPref.getString("loginid", "");
					List<NameValuePair> namevaluepair = new ArrayList<NameValuePair>(
							4);
msg = msg + "*****************"+loginid;
					namevaluepair.add(new BasicNameValuePair("loginid", loginid));
					namevaluepair.add(new BasicNameValuePair("notification","Sim Not Changed"));
					namevaluepair.add(new BasicNameValuePair("status", "0"));

					JSONArray ja = w1.doPost(namevaluepair, "http://" + ip
							+ "/SmartParentingServer1/webservice-android/Simchange.jsp");
					JSONObject jo = (JSONObject) ja.get(0);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				msg = msg + "           ///exception";
				}
				Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
      	  }
      	  else
      	  {
      		try {
      			Toast.makeText(context, "sim changed", Toast.LENGTH_LONG).show();
          		
				Log.i("status","sim cahnged"+serialNmuber);
				mySimPref = PreferenceManager
						.getDefaultSharedPreferences(context);
				loginid = mySimPref.getString("loginid", "");
				List<NameValuePair> namevaluepair = new ArrayList<NameValuePair>(
						4);

				namevaluepair.add(new BasicNameValuePair("loginid", loginid));
				namevaluepair.add(new BasicNameValuePair("notification","Sim Changed"));
				namevaluepair.add(new BasicNameValuePair("status", "1"));

				JSONArray ja = w1.doPost(namevaluepair, "http://" + ip
						+ "/SmartParentingServer1/webservice-android/Simchange.jsp");
				JSONObject jo = (JSONObject) ja.get(0);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

      		
				
      	  }
      }

}
