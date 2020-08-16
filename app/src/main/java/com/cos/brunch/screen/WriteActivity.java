package com.cos.brunch.write;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.cos.brunch.R;
import com.cos.brunch.posts.PostsActivity;
import com.cos.brunch.user.UserActivity;
import com.cos.brunch.userProfile.UserProfileUpdateActivity;

import java.util.ArrayList;

import xute.markdeditor.EditorControlBar;
import xute.markdeditor.MarkDEditor;
import xute.markdeditor.Styles.TextComponentStyle;
import xute.markdeditor.datatype.DraftDataItemModel;
import xute.markdeditor.models.DraftModel;
import xute.markdeditor.utilities.FilePathUtils;

import static android.graphics.Typeface.NORMAL;
import static xute.markdeditor.Styles.TextComponentStyle.BLOCKQUOTE;
import static xute.markdeditor.Styles.TextComponentStyle.H1;
import static xute.markdeditor.Styles.TextComponentStyle.H3;
import static xute.markdeditor.components.TextComponentItem.MODE_OL;
import static xute.markdeditor.components.TextComponentItem.MODE_PLAIN;

public class WriteActivity extends AppCompatActivity implements EditorControlBar.EditorControlListener {

    private static final String TAG = "WriteActivity";
    private static final int REQUEST_IMAGE_SELECTOR = 110;
    private Context mContext = WriteActivity.this;

    private ImageView imgCancel, imgWriteUpdate;
    private TextView tvToolbarHeader;
    private EditorControlBar editorControlBar;
    private MarkDEditor markDEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);

        initData();
        initObject();
        initlistener();

        markDEditor = findViewById(R.id.mdEditor);
        markDEditor.configureEditor (
                " " , // 이미지 업로드 용 서버 URL
                " " ,               // serverToken
                true ,            // isDraft : 드래프트를로드 할 때 true로 설정
                "내용을 입력하세요." , // 입력 상자의 기본 힌트
                NORMAL
        );
        markDEditor.loadDraft(getDraftContent());
        editorControlBar = findViewById(R.id.controlBar);
        editorControlBar.setEditorControlListener(this);
// 초안로드
// markDEditor.loadDraft (getDraftContent ());
        editorControlBar.setEditor (markDEditor);
    }

    private void initData() {
    }

    private void initObject() {
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

        // 저장중 알림창 떠야함 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        imgWriteUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, PostsActivity.class);
                startActivity(intent);
            }
        });
    }

    private DraftModel getDraftContent() {
        ArrayList<DraftDataItemModel> contentTypes = new ArrayList<>();
        return new DraftModel(contentTypes);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_SELECTOR) {
            if (resultCode == Activity.RESULT_OK && data != null && data.getData() != null) {
                Uri uri = data.getData();
                String filePath = FilePathUtils.getPath(this, uri);
                addImage(filePath);
            }
        }
    }

    public void addImage(String filePath) {
        markDEditor.insertImage(filePath);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String permissions[], @NonNull int[] grantResults) {
        switch (requestCode) {
            case REQUEST_IMAGE_SELECTOR:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    openGallery();
                } else {
                    //do something like displaying a message that he didn`t allow the app to access gallery and you wont be able to let him select from gallery
                    //Toast.makeText()"Permission not granted to access images.");
                }
                break;
        }
    }

    private void openGallery() {
        try {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_IMAGE_SELECTOR);
            } else {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, REQUEST_IMAGE_SELECTOR);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onInsertImageClicked() {
        openGallery();
    }

    @Override
    public void onInserLinkClicked() {
        markDEditor.addLink("Click Here", "http://www.hapramp.com");
    }
}