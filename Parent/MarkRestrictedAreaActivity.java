package com.Parent;

import java.util.List;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;
public class MarkRestrictedAreaActivity extends MapActivity implements IP{
	HelloItemizedOverlay1 itemizedoverlay;
	OverlayItem overlayitem;
	List<Overlay> mapOverlays;
	MapView mapView;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.markrestrictedarea);
		mapView = (MapView) findViewById(R.id.myRestrictedMapview);
		mapView.getController().setZoom(16);
		List<Overlay> mapOverlays = mapView.getOverlays();
		Drawable drawable = this.getResources().getDrawable(R.drawable.ic_launcher);
		 itemizedoverlay = new HelloItemizedOverlay1(drawable, this);
		int la = (int) (10.194461800000000000 * 1E6);
		int lo = (int) (76.407133599999950000* 1E6);
		GeoPoint point1 = new GeoPoint(la,lo);
		overlayitem = new OverlayItem(point1,"iam in","");
		itemizedoverlay.addOverlay(overlayitem);
		mapOverlays.add(itemizedoverlay);
		mapView.getController().setCenter(point1);
		mapView.invalidate();
	}

	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}

	public void save1(View v)
	{
		SharedPreferences myshared=PreferenceManager.getDefaultSharedPreferences(this);
		Editor myeditor=myshared.edit();
		myeditor.putString("lat1", ""+HelloItemizedOverlay1.lat1);
		myeditor.putString("log1", ""+HelloItemizedOverlay1.log1);
		myeditor.commit();
		Toast.makeText(this,"save1",10000).show();
		
		
	}
	
	public void save2(View v)
	{
		SharedPreferences myshared=PreferenceManager.getDefaultSharedPreferences(this);
		Editor myeditor=myshared.edit();
		myeditor.putString("lat2", ""+HelloItemizedOverlay1.lat1);
		myeditor.putString("log2", ""+HelloItemizedOverlay1.log1);
		myeditor.commit();
		Toast.makeText(this,"save2",10000).show();
		
		
	}
}
