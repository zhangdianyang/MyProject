package com.zdy.serviceinterface;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author zdy
 */
public interface FallBackInterface {

    String sayHiFromFeign( String name);
}
