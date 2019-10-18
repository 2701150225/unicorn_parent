package com.unicorn.user.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
/**
 * @Author:wangsusheng
 * @Date: 2019/10/18 16:38
 */
@Data
@Entity
@Table(name="tb_user")
public class User implements Serializable{


	/**
	 *
	 */
	private static final long serialVersionUID = 1L;


	@ApiModelProperty("ID")
	@Id
	private java.lang.String id;


	@ApiModelProperty("手机号码")
	private java.lang.String mobile;


	@ApiModelProperty("密码")
	private java.lang.String password;


	@ApiModelProperty("昵称")
	private java.lang.String nickname;


	@ApiModelProperty("性别")
	private java.lang.String sex;


	@ApiModelProperty("出生年月日")
	private java.util.Date birthday;


	@ApiModelProperty("头像")
	private java.lang.String avatar;


	@ApiModelProperty("E-Mail")
	private java.lang.String email;


	@ApiModelProperty("注册日期")
	private java.util.Date regdate;


	@ApiModelProperty("修改日期")
	private java.util.Date updatedate;


	@ApiModelProperty("最后登陆日期")
	private java.util.Date lastdate;


	@ApiModelProperty("在线时长（分钟）")
	private java.lang.Long online;


	@ApiModelProperty("兴趣")
	private java.lang.String interest;


	@ApiModelProperty("个性")
	private java.lang.String personality;


	@ApiModelProperty("粉丝数")
	private java.lang.Integer fanscount;


	@ApiModelProperty("关注数")
	private java.lang.Integer followcount;


	@ApiModelProperty("登录Ip")
	private java.lang.String loginIp;





}
