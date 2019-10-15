package com.unicorn.recruit.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Author:wangsusheng
 * @Date: 2019/10/15 16:46
 */
@Data
@Entity
@Table(name = "tb_recruit")
public class Recruit implements Serializable {
    @Id
    @ApiModelProperty("ID")
    private String id;//ID
    @ApiModelProperty("职位名称")

    private String jobname;//职位名称
    @ApiModelProperty("薪资范围")

    private String salary;//薪资范围
    @ApiModelProperty("经验要求")

    private String condition;//经验要求
    @ApiModelProperty("学历要求")

    private String education;//学历要求
    @ApiModelProperty("任职方式")

    private String type;//任职方式
    @ApiModelProperty("办公地址")

    private String address;//办公地址
    @ApiModelProperty("企业ID")

    private String eid;//企业ID
    @ApiModelProperty("createtime")

    private java.util.Date createtime;//创建日期
    @ApiModelProperty("状态 0：关闭 1:开启  2：推荐")

    private String state;//状态
    @ApiModelProperty("网址")

    private String url;//网址
    @ApiModelProperty("标签")

    private String label;//标签
    @ApiModelProperty("职位描述")

    private String content1;//职位描述
    @ApiModelProperty("职位要求")

    private String content2;//职位要求

}
