package com.lds.vo;
// Generated 28 aout 2012 18:10:32 by Hibernate Tools 3.2.1.GA



/**
 * DetailsdemandearticleId generated by hbm2java
 */
public class DetailsdemandearticleId  implements java.io.Serializable {


     private String numdemandeprix;
     private String idarticle;

    public DetailsdemandearticleId() {
    }

    public DetailsdemandearticleId(String numdemandeprix, String idarticle) {
       this.numdemandeprix = numdemandeprix;
       this.idarticle = idarticle;
    }
   
    public String getNumdemandeprix() {
        return this.numdemandeprix;
    }
    
    public void setNumdemandeprix(String numdemandeprix) {
        this.numdemandeprix = numdemandeprix;
    }
    public String getIdarticle() {
        return this.idarticle;
    }
    
    public void setIdarticle(String idarticle) {
        this.idarticle = idarticle;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof DetailsdemandearticleId) ) return false;
		 DetailsdemandearticleId castOther = ( DetailsdemandearticleId ) other; 
         
		 return ( (this.getNumdemandeprix()==castOther.getNumdemandeprix()) || ( this.getNumdemandeprix()!=null && castOther.getNumdemandeprix()!=null && this.getNumdemandeprix().equals(castOther.getNumdemandeprix()) ) )
 && ( (this.getIdarticle()==castOther.getIdarticle()) || ( this.getIdarticle()!=null && castOther.getIdarticle()!=null && this.getIdarticle().equals(castOther.getIdarticle()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getNumdemandeprix() == null ? 0 : this.getNumdemandeprix().hashCode() );
         result = 37 * result + ( getIdarticle() == null ? 0 : this.getIdarticle().hashCode() );
         return result;
   }   


}


