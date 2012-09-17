package com.lds.vo;
// Generated 28 aout 2012 18:10:32 by Hibernate Tools 3.2.1.GA


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Besoin generated by hbm2java
 */
public class Besoin  implements java.io.Serializable {


     private String idbesoin;
     private Tache tache;
     private Date datebesoin;
     private String descbesoin;
     private String valider;
     private String type;
     private Set detailsfourniturebesoins = new HashSet(0);

    public Besoin() {
    }

	
    public Besoin(String idbesoin, Tache tache) {
        this.idbesoin = idbesoin;
        this.tache = tache;
    }
    public Besoin(String idbesoin, Tache tache, Date datebesoin, String descbesoin, String valider,Set detailsfourniturebesoins) {
       this.idbesoin = idbesoin;
       this.tache = tache;
       this.datebesoin = datebesoin;
       this.descbesoin = descbesoin;
       this.valider=valider;
       this.detailsfourniturebesoins = detailsfourniturebesoins;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValider() {
        return valider;
    }

    public void setValider(String valider) {
        this.valider = valider;
    }
   
    public String getIdbesoin() {
        return this.idbesoin;
    }
    
    public void setIdbesoin(String idbesoin) {
        this.idbesoin = idbesoin;
    }
    public Tache getTache() {
        return this.tache;
    }
    
    public void setTache(Tache tache) {
        this.tache = tache;
    }
    public Date getDatebesoin() {
        return this.datebesoin;
    }
    
    public void setDatebesoin(Date datebesoin) {
        this.datebesoin = datebesoin;
    }
    public String getDescbesoin() {
        return this.descbesoin;
    }
    
    public void setDescbesoin(String descbesoin) {
        this.descbesoin = descbesoin;
    }
    public Set getDetailsfourniturebesoins() {
        return this.detailsfourniturebesoins;
    }
    
    public void setDetailsfourniturebesoins(Set detailsfourniturebesoins) {
        this.detailsfourniturebesoins = detailsfourniturebesoins;
    }




}


