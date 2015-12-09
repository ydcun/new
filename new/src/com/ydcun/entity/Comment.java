package com.ydcun.entity;

import java.math.BigInteger;
import java.util.Date;

/**
 *评论实体
 */
public class Comment {
	private Integer id;
	/**关联文章**/
	private Article article;
	/**评论内容**/
	private String content;
	/**评论状态 0无效（逻辑删除） 1有效普通评论**/
	private Integer state;
	/**评论时间**/
	private Date time;
	/**评论用户 dua_id**/
	private BigInteger userid;
	/**评论用户名**/
	private String username;
	/**评论地点 客户端直接提供**/
	private String location;
	/**地点经纬度（double,double的方式存放lon，lat数据）**/
	private String lonlat;
	/**评论ip 234g的所有手机的ip都是网络自动DHCP分配的**/
	private String ip;
	/**点赞量**/
	private Integer likes;
	/**点踩量**/
	private Integer hate;
	/**  
	 * 获取id  
	 * @return id id  
	 */
	public Integer getId() {
		return id;
	}
	
	/**  
	 * 设置id  
	 * @param id id  
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	
	/**  
	 * 获取关联文章  
	 * @return article 关联文章  
	 */
	public Article getArticle() {
		return article;
	}
	
	/**  
	 * 设置关联文章  
	 * @param article 关联文章  
	 */
	public void setArticle(Article article) {
		this.article = article;
	}
	
	/**  
	 * 获取评论内容  
	 * @return content 评论内容  
	 */
	public String getContent() {
		return content;
	}
	
	/**  
	 * 设置评论内容  
	 * @param content 评论内容  
	 */
	public void setContent(String content) {
		this.content = content;
	}
	
	/**  
	 * 获取评论状态0无效（逻辑删除）1有效普通评论  
	 * @return state 评论状态0无效（逻辑删除）1有效普通评论  
	 */
	public Integer getState() {
		return state;
	}
	
	/**  
	 * 设置评论状态0无效（逻辑删除）1有效普通评论  
	 * @param state 评论状态0无效（逻辑删除）1有效普通评论  
	 */
	public void setState(Integer state) {
		this.state = state;
	}
	
	/**  
	 * 获取评论时间  
	 * @return time 评论时间  
	 */
	public Date getTime() {
		return time;
	}
	
	/**  
	 * 设置评论时间  
	 * @param time 评论时间  
	 */
	public void setTime(Date time) {
		this.time = time;
	}
	
	/**  
	 * 获取评论用户dua_id  
	 * @return userid 评论用户dua_id  
	 */
	public BigInteger getUserid() {
		return userid;
	}
	
	/**  
	 * 设置评论用户dua_id  
	 * @param userid 评论用户dua_id  
	 */
	public void setUserid(BigInteger userid) {
		this.userid = userid;
	}
	
	/**  
	 * 获取评论用户名  
	 * @return username 评论用户名  
	 */
	public String getUsername() {
		return username;
	}
	
	/**  
	 * 设置评论用户名  
	 * @param username 评论用户名  
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**  
	 * 获取评论地点客户端直接提供  
	 * @return location 评论地点客户端直接提供  
	 */
	public String getLocation() {
		return location;
	}
	
	/**  
	 * 设置评论地点客户端直接提供  
	 * @param location 评论地点客户端直接提供  
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	
	/**  
	 * 获取地点经纬度（doubledouble的方式存放lon，lat数据）  
	 * @return lonlat 地点经纬度（doubledouble的方式存放lon，lat数据）  
	 */
	public String getLonlat() {
		return lonlat;
	}
	
	/**  
	 * 设置地点经纬度（doubledouble的方式存放lon，lat数据）  
	 * @param lonlat 地点经纬度（doubledouble的方式存放lon，lat数据）  
	 */
	public void setLonlat(String lonlat) {
		this.lonlat = lonlat;
	}
	
	/**  
	 * 获取评论ip234g的所有手机的ip都是网络自动DHCP分配的  
	 * @return ip 评论ip234g的所有手机的ip都是网络自动DHCP分配的  
	 */
	public String getIp() {
		return ip;
	}
	
	/**  
	 * 设置评论ip234g的所有手机的ip都是网络自动DHCP分配的  
	 * @param ip 评论ip234g的所有手机的ip都是网络自动DHCP分配的  
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}
	/**  
	 * 获取点赞量  
	 * @return likes 点赞量  
	 */
	public Integer getLikes() {
		return likes;
	}
	

	/**  
	 * 设置点赞量  
	 * @param likes 点赞量  
	 */
	public void setLikes(Integer likes) {
		this.likes = likes;
	}
	

	/**  
	 * 获取点踩量  
	 * @return hate 点踩量  
	 */
	public Integer getHate() {
		return hate;
	}
	

	/**  
	 * 设置点踩量  
	 * @param hate 点踩量  
	 */
	public void setHate(Integer hate) {
		this.hate = hate;
	}
	

	
	
}
