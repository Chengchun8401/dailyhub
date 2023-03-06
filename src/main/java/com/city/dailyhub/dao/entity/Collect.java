package com.city.dailyhub.dao.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.time.LocalDate;

@Data
public class Collect {

    // 解决雪花算法id到前端精度丢失问题
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    /**
     * 标题
     */
    private String title;

    /**
     * 图标
     */
    private String icon;

    /**
     * 链接
     */
    private String url;

    /**
     * 权重
     */
    private Integer weight;

    /**
     * 描述
     */
    private String description;

    /**
     * 创建日期
     */
    private LocalDate createDate;

    /**
     *  可见性
     */
    private Integer visible;

    /**
     * 点击量统计
     */
    @TableField(exist = false)
    private Count count;

}
