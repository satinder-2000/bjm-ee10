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
import java.util.Date;

/**
 *
 * @author singh
 */
@Entity
@Table(name = "SurveyFromForumAbuse")
@NamedQueries({
    @NamedQuery(name = "SurveyFromForumAbuse.findAll", query = "SELECT s FROM SurveyFromForumAbuse s"),
    @NamedQuery(name = "SurveyFromForumAbuse.findById", query = "SELECT s FROM SurveyFromForumAbuse s WHERE s.id = :id"),
    @NamedQuery(name = "SurveyFromForumAbuse.findByReportText", query = "SELECT s FROM SurveyFromForumAbuse s WHERE s.reportText = :reportText"),
    @NamedQuery(name = "SurveyFromForumAbuse.findByReportByAccessId", query = "SELECT s FROM SurveyFromForumAbuse s WHERE s.reportByAccessId = :reportByAccessId"),
    @NamedQuery(name = "SurveyFromForumAbuse.findByReportByEmail", query = "SELECT s FROM SurveyFromForumAbuse s WHERE s.reportByEmail = :reportByEmail"),
    @NamedQuery(name = "SurveyFromForumAbuse.findByReportedOn", query = "SELECT s FROM SurveyFromForumAbuse s WHERE s.reportedOn = :reportedOn"),
    @NamedQuery(name = "SurveyFromForumAbuse.findBySurveyFromForumVoteId", query = "SELECT s FROM SurveyFromForumAbuse s WHERE s.surveyFromForumVoteId = :surveyFromForumVoteId")})
public class SurveyFromForumAbuse implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "reportText")
    private String reportText;
    @Basic(optional = false)
    @NotNull
    @Column(name = "reportByAccessId")
    private int reportByAccessId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "reportByEmail")
    private String reportByEmail;
    @Basic(optional = false)
    @NotNull
    @Column(name = "reportedOn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date reportedOn;
    @Basic(optional = false)
    @NotNull
    @Column(name = "surveyFromForumVoteId")
    private int surveyFromForumVoteId;

    public SurveyFromForumAbuse() {
    }

    public SurveyFromForumAbuse(int id) {
        this.id = id;
    }

    public SurveyFromForumAbuse(int id, String reportText, int reportByAccessId, String reportByEmail, Date reportedOn, int surveyFromForumVoteId) {
        this.id = id;
        this.reportText = reportText;
        this.reportByAccessId = reportByAccessId;
        this.reportByEmail = reportByEmail;
        this.reportedOn = reportedOn;
        this.surveyFromForumVoteId = surveyFromForumVoteId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReportText() {
        return reportText;
    }

    public void setReportText(String reportText) {
        this.reportText = reportText;
    }

    public int getReportByAccessId() {
        return reportByAccessId;
    }

    public void setReportByAccessId(int reportByAccessId) {
        this.reportByAccessId = reportByAccessId;
    }

    public String getReportByEmail() {
        return reportByEmail;
    }

    public void setReportByEmail(String reportByEmail) {
        this.reportByEmail = reportByEmail;
    }

    public Date getReportedOn() {
        return reportedOn;
    }

    public void setReportedOn(Date reportedOn) {
        this.reportedOn = reportedOn;
    }

    public int getSurveyFromForumVoteId() {
        return surveyFromForumVoteId;
    }

    public void setSurveyFromForumVoteId(int surveyFromForumVoteId) {
        this.surveyFromForumVoteId = surveyFromForumVoteId;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SurveyFromForumAbuse other = (SurveyFromForumAbuse) obj;
        return this.id == other.id;
    }

    

    @Override
    public String toString() {
        return "org.bjm.entities.SurveyFromForumAbuse[ id=" + id + " ]";
    }
    
}
