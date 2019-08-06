package com.ming.ssm.service.impl;

import com.ming.ssm.dao.IProductDao;
import com.ming.ssm.domain.Product;
import com.ming.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author ming
 */
@Service(value = "productService")
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductDao productDao;

    public List<Product> findAll() throws Exception {
        return productDao.findAll();
    }



    public int save(Product product) throws Exception{
        return productDao.save(product);
    }
}
