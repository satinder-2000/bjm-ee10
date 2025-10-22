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
@Table(name = "ForumComment")
@NamedQueries({
    @NamedQuery(name = "ForumComment.findAll", query = "SELECT f FROM ForumComment f"),
    @NamedQuery(name = "ForumComment.findById", query = "SELECT f FROM ForumComment f WHERE f.id = :id"),
    @NamedQuery(name = "ForumComment.findByComment", query = "SELECT f FROM ForumComment f WHERE f.comment = :comment"),
    @NamedQuery(name = "ForumComment.findByTimestampd", query = "SELECT f FROM ForumComment f WHERE f.dated = :dated"),
    @NamedQuery(name = "ForumComment.findByForumCommenterAccessId", query = "SELECT f FROM ForumComment f WHERE f.forumCommenterAccessId = :forumCommenterAccessId"),
    @NamedQuery(name = "ForumComment.findByForumCommenterEmail", query = "SELECT f FROM ForumComment f WHERE f.forumCommenterEmail = :forumCommenterEmail"),
    @NamedQuery(name = "ForumComment.findByForumId", query = "SELECT f FROM ForumComment f WHERE f.forumId = :forumId")})
public class ForumComment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "comment")
    private String comment;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dated")
    private Timestamp dated;
    @Basic(optional = false)
    @NotNull
    @Column(name = "forumCommenterAccessId")
    private int forumCommenterAccessId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "forumCommenterEmail")
    private String forumCommenterEmail;
    @Basic(optional = false)
    @NotNull
    @Column(name = "forumId")
    private int forumId;

    public ForumComment() {
    }

    public ForumComment(int id) {
        this.id = id;
    }

    public ForumComment(int id, String comment, Timestamp dated, int forumCommenterAccessId, String forumCommenterEmail, int forumId) {
        this.id = id;
        this.comment = comment;
        this.dated = dated;
        this.forumCommenterAccessId = forumCommenterAccessId;
        this.forumCommenterEmail = forumCommenterEmail;
        this.forumId = forumId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Timestamp getDated() {
        return dated;
    }

    public void setDated(Timestamp dated) {
        this.dated = dated;
    }

    

    public int getForumCommenterAccessId() {
        return forumCommenterAccessId;
    }

    public void setForumCommenterAccessId(int forumCommenterAccessId) {
        this.forumCommenterAccessId = forumCommenterAccessId;
    }

    public String getForumCommenterEmail() {
        return forumCommenterEmail;
    }

    public void setForumCommenterEmail(String forumCommenterEmail) {
        this.forumCommenterEmail = forumCommenterEmail;
    }

    public int getForumId() {
        return forumId;
    }

    public void setForumId(int forumId) {
        this.forumId = forumId;
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
        return "org.bjm.entities.ForumComment[ id=" + id + " ]";
    }
    
}
