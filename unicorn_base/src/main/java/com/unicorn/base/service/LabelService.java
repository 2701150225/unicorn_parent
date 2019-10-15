package com.unicorn.base.service;

import com.unicorn.base.pojo.Label;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @Author:wangsusheng
 * @Date: 2019/10/15 11:53
 */
public interface LabelService {

    void save(Label label);

    List<Label> findAll();

    Label findById(String id);

    void update(Label label);

    void delete(String labelId);

    List<Label> findSearch(Label label);


    Page<Label> pageQuery(Label label, int page, int size);


}
