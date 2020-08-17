package com.cos.brunch.screen;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.cos.brunch.R;

import jp.wasabeef.richeditor.RichEditor;

public class WriteActivity extends AppCompatActivity {

    private static final String TAG = "WriteActivity";
    private Context mContext = WriteActivity.this;

    private ImageView imgCancel, imgWriteUpdate;
    private TextView tvToolbarHeader;

    private RichEditor mEditor;
    private TextView mPreview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);

        initData();
        initObject();
        initlistener();

        mEditor = (RichEditor) findViewById(R.id.editor);
        mEditor.setEditorHeight(200);
        mEditor.setEditorFontSize(18);
        mEditor.setEditorFontColor(Color.BLACK);
        mEditor.setEditorBackgroundColor(Color.WHITE);
        mEditor.setBackgroundColor(Color.WHITE);
        mEditor.setPadding(20, 20, 20, 20);
        mEditor.setPlaceholder("내용을 입력하세요.");

//        mPreview = (TextView) findViewById(R.id.preview);
//        mEditor.setOnTextChangeListener(new RichEditor.OnTextChangeListener() {
//            @Override public void onTextChange(String text) {
//                mPreview.setText(text);
//            }
//        });

        findViewById(R.id.action_bold).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                mEditor.setBold();
            }
        });

        findViewById(R.id.action_italic).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                mEditor.setItalic();
            }
        });

        findViewById(R.id.action_underline).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                mEditor.setUnderline();
            }
        });

        findViewById(R.id.action_heading1).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                mEditor.setHeading(1);
            }
        });

        findViewById(R.id.action_heading2).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                mEditor.setHeading(2);
            }
        });

        findViewById(R.id.action_txt_color).setOnClickListener(new View.OnClickListener() {
            private boolean isChanged;

            @Override public void onClick(View v) {
                mEditor.setTextColor(isChanged ? Color.BLACK : Color.rgb(140, 140, 140));
                isChanged = !isChanged;
            }
        });

        findViewById(R.id.action_bg_color).setOnClickListener(new View.OnClickListener() {
            private boolean isChanged;

            @Override public void onClick(View v) {
                mEditor.setTextBackgroundColor(isChanged ? Color.rgb(255,224,140 ) : Color.rgb(228,247,186));
                isChanged = !isChanged;
            }
        });

        findViewById(R.id.action_align_left).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                mEditor.setAlignLeft();
            }
        });

        findViewById(R.id.action_align_center).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                mEditor.setAlignCenter();
            }
        });

        findViewById(R.id.action_align_right).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                mEditor.setAlignRight();
            }
        });

        findViewById(R.id.action_blockquote).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                mEditor.setBlockquote();
            }
        });

        findViewById(R.id.action_insert_image).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                mEditor.insertImage("https://sisterhoodofstyle.com/wp-content/uploads/2018/02/no-image-1.jpg",
                        "dachshund");
            }
        });

        findViewById(R.id.action_insert_link).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                mEditor.insertLink("https://github.com/wasabeef", "wasabeef");
            }
        });
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


}