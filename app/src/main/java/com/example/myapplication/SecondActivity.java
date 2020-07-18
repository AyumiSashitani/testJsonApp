package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.testjson.Data;
import com.example.testjson.Service;

import org.json.JSONException;

import java.io.IOException;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

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

                            @SuppressLint("SetTextI18n")
                            @Override
                            public void run() {
                                userIdView.setText("userId : " + data.getUserId());
                                idView.setText("id : " + data.getId());
                                titleView.setText("title : " + data.getTitle());
                                bodyView.setText("body : " + data.getBody());
                            }
                        });
                    } catch (IOException | JSONException e) {
                        e.printStackTrace();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }
}
