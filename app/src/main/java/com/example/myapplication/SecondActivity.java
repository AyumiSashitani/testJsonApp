package com.example.myapplication;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.testjson.Data;
import com.example.testjson.Service;

import org.json.JSONException;

import java.io.IOException;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try  {
                    Service service = new Service();
                    try {
                        //通信処理実施
                        final Data data = service.execute();

                        final TextView userIdView = findViewById(R.id.userIdText);
                        final TextView idView = findViewById(R.id.idText);
                        final TextView titleView = findViewById(R.id.titleText);
                        final TextView bodyView = findViewById(R.id.bodyText);

                        runOnUiThread(new Runnable() {

                            @Override
                            public void run() {

                                userIdView.setText("userId : " + data.getUserId());
                                idView.setText("id : " + data.getId());
                                titleView.setText("title : " + data.getTitle());
                                bodyView.setText("body : " + data.getBody());
                                // Stuff that updates the UI

                            }
                        });

                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    //Your code goes here
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
