package com.example.mybatis.mapper;

import com.example.mybatis.model.Article;
import com.example.mybatis.model.Member;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

@SpringBootTest
@Slf4j
@Sql(scripts = {"classpath:/test-article.sql"})
public class ArticleMapperTests {

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private MemberMapper memberMapper;

    @Test
    public void findAll() {
        List<Article> articles = articleMapper.findAll();
        for (Article article : articles) {
            log.info("{}", article);
        }
    }

    @Test
    public void findById() {
        Article article = articleMapper.findById(1L).orElseThrow();
        log.info("{}", article);
    }

    @Test
    public void insert() {
        Member member = memberMapper.findByEmail("MiyeongKong@hanbit.co.kr").orElseThrow();
        Article article = Article.builder()
                .title("방학 첫날")
                .description("신난다. 방학이다.")
                .memberId(member.getId()).build();
        int insertedCount = articleMapper.insert(article);
        log.info("insert {}", insertedCount);
        log.info("inserted {}", article);
        log.info("inserted {}", articleMapper.findById(article.getId()));
    }

    @Test
    public void update() throws InterruptedException {
        Thread.sleep(2000);
        Article article = articleMapper.findById(1L).orElseThrow();
        int updatedCount = articleMapper.update(article.getId(), "방학 둘째날", "신난다. 어제부터 방학이다.");
        log.info("updatedCount {}", updatedCount);
        article = articleMapper.findById(article.getId()).orElseThrow();
        log.info("selectById {}", article);
    }
}
