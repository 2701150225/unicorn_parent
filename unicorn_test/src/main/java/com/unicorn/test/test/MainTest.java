package com.unicorn.test.test;

import com.unicorn.test.util.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author:wangsusheng
 * @Date: 2019/11/6 11:29
 */
public class MainTest {



    public static void main(String[] args) {
        // 设定Excel文件所在路径
        String excelFileName = "C:\\Users\\DELL\\Desktop\\文档\\测试.xlsx";
        // 读取Excel文件内容
//        List<ExcelDataVO> readResult = ExcelReader.readExcel(excelFileName);
//        System.out.println(readResult);
        List<ExcelDataVO> readResult = ExcelTest.readExcel(excelFileName);

    }

}
