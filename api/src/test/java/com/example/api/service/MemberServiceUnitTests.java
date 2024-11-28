package com.example.api.service;

import com.example.api.dto.MemberResponse;
import com.example.api.model.Member;
import com.example.api.repository.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
@DisplayName("회원 서비스 단위 테스트")
public class MemberServiceUnitTests {
    @Autowired
    private MemberService memberService;

    @MockitoBean
    private MemberRepository memberRepository;

    @Test
    @DisplayName("회원 검색")
    public void findById() {
        when(memberRepository.findById(1L)).thenReturn(Optional.ofNullable(Member.builder()
                .id(1L)
                .name("윤서준")
                .email("yoon@hanbit.co.kr")
                .age(10).build()));
        MemberResponse memberResponse = memberService.findById(1L);
        assertThat(memberResponse).isNotNull();
        assertThat(memberResponse.getName()).isEqualTo("윤서준");
    }
}
