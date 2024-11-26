package com.example.jpa.repository;

import com.example.jpa.model.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    // findById...
    List<Member> findByName(String name);
    List<Member> findByNameIs(String name);
    List<Member> findByNameEquals(String name);

    List<Member> findByEmail(String email);
    List<Member> findByNameAndEmail(String name, String email);
    List<Member> findByNameOrEmail(String name, String email);
    List<Member> findByNameStartingWith(String name);
    List<Member> findByNameEndingWith(String name);
    List<Member> findByNameContaining(String name);
    List<Member> findByNameLike(String name);

    List<Member> findByAge(int age);
    List<Member> findByAgeIsNull();
    List<Member> findByAgeGreaterThan(int age);
    List<Member> findByAgeGreaterThanEqual(int age);
    List<Member> findByAgeLessThan(int age);
    List<Member> findByAgeLessThanEqual(int age);
    List<Member> findByAgeBetween(int min, int max);

    List<Member> findByOrderByNameAsc();
    List<Member> findByOrderByNameDesc();
    List<Member> findByOrderByNameAscAgeDesc();
    List<Member> findByNameContaining(String name, Sort sort);
    Page<Member> findByNameContaining(String name, Pageable pageable);
}
