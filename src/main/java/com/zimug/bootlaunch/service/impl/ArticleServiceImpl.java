package com.zimug.bootlaunch.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zimug.bootlaunch.entity.Article;
import com.zimug.bootlaunch.mapper.ArticleMapper;
import com.zimug.bootlaunch.service.ArticleService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

    @Override
    public List<Article> getArticleList() {

        List<Article> articleList = baseMapper.getArticleList();
        return articleList;

    }
}
