package com.example.http_rest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.JsonReader;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Some url endpoint that you may have
        String myUrl = "http://143.248.140.106:2580/members";
        //String to place our result in
        String result;
        //Instantiate new instance of our class
        HttpGetRequest getRequest = new HttpGetRequest();
        //Perform the doInBackground method, passing in our url
        try {
            result = getRequest.execute(myUrl).get();
            Log.d("hoho: ", result);
            JSONObject reader = new JSONObject(result);

            String uId = reader.getString("uId");
            String age = reader.getString("age");
            String date_of_birth = reader.getString("date_of_birth");
            String job = reader.getString("job");
            String hobby = reader.getString("hobby");
            String gender = reader.getString("gender");
            String contact = reader.getString("photo");
            String gave = reader.getString("gave");
            String received = reader.getString("received");
            String success = reader.getString("success");
            String last_updated_time = reader.getString("last_updated_time");
            String residence = reader.getString("residence");

        } catch (ExecutionException e) {
            Log.e("error", "haha");
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
            Log.e("error", "haha");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
