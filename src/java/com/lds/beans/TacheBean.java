/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.beans;

import com.lds.persistance.*;
import com.lds.vo.*;
import java.io.*;
import java.util.*;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DualListModel;

public class TacheBean implements Serializable {

    private List<Tache> filteredTaches;
    private List<Tache> taches;
    private DualListModel<Personnel> personnels_add;
    private List<Soustache> soustaches;
    private Soustache soustache;
    private Soustache selectedSt;
    private List<Personnel> personnels;
    private List<Detailstachepersonnel> dtpersonnels;
    private Tache selectedTache;
    private Detailstachepersonnel selectedDTPersonnel;
    private Personnel selectedPersonnel;
    private Tache tache;
    private TacheDao dao;
    private PersonnelDao daop;
    private SousTacheDao daost;
    private TacheDataModel mediumTacheModel;
    private PersonnelDataModel mediumPersModel;
    private SousTacheDataModel mediumStModel;
    private SousTacheDataModel mediumStModel1;
    private DTPersonnelDataModel mediumDPersModel;
    private Detailstachepersonnel dtp;
    private String aart;
    private String pers;
    private Date aff_dated;
    private Date aff_datef;
    private String filed;
    private List<Detailssortiearticle> mesmateriels = new ArrayList<Detailssortiearticle>();     

    public TacheBean() {


        //fournisseurs
        List<Personnel> source ;
        List<Personnel> target = new ArrayList<Personnel>();

        soustaches = new ArrayList<Soustache>();
        daost = new SousTacheHDao();
        soustache = new Soustache();
        soustaches = new ArrayList<Soustache>();
        daop = new PersonnelHDao();
        source = daop.getAllPersonnels();
        personnels_add = new DualListModel<Personnel>(source, target);
        tache = new Tache();
        dtp = new Detailstachepersonnel();
        taches = new ArrayList<Tache>();
        dao = new TacheHDao();
        taches = dao.getAllTache();
        mediumTacheModel = new TacheDataModel(taches);
        dtpersonnels = new ArrayList<Detailstachepersonnel>();
        personnels = new ArrayList<Personnel>();
        mediumDPersModel = new DTPersonnelDataModel(dtpersonnels);
        mediumStModel = new SousTacheDataModel(soustaches);        

    }

    public TacheBean(String id) {
    }

    public String getAart() {
        return aart;
    }

    public void setAart(String aart) {
        this.aart = aart;
    }

    public SousTacheDataModel getMediumStModel1() {
        return mediumStModel1;
    }

    public void setMediumStModel1(SousTacheDataModel mediumStModel1) {
        this.mediumStModel1 = mediumStModel1;
    }

    public Soustache getSoustache() {
        return soustache;
    }

    public void setSoustache(Soustache soustache) {
        this.soustache = soustache;
    }

    public String getFiled() {
        return filed;
    }

    public void setFiled(String filed) {
        this.filed = filed;
    }

    public Date getAff_dated() {
        return aff_dated;
    }

    public void setAff_dated(Date aff_dated) {
        this.aff_dated = aff_dated;
    }

    public Date getAff_datef() {
        return aff_datef;
    }

    public void setAff_datef(Date aff_datef) {
        this.aff_datef = aff_datef;
    }

    public Soustache getSelectedSt() {
        return selectedSt;
    }

    public void setSelectedSt(Soustache selectedSt) {
        this.selectedSt = selectedSt;
    }

    public Detailstachepersonnel getDtp() {
        return dtp;
    }

    public void setDtp(Detailstachepersonnel dtp) {
        this.dtp = dtp;
    }

    public List<Detailstachepersonnel> getDtpersonnels() {
        return dtpersonnels;
    }

    public void setDtpersonnels(List<Detailstachepersonnel> dtpersonnels) {
        this.dtpersonnels = dtpersonnels;
    }

    public List<Tache> getFilteredTaches() {
        return filteredTaches;
    }

    public void setFilteredTaches(List<Tache> filteredTaches) {
        this.filteredTaches = filteredTaches;
    }

    public DTPersonnelDataModel getMediumDPersModel() {
        return mediumDPersModel;
    }

    public void setMediumDPersModel(DTPersonnelDataModel mediumDPersModel) {
        this.mediumDPersModel = mediumDPersModel;
    }

    public PersonnelDataModel getMediumPersModel() {
        return mediumPersModel;
    }

    public void setMediumPersModel(PersonnelDataModel mediumPersModel) {
        this.mediumPersModel = mediumPersModel;
    }      

    public SousTacheDataModel getMediumStModel() {
        return mediumStModel;
    }

    public void setMediumStModel(SousTacheDataModel mediumStModel) {
        this.mediumStModel = mediumStModel;
    }

    public TacheDataModel getMediumTacheModel() {
        return mediumTacheModel;
    }

    public void setMediumTacheModel(TacheDataModel mediumTacheModel) {
        this.mediumTacheModel = mediumTacheModel;
    }

    public String getPers() {
        return pers;
    }

    public void setPers(String pers) {
        this.pers = pers;
    }

    public List<Personnel> getPersonnels() {
        return personnels;
    }

    public void setPersonnels(List<Personnel> personnels) {
        this.personnels = personnels;
    }

    public DualListModel<Personnel> getPersonnels_add() {
        return personnels_add;
    }

    public void setPersonnels_add(DualListModel<Personnel> personnels_add) {
        this.personnels_add = personnels_add;
    }

    public Personnel getSelectedPersonnel() {
        return selectedPersonnel;
    }

    public void setSelectedPersonnel(Personnel selectedPersonnel) {
        this.selectedPersonnel = selectedPersonnel;
    }

    public Tache getSelectedTache() {
        return selectedTache;
    }

    public void setSelectedTache(Tache selectedTache) {
        this.selectedTache = selectedTache;
    }

    public List<Soustache> getSoustaches() {
        return soustaches;
    }

    public void setSoustaches(List<Soustache> soustaches) {
        this.soustaches = soustaches;
    }

    public Tache getTache() {
        return tache;
    }

    public void setTache(Tache tache) {
        this.tache = tache;
    }

    public List<Tache> getTaches() {
        return taches;
    }

    public void setTaches(List<Tache> taches) {
        this.taches = taches;
    }

    public Detailstachepersonnel getSelectedDTPersonnel() {
        return selectedDTPersonnel;
    }

    public void setSelectedDTPersonnel(Detailstachepersonnel selectedDTPersonnel) {
        this.selectedDTPersonnel = selectedDTPersonnel;
    }

    public List<Detailssortiearticle> getMesmateriels() {
        return mesmateriels;
    }

    public void setMesmateriels(List<Detailssortiearticle> mesmateriels) {
        this.mesmateriels = mesmateriels;
    }
    
    

    public void handleFileUpload(FileUploadEvent event) {
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

    public void supprimer() {
        if (selectedTache == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Veuillez choisir une tâche", "Selectionnez une ligne !"));
        }

        dao.delete(selectedTache.getNumtache());
        taches = dao.getAllTache();
        mediumTacheModel = new TacheDataModel(taches);

    }

    public String btnAjouter() {
        List<Personnel> source = daop.getAllPersonnels();
        List<Personnel> target = new ArrayList<Personnel>();
        personnels_add = new DualListModel<Personnel>(source, target);
        soustaches = new ArrayList<Soustache>();
        mediumStModel = new SousTacheDataModel(soustaches);
        return "tache_ajout";
    }

    public void ajouterSt() {
        Soustache st = new Soustache();
        st.setIdsousprojet(soustache.getIdsousprojet());
        st.setDescsousprojet(soustache.getDescsousprojet());
        soustaches.add(st);
        mediumStModel = new SousTacheDataModel(soustaches);
        mediumStModel1 = new SousTacheDataModel(soustaches);
    }

    public void enleverSt() {
        if (selectedSt == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Veuillez choisir une sous-tache", "Selectionnez une ligne !"));
        }

        soustaches.remove(selectedSt);
        mediumStModel = new SousTacheDataModel(soustaches);
        mediumStModel1 = new SousTacheDataModel(soustaches);
    }

    public String ajouter() {
        //Si la reference est dejà utilisée          
        for (Tache tache1 : taches) {
            if (tache1.getNumtache().equals(tache.getNumtache())) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Cette tache existe dejà!", "Veuillez changer le numéro de tache."));
                return "echecAjout";
            }
        }
        //sinon

        Iterator li = personnels_add.getTarget().iterator();
        //Set<Personnel> 
        Set<Detailstachepersonnel> sdtp = new HashSet();
        //Pour chaque personnel
        while (li.hasNext()) {
            //Recupération de l'objet            
            Personnel perso = (Personnel) li.next();
            //Construction de l'ID
            DetailstachepersonnelId dtpi = new DetailstachepersonnelId(tache.getNumtache(), perso.getIdpersonnel());
            dtp.setId(dtpi);
            dtp.setPersonnel(perso);
            dtp.setTache(tache);
            sdtp.add(dtp);
        }

        tache.setDetailstachepersonnels(sdtp);

        //Enregistrer les sous taches
        Iterator li1 = soustaches.iterator();
        Set<Soustache> sst = new HashSet();
        while (li1.hasNext()) {
            Soustache str = (Soustache) li1.next();
            str.setTache(tache);
            sst.add(str);

        }


        tache.setLienschema(filed);

        tache.setSoustaches(sst);
        //insertion dans la base              
        dao.insert(tache);
        //initialisation                       
        tache = new Tache();
        taches = dao.getAllTache();
        mediumTacheModel = new TacheDataModel(taches);
        return "succesAjout";

    }

    public void details() {
     
        //Affichage des personnels   
        List<Personnel> persos = new ArrayList<Personnel>();
        DetailstachepersonnelDao daod = new DetailstachepersonnelHDao();
        List<Detailstachepersonnel> l = daod.getAllDetailstachepersonnel();
        Iterator<Detailstachepersonnel> li = l.iterator();
        while (li.hasNext()) {
            //Recupération objet
            Detailstachepersonnel dda = (Detailstachepersonnel) li.next();
            if (dda.getTache().getNumtache().equals(selectedTache.getNumtache())) {
                aff_dated = dda.getDatedebut();
                aff_datef = dda.getDatefin();
                persos.add(dda.getPersonnel());
            }
        }
        personnels_add.setTarget(persos);
        dtp.setDatedebut(aff_dated);
        dtp.setDatefin(aff_datef);

        //Affichage des Sous-taches
        List<Soustache> soustaches1 = new ArrayList<Soustache>();
        List<Soustache> lst = daost.getAllSoustache();
        Iterator<Soustache> it = lst.iterator();
        while (it.hasNext()) {
            //Recupération objet
            Soustache dda = (Soustache) it.next();
            if (dda.getTache().getNumtache().equals(selectedTache.getNumtache())) {
                soustaches1.add(dda);
            }
        }
        soustaches = soustaches1;
        mediumStModel1 = new SousTacheDataModel(soustaches1);

        FacesContext fc = FacesContext.getCurrentInstance();
        ConfigurableNavigationHandler nav = (ConfigurableNavigationHandler) fc.getApplication().getNavigationHandler();
        nav.performNavigation("details_tache");        
    }

    public String enrModif() {

        //On supprime tous ceux ki ont la mm reference
        dao.delete(selectedTache.getNumtache());

        //On ajoute les supprimés avec la mise à jour                                      
        Iterator li = personnels_add.getTarget().iterator();
        //Set<Personnel> 
        Set<Detailstachepersonnel> sdtp = new HashSet();
        //Pour chaque personnel
        while (li.hasNext()) {
            //Recupération de l'objet            
            Personnel perso = (Personnel) li.next();
            //Construction de l'ID
            DetailstachepersonnelId dtpi = new DetailstachepersonnelId(selectedTache.getNumtache(), perso.getIdpersonnel());
            dtp.setId(dtpi);
            dtp.setPersonnel(perso);
            dtp.setTache(selectedTache);
            sdtp.add(dtp);
        }

        selectedTache.setDetailstachepersonnels(sdtp);

        //Enregistrer les sous taches
        Iterator li1 = soustaches.iterator();
        Set<Soustache> sst = new HashSet();
        while (li1.hasNext()) {
            Soustache str = (Soustache) li1.next();
            str.setTache(selectedTache);
            sst.add(str);
        }

        selectedTache.setSoustaches(sst);
        selectedTache.setLienschema(filed);
        //insertion dans la base              
        dao.insert(selectedTache);
        //initialisation             
        soustaches = new ArrayList<Soustache>();
        taches = dao.getAllTache();
        mediumTacheModel = new TacheDataModel(taches);
        return "succesAjout";

    }
    
      public List<Tache> getAllTaches() {
        Iterator li = taches.iterator();
        List<Tache> allRef = new ArrayList<Tache>();
        while (li.hasNext()) {
            //recupération du projet
            Tache dp = (Tache) li.next();
            //Recuperation de l'affaire enregistree            
            if (!dp.getTypetache().equals("intervention")) {
                allRef.add(dp);
            }
        }
        return allRef;
    }
      
       public void materiels() {
        List<Detailssortiearticle> materiels = new ArrayList<Detailssortiearticle>();
        DetailsSortieArticleDao dsad = new DetailsSortieArticleHDao();
        Iterator it = dsad.getAllDetailssortiearticles().iterator();
        while (it.hasNext()) {
            Detailssortiearticle dsa = (Detailssortiearticle) it.next();
            if (dsa.getBonsortie().getTache().getNumtache().equals(selectedTache.getNumtache())) {
                materiels.add(dsa);
            }
        }
       mesmateriels =  materiels;
    }
           
}