/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upb.parcialdos.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Carlos
 */
@Entity
@Table(name = "USERS")
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u"),
    @NamedQuery(name = "Users.findByUsername", query = "SELECT u FROM Users u WHERE u.username = :username"),
    @NamedQuery(name = "Users.findByUserpassword", query = "SELECT u FROM Users u WHERE u.userpassword = :userpassword"),
    @NamedQuery(name = "Users.findByUserstatus", query = "SELECT u FROM Users u WHERE u.userstatus = :userstatus"),
    @NamedQuery(name = "Users.findByUsercreated", query = "SELECT u FROM Users u WHERE u.usercreated = :usercreated"),
    @NamedQuery(name = "Users.findByUserupdated", query = "SELECT u FROM Users u WHERE u.userupdated = :userupdated")})
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "USERNAME")
    private String username;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "USERPASSWORD")
    private String userpassword;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "USERSTATUS")
    private Character userstatus;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "USERCREATED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usercreated;
    
    @Column(name = "USERUPDATED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date userupdated;

    public Users() {
    }

    public Users(String username) {
        this.username = username;
    }

    public Users(String username, String userpassword, Character userstatus, Date usercreated) {
        this.username = username;
        this.userpassword = userpassword;
        this.userstatus = userstatus;
        this.usercreated = usercreated;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public Character getUserstatus() {
        return userstatus;
    }

    public void setUserstatus(Character userstatus) {
        this.userstatus = userstatus;
    }

    public Date getUsercreated() {
        return usercreated;
    }

    public void setUsercreated(Date usercreated) {
        this.usercreated = usercreated;
    }

    public Date getUserupdated() {
        return userupdated;
    }

    public void setUserupdated(Date userupdated) {
        this.userupdated = userupdated;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (username != null ? username.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.upb.parcialdos.model.Users[ username=" + username + " ]";
    }
    
}
