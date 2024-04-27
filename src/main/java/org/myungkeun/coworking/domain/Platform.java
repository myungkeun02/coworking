package org.myungkeun.coworking.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter

public enum Platform {
    APPLE("apple"),
    KAKAO("kakao"),
    NAVER("naver"),
    GOOGLE("google"),
    EMAIL("email");

    private String value;

    public static Platform from(String value) {
        return Arrays.stream(values())
                .filter(it -> Objects.equals(it.value, value))
                .findFirst()
                .orElseThrow();
    }
}
