package com.Parent;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

import android.app.AlertDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.drawable.Drawable;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.preference.PreferenceManager;
import android.util.Log;
import android.util.StringBuilderPrinter;
import android.view.MotionEvent;
import android.widget.Toast;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.MapView;
import com.google.android.maps.OverlayItem;

class HelloItemizedOverlay1 extends ItemizedOverlay<OverlayItem> implements IP {
	private ArrayList<OverlayItem> mOverlays = new ArrayList<OverlayItem>();
	Context mContext;
	JSONArray ja;
	ArrayList<Location> locations = new ArrayList<Location>();
	SharedPreferences myshared;
	
	static double	lat2,lat1,log1,log2;
	public HelloItemizedOverlay1(Drawable defaultMarker) {
		super(defaultMarker);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected OverlayItem createItem(int i) {
		// TODO Auto-generated method stub
		return mOverlays.get(i);
	}

	@Override
	public int size() {
		return mOverlays.size();
	}

	public void addOverlay(OverlayItem overlay) {
		mOverlays.clear();
		mOverlays.add(overlay);
		populate();
	}

	public HelloItemizedOverlay1(Drawable defaultMarker, Context context) {
		super(boundCenterBottom(defaultMarker));
		mContext = context;
	}

	@Override
	protected boolean onTap(int index) {
		OverlayItem item = mOverlays.get(index);
		AlertDialog.Builder dialog = new AlertDialog.Builder(mContext);
		dialog.setTitle(item.getTitle());
		dialog.setMessage(item.getSnippet());
		dialog.show();
		return true;
	}

	@Override
	public boolean onTouchEvent(MotionEvent event, MapView mapView) {
		// ---when user lifts his finger---
		if (event.getAction() == 1) {

			GeoPoint p = mapView.getProjection().fromPixels((int) event.getX(),
					(int) event.getY());
			Log.i("====================================", p.getLatitudeE6()
					/ 1E6 + "," + p.getLongitudeE6() / 1E6);

			// Toast.makeText(this, "out of bound"+lat,
			// Toast.LENGTH_SHORT).show();

		 lat1 = p.getLatitudeE6() / 1E6;
		 log1 = p.getLongitudeE6() / 1E6;
			//Location currentLoc = new Location(LocationManager.GPS_PROVIDER);
			
			//currentLoc.setLatitude(la);
			//currentLoc.setLongitude(lo);
		//	locations.add(currentLoc);

			
				/*Location currentLoc = new Location(LocationManager.GPS_PROVIDER);
				
				currentLoc.setLatitude(la);
				currentLoc.setLongitude(lo);
				locations.add(currentLoc);*/
				
				//WebServ w1 = new WebServ();
				

					// Toast.makeText(mContext," ttttt",
				// Toast.LENGTH_LONG).show();
					//List<NameValuePair> namevaluepair = new ArrayList<NameValuePair>(
							//2);

					
					//lat1= locations.get(0).getLatitude();
				//	Log.i("latitude1",""+lat1);
				//	log1= locations.get(0).getLongitude();
				//	Log.i("longitude1",""+log1);
			//			lat2= locations.get(1).getLatitude();
			//		Log.i("latitude2",""+lat2);
				// log2= locations.get(1).getLongitude();
				//	Log.i("longitude2",""+log2);


					
					

					//namevaluepair.add(new BasicNameValuePair("loginid", "" + id));
				//ja = w1.doPost(namevaluepair, "http://" + ip
							//+ "/MyProject/mapmark.jsp");
					//JSONObject jo = (JSONObject) ja.get(0);
					//Log.i("ja", "" + ja);

				
			}

		
		return false;
	}
	
	
}
