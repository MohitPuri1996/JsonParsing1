package parmeetenter.jsonparsing1;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static android.content.ContentValues.TAG;
import static android.widget.Toast.*;
import static parmeetenter.jsonparsing1.R.id.sid;

public class MainActivity extends AppCompatActivity {
TextView sid,name,email,phone;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    btn= (Button) findViewById(R.id.btn);
        sid=(TextView)findViewById(R.id.sid);
        name=(TextView)findViewById(R.id.name);
        email=(TextView)findViewById(R.id.email);
        phone=(TextView)findViewById(R.id.phone);

btn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        new JSONTASK().execute("http://bindyaboutique.com/AndroidData/GetAll.php");
    }
});



    }
class JSONTASK extends AsyncTask<String,String,String>{
    HttpURLConnection connection;
    BufferedReader reader;
    @Override
    protected String doInBackground(String... param) {
try {
    URL url = new URL(param[0]);
    connection=(HttpURLConnection)url.openConnection();
    connection.connect();

    InputStream stream =connection.getInputStream();
    reader=new BufferedReader(new InputStreamReader(stream));
StringBuffer buff=new StringBuffer();
String line="";
    while((line=reader.readLine())!=null){
        buff.append(line);
    }

String finaljson= buff.toString();
    JSONArray array=new JSONArray(finaljson);
    JSONObject obj1=(JSONObject)array.get(0);

return obj1.get("name").toString()+";"+obj1.get("sid").toString()+";"+obj1.get("email").toString()+";"+obj1.get("phno").toString();
}catch(Exception e){
    Log.d(TAG, "doInBackground: "+e);
}
        finally {
    if(connection!=null){
        connection.disconnect();
    }
    try{
        if(reader!=null){
            reader.close();
        }
    }catch (Exception e){

    }
        }
        return null;
    }

    @Override
    protected void onPostExecute(String result) {

        super.onPostExecute(result);
        if(result!=null){
        try {

            System.out.println("mohit");
            String[] sss = result.split(";");
            name.setText(sss[1]);
            System.out.println("mohit 1");
            sid.setText(sss[2]);
            email.setText(sss[3]);
            phone.setText(sss[4]);
        }catch(Exception e){
            System.out.println(e);
        }}
        else{
          Toast.makeText(getApplicationContext(),"i this is mohit puri",Toast.LENGTH_SHORT);

        }

    }
}}
