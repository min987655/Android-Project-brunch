package com.cos.brunch.network;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.cos.brunch.dto.CommonRespDto;
import com.cos.brunch.screen.main.MainActivity;
import com.kakao.auth.ISessionCallback;
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

public class SessionCallback implements ISessionCallback {

    private BrunchService brunchService = ServiceGenerator.createService(BrunchService.class);
    private static final String TAG = "SessionCallback";
    private AccessToken accessToken;
    private Context context;

    // loginActivity context 받기위한 생성자
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


                        Log.d(TAG, "onSuccess: result : " + result);

                        UserAccount kakaoAccount = result.getKakaoAccount();

                        if (kakaoAccount != null) {

                            Profile profile = result.getKakaoAccount().getProfile();
                            String id = String.valueOf(result.getId());
                            String email = kakaoAccount.getEmail();
                            String nickname = result.getProperties().get("nickname");

//                            User user = new User(kakaoAccount.getEmail());
//                            Log.d(TAG, "onSuccess: user : " + user);

                            // 서버에 맞는 json 형태 만들어 줌.
                            Map<String, Object> data1 = new HashMap<>();
                            data1.put("email", email);

                            Map<String, Object> data2 = new HashMap<>();
                            data2.put("nickname", nickname);

                            // {id=id, kakao_account={email=email}, properties={nickname=nickname}}
                            Map<String, Object> data = new HashMap<>();
                            data.put("id", id);
                            data.put("kakao_account",data1);
                            data.put("properties",data2);
                            Log.d(TAG, "onSuccess: data : " +data);

                            Call<CommonRespDto> call = brunchService.kakaoAccess(data);
                            call.enqueue(new Callback<CommonRespDto>() {
                                @Override
                                public void onResponse(Call<CommonRespDto> call, Response<CommonRespDto> response) {
                                    if (!response.isSuccessful()) {
                                        Log.d(TAG, "onResponse: 못넘김 : " + response.code());
                                        return;
                                    }
                                    Log.d(TAG, "onResponse: 넘기기 성공 : " + response.body());

                                    CommonRespDto responseJwtToken = response.body();

                                    Object jwtToken = responseJwtToken.getData();
                                    Log.d(TAG, "onResponse: tk : " + jwtToken);

                                    // 로그인 성공시 mainActivity로 이동
                                    Intent intent = new Intent(context, MainActivity.class);
                                    intent.putExtra("jwtToken", String.valueOf(jwtToken));
                                    Log.d(TAG, "onSuccess: 메인에 넘기는 jwtToken : " + String.valueOf(jwtToken));
                                    context.startActivity(intent);
                                }

                                @Override
                                public void onFailure(Call<CommonRespDto> call, Throwable t) {
                                    Log.d(TAG, "onFailure: " + t.getMessage());
                                }
                            });

                            // 토큰
//                            accessToken = Session.getCurrentSession().getTokenInfo();
//                            String acToken = accessToken.getAccessToken();
//                            Log.d(TAG, "onSuccess: getAccessToken : " + acToken);
//                            Log.d(TAG, "onSuccess: getRefreshToken : " + accessToken.getRefreshToken());
                        }

                    }
                });
    }
}
