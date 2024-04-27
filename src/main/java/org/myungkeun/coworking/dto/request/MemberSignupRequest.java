package org.myungkeun.coworking.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString

public class MemberSignupRequest {
    private String email;
    private String password;
    private String nickname;
}
