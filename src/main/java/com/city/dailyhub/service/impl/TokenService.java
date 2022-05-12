package com.city.dailyhub.service.impl;

import com.city.dailyhub.dao.entity.Admin;
import com.city.dailyhub.utils.JWTUtils;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class TokenService {

    public String getToken(Admin admin){
        return JWTUtils.createToken(admin);
    }

    public boolean checkToken(String token){
        if(Strings.isBlank(token)){
            return false;
        }

        Map<String, Object> result = JWTUtils.checkToken(token);

        if(result == null){ // token解析失败
            return false;
        }

        return true;
    }

}
