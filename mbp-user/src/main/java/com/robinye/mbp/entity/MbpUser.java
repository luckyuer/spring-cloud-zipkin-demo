package com.robinye.mbp.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户实体类
 * </p>
 *
 * @author mybatis generator
 * @since 2019-07-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ToString
@Accessors(chain = true)
@TableName("mbp_user")
public class MbpUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    private Long id;

    @TableField
    private String name;

    @TableField
    private Integer gender;

    @TableField
    private Boolean deleted;
}
