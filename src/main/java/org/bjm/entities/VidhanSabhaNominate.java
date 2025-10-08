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
@Table(name = "VidhanSabhaNominate")
@NamedQueries({
    @NamedQuery(name = "VidhanSabhaNominate.findAll", query = "SELECT v FROM VidhanSabhaNominate v"),
    @NamedQuery(name = "VidhanSabhaNominate.findById", query = "SELECT v FROM VidhanSabhaNominate v WHERE v.id = :id"),
    @NamedQuery(name = "VidhanSabhaNominate.findByCandidateName", query = "SELECT v FROM VidhanSabhaNominate v WHERE v.stateCode=:stateCode AND v.candidateName = :candidateName"),
    @NamedQuery(name = "VidhanSabhaNominate.findByConstituency", query = "SELECT v FROM VidhanSabhaNominate v WHERE v.constituency = :constituency"),
    @NamedQuery(name = "VidhanSabhaNominate.findByNominatedByAccessId", query = "SELECT v FROM VidhanSabhaNominate v WHERE v.nominatedByAccessId = :nominatedByAccessId"),
    @NamedQuery(name = "VidhanSabhaNominate.findByNominatedByEmail", query = "SELECT v FROM VidhanSabhaNominate v WHERE v.nominatedByEmail = :nominatedByEmail"),
    @NamedQuery(name = "VidhanSabhaNominate.findByNominatedOn", query = "SELECT v FROM VidhanSabhaNominate v WHERE v.nominatedOn = :nominatedOn"),
    @NamedQuery(name = "VidhanSabhaNominate.findByNominationCount", query = "SELECT v FROM VidhanSabhaNominate v WHERE v.nominationCount = :nominationCount"),
    @NamedQuery(name = "VidhanSabhaNominate.findByStateCode", query = "SELECT v FROM VidhanSabhaNominate v WHERE v.stateCode = :stateCode"),
    @NamedQuery(name = "VidhanSabhaNominate.findForStateCodeAndConstituency", query = "SELECT v FROM VidhanSabhaNominate v WHERE v.stateCode = :stateCode and v.constituency=:constituency")
})
public class VidhanSabhaNominate implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "candidateName")
    private String candidateName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "constituency")
    private String constituency;
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

    public VidhanSabhaNominate() {
    }

    public VidhanSabhaNominate(Integer id) {
        this.id = id;
    }

    public VidhanSabhaNominate(Integer id, String candidateName, String constituency, int nominatedByAccessId, String nominatedByEmail, Date nominatedOn, int nominationCount, String stateCode) {
        this.id = id;
        this.candidateName = candidateName;
        this.constituency = constituency;
        this.nominatedByAccessId = nominatedByAccessId;
        this.nominatedByEmail = nominatedByEmail;
        this.nominatedOn = nominatedOn;
        this.nominationCount = nominationCount;
        this.stateCode = stateCode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }

    public String getConstituency() {
        return constituency;
    }

    public void setConstituency(String constituency) {
        this.constituency = constituency;
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
        if (!(object instanceof VidhanSabhaNominate)) {
            return false;
        }
        VidhanSabhaNominate other = (VidhanSabhaNominate) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.bjm.entities.VidhanSabhaNominate[ id=" + id + " ]";
    }
    
}
