package com.Parent;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageView;

public class FileLogActivity extends Activity implements IP {
	JSONArray ja;
	int cc = 0;
	ImageView i1;
	String filecontent, myfilename;
	Handler h1;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.filelog);

		WebServ w1 = new WebServ();
		try {
			h1 = new Handler();
			int id = ParentActivity.loginid;
			//Log.i("my id", "hi....." + id);
			List<NameValuePair> namevaluepair = new ArrayList<NameValuePair>(1);
			namevaluepair.add(new BasicNameValuePair("loginid", "" + id));
			ja = w1.doPost(namevaluepair, "http://" + ip
					+ "/SmartParentingServer1/webservice-android/imagedisplay.jsp");
			JSONObject jo = (JSONObject) ja.get(0);
			// TextView name = (TextView) findViewById(R.id.myFileName);
			myfilename = jo.get("filename").toString();
			// filecontent =jo.get("filecontent").toString();
			//Log.i("myfilename", "" + myfilename);
			i1 = (ImageView) findViewById(R.id.imageView);

			// name.setText(myfilename);

		} catch (Exception e) {
			// TODO: handle exception
		}
		h1.postDelayed(r1, 1000);
	}

	Runnable r1 = new Runnable() {

		public void run() {
			// TODO Auto-generated method stub
			if (cc <= ja.length()) {
				JSONObject jo;
				try {
					jo = (JSONObject) ja.get(cc);

					myfilename = jo.get("filename").toString();
					Bitmap imageBitmap = DownloadImage("http://" + ip
							+ "/SmartParentingServer1/webservice-android/images/" + ParentActivity.loginid
							+ "/" + myfilename);
					// imageBitmap.recycle();
					i1.setImageBitmap(imageBitmap);
					cc++;

				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				h1.postDelayed(r1, 4000);
			} else {

			}
		}
	};

	private InputStream OpenHttpConnection(String urlString) throws IOException {
		InputStream in = null;
		int response = -1;

		// String encodedURL = URLEncoder.encode(urlString, "UTF8");

		URL url = new URL(urlString);
		URLConnection conn = url.openConnection();

		if (!(conn instanceof HttpURLConnection))
			throw new IOException("Not an HTTP connection");

		try {
			HttpURLConnection httpConn = (HttpURLConnection) conn;
			httpConn.setAllowUserInteraction(false);
			httpConn.setInstanceFollowRedirects(true);
			httpConn.setRequestMethod("GET");
			httpConn.connect();
			response = httpConn.getResponseCode();
			if (response == HttpURLConnection.HTTP_OK) {
				in = httpConn.getInputStream();
			}
		} catch (Exception ex) {
			throw new IOException("Error connecting");
		}
		return in;
	}

	private Bitmap DownloadImage(String URL) {
		Bitmap bitmap = null;
		InputStream in = null;
		try {
			in = OpenHttpConnection(URL);
			bitmap = BitmapFactory.decodeStream(in);
			in.close();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return bitmap;
	}
}
