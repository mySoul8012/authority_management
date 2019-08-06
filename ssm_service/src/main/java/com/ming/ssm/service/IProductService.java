package com.ming.ssm.service;

import com.ming.ssm.domain.Product;

import java.util.List;

public interface IProductService {
    public List<Product> findAll() throws Exception;

    public int save(Product product) throws Exception;
}
