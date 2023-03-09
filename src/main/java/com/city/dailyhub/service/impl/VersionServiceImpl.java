package com.city.dailyhub.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.city.dailyhub.dao.entity.Version;
import com.city.dailyhub.dao.mapper.VersionMapper;
import com.city.dailyhub.service.IVersionService;
import org.springframework.stereotype.Service;

/**
 * @version v1.0
 * @ClassName: VersionServiceImpl
 * @Description: TODO(一句话描述该类的功能)
 * @Author: CitySpring
 */
@Service
public class VersionServiceImpl extends ServiceImpl<VersionMapper, Version> implements IVersionService {
}
