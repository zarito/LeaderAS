package com.lds.vo;
// Generated 28 aout 2012 18:10:32 by Hibernate Tools 3.2.1.GA


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Demandeprix generated by hbm2java
 */
public class Demandeprix  implements java.io.Serializable {


     private String numdemandeprix;
     private Fournisseur fournisseur;
     private String referencedemandeprix;
     private Date datedemandeprix;
     private Set detailsdemandearticles = new HashSet(0);

    public Demandeprix() {
    }

	
    public Demandeprix(String numdemandeprix, Fournisseur fournisseur) {
        this.numdemandeprix = numdemandeprix;
        this.fournisseur = fournisseur;
    }
    public Demandeprix(String numdemandeprix, Fournisseur fournisseur, String referencedemandeprix, Date datedemandeprix, Set detailsdemandearticles) {
       this.numdemandeprix = numdemandeprix;
       this.fournisseur = fournisseur;
       this.referencedemandeprix = referencedemandeprix;
       this.datedemandeprix = datedemandeprix;
       this.detailsdemandearticles = detailsdemandearticles;
    }
   
    public String getNumdemandeprix() {
        return this.numdemandeprix;
    }
    
    public void setNumdemandeprix(String numdemandeprix) {
        this.numdemandeprix = numdemandeprix;
    }
    public Fournisseur getFournisseur() {
        return this.fournisseur;
    }
    
    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }
    public String getReferencedemandeprix() {
        return this.referencedemandeprix;
    }
    
    public void setReferencedemandeprix(String referencedemandeprix) {
        this.referencedemandeprix = referencedemandeprix;
    }
    public Date getDatedemandeprix() {
        return this.datedemandeprix;
    }
    
    public void setDatedemandeprix(Date datedemandeprix) {
        this.datedemandeprix = datedemandeprix;
    }
    public Set getDetailsdemandearticles() {
        return this.detailsdemandearticles;
    }
    
    public void setDetailsdemandearticles(Set detailsdemandearticles) {
        this.detailsdemandearticles = detailsdemandearticles;
    }




}


