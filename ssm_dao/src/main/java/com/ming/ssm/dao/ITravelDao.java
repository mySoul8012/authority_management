package com.ming.ssm.dao;

import com.ming.ssm.domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ITravelDao {
    @Select("")
    public List<Traveller> findByOrderById(String orderId) throws Exception;
}
