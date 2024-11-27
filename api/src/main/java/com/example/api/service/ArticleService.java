package com.example.api.service;

import com.example.api.dto.ArticleRequest;
import com.example.api.dto.ArticleResponse;
import com.example.api.exception.NotFoundException;
import com.example.api.model.Article;
import com.example.api.model.Member;
import com.example.api.repository.ArticleRepository;
import com.example.api.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final MemberRepository memberRepository;
    private final ArticleRepository articleRepository;

    public ArticleResponse create(Long id, ArticleRequest articleRequest) {
        Member member = memberRepository.findById(id).orElseThrow(NotFoundException::new);
        Article article = Article.builder()
                .title(articleRequest.getTitle())
                .description(articleRequest.getDescription())
                .member(member).build();
        articleRepository.save(article);
        return mapToArticleResponse(article);
    }

    public List<ArticleResponse> findAll() {
        return articleRepository.findAll()
                .stream()
                .map(this::mapToArticleResponse)
                .toList();
    }

    public ArticleResponse findById(Long id) {
        Article article = articleRepository.findById(id).orElseThrow(NotFoundException::new);
        return mapToArticleResponse(article);
    }

    public ArticleResponse update(Long id, ArticleRequest articleRequest) {
        Article article = articleRepository.findById(id).orElseThrow(NotFoundException::new);
        article.setTitle(articleRequest.getTitle());
        article.setDescription(articleRequest.getDescription());
        articleRepository.save(article);
        return mapToArticleResponse(article);
    }

    public void delete(Long id) {

        Article article = articleRepository.findById(id).orElseThrow(NotFoundException::new);
        articleRepository.delete(article);
    }

    private ArticleResponse mapToArticleResponse(Article article) {
        return ArticleResponse.builder()
                .id(article.getId())
                .memberId(article.getMember().getId())
                .name(article.getMember().getName())
                .email(article.getMember().getEmail())
                .title(article.getTitle())
                .description(article.getDescription())
                .created(article.getCreated())
                .updated(article.getUpdated()).build();
    }

}
