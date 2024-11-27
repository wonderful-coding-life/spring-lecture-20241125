package com.example.api.repository;

import com.example.api.model.Article;
import com.example.api.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    @Transactional
    void deleteByMember(Member member);
}
