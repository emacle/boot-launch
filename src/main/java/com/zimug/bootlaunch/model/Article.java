package com.zimug.bootlaunch.model;  // 此处 model 为 package 名

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor // lombok 包， 所有参数的构造参数，不用写构造函数
@NoArgsConstructor
@Data // set,get
@Builder

public class Article {
    // GsonFormat 插件 将已有的 json转换成变量对象定义 Alt + s 快捷
    /**
     * id : 1
     * author : zimug
     * title : 手摸手教你开发spring boot
     * content : c
     * createTime :
     * reader : [{"name":"zimug","age":18},{"name":"kobe","age":37}]
     */

    private Long id;
    private String author;
    private String title;
    private String content;
    private Date createTime;
    private List<Reader> reader;

}
