package com.unicorn.mongo.dao;

import com.unicorn.mongo.pojo.Roast;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @Author:wangsusheng
 * @Date: 2019/10/18 11:14
 */
public interface RoastDao extends MongoRepository<Roast, String> {

    public Page<Roast> findByParentid(String parentid, Pageable pageable);
}

