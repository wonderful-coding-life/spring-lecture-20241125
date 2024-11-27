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
    private final MemberService memberService;

    @PostMapping()
    public MemberResponse post(@RequestBody MemberRequest memberRequest) {
        return memberService.create(memberRequest);
    }

    @PostMapping("/batch")
    public List<MemberResponse> postBatch(@RequestBody List<MemberRequest> memberRequests) {
        return memberService.createBatch(memberRequests);
    }

    @GetMapping()
    public List<MemberResponse> get() {
        return memberService.findAll();
    }

    @GetMapping("/{id}")
    public MemberResponse getById(@PathVariable("id") Long id) {
        return memberService.findById(id);
    }

    @PutMapping("/{id}")
    public MemberResponse put(@PathVariable("id") Long id, @RequestBody MemberRequest update) {
        return memberService.update(id, update);
    }

    @PatchMapping("/{id}")
    public MemberResponse patch(@PathVariable("id") Long id, @RequestBody MemberRequest update) {
        return memberService.patch(id, update);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        memberService.delete(id);
    }
}
