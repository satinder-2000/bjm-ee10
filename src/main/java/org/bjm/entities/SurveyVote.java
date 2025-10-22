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
import java.util.Date;

/**
 *
 * @author singh
 */
@Entity
@Table(name = "SurveyVote")
@NamedQueries({
    @NamedQuery(name = "SurveyVote.findAll", query = "SELECT s FROM SurveyVote s"),
    @NamedQuery(name = "SurveyVote.findById", query = "SELECT s FROM SurveyVote s WHERE s.id = :id"),
    @NamedQuery(name = "SurveyVote.findByComment", query = "SELECT s FROM SurveyVote s WHERE s.comment = :comment"),
    @NamedQuery(name = "SurveyVote.findByDated", query = "SELECT s FROM SurveyVote s WHERE s.dated = :dated"),
    @NamedQuery(name = "SurveyVote.findByVoteType", query = "SELECT s FROM SurveyVote s WHERE s.voteType = :voteType"),
    @NamedQuery(name = "SurveyVote.findBySurveyId", query = "SELECT s FROM SurveyVote s WHERE s.surveyId = :surveyId"),
    @NamedQuery(name = "SurveyVote.findByVoterAccessId", query = "SELECT s FROM SurveyVote s WHERE s.voterAccessId = :voterAccessId"),
    @NamedQuery(name = "SurveyVote.findByVoterEmail", query = "SELECT s FROM SurveyVote s WHERE s.voterEmail = :voterEmail")})
public class SurveyVote implements Serializable {

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
    @Temporal(TemporalType.TIMESTAMP)
    private Date dated;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "voteType")
    private String voteType;
    @Basic(optional = false)
    @NotNull
    @Column(name = "surveyId")
    private int surveyId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "voterAccessId")
    private int voterAccessId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "voterEmail")
    private String voterEmail;

    public SurveyVote() {
    }

    public SurveyVote(int id) {
        this.id = id;
    }

    public SurveyVote(int id, String comment, Date dated, String voteType, int surveyId, int voterAccessId, String voterEmail) {
        this.id = id;
        this.comment = comment;
        this.dated = dated;
        this.voteType = voteType;
        this.surveyId = surveyId;
        this.voterAccessId = voterAccessId;
        this.voterEmail = voterEmail;
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

    public Date getDated() {
        return dated;
    }

    public void setDated(Date dated) {
        this.dated = dated;
    }

    public String getVoteType() {
        return voteType;
    }

    public void setVoteType(String voteType) {
        this.voteType = voteType;
    }

    public int getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(int surveyId) {
        this.surveyId = surveyId;
    }

    public int getVoterAccessId() {
        return voterAccessId;
    }

    public void setVoterAccessId(int voterAccessId) {
        this.voterAccessId = voterAccessId;
    }

    public String getVoterEmail() {
        return voterEmail;
    }

    public void setVoterEmail(String voterEmail) {
        this.voterEmail = voterEmail;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.id;
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
        final SurveyVote other = (SurveyVote) obj;
        return this.id == other.id;
    }

    

    @Override
    public String toString() {
        return "org.bjm.entities.SurveyVote[ id=" + id + " ]";
    }
    
}
