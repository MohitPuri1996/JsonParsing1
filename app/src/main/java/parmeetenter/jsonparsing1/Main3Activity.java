package parmeetenter.jsonparsing1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class Main3Activity extends AppCompatActivity {
    List l;
    String sid[];
    String data[];
    ArrayAdapter<String> adapter;
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);



        lv= (ListView) findViewById(R.id.list);



    }
}
