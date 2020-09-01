package com.cos.brunch.network;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import com.cos.brunch.dto.CommonRespDto;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.JavaNetCookieJar;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Header;

public class ServiceGenerator {

    private static final String TAG = "ServiceGenerator";

    public static <S> S createService(Class<S> serviceClass){

        // json 형태로 변환 (patch시에도 null 값 덮어 씌움, gson 변환 안할 시 null은 아예 안넘어 감.)
        Gson gson = new GsonBuilder().serializeNulls().create();

        // OkHttp
//        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
//        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//
//        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                .addInterceptor(new Interceptor() { // 모든 request시 header 보내기.
//                    @NotNull
//                    @Override
//                    public okhttp3.Response intercept(@NotNull Chain chain) throws IOException {
//                        Request originalRequest = chain.request();
//                        Request newRequest = originalRequest.newBuilder()
//                                .addHeader("Authorization", "Bearer ")
//                                .build();
//                        return chain.proceed(newRequest);
//                    }
//                })
//                .addInterceptor(loggingInterceptor)
//                .build();

        // 내 주소 http://192.168.0.64:8080/brunch/
        // 민경이 주소 http://192.168.0.61:8080/brunch/
        // Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.61:8080/brunch/")
                .addConverterFactory(GsonConverterFactory.create(gson))
//                .client(okHttpClient) // client를 OkHttp로 함.
                .build();

        return retrofit.create(serviceClass);
    }
}
