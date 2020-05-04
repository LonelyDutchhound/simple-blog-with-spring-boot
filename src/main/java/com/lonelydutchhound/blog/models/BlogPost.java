package com.lonelydutchhound.blog.models;

import javax.persistence.*;
import java.util.Date;

@Entity
public class BlogPost {

    @Id
    @GeneratedValue
    private long id;
    @Column
    private String title;
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(length = 50)
    private String shortcut;
    @Column(name = "full_text", length = 5000)
    private String fullText;
    @Column(name = "views_count")
    private int viewsCount;

    public BlogPost() {
    }

    public BlogPost(String title, String shortcut, String text) {
        this.title = title;
        this.date = new Date();
        this.shortcut = shortcut;
        this.fullText = text;
        this.viewsCount = 0;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortcut() {
        return shortcut;
    }

    public void setShortcut(String shortcut) {
        this.shortcut = shortcut;
    }

    public String getFullText() {
        return fullText;
    }

    public void setFullText(String fullText) {
        this.fullText = fullText;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(int viewsCount) {
        this.date = new Date();
    }

    public int getViewsCount() {
        return viewsCount;
    }

    public void setViewsCount(int viewsCount) {
        this.viewsCount = viewsCount;
    }
}
