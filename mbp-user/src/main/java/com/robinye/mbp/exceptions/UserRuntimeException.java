/**
 * All rights Reserved, Designed By Robin
 * Copyright: Copyright(C) 2016-2020
 * Company    Robin  Co., Ltd.
 * <p>
 * Date:2019-07-12
 */
package com.robinye.mbp.exceptions;

import com.robinye.mbp.base.exception.BaseRuntimeException;
import com.robinye.mbp.base.exception.ErrorCode;

/**
 * User异常处理类
 *
 * @author yetianbing
 * @version 1.0.0
 * @since jdk8
 */

public class UserRuntimeException extends BaseRuntimeException {
    public UserRuntimeException(ErrorCode errorCode) {
        super(errorCode);
    }

    public UserRuntimeException(ErrorCode errorCode, Throwable cause) {
        super(errorCode, cause);
    }

    public UserRuntimeException(Throwable cause) {
        super(cause);
    }

    public UserRuntimeException(String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
