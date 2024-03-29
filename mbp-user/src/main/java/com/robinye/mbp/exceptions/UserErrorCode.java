/**
 * All rights Reserved, Designed By Robin
 * Copyright: Copyright(C) 2016-2020
 * Company    Robin  Co., Ltd.
 * <p>
 * Date:2019-07-12
 */
package com.robinye.mbp.exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.robinye.mbp.base.exception.ErrorCode;
import org.springframework.http.HttpStatus;

/**
 * Video错误代码和描述类
 *
 * @author yetianbing
 * @version 1.0.0
 * @since jdk8
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum  UserErrorCode implements ErrorCode {
    InvalidUser_IdIncorrect(HttpStatus.BAD_REQUEST,"InvalidUser.IdIncorrect", "User id is incorrect."),
    InvalidUser_NameIncorrect(HttpStatus.BAD_REQUEST,"InvalidUser.NameIncorrect", "User name is incorrect."),
    InvalidUser_NotFound(HttpStatus.NOT_FOUND,"InvalidUser.NotFound", "User can not be found."),
    ;

    private HttpStatus httpStatus;

    private String code;

    private String message;

    UserErrorCode(HttpStatus httpStatus, String code, String message) {
        this.httpStatus = httpStatus;
        this.code = code;
        this.message = message;
    }

    @Override public HttpStatus getHttpStatus() {
        return null;
    }

    @Override public String getCode() {
        return this.code;
    }

    @Override public String getMessage() {
        return this.message;
    }
}
