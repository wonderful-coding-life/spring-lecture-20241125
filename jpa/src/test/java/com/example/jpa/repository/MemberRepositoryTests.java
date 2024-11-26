package com.example.jpa.repository;

import com.example.jpa.model.Member;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@Slf4j
@Sql(scripts = {"classpath:/test-script.sql"})
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
    public void findByOrderByNameAsc() {
        List<Member> members = memberRepository.findByOrderByNameAscAgeDesc();
        for (Member member : members) {
            log.info("{}", member);
        }
    }

    @Test
    public void findByNameContainingWithSort() {
        Sort sort = Sort.by(Sort.Order.asc("name"), Sort.Order.desc("age"));
        List<Member> members = memberRepository.findByNameContaining("윤", sort);
        for (Member member : members) {
            log.info("{}", member);
        }
    }

    @Test
    public void findByNameContainingWithPageable() {
        Sort sort = Sort.by(Sort.Order.asc("name"), Sort.Order.desc("age"));
        Pageable pageable = PageRequest.of(0, 10,sort);
        Page<Member> memberPage = memberRepository.findByNameContaining("윤", pageable);
        log.info("getTotalElements = {}", memberPage.getTotalElements());
        log.info("getTotalPages = {}", memberPage.getTotalPages());
        for (Member member : memberPage.toList()) {
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

    @Test
    public void getMemberStatsObject() {
        List<Object[]> results = memberRepository.getMemberStatsObject();
        for (Object[] result : results) {
            log.info("{}, {}, {}", result[0], result[1], result[2]);
        }
    }
}
