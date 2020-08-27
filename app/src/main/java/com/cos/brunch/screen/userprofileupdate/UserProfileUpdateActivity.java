package com.cos.brunch.screen.userprofileupdate;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.cos.brunch.R;
import com.cos.brunch.screen.user.UserActivity;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserProfileUpdateActivity extends AppCompatActivity {

    private static final String TAG = "UserProUpdateActivity";
    private Context mContext = UserProfileUpdateActivity.this;

    private ImageView imgCancel, imgProfileUpdate, imgUserProfile;

    // 사진 업로드
    private String imageRealPath;
    private File tempFile;
    private static final int PICK_FROM_ALBUM = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile_update);

        initData();
        initObject();
        initlistener();
    }

    private void initData() {
    }

    private void initObject() {
        imgCancel = findViewById(R.id.img_toolbar_l);
        imgProfileUpdate = findViewById(R.id.img_toolbar_r);
        imgUserProfile = findViewById(R.id.img_user_profile);
    }

    private void initlistener() {

        imgCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, UserActivity.class);
                startActivity(intent);
            }
        });

        // 저장중 알림창 떠야함 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        imgProfileUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, UserActivity.class);
                startActivity(intent);
            }
        });

        imgUserProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: ");
                goToAlbum();
            }
        });
    }

    // 앨범으로 이동
    private void goToAlbum() {
        Intent intent = new Intent(Intent.ACTION_PICK); // 폰의 내부저장소 사진첩으로 이동
        intent.setType(MediaStore.Images.Media.CONTENT_TYPE);
        startActivityForResult(intent, PICK_FROM_ALBUM);
    }

    // URI로 이미지 실제 경로 가져오기
    private String getRealPathFromURI(Uri contentURI) {
        String result;
        Cursor cursor = getContentResolver().query(contentURI, null, null, null, null);
        if (cursor == null) { // Source is Dropbox or other similar local file path
            result = contentURI.getPath();
        } else {
            cursor.moveToFirst();
            int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
            result = cursor.getString(idx);
            cursor.close();
        }
        return result;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Uri photoUri = data.getData();
        ContentResolver resolver = getContentResolver();
        Log.d(TAG, "onActivityResult: resolver : " + resolver);

        imageRealPath = getRealPathFromURI(photoUri); // 해당경로에 저장되어있음 - 해당 경로를 DB에 저장하여 불러옴
        Log.d(TAG, "onActivityResult: imageRealPath : " + imageRealPath);

        try {
            InputStream inputStream = resolver.openInputStream(photoUri);
            Log.d(TAG, "onActivityResult: inputStream : " + inputStream);
            Bitmap imgBm = BitmapFactory.decodeStream(inputStream);
            Log.d(TAG, "onActivityResult: imgBm : " + imgBm);
            imgUserProfile.setImageBitmap(imgBm); // 이미지 채워짐
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}