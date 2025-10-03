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
@Table(name = "LokSabhaNominate")
@NamedQueries({
    @NamedQuery(name = "LokSabhaNominate.findAll", query = "SELECT l FROM LokSabhaNominate l"),
    @NamedQuery(name = "LokSabhaNominate.findById", query = "SELECT l FROM LokSabhaNominate l WHERE l.id = :id"),
    @NamedQuery(name = "LokSabhaNominate.findByCandidateName", query = "SELECT l FROM LokSabhaNominate l WHERE l.candidateName = :candidateName"),
    @NamedQuery(name = "LokSabhaNominate.findByNominatedByAccessId", query = "SELECT l FROM LokSabhaNominate l WHERE l.nominatedByAccessId = :nominatedByAccessId"),
    @NamedQuery(name = "LokSabhaNominate.findByNominatedByEmail", query = "SELECT l FROM LokSabhaNominate l WHERE l.nominatedByEmail = :nominatedByEmail"),
    @NamedQuery(name = "LokSabhaNominate.findByNominatedOn", query = "SELECT l FROM LokSabhaNominate l WHERE l.nominatedOn = :nominatedOn"),
    @NamedQuery(name = "LokSabhaNominate.findByNominationCount", query = "SELECT l FROM LokSabhaNominate l WHERE l.nominationCount = :nominationCount"),
    @NamedQuery(name = "LokSabhaNominate.findByStateCode", query = "SELECT l FROM LokSabhaNominate l WHERE l.stateCode = :stateCode")})
public class LokSabhaNominate implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "constituency")
    private String constituency;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "candidateName")
    private String candidateName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nominatedByAccessId")
    private int nominatedByAccessId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nominatedByEmail")
    private String nominatedByEmail;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nominatedOn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date nominatedOn;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nominationCount")
    private int nominationCount;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "stateCode")
    private String stateCode;

    public LokSabhaNominate() {
    }

    public LokSabhaNominate(Integer id) {
        this.id = id;
    }

    public LokSabhaNominate(Integer id, String candidateName, int nominatedByAccessId, String nominatedByEmail, Date nominatedOn, int nominationCount, String stateCode, String constituency) {
        this.id = id;
        this.candidateName = candidateName;
        this.nominatedByAccessId = nominatedByAccessId;
        this.nominatedByEmail = nominatedByEmail;
        this.nominatedOn = nominatedOn;
        this.nominationCount = nominationCount;
        this.stateCode = stateCode;
        this.constituency=constituency;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getConstituency() {
        return constituency;
    }

    public void setConstituency(String constituency) {
        this.constituency = constituency;
    }
    
    

    public String getCandidateName() {
        return candidateName;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }

    public int getNominatedByAccessId() {
        return nominatedByAccessId;
    }

    public void setNominatedByAccessId(int nominatedByAccessId) {
        this.nominatedByAccessId = nominatedByAccessId;
    }

    public String getNominatedByEmail() {
        return nominatedByEmail;
    }

    public void setNominatedByEmail(String nominatedByEmail) {
        this.nominatedByEmail = nominatedByEmail;
    }

    public Date getNominatedOn() {
        return nominatedOn;
    }

    public void setNominatedOn(Date nominatedOn) {
        this.nominatedOn = nominatedOn;
    }

    public int getNominationCount() {
        return nominationCount;
    }

    public void setNominationCount(int nominationCount) {
        this.nominationCount = nominationCount;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
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
        if (!(object instanceof LokSabhaNominate)) {
            return false;
        }
        LokSabhaNominate other = (LokSabhaNominate) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.bjm.entities.LokSabhaNominate[ id=" + id + " ]";
    }
    
}
