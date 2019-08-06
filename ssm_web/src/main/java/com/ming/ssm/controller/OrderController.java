package com.ming.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.ming.ssm.domain.Orders;
import com.ming.ssm.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private IOrderService oserService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1")int page, @RequestParam(name="size", required = true, defaultValue = "5") int size) throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        List<Orders> orders = oserService.findAll(page, size);
        PageInfo pageInfo = new PageInfo(orders);
        modelAndView.addObject("pageInfo", pageInfo);
        modelAndView.setViewName("order-list");
        return modelAndView;
    }

    @RequestMapping("/save.do")
    public ModelAndView save(Orders orders)throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        if(oserService.save(orders) == 1){
            modelAndView.setViewName("success");
        }else{
            modelAndView.setViewName("error");
        }
        return modelAndView;
    }
}
