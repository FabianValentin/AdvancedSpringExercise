package com.elysian.advanced.spring.exercise.responses;

import java.io.Serializable;
import java.util.List;

public class AvailableLanguagesResponseDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    List<String> availableLanguages;

    public List<String> getAvailableLanguages() {
        return availableLanguages;
    }

    public void setAvailableLanguages(List<String> availableLanguages) {
        this.availableLanguages = availableLanguages;
    }
}







