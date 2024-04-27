package org.myungkeun.coworking.exception.badRequest;

import org.apache.coyote.BadRequestException;

public class InvalidEmailException extends BadRequestException {
    public InvalidEmailException() {
        super("이메일 형식이 올바르지 않습니다.");
    }
}
