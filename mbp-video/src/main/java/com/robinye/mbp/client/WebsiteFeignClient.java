/**
 * All rights Reserved, Designed By Robin
 * Copyright: Copyright(C) 2016-2020
 * Company    Robin  Co., Ltd.
 * <p>
 * Date:2019-07-23
 */
package com.robinye.mbp.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * User Feign Client
 *
 * @author yetianbing
 * @version 1.0.0
 * @since jdk8
 */
@FeignClient(name = "website-service", url = "${mbp.website.url}")
@RequestMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
public interface WebsiteFeignClient {
    @GetMapping("/about/")
    String getAboutPage();
}
