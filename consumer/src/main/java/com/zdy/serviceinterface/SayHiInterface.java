package com.zdy.serviceinterface;

import com.zdy.service.SayHiInterfaceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author zdy
 */
@FeignClient(value = "PROVIDER",fallback = SayHiInterfaceImpl.class)
public interface SayHiInterface {

    /**
     * 接口调用
     * @param name
     * @return
     */
    @RequestMapping(value = "/hi")
    String sayHiFromFeign(@RequestParam(value = "name") String name);
}
