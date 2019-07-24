/**
 * All rights Reserved, Designed By Robin
 * Copyright: Copyright(C) 2016-2020
 * Company    Robin  Co., Ltd.
 * <p>
 * Date:2019-07-23
 */
package com.robinye.mbp.client;

import com.robinye.mbp.vo.MbpUserVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * User Feign Client
 *
 * @author yetianbing
 * @version 1.0.0
 * @since jdk8
 */
@FeignClient(name = "${mbp.service.user}")
@RequestMapping(value = "/users", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
public interface UserFeignClient {
    @GetMapping("/{id}")
    MbpUserVO getUserVO(@PathVariable(name = "id") Long id);
}
