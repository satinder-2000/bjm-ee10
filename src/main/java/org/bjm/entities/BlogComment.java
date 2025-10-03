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
@Table(name = "BlogComment")
@NamedQueries({
    @NamedQuery(name = "BlogComment.findAll", query = "SELECT b FROM BlogComment b"),
    @NamedQuery(name = "BlogComment.findById", query = "SELECT b FROM BlogComment b WHERE b.id = :id"),
    @NamedQuery(name = "BlogComment.findByComment", query = "SELECT b FROM BlogComment b WHERE b.comment = :comment"),
    @NamedQuery(name = "BlogComment.findByTimestampd", query = "SELECT b FROM BlogComment b WHERE b.dated = :dated"),
    @NamedQuery(name = "BlogComment.findByBlogId", query = "SELECT b FROM BlogComment b WHERE b.blogId = :blogId"),
    @NamedQuery(name = "BlogComment.findByBlogCommenterEmail", query = "SELECT b FROM BlogComment b WHERE b.blogCommenterEmail = :blogCommenterEmail"),
    @NamedQuery(name = "BlogComment.findByBlogCommenterAccessId", query = "SELECT b FROM BlogComment b WHERE b.blogCommenterAccessId = :blogCommenterAccessId")})
public class BlogComment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 750)
    @Column(name = "comment")
    private String comment;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dated")
    private Timestamp dated;
    @Basic(optional = false)
    @NotNull
    @Column(name = "blogId")
    private int blogId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "blogCommenterEmail")
    private String blogCommenterEmail;
    @Basic(optional = false)
    @NotNull
    @Column(name = "blogCommenterAccessId")
    private int blogCommenterAccessId;

    public BlogComment() {
    }

    public BlogComment(Integer id) {
        this.id = id;
    }

    public BlogComment(Integer id, String comment, Timestamp dated, int blogId, String blogCommenterEmail, int blogCommenterAccessId) {
        this.id = id;
        this.comment = comment;
        this.dated = dated;
        this.blogId = blogId;
        this.blogCommenterEmail = blogCommenterEmail;
        this.blogCommenterAccessId = blogCommenterAccessId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    

    public int getBlogId() {
        return blogId;
    }

    public void setBlogId(int blogId) {
        this.blogId = blogId;
    }

    public String getBlogCommenterEmail() {
        return blogCommenterEmail;
    }

    public void setBlogCommenterEmail(String blogCommenterEmail) {
        this.blogCommenterEmail = blogCommenterEmail;
    }

    public int getBlogCommenterAccessId() {
        return blogCommenterAccessId;
    }

    public void setBlogCommenterAccessId(int blogCommenterAccessId) {
        this.blogCommenterAccessId = blogCommenterAccessId;
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
        if (!(object instanceof BlogComment)) {
            return false;
        }
        BlogComment other = (BlogComment) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.bjm.entities.BlogComment[ id=" + id + " ]";
    }
    
}
