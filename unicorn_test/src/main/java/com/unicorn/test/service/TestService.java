package com.unicorn.test.service;

import com.unicorn.test.model.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @Author:wangsusheng
 * @Date: 2019/11/6 10:55
 */
public interface TestService {
    public List<User> readExcel(MultipartFile file);
}
