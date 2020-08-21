package com.cos.brunch.network;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.cos.brunch.model.Post;
import com.cos.brunch.screen.main.MainActivity;
import com.kakao.auth.ISessionCallback;
import com.kakao.auth.Session;
import com.kakao.auth.authorization.accesstoken.AccessToken;
import com.kakao.network.ErrorResult;
import com.kakao.usermgmt.UserManagement;
import com.kakao.usermgmt.callback.MeV2ResponseCallback;
import com.kakao.usermgmt.response.MeV2Response;
import com.kakao.usermgmt.response.model.Profile;
import com.kakao.usermgmt.response.model.UserAccount;
import com.kakao.util.OptionalBoolean;
import com.kakao.util.exception.KakaoException;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Header;

public class SessionCallback implements ISessionCallback {

    BrunchService brunchService = BrunchService.retrofit.create(BrunchService.class);
    private static final String TAG = "SessionCallback";

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
                        Log.d(TAG, "onSuccess: result : " + result);
                        Log.d(TAG, "onSuccess: result : getID : " + result.getId());
                        UserAccount kakaoAccount = result.getKakaoAccount();
                        if (kakaoAccount != null) {

                            // 이메일
                            String email = kakaoAccount.getEmail();
                            Log.d(TAG, "onSuccess: email : " + email);

                            // 토큰
                            AccessToken accessToken;
                            accessToken = Session.getCurrentSession().getTokenInfo();
                            String acToken;
                            acToken = accessToken.getAccessToken();
                            Log.d(TAG, "onSuccess: getAccessToken : " + acToken);
                            Log.d(TAG, "onSuccess: getRefreshToken : " + accessToken.getRefreshToken());
                            brunchService.AccessToken(acToken);
                        }
                    }
                });
    }
//
//    Call<Map<String, Object>> call = brunchService.AccessToken(acToken);
//        call.
}
