package com.unicorn.article.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
/**
 * 频道实体类
 * @author wangsusheng
 *
 */
@Data
@Entity
@Table(name="tb_channel")
public class Channel implements Serializable{

	@Id
	@ApiModelProperty("Id")
	private String id;//ID
	@ApiModelProperty("频道名称")
	private String name;//频道名称
	@ApiModelProperty("状态")
	private String state;//状态


}
