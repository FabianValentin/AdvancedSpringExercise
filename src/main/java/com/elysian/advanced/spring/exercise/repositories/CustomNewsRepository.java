package com.elysian.advanced.spring.exercise.repositories;

import com.elysian.advanced.spring.exercise.models.News;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface CustomNewsRepository {

    List<News> findAllByCustomSearch(Map<String, String> requestMapping);
}
