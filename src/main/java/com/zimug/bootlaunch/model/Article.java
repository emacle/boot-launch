package com.zimug.bootlaunch.model;  // 此处 model 为 package 名

import com.fasterxml.jackson.annotation.*;
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


//@JsonPropertyOrder(value={"pname1","pname2"}) 改变子属性在JSON序列化中的默认定义的顺序。如：param1在先，param2在后。
//@JsonIgnore 排除某个属性不做序列化与反序列化
//@JsonProperty(anotherName) 为某个属性换一个名称，体现在JSON数据里面
//@JsonInclude(JsonInclude.Include.NON_NULL) 排除为空的元素不做序列化反序列化
//@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8") 指定日期类型的属性格式

// JsonPropertyOrder注解 改变响应返回顺序  ****写在类上面****
//{
//        "isok": true,
//        "code": 200,
//        "message": "success",
//        "data": {
//        "title": "手摸手教你开发spring boot",
//        "content": "c",
//        "createTime": null,
//        }}
// => content  在 title 前面
@JsonPropertyOrder(value = {"content", "title"})
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
    @JsonIgnore
    private Long id;  // spring boot 默认使用 Jackson , @JsonIgnore 注解 加在属性上面 序列化所反序化过程该参数会被忽略

    // @JsonProperty , 加在变量上面 属性替换 提交的 json对像里必须使用 auther 才能接收同时回传 auther
    // 但是spring boot 后端类处理的时候是使用author 变量
    @JsonProperty("auther")
    //  @JsonAlias("auther") 尽量不用 加在属性上面 变量属性替换 提交的 json对像里必须使用 auther 才能接收 但是回传的是 author
    private String author;

    private String title;
    private String content;

    // @JsonInclude(JsonInclude.Include.NON_NULL) 写在属性上面，不为空的时候才进行序列化
    @JsonInclude(JsonInclude.Include.NON_NULL)
    // @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8") // 指定日期格式 可以全局配置 Date
    private Date createTime;

    private List<Reader> reader;

}
