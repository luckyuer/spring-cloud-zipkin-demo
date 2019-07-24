/**
 * All rights Reserved, Designed By Robin
 * Copyright: Copyright(C) 2016-2020
 * Company    Robin  Co., Ltd.
 * <p>
 * Date:2019-07-23
 */
package com.robinye.mbp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin2.server.internal.EnableZipkinServer;

/**
 * Zipkin 服务端驱动类
 *
 * @author yetianbing
 * @version 1.0.0
 * @since jdk8
 */

@SpringBootApplication
@EnableZipkinServer
public class MbpZipkinApplication {
    public static void main(String[] args) {
        SpringApplication.run(MbpZipkinApplication.class, args);
    }
}
