/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.beans;

import com.lds.persistance.*;
import com.lds.vo.Boncc;
import com.lds.vo.Detailssortiearticle;
import com.lds.vo.Projet;
import com.lds.vo.Tache;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.primefaces.event.FileUploadEvent;

public class ProjetBean implements Serializable {

    private List<Projet> filteredProjets;
    private List<Projet> projets;
    private Projet selectedAffaire;
    private Projet selectedIntervention;
    private Projet affaire;
    private Projet intervention;
    private ProjetDao dao;
    private ProjetDataModel mediumAffairesModel;
    private ProjetDataModel mediumInterventionsModel;
    private String id_projet;
    private String filef;
    private String filed;
    private Boncc boncc = new Boncc();
    private static List<Boncc> bonccs = new ArrayList<Boncc>();
    private List<Boncc> mesbons = new ArrayList<Boncc>();
    private List<Detailssortiearticle> mesmateriels = new ArrayList<Detailssortiearticle>();

    public ProjetBean() {

        affaire = new Projet();
        intervention = new Projet();
        projets = new ArrayList<Projet>();
        dao = new ProjetHDao();
        projets = dao.getAllProjet();
        mediumAffairesModel = new ProjetDataModel(this.getAllAffaire());
        mediumInterventionsModel = new ProjetDataModel(this.getAllIntervention());


    }

    public void setId_projet(String id_projet) {
        this.id_projet = id_projet;
    }

    public String getId_projet() {
        return id_projet;
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

    public String getFilef() {
        return filef;
    }

    public void setFilef(String filef) {
        this.filef = filef;
    }

    public String getFiled() {
        return filed;
    }

    public void setFiled(String filed) {
        this.filed = filed;
    }

    public Boncc getBoncc() {
        return boncc;
    }

    public void setBoncc(Boncc boncc) {
        this.boncc = boncc;
    }

    public List<Boncc> getBonccs() {
        return bonccs;
    }

    public void setBonccs(List<Boncc> bonccs) {
        ProjetBean.bonccs = bonccs;
    }

    public List<Boncc> getMesbons() {
        return mesbons;
    }

    public void setMesbons(List<Boncc> mesbons) {
        this.mesbons = mesbons;
    }

    public List<Detailssortiearticle> getMesmateriels() {
        return mesmateriels;
    }

    public void setMesmateriels(List<Detailssortiearticle> mesmateriels) {
        this.mesmateriels = mesmateriels;
    }

    public void reinit() {
        boncc = new Boncc();
    }

    public void supprimerAffaire() {
        if (selectedAffaire == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Veuillez choisir une affaire", "Selectionnez une ligne !"));
        }

        //suppression des bons clients pour l'affaire
        BonccDao bd = new BonccHDao();
        Iterator it = bd.getAllBoncc().iterator();
        while (it.hasNext()) {
            Boncc bnc = (Boncc) it.next();
            if (bnc.getIdprojet().equals(selectedAffaire.getIdprojet())) {
                bd.delete(bnc.getNumboncc());
            }
        }

        //suppression de l'affaire
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

        BonccDao bd = new BonccHDao();
        Iterator li = bonccs.iterator();
        while (li.hasNext()) {
            //Recupération objet
            Boncc pu = (Boncc) li.next();
            pu.setIdprojet(affaire.getIdprojet());
            bd.insert(pu);
        }

        affaire.setLienfacture(filef);
        affaire.setLiendevis(filed);
        affaire.setTypeprojet("1");
        dao.insert(affaire);
        affaire = new Projet();
        projets = dao.getAllProjet();
        mediumAffairesModel = new ProjetDataModel(this.getAllAffaire());
        return "succesAjout";

    }

    public String ajouterIntervention() {

        TacheDao td = new TacheHDao();
        Tache t = new Tache();
        t.setNumtache(intervention.getIdprojet());
        t.setTypetache("intervention");

        intervention.setTypeprojet("2");
        for (Projet projet : projets) {
            if (projet.getIdprojet().equals(intervention.getIdprojet())) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Ce projet existe dejà !", "Veuillez changer le Code de projet."));
                return "projet_ajout";
            }
        }

        //dao1.insert(new Element(id_projet));
        dao.insert(intervention);
        td.insert(t);
        intervention = new Projet();
        projets = dao.getAllProjet();
        id_projet = new String();
        mediumInterventionsModel = new ProjetDataModel(this.getAllIntervention());
        return "succesAjout";

    }

    public void handleFileUpload(FileUploadEvent event) throws IOException {
        String path = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/files");

        try {
            File targetFolder = new File(path);
            InputStream inputStream = event.getFile().getInputstream();
            OutputStream out = new FileOutputStream(new File(targetFolder,
                    event.getFile().getFileName()));
            int read = 0;
            byte[] bytes = new byte[1024];
            while ((read = inputStream.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            inputStream.close();
            out.flush();
            out.close();
            filed = "../../files/" + event.getFile().getFileName();
        } catch (IOException e) {
            e.printStackTrace();


        }
    }

    public void handleFileUpload1(FileUploadEvent event) {
        String path = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/files");

        try {
            File targetFolder = new File(path);
            InputStream inputStream = event.getFile().getInputstream();
            OutputStream out = new FileOutputStream(new File(targetFolder,
                    event.getFile().getFileName()));
            int read = 0;
            byte[] bytes = new byte[1024];
            while ((read = inputStream.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            inputStream.close();
            out.flush();
            out.close();
            filef = "../../files/" + event.getFile().getFileName();
        } catch (IOException e) {
            e.printStackTrace();


        }
    }

    public void modifAffaire() {
        FacesContext fc = FacesContext.getCurrentInstance();
        ConfigurableNavigationHandler nav = (ConfigurableNavigationHandler) fc.getApplication().getNavigationHandler();
        nav.performNavigation("modif_aff");
    }

    public void modifIntervention() {

        FacesContext fc = FacesContext.getCurrentInstance();
        ConfigurableNavigationHandler nav = (ConfigurableNavigationHandler) fc.getApplication().getNavigationHandler();
        nav.performNavigation("modif_interv");

    }

    public String enrModifAffaire() {

        selectedAffaire.setLienfacture(filef);
        selectedAffaire.setLiendevis(filed);
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
            if (dp.getTypeprojet().equals("1")) {
                allRef.add(dp);
            }
        }
        return allRef;
    }

    private List<Projet> getAllIntervention() {

        Iterator li = projets.iterator();
        List<Projet> allRef = new ArrayList<Projet>();
        while (li.hasNext()) {
            //recupération du projet
            Projet dp = (Projet) li.next();
            //Recuperation de l'affaire enregistree            
            if (dp.getTypeprojet().equals("2")) {
                allRef.add(dp);
            }
        }
        return allRef;
    }

    public void materiels() {
        List<Detailssortiearticle> materiel = new ArrayList<Detailssortiearticle>();
        DetailsSortieArticleDao dsad = new DetailsSortieArticleHDao();
        Iterator it = dsad.getAllDetailssortiearticles().iterator();
        while (it.hasNext()) {
            Detailssortiearticle dsa = (Detailssortiearticle) it.next();
            if (dsa.getBonsortie().getTache().getProjet().getIdprojet().equals(selectedIntervention.getIdprojet())) {
                materiel.add(dsa);
            }
        }
        mesmateriels = materiel;
    }

    public void bons() {
        List<Boncc> bon = new ArrayList<Boncc>();
        BonccDao bd = new BonccHDao();
        Iterator it = bd.getAllBoncc().iterator();
        while (it.hasNext()) {
            Boncc bnc = (Boncc) it.next();
            if (bnc.getIdprojet().equals(selectedAffaire.getIdprojet())) {
                bon.add(bnc);
            }
        }
        mesbons = bon;
    }
}
