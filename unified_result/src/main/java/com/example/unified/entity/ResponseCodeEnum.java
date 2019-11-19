package com.example.unified.entity;

public enum ResponseCodeEnum implements ResponseCodeEnumSupper{

    /**
     * 定义返回码
     */
    RETURN_CODE_100200("100200", "请求成功"),
    RETURN_CODE_100401("100401", "权限不足"),
    RETURN_CODE_100402("100402", "数据库操作异常"),
    RETURN_CODE_100403("100403", "参数不允许为空"),
    RETURN_CODE_100404("100404", "请求资源不存在"),
    RETURN_CODE_100500("100500", "系统异常"),
    RETURN_CODE_100400("100200", "请求参数错误");
    private String code;
    private String msg;

    private ResponseCodeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
