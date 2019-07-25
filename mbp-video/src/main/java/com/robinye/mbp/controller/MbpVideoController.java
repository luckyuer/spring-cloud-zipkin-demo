package com.robinye.mbp.controller;

import com.robinye.mbp.client.WebsiteFeignClient;
import com.robinye.mbp.service.IMbpVideoService;
import com.robinye.mbp.vo.MbpVideoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author mybatis generator
 * @since 2019-07-19
 */
@RestController
@RequestMapping("/videos")
public class MbpVideoController {
    @Autowired
    private IMbpVideoService iMbpVideoService;

    @Autowired
    private WebsiteFeignClient websiteFeignClient;

    @GetMapping(value = "/{id}")
    public MbpVideoVO getVideo(@PathVariable(value = "id") Long id) {
        return iMbpVideoService.getVideo(id);
    }

    @GetMapping(value = "")
    public List<MbpVideoVO> listVideos(@RequestParam(value = "name") String name) {
        return iMbpVideoService.listVideos(name);
    }

    @GetMapping(value = "/website")
    public String accessWebsite() {
        return websiteFeignClient.getAboutPage();
    }
}
