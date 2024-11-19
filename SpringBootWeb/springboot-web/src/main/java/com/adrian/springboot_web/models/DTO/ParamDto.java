package com.adrian.springboot_web.models.DTO;

public class ParamDto {

    private String message;
    private Integer code;

    public ParamDto() {
    }

    public ParamDto(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

}
