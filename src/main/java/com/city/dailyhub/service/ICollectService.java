package com.city.dailyhub.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.city.dailyhub.dao.entity.Collect;
import com.city.dailyhub.vo.PageParam;
import com.city.dailyhub.vo.Result;

public interface ICollectService extends IService<Collect> {
    Result getCollectionsByPage(PageParam pageParam);
}
