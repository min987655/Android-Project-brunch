package com.cos.brunch.network;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.cos.brunch.model.User;
import com.cos.brunch.screen.main.MainActivity;
import com.google.android.material.navigation.NavigationView;
import com.kakao.auth.ISessionCallback;
import com.kakao.auth.Session;
import com.kakao.auth.authorization.accesstoken.AccessToken;
import com.kakao.network.ErrorResult;
import com.kakao.usermgmt.UserManagement;
import com.kakao.usermgmt.callback.MeV2ResponseCallback;
import com.kakao.usermgmt.response.MeV2Response;
import com.kakao.usermgmt.response.model.Profile;
import com.kakao.usermgmt.response.model.UserAccount;
import com.kakao.util.exception.KakaoException;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SessionCallback implements ISessionCallback {

    private BrunchService brunchService = ServiceGenerator.createService(BrunchService.class);
    private static final String TAG = "SessionCallback";
    public AccessToken accessToken;
    private Context context;

    public void loginSuccese(final Context context) {
        this.context=context;
    }

    // 로그인에 성공한 상태
    @Override
    public void onSessionOpened() {
        requestMe();
    }

    // 로그인에 실패한 상태
    @Override
    public void onSessionOpenFailed(KakaoException exception) {
        Log.e("SessionCallback :: ", "onSessionOpenFailed : " + exception.getMessage());
    }

    // 사용자 정보 요청
    public void requestMe() {
        UserManagement.getInstance()
                .me(new MeV2ResponseCallback() {
                    @Override
                    public void onSessionClosed(ErrorResult errorResult) {
                        Log.d(TAG, "onSessionClosed: 세션이 닫혀있음 : " + errorResult);
                    }

                    @Override
                    public void onFailure(ErrorResult errorResult) {
                        Log.d(TAG, "onFailure: 사용자 요청 실패 : " + errorResult);
                    }

                    @Override
                    public void onSuccess(MeV2Response result) {

                        Intent intent = new Intent(context, MainActivity.class);
                        context.startActivity(intent);

                        Log.d(TAG, "onSuccess: result : " + result);
//                        Log.d(TAG, "onSuccess: result : getID : " + result.getId());
                        String info = String.valueOf(result);

                        Log.d(TAG, "onSuccess: info : " + info);
                        UserAccount kakaoAccount = result.getKakaoAccount();
                        Log.d(TAG, "onSuccess: kakaoAccount: " + kakaoAccount);

                        if (kakaoAccount != null) {

                            Profile profile = result.getKakaoAccount().getProfile();
                            String id = String.valueOf(result.getId());
                            String email = kakaoAccount.getEmail();
                            String nickname = result.getProperties().get("nickname");
                            String properties = String.valueOf(result.getProperties());
                            String kakao_account = String.valueOf(result.getKakaoAccount());

                            Log.d(TAG, "onSuccess: profile : " + profile);

                            User user = new User(kakaoAccount.getEmail());
                            Log.d(TAG, "onSuccess: user : " + user);

                            Map<String, Object> data1 = new HashMap<>();
                            data1.put("email", email);

                            Map<String, Object> data2 = new HashMap<>();
                            data2.put("nickname", nickname);

                            Map<String, Object> data = new HashMap<>();
                            data.put("id", id);
                            data.put("kakao_account",data1);
                            data.put("properties",data2);

                            Log.d(TAG, "onSuccess: body : " + info);

                            Call<String> call = brunchService.AccessToken(data);
                            call.enqueue(new Callback<String>() {
                                @Override
                                public void onResponse(Call<String> call, Response<String> response) {
                                    if (!response.isSuccessful()) {
                                        Log.d(TAG, "onResponse: 못넘김 : " + response.code());
                                        return;
                                    }
                                    Log.d(TAG, "onResponse: 넘기기 성공 : " + response.code());
                                }

                                @Override
                                public void onFailure(Call<String> call, Throwable t) {
                                    Log.d(TAG, "onFailure: " + t.getMessage());
                                }
                            });

                            // 토큰
                            accessToken = Session.getCurrentSession().getTokenInfo();

                            String acToken = accessToken.getAccessToken();
                            Log.d(TAG, "onSuccess: getAccessToken : " + acToken);
                            Log.d(TAG, "onSuccess: getRefreshToken : " + accessToken.getRefreshToken());
                        }
                    }
                });
    }
}
