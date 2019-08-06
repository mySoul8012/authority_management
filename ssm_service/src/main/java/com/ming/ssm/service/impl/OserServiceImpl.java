package com.ming.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.ming.ssm.dao.IOrderDao;
import com.ming.ssm.domain.Orders;
import com.ming.ssm.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "oserService")
public class OserServiceImpl implements IOrderService {
    @Autowired
    private IOrderDao iOrderDao;

    public List<Orders> findAll(int page, int size) throws Exception {
        PageHelper.startPage(page,size);
        return iOrderDao.findAll();
    }


    public int save(Orders orders) throws Exception {
        return iOrderDao.save(orders);
    }
}
