package com.example.api.service;

import com.example.api.dto.MemberRequest;
import com.example.api.dto.MemberResponse;
import com.example.api.model.Member;
import com.example.api.repository.MemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@DisplayName("회원 비즈니스 로직 테스트")
public class MemberServiceTests {
    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberRepository memberRepository;

    @BeforeEach
    public void beforeEach() {
        memberRepository.deleteAll();
    }

    @AfterEach
    public void afterEach() {
        memberRepository.deleteAll();
    }

    @Test
    @DisplayName("회원 등록 테스트")
    public void createBatch() {
        List<MemberRequest> memberRequests = List.of(
                MemberRequest.builder().name("윤서준").email("SeojunYoon@hanbit.co.kr").age(10).build(),
                MemberRequest.builder().name("윤광철").email("KwangcheolYoon@hanbit.co.kr").age(43).build(),
                MemberRequest.builder().name("김도윤").email("DoyunKim@hanbit.co.kr").age(11).build(),
                MemberRequest.builder().name("공미영").email("MiyeongKong@hanbit.co.kr").age(28).build()
        );

        List<MemberResponse> memberResponses = memberService.createBatch(memberRequests);
        assertThat(memberResponses.size()).isEqualTo(4);
        assertThat(memberResponses.get(0).getId()).isNotNull();
    }
}
