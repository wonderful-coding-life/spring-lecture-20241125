package com.example.api.controller;

import com.example.api.model.Member;
import com.example.api.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MemberController {
    @Autowired
    private MemberRepository memberRepository;

    @PostMapping("/api/members")
    public Member post(@RequestBody Member member) {
        return memberRepository.save(member);
    }

    @GetMapping("/api/members")
    public List<Member> get() {
        return memberRepository.findAll();
    }

    @GetMapping("/api/members/{id}")
    public Member getById(@PathVariable("id") Long id) {
        return memberRepository.findById(id).orElseThrow();
    }

    @PutMapping("/api/members/{id}")
    public Member put(@PathVariable("id") Long id, @RequestBody Member update) {
        Member member = memberRepository.findById(id).orElseThrow();
        update.setId(id);
        return memberRepository.save(update);
    }

    @PatchMapping("/api/members/{id}")
    public Member patch(@PathVariable("id") Long id, @RequestBody Member update) {
        Member member = memberRepository.findById(id).orElseThrow();
        if (update.getName() != null) {
            member.setName(update.getName());
        }
        if (update.getEmail() != null) {
            member.setEmail(update.getEmail());
        }
        if (update.getAge() != null) {
            member.setAge(update.getAge());
        }
        return memberRepository.save(member);
    }

    @DeleteMapping("/api/members/{id}")
    public void delete(@PathVariable("id") Long id) {
        memberRepository.deleteById(id);
    }
}
