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
				subMap.put("id",ar.getId());
				subMap.put("title",ar.getTitle());
				subMap.put("title",ar.getTitle());
				subMap.put("title",ar.getTitle());
				subMap.put("title",ar.getTitle());
				subMap.put("title",ar.getTitle());
				subMap.put("title",ar.getTitle());
				subMap.put("title",ar.getTitle());
				subMap.put("title",ar.getTitle());
				subMap.put("title",ar.getTitle());
				subMap.put("title",ar.getTitle());
				subMap.put("title",ar.getTitle());
				subMap.put("title",ar.getTitle());
				subMap.put("title",ar.getTitle());
				subMap.put("title",ar.getTitle());
				subMap.put("title",ar.getTitle());
				subMap.put("title",ar.getTitle());
				subMap.put("title",ar.getTitle());
				subMap.put("title",ar.getTitle());
				subMap.put("title",ar.getTitle());
				subMap.put("title",ar.getTitle());
				subList.add(subMap);
			}
			result.put("articleList",subList);
			result.put("reslut", "ok");
		}catch(Exception e){
			e.printStackTrace();
			result.put("error",e.getMessage());
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
