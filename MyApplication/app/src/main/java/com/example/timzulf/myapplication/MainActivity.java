package com.example.timzulf.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.gimbal.android.Gimbal;
import com.gimbal.android.Place;
import com.gimbal.android.PlaceEventListener;
import com.gimbal.android.PlaceManager;
import com.gimbal.android.Visit;

import android.content.Intent;
import android.view.ViewGroup;
import android.transition.Fade;
import android.transition.TransitionManager;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {
    //Declare the views
    TextView main_text;
    Button button2;
    private ViewGroup mRootView;
    private PlaceEventListener placeEventListener;
    private TextView text;
    //Log.d("Welcome:","creating intent ");

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        final Intent intent = new Intent(this, StoreActivity.class);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.opening);

        //set transition info
        mRootView = (ViewGroup) findViewById(R.id.opening);
        text = (TextView) findViewById(R.id.text);
        button2 = (Button) findViewById(R.id.button2);
        button2.setVisibility(View.VISIBLE);
        button2.setBackgroundColor(Color.TRANSPARENT);
        button2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                TransitionManager.beginDelayedTransition(mRootView, new Fade());
                toggleVisibility(text);
                //Gimbal.resetApplicationInstanceIdentifier();
                startActivity(intent);
            }
        });

        //set gimbal api key
        Log.d("Welcome:", "Setting API key...\n\n\n\n\n");
        Gimbal.setApiKey(this.getApplication(), "31c1c470-a53e-4ba1-a629-3f61830d37ba");
        //System.exit(0);
        placeEventListener = new PlaceEventListener() {
            @Override
            public void onVisitStart(Visit visit) {
                //when a place is entered

                PlaceManager.getInstance().stopMonitoring();
                Place p = visit.getPlace();
                String name = p.getName();

                //check name of beacon
                if (true) {
                    //etc

                    Log.d("Welcome:", "\n\n\n\n\nEntering: " + name);
                }
                //android.os.SystemClock.sleep(1000);
                TransitionManager.beginDelayedTransition(mRootView, new Fade());
                toggleVisibility(text);
                //Gimbal.resetApplicationInstanceIdentifier();
                startActivity(intent);


            }

            @Override
            public void onVisitEnd(Visit visit) {
                //when a place is exited
                //notify user "thanks for shopping at Zalando!

            }
        };


        PlaceManager.getInstance().addListener(placeEventListener);
        //begin monitoring for place entries
        PlaceManager.getInstance().startMonitoring();
        if (PlaceManager.getInstance().isMonitoring()) Log.d("Welcome:", "monitoring...");
        //Access the views defined in the layout Xml
        //main_text=(TextView)findViewById(R.id.);
        //main_button=(Button)findViewById(R.id.main_button);


    }

    private static void toggleVisibility(View... views){
        for (View view : views){
            boolean isVisible = view.getVisibility() == View.VISIBLE;
            view.setVisibility(isVisible ? View.INVISIBLE : View.VISIBLE);
        }

    }
    @Override
    public void onClick(View v) {
        main_text.setText("I am at the");
    }


}
