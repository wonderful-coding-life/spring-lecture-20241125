package com.example.bbs.controller;

import com.example.bbs.dto.TestForm;
import com.example.bbs.dto.TestFormValidation;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test/form")
@Slf4j
public class FormTestController {
    @GetMapping("/a")
    public String getA() {
        return "test-form-a";
    }

    @PostMapping("/a")
    public String postA(String name) {
        log.info("post a {}", name);
        return "redirect:/";
    }

    @GetMapping("/b")
    public String getB() {
        return "test-form-b";
    }

    @PostMapping("/b")
    public String postB(TestForm testForm) {
        log.info("post b {}", testForm);
        return "redirect:/";
    }

    @GetMapping("/c")
    public String getC(@ModelAttribute("testForm") TestForm testForm) {
        testForm.setName("홍길동...");
        testForm.setAddress("서울시...");
        return "test-form-c";
    }

    @PostMapping("/c")
    public String postC(@ModelAttribute("testForm") TestForm testForm) {
        log.info("post c {}", testForm);

        boolean hasError = false;
        if (testForm.getName().isBlank()) {
            testForm.setName("이름을 넣으시라니까요");
            hasError = true;
        }
        if (testForm.getAddress().isBlank()) {
            testForm.setAddress("주소는 꼭 입력해야 합니다");
            hasError = true;
        }

        if (hasError) {
            return "/test-form-c";
        }

        return "redirect:/";
    }

    @GetMapping("/d")
    public String getD(@ModelAttribute("testForm") TestFormValidation testForm) {
        return "test-form-d";
    }

    @PostMapping("/d")
    public String postD(@Valid @ModelAttribute("testForm") TestFormValidation testForm, BindingResult bindingResult) {
        log.info("post d {}", testForm);
        if (testForm.getName().equals("admin")) {
            bindingResult.rejectValue("name", "NotAllowed", "사용할 수 없는 이름입니다");
        }

        if (bindingResult.hasErrors()) {
            return "test-form-d";
        }

        return "redirect:/";
    }
}
