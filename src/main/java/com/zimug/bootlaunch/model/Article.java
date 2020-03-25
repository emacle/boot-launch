package com.zimug.bootlaunch.model;  // 此处 model 为 package 名

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
//    private String title;
//    private String content;
//    private String createTime;
//    private List<ReaderBean> reader;
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getAuthor() {
//        return author;
//    }
//
//    public void setAuthor(String author) {
//        this.author = author;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getContent() {
//        return content;
//    }
//
//    public void setContent(String content) {
//        this.content = content;
//    }
//
//    public String getCreateTime() {
//        return createTime;
//    }
//
//    public void setCreateTime(String createTime) {
//        this.createTime = createTime;
//    }
//
//    public List<ReaderBean> getReader() {
//        return reader;
//    }
//
//    public void setReader(List<ReaderBean> reader) {
//        this.reader = reader;
//    }
//
//    public static class ReaderBean {
//        /**
//         * name : zimug
//         * age : 18
//         */
//
//        private String name;
//        private int age;
//
//        public String getName() {
//            return name;
//        }
//
//        public void setName(String name) {
//            this.name = name;
//        }
//
//        public int getAge() {
//            return age;
//        }
//
//        public void setAge(int age) {
//            this.age = age;
//        }
//    }


}
