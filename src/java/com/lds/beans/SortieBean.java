/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.beans;

import com.lds.persistance.ArticleHDao;
import com.lds.persistance.BesoinHDao;
import com.lds.persistance.BonSortieHDao;
import com.lds.persistance.DetailsBesoinArticleHDao1;
import com.lds.persistance.DetailsSortieArticleHDao;
import com.lds.persistance.PersonnelHDao;
import com.lds.persistance.ProjetHDao;
import com.lds.persistance.TacheHDao;
import com.lds.vo.Article;
import com.lds.vo.Besoin;
import com.lds.vo.Bonsortie;
import com.lds.vo.Detailsarticlbesoin;
import com.lds.vo.Detailssortiearticle;
import com.lds.vo.DetailssortiearticleId;
import com.lds.vo.Personnel;
import com.lds.vo.Projet;
import com.lds.vo.Tache;
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
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author ELKAOUMI
 */
@ManagedBean
@RequestScoped
public class SortieBean implements Serializable {

    private List<Bonsortie> filteredBonsorties;
    private Personnel pers;
    private List<Bonsortie> bonsorties;
    private List<Detailssortiearticle> detailsortiearticle;
    private Bonsortie selectedBonsortie;
    private Detailssortiearticle selecteddetailssortiearticle;
    private Bonsortie sortie;
    private BonSortieHDao dao;
    private DetailsSortieArticleHDao dao2;
    private BonsortieDataModel mediumBonsortiesModel;
    private details_sortie_article_DataModel mediumBonsortiesdetailsModel;
    private String id_pers;
    private String id_projet;
    private PersonnelHDao dao1 = new PersonnelHDao();
    private Personnel p;
    private ProjetHDao projet_dao;
    private String id_article;
    private String id_fourniture;
    private String qnt_sortie;
    private ArticleHDao dao_article;
    private String qnt_sortie2;
    private String id_tache;
    private TacheHDao tache_dao;
    private String type_projet;
    private Integer qnt_retour;
    private String id_article_retour;
    private Integer qnt_retour_f;
    private String id_article_retour_f;

    public SortieBean() {

        sortie = new Bonsortie();
        bonsorties = new ArrayList<Bonsortie>();
        //selectedBonsortie=new Bonsortie();
        //populateRandomCars(cars, 50);  
        dao = new BonSortieHDao();
        dao1 = new PersonnelHDao();
        projet_dao = new ProjetHDao();
        dao2 = new DetailsSortieArticleHDao();
        dao_article = new ArticleHDao();
        bonsorties = dao.getAllBonSorties();

        mediumBonsortiesModel = new BonsortieDataModel(bonsorties);
        id_pers = new String();
        id_projet = new String();
        id_article = "";
        qnt_sortie = "";
        tache_dao = new TacheHDao();
    }

    public String getId_article_retour_f() {
        return id_article_retour_f;
    }

    public void setId_article_retour_f(String id_article_retour_f) {
        this.id_article_retour_f = id_article_retour_f;
    }

    public Integer getQnt_retour_f() {
        return qnt_retour_f;
    }

    public void setQnt_retour_f(Integer qnt_retour_f) {
        this.qnt_retour_f = qnt_retour_f;
    }

    public List<Detailssortiearticle> getDetailsortiearticle() {
        return detailsortiearticle;
    }

    public void setDetailsortiearticle(List<Detailssortiearticle> detailsortiearticle) {
        this.detailsortiearticle = detailsortiearticle;
    }

    public String getId_article_retour() {
        return id_article_retour;
    }

    public void setId_article_retour(String id_article_retour) {
        this.id_article_retour = id_article_retour;
    }

    public List<String> getallarticle() {
        //selectedBonsortie
        List<String> articles = new ArrayList<String>();
        DetailsSortieArticleHDao details_article_bc = new DetailsSortieArticleHDao();
        List<Detailssortiearticle> list_Detailsbcarticle = new ArrayList<Detailssortiearticle>();
        list_Detailsbcarticle = details_article_bc.getAllDetailssortiearticles_id(selectedBonsortie.getIdsortie());
        Iterator li = list_Detailsbcarticle.iterator();
        while (li.hasNext()) {
            //Recupération objet
            Detailssortiearticle pu = (Detailssortiearticle) li.next();
            articles.add(pu.getArticle().getIdarticle());
        }
        return articles;
    }

    public List<String> getallarticle_four() {
        List<Article> articl = dao_article.getAllArticle_four();
        List<String> articles = new ArrayList<String>();
        Iterator li = articl.iterator();
        while (li.hasNext()) {
            //Recupération objet
            Article pu = (Article) li.next();
            articles.add(pu.getIdarticle());
        }
        return articles;

    }

    public Integer getQnt_retour() {
        return qnt_retour;
    }

    public void setQnt_retour(Integer qnt_retour) {
        this.qnt_retour = qnt_retour;
    }

    public String getType_projet() {
        return type_projet;
    }

    public void setType_projet(String type_projet) {
        this.type_projet = type_projet;
    }

    public List<String> alltache() {

        List<String> all = new ArrayList<String>();
        tache_dao = new TacheHDao();
        ArrayList<Tache> l = (ArrayList<Tache>) tache_dao.getAllTache_id(id_projet);
        Iterator li = l.iterator();
        while (li.hasNext()) {
            //Recupération objet
            Tache pu = (Tache) li.next();
            all.add(pu.getDesignationtache());

        }
        return all;
    }

    public String getId_tache() {
        return id_tache;
    }

    public void setId_tache(String id_tache) {
        this.id_tache = id_tache;
    }

    public String getQnt_sortie2() {
        return qnt_sortie2;
    }

    public void setQnt_sortie2(String qnt_sortie2) {
        this.qnt_sortie2 = qnt_sortie2;
    }

    public String getId_article() {

        return id_article;
    }

    public void setId_article(String id_article) {

        this.id_article = id_article;
    }

    public String getId_fourniture() {
        return id_fourniture;
    }

    public void setId_fourniture(String id_fourniture) {
        this.id_fourniture = id_fourniture;
    }

    public Detailssortiearticle getSelecteddetailssortiearticle() {
        return selecteddetailssortiearticle;
    }

    public void setSelecteddetailssortiearticle(Detailssortiearticle selecteddetailssortiearticle) {
        this.selecteddetailssortiearticle = selecteddetailssortiearticle;
    }

    public String getQnt_sortie() {

        return qnt_sortie;
    }

    public void setQnt_sortie(String qnt_sortie) {

        this.qnt_sortie = qnt_sortie;
    }

    public String getId_projet() {
        return id_projet;
    }

    public void setId_projet(String id_projet) {
        this.id_projet = id_projet;
    }

    public String getId_pers() {
        return id_pers;
    }

    public List<String> allpersonnel() {
        List<String> all = new ArrayList<String>();
        dao1 = new PersonnelHDao();
        ArrayList<Personnel> l = (ArrayList<Personnel>) dao1.getAllPersonnels();
        Iterator li = l.iterator();
        while (li.hasNext()) {
            //Recupération objet
            Personnel pu = (Personnel) li.next();
            all.add(pu.getNom());
        }

        return all;
    }

    public List<String> allprojet() {
        List<String> all = new ArrayList<String>();
        projet_dao = new ProjetHDao();
        ArrayList<Projet> l = (ArrayList<Projet>) projet_dao.getAllProjet();
        Iterator li = l.iterator();
        while (li.hasNext()) {
            //Recupération objet
            Projet pu = (Projet) li.next();
            all.add(pu.getIdprojet());
        }

        return all;
    }

    public void setId_pers(String id_pers) {
        this.id_pers = id_pers;
    }

    public Personnel getPers() {
        return pers;
    }

    public void setPers(Personnel pers) {
        this.pers = pers;
    }

    public BonsortieDataModel getMediumBonsortiesModel() {
        return mediumBonsortiesModel;
    }

    public void setMediumBonsortiesModel(BonsortieDataModel mediumBonsortiesModel) {
        this.mediumBonsortiesModel = mediumBonsortiesModel;
    }

    public void setFilteredBonsorties(List<Bonsortie> filteredBonsorties) {
        this.filteredBonsorties = filteredBonsorties;
    }

    public void setid_pers(String id_pers) {
        this.id_pers = id_pers;
    }

    public void setSelectedBonsortie(Bonsortie selectedBonsortie) {
        this.selectedBonsortie = selectedBonsortie;
    }

    public void setSortie(Bonsortie sortie) {
        this.sortie = sortie;
    }

    public List<Bonsortie> getFilteredBonsorties() {
        return filteredBonsorties;
    }

    public String getid_pers() {
        return id_pers;
    }

    public Bonsortie getSelectedBonsortie() {
        return selectedBonsortie;
    }

    public Bonsortie getSortie() {
        return sortie;
    }

    /**
     * Creates a new instance of SortieBean
     */
    public void supprimer() {
        if (selectedBonsortie == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Veuillez choisir un bonsortie", "Selectionnez une ligne !"));
        }

        //dao.delete(selectedBonsortie.getIdsortie());
        try {
            dao.delete(selectedBonsortie.getIdsortie());
            bonsorties = dao.getAllBonSorties();
            mediumBonsortiesModel = new BonsortieDataModel(bonsorties);
        } catch (Exception e) {

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Impossible de supprimer un bon sortie", "le Bon contient des articles,veuillez supprimer les détails avant de supprimer le bon !"));
        }

    }

    public void ajouter() {
        //Si le login est dejà utilisé 

        for (Bonsortie bonsortie : bonsorties) {
            if (bonsortie.getIdsortie().equals(sortie.getIdsortie())) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Ce bonsortie existe dejà !", "Veuillez changer le Code de bonsortie."));

            }
        }
        sortie.setPersonnel(dao1.getNomPersonnel(id_pers));
        sortie.setTache(tache_dao.getTache_nom(id_tache, id_projet));
        //sortie.setProjet(projet_dao.getProjet(id_projet));
        dao.insert(sortie);

        List<Article> list_a = this.getallarticle_article();

        int i = 0;
        DetailsSortieArticleHDao detail_sortiearticle = new DetailsSortieArticleHDao();
        //System.out.println("artiiiiiiiiiiiii:+" + list_a.size());
        while (i < list_a.size()) {
            Detailssortiearticle du = new Detailssortiearticle(new DetailssortiearticleId(sortie.getIdsortie(), list_a.get(i).getIdarticle()), sortie, list_a.get(i), 0, 0);
            detail_sortiearticle.insert(du);
            i++;
        }
        selectedBonsortie = sortie;
        sortie = new Bonsortie();
        id_projet = "";
        id_tache = "";
        id_pers = "";
        bonsorties = dao.getAllBonSorties();
        mediumBonsortiesModel = new BonsortieDataModel(bonsorties);
        this.details();


    }

    public List<Article> getallarticle_article() {
        //selectedBonsortie
        List<Article> articles = new ArrayList<Article>();
        DetailsBesoinArticleHDao1 details_article_bc = new DetailsBesoinArticleHDao1();
        List<Detailsarticlbesoin> list_Detailsbcarticle = new ArrayList<Detailsarticlbesoin>();
        Projet pro = sortie.getTache().getProjet();
        // System.out.println("Projettt" + pro.getIdprojet());
        BesoinHDao besoin = new BesoinHDao();
        List<Besoin> list_besoin = new ArrayList<Besoin>();
        List<Besoin> list_total = besoin.getAllBesoin_total();
        int j = 0;
        // System.out.println("besoinnnn" + list_total.size());
        while (j < list_total.size()) {

            if (pro.getIdprojet().equals(list_total.get(j).getTache().getProjet().getIdprojet())) {
                list_besoin.add(list_total.get(j));
            }

            j++;
        }
        // System.out.println("besoinnnnnnnntttttt" + list_besoin.size());
        int i = 0;
        while (i < list_besoin.size()) {
            list_Detailsbcarticle = details_article_bc.getDetailsarticlbesoins_id(((Besoin) list_besoin.get(i)).getIdbesoin());
            Iterator li = list_Detailsbcarticle.iterator();
            while (li.hasNext()) {
                //Recupération objet
                Detailsarticlbesoin pu = (Detailsarticlbesoin) li.next();
                // System.out.println("ggggg" + pu.getId().getIdarticle());
                articles.add(dao_article.getArticle(pu.getId().getIdarticle()));
            }
            i++;
        }
        Iterator li = articles.iterator();
        List<Article> allRef = new ArrayList<Article>();
        while (li.hasNext()) {
            Boolean Test = true;
            //recupération de la demande de prix
            Article dp = (Article) li.next();
            Iterator li1 = allRef.iterator();
            while (li1.hasNext() && Test) {
                //Recuperation de la demande enregistree
                Article dp1 = (Article) li1.next();
                if (dp.getIdarticle().equals(dp1.getIdarticle())) {
                    Test = false;
                }
            }
            if (Test == true) {
                allRef.add(dp);
                // System.out.println("Article"+dp.getIdarticle())
            }
        }
        return allRef;
    }

    public details_sortie_article_DataModel getMediumBonsortiesdetailsModel() {
        return mediumBonsortiesdetailsModel;
    }

    public void setMediumBonsortiesdetailsModel(details_sortie_article_DataModel mediumBonsortiesdetailsModel) {
        this.mediumBonsortiesdetailsModel = mediumBonsortiesdetailsModel;
    }

    public void modif() {
        p = selectedBonsortie.getPersonnel();
        id_pers = p.getIdpersonnel();
        p = dao1.getPersonnel(id_pers);
        id_pers = p.getNom();
        id_projet = selectedBonsortie.getTache().getProjet().getIdprojet();
        id_tache = selectedBonsortie.getTache().getDesignationtache();
        FacesContext fc = FacesContext.getCurrentInstance();
        ConfigurableNavigationHandler nav = (ConfigurableNavigationHandler) fc.getApplication().getNavigationHandler();
        nav.performNavigation("modif_sortie");
        //Bonsortie b = dao.getBonSortie(selectedBonsortie.getIdsortie());
        // System.out.println("gggg"+b.getPersonnel().getNom());


    }

    public String details() {
        if (selectedBonsortie == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Veuillez choisir un bonsortie", "Selectionnez une ligne !"));
            return "";
        } else {
            mediumBonsortiesdetailsModel = new details_sortie_article_DataModel(dao2.getAllDetailssortiearticles_id(selectedBonsortie.getIdsortie()));
            //dao2.getAllDetailssortiearticles_id(selectedBonsortie.getIdsortie())
            p = selectedBonsortie.getPersonnel();
            id_pers = p.getIdpersonnel();
            p = dao1.getPersonnel(id_pers);
            id_pers = p.getNom();
            id_projet = selectedBonsortie.getTache().getProjet().getIdprojet();
            if (selectedBonsortie.getTache().getProjet().getTypeprojet().equals("1")) {
                type_projet = "Affaire";
            } else {
                type_projet = "Intervention";
            }
            id_tache = selectedBonsortie.getTache().getDesignationtache();
            return "details_sortie";
        }
    }

    public String enrModif() {        
        p = dao1.getNomPersonnel(id_pers);
        Tache tache = tache_dao.getTache_nom(id_tache, id_projet);
        selectedBonsortie.setPersonnel(p);
        selectedBonsortie.setTache(tache);
        dao.update(selectedBonsortie);
        bonsorties = dao.getAllBonSorties();
        mediumBonsortiesModel = new BonsortieDataModel(bonsorties);
        return "succesAjoutArticle";
    }
   

    public String enrretour() {
        Article article = dao_article.getArticle(id_article_retour);
        Integer t = new Integer(0);
        try {
            t = new Integer(qnt_retour);
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "N° article n'exist pas  !", "Veuillez changer le Code d'article."));            
            return "";
        }
        Detailssortiearticle dd = dao2.getDetailssortiearticle(new DetailssortiearticleId(selectedBonsortie.getIdsortie(), article.getIdarticle()));
        if (qnt_retour > dd.getQntsortie()) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "N° article n'exist pas  !", "Veuillez changer le Code d'article."));            
            return "details_sortie";
        }
        dd.setQntretour(qnt_retour);
        dao2.update(dd);
        mediumBonsortiesdetailsModel = new details_sortie_article_DataModel(dao2.getAllDetailssortiearticles_id(selectedBonsortie.getIdsortie()));
        return "details_sortie";
    }

    public String enrDetails() {

        Article article = dao_article.getArticle(id_article);
        if (article == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "N° article n'exist pas  !", "Veuillez changer le Code d'article."));            
            return "";
        }
        Integer t = new Integer(0);
        try {
            t = new Integer(qnt_sortie);
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "N° article n'exist pas  !", "Veuillez changer le Code d'article."));
            //System.err.println("hhhhhhhh");
            return "";
        }
        Detailssortiearticle dd = dao2.getDetailssortiearticle(new DetailssortiearticleId(selectedBonsortie.getIdsortie(), article.getIdarticle()));
        if (dd == null) {
            Integer qnt = dao_article.getArticle(id_article).getQntarticle();
            if ((qnt - t) < 0) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "N° article n'exist pas  !", "Veuillez changer le Code d'article."));
                //System.err.println("aaaaaaaaa");
                return "";
            } else {
                Detailssortiearticle details = new Detailssortiearticle(new DetailssortiearticleId(selectedBonsortie.getIdsortie(), article.getIdarticle()), selectedBonsortie, article, t, 0);
                dao2.insert(details);
                Article a = dao_article.getArticle(id_article);
                a.setQntarticle(qnt - t);
                dao_article.update(a);
                mediumBonsortiesdetailsModel = new details_sortie_article_DataModel(dao2.getAllDetailssortiearticles_id(selectedBonsortie.getIdsortie()));

                return "details_sortie";
            }
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "N° article n'existe pas  !", "Veuillez changer le Code d'article."));            
            return "";

        }
    }

    public void supprimer_details() {
        if (selecteddetailssortiearticle == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Veuillez choisir une article", "Selectionnez une ligne !"));
        }
        System.out.println(selecteddetailssortiearticle.getId().getIdarticle());
        //dao.delete(selectedBonsortie.getIdsortie());
        dao2.delete(selecteddetailssortiearticle.getId());
        Article a = dao_article.getArticle(selecteddetailssortiearticle.getArticle().getIdarticle());
        a.setQntarticle(a.getQntarticle() + selecteddetailssortiearticle.getQntsortie());
        dao_article.update(a);
        mediumBonsortiesdetailsModel = new details_sortie_article_DataModel(dao2.getAllDetailssortiearticles_id(selectedBonsortie.getIdsortie()));

    }

    public void etat_sortie() throws ClassNotFoundException, SQLException, JRException, IOException {
        /*
         * if (selectedFournisseur == null) {
         * FacesContext.getCurrentInstance().addMessage(null, new
         * FacesMessage("Veuillez choisir un fournisseur", "Selectionnez une
         * ligne !")); }
         */
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/lds_db", "postgres", "lds");


        java.io.InputStream in = getClass().getResourceAsStream("sortie.jasper");
        Map paramettres = new HashMap();
        paramettres.put("id_sortie", selectedBonsortie.getIdsortie());
        paramettres.put("id_projet", selectedBonsortie.getTache().getProjet().getIdprojet());
        if (selectedBonsortie.getTache().getProjet().getTypeprojet().equals("1")) {
            paramettres.put("type_projet", "Affaire");
        } else {
            paramettres.put("type_projet", "Intervention");
        }
        try {
            paramettres.put("nom_tache", selectedBonsortie.getTache().getDesignationtache());

        } catch (Exception e) {
            paramettres.put("nom_tache", "");
        }
        try {
            paramettres.put("desc_sortie", selectedBonsortie.getDescsortie());
        } catch (Exception e) {
            paramettres.put("desc_sortie", "");
        }
        try {
            paramettres.put("date_sortie", selectedBonsortie.getDatesortie().toString());
        } catch (Exception e) {
            paramettres.put("date_sortie", "");
        }
        try {
            paramettres.put("nom_pers", selectedBonsortie.getPersonnel().getNom());
        } catch (Exception e) {
            paramettres.put("nom_pers", "");
        }
        URL in3 = getClass().getResource("sortie.jrxml");
        String url11 = in3.getPath();
        String url2[] = url11.split("sortie.jrxml");

        paramettres.put("lien_image", url2[0] + "logo.png");
        JasperPrint editer = JasperFillManager.fillReport(in, paramettres, con);
        HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        httpServletResponse.addHeader("Content-disposition", "attachment; filename=sortie_" + selectedBonsortie.getIdsortie() + ".pdf");
        //ServletOutputStream servletOutputStream=httpServletResponse.getOutputStream();
        try {
            JasperExportManager.exportReportToPdfStream(editer, httpServletResponse.getOutputStream());
        } catch (Exception e) {
        }
    }

    public void onEdit(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Article Edited", ((Detailssortiearticle) event.getObject()).getArticle().getDescarticle());
        selecteddetailssortiearticle = ((Detailssortiearticle) event.getObject());
        DetailsSortieArticleHDao detailssortie = new DetailsSortieArticleHDao();
        Integer qnt_sortie_ancien = detailssortie.getDetailssortiearticle(selecteddetailssortiearticle.getId()).getQntsortie();
        Integer qntretour_ancien = detailssortie.getDetailssortiearticle(selecteddetailssortiearticle.getId()).getQntretour();
        Integer resultat = selecteddetailssortiearticle.getQntsortie() - qnt_sortie_ancien;
        Integer resultat_retour = selecteddetailssortiearticle.getQntretour() - qntretour_ancien;
        Integer qnt = selecteddetailssortiearticle.getArticle().getQntarticle();
        boolean etat = true;
        Article arc = selecteddetailssortiearticle.getArticle();
        if (resultat > 0) {
            if ((qnt - resultat) < 0) 
                etat = false;

             else 
                arc.setQntarticle(qnt - resultat);
            
        } else {
            if (resultat < 0) 
                arc.setQntarticle(qnt - resultat);            
            //retour
            if (resultat_retour > 0) 
                arc.setQntarticle(qnt + resultat_retour);
            else {
                if (resultat_retour < 0) {
                    if ((qnt + resultat_retour) < 0) 
                        etat = false;
                     else 
                        arc.setQntarticle(qnt + resultat_retour);
                    
                }
                if (etat) {
                    dao2.update(selecteddetailssortiearticle);                    
                    dao_article.update(arc);
                    FacesContext.getCurrentInstance().addMessage(null, msg);

                } else {
                    selecteddetailssortiearticle.setQntretour(qntretour_ancien);
                    selecteddetailssortiearticle.setQntsortie(qnt_sortie_ancien);
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Qnt  de stock est Insuffisante ", "Veuillez changer Qnt."));
                }
            }
        }
    }
}
