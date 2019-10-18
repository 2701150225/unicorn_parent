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
@Table(name = "tb_admin")
public class Admin implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;


    @ApiModelProperty("ID")
    @Id
    private java.lang.String id;


    @ApiModelProperty("登陆名称")
    private java.lang.String loginname;


    @ApiModelProperty("密码")
    private java.lang.String password;


    @ApiModelProperty("状态")
    private java.lang.String state;


}
