package com.city.dailyhub.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.city.dailyhub.dao.entity.Collect;
import com.city.dailyhub.dao.mapper.CollectMapper;
import com.city.dailyhub.service.ICollectService;
import com.city.dailyhub.vo.PageParam;
import com.city.dailyhub.vo.PageVo;
import com.city.dailyhub.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CollectServiceImpl extends ServiceImpl<CollectMapper, Collect> implements ICollectService{

    @Autowired
    private CollectMapper collectMapper;

    @Override
    public Result getCollectionsByPage(PageParam pageParam) {
        PageVo pageVo = new PageVo();
        // 开启分页
        Page<Collect> page = new Page<>(pageParam.getCurrentPage(), pageParam.getPageSize());
        // 获取数据
        IPage<Collect> collectPage = collectMapper.getAllCollect(page, pageParam.getTitle());

        pageVo.setTotal(collectPage.getTotal());
        pageVo.setData(collectPage.getRecords());

        return Result.success(null, pageVo);
    }
}
