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
import jakarta.validation.constraints.Size;
import java.io.Serializable;

/**
 *
 * @author singh
 */
@Entity
@Table(name = "State")
@NamedQueries({
    @NamedQuery(name = "State.findAll", query = "SELECT s FROM State s"),
    @NamedQuery(name = "State.findByPostCodePrefix", query = "SELECT s FROM State s WHERE s.postCodePrefix = :postCodePrefix"),
    @NamedQuery(name = "State.findByName", query = "SELECT s FROM State s WHERE s.name = :name"),
    @NamedQuery(name = "State.findByCode", query = "SELECT s FROM State s WHERE s.code = :code"),
    @NamedQuery(name = "State.findById", query = "SELECT s FROM State s WHERE s.id = :id")})
public class State implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 8)
    @Column(name = "postCodePrefix")
    private String postCodePrefix;
    @Size(max = 100)
    @Column(name = "name")
    private String name;
    @Size(max = 2)
    @Column(name = "code")
    private String code;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private int id;

    public State() {
    }

    public State(int id) {
        this.id = id;
    }

    public String getPostCodePrefix() {
        return postCodePrefix;
    }

    public void setPostCodePrefix(String postCodePrefix) {
        this.postCodePrefix = postCodePrefix;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + this.id;
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
        final State other = (State) obj;
        return this.id == other.id;
    }

    

    

    @Override
    public String toString() {
        return "org.bjm.entities.State[ id=" + id + " ]";
    }
    
}
