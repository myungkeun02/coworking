package org.myungkeun.coworking.exception.badRequest;

import org.apache.coyote.BadRequestException;

public class InvalidNicknameException extends BadRequestException {
    public InvalidNicknameException() {
        super("닉네임은 영어 한글로만 구성된 2자에서 6자여야합니다.");
    }
}
