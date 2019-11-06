package com.unicorn.test.model;



import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author:wangsusheng
 * @Date: 2019/11/6 10:01
 */
@Data
public class User implements Serializable {


    private String username;

    private String password;

    private Date brithday;
}
