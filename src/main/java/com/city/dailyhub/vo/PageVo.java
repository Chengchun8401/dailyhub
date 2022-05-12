package com.city.dailyhub.vo;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class PageVo {

    private Long total;

    private List<?> data;
}
