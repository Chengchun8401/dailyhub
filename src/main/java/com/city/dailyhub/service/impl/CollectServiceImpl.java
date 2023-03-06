package com.city.dailyhub.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.city.dailyhub.dao.entity.Collect;
import com.city.dailyhub.dao.entity.Count;
import com.city.dailyhub.dao.mapper.CollectMapper;
import com.city.dailyhub.dao.mapper.CountMapper;
import com.city.dailyhub.service.ICollectService;
import com.city.dailyhub.vo.CollectClick;
import com.city.dailyhub.vo.PageParam;
import com.city.dailyhub.vo.PageVo;
import com.city.dailyhub.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CollectServiceImpl extends ServiceImpl<CollectMapper, Collect> implements ICollectService{

    @Autowired
    private CollectMapper collectMapper;

    @Autowired
    private CountMapper countMapper;

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

    @Override
    public Result clickIncrease(Long id) {
        Count collectCounts = countMapper.selectOne(new QueryWrapper<Count>().eq("collectId", id)
                .eq("clickDate", LocalDate.now()));

        if (collectCounts == null){
            Count count = new Count();
            count.setCollectId(id);
            count.setClick(1);
            count.setClickDate(LocalDate.now());
            int insert = countMapper.insert(count);
            if(insert < 1){
                return Result.fail("点击量更新失败", 555);
            }
        } else{
            collectCounts.setClick(collectCounts.getClick() + 1);
            int update = countMapper.updateById(collectCounts);
            if(update < 1){
                return Result.fail("点击量更新失败", 555);
            }
        }

        return Result.success(null, 200);
    }

    @Override
    public Result getCollectionInfo(PageParam pageParam) {
        PageVo pageVo = new PageVo();
        // 开启分页
        Page<Collect> page = new Page<>(pageParam.getCurrentPage(), pageParam.getPageSize());
        // 获取数据
        IPage<Collect> collectPage = collectMapper.getCollectionInfo(page);

        pageVo.setTotal(collectPage.getTotal());
        pageVo.setData(collectPage.getRecords());

        return Result.success(null, pageVo);
    }

    @Override
    public Result getCollectClick() {
        List<CollectClick> data = collectMapper.getCollectClick();
        return Result.success(null, data);
    }

}
