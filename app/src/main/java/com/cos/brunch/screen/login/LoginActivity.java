package com.cos.brunch.screen.login;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.cos.brunch.R;
import com.cos.brunch.network.SessionCallback;
import com.kakao.auth.AuthType;
import com.kakao.auth.Session;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "LoginActivity";

    private SessionCallback sessionCallback = new SessionCallback();
    private Session session;
    private Context mContext = LoginActivity.this;

    private Button btn_custom_login;

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
        setupMainView();

        sessionCallback.onSessionOpened();
    }

    private void initObject(){
        btn_custom_login = findViewById(R.id.btn_custom_login);
    }

    private void initListener(){
        btn_custom_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                session.open(AuthType.KAKAO_LOGIN_ALL, LoginActivity.this);
            }
        });
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

    public void setupMainView() {
        sessionCallback.loginSuccese(mContext);
    }


}