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
 * @Date: 2019/10/25 12:32
 */
@Data
@Entity
@Table(name = "tb_nofriend")
@IdClass(NoFriend.class)
public class NoFriend implements Serializable {
    @ApiModelProperty("用户id")
    @Id
    private String userid;
    @ApiModelProperty("非好友id")
    @Id
    private String friendid;



}
