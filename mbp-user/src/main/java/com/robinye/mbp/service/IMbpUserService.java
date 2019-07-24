package com.robinye.mbp.service;

import com.robinye.mbp.entity.MbpUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.robinye.mbp.vo.MbpUserVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author mybatis generator
 * @since 2019-07-23
 */
public interface IMbpUserService extends IService<MbpUser> {
    MbpUserVO getUser(Long id);
}
