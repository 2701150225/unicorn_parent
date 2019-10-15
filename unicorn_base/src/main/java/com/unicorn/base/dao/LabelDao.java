package com.unicorn.base.dao;

import com.unicorn.base.pojo.Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


/**
 * @Author:wangsusheng
 * @Date: 2019/10/15 11:50
 */

/**
 * 标签数据访问接口
 */
public interface LabelDao extends JpaRepository<Label, String>, JpaSpecificationExecutor<Label> {
}
