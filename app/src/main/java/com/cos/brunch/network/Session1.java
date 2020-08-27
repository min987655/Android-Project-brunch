package com.cos.brunch.network;

import android.util.Log;

import com.cos.brunch.model.User;
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

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Session1 implements ISessionCallback {

    private BrunchService brunchService = ServiceGenerator.createService(BrunchService.class);
    private static final String TAG = "SessionCallback";
    public AccessToken accessToken;

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
//                        Log.d(TAG, "onSuccess: result : " + result);
//                        Log.d(TAG, "onSuccess: result : getID : " + result.getId());
                        UserAccount kakaoAccount = result.getKakaoAccount();

                        Log.d(TAG, "onSuccess: kakaoAccount: " + kakaoAccount);
                        if (kakaoAccount != null) {

                            // 이메일
//                            String email = kakaoAccount.getEmail();
//                            Log.d(TAG, "onSuccess: email : " + email);

                            Profile profile = result.getKakaoAccount().getProfile();
                            String stringProfile = profile.toString();
                            String nickname = kakaoAccount.getProfile().getNickname();
                            Log.d(TAG, "onSuccess: profile : " + profile);
                            Log.d(TAG, "onSuccess: profile : nickname : " + nickname);

/////////////////////////////////////////////////////////////////////////////////////////////////////

                            User user = new User(kakaoAccount.getEmail());
                            Log.d(TAG, "onSuccess: user : " + user);

                            Map<String, Object> data = new HashMap<>();
//                            data.put("Map-Header1", "def");
                            data.put("Authorization", profile);
                            Log.d(TAG, "onSuccess: headers : " + data);

                            Call<Object> call = brunchService.AccessToken(data);
                            call.enqueue(new Callback<Object>() {
                                @Override
                                public void onResponse(Call<Object> call, Response<Object> response) {
                                    if (!response.isSuccessful()) {
                                        Log.d(TAG, "onResponse: AccessToken : 못넘김 : " + response.code());
                                        return;
                                    }
                                    Log.d(TAG, "onResponse: AccessToken 넘기기 성공 : " + response.code());
                                }

                                @Override
                                public void onFailure(Call<Object> call, Throwable t) {
                                    Log.d(TAG, "onFailure: " + t.getMessage());
                                }
                            });

/////////////////////////////////////////////////////////////////////////////////////////////////////


                            // 토큰
//                            AccessToken accessToken;
                            accessToken = Session.getCurrentSession().getTokenInfo();

                            String acToken = accessToken.getAccessToken();
                            Log.d(TAG, "onSuccess: getAccessToken : " + acToken);
                            Log.d(TAG, "onSuccess: getRefreshToken : " + accessToken.getRefreshToken());

//                            AccessTokenRequest(kakaoAccount, accessToken);
                        }
                    }
                });
    }

//    public void AccessTokenRequest(UserAccount kakaoAccount, AccessToken accessToken) {
//
//        /// 이하 로직 실행 안됨 !
//        User user = new User(kakaoAccount.getEmail());
//        Log.d(TAG, "onSuccess: user : " + user);
//
//        Map<String, String> headers = new HashMap<>();
//        headers.put("Map-Header1", "def");
//        headers.put("Authorization", accessToken.getAccessToken());
//
//        Log.d(TAG, "onSuccess: headers : " + headers);
//
//        Call<User> call = brunchService.AccessToken(headers, user);
//        call.enqueue(new Callback<User>() {
//            @Override
//            public void onResponse(Call<User> call, Response<User> response) {
//                if (!response.isSuccessful()) {
//                    Log.d(TAG, "onResponse: AccessToken : 못넘김 : " + response.code());
//                    return;
//                }
//                Log.d(TAG, "onResponse: AccessToken 넘기기 성공 : " + response.code());
//            }
//
//            @Override
//            public void onFailure(Call<User> call, Throwable t) {
//                Log.d(TAG, "onFailure: " + t.getMessage());
//            }
//        });
//    }
}
