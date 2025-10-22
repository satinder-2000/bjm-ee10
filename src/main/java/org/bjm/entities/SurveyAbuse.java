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
@Table(name = "SurveyAbuse")
@NamedQueries({
    @NamedQuery(name = "SurveyAbuse.findAll", query = "SELECT s FROM SurveyAbuse s"),
    @NamedQuery(name = "SurveyAbuse.findById", query = "SELECT s FROM SurveyAbuse s WHERE s.id = :id"),
    @NamedQuery(name = "SurveyAbuse.findByReportText", query = "SELECT s FROM SurveyAbuse s WHERE s.reportText = :reportText"),
    @NamedQuery(name = "SurveyAbuse.findByReportedByAccessId", query = "SELECT s FROM SurveyAbuse s WHERE s.reportedByAccessId = :reportedByAccessId"),
    @NamedQuery(name = "SurveyAbuse.findByReportedByEmail", query = "SELECT s FROM SurveyAbuse s WHERE s.reportedByEmail = :reportedByEmail"),
    @NamedQuery(name = "SurveyAbuse.findByReportedOn", query = "SELECT s FROM SurveyAbuse s WHERE s.reportedOn = :reportedOn"),
    @NamedQuery(name = "SurveyAbuse.findBySurveyVoteId", query = "SELECT s FROM SurveyAbuse s WHERE s.surveyVoteId = :surveyVoteId")})
public class SurveyAbuse implements Serializable {

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
    @Column(name = "reportedByAccessId")
    private int reportedByAccessId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "reportedByEmail")
    private String reportedByEmail;
    @Basic(optional = false)
    @NotNull
    @Column(name = "reportedOn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date reportedOn;
    @Basic(optional = false)
    @NotNull
    @Column(name = "surveyVoteId")
    private int surveyVoteId;

    public SurveyAbuse() {
    }

    public SurveyAbuse(int id) {
        this.id = id;
    }

    public SurveyAbuse(int id, String reportText, int reportedByAccessId, String reportedByEmail, Date reportedOn, int surveyVoteId) {
        this.id = id;
        this.reportText = reportText;
        this.reportedByAccessId = reportedByAccessId;
        this.reportedByEmail = reportedByEmail;
        this.reportedOn = reportedOn;
        this.surveyVoteId = surveyVoteId;
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

    public Date getReportedOn() {
        return reportedOn;
    }

    public void setReportedOn(Date reportedOn) {
        this.reportedOn = reportedOn;
    }

    public int getSurveyVoteId() {
        return surveyVoteId;
    }

    public void setSurveyVoteId(int surveyVoteId) {
        this.surveyVoteId = surveyVoteId;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + this.id;
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
        final SurveyAbuse other = (SurveyAbuse) obj;
        return this.id == other.id;
    }

    

    @Override
    public String toString() {
        return "org.bjm.entities.SurveyAbuse[ id=" + id + " ]";
    }
    
}
