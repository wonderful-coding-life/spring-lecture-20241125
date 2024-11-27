package com.example.api.service;

import com.example.api.dto.MemberRequest;
import com.example.api.dto.MemberResponse;
import com.example.api.model.Member;
import com.example.api.repository.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
public class MemberServiceUnitTests {
    @Autowired
    private MemberService memberService;

    @MockBean
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
