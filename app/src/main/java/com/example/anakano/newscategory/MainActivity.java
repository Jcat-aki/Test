package com.example.anakano.newscategory;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // テキストビューを呼び出し、設定したidからビューを呼び出す。（インスタンスの格納）
        TextView textView = (TextView) findViewById(R.id.main_api_response);
        // ここでテキストビューに仮の文字を入力する。（最後にはプログレスダイアログを作成）
        textView.setText("hogehoge");

        try {
            final URL url = new URL("https://hacker-news.firebaseio.com/v0/topstories.json?print=pretty");
            DownloadTasks downloadTasks = (DownloadTasks) new DownloadTasks(new ProgressDialog(this),textView).execute(url);
        } catch (MalformedURLException e) {
            textView.setText(e.toString());
            e.printStackTrace();
        }
    }
}
