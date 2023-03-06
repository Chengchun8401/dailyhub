package com.city.dailyhub.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.city.dailyhub.dao.entity.Collect;
import com.city.dailyhub.vo.CollectClick;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface CollectMapper extends BaseMapper<Collect> {

    IPage<Collect> getAllCollect(Page<Collect> page, @Param("search_title") String title);

    IPage<Collect> getCollectionInfo(Page<Collect> page);

    List<CollectClick> getCollectClick();
}
