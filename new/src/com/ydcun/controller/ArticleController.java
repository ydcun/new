package com.ydcun.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ydcun.entity.Article;
import com.ydcun.exception.InfoException;
import com.ydcun.mysql.service.IArticleService;

import freemarker.template.utility.StringUtil;

@Controller
@RequestMapping("/article")
public class ArticleController {
	@Autowired
    private IArticleService  articleServiceImpl;

	@SuppressWarnings("finally")
	@RequestMapping("/getArticleList")
	@ResponseBody
	public String getArticleList(@RequestBody String json)  {
		Map<String,Object> result = new HashMap<String, Object>();
		try{
			Map<String,String> map = new Gson().fromJson(json, new TypeToken<Map<String,String>>(){}.getType());
			String code = map.get("code");
			List<Article> arlist =null;
			if(code==null || code.equals("")){
				throw new InfoException("code 不能为空或空串");
			}
			// 实例化 
			arlist = articleServiceImpl.findAllArticleByCode(code); 
			List<Map<String,Object>> subList = new ArrayList<Map<String,Object>>();
			Map<String,Object> subMap = new HashMap<String, Object>();
			for(Article ar:arlist){
				subMap.put("id",ar.getAid());//"1",
		        subMap.put("title",ar.getTitle());//"题目",
		        subMap.put("brief",ar.getBrief());//"简介",
		        subMap.put("digest",ar.getDigest());//"摘要信息",
		        subMap.put("content",ar.getContent());//"文章内容",
		        subMap.put("image"),ar.getImage();//"文章缩略图路径",
		        subMap.put("keywords");//"关键词",
		        subMap.put("istop");//"是否置顶0不置顶 1置顶",
		        subMap.put("original");//"是否原创0否1是",
		        subMap.put("views");//"阅读数量",
		        subMap.put("likes");//"点赞数",
		        subMap.put("hate");//"点才数",
		        subMap.put("comments");//"评论数",
		        subMap.put("status");//"状态0删除1未审核2审核未通过3审核通过",
		        subMap.put("copyfrom");//"版权来自",
		        subMap.put("author");//"作者名字",
		        subMap.put("time");//"创建日期",
				subList.add(subMap);
			}
			result.put("data",subList);
			result.put("status", "ok");
		}catch(Exception e){
			e.printStackTrace();
			result.put("status", "error");
			result.put("data",e.getMessage());
		}finally {
			return new Gson().toJson(result);
		}
	}
	
	@RequestMapping("/test")
	@ResponseBody
	public String getArticleListTest(@RequestBody String json) throws Exception {
		Map<String,Object> result = new HashMap<String, Object>();
		String code ="";
		try{
		Map<String,String> map = new Gson().fromJson(json, new TypeToken<Map<String,String>>(){}.getType());
		code = map.get("code");
		result.put("code", code);
		}catch(Exception e){
			e.printStackTrace();
			result.put("error", e.getMessage());
		}
		return new Gson().toJson(result);
	}
	
	
}
