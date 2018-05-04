package com.wux.controller;

import com.alibaba.fastjson.JSON;
import com.wux.entity.Carousel;
import com.wux.service.CarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by wuxiang
 * on 2018/4/20.
 */
@Controller
@RequestMapping("carousel")
public class CarouselController {
    @Autowired
    private CarouselService carouselService;

    @RequestMapping("view")
    public ModelAndView toView(){
        ModelAndView modelAndView = new ModelAndView("../views/carousel");
        List<Carousel> list = carouselService.findAll();
        modelAndView.getModelMap().put("list",list);
        return modelAndView;
    }

    @RequestMapping(value = "findOne",produces = "text/plain; charset=utf-8")
    @ResponseBody
    public String findOne(String id){
        return JSON.toJSONString(carouselService.findCarousel(id) );
    }

    @RequestMapping(value = "findAll", produces = "text/html; charset=utf-8")
    @ResponseBody
    public String findAll() {
        return JSON.toJSONString(carouselService.findAll());
    }

    @RequestMapping("add")
    public void addCarousel(Carousel carousel){
        carouselService.addCarousel(carousel);
    }

    @RequestMapping("remove")
    public void removeCarousel(Integer id){
        carouselService.removeCarousel(id);
    }

    @RequestMapping("modify")
    public void modifyCarousel(Carousel carousel){
        carouselService.modifyCarousel(carousel);
    }
}
