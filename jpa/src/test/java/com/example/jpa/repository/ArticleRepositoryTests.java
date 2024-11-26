package com.example.jpa.repository;

import com.example.jpa.model.Article;
import com.example.jpa.model.Member;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
@Slf4j
@Sql(scripts = {"classpath:/test-script.sql"})
public class ArticleRepositoryTests {
    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void findAll() {
        List<Article> articles = articleRepository.findAll();
        for (Article article : articles) {
            log.info("{}", article);
        }
    }

    @Test
    public void save() throws InterruptedException {
        Member member = memberRepository.findById(1L).orElseThrow();
        Article article = Article.builder()
                .title("개학 전날")
                .description("꿀꿀하다")
                .member(member).build();
        articleRepository.save(article);
        log.info("after saved {}", article);

        Thread.sleep(2000);

        article.setTitle("벌써 개학 전날이다");
        articleRepository.save(article);
        log.info("after queried {}", articleRepository.findById(article.getId()));
    }
}
