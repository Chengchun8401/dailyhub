package com.city.dailyhub.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.city.dailyhub.dao.entity.Collect;
import com.city.dailyhub.vo.PageParam;
import com.city.dailyhub.vo.Result;

public interface ICollectService extends IService<Collect> {
    /**
     * 分页拉取书签信息
     * @param pageParam
     * @return
     */
    Result getCollectionsByPage(PageParam pageParam);

    /**
     * 点击量自增
     * @param id
     * @return
     */
    Result clickIncrease(Long id);

    /**
     * 获取书签完整信息
     * @return
     */
    Result getCollectionInfo(PageParam pageParam);

    /**
     * 获取书签名以及点击量
     * @return
     */
    Result getCollectClick();
}
