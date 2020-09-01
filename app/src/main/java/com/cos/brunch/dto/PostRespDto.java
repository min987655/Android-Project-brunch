package com.cos.brunch.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostRespDto {
    private int id;
    private String title;
    private String content;
    private String nickName;
    private String createDate;
}
