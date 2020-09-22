package com.suning.cn.controller;

import com.suning.cn.service.HomeService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tangchaochao
 * @create 2020-2020-09-22 09:33
 */
@Log4j
@RestController
@RequestMapping(value = "/home")
public class HomeController {

    @Autowired
    private HomeService homeService;

    @PostMapping(value = "/chosen")
    public void chosen() {
        homeService.getChosenGoods();
    }


}
