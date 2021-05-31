package com.douyuehan.doubao.controller;

import com.douyuehan.doubao.common.api.ApiResult;
import com.douyuehan.doubao.model.entity.BmsPromotion;
import com.douyuehan.doubao.service.IBmsPromotionService;

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
@RequestMapping("/promotion")
public class BmsPromotionController extends BaseController {

    @Resource
    private IBmsPromotionService bmsPromotionService;

    @GetMapping("/all")
    public ApiResult<List<BmsPromotion>> list() {
        List<BmsPromotion> list = bmsPromotionService.list();
        return ApiResult.success(list);
    }

    @PostMapping("/update")
    public ApiResult<BmsPromotion> update(@Valid @RequestBody BmsPromotion promotion) {
       
        bmsPromotionService.updateById(promotion);
        return ApiResult.success(promotion);
    }

    @DeleteMapping("/delete/{id}")
    public ApiResult<String> delete(@PathVariable("id") String id) {
        bmsPromotionService.removeById(id);
        return ApiResult.success(null,"删除成功");
    }
}
