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
@Table(name = "tb_enterprise")
public class Enterprise implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @ApiModelProperty("ID")
    private java.lang.String id;


    @ApiModelProperty("企业名称")
    private java.lang.String name;


    @ApiModelProperty("企业简介")
    private java.lang.String summary;


    @ApiModelProperty("企业地址")
    private java.lang.String address;


    @ApiModelProperty("标签列表")
    private java.lang.String labels;


    @ApiModelProperty("坐标")
    private java.lang.String coordinate;


    @ApiModelProperty("是否热门")
    private java.lang.String ishot;


    @ApiModelProperty("LOGO")
    private java.lang.String logo;


    @ApiModelProperty("职位数")
    private java.lang.Integer jobcount;


    @ApiModelProperty("URL")
    private java.lang.String url;

}
