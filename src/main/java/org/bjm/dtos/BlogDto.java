package org.bjm.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

/**
 *
 * @author singh
 */
public class BlogDto {
    
    private int id;
    
    @Size(min = 5, max=125)
    private String title;
    @Size(min = 5, max=250)
    private String summary;
    @NotEmpty
    private String text;
    private String publishedOn;
    private int publishedById;
    private String publishedByEmail;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
    
    

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPublishedOn() {
        return publishedOn;
    }

    public void setPublishedOn(String publishedOn) {
        this.publishedOn = publishedOn;
    }

    public int getPublishedById() {
        return publishedById;
    }

    public void setPublishedById(int publishedById) {
        this.publishedById = publishedById;
    }

    public String getPublishedByEmail() {
        return publishedByEmail;
    }

    public void setPublishedByEmail(String publishedByEmail) {
        this.publishedByEmail = publishedByEmail;
    }
    
    
    
    
}
