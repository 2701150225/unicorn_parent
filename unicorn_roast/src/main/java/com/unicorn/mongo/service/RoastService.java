package com.unicorn.mongo.service;

import com.unicorn.mongo.pojo.Roast;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @Author:wangsusheng
 * @Date: 2019/10/18 11:26
 */
public interface RoastService {

    List<Roast> findAll();

    Roast findById(String id);

    void save(Roast roast);

    void update(Roast roast);

    void deleteById(String id);

    Page<Roast> pageQuery(String parentid, int page, int size);

    void addthumbup(String id);

}
