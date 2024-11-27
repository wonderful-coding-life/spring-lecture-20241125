package com.example.api.repository;

import com.example.api.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    List<Member> findByNameContainingOrderByNameAsc(String name);
    Optional<Member> findByName(String name);
}
