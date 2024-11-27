package com.example.api.repository;

import com.example.api.model.Member;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@DisplayName("회원 테스트")
public class MemberRepositoryTests {
    @Autowired
    private MemberRepository memberRepository;

    @BeforeEach
    public void beforeEach() {
        memberRepository.deleteAll();
        memberRepository.save(Member.builder().name("윤서준").email("SeojunYoon@hanbit.co.kr").age(10).enabled(true).build());
        memberRepository.save(Member.builder().name("윤광철").email("KwangcheolYoon@hanbit.co.kr").age(43).enabled(true).build());
        memberRepository.save(Member.builder().name("공미영").email("MiyeongKong@hanbit.co.kr").age(26).enabled(false).build());
        memberRepository.save(Member.builder().name("김도윤").email("DoyunKim@hanbit.co.kr").age(10).enabled(true).build());
    }

    @AfterEach
    public void afterEach() {
        memberRepository.deleteAll();
    }

    @Test
    @DisplayName("전체 회원 조회")
    public void findAll() {
        List<Member> members = memberRepository.findAll();
        assertThat(members.size()).isEqualTo(4);
    }

    @RepeatedTest(3)
    @DisplayName("이름 검색 테스트")
    //@Disabled("데이터베이스 변경 견으로 잠시 테스트 보류")
    public void findByName() {
        Member member = memberRepository.findByName("윤서준").orElse(null);
        assertThat(member).isNotNull();
        List<Member> members = memberRepository.findByNameContainingOrderByNameAsc("윤");
        assertThat(members.size()).isEqualTo(3);
    }
}
