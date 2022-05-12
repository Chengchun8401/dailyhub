package com.city.dailyhub.controller;

import com.city.dailyhub.dao.entity.Collect;
import com.city.dailyhub.service.ICollectService;
import com.city.dailyhub.vo.PageParam;
import com.city.dailyhub.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping(path = "/collect")
public class CollectController {

    @Autowired
    private ICollectService collectService;

    @GetMapping("/all")
    public Result getCollections(PageParam pageParam){
        return collectService.getCollectionsByPage(pageParam);
    }

    @DeleteMapping("/{id}")
    public Result deleteCollection(@PathVariable Long id){
        if(collectService.removeById(id)){
            return Result.success("删除成功", null);
        }

        return Result.fail("删除失败",402);
    }

    @PutMapping("")
    public Result updateCollection(@RequestBody Collect collect){
        if(collectService.updateById(collect)){
            return Result.success("更新成功", null);
        }

        return Result.fail("更新失败",402);
    }

    @PostMapping("")
    public Result addCollection(@RequestBody Collect collect){
        collect.setId(null);
        collect.setCreateDate(LocalDate.now());

        if(collectService.save(collect)){
            return Result.success("添加成功", null);
        }

        return Result.fail("添加失败",402);
    }

}
