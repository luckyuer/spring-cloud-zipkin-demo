package com.robinye.mbp.vo;

import com.robinye.mbp.base.common.AbstractVO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
public class MbpUserVO extends AbstractVO {
    private Long id;

    private String name;

    private Integer gender;

    private Boolean deleted;
}
