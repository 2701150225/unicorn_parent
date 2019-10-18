package com.unicorn.mongo.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Date;

@Data
public class Roast implements Serializable {

    @ApiModelProperty("id")
    @Id
    private String _id;
    @ApiModelProperty("吐槽内容")
    private String content;
    @ApiModelProperty("发布日期")
    private Date publishtime;
    @ApiModelProperty("发布人ID")
    private String userid;
    @ApiModelProperty("发布人昵称")
    private String nickname;
    @ApiModelProperty("浏览量")
    private Integer visits;
    @ApiModelProperty("点赞数")
    private Integer thumbup;
    @ApiModelProperty("分享数")
    private Integer share;
    @ApiModelProperty("回复数")
    private Integer comment;
    @ApiModelProperty("是否可见")
    private String state;
    @ApiModelProperty("上级ID")
    private String parentid;


}
