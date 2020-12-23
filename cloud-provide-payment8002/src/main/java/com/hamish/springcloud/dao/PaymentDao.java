package com.hamish.springcloud.dao;

import com.api.common.entitys.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @描述:
 * @Date: 2020/12/20 5:25 下午
 * @Author: hha
 */
@Mapper
public interface PaymentDao {

    int create(Payment payment);

    Payment getPaymentById(@Param("id") long id);

}
