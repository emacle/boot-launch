package com.zimug.bootlaunch.model;  // 此处 model 为 package 名

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor // lombok 包， 所有参数的构造参数，不用写构造函数
@NoArgsConstructor
@Data // set,get
@Builder

public class Article {
    private Long id;

    private String author;
}
