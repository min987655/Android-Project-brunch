package com.cos.brunch.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    private int id;
    private int userId;
    private int postId;
    private String content;
    private String createDate;

    public Comment(String content) {
        this.content = content;
    }
}
