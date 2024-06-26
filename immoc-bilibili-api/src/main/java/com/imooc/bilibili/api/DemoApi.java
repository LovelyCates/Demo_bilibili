package com.imooc.bilibili.api;

import com.imooc.bilibili.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author 小喵
 * @date 2024/3/27
 */
@RestController
public class DemoApi {

    @Autowired
    private DemoService demoService;

    @GetMapping("/query")
    public Long query(Long id) {
        return demoService.query(id);
    }

    @GetMapping("/queryInfo")
    public Map<String, Object> queryInfo(Long id) {
        return demoService.queryInfo(id);
    }


}
