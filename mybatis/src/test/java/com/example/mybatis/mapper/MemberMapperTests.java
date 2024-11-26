package com.example.mybatis.mapper;

import com.example.mybatis.model.Member;
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
public class MemberMapperTests {
    @Autowired
    private MemberMapper memberMapper;

    @Test
    public void findAll() {
        List<Member> members = memberMapper.findAll();
        for (Member member : members) {
            log.info("{}", member);
        }
    }

    @Test
    public void findById() {
        Member member = memberMapper.findById(3L);
        log.info("{}", member);
    }

    @Test
    public void findByEmail() {
        Optional<Member> member = memberMapper.findByEmail("KwangcheolYoon@hanbit.co.kr");
        log.info("{}", member.orElseThrow());
    }

    @Test
    public void findAllOrderBy() {
        //List<Member> members = memberMapper.findAllOrderBy("age; DROP TABLE member; --");
        List<Member> members = memberMapper.findAllOrderBy("age");
        for (Member member : members) {
            log.info("{}", member);
        }
        log.info("{}", memberMapper.count());
    }

    @Test
    public void count() {
        log.info("count= {}", memberMapper.count());
    }

    @Test
    public void insert() {
        Member member = Member.builder()
                .name("홍길동")
                .email("hong@hanbit.co.kr")
                .age(12).build();
        memberMapper.save(member);
        log.info("count= {}", memberMapper.count());
        log.info("count= {}", memberMapper.findById(member.getId()));
    }
}
