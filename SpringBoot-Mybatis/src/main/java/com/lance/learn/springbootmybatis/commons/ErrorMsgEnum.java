package com.lance.learn.springbootmybatis.commons;

/**
 * @Auther: Lance(ZYH)
 * @Date: 2018/8/28 10:05
 * @Description:    错误信息枚举类
 */
public enum ErrorMsgEnum {
    //10xx 成功
    SUCCESS("1000", "Success"),

    //11xx 失败

    //内部错误
    INTERNAL_ERROR("1101", "Internal error!"),
    //内部参数错误
    INTERNAL_PARAM_ERROR("1102", "Internal param error!"),


    //12xx 数据库操作失败

    //重复的数据
    DUPLICATE_KEY("1202", "Duplicate key!"),
    //添加失败
    ADD_FAILURE("1203", "Add failed!"),
    //更新失败
    UPDATE_FAILURE("1204", "Update failed!"),
    //删除失败
    DELETE_FAILURE("1205", "Delete failed!"),
    //查询失败
    QUERY_FAILURE("1206", "Query failed!"),


    //13xx 外部错误

    //Index Service错误
    ES_ERROR("1301", "Index Service error!"),
    //参数错误
    PARAM_ERROR("1302", "Param error!"),
    //认证错误
    AUTH_ERROR("1303", "认证错误"),
    //Store Service错误
    STORE_SERVICE_ERROR("1304", "Store Service error!");

    private String errorCode;
    private String errorMsg;

    ErrorMsgEnum(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
