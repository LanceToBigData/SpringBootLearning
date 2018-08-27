package com.lance.learn.springbootpoi.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @Auther: Lance(ZYH)
 * @Date: 2018/8/27 14:16
 * @Description:    Excel处理业务
 */
public interface ExcelService {

    /**
     * excel文件上传
     * @param fileName
     * @param file
     */
    void uploadExcel(String fileName, MultipartFile file) throws Exception;

}
