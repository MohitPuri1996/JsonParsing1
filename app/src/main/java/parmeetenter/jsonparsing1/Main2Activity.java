package parmeetenter.jsonparsing1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

import java.util.List;

public class Main2Activity extends AppCompatActivity {
Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        b1= (Button) findViewById(R.id.button);
        b2= (Button) findViewById(R.id.button2);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
Intent i=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });


        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),Main3Activity.class);
                startActivity(i);
            }
        });
    }
}
