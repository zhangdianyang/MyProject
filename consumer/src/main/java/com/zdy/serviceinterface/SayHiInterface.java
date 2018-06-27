package com.zdy.serviceinterface;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author zdy
 */
@FeignClient(value = "PROVIDER")
public interface SayHiInterface {

    /**
     * 接口调用
     * @param name
     * @return
     */
    @RequestMapping(value = "/hi")
    String sayHiFromFeign(@RequestParam(value = "name") String name);
}
