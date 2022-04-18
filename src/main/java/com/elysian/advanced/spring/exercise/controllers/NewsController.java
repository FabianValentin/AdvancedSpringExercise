package com.elysian.advanced.spring.exercise.controllers;

import com.elysian.advanced.spring.exercise.models.News;
import com.elysian.advanced.spring.exercise.services.NewsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(
        path = "/api.currentsapi.services/v1"
)
public class NewsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(NewsController.class);

    private final NewsService newsService;

    @Autowired
    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @PostMapping("/createNews")
    public ResponseEntity<?> createNews(@RequestBody News news) {
        newsService.createNews(news);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/getNewsByAuthor/{author}")
    public List<News> getNewsByAuthor(@PathVariable final String author) {
        LOGGER.info("Start time: {}", new Date(System.currentTimeMillis()));
        List<News> news = newsService.getNewsByAuthor(author);
        LOGGER.info("Stop time: {}", new Date(System.currentTimeMillis()));
        return news;
    }

    @GetMapping("/search")
    public List<News> getNewsByCustomSearch(@RequestParam Map<String,String> requestParams) {
        requestParams.entrySet().forEach(entry -> LOGGER.info("Filter name {} filter value {}", entry.getKey(), entry.getValue()));
        List<News> news = newsService.findBySpecialSearch(requestParams);
        return news;
    }

    @GetMapping("/latest-news")
    public List<News> getLatestNews(@RequestParam String language){
        LOGGER.info("Start time: {}", new Date(System.currentTimeMillis()));
        List<News> news = newsService.getNewsByLanguage(language);
        LOGGER.info("Stop time: {}", new Date(System.currentTimeMillis()));
        return news;
    }

}
