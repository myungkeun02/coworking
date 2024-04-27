package org.myungkeun.coworking.controller;

import lombok.RequiredArgsConstructor;
import org.myungkeun.coworking.dto.request.MemberSignupRequest;
import org.myungkeun.coworking.dto.response.IsDuplicateEmailResponse;
import org.myungkeun.coworking.dto.response.IsDuplicateNicknameResponse;
import org.myungkeun.coworking.dto.response.MemberSignupResponse;
import org.myungkeun.coworking.exception.badRequest.DuplicateMemberException;
import org.myungkeun.coworking.exception.badRequest.InvalidEmailException;
import org.myungkeun.coworking.exception.badRequest.InvalidNicknameException;
import org.myungkeun.coworking.exception.badRequest.InvalidPasswordException;
import org.myungkeun.coworking.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/check-duplicate/email")
    private ResponseEntity<IsDuplicateEmailResponse> checkDuplicateEmail(
            @RequestParam String value
    ) throws InvalidEmailException {
        IsDuplicateEmailResponse response = memberService.isDuplicateEmail(value);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/check-duplicate/nickname")
    private ResponseEntity<IsDuplicateNicknameResponse> checkDuplicateNickname(
            @RequestParam String value
    ) throws InvalidNicknameException {
        IsDuplicateNicknameResponse response = memberService.isDuplicateNickname(value);
        return ResponseEntity.ok(response);
    }
}
