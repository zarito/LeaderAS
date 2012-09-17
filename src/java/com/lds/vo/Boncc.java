/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.vo;

import java.util.Date;

/**
 *
 * @author zarito
 */
public class Boncc {

    private String numboncc;
    private Date dateboncc;
    private String idprojet;

    public Boncc() {
    }

    public Boncc(String numboncc, Date dateboncc,String idprojet) {
        this.numboncc = numboncc;
        this.dateboncc = dateboncc;
        this.idprojet = idprojet;
    }

    public Date getDateboncc() {
        return dateboncc;
    }

    public void setDateboncc(Date dateboncc) {
        this.dateboncc = dateboncc;
    }

    public String getNumboncc() {
        return numboncc;
    }

    public void setNumboncc(String numboncc) {
        this.numboncc = numboncc;
    }

    public String getIdprojet() {
        return idprojet;
    }

    public void setIdprojet(String idprojet) {
        this.idprojet = idprojet;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Boncc other = (Boncc) obj;
        if ((this.numboncc == null) ? (other.numboncc != null) : !this.numboncc.equals(other.numboncc)) {
            return false;
        }
        if ((this.dateboncc == null) ? (other.dateboncc != null) : !this.dateboncc.equals(other.dateboncc)) {
            return false;
        }
        if ((this.idprojet == null) ? (other.idprojet != null) : !this.idprojet.equals(other.idprojet)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + (this.numboncc != null ? this.numboncc.hashCode() : 0);
        hash = 59 * hash + (this.dateboncc != null ? this.dateboncc.hashCode() : 0);
        hash = 59 * hash + (this.idprojet != null ? this.idprojet.hashCode() : 0);
        return hash;
    }
    
    
    
      
      
}
