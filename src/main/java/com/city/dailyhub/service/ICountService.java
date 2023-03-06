package com.city.dailyhub.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.city.dailyhub.dao.entity.Count;
import com.city.dailyhub.vo.Result;

/**
 * @version v1.0
 * @InterfaceName: ICountService
 * @Description: TODO(一句话描述该类的功能)
 * @Author: CitySpring
 */
public interface ICountService extends IService<Count> {
    /**
     * 获取点击量信息
     * 1.总点击量
     * 2.近七日点击量
     * @return Result
     */
    Result getClickData();
}
