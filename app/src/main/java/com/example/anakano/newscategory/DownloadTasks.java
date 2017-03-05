package com.example.anakano.newscategory;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by anakano on 17/03/05.
 */

public class DownloadTasks extends AsyncTask<URL, Integer, String> {

    private ProgressDialog mProgressDialog;
    private TextView mTextView;

    /**
     * コンストラクタ
     * @param progressDialog 進捗状況を表示するダイアログを表示
     */
    public DownloadTasks(ProgressDialog progressDialog, TextView textView){
        super();
        mProgressDialog = progressDialog;
        mTextView = textView;
    }

    /**
     * UIスレッド上で動くが、doInBackgroundが呼ばれる前に動くため、初期化に最適
     */
    @Override
    protected void onPreExecute() {
        // とりあえず、よんでおくだけ
        System.out.print("hogehoge");

        mProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        mProgressDialog.setIndeterminate(false);
        mProgressDialog.show();
    }

    /**
     * このメソッドは、UIスレッド以外で処理ができるようにするために、使われます。<br>
     * そのためダウンロード中もユーザが画面を触って動作できるようになる利点があります。
     * @param urls
     * @return ダウンロードした結果を返す
     */
    @Override
    protected String doInBackground(URL... urls) {
        String result = "";
        HttpURLConnection httpURLConnection = null;

        try{
            httpURLConnection = (HttpURLConnection) urls[0].openConnection();
            httpURLConnection.setReadTimeout(1000);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setDoInput(true);
            httpURLConnection.connect();
            int resp = httpURLConnection.getResponseCode();

            StringBuffer sb = new StringBuffer();
            String readLine = "";
            BufferedReader br = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            while ( (readLine = br.readLine()) != null){
                sb.append(readLine);
            }

            result = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * doInBackground中に呼ばれて進捗状況を逐次報告してくれる最高なメソッド<br>
     * こいつは、UIメソッド上で動くよ
     * @param progress 進捗状況の数値
     */
    @Override
    protected void onProgressUpdate( Integer... progress){
        mProgressDialog.incrementProgressBy(progress[0]);
    }

    /**
     * doInBackgroundが完了したらよばれるやつ。UIスレッド上で動く。
     * @param result 結果
     */
    @Override
    protected void onPostExecute( String result){
        mProgressDialog.dismiss();

        mTextView.setText(result);
    }
}
