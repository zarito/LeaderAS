package com.lds.vo;
// Generated 28 aout 2012 18:10:32 by Hibernate Tools 3.2.1.GA



/**
 * Soustache generated by hbm2java
 */
public class Soustache  implements java.io.Serializable {


     private String idsousprojet;
     private Tache tache;
     private String descsousprojet;

    public Soustache() {
    }

	
    public Soustache(String idsousprojet, Tache tache) {
        this.idsousprojet = idsousprojet;
        this.tache = tache;
    }
    public Soustache(String idsousprojet, Tache tache, String descsousprojet) {
       this.idsousprojet = idsousprojet;
       this.tache = tache;
       this.descsousprojet = descsousprojet;
    }
   
    public String getIdsousprojet() {
        return this.idsousprojet;
    }
    
    public void setIdsousprojet(String idsousprojet) {
        this.idsousprojet = idsousprojet;
    }
    public Tache getTache() {
        return this.tache;
    }
    
    public void setTache(Tache tache) {
        this.tache = tache;
    }
    public String getDescsousprojet() {
        return this.descsousprojet;
    }
    
    public void setDescsousprojet(String descsousprojet) {
        this.descsousprojet = descsousprojet;
    }




}

