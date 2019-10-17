package com.unicorn.activity.pojo;

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
@Table(name="tb_gathering")
public class Gathering implements Serializable{



	@ApiModelProperty("编号")
	@Id
	private java.lang.String id;


	@ApiModelProperty("活动名称")
	private java.lang.String name;


	@ApiModelProperty("大会简介")
	private java.lang.String summary;


	@ApiModelProperty("详细说明")
	private java.lang.String detail;


	@ApiModelProperty("主办方")
	private java.lang.String sponsor;


	@ApiModelProperty("活动图片")
	private java.lang.String image;


	@ApiModelProperty("开始时间")
	private java.util.Date starttime;


	@ApiModelProperty("截止时间")
	private java.util.Date endtime;


	@ApiModelProperty("举办地点")
	private java.lang.String address;


	@ApiModelProperty("报名截止")
	private java.util.Date enrolltime;


	@ApiModelProperty("是否可见")
	private java.lang.String state;


	@ApiModelProperty("城市")
	private java.lang.String city;



}
