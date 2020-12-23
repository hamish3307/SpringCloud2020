package com.api.common.entitys;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @描述:
 * @Date: 2020/12/20 5:21 下午
 * @Author: hha
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponce<T> {

    private int code;
    private String message;
    private T data;

    public ApiResponce(int code, String message) {
        this(code, message, null);
    }

    public static <T> ApiResponce success(T data) {
        return new ApiResponce(200, "操作成功", data);
    }

    public static ApiResponce error() {
        return error(null);
    }

    public static ApiResponce error(String message) {
        return new ApiResponce(404, message, null);
    }

}
