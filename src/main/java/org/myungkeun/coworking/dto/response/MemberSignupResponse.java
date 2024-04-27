package org.myungkeun.coworking.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.myungkeun.coworking.domain.Member;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString

public class MemberSignupResponse {
    private Long id;
    private String email;
    private String nickname;
}
