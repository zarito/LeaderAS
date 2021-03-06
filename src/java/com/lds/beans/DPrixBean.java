/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.beans;

import com.lds.persistance.*;
import com.lds.vo.*;
import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import org.primefaces.model.DualListModel;
import org.primefaces.model.LazyDataModel;

public class DPrixBean implements Serializable {

    private List<Demandeprix> filteredDemandeprixs;
    private String qnte;
    private List<Demandeprix> demandeprixs;
    private DualListModel<Fournisseur> fournisseurs_add;
    private List<Article> articles_add;
    private List<Fournisseur> fournisseurs;
    private List<Detailsdemandearticle> ddarticles;
    private Demandeprix selectedDemandeprix;
    private Detailsdemandearticle selectedDDArticle;
    private Fournisseur selectedFournisseur;
    private Demandeprix dprix;
    private DemandePrixDao dao;
    private FournisseurDao daof;
    private ArticleDao daoa;
    private DPrixDataModel mediumDPrixModel;
    private FournisseurDataModel mediumFournModel;
    private DetailsDemandeArticleDataModel mediumArtModel;
    private DetailsDemandeArticleDataModel mediumArtModel1;
    private Detailsdemandearticle dda = new Detailsdemandearticle();
    private String aart;
    private String fourn;
    private ArrayList<Article> articles;

    public DPrixBean() {


        //fournisseurs
        List<Fournisseur> source = new ArrayList<Fournisseur>();
        List<Fournisseur> target = new ArrayList<Fournisseur>();

        articles_add = new ArrayList<Article>();
        daoa = new ArticleHDao();
        articles_add = daoa.getAllArticle();
        daof = new FournisseurHDao();
        source = daof.getAllFournisseur();
        fournisseurs_add = new DualListModel<Fournisseur>(source, target);
        dprix = new Demandeprix();
        demandeprixs = new ArrayList<Demandeprix>();
        dao = new DemandePrixHDao();
        demandeprixs = dao.getAllDevis();
        mediumDPrixModel = new DPrixDataModel(this.getAllReference());
        ddarticles = new ArrayList<Detailsdemandearticle>();
        fournisseurs = new ArrayList<Fournisseur>();
        mediumArtModel = new DetailsDemandeArticleDataModel(ddarticles);


    }

    public DPrixBean(String id) {
    }

    public List<Fournisseur> getFournisseurs() {
        return fournisseurs;
    }

    public void setFournisseurs(List<Fournisseur> fournisseurs) {
        this.fournisseurs = fournisseurs;
    }

    public DetailsDemandeArticleDataModel getMediumArtModel() {
        return mediumArtModel;
    }

    public void setMediumArtModel(DetailsDemandeArticleDataModel mediumArtModel) {
        this.mediumArtModel = mediumArtModel;
    }

    public DPrixDataModel getMediumDPrixModel() {
        return mediumDPrixModel;
    }

    public void setMediumDPrixModel(DPrixDataModel mediumDPrixModel) {
        this.mediumDPrixModel = mediumDPrixModel;
    }

    public DualListModel<Fournisseur> getFournisseurs_add() {
        return fournisseurs_add;
    }

    public void setFournisseurs_add(DualListModel<Fournisseur> fournisseurs_add) {
        this.fournisseurs_add = fournisseurs_add;
    }

    public Detailsdemandearticle getSelectedDDArticle() {
        return selectedDDArticle;
    }

    public void setSelectedDDArticle(Detailsdemandearticle selectedDDArticle) {
        this.selectedDDArticle = selectedDDArticle;
    }

    public Fournisseur getSelectedFournisseur() {
        return selectedFournisseur;
    }

    public void setSelectedFournisseur(Fournisseur selectedFournisseur) {
        this.selectedFournisseur = selectedFournisseur;
    }

    public Demandeprix getSelectedDemandeprix() {
        return selectedDemandeprix;
    }

    public DetailsDemandeArticleDataModel getMediumArtModel1() {
        return mediumArtModel1;
    }

    public void setMediumArtModel1(DetailsDemandeArticleDataModel mediumArtModel1) {
        this.mediumArtModel1 = mediumArtModel1;
    }

    public FournisseurDataModel getMediumFournModel() {
        return mediumFournModel;
    }

    public void setMediumFournModel(FournisseurDataModel mediumFournModel) {
        this.mediumFournModel = mediumFournModel;
    }

    public String getAart() {
        return aart;
    }

    public void setAart(String aart) {
        this.aart = aart;
    }

    public String getFourn() {
        return fourn;
    }

    public void setFourn(String fourn) {
        this.fourn = fourn;
    }

    public void setSelectedDemandeprix(Demandeprix selectedDemandeprix) {
        this.selectedDemandeprix = selectedDemandeprix;
    }

    public LazyDataModel<Demandeprix> getMediumDemandeprixsModel() {
        return mediumDPrixModel;
    }

    public Demandeprix getDprix() {
        return dprix;
    }

    public void setDprix(Demandeprix dprix) {
        this.dprix = dprix;
    }

    public String getQnte() {
        return qnte;
    }

    public void setQnte(String qnte) {
        this.qnte = qnte;
    }

    public List<Demandeprix> getFilteredDemandeprixs() {
        return filteredDemandeprixs;
    }

    public void setFilteredDemandeprixs(List<Demandeprix> filteredDemandeprixs) {
        this.filteredDemandeprixs = filteredDemandeprixs;
    }

    public List<Demandeprix> getDemandeprixs() {
        return demandeprixs;
    }

    public void setFournisseurs(ArrayList<Fournisseur> fournisseurs) {
        this.fournisseurs = fournisseurs;
    }

    public ArrayList<Article> getArticles() {
        return (ArrayList<Article>) articles;
    }

    public void setArticles(ArrayList<Article> articles) {
        this.articles = articles;
    }

    public List<Detailsdemandearticle> getDdarticles() {
        return ddarticles;
    }

    public void setDdarticles(List<Detailsdemandearticle> ddarticles) {
        this.ddarticles = ddarticles;
    }

    public List<Article> getArticles_add() {
        return articles_add;
    }

    public void setArticles_add(List<Article> articles_add) {
        this.articles_add = articles_add;
    }

    public void supprimer() {
        if (selectedDemandeprix == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Veuillez choisir un demandeprix", "Selectionnez une ligne !"));
        }

        for (Demandeprix demandeprix : demandeprixs) {
            if (demandeprix.getReferencedemandeprix().equals(selectedDemandeprix.getReferencedemandeprix())) {
                dao.delete(demandeprix.getNumdemandeprix());

            }
        }

        demandeprixs = dao.getAllDevis();
        mediumDPrixModel = new DPrixDataModel(this.getAllReference());

    }

    public String btnAjouter() {
        ddarticles = new ArrayList<Detailsdemandearticle>();
        return "echecAjout";
    }

    public String ajouter() {
        //Si la reference est dejà utilisée          

        for (Demandeprix demandeprix : demandeprixs) {
            if (demandeprix.getReferencedemandeprix().equals(dprix.getReferencedemandeprix())) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Cette demande existe dejà!", "Veuillez changer le numéro de demande."));
                return "echecAjout";
            }
        }
        //sinon
        Iterator li = fournisseurs_add.getTarget().iterator();
        //variables pour construire le num ki es identifiant
        String num = dprix.getReferencedemandeprix()+"-";
        Integer i = 1;
        //Pour chaque fournisseur
        while (li.hasNext()) {
            //Recupération de l'objet            
            String idfo = (String) li.next();
            FournisseurHDao ad = new FournisseurHDao();
            Fournisseur fo;
            dprix.setNumdemandeprix(num + i);
            fo = ad.getFournisseur(idfo);
            dprix.setFournisseur(fo);
            //pour les articles
            Set<Detailsdemandearticle> sdda = new HashSet();            //System.out.println("flk,klgkgffkgkdl" + fo.getIdfournisseur());            
            Iterator lia = ddarticles.iterator();
            while (lia.hasNext()) {
                Detailsdemandearticle dda1 = (Detailsdemandearticle) lia.next();
                //Construction de l'ID
                DetailsdemandearticleId ddai = new DetailsdemandearticleId((num + i), dda1.getArticle().getIdarticle());
                dda1.setId(ddai);
                sdda.add(dda1);
            }
            //le set Detailsdemande articles pour finir la construction de notre objet pr un seul fournisseur
            dprix.setDetailsdemandearticles(sdda);
            //insertion dans la base              
            dao.insert(dprix);
            i++;
        }
        //initialisation        
        dprix = new Demandeprix();
        demandeprixs = dao.getAllDevis();
        mediumDPrixModel = new DPrixDataModel(this.getAllReference());
        return "succesAjout";

    }

    public void details() {
        if (selectedDemandeprix == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Veuillez choisir une demande", "Selectionnez une ligne !"));
           
        } else {

            //Affichage des fournisseurs
            List<Fournisseur> fournis = new ArrayList<Fournisseur>();
            for (Demandeprix dprix1 : demandeprixs) {
                if (selectedDemandeprix.getReferencedemandeprix().equals(dprix1.getReferencedemandeprix())) {
                    fournis.add(dprix1.getFournisseur());
                }

            }
            fournisseurs = fournis;
            mediumFournModel = new FournisseurDataModel(fournis);

            //Affichage des Articles
            List<Detailsdemandearticle> arto = new ArrayList<Detailsdemandearticle>();
            DetailsdemandearticleDao daod = new DetailsdemandearticleHDao();
            List<Detailsdemandearticle> l = daod.getAllDetailsdemandearticle();
            Iterator<Detailsdemandearticle> li = l.iterator();
            while (li.hasNext()) {
                //Recupération objet
                Detailsdemandearticle dda1 = (Detailsdemandearticle) li.next();
                if (dda1.getDemandeprix().getNumdemandeprix().equals(selectedDemandeprix.getNumdemandeprix())) {
                    arto.add(dda1);
                }
            }
            ddarticles = arto;
            mediumArtModel1 = new DetailsDemandeArticleDataModel(arto);

               FacesContext fc = FacesContext.getCurrentInstance();
        ConfigurableNavigationHandler nav = (ConfigurableNavigationHandler) fc.getApplication().getNavigationHandler();
        nav.performNavigation("details_dp");
        }
    }

    public String enrModif() {
        String num = null;
        Date datesecours = null;
        Demandeprix dpsecours = new Demandeprix();
        //On supprime tous ceux ki ont la mm reference
        for (Demandeprix dprix1 : demandeprixs) {
            if (selectedDemandeprix.getReferencedemandeprix().equals(dprix1.getReferencedemandeprix())) {
                //variables pour construire le num ki es identifiant
                datesecours = dprix1.getDatedemandeprix();
                num = dprix1.getReferencedemandeprix();
                dao.delete(dprix1.getNumdemandeprix());
            }
        }

        //On ajoute les supprimés avec la mise à jour                                      
        Integer i = 1;
        Iterator li = fournisseurs.iterator();
        //Pour chaque fournisseur
        while (li.hasNext()) {
            //Recupération de l'objet            
            Fournisseur fo = (Fournisseur) li.next();
            // FournisseurHDao ad = new FournisseurHDao();
            //Fournisseur fo;
            dpsecours.setNumdemandeprix(num + i);
            //fo = ad.getFournisseur(idfo);
            dpsecours.setFournisseur(fo);
            //pour les articles
            Set<Detailsdemandearticle> sdda = new HashSet();
            Iterator lia = ddarticles.iterator();
            while (lia.hasNext()) {
                Detailsdemandearticle dda1 = (Detailsdemandearticle) lia.next();
                //Construction de l'ID
                DetailsdemandearticleId ddai = new DetailsdemandearticleId((num + i), dda1.getArticle().getIdarticle());
                dda1.setId(ddai);
                sdda.add(dda1);
            }
            //le set Detailsdemande articles pour finir la construction de notre objet pr un seul fournisseur
            dpsecours.setDetailsdemandearticles(sdda);
            dpsecours.setDatedemandeprix(datesecours);
            dpsecours.setReferencedemandeprix(num);
            //insertion dans la base              
            dao.insert(dpsecours);
            i++;
        }
        //Initialisation        
        demandeprixs = dao.getAllDevis();
        ddarticles = new ArrayList<Detailsdemandearticle>();
        mediumDPrixModel = new DPrixDataModel(this.getAllReference());
        return "succesAjout";

    }

    public Boolean print() {

        if (selectedDemandeprix != null) {
            return true;
        } else {
            return false;
        }

    }

    public void enleverArt() {
        System.out.println("hhhh");
        if (selectedDDArticle == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Veuillez choisir un article", "Selectionnez une ligne !"));
            System.out.println("nulllllllllllllllllllllll");
        }

        ddarticles.remove(selectedDDArticle);
        mediumArtModel = new DetailsDemandeArticleDataModel(ddarticles);
    }

    public void ajouterArt() {
        Detailsdemandearticle dda1 = new Detailsdemandearticle();
        ArticleHDao ad = new ArticleHDao();
        dda1.setArticle(ad.getArticle(aart));
        dda1.setQntdemande(new Integer(qnte));
        ddarticles.add(dda1);
        mediumArtModel = new DetailsDemandeArticleDataModel(ddarticles);
        mediumArtModel1 = new DetailsDemandeArticleDataModel(ddarticles);
    }

    public void ajouterFourn() {

        Demandeprix dp = selectedDemandeprix;
        Integer nf = fournisseurs.size() + 1;
        String num = dp.getReferencedemandeprix() + nf;
        //Nouvo fournisseur
        FournisseurHDao ad = new FournisseurHDao();
        Fournisseur fo;
        fo = ad.getFournisseur(fourn);
        dp.setFournisseur(fo);
        dp.setNumdemandeprix(num);
        //insertion dans la base              
        dao.insert(dp);
        fournisseurs.add(fo);
        mediumFournModel = new FournisseurDataModel(fournisseurs);

    }

    public List<Demandeprix> getAllReference() {
        Iterator li = demandeprixs.iterator();
        List<Demandeprix> allRef = new ArrayList<Demandeprix>();
        while (li.hasNext()) {
            Boolean Test = true;
            //recupération de la demande de prix
            Demandeprix dp = (Demandeprix) li.next();
            Iterator li1 = allRef.iterator();
            while (li1.hasNext() && Test) {
                //Recuperation de la demande enregistree
                Demandeprix dp1 = (Demandeprix) li1.next();
                if (dp.getReferencedemandeprix().equals(dp1.getReferencedemandeprix())) {
                    Test = false;
                }
            }
            if (Test == true) {
                allRef.add(dp);
            }
        }

        return allRef;
    }

    public void etat_demandeprix() throws ClassNotFoundException, SQLException, JRException, IOException {
        if (selectedFournisseur == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Veuillez choisir un fournisseur", "Selectionnez une ligne !"));
        }
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/lds_db", "postgres", "lds");


        java.io.InputStream in = getClass().getResourceAsStream("demande.jasper");
        Map paramettres = new HashMap();
        paramettres.put("id_refrence", selectedDemandeprix.getReferencedemandeprix());
        paramettres.put("id_fournisseur",selectedFournisseur.getIdfournisseur());
        URL in3 = getClass().getResource("demande.jrxml");
        String url11 = in3.getPath();
        String url2[] = url11.split("demande.jrxml");

        paramettres.put("lien_image", url2[0] + "logo.png");
        JasperPrint editer = JasperFillManager.fillReport(in, paramettres, con);
        HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        httpServletResponse.addHeader("Content-disposition", "attachment; filename=demande_" + selectedDemandeprix.getReferencedemandeprix() + selectedFournisseur.getIdfournisseur() + ".pdf");
        //ServletOutputStream servletOutputStream=httpServletResponse.getOutputStream();
        try {
            JasperExportManager.exportReportToPdfStream(editer, httpServletResponse.getOutputStream());
        } catch (Exception e) {
        }
    }

    public static void main(String args[]) throws Exception {

        DPrixBean dd = new DPrixBean("");
        dd.etat_demandeprix();
    }
}
