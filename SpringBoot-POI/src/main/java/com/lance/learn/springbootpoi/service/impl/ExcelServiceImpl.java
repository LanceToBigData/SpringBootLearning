package com.lance.learn.springbootpoi.service.impl;

import com.lance.learn.springbootpoi.entity.User;
import com.lance.learn.springbootpoi.service.ExcelService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Auther: Lance(ZYH)
 * @Date: 2018/8/27 14:19
 * @Description:  excel处理实现类
 */
@Service
public class ExcelServiceImpl implements ExcelService {

    /**
     * 文件上传
     * @param fileName
     * @param file
     */
    @Override
    public void uploadExcel(String fileName, MultipartFile file) throws Exception {

        //存储excel里面数据
        List<User> userList = new ArrayList<>();

        //判断文件格式
        if (!fileName.matches("^.+\\.(?i)(xls)$") &&
                !fileName.matches("^.+\\.(?i)(xlsx)$")){
            throw new Exception("上传文件格式不正确");
        }
        boolean isExcel2003 = true;
        if (fileName.matches("^.+\\.(?i)(xlsx)$")){
            isExcel2003 = false;
        }

        InputStream is = file.getInputStream();
        Workbook wb = null;
        if (isExcel2003){
            wb = new HSSFWorkbook(is);
        }else{
            wb = new XSSFWorkbook(is);
        }
        Sheet sheet  = wb.getSheetAt(0);
        User user;
        for (int r = 1;r >= sheet.getLastRowNum();r++){
            //获得sheet某行
            Row row = sheet.getRow(r);
            if (row == null){
                continue;
            }
            user = new User();

            if (row.getCell(0).getCellType() != 1){
                throw new Exception("导入失败(第\"+(r+1)+\"行,姓名请设为文本格式)");
            }
            String name = row.getCell(0).getStringCellValue();
            if (name == null && name.isEmpty() ){
                throw new Exception("导入失败(第\"+(r+1)+\"行,姓名未填写)");
            }

            row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
            String phone = row.getCell(1).getStringCellValue();
            if (phone == null && phone.isEmpty()){
                throw new Exception("导入失败(第\"+(r+1)+\"行,电话未填写)");
            }

            String address = row.getCell(2).getStringCellValue();
            Date date = row.getCell(3).getDateCellValue();
            String desc = row.getCell(4).getStringCellValue();

            user.setName(name);
            user.setPhone(phone);
            user.setAddress(address);
            user.setRegisterDate(date);
            user.setDesc(desc);

            userList.add(user);
        }

        for (User userDemo : userList) {
            System.out.println(userDemo);
            System.out.println("------------------------");
        }

    }
}
