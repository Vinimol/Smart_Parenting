package com.Parent;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ImageAdapter extends BaseAdapter implements IP {
	String filename, imagecontent;
	TextView myfilename;
	Context adapterContext;
	JSONArray recvdja;
	JSONObject recvdjo;

	public ImageAdapter(Context adapterContext, JSONArray recvdja) {
		super();
		this.adapterContext = adapterContext;
		this.recvdja = recvdja;
	}

	public int getCount() {
		// TODO Auto-generated method stub
		return 1;
	}

	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		convertView = LayoutInflater.from(adapterContext).inflate(
				R.layout.image_custom_cell, null);
		TextView myfilename = (TextView) convertView
				.findViewById(R.id.myFileName);

		try {
			recvdjo = (JSONObject) recvdja.get(position);
			filename = recvdjo.get("filename").toString();
			Log.i("filename", "" + filename);
			ImageView i1 = (ImageView) convertView.findViewById(R.id.imageView);
			
			Bitmap imageBitmap = DownloadImage("http://" + ip
					+ "/SmartParentingServer1/webservice-android/images/" + ParentActivity.loginid + "/"
					+ filename);
			//imageBitmap.recycle();
			 i1.setImageBitmap(imageBitmap);
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		myfilename.setText(filename);

		return convertView;
	}

	private InputStream OpenHttpConnection(String urlString) throws IOException {
		InputStream in = null;
		int response = -1;

		//String encodedURL = URLEncoder.encode(urlString, "UTF8");  
		
		
		
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
