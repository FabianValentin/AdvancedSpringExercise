package com.elysian.advanced.spring.exercise.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "News")
public class News {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "author", nullable = false, length = 50)
    private String author;

    @Column(name = "category", nullable = false, length = 50)
    private String category;

    @Column(name = "description", length = 100)
    private String description;

    @Column(name = "image", length = 100)
    private String image;

    @Column(name = "language", length = 10)
    private String language;

    @Column(name = "published")
    private Date published;

    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @Column(name = "url", length = 200)
    private String url;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Date getPublished() {
        return published;
    }

    public void setPublished(Date published) {
        this.published = published;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override public String toString() {
        return "News{" +
               "author='" + author + '\'' +
               ", category='" + category + '\'' +
               ", description='" + description + '\'' +
               ", id=" + id +
               ", image='" + image + '\'' +
               ", language='" + language + '\'' +
               ", published=" + published +
               ", title='" + title + '\'' +
               ", url='" + url + '\'' +
               '}';
    }
}
