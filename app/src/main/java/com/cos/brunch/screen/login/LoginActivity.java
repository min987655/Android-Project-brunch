package com.cos.brunch.screen.login;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.cos.brunch.R;
import com.cos.brunch.network.SessionCallback;
import com.cos.brunch.screen.main.MainActivity;
import com.kakao.auth.AuthType;
import com.kakao.auth.ISessionCallback;
import com.kakao.auth.Session;
import com.kakao.auth.authorization.accesstoken.AccessToken;
import com.kakao.network.ErrorResult;
import com.kakao.usermgmt.UserManagement;
import com.kakao.usermgmt.callback.LogoutResponseCallback;
import com.kakao.usermgmt.callback.MeV2ResponseCallback;
import com.kakao.usermgmt.response.MeV2Response;
import com.kakao.usermgmt.response.model.UserAccount;
import com.kakao.util.exception.KakaoException;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "LoginActivity";

    private SessionCallback sessionCallback = new SessionCallback();
    private Session session;
    private Context mContext = LoginActivity.this;

    private Button btn_custom_login;
//    private Button btn_custom_login_out;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        session = Session.getCurrentSession();
        session.addCallback(sessionCallback);
//      session.getCurrentSession().checkAndImplicitOpen(); // 토큰 만료시 자동 갱신

        initObject();
        initListener();
        printHashKey(this);

        sessionCallback.onSessionOpened();
    }

    private void initObject(){
        btn_custom_login = findViewById(R.id.btn_custom_login);
//        btn_custom_login_out = findViewById(R.id.btn_custom_login_out);
    }

    private void initListener(){
        btn_custom_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                session.open(AuthType.KAKAO_LOGIN_ALL, LoginActivity.this);
            }
        });

//        btn_custom_login_out.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                UserManagement.getInstance()
//                        .requestLogout(new LogoutResponseCallback() {
//                            @Override
//                            public void onCompleteLogout() {
//                                Toast.makeText(LoginActivity.this, "로그아웃 되었습니다.", Toast.LENGTH_SHORT).show();
//                            }
//                        });
//            }
//        });
    }

    public static void printHashKey(Context pContext) {
        try {
            PackageInfo info = pContext.getPackageManager().getPackageInfo(pContext.getPackageName(), PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                String hashKey = new String(Base64.encode(md.digest(), 0));
                Log.i(TAG, "printHashKey() Hash Key: " + hashKey);
            }
        } catch (NoSuchAlgorithmException e) {
            Log.e(TAG, "printHashKey()", e);
        } catch (Exception e) {
            Log.e(TAG, "printHashKey()", e);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        // 세션 콜백 삭제
        Session.getCurrentSession().removeCallback(sessionCallback);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        // 카카오톡|스토리 간편로그인 실행 결과를 받아서 SDK로 전달
        if (Session.getCurrentSession().handleActivityResult(requestCode, resultCode, data)) {
            return;
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    private class SessionCallback implements ISessionCallback {

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
                            Intent intent = new Intent(mContext, MainActivity.class);
                            startActivity(intent);
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
                                Log.d(TAG, "onSuccess: getAccessToken : " + accessToken.getAccessToken());
                                Log.d(TAG, "onSuccess: getRefreshToken : " + accessToken.getRefreshToken());
                            }
                        }
                    });
        }
    }


}