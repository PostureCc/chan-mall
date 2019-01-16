package com.chan.exception;

public enum ErrorCodes {
    SUCCESS("成功", "0"),
    PARAMETERS_OF_THE_ABNORMAL("参数异常","5004"),
    USER_IS_NULL("没有找到该用户的信息", "4404"),
    RESULT_SYS_ERR("系统服务异常,请稍后再试", "-1"),
    ;

    private String msg;

    private String code;

    private ErrorCodes(String msg, String code) {
        this.msg = msg;
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return this.getCode() + "  :  " + this.getMsg();
    }

}
