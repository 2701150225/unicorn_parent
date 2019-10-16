package com.unicorn.article.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
/**
 * 实体类
 * @author wangsusheng
 *
 */
@Data
@Entity
@Table(name="tb_article")
public class Article implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;



	@ApiModelProperty("ID")
	@Id
	private java.lang.String id;


	@ApiModelProperty("专栏ID")
	private java.lang.String columnid;


	@ApiModelProperty("用户ID")
	private java.lang.String userid;


	@ApiModelProperty("标题")
	private java.lang.String title;


	@ApiModelProperty("文章正文")
	private java.lang.String content;


	@ApiModelProperty("文章封面")
	private java.lang.String image;


	@ApiModelProperty("发表日期")
	private java.util.Date createtime;


	@ApiModelProperty("修改日期")
	private java.util.Date updatetime;


	@ApiModelProperty("是否公开 0：不公开 1：公开")
	private java.lang.String ispublic;


	@ApiModelProperty("是否置顶")
	private java.lang.String istop;


	@ApiModelProperty("浏览量")
	private java.lang.Integer visits;


	@ApiModelProperty("点赞数")
	private java.lang.Integer thumbup;


	@ApiModelProperty("评论数")
	private java.lang.Integer comment;


	@ApiModelProperty("审核状态 0：未审核  1：已审核")
	private java.lang.String state;


	@ApiModelProperty("所属频道")
	private java.lang.String channelid;


	@ApiModelProperty("URL")
	private java.lang.String url;


	@ApiModelProperty("类型 0：分享 1：专栏 ")
	private java.lang.String type;



}
