package com.pinyougou.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.manager.controller.sellergoods.service.BrandService;
import com.pinyougou.manager.controller.sellergoods.service.entity.PageResult;
import com.pinyougou.manager.controller.sellergoods.service.entity.Result;
import com.pinyougou.manager.controller.sellergoods.service.pojo.TbBrand;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author bear
 * @version 1.0
 * @description com.pinyougou.manager.controller
 * @date 2018/3/23
 */
@Controller
@RequestMapping("/brand")//url窄化
public class BrandController {
    @Reference//利用dubbo注入对象
    private BrandService brandService;
    @ResponseBody
    @RequestMapping("/findAll")
    public List<TbBrand> findAll(){
        return brandService.findAll();
    }

    @RequestMapping("/findPage")
    @ResponseBody//对象回去,会变成json要加上responseBody
    public PageResult findPage(int pageNum,int pageSize){
     return  brandService.findPage(pageNum, pageSize);
    }
    @RequestMapping("/add")
    @ResponseBody//对象回去,会变成json要加上responseBody
    public Result add(@RequestBody TbBrand brand){
        try {
            brandService.add(brand);
            return new Result(true,"新增成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"新增失敗");
        }
    } @RequestMapping("/update")
    @ResponseBody//对象回去,会变成json要加上responseBody
    public Result update(@RequestBody TbBrand brand){
        try {
            brandService.update(brand);
            return new Result(true,"修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"修改失敗");
        }
    }
    @RequestMapping("/findOne")
    @ResponseBody//对象回去,会变成json要加上responseBody
    public TbBrand findOne(Long id){
        TbBrand brand = brandService.findOne(id);
        return brand;
    }
    @RequestMapping("/delete")
    @ResponseBody//对象回去,会变成json要加上responseBody
    public Result delete(Long[] ids){
        try {
            brandService.delete(ids);
            return new Result(true,"删除成功");
        }catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"删除失败");
        }
    }
    @RequestMapping("/search")
    @ResponseBody//对象回去,会变成json要加上responseBody
    //RequestBody是接收页面传递过来的json
    public PageResult search(@RequestBody TbBrand brand,int pageNum,int pageSize){
        return  brandService.findPage(brand,pageNum, pageSize);
    }
}
