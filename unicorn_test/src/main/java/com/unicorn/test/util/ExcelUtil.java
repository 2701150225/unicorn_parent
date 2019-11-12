package com.unicorn.test.util;


import com.alibaba.fastjson.JSONObject;
import com.unicorn.test.model.User;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author:wangsusheng
 * @Date: 2019/11/6 9:39
 */
@Component
public class ExcelUtil {


    private static final List<String> PARAMS_LIST = new ArrayList<String>() {{
        add("username");
        add("password");
        add("brithday");
    }};


    private static final String XLSX = "xlsx";

    private static final String XLS = "xls";

    public List<User> readWorkBook(MultipartFile file) {
        Workbook workbook = getWorkbook(file);

        Sheet sheet = workbook.getSheetAt(0);

        int totalRowNum = sheet.getLastRowNum();

        List<User> result = new ArrayList<>(totalRowNum);
        for (int i = 1; i < totalRowNum; i++) {
            JSONObject jsonObject = new JSONObject();
            for (int j = 0; j < PARAMS_LIST.size(); j++) {
                String stringCellValue = sheet.getRow(i).getCell(j).getStringCellValue();
                jsonObject.put(PARAMS_LIST.get(j), stringCellValue);
            }
            User user = JSONObject.toJavaObject(jsonObject, User.class);
            result.add(user);
        }
        return result;
    }

    private Workbook getWorkbook(MultipartFile file) {
        try {
            String filename = file.getOriginalFilename();
            String filenameSuffix = filename.substring(filename.lastIndexOf(".") + 1);
            if (XLSX.equals(filenameSuffix)) {
                return new XSSFWorkbook(file.getInputStream());
            } else if (XLS.equals(filenameSuffix)) {
                return new HSSFWorkbook(file.getInputStream());
            } else {
                throw new GlobalException("Excel格式错误");
            }
        } catch (IOException e) {
            throw new GlobalException("");
        }
    }

}
