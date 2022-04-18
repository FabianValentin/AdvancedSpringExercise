package com.elysian.advanced.spring.exercise.services;

import com.elysian.advanced.spring.exercise.models.News;
import com.elysian.advanced.spring.exercise.repositories.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    public List<News> getNewsByLanguage(final String language){
        return newsRepository.getByLanguage(language).stream().sorted(newsDateComparator).collect(Collectors.toList());
    }

    public List<News> findBySpecialSearch(final Map<String, String> searchFilters) {

        return newsRepository.findAllByCustomSearch(searchFilters);
    }

    public static Comparator< News > newsDateComparator = new Comparator<News>() {
        @Override public int compare(News o1, News o2) {
            return o1.getPublished().compareTo(o2.getPublished());
        }
    };
}
