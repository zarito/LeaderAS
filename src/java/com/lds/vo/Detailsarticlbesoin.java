package com.lds.vo;
// Generated 28 aout 2012 18:10:32 by Hibernate Tools 3.2.1.GA



/**
 * Detailsarticlbesoin generated by hbm2java
 */
public class Detailsarticlbesoin  implements java.io.Serializable {


     private DetailsarticlbesoinId id;
     private Integer qntbesoin;

    public Detailsarticlbesoin() {
    }

	
    public Detailsarticlbesoin(DetailsarticlbesoinId id) {
        this.id = id;
    }
    public Detailsarticlbesoin(DetailsarticlbesoinId id, Integer qntbesoin) {
       this.id = id;
       this.qntbesoin = qntbesoin;
    }
   
    public DetailsarticlbesoinId getId() {
        return this.id;
    }
    
    public void setId(DetailsarticlbesoinId id) {
        this.id = id;
    }
    public Integer getQntbesoin() {
        return this.qntbesoin;
    }
    
    public void setQntbesoin(Integer qntbesoin) {
        this.qntbesoin = qntbesoin;
    }




}


