package com.unicorn.qa.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 实体类
 * @author Administrator
 *
 */
@Data
@Entity
@Table(name="tb_problem")
public class Problem implements Serializable{


	/**
	 *
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@ApiModelProperty("ID")
	private java.lang.String id;


	@ApiModelProperty("标题")
	private java.lang.String title;


	@ApiModelProperty("内容")
	private java.lang.String content;


	@ApiModelProperty("创建日期")
	private java.util.Date createtime;


	@ApiModelProperty("修改日期")
	private java.util.Date updatetime;


	@ApiModelProperty("用户ID")
	private java.lang.String userid;


	@ApiModelProperty("昵称")
	private java.lang.String nickname;


	@ApiModelProperty("浏览量")
	private java.lang.Long visits;


	@ApiModelProperty("点赞数")
	private java.lang.Long thumbup;


	@ApiModelProperty("回复数")
	private java.lang.Long reply;


	@ApiModelProperty("是否解决")
	private java.lang.String solve;


	@ApiModelProperty("回复人昵称")
	private java.lang.String replyname;


	@ApiModelProperty("回复日期")
	private java.util.Date replytime;



}
