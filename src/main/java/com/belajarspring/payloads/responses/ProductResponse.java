package com.belajarspring.payloads.responses;

public class ProductResponse {
    private Integer status;
    private String message;
    private Object data;


    // Constructor
    public ProductResponse() {

    }

    public ProductResponse(Integer status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    // setter and getter
    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Object getData() {
        return this.data;
    }
}
