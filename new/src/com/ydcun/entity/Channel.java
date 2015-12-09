package com.ydcun.entity;

/**
 *类型实体
 */
public class Channel {
	private Integer id;
	/**类型标识字段**/
	private Integer code;
	/**新闻类型名**/
	private String name;
	/**栏目关键字**/
	private String keywords;
	/**简介**/
	private String brief;
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
	 * 获取类型标识字段  
	 * @return code 类型标识字段  
	 */
	public Integer getCode() {
		return code;
	}
	
	/**  
	 * 设置类型标识字段  
	 * @param code 类型标识字段  
	 */
	public void setCode(Integer code) {
		this.code = code;
	}
	
	/**  
	 * 获取新闻类型名  
	 * @return name 新闻类型名  
	 */
	public String getName() {
		return name;
	}
	
	/**  
	 * 设置新闻类型名  
	 * @param name 新闻类型名  
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**  
	 * 获取栏目关键字  
	 * @return keywords 栏目关键字  
	 */
	public String getKeywords() {
		return keywords;
	}
	
	/**  
	 * 设置栏目关键字  
	 * @param keywords 栏目关键字  
	 */
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	
	/**  
	 * 获取简介  
	 * @return brief 简介  
	 */
	public String getBrief() {
		return brief;
	}
	
	/**  
	 * 设置简介  
	 * @param brief 简介  
	 */
	public void setBrief(String brief) {
		this.brief = brief;
	}
	
	
	
}
