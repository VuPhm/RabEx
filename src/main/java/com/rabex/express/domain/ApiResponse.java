package com.rabex.express.domain;

public class ApiResponse<T> {
    private boolean success;
    private int code;
    private T data;

    public ApiResponse(boolean success, int code, T data) {
        this.success = success;
        this.code = code;
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
