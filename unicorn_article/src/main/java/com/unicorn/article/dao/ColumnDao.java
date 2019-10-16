package com.unicorn.article.dao;


import com.unicorn.article.pojo.Column;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 数据访问接口
 * @author wangsusheng
 *
 */
public interface ColumnDao extends JpaRepository<Column,String>, JpaSpecificationExecutor<Column> {
	
}
