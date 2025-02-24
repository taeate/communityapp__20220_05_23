package com.example.backend.article.service;

import com.example.backend.article.dto.ArticleDTO;
import com.example.backend.article.entity.Article;
import com.example.backend.article.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {

    private final ModelMapper mapper;
    private final ArticleRepository articleRepository;

    /**
     * article create service
     */
    @Override
    public Optional<ArticleDTO> createArticle(ArticleDTO articleDTO) {
        Article article = mapper.map(articleDTO, Article.class);
        article.setArticleId(UUID.randomUUID().toString());

        articleRepository.save(article);

        ArticleDTO savedArticleDTO = mapper.map(article, ArticleDTO.class);

        return Optional.ofNullable(savedArticleDTO);
    }
}
