package com.ydcun.entity;

import java.math.BigInteger;
import java.util.Date;

/**
 *文章实体
 */
public class Article {
	private Integer id;
	/**app的id （来自dua平台的app_id）**/
	private BigInteger aid;
	/**对应类型**/
	private Channel channel;
	/**文章题目**/
	private String title;
	/**文章简介**/
	private String brief;
	/**文章摘要**/
	private String digest;
	/**文章正文**/
	private String content;
	/**缩略图路径**/
	private String image;
	/**关键词 用竖线隔开**/
	private String keywords;
	/**是否置顶 0不置顶 1置顶**/
	private Integer istop;
	/**是否原创 0不是原创 1是原创**/
	private Integer original;
	/**是否共享 0不共享 1共享**/
	private Integer sharable;
	/**阅读数**/
	private Integer views;
	/**文章点赞量**/
	private Integer likes;
	/**文章点踩量**/
	private Integer hate;
	/**评论数量**/
	private Integer comments;
	/**状态 0删除（逻辑） 1未审核 2审核没有通过 3审核通过**/
	private Integer status;
	/**文章来源（文字描述）**/
	private String copyfrom;
	/**作者名字 以字符串表达署名**/
	private String author_name;
	/**作者id 编辑文章的作者 dua_id**/
	private BigInteger author;
	/**平台编辑和提交文章的人 dua_id**/
	private BigInteger editor;
	/**审核文章并给state字段值的人 dua_id**/
	private BigInteger checker;
	/**创建时间**/
	private Date time;
	/**审核时间**/
	private Date check_time;
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
	 * 获取app的id（来自dua平台的app_id）  
	 * @return aid app的id（来自dua平台的app_id）  
	 */
	public BigInteger getAid() {
		return aid;
	}
	
	/**  
	 * 设置app的id（来自dua平台的app_id）  
	 * @param aid app的id（来自dua平台的app_id）  
	 */
	public void setAid(BigInteger aid) {
		this.aid = aid;
	}
	
	/**  
	 * 获取对应类型  
	 * @return channel 对应类型  
	 */
	public Channel getChannel() {
		return channel;
	}
	
	/**  
	 * 设置对应类型  
	 * @param channel 对应类型  
	 */
	public void setChannel(Channel channel) {
		this.channel = channel;
	}
	
	/**  
	 * 获取文章题目  
	 * @return title 文章题目  
	 */
	public String getTitle() {
		return title;
	}
	
	/**  
	 * 设置文章题目  
	 * @param title 文章题目  
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**  
	 * 获取文章简介  
	 * @return brief 文章简介  
	 */
	public String getBrief() {
		return brief;
	}
	
	/**  
	 * 设置文章简介  
	 * @param brief 文章简介  
	 */
	public void setBrief(String brief) {
		this.brief = brief;
	}
	
	/**  
	 * 获取文章摘要  
	 * @return digest 文章摘要  
	 */
	public String getDigest() {
		return digest;
	}

	/**  
	 * 设置文章摘要  
	 * @param digest 文章摘要  
	 */
	public void setDigest(String digest) {
		this.digest = digest;
	}
	

	/**  
	 * 获取文章正文  
	 * @return content 文章正文  
	 */
	public String getContent() {
		return content;
	}
	
	/**  
	 * 设置文章正文  
	 * @param content 文章正文  
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**  
	 * 获取缩略图路径  
	 * @return image 缩略图路径  
	 */
	public String getImage() {
		return image;
	}
	
	/**  
	 * 设置缩略图路径  
	 * @param image 缩略图路径  
	 */
	public void setImage(String image) {
		this.image = image;
	}
	
	/**  
	 * 获取关键词用竖线隔开  
	 * @return keywords 关键词用竖线隔开  
	 */
	public String getKeywords() {
		return keywords;
	}
	
	/**  
	 * 设置关键词用竖线隔开  
	 * @param keywords 关键词用竖线隔开  
	 */
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	
	/**  
	 * 获取是否置顶0不置顶1置顶  
	 * @return istop 是否置顶0不置顶1置顶  
	 */
	public Integer getIstop() {
		return istop;
	}
	
	/**  
	 * 设置是否置顶0不置顶1置顶  
	 * @param istop 是否置顶0不置顶1置顶  
	 */
	public void setIstop(Integer istop) {
		this.istop = istop;
	}
	
	/**  
	 * 获取是否原创0不是原创1是原创  
	 * @return original 是否原创0不是原创1是原创  
	 */
	public Integer getOriginal() {
		return original;
	}
	
	/**  
	 * 设置是否原创0不是原创1是原创  
	 * @param original 是否原创0不是原创1是原创  
	 */
	public void setOriginal(Integer original) {
		this.original = original;
	}
	
	/**  
	 * 获取是否共享0不共享1共享  
	 * @return sharable 是否共享0不共享1共享  
	 */
	public Integer getSharable() {
		return sharable;
	}
	
	/**  
	 * 设置是否共享0不共享1共享  
	 * @param sharable 是否共享0不共享1共享  
	 */
	public void setSharable(Integer sharable) {
		this.sharable = sharable;
	}
	
	/**  
	 * 获取阅读数  
	 * @return views 阅读数  
	 */
	public Integer getViews() {
		return views;
	}
	

	/**  
	 * 设置阅读数  
	 * @param views 阅读数  
	 */
	public void setViews(Integer views) {
		this.views = views;
	}
	

	/**  
	 * 获取文章点赞量  
	 * @return likes 文章点赞量  
	 */
	public Integer getLikes() {
		return likes;
	}
	

	/**  
	 * 设置文章点赞量  
	 * @param likes 文章点赞量  
	 */
	public void setLikes(Integer likes) {
		this.likes = likes;
	}
	

	/**  
	 * 获取文章点踩量  
	 * @return hate 文章点踩量  
	 */
	public Integer getHate() {
		return hate;
	}
	
	/**  
	 * 设置文章点踩量  
	 * @param hate 文章点踩量  
	 */
	public void setHate(Integer hate) {
		this.hate = hate;
	}
	
	/**  
	 * 获取评论数量  
	 * @return comments 评论数量  
	 */
	public Integer getComments() {
		return comments;
	}
	
	/**  
	 * 设置评论数量  
	 * @param comments 评论数量  
	 */
	public void setComments(Integer comments) {
		this.comments = comments;
	}
		
	/**  
	 * 获取状态0删除（逻辑）1未审核2审核没有通过3审核通过  
	 * @return status 状态0删除（逻辑）1未审核2审核没有通过3审核通过  
	 */
	public Integer getStatus() {
		return status;
	}
	

	/**  
	 * 设置状态0删除（逻辑）1未审核2审核没有通过3审核通过  
	 * @param status 状态0删除（逻辑）1未审核2审核没有通过3审核通过  
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	

	/**  
	 * 获取文章来源（文字描述）  
	 * @return copyfrom 文章来源（文字描述）  
	 */
	public String getCopyfrom() {
		return copyfrom;
	}
	
	/**  
	 * 设置文章来源（文字描述）  
	 * @param copyfrom 文章来源（文字描述）  
	 */
	public void setCopyfrom(String copyfrom) {
		this.copyfrom = copyfrom;
	}
	
	/**  
	 * 获取作者名字以字符串表达署名  
	 * @return author_name 作者名字以字符串表达署名  
	 */
	public String getAuthor_name() {
		return author_name;
	}
	
	/**  
	 * 设置作者名字以字符串表达署名  
	 * @param author_name 作者名字以字符串表达署名  
	 */
	public void setAuthor_name(String author_name) {
		this.author_name = author_name;
	}
	
	/**  
	 * 获取作者id编辑文章的作者dua_id  
	 * @return author 作者id编辑文章的作者dua_id  
	 */
	public BigInteger getAuthor() {
		return author;
	}
	
	/**  
	 * 设置作者id编辑文章的作者dua_id  
	 * @param author 作者id编辑文章的作者dua_id  
	 */
	public void setAuthor(BigInteger author) {
		this.author = author;
	}
	
	/**  
	 * 获取平台编辑和提交文章的人dua_id  
	 * @return editor 平台编辑和提交文章的人dua_id  
	 */
	public BigInteger getEditor() {
		return editor;
	}
	
	/**  
	 * 设置平台编辑和提交文章的人dua_id  
	 * @param editor 平台编辑和提交文章的人dua_id  
	 */
	public void setEditor(BigInteger editor) {
		this.editor = editor;
	}
	
	/**  
	 * 获取审核文章并给state字段值的人dua_id  
	 * @return checker 审核文章并给state字段值的人dua_id  
	 */
	public BigInteger getChecker() {
		return checker;
	}
	
	/**  
	 * 设置审核文章并给state字段值的人dua_id  
	 * @param checker 审核文章并给state字段值的人dua_id  
	 */
	public void setChecker(BigInteger checker) {
		this.checker = checker;
	}
	
	/**  
	 * 获取创建时间  
	 * @return time 创建时间  
	 */
	public Date getTime() {
		return time;
	}
	

	/**  
	 * 设置创建时间  
	 * @param time 创建时间  
	 */
	public void setTime(Date time) {
		this.time = time;
	}
	

	/**  
	 * 获取审核时间  
	 * @return check_time 审核时间  
	 */
	public Date getCheck_time() {
		return check_time;
	}
	
	/**  
	 * 设置审核时间  
	 * @param check_time 审核时间  
	 */
	public void setCheck_time(Date check_time) {
		this.check_time = check_time;
	}
	
	
	
	
}
