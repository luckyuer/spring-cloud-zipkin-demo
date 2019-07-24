package com.robinye.mbp.controller;


import com.robinye.mbp.service.IMbpUserService;
import com.robinye.mbp.vo.MbpUserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  User前端控制器
 * </p>
 *
 * @author mybatis generator
 * @since 2019-07-23
 */
@RestController
@RequestMapping("/users")
public class MbpUserController {
    @Autowired
    private IMbpUserService iMbpUserService;

    @GetMapping("/{id}")
    public MbpUserVO getUser(@PathVariable(name = "id") Long id) {
        return iMbpUserService.getUser(id);
    }
}
