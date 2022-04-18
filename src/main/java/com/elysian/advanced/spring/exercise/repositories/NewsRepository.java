package com.elysian.advanced.spring.exercise.repositories;

import com.elysian.advanced.spring.exercise.models.News;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<News, Integer>, CustomNewsRepository {

    @Cacheable(cacheNames = "news_by_author", key = "#author")
    List<News> getByAuthor(String author);

    @Cacheable(cacheNames = "news_by_language", key = "#language")
    List<News> getByLanguage(String language);


    @Scheduled(cron = "0 0/30 * * * ?")
    @CacheEvict(value = "news_by_author")
    default void clearNewsByAuthorCache(){

    }

    @Scheduled(cron = "0 0/30 * * * ?")
    @CacheEvict(value = "news_by_language")
    default void clearNewsByLanguageCache(){

    }
}
