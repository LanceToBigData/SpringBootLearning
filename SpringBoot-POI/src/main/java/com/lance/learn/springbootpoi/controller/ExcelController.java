package com.lance.learn.springbootpoi.controller;

import com.lance.learn.springbootpoi.service.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Auther: Lance(ZYH)
 * @Date: 2018/8/27 14:01
 * @Description: 处理excel文件上传\下载
 */
@RestController
@RequestMapping("/excel")
public class ExcelController {

    @Autowired
    private ExcelService excelService;

    @PostMapping("/upload")
    public String uploadExcel(@RequestParam MultipartFile file){
        String fileName = file.getOriginalFilename();
        try {
            excelService.uploadExcel(fileName,file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "success";
    }
}
