package smart.com;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Service;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.IBinder;
import android.preference.PreferenceManager;
import android.provider.ContactsContract;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

public class SMSSentService extends Service  implements IP
{
    ContentResolver contentResolver;
    Uri uri=Uri.parse("content://sms");
    Handler handler;
    SharedPreferences myshare;
    @Override
    public IBinder onBind(Intent arg0) 
    {
        return null;
    }
    @Override
    public void onCreate() 
    {
    	Log.i("STATUS", "sms service on create");
        contentResolver=getContentResolver();
        contentResolver.registerContentObserver(uri, true, new contentObserver(handler));
        Log.i("msg","hai");
        myshare = PreferenceManager.getDefaultSharedPreferences(this);
        super.onCreate();
    }

    @Override
    public void onStart(Intent intent, int startId) 
    {
        super.onStart(intent, startId);
        Log.i("onstart","start");
    }

    @Override
    public void onDestroy() 
    {
        super.onDestroy();
        
    }
    public class contentObserver extends ContentObserver
    {
        public contentObserver(Handler handler) 
        {
            super(handler);
        }
        @Override
        public void onChange(boolean selfChange) 
        {  																																																																																																																																															                 
        	String loginid = myshare.getString("loginid", "");
            Cursor cursor = contentResolver.query(uri, null, null, null, null);
            cursor.moveToFirst();
            String num = cursor.getString(2);
            Log.e("num",num);
           // String num1 = cursor.getString(1);
           // Log.e("num1",num1);
          //  String num12 = cursor.getString(3);
           // Log.e("num12",num12);
            String content = cursor.getString(cursor.getColumnIndex("body"));
            String number = cursor.getString(cursor.getColumnIndex("address"));
            String type = cursor.getString(cursor.getColumnIndex("type"));
           
           // String num = cursor.getString(2);
            Log.e("!!!!!!!!!!!!!", "SMS - " + content+"\t"+number);
           // Toast.makeText(,"!!!!!!!!!!!!!", "SMS - " + content+"\t"+number,10000).show();
            Log.d("type",type);
            if(type.equals("1"))
            {
            	
            }
            else
            {
           WebServ webobj=new WebServ();
			try {
			List<NameValuePair> namevaluepair = new ArrayList<NameValuePair>(3);
				namevaluepair.add(new BasicNameValuePair("number", number));
				namevaluepair.add(new BasicNameValuePair("msg", content));
				namevaluepair.add(new BasicNameValuePair("loginid",loginid));
				JSONArray ja=webobj.doPost(namevaluepair,"http://"+ip+"/SmartParentingServer1/webservice-android/outboxinsert.jsp");
				JSONObject jo=(JSONObject) ja.get(0);
				String msg=jo.get("resp").toString();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            }
            super.onChange(selfChange);
        }
    }
}