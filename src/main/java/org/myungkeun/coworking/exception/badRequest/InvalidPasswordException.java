package org.myungkeun.coworking.exception.badRequest;

import org.apache.coyote.BadRequestException;

public class InvalidPasswordException extends BadRequestException {
    public InvalidPasswordException() {
        super("비밀번호는 소문자, 숫자를 포함한 8자에서 20자로 구성되어야합니다");
    }
}
