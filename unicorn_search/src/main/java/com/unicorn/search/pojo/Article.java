package com.unicorn.search.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import java.io.Serializable;


/**
 * @Author:wangsusheng
 * @Date: 2019/10/15 11:38
 */

@Data
@Document(indexName = "unicorn_article", type = "article")
public class Article implements Serializable {

   @ApiModelProperty("ID")
    @Id
    private String id;

    //是否索引，就是看该域是否能被搜索。
    //是否分词，就表示搜索的时候是整体匹配还是单词匹配
    //是否存储，就是是否在页面上显示
    @ApiModelProperty("文章标题")
    @Field(index = true, analyzer="ik_max_word", searchAnalyzer="ik_max_word")
    private String title;

    @ApiModelProperty("内容")
    @Field(index = true, analyzer="ik_max_word", searchAnalyzer="ik_max_word")
    private String content;
    @ApiModelProperty("审核状态")
    private String state;//审核状态

}
