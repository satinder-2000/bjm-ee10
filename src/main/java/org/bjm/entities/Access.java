package org.bjm.entities;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
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
@Table(name = "Access")
@NamedQueries({
    @NamedQuery(name = "Access.findAll", query = "SELECT a FROM Access a"),
    @NamedQuery(name = "Access.findById", query = "SELECT a FROM Access a WHERE a.id = :id"),
    @NamedQuery(name = "Access.findByEmail", query = "SELECT a FROM Access a WHERE a.email = :email"),
    @NamedQuery(name = "Access.findByPassword", query = "SELECT a FROM Access a WHERE a.password = :password"),
    @NamedQuery(name = "Access.findByProfileFile", query = "SELECT a FROM Access a WHERE a.profileFile = :profileFile"),
    @NamedQuery(name = "Access.findByFailedAttempts", query = "SELECT a FROM Access a WHERE a.failedAttempts = :failedAttempts"),
    @NamedQuery(name = "Access.findByCreatedOn", query = "SELECT a FROM Access a WHERE a.createdOn = :createdOn"),
    @NamedQuery(name = "Access.findByUpdatedOn", query = "SELECT a FROM Access a WHERE a.updatedOn = :updatedOn")})
public class Access implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "email")
    private String email;
    @Size(max = 100)
    @Column(name = "password")
    private String password;
    @Size(max = 100)
    @Column(name = "profileFile")
    private String profileFile;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "image")
    private byte[] image;
    @Basic(optional = false)
    @NotNull
    @Column(name = "failedAttempts")
    private short failedAttempts;
    @Basic(optional = false)
    @NotNull
    @Column(name = "createdOn")
    private Timestamp createdOn;
    @Basic(optional = false)
    @NotNull
    @Column(name = "updatedOn")
    private Timestamp updatedOn;

    public Access() {
    }

    public Access(Integer id) {
        this.id = id;
    }

    public Access(Integer id, String email, byte[] image, short failedAttempts, Timestamp createdOn, Timestamp updatedOn) {
        this.id = id;
        this.email = email;
        this.image = image;
        this.failedAttempts = failedAttempts;
        this.createdOn = createdOn;
        this.updatedOn = updatedOn;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfileFile() {
        return profileFile;
    }

    public void setProfileFile(String profileFile) {
        this.profileFile = profileFile;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public short getFailedAttempts() {
        return failedAttempts;
    }

    public void setFailedAttempts(short failedAttempts) {
        this.failedAttempts = failedAttempts;
    }

    public Timestamp getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Timestamp createdOn) {
        this.createdOn = createdOn;
    }

    public Timestamp getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Timestamp updatedOn) {
        this.updatedOn = updatedOn;
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
        return "org.bjm.entities.Access[ id=" + id + " ]";
    }
    
}
