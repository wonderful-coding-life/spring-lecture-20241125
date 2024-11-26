package com.example.mybatis.mapper;

import com.example.mybatis.model.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface MemberMapper {
    List<Member> findAll();
    Member findById(@Param("id") Long id);
    Optional<Member> findByEmail(@Param("email") String email);
    List<Member> findAllOrderBy(@Param("order") String order);
    int count();
    int save(@Param("member") Member member);
    int update(@Param("member") Member member);
    int delete(@Param("id") Long id);
}
