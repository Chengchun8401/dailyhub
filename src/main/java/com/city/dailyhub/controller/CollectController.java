package com.city.dailyhub.controller;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.city.dailyhub.common.cache.Cache;
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

    @GetMapping("/info")
    public Result getCollectionInfo(PageParam pageParam){
        return collectService.getCollectionInfo(pageParam);
    }

    @Cache(name = "get_collect_click")
    @GetMapping("/pre")
    public Result getCollectClick(){
        return collectService.getCollectClick();
    }

    @DeleteMapping("/{id}")
    public Result deleteCollection(@PathVariable Long id){
        boolean update = collectService.update(new UpdateWrapper<Collect>().eq("id", id).set("visible", 0));
        if(update){
            return Result.success("删除成功", null);
        }
        return Result.fail("删除失败",402);
    }

    @PutMapping("/{id}")
    public Result changeCollection(@PathVariable Long id){
        boolean update = collectService.update(new UpdateWrapper<Collect>().eq("id", id).set("visible", 1));
        if(update){
            return Result.success("修改成功", null);
        }
        return Result.fail("操作失败",402);
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

    @GetMapping("/increase/{id}")
    public Result clickIncrease(@PathVariable Long id){
        return collectService.clickIncrease(id);
    }

}
