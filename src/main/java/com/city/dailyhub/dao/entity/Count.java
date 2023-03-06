package com.city.dailyhub.dao.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.time.LocalDate;

/**
 * @version v1.0
 * @ClassName: Count
 * @Description: TODO(一句话描述该类的功能)
 * @Author: CitySpring
 */
@Data
public class Count {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    /**
     * 书签Id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long collectId;

    /**
     * 点击日期
     */
    private LocalDate clickDate;

    /**
     * 点击量
     */
    private Integer click;

}
