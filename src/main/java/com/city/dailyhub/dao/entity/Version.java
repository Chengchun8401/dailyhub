package com.city.dailyhub.dao.entity;

import lombok.Data;

import java.time.LocalDate;

/**
 * @version v1.0
 * @ClassName: Version
 * @Description: TODO(一句话描述该类的功能)
 * @Author: CitySpring
 */
@Data
public class Version {

    private Integer id;

    private String info;

    private String user;

    private LocalDate updateTime;
}
