package com.zimug.bootlaunch.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zimug.bootlaunch.entity.Article;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ArticleMapper extends BaseMapper<Article> {

    @Select("select * from article;")
    List<Article> getArticleList();


}
