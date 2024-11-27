package com.example.api.controller;

import com.example.api.dto.MemberRequest;
import com.example.api.dto.MemberResponse;
import com.example.api.model.Member;
import com.example.api.repository.MemberRepository;
import com.example.api.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberController {
    private final MemberRepository memberRepository;
    private final MemberService memberService;

    @PostMapping()
    public MemberResponse post(@RequestBody MemberRequest memberRequest) {
        return memberService.create(memberRequest);
    }

    @GetMapping()
    public List<Member> get() {
        return memberRepository.findAll();
    }

    @GetMapping("/{id}")
    public Member getById(@PathVariable("id") Long id) {
        return memberRepository.findById(id).orElseThrow();
    }

    @PutMapping("/{id}")
    public Member put(@PathVariable("id") Long id, @RequestBody Member update) {
        Member member = memberRepository.findById(id).orElseThrow();
        update.setId(id);
        return memberRepository.save(update);
    }

    @PatchMapping("/{id}")
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

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        memberRepository.deleteById(id);
    }
}
