package com.elysian.advanced.spring.exercise.services;

import com.elysian.advanced.spring.exercise.models.News;
import com.elysian.advanced.spring.exercise.repositories.NewsRepository;
import com.elysian.advanced.spring.exercise.responses.AvailableCategoriesResponseDTO;
import com.elysian.advanced.spring.exercise.responses.AvailableLanguagesResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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

    public List<News> getNewsByLanguageOrderByPublished(final String language){
        return newsRepository.getAllByLanguageOrderByPublishedDesc(language);
    }

    public List<News> findBySpecialSearch(final Map<String, String> searchFilters) {

        return newsRepository.findAllByCustomSearch(searchFilters);
    }

    public AvailableLanguagesResponseDTO getAvailableLanguages(){
        List<String> languages = newsRepository.getAvailableLanguages();
        AvailableLanguagesResponseDTO availableLanguagesResponseDTO = new AvailableLanguagesResponseDTO();
        availableLanguagesResponseDTO.setAvailableLanguages(languages);
        return availableLanguagesResponseDTO;
    }

    public AvailableCategoriesResponseDTO getAvailableCategories(){
        List<String> categories = newsRepository.getAvailableCategories();
        AvailableCategoriesResponseDTO availableCategoriesResponseDTO = new AvailableCategoriesResponseDTO();
        availableCategoriesResponseDTO.setAvailableCategories(categories);
        return availableCategoriesResponseDTO;
    }

}
