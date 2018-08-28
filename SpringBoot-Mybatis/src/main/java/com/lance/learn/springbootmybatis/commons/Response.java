package com.lance.learn.springbootmybatis.commons;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;

/**
 * @Auther: Lance(ZYH)
 * @Date: 2018/8/28 10:01
 * @Description:    响应对象
 */
public class Response {
    private Meta meta;
    private Object data;

    public Response success() {
        this.meta = new Meta(ErrorMsgEnum.SUCCESS.getErrorCode(), ErrorMsgEnum.SUCCESS.getErrorMsg());
        this.meta.setErrorMsg("正常");
        return this;
    }

    public Response success(Object data) {
        success();
        this.data = data;
        return this;
    }

    /***
     * 默认错误
     * @return
     */
    public Response failure() {
        this.meta = new Meta(ErrorMsgEnum.INTERNAL_ERROR.getErrorCode(), ErrorMsgEnum.INTERNAL_ERROR.getErrorMsg());
        return this;
    }

    /**
     * 指定前端显示错误信息
     *
     * @param errorMessage 显示的错误信息
     * @return
     */
    public Response failure(String errorMessage) {
        this.meta = new Meta(ErrorMsgEnum.INTERNAL_ERROR.getErrorCode());
        meta.setErrorMsg(errorMessage);
        return this;
    }

    /**
     * 返回前端传递参数
     * @param conditions
     * @return
     */
    public Response withConditions(String conditions) {
        this.meta.conditions = conditions;
        return this;
    }

    /**
     * 指定错误代码及错误追踪信息
     *
     * @param errorMsg  追踪信息
     * @param errorCode 错误代码
     * @return
     */
    public Response failureWithErrorMsg(String errorMsg, String errorCode) {
        this.meta = new Meta(errorCode);
        this.meta.setErrorMsg(errorMsg);
        return this;
    }

    /**
     * 根据错误枚举类来生成错误信息
     *
     * @param errorMsgEnum 错误枚举类
     * @return
     */
    public Response failure(ErrorMsgEnum errorMsgEnum) {
        this.meta = new Meta(errorMsgEnum.getErrorCode(), errorMsgEnum.getErrorMsg());
        return this;
    }

    /**
     * 根据错误枚举类来生成错误信息
     *
     * @param errorMsgEnum 错误枚举类
     * @param displayMsg   显示的错误信息
     * @return
     */
    public Response failure(ErrorMsgEnum errorMsgEnum, String displayMsg) {
        this.meta = new Meta(errorMsgEnum.getErrorCode(), errorMsgEnum.getErrorMsg());
        this.meta.setErrorMsg(displayMsg);
        return this;
    }

    public Meta getMeta() {
        return meta;
    }

    public Object getData() {
        return data;
    }

    /**
     * 将Response包装上Http Status
     * @return ResponseEntity
     */
    @JsonIgnore
    public ResponseEntity<Response> getResponseEntity(){
        String errorCode = ErrorMsgEnum.SUCCESS.getErrorCode();
        boolean success = errorCode.equals(getMeta().getErrorCode()+"");
        HttpStatus httpStatus = success ? HttpStatus.OK : HttpStatus.SERVICE_UNAVAILABLE;
        return new ResponseEntity<>(this, httpStatus);
    }

    /**
     * 包装data数据
     *
     * @param name
     * @param object
     * @return
     */
    public Response packageData(String name, Object object) {
        HashMap mapData;
        if (data != null && data instanceof HashMap) {
            mapData = (HashMap) getData();
            mapData.put(name, object);
        } else {
            mapData = new HashMap<>();
            mapData.put(name, object);
        }
        return success(mapData);

    }


    private class Meta {

        private int errorCode;
        private String errorMsg;
        private String trackMsg;
        private String conditions;


        Meta(String errorCodeStr) {
            this.errorCode = Integer.parseInt(errorCodeStr);
        }


        Meta(String errorCode, String trackMsg) {
            int code = Integer.parseInt(errorCode);
            setErrorCode(code);
            setTrackMsg(trackMsg);
        }

        public int getErrorCode() {
            return errorCode;
        }

        public String getErrorMsg() {
            return errorMsg;
        }

        void setErrorCode(int errorCode) {
            this.errorCode = errorCode;
        }

        void setErrorMsg(String errorMsg) {
            this.errorMsg = errorMsg;
        }

        public String getConditions() {
            return conditions;
        }

        public void setConditions(String conditions) {
            this.conditions = conditions;
        }

        public String getTrackMsg() {
            return trackMsg;
        }

        void setTrackMsg(String trackMsg) {
            this.trackMsg = trackMsg;
        }
    }
}
