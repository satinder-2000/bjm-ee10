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
@Table(name = "BlogAbuse")
@NamedQueries({
    @NamedQuery(name = "BlogAbuse.findAll", query = "SELECT b FROM BlogAbuse b"),
    @NamedQuery(name = "BlogAbuse.findById", query = "SELECT b FROM BlogAbuse b WHERE b.id = :id"),
    @NamedQuery(name = "BlogAbuse.findByBlogCommentId", query = "SELECT b FROM BlogAbuse b WHERE b.blogCommentId = :blogCommentId"),
    @NamedQuery(name = "BlogAbuse.findByReportedByAccessId", query = "SELECT b FROM BlogAbuse b WHERE b.reportedByAccessId = :reportedByAccessId"),
    @NamedQuery(name = "BlogAbuse.findByReportedByEmail", query = "SELECT b FROM BlogAbuse b WHERE b.reportedByEmail = :reportedByEmail"),
    @NamedQuery(name = "BlogAbuse.findByReportText", query = "SELECT b FROM BlogAbuse b WHERE b.reportText = :reportText"),
    @NamedQuery(name = "BlogAbuse.findByReportedOn", query = "SELECT b FROM BlogAbuse b WHERE b.reportedOn = :reportedOn")})
public class BlogAbuse implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "blogCommentId")
    private int blogCommentId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "reportedByAccessId")
    private int reportedByAccessId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "reportedByEmail")
    private String reportedByEmail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "reportText")
    private String reportText;
    @Basic(optional = false)
    @NotNull
    @Column(name = "reportedOn")
    private Timestamp reportedOn;

    public BlogAbuse() {
    }

    public BlogAbuse(Integer id) {
        this.id = id;
    }

    public BlogAbuse(Integer id, int blogCommentId, int reportedByAccessId, String reportedByEmail, String reportText, Timestamp reportedOn) {
        this.id = id;
        this.blogCommentId = blogCommentId;
        this.reportedByAccessId = reportedByAccessId;
        this.reportedByEmail = reportedByEmail;
        this.reportText = reportText;
        this.reportedOn = reportedOn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBlogCommentId() {
        return blogCommentId;
    }

    public void setBlogCommentId(int blogCommentId) {
        this.blogCommentId = blogCommentId;
    }

    public int getReportedByAccessId() {
        return reportedByAccessId;
    }

    public void setReportedByAccessId(int reportedByAccessId) {
        this.reportedByAccessId = reportedByAccessId;
    }

    public String getReportedByEmail() {
        return reportedByEmail;
    }

    public void setReportedByEmail(String reportedByEmail) {
        this.reportedByEmail = reportedByEmail;
    }

    public String getReportText() {
        return reportText;
    }

    public void setReportText(String reportText) {
        this.reportText = reportText;
    }

    public Timestamp getReportedOn() {
        return reportedOn;
    }

    public void setReportedOn(Timestamp reportedOn) {
        this.reportedOn = reportedOn;
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
        return "org.bjm.entities.BlogAbuse[ id=" + id + " ]";
    }
    
}
