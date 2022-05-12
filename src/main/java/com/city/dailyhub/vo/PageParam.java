package com.city.dailyhub.vo;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class PageParam {

    private Integer currentPage;

    private Integer pageSize;

    private String title;
}
