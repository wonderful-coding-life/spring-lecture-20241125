package com.example.demo.mapper;

import com.example.demo.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class MemberMapper {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private MemberRowMapper memberRowMapper;

    public List<Member> findAll() {
        return jdbcTemplate.query("SELECT * FROM member", memberRowMapper);
    }

    public Optional<Member> findById(long id) {
        List<Member> members = jdbcTemplate.query("SELECT * FROM member WHERE id=?", memberRowMapper, id);
        return members.stream().findFirst();
    }
}
