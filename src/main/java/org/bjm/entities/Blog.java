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
@Table(name = "Blog")
@NamedQueries({
    @NamedQuery(name = "Blog.findAll", query = "SELECT b FROM Blog b"),
    @NamedQuery(name = "Blog.findById", query = "SELECT b FROM Blog b WHERE b.id = :id"),
    @NamedQuery(name = "Blog.findByPublishedOn", query = "SELECT b FROM Blog b WHERE b.publishedOn = :publishedOn"),
    @NamedQuery(name = "Blog.findByTitle", query = "SELECT b FROM Blog b WHERE b.title = :title"),
    @NamedQuery(name = "Blog.findBySummary", query = "SELECT b FROM Blog b WHERE b.summary = :summary"),
    @NamedQuery(name = "Blog.findByText", query = "SELECT b FROM Blog b WHERE b.text = :text"),
    @NamedQuery(name = "Blog.findByPublishedByAccessId", query = "SELECT b FROM Blog b WHERE b.publishedByAccessId = :publishedByAccessId"),
    @NamedQuery(name = "Blog.findByPublishedByEmail", query = "SELECT b FROM Blog b WHERE b.publishedByEmail = :publishedByEmail"),
    @NamedQuery(name = "Blog.findNBlogs", query = "SELECT b FROM Blog b ORDER BY b.id")

})
public class Blog implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "publishedOn")
    private Timestamp publishedOn;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "title")
    private String title;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "summary")
    private String summary;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10000)
    @Column(name = "text")
    private String text;
    @Basic(optional = false)
    @NotNull
    @Column(name = "publishedByAccessId")
    private int publishedByAccessId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "publishedByEmail")
    private String publishedByEmail;

    public Blog() {
    }

    public Blog(Integer id) {
        this.id = id;
    }

    public Blog(Integer id, Timestamp publishedOn, String title, String summary, String text, int publishedByAccessId, String publishedByEmail) {
        this.id = id;
        this.publishedOn = publishedOn;
        this.title = title;
        this.summary = summary;
        this.text = text;
        this.publishedByAccessId = publishedByAccessId;
        this.publishedByEmail = publishedByEmail;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getPublishedOn() {
        return publishedOn;
    }

    public void setPublishedOn(Timestamp publishedOn) {
        this.publishedOn = publishedOn;
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

    public int getPublishedByAccessId() {
        return publishedByAccessId;
    }

    public void setPublishedByAccessId(int publishedByAccessId) {
        this.publishedByAccessId = publishedByAccessId;
    }

    public String getPublishedByEmail() {
        return publishedByEmail;
    }

    public void setPublishedByEmail(String publishedByEmail) {
        this.publishedByEmail = publishedByEmail;
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
        if (!(object instanceof Blog)) {
            return false;
        }
        Blog other = (Blog) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.bjm.entities.Blog[ id=" + id + " ]";
    }
    
}
