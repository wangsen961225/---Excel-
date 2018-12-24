package com.zsx.crm_excel.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@EnableAutoConfiguration
@ComponentScan
public class HelloController {

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public ModelAndView hello(){
        System.out.println("...");
        return new ModelAndView("/index");
    }

}
