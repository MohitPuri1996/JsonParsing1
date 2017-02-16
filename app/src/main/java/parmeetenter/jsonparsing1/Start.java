package parmeetenter.jsonparsing1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Start extends AppCompatActivity implements View.OnClickListener {
Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
    login=(Button)findViewById(R.id.login);
        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v==login)
        {
            Intent intent=new Intent(Start.this,MainActivity.class);
            startActivity(intent);
        }
    }
}
