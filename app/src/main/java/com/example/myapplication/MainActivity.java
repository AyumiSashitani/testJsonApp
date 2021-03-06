package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private String descriptionText =
            "本アプリはJSONPlaceHolderの特定のAPIにOKHTTPを用いてアクセスし、JSONの値を取得します。取得した値はjacksonでJavaオブジェクトにパースしてから画面に表示しています。" +
                    "実際に値を取得するには以下の「API実行」ボタンを押下して下さい。";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //アプリ説明テキスト表示
        final TextView descriptionView = findViewById(R.id.descriptionText);
        descriptionView.setText(descriptionText);

        //APIボタン設定
        Button apiButton = findViewById(R.id.apiButton);
        apiButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), SecondActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}