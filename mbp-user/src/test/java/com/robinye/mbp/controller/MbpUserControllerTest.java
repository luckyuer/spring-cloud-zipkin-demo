/**
 * All rights Reserved, Designed By Robin
 * Copyright: Copyright(C) 2016-2020
 * Company    Robin  Co., Ltd.
 * <p>
 * Date:2019-07-23
 */
package com.robinye.mbp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.robinye.mbp.MbpUserApplication;
import com.robinye.mbp.vo.MbpUserVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * User controller 测试用例类
 *
 * @author yetianbing
 * @version 1.0.0
 * @since jdk8
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MbpUserApplication.class)
public class MbpUserControllerTest {
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private ObjectMapper jacksonObjectMapper;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    /**
     * @see MbpUserController#getUser(Long)
     * @throws Exception
     */
    @Test
    public void testGetUser() throws Exception {
        long id = 1;
        RequestBuilder request = MockMvcRequestBuilders.get("/users/" + id)
                .contentType(MediaType.APPLICATION_JSON_UTF8);

        MvcResult mvcResult = mockMvc.perform(request).andReturn();

        int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();


        log.info("Result status：{}.", status);
        Assert.assertEquals(200, status);

        log.info("Result content:{}.", content);

        if (StringUtils.isEmpty(content)) {
            return;
        }

        MbpUserVO mbpUserVO = jacksonObjectMapper.readValue(content, MbpUserVO.class);
        log.info("MbpUserVO: {}.", mbpUserVO);
    }
}
