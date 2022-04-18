package com.elysian.advanced.spring.exercise.responses;

import java.io.Serializable;
import java.util.List;

public class AvailableCategoriesResponseDTO implements Serializable {

    List<String> availableCategories;

    public List<String> getAvailableCategories() {
        return availableCategories;
    }

    public void setAvailableCategories(List<String> availableCategories) {
        this.availableCategories = availableCategories;
    }
}
