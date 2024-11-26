package com.example.jpa.repository;

import com.example.jpa.model.Member;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@Slf4j
@Sql(scripts = {"classpath:/test-member.sql"})
public class MemberRepositoryTests {
    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void findAll() {
        List<Member> members = memberRepository.findAll();
        for (Member member : members) {
            log.info("{}", member);
        }
    }

    @Test
    public void findById() {
        log.info("{}", memberRepository.findById(1L));
    }

    @Test
    public void findByName() {
        log.info("{}", memberRepository.findByName("윤서준"));
    }

    @Test
    public void findByEmail() {
        log.info("{}", memberRepository.findByEmail("MiyeongKong@hanbit.co.kr"));
    }

    @Test
    public void findByAgeGreaterThan() {
        List<Member> members = memberRepository.findByAgeGreaterThan(12);
        for (Member member : members) {
            log.info("{}", member);
        }
    }

    @Test
    public void findByNameStartingWith() {
        List<Member> members = memberRepository.findByNameStartingWith("윤");
        for (Member member : members) {
            log.info("{}", member);
        }
    }

    @Test
    public void update() {
        Member member = memberRepository.findById(1L).orElseThrow();
        member.setName("윤서준2");
        memberRepository.save(member);
        log.info("{}", memberRepository.findById(1L));
    }

    @Test
    public void save() {
        Member member = Member.builder().name("홍길동").email("hong@hanbit.co.kr").build();
        memberRepository.save(member);
    }


}
