package com.city.dailyhub.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.city.dailyhub.dao.entity.Admin;
import com.city.dailyhub.dao.mapper.AdminMapper;
import com.city.dailyhub.service.IAdminService;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {

}
