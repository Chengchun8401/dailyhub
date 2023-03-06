package com.city.dailyhub.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.city.dailyhub.dao.entity.Count;
import com.city.dailyhub.dao.entity.CountInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @version v1.0
 * @InterfaceName: ContMapper
 * @Description: TODO(一句话描述该类的功能)
 * @Author: CitySpring
 */
@Mapper
public interface CountMapper extends BaseMapper<Count> {

    Integer getTotalClick();

    Integer getWeekClick();

    List<CountInfo> getWeeklyClick();

}
