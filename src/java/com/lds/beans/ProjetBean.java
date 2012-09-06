/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.beans;

import com.lds.persistance.ProjetDao;
import com.lds.persistance.ProjetHDao;
import com.lds.vo.Projet;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import org.primefaces.model.UploadedFile;

public class ProjetBean implements Serializable {

    private List<Projet> filteredProjets;
    private SelectItem[] options;
    private List<Projet> projets;
    private Projet selectedAffaire;
    private Projet selectedIntervention;
    private Projet affaire;
    private Projet intervention;
    private ProjetDao dao;
    private ProjetDataModel mediumAffairesModel;
    private ProjetDataModel mediumInterventionsModel;
    private String id_projet;    
    private UploadedFile filef; 
    private UploadedFile filed; 

      public ProjetBean() {
                
        affaire = new Projet();
        intervention = new Projet();
        projets = new ArrayList<Projet>();         
        dao = new ProjetHDao();
        projets = dao.getAllProjet();
        mediumAffairesModel = new ProjetDataModel(this.getAllAffaire());
        mediumInterventionsModel = new ProjetDataModel(this.getAllIntervention());
        options = this.createFilterOptions();
    }
            
    public void setId_projet(String id_projet) {
        this.id_projet = id_projet;
    }

    public String getId_projet() {
        return id_projet;
    }

    public SelectItem[] getOptions() {
        return options;
    }

    public void setOptions(SelectItem[] options) {
        this.options = options;
    }

    
    public Projet getSelectedAffaire() {
        return selectedAffaire;
    }

    public void setSelectedAffaire(Projet selectedAffaire) {
        this.selectedAffaire = selectedAffaire;
    }

    public Projet getSelectedIntervention() {
        return selectedIntervention;
    }

    public void setSelectedIntervention(Projet selectedIntervention) {
        this.selectedIntervention = selectedIntervention;
    }
   
    public Projet getAffaire() {
        return affaire;
    }

    public void setAffaire(Projet affaire) {
        this.affaire = affaire;
    }

    public Projet getIntervention() {
        return intervention;
    }

    public void setIntervention(Projet intervention) {
        this.intervention = intervention;
    }
        
    public List<Projet> getFilteredProjets() {
        return filteredProjets;
    }

    public void setFilteredProjets(List<Projet> filteredProjets) {
        this.filteredProjets = filteredProjets;
    }

    public List<Projet> getProjets() {
        return projets;
    }

    public ProjetDataModel getMediumAffairesModel() {
        return mediumAffairesModel;
    }

    public void setMediumAffairesModel(ProjetDataModel mediumAffairesModel) {
        this.mediumAffairesModel = mediumAffairesModel;
    }

    public ProjetDataModel getMediumInterventionsModel() {
        return mediumInterventionsModel;
    }

    public void setMediumInterventionsModel(ProjetDataModel mediumInterventionsModel) {
        this.mediumInterventionsModel = mediumInterventionsModel;
    }
 
    public UploadedFile getFilef() {
        return filef;
    }

    public void setFilef(UploadedFile filef) {
        this.filef = filef;
    }
    
    public UploadedFile getFiled() {
        return filed;
    }

    public void setFiled(UploadedFile filed) {
        this.filed = filed;
    }
            

    public void supprimerAffaire() {
        if (selectedAffaire == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Veuillez choisir une affaire", "Selectionnez une ligne !"));
        }

        dao.delete(selectedAffaire.getIdprojet());        
        projets = dao.getAllProjet();
        mediumAffairesModel = new ProjetDataModel(this.getAllAffaire());

    }
    
      public void supprimerIntervention() {
        if (selectedIntervention == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Veuillez choisir une intervention", "Selectionnez une ligne !"));
        }

        dao.delete(selectedIntervention.getIdprojet());        
        projets = dao.getAllProjet();
        mediumInterventionsModel = new ProjetDataModel(this.getAllIntervention());

    }

    public String ajouterAffaire() {        
         //Si le num du projet est dejà utilisé
        for (Projet projet : projets) {
            if (projet.getIdprojet().equals(affaire.getIdprojet())) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Ce projet existe dejà !", "Veuillez changer le Code de projet."));
                return "";
            }
        }
        
        if(filef!=null)
        affaire.setLienfacture(filef.getFileName());                              
        if(filed!=null)
        affaire.setLiendevis(filed.getFileName());   
        affaire.setTypeprojet("1");
        dao.insert(affaire);
        affaire = new Projet();
        projets = dao.getAllProjet();        
        mediumAffairesModel = new ProjetDataModel(this.getAllAffaire());
        return "succesAjout";               

    }
    
     public String ajouterIntervention() {
         
        intervention.setTypeprojet("2");
        for (Projet projet : projets) {
            if (projet.getIdprojet().equals(intervention.getIdprojet())) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Ce projet existe dejà !", "Veuillez changer le Code de projet."));
                return "projet_ajout";
            }
        }

        //dao1.insert(new Element(id_projet));
        dao.insert(intervention);
        intervention = new Projet();
        projets = dao.getAllProjet();
        id_projet = new String();
        mediumInterventionsModel = new ProjetDataModel(this.getAllIntervention());
        return "succesAjout";

    }


    public String modifAffaire() {
        if (selectedAffaire == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Veuillez choisir un projet", "Selectionnez une ligne !"));
            return "";
        } else {
            //typeUser=selectedProjet.getTypeuser().getTypeuser();
            return "modif_aff";
        }
    }
    
     public String modifIntervention() {
        if (selectedIntervention == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Veuillez choisir un projet", "Selectionnez une ligne !"));
            return "";
        } else {
            //typeUser=selectedProjet.getTypeuser().getTypeuser();
            return "modif_interv";
        }
    }

    public String enrModifAffaire() {
        //selectedProjet.setTypeuser(new Typeuser(typeUser));
        if(filef!=null)
        selectedAffaire.setLienfacture(filef.getFileName());                              
        if(filed!=null)
        selectedAffaire.setLiendevis(filed.getFileName()); 
        dao.update(selectedAffaire);
        projets = dao.getAllProjet();
        mediumAffairesModel = new ProjetDataModel(this.getAllAffaire());
        return "succesAjout";
    }
    
      public String enrModifIntervention() {
        //selectedProjet.setTypeuser(new Typeuser(typeUser));
        dao.update(selectedIntervention);
        projets = dao.getAllProjet();
        mediumAffairesModel = new ProjetDataModel(this.getAllIntervention());
        return "succesAjout";
    }

    public List<String> allNomProjets() {
        List<String> all = new ArrayList<String>();
        Iterator li = projets.iterator();
        while (li.hasNext()) {
          //Recupération objet
            Projet pu = (Projet) li.next();
            all.add(pu.getIdprojet());
        }

        return all;
    }
    
    
       public List<Projet> getAllAffaire() {
        Iterator li = projets.iterator();
        List<Projet> allRef = new ArrayList<Projet>();
        while (li.hasNext()) {            
            //recupération du projet
            Projet dp = (Projet) li.next();                       
            //Recuperation de l'affaire enregistree            
                if (dp.getTypeprojet().equals("1"))                    
                    allRef.add(dp);                                        
        }
        return allRef;
    }
    
       
     public List<Projet> getAllIntervention() {
        
        Iterator li = projets.iterator();
        List<Projet> allRef = new ArrayList<Projet>();
        while (li.hasNext()) {            
            //recupération du projet
            Projet dp = (Projet) li.next();                       
            //Recuperation de l'affaire enregistree            
                if (dp.getTypeprojet().equals("2"))                    
                    allRef.add(dp);                                        
        }
        return allRef;     
     }            
            
      private SelectItem[] createFilterOptions()  {  
          
        SelectItem[] options1 = new SelectItem[this.getAllAffaire().size() + 1];   
        options1[0] = new SelectItem("", "Select");  
        Iterator li = this.getAllAffaire().iterator();
        Integer i =0;
        while(li.hasNext()) {  
            Projet po = (Projet) li.next();
            options1[i + 1] = new SelectItem(po.getIdprojet());              
        }  
  
        return options1;  
    } 
}
