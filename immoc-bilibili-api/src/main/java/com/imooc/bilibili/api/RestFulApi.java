package com.imooc.bilibili.api;

import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 小喵
 * @date 2024/3/28
 * @description get、delete、put 均具有幂等性，post 不具有幂等性。
 * 幂等性：多次请求，结果一致。
 */
@RestController
public class RestFulApi {
    private final Map<Integer, Map<String, Object>> dataMap;

    public RestFulApi() {
        this.dataMap = new HashMap<>();
        for (int i = 1; i <= 3; i++) {
            Map<String, Object> data = new HashMap<>();
            data.put("name", "小喵");
            data.put("id", i);
            this.dataMap.put(i, data);
        }
    }

    @GetMapping("/objects/{id}")
    public Map<String, Object> getObjectById(@PathVariable Integer id) {
        return this.dataMap.get(id);
    }

    @DeleteMapping("/objects/{id}")
    public String deleteObjectById(@PathVariable Integer id) {
        this.dataMap.remove(id);
        return "删除成功";
    }

    @PostMapping("/objects")
    public String addObject(@RequestBody Map<String, Object> object) {
        Integer[] integers = dataMap.keySet().toArray(new Integer[0]);
        Arrays.sort(integers);
        int nextId = integers[integers.length - 1] + 1;
        dataMap.put(nextId, object);
        return "添加成功";
    }

    @PutMapping("/objects")
    public String updateObject(@RequestBody Map<String, Object> object) {

        Integer id = Integer.valueOf(String.valueOf(object.get("id")));

        Map<String, Object> containedData = dataMap.get(id);

        if (containedData == null) {
            Integer[] integers = dataMap.keySet().toArray(new Integer[0]);
            Arrays.sort(integers);
            int nextId = integers[integers.length - 1] + 1;
            dataMap.put(nextId, object);
        } else {
            dataMap.put(id, object);
        }

        return "更新成功";
    }

}
