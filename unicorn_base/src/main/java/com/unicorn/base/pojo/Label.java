package com.unicorn.base.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
/**
 * @Author:wangsusheng
 * @Date: 2019/10/15 11:35
 */
@Data
@Entity
@Table(name = "tb_label")
public class Label implements Serializable {
    @Id
    @ApiModelProperty("id")
    private String id;//
    @ApiModelProperty("标签名称")
    private String labelname;//标签名称
    @ApiModelProperty("状态")
    private String state;//状态
    @ApiModelProperty("使用数量")
    private Long count;//使用数量
    @ApiModelProperty("关注数")
    private Long fans;//关注数
    @ApiModelProperty("是否推荐")
    private String recommend;//是否推荐
}
