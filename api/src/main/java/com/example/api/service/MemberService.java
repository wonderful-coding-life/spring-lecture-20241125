package com.example.api.service;

import com.example.api.dto.MemberRequest;
import com.example.api.dto.MemberResponse;
import com.example.api.exception.NotFoundException;
import com.example.api.model.Member;
import com.example.api.repository.ArticleRepository;
import com.example.api.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final ArticleRepository articleRepository;

    public MemberResponse create(MemberRequest memberRequest) {
        Member member = Member.builder()
                .name(memberRequest.getName())
                .email(memberRequest.getEmail())
                .age(memberRequest.getAge())
                .password(memberRequest.getName() + "1234")
                .enabled(true).build();
        memberRepository.save(member);
        return mapToMemberResponse(member);
    }

    public MemberResponse update(Long id, MemberRequest memberRequest) {
        Member member = memberRepository.findById(id).orElseThrow(NotFoundException::new);
        member.setName(memberRequest.getName());
        member.setEmail(memberRequest.getEmail());
        member.setAge(memberRequest.getAge());
        memberRepository.save(member);
        return mapToMemberResponse(member);
    }

    public MemberResponse patch(Long id, MemberRequest memberRequest) {
        Member member = memberRepository.findById(id).orElseThrow(NotFoundException::new);
        if (memberRequest.getName() != null) {
            member.setName(memberRequest.getName());
        }
        if (memberRequest.getEmail() != null) {
            member.setEmail(memberRequest.getEmail());
        }
        if (memberRequest.getAge() != null) {
            member.setAge(memberRequest.getAge());
        }
        memberRepository.save(member);
        return mapToMemberResponse(member);
    }

    //@Transactional(rollbackOn = {Exception.class, RuntimeException.class})
    //@Transactional(rollbackFor = {Exception.class, RuntimeException.class})
    public List<MemberResponse> createBatch(List<MemberRequest> memberRequests) {
        //Thread.sleep(10);
        return memberRequests.stream().map(this::create).toList();
    }

    public MemberResponse findById(Long id) {
        Member member = memberRepository.findById(id).orElseThrow(NotFoundException::new);
        return mapToMemberResponse(member);
    }

    public List<MemberResponse> findAll(String name) {
        if (name != null) {
            return memberRepository.findByNameContainingOrderByNameAsc(name)
                    .stream()
                    .map(this::mapToMemberResponse)
                    .toList();
        } else {
            return memberRepository.findAll().stream().map(this::mapToMemberResponse).toList();
        }
//        List<Member> members = memberRepository.findAll();
//        List<MemberResponse> memberResponses = new ArrayList<>();
//        for (Member member : members) {
//            memberResponses.add(mapToMemberResponse(member));
//        }
//        return memberResponses;
    }

    public void delete(Long id) {
        Member member = memberRepository.findById(id).orElseThrow(NotFoundException::new);
        articleRepository.deleteByMember(member);
        memberRepository.deleteById(id);
    }

    private MemberResponse mapToMemberResponse(Member member) {
        return MemberResponse.builder()
                .id(member.getId())
                .name(member.getName())
                .email(member.getEmail())
                .age(member.getAge()).build();

    }
}
