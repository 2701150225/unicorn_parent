package com.unicorn.test.test;

import com.alibaba.fastjson.JSONObject;
import com.unicorn.test.model.User;
import com.unicorn.test.util.GlobalException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author:wangsusheng
 * @Date: 2019/11/6 11:54
 */
public class ExcelTest {

    public static List<ExcelDataVO> readExcel(String fileName) {
        Workbook workbook = null;
        FileInputStream inputStream = null;
        try {
            // 获取Excel后缀名
            String fileType = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
            // 获取Excel文件
            File excelFile = new File(fileName);
            if (!excelFile.exists()) {
                System.out.println("指定的Excel文件不存在！");
                return null;
            }
            // 获取Excel工作簿
            inputStream = new FileInputStream(excelFile);
//            workbook = getWorkbook(inputStream, fileType);
//            // 读取excel中的数据
//            List<ExcelDataVO> resultDataList = parseExcel(workbook);
//            return resultDataList;
            return  null;
        } catch (Exception e) {
            System.out.println("解析Excel失败，文件名：" + fileName + " 错误信息：" + e.getMessage());
            return null;
        } finally {
            try {
                if (null != workbook) {
                    workbook.close();
                }
                if (null != inputStream) {
                    inputStream.close();
                }
            } catch (Exception e) {
                System.out.println("关闭数据流出错！错误信息：" + e.getMessage());
                return null;
            }
        }
    }

//    private Workbook getWorkbook(InputStream inputStream, String fileType) {
//        try {
//            String filename = file.getOriginalFilename();
//            String filenameSuffix = filename.substring(filename.lastIndexOf(".") + 1);
//            if (XLSX.equals(filenameSuffix)) {
//                return new XSSFWorkbook(file.getInputStream());
//            } else if (XLS.equals(filenameSuffix)) {
//                return new HSSFWorkbook(file.getInputStream());
//            } else {
//                throw new GlobalException("Excel格式错误");
//            }
//        } catch (IOException e) {
//            throw new GlobalException("");
//        }
//    }

}
