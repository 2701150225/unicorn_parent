package com.unicorn.article.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author:wangsusheng
 * @Date: 2019/10/18 14:41
 */
@Data
public class Comment implements Serializable {
    @ApiModelProperty("评论id")
    @Id
    private String _id;
    @ApiModelProperty("文章id")
    private String articleid;
    @ApiModelProperty("评论内容")
    private String content;
    @ApiModelProperty("评论人id")
    private String userid;
    @ApiModelProperty("评论id，为0时表示文章的顶级评论")
    private String parentid;
    @ApiModelProperty("评论日期")
    private Date publishdate;


}
