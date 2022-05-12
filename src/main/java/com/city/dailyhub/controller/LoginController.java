package com.city.dailyhub.controller;

import com.city.dailyhub.service.ILoginService;
import com.city.dailyhub.vo.LoginParam;
import com.city.dailyhub.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/collect/login")
public class LoginController {

    @Autowired
    private ILoginService loginService;

    @PostMapping("")
    public Result login(@RequestBody LoginParam loginParam){
        return loginService.login(loginParam);
    }

}
