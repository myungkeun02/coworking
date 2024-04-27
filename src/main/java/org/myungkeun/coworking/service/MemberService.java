package org.myungkeun.coworking.service;

import lombok.RequiredArgsConstructor;
import org.myungkeun.coworking.domain.Member;
import org.myungkeun.coworking.domain.Platform;
import org.myungkeun.coworking.dto.request.MemberSignupRequest;
import org.myungkeun.coworking.dto.response.MemberSignupResponse;
import org.myungkeun.coworking.exception.badRequest.DuplicateMemberException;
import org.myungkeun.coworking.exception.badRequest.InvalidPasswordException;
import org.myungkeun.coworking.repository.MemberRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor

public class MemberService {

    private static final Pattern PASSWORD_REGEX = Pattern.compile("^(?=.*[a-z])(?=.*\\d)[a-z\\d]{8,20}$");
    private static final int EMAIL_VERIFY_CODE_MAXIMUM_NUMBER = 9999;

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;


    public MemberSignupResponse signup(MemberSignupRequest request) throws DuplicateMemberException, InvalidPasswordException {

        validatePassword(request.getPassword());
        validateDuplicateMember(request);
        String encodedPassword = passwordEncoder.encode(request.getPassword());

        try {
            Member member = new Member(request.getEmail(), request.getNickname(), encodedPassword, Platform.EMAIL);
            Member save = memberRepository.save(member);
            return new MemberSignupResponse(save.getId(), save.getEmail(), save.getNickname());
        } catch (DataIntegrityViolationException e) {
            throw new DuplicateMemberException();
        }
    }

    private void validateDuplicateMember(MemberSignupRequest request) throws DuplicateMemberException {
        if (memberRepository.existsByEmailAndPlatform(request.getEmail(), Platform.EMAIL)) {
            throw new DuplicateMemberException();
        }
        validateDuplicateNickname(request.getNickname());
    }

    private void validateDuplicateNickname(String nickname) throws DuplicateMemberException {
        if (memberRepository.existsByNickname(nickname)) {
            throw new DuplicateMemberException();
        }
    }

    private void validatePassword(String password) throws InvalidPasswordException {
        if (!PASSWORD_REGEX.matcher(password).matches()) {
            throw new InvalidPasswordException();
        }
    }
}
