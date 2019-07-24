package com.robinye.mbp.converter;

import com.robinye.mbp.base.common.AbstractBeanConvertor;
import com.robinye.mbp.entity.MbpUser;
import com.robinye.mbp.vo.MbpUserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component public class MbpUserConvertor extends AbstractBeanConvertor<MbpUser, MbpUserVO> {
    @Override public MbpUser toEntity(MbpUserVO mbpUserVO) {
        if (mbpUserVO == null) {
            return null;
        }

        MbpUser mbpUser = new MbpUser();
        BeanUtils.copyProperties(mbpUserVO, mbpUser);

        return mbpUser;
    }

    @Override public MbpUserVO toVO(MbpUser mbpUser) {
        if (mbpUser == null) {
            return null;
        }

        MbpUserVO mbpUserVO = new MbpUserVO();
        BeanUtils.copyProperties(mbpUser, mbpUserVO);

        return mbpUserVO;
    }
}
