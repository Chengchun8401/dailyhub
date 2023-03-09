package com.city.dailyhub.controller;

import com.city.dailyhub.dao.entity.Version;
import com.city.dailyhub.service.IVersionService;
import com.city.dailyhub.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @version v1.0
 * @ClassName: VersionController
 * @Description: TODO(一句话描述该类的功能)
 * @Author: CitySpring
 */
@RestController
@RequestMapping("/collect/version")
public class VersionController {

    @Autowired
    private IVersionService versionService;

    @GetMapping("")
    public Result getVersionInfo(){
        List<Version> versions = versionService.list();
        return Result.success(null, versions);
    }

}
