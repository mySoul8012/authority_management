package com.ming.ssm.service;

import com.ming.ssm.domain.Orders;

import java.util.List;

public interface IOrderService {
    public List<Orders> findAll(int page, int size) throws Exception;

    public int save(Orders orders)throws Exception;
}
