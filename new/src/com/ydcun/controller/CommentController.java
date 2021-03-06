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
import com.ydcun.entity.Comment;
import com.ydcun.exception.InfoException;
import com.ydcun.mysql.service.IArticleService;
import com.ydcun.mysql.service.ICommentService;


@Controller
@RequestMapping("/comments")
public class CommentController {
	@Autowired
    private ICommentService  commentServiceImpl;

	@SuppressWarnings("finally")
	@RequestMapping("/get")
	@ResponseBody
	public String getCommentList(@RequestBody String json)  {
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
			}
			BigInteger dua_id = new BigInteger(dua);
			
			String aid = map.get("aid");//"文章的类型。int型数字"，
			if(Util.isEmptyString(aid)){
				throw new InfoException("page 不能为空或空串");
			}
			Integer aid_int = new Integer(aid);
			
			String page = map.get("page");//"文章的类型。int型数字"，
			if(Util.isEmptyString(page)){
				throw new InfoException("page 不能为空或空串");
			}
			Integer page_int = new Integer(page);
			
			String num = map.get("num");//"int整形，要获取最近的多少篇文章",
			if(Util.isEmptyString(num)){
				throw new InfoException("num 不能为空或空串");
			}
			Integer num_int = new Integer(num);
			
			List<Comment> commlist =null;
			//获取某文章的评论信息
			commlist = commentServiceImpl.getArticleList(key,dua_id,aid_int,page_int,num_int); 
			if(commlist==null){
				throw new InfoException("没有查到数据");
			}
 			List<Map<String,Object>> subList = new ArrayList<Map<String,Object>>();
			Map<String,Object> subMap = null;
			for(Comment comm:commlist){
				subMap  = new HashMap<String, Object>();
				subMap.put("id",comm.getId());//"1",
		        subMap.put("content",comm.getContent());//"评论内容",
		        subMap.put("time",DateUtil.getString(comm.getTime(),"yyyy-MM-dd HH:mm"));//"发布时间",
		        subMap.put("userid",comm.getUserid());//"评论用户dua_id",
		        subMap.put("username",comm.getUsername());//"评论用户名",
		        subMap.put("locaction",comm.getLocation());//"评论地点",
		        subMap.put("lkie",comm.getLikes());//"点赞数",
		        subMap.put("hate",comm.getHate());//"点踩数",
				subList.add(subMap);
			}
			result.put("status", "ok");
			result.put("data",subList);
		}catch(Exception e){
			e.printStackTrace();
			result.put("status", "error");
			result.put("data",e.getMessage());
		}finally {
			return new Gson().toJson(result);
		}
	}
	@SuppressWarnings("finally")
	@RequestMapping("/post")
	@ResponseBody
	public String postCommentList(@RequestBody String json)  {
		Map<String,Object> result = new HashMap<String, Object>();
		try{
			Map<String,String> map = new Gson().fromJson(json, new TypeToken<Map<String,String>>(){}.getType());
			
			String key = map.get("key");//"dua系统中app的key,是一个32位的字符串"
			if(Util.isEmptyString(key)){
				throw new InfoException("key 不能为空或空串");
			}
			
			String article_id = map.get("aid");//"文章的id int型数字"，
			if(Util.isEmptyString(article_id)){
				throw new InfoException("aid 不能为空或空串");
			}
			Integer aid = new Integer(article_id);
			
			String content = map.get("content");//"评论内容
			if(Util.isEmptyString(content)){
				throw new InfoException("content 不能为空或空串");
			}
			
			String userid = map.get("dua");//"评论用户dua_id
			if(Util.isEmptyString(content)){
				throw new InfoException("dua 不能为空或空串");
			}else if(!Util.isNum(userid)){
				throw new InfoException("dua 不是数字串");
			}
			BigInteger userid_int = new BigInteger(userid);
			
			String username = map.get("username");//"评论用户名
			if(Util.isEmptyString(username)){
				throw new InfoException("username 不能为空或空串");
			}
			
			String location = map.get("location");//"评论地点
			if(Util.isEmptyString(location)){
				throw new InfoException("lonlat 不能为空或空串");
			}
			
			String lonlat = map.get("lonlat");//"评论地点经纬度
			if(Util.isEmptyString(lonlat)){
				throw new InfoException("lonlat 不能为空或空串");
			}
			
			String ip = map.get("ip");//"评论客户端ip地址
			if(Util.isEmptyString(ip)){
				throw new InfoException("ip 不能为空或空串");
			}
			this.commentServiceImpl.addComment(key,aid,content,userid_int,username,location,lonlat,ip);
			
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
	public String putComment(@RequestBody String json) throws Exception {
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
			
			String article_id = map.get("aid");
			if(Util.isEmptyString(article_id)){
				throw new InfoException("aid 不能为空或空串");
			}else if(!Util.isNum(article_id)){
				throw new InfoException("aid 不是数字串");
			}
			Integer article_int = new Integer(article_id);
			
			String comment_id = map.get("cid");
			if(Util.isEmptyString(comment_id)){
				throw new InfoException("cid 不能为空或空串");
			}else if(!Util.isNum(comment_id)){
				throw new InfoException("cid 不是数字串");
			}
			Integer comment_int = new Integer(comment_id);
			
			String action = map.get("action");
			if(Util.isEmptyString(action)){
				throw new InfoException("action 不能为空或空串");
			}else if(!Util.isNum(action)){
				throw new InfoException("action 不是数字串");
			}
			if(action.equals("1")){//赞
				this.commentServiceImpl.addLike(key,dua_id,article_int,comment_int);
			}else if(action.equals("0")){//文章点踩数
				this.commentServiceImpl.addHate(key,dua_id,article_int,comment_int);
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
