package com.douyuehan.doubao.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.douyuehan.doubao.common.api.ApiResult;
import com.douyuehan.doubao.model.entity.BmsBillboard;
import com.douyuehan.doubao.service.IBmsBillboardService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/billboard")
public class BmsBillboardController extends BaseController {

    @Resource
    private IBmsBillboardService bmsBillboardService;

    @GetMapping("/show")
    public ApiResult<BmsBillboard> getNotices(){
        List<BmsBillboard> list = bmsBillboardService.list(new
                LambdaQueryWrapper<BmsBillboard>().eq(BmsBillboard::isShow,true));
        return ApiResult.success(list.get(list.size()- 1));
    }

    @GetMapping("/all")
    public ApiResult<List<BmsBillboard>> list() {
        List<BmsBillboard> list = bmsBillboardService.list();
        return ApiResult.success(list);
    }

    @PostMapping("/update")
    public ApiResult<BmsBillboard> update(@Valid @RequestBody BmsBillboard billborad) {
       
        bmsBillboardService.updateById(billborad);
        return ApiResult.success(billborad);
    }

    @DeleteMapping("/delete/{id}")
    public ApiResult<String> delete(@PathVariable("id") String id) {
        bmsBillboardService.removeById(id);
        return ApiResult.success(null,"删除成功");
    }
}
