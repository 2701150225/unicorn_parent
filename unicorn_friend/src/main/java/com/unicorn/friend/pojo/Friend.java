package com.unicorn.friend.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;
/**
 * @Author:wangsusheng
 * @Date: 2019/10/25 12:31
 */
@Data
@Entity
@Table(name = "tb_friend")
@IdClass(Friend.class)
public class Friend implements Serializable {
    @ApiModelProperty("用户id")
    @Id
    private String userid;
    @ApiModelProperty("好友id")
    @Id
    private String friendid;
    @ApiModelProperty("是否相互喜欢,0表示单向,1表示双向")
    private String islike;

}
