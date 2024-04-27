package org.myungkeun.coworking.exception.badRequest;

import lombok.Getter;
import org.apache.coyote.BadRequestException;

@Getter
public class DuplicateMemberException extends BadRequestException {
    public DuplicateMemberException() {
        super("이미 존재하는 회원입니다");
    }
}
