package com.api.common.entitys;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @描述: 支付实体类
 * @Date: 2020/12/20 4:55 下午
 * @Author: hha
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {

    private long id;
    private String serial;

}
