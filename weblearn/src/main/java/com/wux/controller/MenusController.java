package com.wux.controller;

import com.wux.entity.Menus;
import com.wux.entity.PageData;
import com.wux.service.MenusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by wuxiang
 * on 2018/5/12.
 */
@Controller
public class MenusController {
    @Autowired
    private MenusService menusService;

    @GetMapping("menus/{id}")
    @ResponseBody
    public Menus findMenus(@PathVariable("id") Integer id){
        return menusService.findMenus(id);
    }
    @GetMapping("menus")
    @ResponseBody
    public PageData<Menus> findAll(Integer page, Integer rows){
        /* easyui-datagrid颁布数据 */
        PageData<Menus> pageData = new PageData<>();
        List<Menus> list = menusService.findPage(page, rows);
        Integer count = menusService.count();
        pageData.setRows(list);
        pageData.setTotal(count);
        return pageData;
    }
    @PostMapping("menus")
    @ResponseBody
    public String addMenus(HttpServletRequest request, Menus menus) throws UnsupportedEncodingException {
        menusService.addMenus(menus);
        return "";
    }
    @DeleteMapping("menus/{id}")
    @ResponseBody
    public String removeMenus(@PathVariable("id")Integer id){
        menusService.removeMenus(id);
        return "";
    }
    @PutMapping("menus")
    @ResponseBody
    public String modifyMenus(Menus menus){
        System.out.println(menus);
        menusService.modifyMenus(menus);
        return "";
    }
}
