package com.unicorn.test.service.impl;

import com.unicorn.test.model.User;
import com.unicorn.test.service.TestService;
import com.unicorn.test.util.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @Author:wangsusheng
 * @Date: 2019/11/6 10:56
 */
@Service
public class TestServiceImpl implements TestService {


    @Autowired
    private ExcelUtil excelUtil;

    public List<User> readExcel(MultipartFile file){
        List<User> list=excelUtil.readWorkBook(file);
        for (User user :list){
            System.out.println(user);
        }
        return  list;
    }


}
