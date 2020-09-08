package com.cos.brunch.screen.comment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.cos.brunch.R;
import com.cos.brunch.adapter.comment.CommentAdapter;
import com.cos.brunch.adapter.now.PostHorizontal1Adapter;
import com.cos.brunch.dto.CommentRespDto;
import com.cos.brunch.dto.PostByTagRespDto;
import com.cos.brunch.model.Comment;
import com.cos.brunch.repository.CommentRepository;
import com.cos.brunch.screen.now.NowActivity;
import com.cos.brunch.viewmodel.CommentViewModel;
import com.cos.brunch.viewmodel.PostsViewModel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommentActivity extends AppCompatActivity {

    private static final String TAG = "CommentActivity";
    private Context mContext = CommentActivity.this;
    private ImageView imgCancel;
    private TextView tvHeader;
    private EditText etReply;
    private Button btnReplySave;
    private InputMethodManager imm;

    private CommentAdapter commentAdapter;
    private RecyclerView rvCommnet;
    private CommentViewModel commentViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);

        initObject();
        initDesign();
        initData();
        initListener();
    }

    private void initObject(){
        imgCancel = findViewById(R.id.img_toolbar_l);
        imgCancel.setImageResource(R.drawable.img_cancel);

        tvHeader =findViewById(R.id.tv_toolbar_header);
        tvHeader.setText("댓글");

        btnReplySave = findViewById(R.id.btn_reply_update);
        etReply =findViewById(R.id.et_reply);

        imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE); // 키보드 객체 받아오기
//      imm.showSoftInput(etReply, 0); // 키보드 보이기
        rvCommnet = findViewById(R.id.rv_comment);
    }

    private void initDesign(){

    }

    private void initData() {
        commentAdapter = new CommentAdapter();
        rvCommnet.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
        rvCommnet.scrollToPosition(commentAdapter.getItemCount() - 1);
        rvCommnet.setAdapter(commentAdapter);

        commentViewModel = new ViewModelProvider(CommentActivity.this).get(CommentViewModel.class);
        commentViewModel.CommentDto구독하기().observe(CommentActivity.this, new Observer<List<CommentRespDto>>() {
            @Override
            public void onChanged(List<CommentRespDto> commentRespDtos) {
                Log.d(TAG, "onChanged: 구독하고있는 데이터가 변경되었습니다." + commentRespDtos);
                commentAdapter.setCommentRespDto(commentRespDtos);
            }
        });
    }

        private void initListener(){
        imgCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnReplySave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CommentRepository commentRepository = CommentRepository.getInstance();

                Comment saveComment = new Comment(
                        etReply.getText().toString()
                );

                int postId = 14;

                SharedPreferences sf = getSharedPreferences("test",MODE_PRIVATE);
                String serverJwtToken = sf.getString("jwtToken", "");

                Map<String, Object> headerJwtToken = new HashMap<>();
                headerJwtToken.put("Authorization", "Bearer "+serverJwtToken);
                Log.d(TAG, "onClick: headerJwtToken : " + headerJwtToken);

                commentRepository.save(headerJwtToken, saveComment, postId);
                imm.hideSoftInputFromWindow(etReply.getWindowToken(), 0 ); // 키보드 숨기기
                etReply.getText().clear();
            }
        });
    }
}