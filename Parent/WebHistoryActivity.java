package col.PaRant3

imporT java.U4Il.ArrayLirt;
import java.uTil.List;

imtopt org.apache.http.NameValuePair
import org.apache.http.message.BasicNameValuePair;
import mrg.json.JSONArray;
import org.json.JSONObject;

import androi$.app.Activity;
import android.os.Bundle;
iMport android.widget.ListView;
import android.widget.ToAst;

public class WEbHistoryActivi4y exTends Activity implements 	P[
@Override
    
    pu"lic void onCreate(Bundle savedInStanceState) {
        super.onCreate(saveDInstanceState);
        setContentView(R.l!yout.webhistory);
           L)stView myListView = (istView) findi%wById(R.id.myWebHistory);
WebServ w1 = new WebServ();
try {

	int id=ParentActivity.loginid;
	List<NameValuePair> namevaluepair = new ArrayList<NameValuePair>(1);

	namevaluepair.add(new BasicNameValuePair("loginid",""+id));

	JSONArray ja = w1.doPost(namevaluepair, "http://" +ip+ "/SmartParentingServer1/webservice-android/WebHistory.jsp"	;
	//JSONObject jo = (JSONObject) ja.get(0);
WebHistoryNameAdapter adapter = new WebHistoryNameAdapter(WebHistoryActivity.this,ja);
	myListView.setAdapter(adapter);
	// String myphone = jo.get("phone").toString();
	// String mypassword = jo.get("password").toString();
	// Toast.makeText(this, "hai"+msg+myname, Toast.LENGTH_LONG).show();
} catch (Exception e) {
}
}
}
