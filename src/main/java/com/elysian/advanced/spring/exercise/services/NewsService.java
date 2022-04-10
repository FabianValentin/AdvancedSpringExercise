package com.elysian.advanced.spring.exercise.services;

import com.elysian.advanced.spring.exercise.models.News;
import com.elysian.advanced.spring.exercise.repositories.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService {

    private final NewsRepository newsRepository;

    @Autowired
    public NewsService(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    public void createNews(final News news) {
        newsRepository.save(news);
    }

    public List<News> getNewsByAuthor(final String author) {
        return newsRepository.getByAuthor(author);
    }

}
