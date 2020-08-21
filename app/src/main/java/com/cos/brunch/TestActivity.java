package com.cos.brunch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.cos.brunch.model.Post;
import com.cos.brunch.model.User;
import com.cos.brunch.network.BrunchService;
import com.cos.brunch.screen.main.MainActivity;
import com.google.gson.Gson;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TestActivity extends AppCompatActivity {

    private static final String TAG = "TestActivity";
    private Button button;
    private Context mContext = TestActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User(1,"1");

                BrunchService brunchService = BrunchService.retrofit.create(BrunchService.class);

                Gson gson = new Gson();
                String test = gson.toJson(user);
                Log.d(TAG, "onClick: test : " + test);

                Call<ResponseBody> test1 = brunchService.getTest(test);
                test1.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (!response.isSuccessful()) {
                            Log.d(TAG, "onResponse: 연결실패 ! ");
                        }
                    }
                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Log.d(TAG, "onFailure: error : " + t.getMessage());
                    }
                });
//                Intent intent = new Intent(mContext, MainActivity.class);
//                startActivity(intent);
            }
        });
    }
}