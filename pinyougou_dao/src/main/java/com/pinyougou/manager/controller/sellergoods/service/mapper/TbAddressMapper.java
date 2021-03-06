package com.pinyougou.manager.controller.sellergoods.service.mapper;

import com.pinyougou.manager.controller.sellergoods.service.pojo.TbAddressExample;
import com.pinyougou.manager.controller.sellergoods.service.pojo.TbAddress;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface TbAddressMapper {
    int countByExample(TbAddressExample example);

    int deleteByExample(TbAddressExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbAddress record);

    int insertSelective(TbAddress record);

    List<TbAddress> selectByExample(TbAddressExample example);

    TbAddress selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbAddress record, @Param("example") TbAddressExample example);

    int updateByExample(@Param("record") TbAddress record, @Param("example") TbAddressExample example);

    int updateByPrimaryKeySelective(TbAddress record);

    int updateByPrimaryKey(TbAddress record);
}