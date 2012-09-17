/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.beans;

import com.lds.persistance.ArticleHDao;
import com.lds.persistance.BonCommandeHDao;
import com.lds.persistance.DetailsBcArticleHDao;
import com.lds.persistance.FournisseurHDao;
import com.lds.persistance.ProjetHDao;
import com.lds.vo.Article;
import com.lds.vo.Boncommande;
import com.lds.vo.Detailsbcarticle;
import com.lds.vo.DetailsbcarticleId;
import com.lds.vo.Fournisseur;
import com.lds.vo.Projet;
import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

public class BcBean implements Serializable {

    private List<Boncommande> filteredBoncommandes;
    private List<Boncommande> boncommandes;
    private Boncommande selectedBoncommande;
    private Boncommande elt;
    private BonCommandeHDao dao;
    private BoncommandeDataModel mediumBoncommandesModel;
    private String id_fournisseur;
    private String id_projet;
    private BcarticleDataModel mediumBoncommandesModel_article;
    private Detailsbcarticle selectedBoncommande_article;
    private String id_article;
    private String qnt_commande;
    private String prix_unitaire;
    private String id_fourniture;
    private String prix_fourniture;
    private String qnt_fourniture;
    private ArticleHDao article_dao;
    private DetailsBcArticleHDao article_details_dao;

    public BcBean() {
        elt = new Boncommande();
        boncommandes = new ArrayList<Boncommande>();
        //selectedBoncommande=new Boncommande();
        //populateRandomCars(cars, 50);  
        dao = new BonCommandeHDao();
        boncommandes = dao.getAllBonCommandes();
        ArrayList<Boncommande> all = new ArrayList<Boncommande>();
        Iterator li = boncommandes.iterator();
        while (li.hasNext()) {
            //Recupération objet
            Boncommande pu = (Boncommande) li.next();
            if (pu.getProjet().getTypeprojet().equals("1")) {
                pu.setType_projet("Affaire");
            } else {
                pu.setType_projet("Intervention");
            }
            all.add(pu);
        }
        boncommandes = all;
        mediumBoncommandesModel = new BoncommandeDataModel(boncommandes);
        article_dao = new ArticleHDao();
        article_details_dao = new DetailsBcArticleHDao();

    }

    public List<Boncommande> affiche_type_projet(List<Boncommande> bes) {
        ArrayList<Boncommande> all = new ArrayList<Boncommande>();
        Iterator li = boncommandes.iterator();
        while (li.hasNext()) {
            //Recupération objet
            Boncommande pu = (Boncommande) li.next();
            if (pu.getProjet().getTypeprojet().equals("1")) {
                pu.setType_projet("Projet");
            } else {
                pu.setType_projet("Intervention");
            }
            all.add(pu);
        }
        return all;
    }

    public String getId_fourniture() {
        return id_fourniture;
    }

    public void setId_fourniture(String id_fourniture) {
        this.id_fourniture = id_fourniture;
    }

    public String getPrix_fourniture() {
        return prix_fourniture;
    }

    public void setPrix_fourniture(String prix_fourniture) {
        this.prix_fourniture = prix_fourniture;
    }

    public String getQnt_fourniture() {
        return qnt_fourniture;
    }

    public void setQnt_fourniture(String qnt_fourniture) {
        this.qnt_fourniture = qnt_fourniture;
    }

    public String getId_article() {
        return id_article;
    }

    public void setId_article(String id_article) {
        this.id_article = id_article;
    }

    public String getPrix_unitaire() {
        return prix_unitaire;
    }

    public void setPrix_unitaire(String prix_unitaire) {
        this.prix_unitaire = prix_unitaire;
    }

    public String getQnt_commande() {
        return qnt_commande;
    }

    public void setQnt_commande(String qnt_commande) {
        this.qnt_commande = qnt_commande;
    }

    public BoncommandeDataModel getMediumBoncommandesModel() {
        return mediumBoncommandesModel;
    }

    public void setMediumBoncommandesModel(BoncommandeDataModel mediumBoncommandesModel) {
        this.mediumBoncommandesModel = mediumBoncommandesModel;
    }

    public BcarticleDataModel getMediumBoncommandesModel_article() {
        return mediumBoncommandesModel_article;
    }

    public void setMediumBoncommandesModel_article(BcarticleDataModel mediumBoncommandesModel_article) {
        this.mediumBoncommandesModel_article = mediumBoncommandesModel_article;
    }

    public Detailsbcarticle getSelectedBoncommande_article() {
        return selectedBoncommande_article;
    }

    public void setSelectedBoncommande_article(Detailsbcarticle selectedBoncommande_article) {
        this.selectedBoncommande_article = selectedBoncommande_article;
    }

    public List<String> allprojet() {
        List<String> all = new ArrayList<String>();
        ProjetHDao projet_dao = new ProjetHDao();
        ArrayList<Projet> l = (ArrayList<Projet>) projet_dao.getAllProjet();
        Iterator li = l.iterator();
        while (li.hasNext()) {
            //Recupération objet
            Projet pu = (Projet) li.next();
            all.add(pu.getIdprojet());
        }

        return all;
    }

    public List<String> allfournisseur() {
        List<String> all = new ArrayList<String>();
        FournisseurHDao four_dao = new FournisseurHDao();
        ArrayList<Fournisseur> l = (ArrayList<Fournisseur>) four_dao.getAllFournisseur();
        Iterator li = l.iterator();
        while (li.hasNext()) {
            //Recupération objet
            Fournisseur pu = (Fournisseur) li.next();
            // pu=four_dao.getFournisseur(pu.getIdfournisseur());
            all.add(pu.getNom());
        }

        return all;
    }

    public String getId_fournisseur() {
        return id_fournisseur;
    }

    public void setId_fournisseur(String id_fournisseur) {
        this.id_fournisseur = id_fournisseur;
    }

    public String getId_projet() {
        return id_projet;
    }

    public void setId_projet(String id_projet) {
        this.id_projet = id_projet;
    }
    private String id_boncommande;

    public void setId_boncommande(String id_boncommande) {
        this.id_boncommande = id_boncommande;
    }

    public String getId_boncommande() {
        return id_boncommande;
    }

    public Boncommande getSelectedBoncommande() {
        return selectedBoncommande;
    }

    public void setSelectedBoncommande(Boncommande selectedBoncommande) {
        this.selectedBoncommande = selectedBoncommande;
    }

    public Boncommande getElt() {
        return elt;
    }

    public void setElt(Boncommande elt) {
        this.elt = elt;
    }

    public List<Boncommande> getFilteredBoncommandes() {
        return filteredBoncommandes;
    }

    public void setFilteredBoncommandes(List<Boncommande> filteredBoncommandes) {
        this.filteredBoncommandes = filteredBoncommandes;
    }

    public List<Boncommande> getBoncommandes() {
        return boncommandes;
    }

    public void supprimer() {
        if (selectedBoncommande == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Veuillez choisir un boncommande", "Selectionnez une ligne !"));
        }
        try {
            dao.delete(selectedBoncommande.getNumbc());
            //dao1.delete(selectedBoncommande.getId().getIdboncommande());
            boncommandes = dao.getAllBonCommandes();
            boncommandes = this.affiche_type_projet(boncommandes);
            mediumBoncommandesModel = new BoncommandeDataModel(boncommandes);
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Impossible de supprimer le bon de commande", "Bon déja utilisé !"));
        }

    }

    public String ajouter() {
        //Si le login est dejà utilisé 

        for (Boncommande boncommande : boncommandes) {
            if (boncommande.getNumbc().equals(elt.getNumbc())) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Ce boncommande existe dejà !", "Veuillez changer le Code de boncommande."));
                return "";
            }
        }
        //elt.setIdboncommande(id_boncommande);
        //dao1.insert(new Element(id_boncommande));
        FournisseurHDao four_dao = new FournisseurHDao();
        ProjetHDao projet_dao = new ProjetHDao();
        elt.setFournisseur(four_dao.getFournisseur_nom(id_fournisseur));
        elt.setProjet(projet_dao.getProjet(id_projet));
        elt.setPrixht(0.0);

        dao.insert(elt);
        elt = new Boncommande();
        boncommandes = dao.getAllBonCommandes();
        boncommandes = this.affiche_type_projet(boncommandes);
        id_boncommande = new String();
        id_projet = "";
        id_fournisseur = "";
        mediumBoncommandesModel = new BoncommandeDataModel(boncommandes);
        return "succesAjout";

    }

    public void modif() {        
        id_projet = selectedBoncommande.getProjet().getIdprojet();
        FournisseurHDao four_dao = new FournisseurHDao();
        id_fournisseur = selectedBoncommande.getFournisseur().getIdfournisseur();
        id_fournisseur = four_dao.getFournisseur(id_fournisseur).getNom();
        FacesContext fc = FacesContext.getCurrentInstance();
        ConfigurableNavigationHandler nav = (ConfigurableNavigationHandler) fc.getApplication().getNavigationHandler();
        nav.performNavigation("modif");

    }

    public String enrModif() {        
        FournisseurHDao four_dao = new FournisseurHDao();
        ProjetHDao projet_dao = new ProjetHDao();
        selectedBoncommande.setProjet(projet_dao.getProjet(id_projet));
        selectedBoncommande.setFournisseur(four_dao.getFournisseur_nom(id_fournisseur));
        dao.update(selectedBoncommande);
        boncommandes = dao.getAllBonCommandes();
        boncommandes = this.affiche_type_projet(boncommandes);
        mediumBoncommandesModel = new BoncommandeDataModel(boncommandes);
        return "succesAjout";
    }

    public String enrDetails() {        
        Article article = article_dao.getArticle(id_article);
        if (article == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "N° article n'exist pas  !", "Veuillez changer le Code d'article."));
            //System.err.println("ggg");
            return "";
        } else {
            Integer t = new Integer(0);
            try {
                //  System.out.println(qnt_besoin+"hhh");
                t = new Integer(qnt_commande);
            } catch (Exception e) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Qnt doit être entier !", "Veuillez changer la Qnt."));
                //System.err.println("aaaaaaaaa");
                return "";
            }
            Double d = new Double(0);
            try {
                d = new Double(prix_unitaire);
            } catch (Exception e) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "le Prix doit être double  !", "Veuillez le prix."));                
                return "";

            }
            
            List<Detailsbcarticle> details_list_article = article_details_dao.getAllDetailsbcarticles();
            Detailsbcarticle details = new Detailsbcarticle(new DetailsbcarticleId(selectedBoncommande.getNumbc(), id_article), selectedBoncommande, article, d, t, new Integer(0));
            for (Detailsbcarticle des : details_list_article) {
                if (des.getId().equals(details.getId())) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Ce article existe dejà !", "Veuillez changer le Code de article."));
                    return "";
                }
            }

            article_details_dao.insert(details);
            selectedBoncommande.setPrixht(selectedBoncommande.getPrixht() + d * t);
            dao.update(selectedBoncommande);
            // Integer  = article_dao.getArticle(id_article);
            mediumBoncommandesModel_article = new BcarticleDataModel(article_details_dao.getDetailsbcarticles_id(selectedBoncommande.getNumbc()));
            id_article = "";
            qnt_commande = "";
            prix_unitaire = "";
            return "details_bc";

        }
    }

    public void supprimer_details() {        
        if (selectedBoncommande_article == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Veuillez choisir une article", "Selectionnez une ligne !"));
            
        }
        
        selectedBoncommande.setPrixht(selectedBoncommande.getPrixht() - (selectedBoncommande_article.getPrixunitaire() * selectedBoncommande_article.getQntcommande()));
        dao.update(selectedBoncommande);
        article_details_dao.delete(selectedBoncommande_article.getId());
        mediumBoncommandesModel_article = new BcarticleDataModel(article_details_dao.getDetailsbcarticles_id(selectedBoncommande.getNumbc()));

    }

    public void details() {
        if (selectedBoncommande == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Veuillez choisir un BC", "Selectionnez une ligne avec les cercles!"));

        } else {          
            id_projet = selectedBoncommande.getProjet().getIdprojet();
            FournisseurHDao four_dao = new FournisseurHDao();
            id_fournisseur = selectedBoncommande.getFournisseur().getIdfournisseur();
            id_fournisseur = four_dao.getFournisseur(id_fournisseur).getNom();

            mediumBoncommandesModel_article = new BcarticleDataModel(article_details_dao.getDetailsbcarticles_id(selectedBoncommande.getNumbc()));
            FacesContext fc = FacesContext.getCurrentInstance();
            ConfigurableNavigationHandler nav = (ConfigurableNavigationHandler) fc.getApplication().getNavigationHandler();
            nav.performNavigation("details_bc");

        }
    }

    public void etat_bc() throws ClassNotFoundException, SQLException, JRException, IOException {
    /*    if (selectedBoncommande == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Veuillez choisir un Bon de commande", "Selectionnez une ligne !"));
        }*/
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/lds_db", "postgres", "lds");


        java.io.InputStream in = getClass().getResourceAsStream("boncommande.jasper");
        Map paramettres = new HashMap();
        paramettres.put("num_bc", selectedBoncommande.getNumbc());
        paramettres.put("date_bc", selectedBoncommande.getDateboncommande());
        paramettres.put("contact", selectedBoncommande.getFournisseur().getContact());
        paramettres.put("fournisseur", "(" + selectedBoncommande.getFournisseur().getNom() + ")");
        if (selectedBoncommande.getUrgent()) {
            paramettres.put("urgent", "(Urgent)");
        } else {
            paramettres.put("urgent", "");
        }

        URL in3 = getClass().getResource("boncommande.jrxml");
        String url11 = in3.getPath();
        String url2[] = url11.split("boncommande.jrxml");

        paramettres.put("lien_image", url2[0] + "logo.png");
        JasperPrint editer = JasperFillManager.fillReport(in, paramettres, con);
        HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        httpServletResponse.addHeader("Content-disposition", "attachment; filename=demande_" + selectedBoncommande.getNumbc() + ".pdf");
        //ServletOutputStream servletOutputStream=httpServletResponse.getOutputStream();
        try {
            JasperExportManager.exportReportToPdfStream(editer, httpServletResponse.getOutputStream());
        } catch (Exception e) {
        }
    }
}
