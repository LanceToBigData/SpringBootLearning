package com.lance.learn.springbootpoi.util;

import org.apache.poi.hpsf.DocumentSummaryInformation;
import org.apache.poi.hpsf.SummaryInformation;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.stereotype.Component;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

/**
 * @Auther: Lance(ZYH)
 * @Date: 2018/8/27 16:36
 * @Description:
 */
@Component
public class ExcelUtil {

    /**
     * 创建Workbook和Sheet
     */
    public void basicExcel() {
        String filePath = "d:\\poi\\sample.xlsx";   //文件路径
        XSSFWorkbook workbook = new XSSFWorkbook(); //创建Excel文件(Workbook)
//        XSSFSheet sheet = workbook.createSheet();
        XSSFSheet mySheet = workbook.createSheet("MySheet");
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(filePath);
            workbook.write(out);
            out.close();//关闭文件流
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 创建单元格
     */
    public void createCell() {
        String filePath = "d:\\poi\\sample.xlsx";   //文件路径
        XSSFWorkbook workbook = new XSSFWorkbook(); //创建Excel文件(Workbook)
//        XSSFSheet sheet = workbook.createSheet();
        XSSFSheet mySheet = workbook.createSheet("MySheet");

        XSSFRow row = mySheet.createRow(0); // 创建行,从0开始
        XSSFCell cell = row.createCell(0);// 创建行的单元格,也是从0开始
        cell.setCellValue("姓名");
        row.createCell(1).setCellValue("年龄");
        row.createCell(2).setCellValue("地址");
        row.createCell(3).setCellValue("电话");


        FileOutputStream out = null;
        try {
            out = new FileOutputStream(filePath);
            workbook.write(out);
            out.close();//关闭文件流
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建文档摘要信息（基本信息）
     */
    public void createDocumentMessage() {
        //todo 测试的时候 dsi报空指针
        String filePath = "d:\\poi\\sample.xls";   //文件路径
//        XSSFWorkbook workbook = new XSSFWorkbook();  没有getDocumentSummaryInformation()方法
        HSSFWorkbook workbook = new HSSFWorkbook(); //创建Excel文件(Workbook)
        DocumentSummaryInformation dsi = workbook.getDocumentSummaryInformation();
        //文档类别
        dsi.setCategory("员工信息");
        //设置文档管理员
        dsi.setManager("江南一点雨");
        //设置组织机构
        dsi.setCompany("XXX集团");
        //获取摘要信息并配置
        SummaryInformation si = workbook.getSummaryInformation();
        //设置文档主题
        si.setSubject("员工信息表");
        //设置文档标题
        si.setTitle("员工信息");
        //设置文档作者
        si.setAuthor("XXX集团");
        //设置文档备注
        si.setComments("备注信息暂无");

        FileOutputStream out = null;
        try {
            out = new FileOutputStream(filePath);
            workbook.write(out);
            out.close();//关闭文件流
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Excel的单元格操作-设置格式
     */
    public void setFormat() {
        String filePath = "d:\\poi\\sample.xlsx";   //文件路径
        XSSFWorkbook workbook = new XSSFWorkbook(); //创建Excel文件(Workbook)
        XSSFSheet sheet = workbook.createSheet("MySheet");
        XSSFRow row = sheet.createRow(0);

        //设置日期格式--使用Excel内嵌的格式
        XSSFCell cell1 = row.createCell(0);
        cell1.setCellValue(new Date());
        XSSFCellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy h:mm:ss"));
        cell1.setCellStyle(cellStyle);

        //设置保留2位小数--使用Excel内嵌的格式
        XSSFCell cell2 = row.createCell(1);
        cell2.setCellValue(12.34567);
        workbook.createCellStyle();
        cellStyle = workbook.createCellStyle();
        cellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("￥#,##0"));
        cell2.setCellStyle(cellStyle);

        //设置货币格式--使用自定义的格式
        XSSFCell cell3 = row.createCell(2);
        cell3.setCellValue(34.422);
        workbook.createCellStyle();
        cellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("0.00"));
        cell3.setCellStyle(cellStyle);


        FileOutputStream out = null;
        try {
            out = new FileOutputStream(filePath);
            workbook.write(out);
            out.close();//关闭文件流
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 合并行或列
     */
    public void mergeRowOrCell(){
        String filePath = "d:\\poi\\sample.xlsx";   //文件路径
        XSSFWorkbook workbook = new XSSFWorkbook(); //创建Excel文件(Workbook)
        XSSFSheet sheet = workbook.createSheet("MySheet");
        XSSFRow row = sheet.createRow(0);
        //合并列
        XSSFCell cell = row.createCell(0);
        cell.setCellValue("合并列");
        CellRangeAddress region = new CellRangeAddress(0,0,0,5);
        sheet.addMergedRegion(region);

        //合并行
        cell = row.createCell(6);
        cell.setCellValue(6);
        region = new CellRangeAddress(0,5,6,6);
        sheet.addMergedRegion(region);

        FileOutputStream out = null;
        try {
            out = new FileOutputStream(filePath);
            workbook.write(out);
            out.close();//关闭文件流
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
