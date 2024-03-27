package com.imooc.bilibili.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 * @author 小喵
 * @date 2024/3/27
 */
@Mapper
public interface DemoDao {

    public Long query(Long id);

    public Map<String, Object> queryInfo(Long id);
}
