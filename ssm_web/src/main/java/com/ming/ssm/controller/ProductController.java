package com.ming.ssm.controller;

import com.ming.ssm.domain.Product;
import com.ming.ssm.domain.User;
import com.ming.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpSession;
import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @RequestMapping("/UserIndex.do")
    public ModelAndView index(HttpSession session) throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping("/findAll.do")
    @Secured(value = "ROLE_admin")
    public ModelAndView findAll() throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        List<Product> products = productService.findAll();
        modelAndView.addObject("products", products);
        modelAndView.setViewName("product-list");
        return modelAndView;
    }

    @RequestMapping(value = "/add.do" , method = RequestMethod.POST)
    public ModelAndView add(Product product) throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        int res = productService.save(product);
        if(res != 0){
            modelAndView.setViewName("success");
            return modelAndView;
        }else{
            modelAndView.setViewName("error");
            return modelAndView;
        }
    }
}
