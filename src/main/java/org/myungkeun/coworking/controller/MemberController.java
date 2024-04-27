package org.myungkeun.coworking.controller;

import lombok.RequiredArgsConstructor;
import org.myungkeun.coworking.dto.request.MemberSignupRequest;
import org.myungkeun.coworking.dto.response.MemberSignupResponse;
import org.myungkeun.coworking.exception.badRequest.DuplicateMemberException;
import org.myungkeun.coworking.exception.badRequest.InvalidPasswordException;
import org.myungkeun.coworking.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/member")
@RequiredArgsConstructor

public class MemberController {
    private final MemberService memberService;
    @PostMapping("/signup")
    public ResponseEntity<MemberSignupResponse> signup(
            @RequestBody MemberSignupRequest memberSignupRequest
    ) throws DuplicateMemberException, InvalidPasswordException {
        MemberSignupResponse response = memberService.signup(memberSignupRequest);
        return ResponseEntity.ok(response);
    }
}
