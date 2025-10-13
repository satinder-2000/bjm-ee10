/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.bjm.entities;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author singh
 */
@Entity
@Table(name = "Survey")
@NamedQueries({
    @NamedQuery(name = "Survey.findAll", query = "SELECT s FROM Survey s"),
    @NamedQuery(name = "Survey.findById", query = "SELECT s FROM Survey s WHERE s.id = :id"),
    @NamedQuery(name = "Survey.findBySurveyCreatorEmail", query = "SELECT s FROM Survey s WHERE s.surveyCreatorEmail = :surveyCreatorEmail"),
    @NamedQuery(name = "Survey.findByCategoryType", query = "SELECT s FROM Survey s WHERE s.categoryType = :categoryType"),
    @NamedQuery(name = "Survey.findByCategorySubType", query = "SELECT s FROM Survey s WHERE s.categorySubType = :categorySubType"),
    @NamedQuery(name = "Survey.findByTitle", query = "SELECT s FROM Survey s WHERE s.title = :title"),
    @NamedQuery(name = "Survey.findByDescription", query = "SELECT s FROM Survey s WHERE s.description = :description"),
    @NamedQuery(name = "Survey.findByCreatedOn", query = "SELECT s FROM Survey s WHERE s.createdOn = :createdOn"),
    @NamedQuery(name = "Survey.findByUpdatedOn", query = "SELECT s FROM Survey s WHERE s.updatedOn = :updatedOn")})
public class Survey implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "surveyCreatorEmail")
    private String surveyCreatorEmail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "categoryType")
    private String categoryType;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "categorySubType")
    private String categorySubType;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 125)
    @Column(name = "title")
    private String title;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5000)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "createdOn")
    private Timestamp createdOn;
    @Basic(optional = false)
    @NotNull
    @Column(name = "updatedOn")
    private Timestamp updatedOn;

    public Survey() {
    }

    public Survey(Integer id) {
        this.id = id;
    }

    public Survey(Integer id, String surveyCreatorEmail, String categoryType, String categorySubType, String title, String description, Timestamp createdOn, Timestamp updatedOn) {
        this.id = id;
        this.surveyCreatorEmail = surveyCreatorEmail;
        this.categoryType = categoryType;
        this.categorySubType = categorySubType;
        this.title = title;
        this.description = description;
        this.createdOn = createdOn;
        this.updatedOn = updatedOn;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSurveyCreatorEmail() {
        return surveyCreatorEmail;
    }

    public void setSurveyCreatorEmail(String surveyCreatorEmail) {
        this.surveyCreatorEmail = surveyCreatorEmail;
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

    public Timestamp getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Timestamp createdOn) {
        this.createdOn = createdOn;
    }

    public Timestamp getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Timestamp updatedOn) {
        this.updatedOn = updatedOn;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Survey)) {
            return false;
        }
        Survey other = (Survey) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.bjm.entities.Survey[ id=" + id + " ]";
    }
    
}
