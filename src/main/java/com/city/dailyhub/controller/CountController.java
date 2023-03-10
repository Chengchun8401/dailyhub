package com.city.dailyhub.controller;

import com.city.dailyhub.common.cache.Cache;
import com.city.dailyhub.service.ICountService;
import com.city.dailyhub.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version v1.0
 * @ClassName: CountController
 * @Description: TODO(一句话描述该类的功能)
 * @Author: CitySpring
 */
@RestController
@RequestMapping("/collect/count")
public class CountController {

    @Autowired
    private ICountService countService;

    @GetMapping("/info")
    @Cache(name = "get_click_data")
    public Result getClickData(){
        return countService.getClickData();
    }


}
