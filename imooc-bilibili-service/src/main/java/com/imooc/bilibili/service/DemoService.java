package com.imooc.bilibili.service;

import com.imooc.bilibili.dao.DemoDao;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author 小喵
 * @date 2024/3/27
 */
@Service
public class DemoService {

    private final DemoDao demoDao;

    public DemoService(DemoDao demoDao) {
        this.demoDao = demoDao;
    }

    public Long query(Long id) {
        return demoDao.query(id);
    }

    public Map<String, Object> queryInfo(Long id) {
        return  demoDao.queryInfo(id);
    }
}
