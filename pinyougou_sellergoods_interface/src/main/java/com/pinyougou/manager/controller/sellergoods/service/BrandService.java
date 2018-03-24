package com.pinyougou.manager.controller.sellergoods.service;

import com.pinyougou.manager.controller.sellergoods.service.entity.PageResult;
import com.pinyougou.manager.controller.sellergoods.service.pojo.TbBrand;

import java.util.List;

/**
 * @author bear
 * @version 1.0
 * @description com.pinyougou
 * @date 2018/3/23
 */
public interface BrandService {
    public List<TbBrand> findAll();
    public PageResult findPage(int pageNum,int pageSize);
    public void  add(TbBrand brand);
    public TbBrand findOne(Long id);
    public void  update(TbBrand brand);
    public void  delete(Long[] ids);
    public PageResult findPage(TbBrand brand,int pageNum,int pageSize);
}
