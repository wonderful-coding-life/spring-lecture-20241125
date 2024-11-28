package com.example.bbs.repository;

import com.example.bbs.model.Authority;
import com.example.bbs.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
    List<Authority> findByMember(Member member);
}
