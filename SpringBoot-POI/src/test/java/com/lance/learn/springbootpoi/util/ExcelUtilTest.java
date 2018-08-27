package com.lance.learn.springbootpoi.util;

import com.lance.learn.springbootpoi.SpringbootPoiApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Auther: Lance(ZYH)
 * @Date: 2018/8/27 16:41
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootPoiApplication.class)
public class ExcelUtilTest {
    @Autowired
    private ExcelUtil excelUtil;

    @Test
    public void basicExcel() {
        excelUtil.basicExcel();
    }

    @Test
    public void createCell() {
        excelUtil.createCell();
    }

    @Test
    public void createDocumentMessage() {
        excelUtil.createDocumentMessage();
    }

    @Test
    public void setFormat() {
        excelUtil.setFormat();
    }

    @Test
    public void mergeRowOrCell() {
        excelUtil.mergeRowOrCell();
    }
}