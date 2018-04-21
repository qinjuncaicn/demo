package com.qjc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author qinjuncai
 * @description: 通用页面跳转
 * @create 2018/04/21 10:16
 */
@RequestMapping("/page")
@Controller
public class PageController {

    /**
     * 通用页面跳转
     *
     * @param tomode 跳转模块
     * @param topage 跳转页面
     * @return
     */
    @RequestMapping(value = "{tomode}/{topage}", method = RequestMethod.GET)
    public String functionList(@PathVariable("tomode") String tomode, @PathVariable("topage") String topage) {
        return tomode + "/" + topage;
    }
}
