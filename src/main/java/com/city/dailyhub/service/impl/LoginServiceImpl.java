package com.city.dailyhub.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.city.dailyhub.dao.entity.Admin;
import com.city.dailyhub.service.IAdminService;
import com.city.dailyhub.service.ILoginService;
import com.city.dailyhub.vo.LoginParam;
import com.city.dailyhub.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements ILoginService {

    @Autowired
    private IAdminService adminService;

    @Autowired
    private TokenService tokenService;

    @Override
    public Result login(LoginParam loginParam) {
        Admin admin = adminService.getOne(new QueryWrapper<Admin>().eq("username", loginParam.getUsername()));

        if(admin == null){
            return Result.fail("账号不存在", 404);
        }

        if(!admin.getPassword().equals(loginParam.getPassword())){
            return Result.fail("账号密码错误",404);
        }

        return Result.success("欢迎访问", tokenService.getToken(admin));
    }
}
