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
@Table(name="tb_column")
public class Column implements Serializable{

	@Id
	@ApiModelProperty("Id")
	private String id;//ID

	@ApiModelProperty("专栏名称")

	private String name;//专栏名称
	@ApiModelProperty("专栏简介")

	private String summary;//专栏简介
	@ApiModelProperty("用户ID")

	private String userid;//用户ID
	@ApiModelProperty("申请日期")

	private java.util.Date createtime;//申请日期
	@ApiModelProperty("审核日期")

	private java.util.Date checktime;//审核日期
	@ApiModelProperty("状态")

	private String state;//状态

	



	
}
