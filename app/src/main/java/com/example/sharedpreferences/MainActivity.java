package com.example.sharedpreferences;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivityTAG_";

    private String mUrl = "http://www.mocky.io/v2/57a4dfb40f0000821dc9a3b8";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void doMagic(View view) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(mUrl)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                Gson gson = new GsonBuilder().create();
                Type listType = new TypeToken<List<Student>>() {
                }.getType();

                ArrayList<Student> students = gson.fromJson(json, listType);
                for (Student student : students) {
                    Log.d(TAG, "onResponse: " + student.toString());
                }
            }
        });
    }
}