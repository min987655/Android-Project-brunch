package com.cos.brunch.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostByTagRespDto {
    private String title;
    private String subTitle;
    private String coverImg;
    private String content;
    private String createDate;
    private String nickName;
    private String tag;
}
