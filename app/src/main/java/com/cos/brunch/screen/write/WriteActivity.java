package com.cos.brunch.screen.write;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Base64InputStream;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.cos.brunch.R;
import com.cos.brunch.model.Post;
import com.cos.brunch.repository.PostRepository;
import com.cos.brunch.utils.DialogCallBack;
import com.google.gson.internal.bind.util.ISO8601Utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.StringWriter;

import jp.wasabeef.richeditor.RichEditor;

// 커스텀 인터페이스 DialogCallBack 사용을 위해 implements 함
public class WriteActivity extends AppCompatActivity implements DialogCallBack {

    private static final String TAG = "Write_Activity";
    private Context mContext = WriteActivity.this;

    private ImageView imgCancel, imgWriteUpdate;
    private TextView tvToolbarHeader;
    private EditText etTitle, etSubTitle;

    private RichEditor mEditor;

    // 사진 업로드
    private String imageRealPath;
    private File tempFile;
    private static final int PICK_FROM_ALBUM = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);

        initObject();
        initlistener();
        initRichEditor();
    }

    private void initObject() {

        etTitle = findViewById(R.id.et_write_title);
        etSubTitle = findViewById(R.id.et_write_sub_title);
        mEditor = findViewById(R.id.editor);
        mEditor.setEditorHeight(200);
        mEditor.setEditorFontSize(18);
        mEditor.setEditorFontColor(Color.BLACK);
        mEditor.setEditorBackgroundColor(Color.WHITE);
        mEditor.setBackgroundColor(Color.WHITE);
        mEditor.setPadding(20, 20, 20, 20);
        mEditor.setPlaceholder("내용을 입력하세요.");

        imgCancel = findViewById(R.id.img_toolbar_l);
        tvToolbarHeader = findViewById(R.id.tv_toolbar_header);
        tvToolbarHeader.setText("글쓰기");
        imgWriteUpdate = findViewById(R.id.img_toolbar_r);
    }

    private void initlistener() {
        imgCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        imgWriteUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WriteBottomDialog bottomDialog = new WriteBottomDialog(WriteActivity.this);
                bottomDialog.show(getSupportFragmentManager(), "bottomDialog");
            }
        });
    }

    private void initRichEditor() {
        findViewById(R.id.action_bold).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditor.setBold();
            }
        });

        findViewById(R.id.action_italic).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditor.setItalic();
            }
        });

        findViewById(R.id.action_underline).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditor.setUnderline();
            }
        });

        findViewById(R.id.action_heading1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditor.setHeading(1);
            }
        });

        findViewById(R.id.action_heading2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditor.setHeading(2);
            }
        });

        findViewById(R.id.action_txt_color).setOnClickListener(new View.OnClickListener() {
            private boolean isChanged;

            @Override
            public void onClick(View v) {
                mEditor.setTextColor(isChanged ? Color.BLACK : Color.rgb(140, 140, 140));
                isChanged = !isChanged;
            }
        });

        findViewById(R.id.action_bg_color).setOnClickListener(new View.OnClickListener() {
            private boolean isChanged;

            @Override
            public void onClick(View v) {
                mEditor.setTextBackgroundColor(isChanged ? Color.rgb(255, 224, 140) : Color.rgb(228, 247, 186));
                isChanged = !isChanged;
            }
        });

        findViewById(R.id.action_align_left).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditor.setAlignLeft();
            }
        });

        findViewById(R.id.action_align_center).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditor.setAlignCenter();
            }
        });

        findViewById(R.id.action_align_right).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditor.setAlignRight();
            }
        });

        findViewById(R.id.action_blockquote).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditor.setBlockquote();
            }
        });

//        findViewById(R.id.action_insert_image).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                goToAlbum();
//                mEditor.insertImage("https://sisterhoodofstyle.com/wp-content/uploads/2018/02/no-image-1.jpg",
//                        "img");
//            }
//        });

        findViewById(R.id.action_insert_image).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToAlbum();
            }
        });

        findViewById(R.id.action_insert_link).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditor.insertLink("https://github.com/wasabeef", "testLink");
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
//        tempFile = new File(imageRealPath);  // 파일로 inPutStream
//        Log.d(TAG, "onActivityResult: tempFile : " + tempFile);

        try {
            InputStream inputStream = resolver.openInputStream(photoUri);
            Log.d(TAG, "onActivityResult: inputStream : " + inputStream);
            Bitmap imgBm = BitmapFactory.decodeStream(inputStream);
            Log.d(TAG, "onActivityResult: imgBm : " + imgBm);

            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            imgBm.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            Log.d(TAG, "onActivityResult: byteArray : " + byteArray);
            String encoded = Base64.encodeToString(byteArrayOutputStream.toByteArray(), Base64.NO_WRAP);
            Log.d(TAG, "onActivityResult: encoded : " + encoded);

            mEditor.insertImage("data:image/png;base64," + encoded, "img");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // .onClick시 실행 됨
    @Override
    public void onClick() {
        PostRepository postRepository = PostRepository.getInstance();

        Post savePost = new Post(
                etTitle.getText().toString(),
                etSubTitle.getText().toString(),
                mEditor.getHtml()
        );
        postRepository.save(savePost);
    }
}