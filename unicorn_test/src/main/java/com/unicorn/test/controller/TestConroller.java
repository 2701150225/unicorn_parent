package com.unicorn.test.controller;

import com.unicorn.test.model.User;
import com.unicorn.test.service.TestService;
import com.unicorn.test.util.ExcelUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @Author:wangsusheng
 * @Date: 2019/11/6 10:39
 */
@RestController
@RequestMapping("/test")
@Api(value = "TestConroller",description = "测试专用")
public class TestConroller {


    @Autowired
    TestService testService;

    @RequestMapping(value = "/readExcel",method = RequestMethod.POST)
    @ApiOperation(value = "读取excel文件")
    public List<User> readExcel(MultipartFile file){

    List<User> list=testService.readExcel(file);
    return  list;
    }
}
