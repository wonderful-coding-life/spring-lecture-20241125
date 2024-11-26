package com.example.jpa.repository;

import com.example.jpa.model.Member;
import com.example.jpa.model.MemberStats;
import com.example.jpa.model.MemberStatsNative;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
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

    @Query("SELECT m.name, m.email, COUNT(a.id) as count FROM Member m LEFT JOIN Article a ON a.member = m GROUP BY m ORDER BY count DESC")
    List<Object[]> getMemberStatsObject();

    @Query(value="SELECT m.name, m.email, count(a.id) AS count FROM member m LEFT JOIN article a ON m.id = a.member_id GROUP BY m.id ORDER BY count DESC", nativeQuery = true)
    List<Object[]> getMemberStatsNativeObjects();

    @Query("SELECT new com.example.jpa.model.MemberStats(m.name, m.email, COUNT(a.id) as count) FROM Member m LEFT JOIN Article a ON a.member = m GROUP BY m ORDER BY count DESC")
    List<MemberStats> getMemberStats();

    @Query(value="SELECT m.name, m.email, count(a.id) AS count FROM member m LEFT JOIN article a ON m.id = a.member_id GROUP BY m.id ORDER BY count DESC", nativeQuery = true)
    List<MemberStatsNative> getMemberStatsNative();
}
