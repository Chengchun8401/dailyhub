package com.city.dailyhub.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.city.dailyhub.dao.entity.Count;
import com.city.dailyhub.dao.entity.CountInfo;
import com.city.dailyhub.dao.mapper.CountMapper;
import com.city.dailyhub.service.ICountService;
import com.city.dailyhub.vo.CountVo;
import com.city.dailyhub.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @version v1.0
 * @ClassName: CountServiceImpl
 * @Description: TODO(一句话描述该类的功能)
 * @Author: CitySpring
 */
@Service
public class CountServiceImpl extends ServiceImpl<CountMapper, Count> implements ICountService {

    @Autowired
    private CountMapper countMapper;

    @Override
    public Result getClickData() {
        CountVo countVo = new CountVo();

        Integer totalClick = countMapper.getTotalClick();
        Integer weekClick = countMapper.getWeekClick();
        List<CountInfo> weeklyClick = countMapper.getWeeklyClick();

        countVo.setTotalClick(totalClick);
        countVo.setWeekClick(weekClick);
        countVo.setData(weeklyClick);

        return Result.success(null, countVo);
    }
}
