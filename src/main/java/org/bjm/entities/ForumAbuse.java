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
@Table(name = "ForumAbuse")
@NamedQueries({
    @NamedQuery(name = "ForumAbuse.findAll", query = "SELECT f FROM ForumAbuse f"),
    @NamedQuery(name = "ForumAbuse.findById", query = "SELECT f FROM ForumAbuse f WHERE f.id = :id"),
    @NamedQuery(name = "ForumAbuse.findByForumCommentId", query = "SELECT f FROM ForumAbuse f WHERE f.forumCommentId = :forumCommentId"),
    @NamedQuery(name = "ForumAbuse.findByReportedByAccessId", query = "SELECT f FROM ForumAbuse f WHERE f.reportedByAccessId = :reportedByAccessId"),
    @NamedQuery(name = "ForumAbuse.findByReportedByEmail", query = "SELECT f FROM ForumAbuse f WHERE f.reportedByEmail = :reportedByEmail"),
    @NamedQuery(name = "ForumAbuse.findByReportText", query = "SELECT f FROM ForumAbuse f WHERE f.reportText = :reportText"),
    @NamedQuery(name = "ForumAbuse.findByReportedOn", query = "SELECT f FROM ForumAbuse f WHERE f.reportedOn = :reportedOn")})
public class ForumAbuse implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "forumCommentId")
    private int forumCommentId;
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
    @Size(min = 1, max = 1000)
    @Column(name = "reportText")
    private String reportText;
    @Basic(optional = false)
    @NotNull
    @Column(name = "reportedOn")
    private Timestamp reportedOn;

    public ForumAbuse() {
    }

    public ForumAbuse(Integer id) {
        this.id = id;
    }

    public ForumAbuse(Integer id, int forumCommentId, int reportedByAccessId, String reportedByEmail, String reportText, Timestamp reportedOn) {
        this.id = id;
        this.forumCommentId = forumCommentId;
        this.reportedByAccessId = reportedByAccessId;
        this.reportedByEmail = reportedByEmail;
        this.reportText = reportText;
        this.reportedOn = reportedOn;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getForumCommentId() {
        return forumCommentId;
    }

    public void setForumCommentId(int forumCommentId) {
        this.forumCommentId = forumCommentId;
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
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ForumAbuse)) {
            return false;
        }
        ForumAbuse other = (ForumAbuse) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.bjm.entities.ForumAbuse[ id=" + id + " ]";
    }
    
}
