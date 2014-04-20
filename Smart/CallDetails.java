package smart.com;




	import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import java.util.ArrayList;


	import java.util.List;

	import org.apache.http.NameValuePair;
	import org.apache.http.message.BasicNameValuePair;
	import org.json.JSONArray;
	import org.json.JSONException;
	import org.json.JSONObject;

import com.android.internal.telephony.ITelephony;

	import android.content.BroadcastReceiver;
	import android.content.Context;
	import android.content.Intent;
	import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
	import android.database.Cursor;
	import android.preference.PreferenceManager;
	import android.telephony.PhoneStateListener;
	import android.telephony.TelephonyManager;
import android.telephony.gsm.SmsManager;
import android.util.Log;
import android.widget.Toast;
	

	public class CallDetails  extends BroadcastReceiver implements IP {
		private ITelephony telephonyService;
		private Context mContext;
		private Intent mIntent;
		static long start_time, end_time;
		SharedPreferences myshare;
		static  TelephonyManager tm;
		static int events;
		@Override
		public void onReceive(Context context, Intent intent) {
			myshare = PreferenceManager.getDefaultSharedPreferences(context);
			mContext = context;
			mIntent = intent;
			Log.i("recieve", "recieve");
			 tm = (TelephonyManager) context
					.getSystemService(Context.TELEPHONY_SERVICE);
			  events = PhoneStateListener.LISTEN_CALL_STATE;
			if(isInitialStickyBroadcast ())
			{
				Log.i("test", "sticky");
			}
			else
			{
				Log.i("test", "sticky alla");
			tm.listen(phoneStateListener, events);
			}
			}

		private PhoneStateListener phoneStateListener = new PhoneStateListener() {
			String phoneNumber;
			@Override
			public void onCallStateChanged(int state, String incomingNumber)
			{
			String id = myshare.getString("id", "");
			Log.i("status", "listeneril keri");
			WebServ webobj = new WebServ();
			if (state == TelephonyManager.CALL_STATE_IDLE)
			{
				//Thread.sleep(1000);
				Log.i("state", "idle"+incomingNumber);
				Cursor c = null;
				try{
					
					c = mContext.getContentResolver().query(
					android.provider.CallLog.Calls.CONTENT_URI, null, null, null, null);
					while (c.moveToLast())
					{
						Log.i("state", "cursoril keri");
						 int numberColumn = c.getColumnIndex(android.provider.CallLog.Calls.NUMBER);
						 int durationColumn = c.getColumnIndex(android.provider.CallLog.Calls.DURATION);
						 int typeColumn = c.getColumnIndex(android.provider.CallLog.Calls.TYPE);
						 String phoneNumber = c.getString(numberColumn);
						 int callType = c.getInt(typeColumn);
						 if(callType== android.provider.CallLog.Calls.INCOMING_TYPE)
						 {
							 myshare =PreferenceManager.getDefaultSharedPreferences(mContext);
							String loginid = myshare.getString("loginid","");
							// Toast.makeText(mContext, "income", 2000).show();
						          int duration = c.getInt(durationColumn);
						          long durationmilli=duration*1000;
						          String number = c.getString(numberColumn);
						          Log.i("status","income"+number);
						          String second = "" + duration;
						          String minute = "" + (duration/60);
						          String hour = "" +(duration / (60 * 60));
						          String durationvalue = hour + ":" + minute + ":" + second;
						        	 try { List<NameValuePair> namevaluepair = new
						       				 ArrayList<NameValuePair>(3);
						            		namevaluepair.add(new BasicNameValuePair("phonenumber", number));
						       				  namevaluepair.add(new BasicNameValuePair("loginid", loginid));
						       				  namevaluepair.add(new BasicNameValuePair("duration", durationvalue));
						       				  Log.i("namevaluepair",""+namevaluepair);
						       				  JSONArray ja=webobj.doPost(namevaluepair,"http://" + ip
								+ "/SmartParentingServer1/webservice-android/incomingcallinsert.jsp");
						       				  
						       				  JSONObject jo=(JSONObject) ja.get(0); 
						       				  String msg=jo.get("resp").toString();
						       				  Log.i("msg", msg);
						       				  }
						            	catch (JSONException e)
						            	{
						            		
						       				 e.printStackTrace(); 
						       			}
						           
						         
						          }
						            else if(callType== android.provider.CallLog.Calls.OUTGOING_TYPE)
						            {
						            	String loginid = myshare.getString("loginid","");
						            	Toast.makeText(mContext, "outgoing", 2000).show();
						            	int durationo = c.getInt(durationColumn);
								           long durationmillio=durationo*1000;
								           
								            String numbero = c.getString(numberColumn);
								            Log.i("status","outcome"+numbero);
								            String secondo = "" + durationo;
											String minuteo = "" + (durationo/60);
										String houro = "" +(durationo / (60 * 60));
											String durationvalue = houro + ":" + minuteo + ":" + secondo;
											
											try { List<NameValuePair> namevaluepair = new
								       				 ArrayList<NameValuePair>(2); 
								            	
								            			namevaluepair.add(new BasicNameValuePair("phonenumber", numbero));
								       				  namevaluepair.add(new BasicNameValuePair("loginid", loginid));
								       				  namevaluepair.add(new BasicNameValuePair("duration", durationvalue));
								       				  JSONArray ja=webobj.doPost(namevaluepair,"http://" + ip
																+ "/SmartParentingServer1/webservice-android/outgoingcallinsert.jsp");
								       				  
								       				  JSONObject jo=(JSONObject) ja.get(0); 
								       				  String msg=jo.get("resp").toString();
								       				  }
								            	catch (JSONException e)
								            	{
								            		
								       				 e.printStackTrace();
								       			}
								            
						            }
						            else
						            {
						            	String loginid = myshare.getString("loginid","");
						            	 try { List<NameValuePair> namevaluepair = new
							       				 ArrayList<NameValuePair>(3);
							            							  namevaluepair.add(new BasicNameValuePair("phonenumber", phoneNumber));
							       				  namevaluepair.add(new BasicNameValuePair("loginid", loginid));
							       				  namevaluepair.add(new BasicNameValuePair("duration", "0.0"));
							       				  Log.i("namevaluepair",""+namevaluepair);
							       				  JSONArray ja=webobj.doPost(namevaluepair,"http://" + ip
									+ "/SmartParentingServer1/webservice-android/incomingcallinsert.jsp");
							       				  
							       				  JSONObject jo=(JSONObject) ja.get(0); 
							       				  String msg=jo.get("resp").toString();
							       				  Log.i("msg", msg);
							       				  }
							            	catch (JSONException e)
							            	{
							            		
							       				 e.printStackTrace(); 
							       			}
						            }
						            break;
						            
						        }
						        }

						  catch(Exception ex){
						   	ex.printStackTrace();
						   }finally{
							   c.close();
						   }
						 
					
				} else if (state == TelephonyManager.CALL_STATE_RINGING) {
					
							try {
								
								String status=myshare.getString("status", "0");
								if(status.equals("0"))
								{
									
								
		
									TelephonyManager telephony = (TelephonyManager) mContext
											.getSystemService(Context.TELEPHONY_SERVICE);
								Class c = Class.forName(telephony.getClass().getName());
								
								Method m = c.getDeclaredMethod("getITelephony");
								m.setAccessible(true);
								telephonyService = (ITelephony) m.invoke(telephony);
								Toast.makeText(mContext, "phno "+incomingNumber, 3000).show();
							
								telephonyService.endCall();
							
								String msg1=myshare.getString("msg", "");
								String stat=myshare.getString("stat", "");
										if(!stat.equals(incomingNumber))
										{
							android.telephony.SmsManager s1=android.telephony.SmsManager.getDefault();
							s1.sendTextMessage(incomingNumber,null,""+msg1, null, null);
							Editor myeditor = myshare.edit();
		
							myeditor.putString("stat",""+incomingNumber);
				         
							myeditor.commit();
						
								
										}
								}
							} catch (IllegalArgumentException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (IllegalAccessException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (InvocationTargetException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (ClassNotFoundException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (SecurityException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (NoSuchMethodException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
				
							
					
				} else if (state == TelephonyManager.CALL_STATE_OFFHOOK) {

					
									 }
				
				super.onCallStateChanged(state, incomingNumber);
			}
		};
		
	}


