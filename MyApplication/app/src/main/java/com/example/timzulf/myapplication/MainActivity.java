package com.example.timzulf.myapplication;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.gimbal.android.Gimbal;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {
//Declare the views
    TextView main_text;
    Button main_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Access the views defined in the layout Xml
        main_text=(TextView)findViewById(R.id.main_text);
        main_button=(Button)findViewById(R.id.main_button);

        main_button.setOnClickListener(this);
    }



    @Override
    public void onClick(View v){
        main_text.setText("I am at the");
    }


}
