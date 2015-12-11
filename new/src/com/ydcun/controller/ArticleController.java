package com.ydcun.controller;

import java.math.BigInteger;
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
import com.ydcun.common.DateUtil;
import com.ydcun.common.Util;
import com.ydcun.entity.Article;
import com.ydcun.exception.InfoException;
import com.ydcun.mysql.service.IArticleService;

import freemarker.template.utility.StringUtil;

@Controller
@RequestMapping("/articles")
public class ArticleController {
	@Autowired
    private IArticleService  articleServiceImpl;

	@SuppressWarnings("finally")
	@RequestMapping("/get")
	@ResponseBody
	public String getArticleList(@RequestBody String json)  {
		Map<String,Object> result = new HashMap<String, Object>();
		try{
			Map<String,String> map = new Gson().fromJson(json, new TypeToken<Map<String,String>>(){}.getType());
			String key = map.get("key");//"dua系统中app的key,是一个32位的字符串"
			if(Util.isEmptyString(key)){
				throw new InfoException("key 不能为空或空串");
			}
			
			String dua = map.get("dua");//"64位的整型：bigint/long long"，
			if(Util.isEmptyString(dua)){
				throw new InfoException("dua 不能为空或空串");
			}else if(!Util.isNum(dua)){
				throw new InfoException("dua 不是数字串");
			}
			BigInteger dua_id = new BigInteger(dua);
			
			String channel = map.get("channel");//int 文章类型
			if(Util.isEmptyString(channel)){
				throw new InfoException("channel 不能为空或空串");
			}else if(!Util.isNum(channel)){
				throw new InfoException("channel 不是数字串");
			}
			Integer channel_int = new Integer(channel);
			String num = map.get("num");//int 获取多少篇文章
			if(Util.isEmptyString(num)){
				throw new InfoException("num 不能为空或空串");
			}else if(!Util.isNum(num)){
				throw new InfoException("num 不是数字串");
			}
			Integer num_int = new Integer(num);
			
			String aid = map.get("aid");//int 查询数据库aid以后的文章
			if(Util.isEmptyString(aid)){
				throw new InfoException("aid 不能为空或空串");
			}else if(!Util.isNum(aid)){
				throw new InfoException("aid 不是数字串");
			}
			Integer aid_int = new Integer(aid);
			
			// 实例化 
			List<Article> arlist = articleServiceImpl.getArticleList(key, dua_id, channel, num_int, aid_int); 
			List<Map<String,Object>> subList = new ArrayList<Map<String,Object>>();
			Map<String,Object> subMap = new HashMap<String, Object>();
			for(Article ar:arlist){
				subMap.put("id",ar.getAid());//"1",
		        subMap.put("title",ar.getTitle());//"题目",
		        subMap.put("brief",ar.getBrief());//"简介",
		        subMap.put("digest",ar.getDigest());//"摘要信息",
		        subMap.put("content",ar.getContent());//"文章内容",
		        subMap.put("image",ar.getImage());//"文章缩略图路径",
		        subMap.put("keywords",ar.getKeywords());//"关键词",
		        subMap.put("istop",ar.getIstop());//"是否置顶0不置顶 1置顶",
		        subMap.put("original",ar.getOriginal());//"是否原创0否1是",
		        subMap.put("views",ar.getViews());//"阅读数量",
		        subMap.put("likes",ar.getLikes());//"点赞数",
		        subMap.put("hate",ar.getHate());//"点才数",
		        subMap.put("comments",ar.getComments());//"评论数",
		        subMap.put("status",ar.getStatus());//"状态0删除1未审核2审核未通过3审核通过",
		        subMap.put("copyfrom",ar.getCopyfrom());//"版权来自",
		        subMap.put("author",ar.getAuthor_name());//"作者名字",
		        subMap.put("time",DateUtil.getString(ar.getTime(), "yyyy-MM-dd HH:mm"));//"创建日期",
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
	
	@RequestMapping("/put")
	@ResponseBody
	public String putArticle(@RequestBody String json) throws Exception {
		Map<String,Object> result = new HashMap<String, Object>();
		String code ="";
		try{
			Map<String,String> map = new Gson().fromJson(json, new TypeToken<Map<String,String>>(){}.getType());
			String key = map.get("key");//"dua系统中app的key,是一个32位的字符串"
			if(Util.isEmptyString(key)){
				throw new InfoException("key 不能为空或空串");
			}
			
			String dua = map.get("dua");//"64位的整型：bigint/long long"，
			if(Util.isEmptyString(dua)){
				throw new InfoException("dua 不能为空或空串");
			}else if(!Util.isNum(dua)){
				throw new InfoException("dua 不是数字串");
			}
			Integer dua_id = new Integer(dua);
			String aid = map.get("aid");//int 文章id
			if(Util.isEmptyString(aid)){
				throw new InfoException("aid 不能为空或空串");
			}else if(!Util.isNum(aid)){
				throw new InfoException("aid 不是数字串");
			}
			Integer aid_int = new Integer(aid);
			
			String action = map.get("action");
			if(Util.isEmptyString(action)){
				throw new InfoException("action 不能为空或空串");
			}else if(!Util.isNum(action)){
				throw new InfoException("action 不是数字串");
			}
			if(action.equals("1")){//点击阅读
				this.articleServiceImpl.addViews(key,dua_id,aid_int);
			}else if(action.equals("2")){//文章点赞
				this.articleServiceImpl.addLike(key,dua_id,aid_int);
			}else if(action.equals("3")){//文章点踩数
				this.articleServiceImpl.addHate(key,dua_id,aid_int);
			}
			result.put("status", "ok");
		}catch(Exception e){
			e.printStackTrace();
			result.put("status", "error");
			result.put("data", e.getMessage());
		}
		return new Gson().toJson(result);
	}
	
	
}