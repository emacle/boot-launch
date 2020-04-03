package com.zimug.bootlaunch.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zimug.bootlaunch.entity.Article;

import java.util.List;

public interface ArticleService extends IService<Article> {

    List<Article> getArticleList();

}
