package com.city.dailyhub.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.city.dailyhub.dao.entity.Collect;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CollectMapper extends BaseMapper<Collect> {

    IPage<Collect> getAllCollect(Page<Collect> page, @Param("search_title") String title);
}
