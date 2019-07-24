package com.robinye.mbp.service.impl;

import com.robinye.mbp.converter.MbpUserConvertor;
import com.robinye.mbp.entity.MbpUser;
import com.robinye.mbp.mapper.MbpUserMapper;
import com.robinye.mbp.service.IMbpUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.robinye.mbp.vo.MbpUserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author mybatis generator
 * @since 2019-07-23
 */
@Service
public class MbpUserServiceImpl extends ServiceImpl<MbpUserMapper, MbpUser> implements IMbpUserService {

    @Autowired
    private MbpUserConvertor mbpUserConvertor;

    @Override
    public MbpUserVO getUser(Long id) {
        MbpUser mbpUser = getById(id);
        return mbpUserConvertor.toVO(mbpUser);
    }
}
