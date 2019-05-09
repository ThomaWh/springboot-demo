package com.example.poi.controller;

import com.example.poi.entity.User;
import com.example.poi.server.UserService;
import com.example.poi.util.FileUtil;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author wh
 * @description poi 简单示例
 * @date 2019/5/9
 */
@RestController
@RequestMapping("/excel")
public class PoiExcelDemo {
    @Autowired
    private UserService userService;

    @RequestMapping("/exportUserExcel")
    public void exportUserExcel(HttpServletResponse response) {
        List<User> userList = userService.getAll();
        //创建工作簿
        HSSFWorkbook workbook = new HSSFWorkbook();
        //创建表
        HSSFSheet sheet = workbook.createSheet("用户信息表");
        //创建行
        HSSFRow row = sheet.createRow(0);
        //创建单元格格式
        HSSFCellStyle cellStyle = workbook.createCellStyle();
        //设置表头
        String[] head = {"姓名", "性别", "住址", "年龄", "职业", "爱好"};
        //设置表头
        HSSFCell cell;
        for (int i = 0; i < head.length; i++) {
            cell = row.createCell(i+1);
            cell.setCellValue(head[i]);
            cell.setCellStyle(cellStyle);
        }
        //设置表格内容
        for (int i = 0; i < userList.size(); i++) {
            row = sheet.createRow(i);
            User user = userList.get(i);
            String[] userArray = {user.getUserName(), user.getUserSex(), user.getUserAddress(), user.getUserAge() , user.getUserProfesseion(), user.getUserHobby()};
            for (int j = 0; j < userArray.length; j++) {
                row.createCell(j).setCellValue(userArray[j]);
            }
        }
        FileUtil.createFile(response, workbook);
    }
}
