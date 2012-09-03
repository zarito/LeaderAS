package com.lds.vo;
// Generated 28 aout 2012 18:10:32 by Hibernate Tools 3.2.1.GA


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Bonreception generated by hbm2java
 */
public class Bonreception  implements java.io.Serializable {


     private String numreception;
     private Boncommande boncommande;
     private Date datereception;
     private Set detailsbrarticles = new HashSet(0);

    public Bonreception() {
    }

	
    public Bonreception(String numreception, Boncommande boncommande) {
        this.numreception = numreception;
        this.boncommande = boncommande;
    }
    public Bonreception(String numreception, Boncommande boncommande, Date datereception, Set detailsbrarticles) {
       this.numreception = numreception;
       this.boncommande = boncommande;
       this.datereception = datereception;
       this.detailsbrarticles = detailsbrarticles;
    }
   
    public String getNumreception() {
        return this.numreception;
    }
    
    public void setNumreception(String numreception) {
        this.numreception = numreception;
    }
    public Boncommande getBoncommande() {
        return this.boncommande;
    }
    
    public void setBoncommande(Boncommande boncommande) {
        this.boncommande = boncommande;
    }
    public Date getDatereception() {
        return this.datereception;
    }
    
    public void setDatereception(Date datereception) {
        this.datereception = datereception;
    }
    public Set getDetailsbrarticles() {
        return this.detailsbrarticles;
    }
    
    public void setDetailsbrarticles(Set detailsbrarticles) {
        this.detailsbrarticles = detailsbrarticles;
    }




}

