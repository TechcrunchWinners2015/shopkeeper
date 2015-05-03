package com.example.timzulf.myapplication;

        import android.util.*;
        import android.support.v7.app.ActionBarActivity;
        import android.os.Bundle;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.view.View;
        import android.widget.Button;
        import android.widget.TextView;
        import com.gimbal.android.Gimbal;
        import com.gimbal.android.PlaceManager;
        import com.gimbal.android.PlaceEventListener;
        import com.gimbal.android.Place;
        import com.gimbal.android.Visit;

public class StoreActivity extends ActionBarActivity{
    //Declare the views
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.store_view);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        /* nexmo/twilio call/message here */
                        Log.d("Store:","help is on the way!");
                    }
                }
        );

        Log.d("Welcome:", "Populating table...\n\n\n\n\n");

        /*insert REST api call to Zalando here */
        /* parse JSON and get relevant data */
        /*update UI, populate suggestions*/

    }

}
