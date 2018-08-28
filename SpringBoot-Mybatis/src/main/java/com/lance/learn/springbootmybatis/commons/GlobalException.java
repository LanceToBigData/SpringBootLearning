package com.lance.learn.springbootmybatis.commons;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Auther: Lance(ZYH)
 * @Date: 2018/8/28 11:41
 * @Description:   全局异常处理
 */
public class GlobalException extends Exception{
    private final Logger logger = LoggerFactory.getLogger(GlobalException.class);
    private String errorCode;
    private String errorMsg;

    public String getErrorMsg()
    {
        return this.errorMsg;
    }

    public String getErrorCode()
    {
        return this.errorCode;
    }


}
