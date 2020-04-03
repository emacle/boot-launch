package com.zimug.bootlaunch.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

@Data
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * id
     */
    @TableId(type = IdType.ID_WORKER_STR)
    private String id;

    private String author;
    private String title;
    private String content;
}
