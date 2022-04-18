package com.elysian.advanced.spring.exercise.repositories.impl;

import com.elysian.advanced.spring.exercise.models.News;
import com.elysian.advanced.spring.exercise.repositories.CustomNewsRepository;
import com.elysian.advanced.spring.exercise.repositories.NewsRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CustomNewsRepositoryImpl implements CustomNewsRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override public List<News> findAllByCustomSearch(Map<String, String> requestMapping) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<News> query = cb.createQuery(News.class);
        Root<News> news = query.from(News.class);

        List<Predicate> predicates = new ArrayList<>();

        requestMapping.entrySet().stream().forEach(entry -> {
            Path<String> searchByCriteria = news.get(entry.getKey());
            predicates.add(cb.like(searchByCriteria, entry.getValue()));
        });

        query.select(news)
             .where(cb.and(predicates.toArray(new Predicate[predicates.size()])));

        return entityManager.createQuery(query)
                            .getResultList();
    }
}
