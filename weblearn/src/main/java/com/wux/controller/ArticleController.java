package com.wux.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wux.entity.Article;
import com.wux.entity.PageData;
import com.wux.entity.TrollImage;
import com.wux.service.ArticleService;

@Controller
@RequestMapping("article")
public class ArticleController {
	@Autowired
	private ArticleService articleService;

	@RequestMapping("showArticle")
	public Article showArticle(String id){
		Article article = articleService.selectByPrimaryKey(id);
		return article;
	}

	@RequestMapping("insertArticle")
	public String insertArticle(Article article){
		articleService.insertSelective(article);
		return "ok";
	}

	@RequestMapping("removeArticle")
	@ResponseBody
	public String removeArticle(String id){
		articleService.deleteByPrimaryKey(id);
		return "ok";
	}
	
	@RequestMapping("showAll")
	@ResponseBody
	public <T> PageData<T> showTrollImage(Integer page, Integer rows){    // 展示轮播图
		PageData<T> pageData = new PageData<T>();
		List<Article> list = articleService.selectByPage(page, rows);
		pageData.setRows((List<T>) list);
		pageData.setTotal(articleService.countByExample());
		return pageData;
	}
}
