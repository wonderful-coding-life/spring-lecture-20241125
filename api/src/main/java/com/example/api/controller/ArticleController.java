package com.example.api.controller;

import com.example.api.dto.ArticleRequest;
import com.example.api.dto.ArticleResponse;
import com.example.api.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/articles")
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleService articleService;

    @GetMapping()
    public List<ArticleResponse> get() {
        return articleService.findAll();
    }

    @GetMapping("/{id}")
    public ArticleResponse getById(@PathVariable("id") Long id) {
        return articleService.findById(id);
    }

    @PutMapping("/{id}")
    public ArticleResponse putById(@PathVariable("id") Long id, @RequestBody ArticleRequest articleRequest) {
        return articleService.update(id, articleRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        articleService.delete(id);
    }
}
