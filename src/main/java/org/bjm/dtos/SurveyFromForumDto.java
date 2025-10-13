package org.bjm.dtos;

import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author singh
 */
public class SurveyFromForumDto implements Serializable {
    
    private int id;
    private String categoryType;
    private String categorySubType;
    @Size(min = 5, max=125)
    private String title;
    private String description;
    private Map<String, Set<String>> forumCategoryMap;
    private Set<String> categoryTypes;
    private Set<String> categorySubTypes;
    private String createdOn;
    private String updatedOn;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(String categoryType) {
        this.categoryType = categoryType;
    }

    public String getCategorySubType() {
        return categorySubType;
    }

    public void setCategorySubType(String categorySubType) {
        this.categorySubType = categorySubType;
    }

    public Map<String, Set<String>> getForumCategoryMap() {
        return forumCategoryMap;
    }

    public void setForumCategoryMap(Map<String, Set<String>> forumCategoryMap) {
        this.forumCategoryMap = forumCategoryMap;
    }

    public Set<String> getCategoryTypes() {
        return categoryTypes;
    }

    public void setCategoryTypes(Set<String> categoryTypes) {
        this.categoryTypes = categoryTypes;
    }

    public Set<String> getCategorySubTypes() {
        return categorySubTypes;
    }

    public void setCategorySubTypes(Set<String> categorySubTypes) {
        this.categorySubTypes = categorySubTypes;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public String getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(String updatedOn) {
        this.updatedOn = updatedOn;
    }
    
    
    
}
