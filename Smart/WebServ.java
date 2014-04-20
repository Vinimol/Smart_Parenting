package smart.com;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;

import android.util.Log;

public class WebServ {
	public JSONArray doPost(List<NameValuePair> namevaluepair,String url) {
		JSONArray myArray = null;
		HttpClient myClient = new DefaultHttpClient();
		HttpPost post = new HttpPost(url);
		try {

			post.setEntity(new UrlEncodedFormEntity(namevaluepair));
			HttpResponse response = myClient.execute(post);
			Log.i("response",""+ namevaluepair);
			String line = "";
			
			StringBuilder totalString = new StringBuilder();

			BufferedReader br = new BufferedReader(new InputStreamReader(
					response.getEntity().getContent()));
			while ((line = br.readLine()) != null) {
				totalString.append(line);
			}
			
			myArray = new JSONArray(totalString.toString());
			Log.e("t1",""+myArray);
		} catch (Exception e) {
			//Log.i("r",""+ e);
			e.printStackTrace();
		}
		return myArray;
	}
}
