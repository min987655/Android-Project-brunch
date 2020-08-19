package com.cos.brunch.utils;

import android.app.Application;
import android.content.Context;

import androidx.annotation.Nullable;

import com.kakao.auth.ApprovalType;
import com.kakao.auth.AuthType;
import com.kakao.auth.IApplicationConfig;
import com.kakao.auth.ISessionConfig;
import com.kakao.auth.KakaoAdapter;
import com.kakao.auth.KakaoSDK;

// kakao SDK 사용하기위해 초기화해줘야 함
public class GlobalApplication extends Application {
    private static GlobalApplication instance;

    public static GlobalApplication getGlobalApplicationContext() {
        if (instance == null) {
            throw new IllegalStateException("카카오 상속 실패 !");
        }
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        // 카카오 SDK 초기화
        KakaoSDK.init(new kakaoSDKAdapter());
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        instance = null;
    }

    public class kakaoSDKAdapter extends KakaoAdapter {

        // 카카오 로그인 세션을 불러올 때의 설정값을 설정하는 부분.
        @Override
        public ISessionConfig getSessionConfig() {
            return new ISessionConfig() {

                //로그인을 어떤 방식으로 할지 지정
                //KAKAO_LOGIN_ALL: 모든 로그인방식을 사용하고 싶을때 지정.
                @Override
                public AuthType[] getAuthTypes() {
                    return new AuthType[] {
                            AuthType.KAKAO_LOGIN_ALL
                    };
                }

                // SDK 로그인시 사용되는 WebView에서 pause와 resume시에 Timer를 설정하여 CPU소모를 절약한다.
                // true 를 리턴할경우 webview로그인을 사용하는 화면서 모든 webview에 onPause와 onResume 시에 Timer를 설정해 주어야 한다.
                // 지정하지 않을 시 false로 설정된다.
                @Override
                public boolean isUsingWebviewTimer() {
                    return false;
                }

                // 로그인시 access token과 refresh token을 저장할 때의 암호화 여부를 결정한다.
                @Override
                public boolean isSecureMode() {
                    return false;
                }

                // 일반 사용자가 아닌 Kakao와 제휴된 앱에서만 사용되는 값으로, 값을 채워주지 않을경우 ApprovalType.INDIVIDUAL 값을 사용하게 된다.
                @Nullable
                @Override
                public ApprovalType getApprovalType() {
                    return ApprovalType.INDIVIDUAL;
                }

                // Kakao SDK 에서 사용되는 WebView에서 email 입력폼의 데이터를 저장할지 여부를 결정한다.
                // true일 경우, 다음번에 다시 로그인 시 email 폼을 누르면 이전에 입력했던 이메일이 나타난다.
                @Override
                public boolean isSaveFormData() {
                    return true;
                }
            };
        }

        // 앱이 가지고있는 정보를 얻기 위한 인터페이스
        @Override
        public IApplicationConfig getApplicationConfig() {
            return new IApplicationConfig() {
                @Override
                public Context getApplicationContext() {
                    return GlobalApplication.getGlobalApplicationContext();
                }
            };
        }
    }
}
