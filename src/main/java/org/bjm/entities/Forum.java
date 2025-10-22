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
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 *
 * @author singh
 */
@Entity
@Table(name = "Forum")
@NamedQueries({
    @NamedQuery(name = "Forum.findAll", query = "SELECT f FROM Forum f"),
    @NamedQuery(name = "Forum.findById", query = "SELECT f FROM Forum f WHERE f.id = :id"),
    @NamedQuery(name = "Forum.findByForumCreatorEmail", query = "SELECT f FROM Forum f WHERE f.forumCreatorEmail = :forumCreatorEmail"),
    @NamedQuery(name = "Forum.findByCategoryType", query = "SELECT f FROM Forum f WHERE f.categoryType = :categoryType"),
    @NamedQuery(name = "Forum.findByCategorySubType", query = "SELECT f FROM Forum f WHERE f.categorySubType = :categorySubType"),
    @NamedQuery(name = "Forum.findByTitle", query = "SELECT f FROM Forum f WHERE f.title = :title"),
    @NamedQuery(name = "Forum.findByDescription", query = "SELECT f FROM Forum f WHERE f.description = :description"),
    @NamedQuery(name = "Forum.findByCreatedOn", query = "SELECT f FROM Forum f WHERE f.createdOn = :createdOn"),
    @NamedQuery(name = "Forum.findByUpdatedOn", query = "SELECT f FROM Forum f WHERE f.updatedOn = :updatedOn")})
public class Forum implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "forumCreatorEmail")
    private String forumCreatorEmail;
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
    @Size(min = 1, max = 150)
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

    public Forum() {
    }

    public Forum(int id) {
        this.id = id;
    }

    public Forum(int id, String forumCreatorEmail, String categoryType, String categorySubType, String title, String description, Timestamp createdOn, Timestamp updatedOn) {
        this.id = id;
        this.forumCreatorEmail = forumCreatorEmail;
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

    public String getForumCreatorEmail() {
        return forumCreatorEmail;
    }

    public void setForumCreatorEmail(String forumCreatorEmail) {
        this.forumCreatorEmail = forumCreatorEmail;
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
    public boolean equals(Object obj) {
        return super.equals(obj); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public int hashCode() {
        return super.hashCode(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    

    @Override
    public String toString() {
        return "org.bjm.entities.Forum[ id=" + id + " ]";
    }
    
}
