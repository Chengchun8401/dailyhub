package com.city.dailyhub.service;

import com.city.dailyhub.vo.LoginParam;
import com.city.dailyhub.vo.Result;

public interface ILoginService {

    Result login(LoginParam loginParam);

}
