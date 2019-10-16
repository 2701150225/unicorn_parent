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
@Table(name="tb_reply")
public class Reply implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

    @Id
	@ApiModelProperty("编号")
	private java.lang.String id;


	@ApiModelProperty("问题ID")
	private java.lang.String problemid;


	@ApiModelProperty("回答内容")
	private java.lang.String content;


	@ApiModelProperty("创建日期")
	private java.util.Date createtime;


	@ApiModelProperty("更新日期")
	private java.util.Date updatetime;


	@ApiModelProperty("回答人ID")
	private java.lang.String userid;


	@ApiModelProperty("回答人昵称")
	private java.lang.String nickname;
	
}
