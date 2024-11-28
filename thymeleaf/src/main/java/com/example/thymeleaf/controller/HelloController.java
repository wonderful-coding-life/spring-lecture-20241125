package com.example.thymeleaf.controller;

import com.example.thymeleaf.model.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HelloController {
    @GetMapping("/hello")
    public String getHello() {
        return "hello";
    }

    @GetMapping("/model")
    public String getModel(Model model) {
        model.addAttribute("name", "윤서준");
        model.addAttribute("email", "SeojoonYun@hanbit.co.kr");

        Member member = Member.builder()
                .id(1L)
                .name("윤광철")
                .email("KwangcheolYun@hanbit.co.kr")
                .age(43).build();
        model.addAttribute("member", member);

        return "model";
    }

    @GetMapping("/list")
    public String getList(Model model) {
        var members = List.of(Member.builder().name("윤서준").email("SeojunYoon@hanbit.co.kr").age(10).build(),
                Member.builder().name("윤광철").email("KwangcheolYoon@hanbit.co.kr").age(43).build(),
                Member.builder().name("공미영").email("MiyeongKong@hanbit.co.kr").age(23).build(),
                Member.builder().name("김도윤").email("DoyunKim@hanbit.co.kr").age(10).build());

        model.addAttribute("members", members);

        //return "list";
        //return "list-with-common";
        return "list-baselayout";
    }

    @GetMapping("/link")
    public String getLink(Model model) {
        model.addAttribute("memberId", 3);
        return "link";
    }


}
