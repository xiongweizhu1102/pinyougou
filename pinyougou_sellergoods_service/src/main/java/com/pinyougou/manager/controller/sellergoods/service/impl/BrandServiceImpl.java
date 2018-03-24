package com.pinyougou.manager.controller.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pinyougou.manager.controller.sellergoods.service.BrandService;
import com.pinyougou.manager.controller.sellergoods.service.entity.PageResult;
import com.pinyougou.manager.controller.sellergoods.service.mapper.TbBrandMapper;
import com.pinyougou.manager.controller.sellergoods.service.pojo.TbBrand;
import com.pinyougou.manager.controller.sellergoods.service.pojo.TbBrandExample;
import jdk.nashorn.internal.runtime.arrays.IteratorAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author bear
 * @version 1.0
 * @description com.pinyougou.sellergoods.service.impl
 * @date 2018/3/23
 */
@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private TbBrandMapper tbBrandMapper;
    @Override
    public List<TbBrand> findAll() {
        return tbBrandMapper.selectByExample(null);
    }

    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        //分页插件传递进去当前页数和每页显示数据条数
        PageHelper.startPage(pageNum,pageSize);
        //将查到的品牌列表转换为pageBean
        Page<TbBrand> page = (Page<TbBrand>) tbBrandMapper.selectByExample(null);
        //封装页面需要的商品列表和总数据条数
        return new PageResult(page.getTotal(),page.getResult());
    }

    @Override
    public void add(TbBrand brand) {
        tbBrandMapper.insert(brand);
    }

    @Override
    public TbBrand findOne(Long id) {
        return tbBrandMapper.selectByPrimaryKey(id);
    }

    @Override
    public void update(TbBrand brand) {
        tbBrandMapper.updateByPrimaryKey(brand);
    }

    @Override
    public void delete(Long[] ids) {
        for (Long id : ids) {
            tbBrandMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public PageResult findPage(TbBrand brand, int pageNum, int pageSize) {

        //设置查询条件
        TbBrandExample example = new TbBrandExample();
        TbBrandExample.Criteria criteria = example.createCriteria();
        if (brand != null) {
            if (brand.getName() != null && brand.getName().length() > 0) {
                criteria.andNameLike("%" + brand.getName() + "%");
            }
            if (brand.getFirstChar() != null && brand.getFirstChar().length() > 0) {
                criteria.andFirstCharEqualTo(brand.getFirstChar());
            }
        }
        //分页插件进行设置页码和每页显示数据条数
        PageHelper.startPage(pageNum, pageSize);
        //将查询出来的品牌集合转换成一个page对象
        Page<TbBrand> page = (Page<TbBrand>) tbBrandMapper.selectByExample(example);
        return  new PageResult(page.getTotal(),page.getResult());

    }
}
