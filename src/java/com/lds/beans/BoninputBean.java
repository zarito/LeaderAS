/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.beans;

import com.lds.persistance.ArticleHDao;
import com.lds.persistance.BonCommandeHDao;
import com.lds.persistance.BonReceptionHDao;
import com.lds.persistance.DetailsBcArticleHDao;
import com.lds.persistance.DetailsInputArticleHDao;
import com.lds.vo.Article;
import com.lds.vo.Boncommande;
import com.lds.vo.Bonreception;
import com.lds.vo.Detailsbcarticle;
import com.lds.vo.DetailsbcarticleId;
import com.lds.vo.Detailsbrarticle;
import com.lds.vo.DetailsbrarticleId;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.event.RowEditEvent;
import org.primefaces.model.LazyDataModel;

public class BoninputBean implements Serializable {

    public BoninputBean() {
        elt = new Bonreception();
        bonreceptions = new ArrayList<Bonreception>();
        //selectedBonreception=new Bonreception();
        //populateRandomCars(cars, 50);  
        dao = new BonReceptionHDao();
        bonreceptions = dao.getAllBonReceptions();
        mediumBonreceptionsModel = new BoninputDataModel(bonreceptions);
        detailsInputArticleHDao = new DetailsInputArticleHDao();
        article_dao = new ArticleHDao();
    }
    private List<Bonreception> filteredBonreceptions;
    private List<Bonreception> bonreceptions;
    private Bonreception selectedBonreception;
    private Bonreception[] selectedBonreceptions;
    private Bonreception elt;
    private BonReceptionHDao dao;
    private BoninputDataModel mediumBonreceptionsModel;
    private String id_bonreception;
    private String id_commande;
    private details_input_sortie_article_DataModel mediumInputdetailsModel;
    private Detailsbrarticle selecteddetailsinputarticle;
    private List<Detailsbrarticle> detailsbrarticles;
    private String qnt_livre;
    private String id_article;
    private DetailsInputArticleHDao detailsInputArticleHDao;
    private String id_fourniture;
    private ArticleHDao article_dao;
    private String qnt_livre2;

    public String getQnt_livre2() {
        return qnt_livre2;
    }

    public void setQnt_livre2(String qnt_livre2) {
        this.qnt_livre2 = qnt_livre2;
    }

    public String getId_fourniture() {
        return id_fourniture;
    }

    public void setId_fourniture(String id_fourniture) {
        this.id_fourniture = id_fourniture;
    }

    public String getId_article() {
        return id_article;
    }

    public void setId_article(String id_article) {
        this.id_article = id_article;
    }

    public String getQnt_livre() {
        return qnt_livre;
    }

    public void setQnt_livre(String qnt_livre) {
        this.qnt_livre = qnt_livre;
    }

    public Detailsbrarticle getSelecteddetailsinputarticle() {
        return selecteddetailsinputarticle;
    }

    public void setSelecteddetailsinputarticle(Detailsbrarticle selecteddetailsinputarticle) {
        this.selecteddetailsinputarticle = selecteddetailsinputarticle;
    }

    public details_input_sortie_article_DataModel getMediumInputdetailsModel() {
        return mediumInputdetailsModel;
    }

    public void setMediumInputdetailsModel(details_input_sortie_article_DataModel mediumInputdetailsModel) {
        this.mediumInputdetailsModel = mediumInputdetailsModel;
    }

    public String getId_commande() {
        return id_commande;
    }

    public void setId_commande(String id_commande) {
        this.id_commande = id_commande;
    }

    public void setId_bonreception(String id_bonreception) {
        this.id_bonreception = id_bonreception;
    }

    public String getId_bonreception() {
        return id_bonreception;
    }

    public Bonreception getSelectedBonreception() {
        return selectedBonreception;
    }

    public void setSelectedBonreception(Bonreception selectedBonreception) {
        this.selectedBonreception = selectedBonreception;
    }

    public LazyDataModel<Bonreception> getMediumBonreceptionsModel() {
        return mediumBonreceptionsModel;
    }

    public Bonreception getElt() {
        return elt;
    }

    public void setElt(Bonreception elt) {
        this.elt = elt;
    }

    public List<Bonreception> getFilteredBonreceptions() {
        return filteredBonreceptions;
    }

    public void setFilteredBonreceptions(List<Bonreception> filteredBonreceptions) {
        this.filteredBonreceptions = filteredBonreceptions;
    }

    public List<Bonreception> getBonreceptions() {
        return bonreceptions;
    }

    public void supprimer() {
        if (selectedBonreception == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Veuillez choisir un bonreception", "Selectionnez une ligne !"));
        }
        try {
            dao.delete(selectedBonreception.getNumreception());
            //dao1.delete(selectedBonreception.getId().getIdbonreception());
            bonreceptions = dao.getAllBonReceptions();
            mediumBonreceptionsModel = new BoninputDataModel(bonreceptions);
        } catch (Exception e) {

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Impossible de supprimer un bon livraision", "le Bon contient des articles,veuillez supprimer les détails avant de supprimer le bon !"));
        }

    }

    public void ajouter() {
        //Si le login est dejà utilisé 

        for (Bonreception bonreception : bonreceptions) {
            if (bonreception.getNumreception().equals(elt.getNumreception())) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Ce bonreception existe dejà !", "Veuillez changer le Code de bonreception."));

            }
        }
        BonCommandeHDao comm = new BonCommandeHDao();
        List<Boncommande> commandes = comm.getAllBonCommandes();
        int k = 0;
        for (Boncommande boncommande : commandes) {
            if (boncommande.getNumbc().equals(id_commande)) {
                k = 1;
            }
        }
        if (k == 0) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "N° Bon de commande n'exist pas !", "Veuillez changer le Code de Bon Commande."));

        }
        elt.setBoncommande(comm.getBonCommande(id_commande));
        dao.insert(elt);

        List<Article> articles = this.getallarticle_bc();
        int i = 0;
        DetailsInputArticleHDao detail_inputarticle = new DetailsInputArticleHDao();
        // DetailsBcArticleHDao comm1=new DetailsBcArticleHDao();
        //System.out.println("artiiiiiiiiiiiii:+" + list_a.size());
        while (i < articles.size()) {
            Detailsbrarticle du = new Detailsbrarticle(new DetailsbrarticleId(articles.get(i).getIdarticle(), elt.getNumreception()), elt, articles.get(i), 0);
            detail_inputarticle.insert(du);
            i++;
        }
        selectedBonreception = elt;
        elt = new Bonreception();
        bonreceptions = dao.getAllBonReceptions();
        id_commande = new String();
        mediumBonreceptionsModel = new BoninputDataModel(bonreceptions);
        this.details();

    }

    public List<Article> getallarticle_bc() {
        DetailsBcArticleHDao detailsBcArticleHDao = new DetailsBcArticleHDao();
        List<Detailsbcarticle> list = detailsBcArticleHDao.getDetailsbcarticles_id(elt.getBoncommande().getNumbc());
        List<Article> articles = new ArrayList<Article>();
        int i = 0;
        while (i < list.size()) {
            articles.add(list.get(i).getArticle());
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
        List<Article> all = new ArrayList<Article>();
        ArrayList<Article> l = new ArrayList<Article>(allRef);
        li = l.iterator();
        DetailsBcArticleHDao dbc = new DetailsBcArticleHDao();
        while (li.hasNext()) {
            //Recupération objet
            Article pu = (Article) li.next();
            Integer total = dbc.getDetailsbcarticle(new DetailsbcarticleId(elt.getBoncommande().getNumbc(), pu.getIdarticle())).getQntlivre();
            Integer command = dbc.getDetailsbcarticle(new DetailsbcarticleId(elt.getBoncommande().getNumbc(), pu.getIdarticle())).getQntcommande();
            if (total < command) {
                all.add(pu);
            }
        }
        return all;
    }

    public void modif() {        
            id_commande = selectedBonreception.getBoncommande().getNumbc();
            FacesContext fc = FacesContext.getCurrentInstance();
            ConfigurableNavigationHandler nav = (ConfigurableNavigationHandler) fc.getApplication().getNavigationHandler();
            nav.performNavigation("modif_input");            
        
    }

    public String enrModif() {
        //selectedBonreception.setTypeuser(new Typeuser(typeUser));
        BonCommandeHDao comm = new BonCommandeHDao();
        List<Boncommande> commandes = comm.getAllBonCommandes();
        int k = 0;
        for (Boncommande boncommande : commandes) {
            if (boncommande.getNumbc().equals(id_commande)) {
                k = 1;
            }
        }
        if (k == 0) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "N° Bon de commande n'exist pas !", "Veuillez changer le Code de Bon Commande."));
            return "";
        }
        selectedBonreception.setBoncommande(comm.getBonCommande(id_commande));
        dao.update(selectedBonreception);
        bonreceptions = dao.getAllBonReceptions();
        mediumBonreceptionsModel = new BoninputDataModel(bonreceptions);
        id_commande = new String();
        return "succesAjoutArticle";
    }

    public String details() {
        if (selectedBonreception == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Veuillez choisir un Bon livraison", "Selectionnez une ligne !"));
            return "";
        } else {
            detailsbrarticles = detailsInputArticleHDao.getAllDetailsbrarticles_id(selectedBonreception.getNumreception());

            List<Detailsbrarticle> all = new ArrayList<Detailsbrarticle>();
            ArrayList<Detailsbrarticle> l = new ArrayList<Detailsbrarticle>(detailsbrarticles);
            Iterator li = l.iterator();
            DetailsBcArticleHDao dbc = new DetailsBcArticleHDao();
            while (li.hasNext()) {
                //Recupération objet
                Detailsbrarticle pu = (Detailsbrarticle) li.next();
                if (dbc.getDetailsbcarticle(new DetailsbcarticleId(pu.getBonreception().getBoncommande().getNumbc(), pu.getArticle().getIdarticle())) == null) {
                    System.out.println("LLLLLLL+" + pu.getArticle().getIdarticle());
                }
                pu.setTotal_qntlivre(dbc.getDetailsbcarticle(new DetailsbcarticleId(pu.getBonreception().getBoncommande().getNumbc(), pu.getArticle().getIdarticle())).getQntlivre());
                pu.setQnt_commander(dbc.getDetailsbcarticle(new DetailsbcarticleId(pu.getBonreception().getBoncommande().getNumbc(), pu.getArticle().getIdarticle())).getQntcommande());
                all.add(pu);

            }
            mediumInputdetailsModel = new details_input_sortie_article_DataModel(all);
            id_commande = selectedBonreception.getBoncommande().getNumbc();
           return "details_input";

        }
    }

    public List<Detailsbrarticle> actualise_article(List<Detailsbrarticle> details_a) {
        details_a = detailsInputArticleHDao.getAllDetailsbrarticles_id(selectedBonreception.getNumreception());

        List<Detailsbrarticle> all = new ArrayList<Detailsbrarticle>();
        ArrayList<Detailsbrarticle> l = new ArrayList<Detailsbrarticle>(details_a);
        Iterator li = l.iterator();
        DetailsBcArticleHDao dbc = new DetailsBcArticleHDao();
        while (li.hasNext()) {
            //Recupération objet
            Detailsbrarticle pu = (Detailsbrarticle) li.next();
            pu.setTotal_qntlivre(dbc.getDetailsbcarticle(new DetailsbcarticleId(pu.getBonreception().getBoncommande().getNumbc(), pu.getArticle().getIdarticle())).getQntlivre());
            pu.setQnt_commander(dbc.getDetailsbcarticle(new DetailsbcarticleId(pu.getBonreception().getBoncommande().getNumbc(), pu.getArticle().getIdarticle())).getQntcommande());
            all.add(pu);

        }
        return all;
        //mediumInputdetailsModel = new details_input_sortie_article_DataModel(all);

    }

    public List<String> getallarticle() {
        List<String> articles = new ArrayList<String>();
        DetailsBcArticleHDao details_article_bc = new DetailsBcArticleHDao();
        List<Detailsbcarticle> list_Detailsbcarticle = new ArrayList<Detailsbcarticle>();
        list_Detailsbcarticle = details_article_bc.getDetailsbcarticles_id(selectedBonreception.getBoncommande().getNumbc());
        Iterator li = list_Detailsbcarticle.iterator();
        while (li.hasNext()) {
            //Recupération objet
            Detailsbcarticle pu = (Detailsbcarticle) li.next();
            articles.add(pu.getArticle().getIdarticle());
        }
        return articles;
    }

    public String enrDetails() {
        System.out.println("wakkkkkkkwakkkkkkk");
        Article article = article_dao.getArticle(id_article);
        if (article == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "N° article n'exist pas  !", "Veuillez changer le Code d'article."));
            //System.err.println("ggg");
            return "";
        } else {
            Integer t = new Integer(0);
            try {
                t = new Integer(qnt_livre);
            } catch (Exception e) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "N° article n'exist pas  !", "Veuillez changer le Code d'article."));
                //System.err.println("aaaaaaaaa");
                return "";
            }
            DetailsBcArticleHDao comm = new DetailsBcArticleHDao();
            Detailsbcarticle dca = comm.getDetailsbcarticle(new DetailsbcarticleId(selectedBonreception.getBoncommande().getNumbc(), id_article));
            Integer qnt_commande = dca.getQntcommande();
            qnt_commande = qnt_commande - dca.getQntlivre();
            if (qnt_commande <= 0) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "qnt_commande<=0  !", "Veuillez changer le Code d'article."));
                //System.err.println("LLLLLLLLLLLLL");
                return "";
            } else {
                if (qnt_commande < t) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Quantité demandé est inférieur que Quantité commandé  !", "Veuillez changer le Quantité d'article."));
                    //System.err.println("MMMMMMMMMMMMMMMMM");
                    return "";
                } else {

                    Detailsbrarticle dd = detailsInputArticleHDao.getDetailsbrarticle(new DetailsbrarticleId(id_article, selectedBonreception.getNumreception()));
                    if (dd == null) {
                        Article a = article_dao.getArticle(id_article);
                        DetailsBcArticleHDao details_article_bc = new DetailsBcArticleHDao();
                        Detailsbcarticle d_bc = details_article_bc.getDetailsbcarticle(new DetailsbcarticleId(selectedBonreception.getBoncommande().getNumbc(), id_article));

                        Detailsbrarticle details = new Detailsbrarticle(new DetailsbrarticleId(id_article, selectedBonreception.getNumreception()), selectedBonreception, a, t);
                        detailsInputArticleHDao.insert(details);
                        // Integer  = article_dao.getArticle(id_article);
                        a.setQntarticle(a.getQntarticle() + t);
                        article_dao.update(a);
                        d_bc.setQntlivre(d_bc.getQntlivre() + t);
                        details_article_bc.update(d_bc);

                        mediumInputdetailsModel = new details_input_sortie_article_DataModel(this.actualise_article(detailsInputArticleHDao.getAllDetailsbrarticles_id(selectedBonreception.getNumreception())));

                        return "details_input";

                    } else {
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "N° article Exist déja  !", "Veuillez changer le Code d'article."));
                        //System.err.println("TTTTTTTTTTTTT");
                        return "";

                    }
                }
            }
        }
    }

    public void supprimer_details() {
        System.out.println("mmmmmmmmmmm");
        if (selecteddetailsinputarticle == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Veuillez choisir une article", "Selectionnez une ligne !"));
            System.out.println("gggggggg");
        }
        //System.out.println(selecteddetailssortiearticle.getId().getIdarticle());
        //dao.delete(selectedBonsortie.getIdsortie());
        detailsInputArticleHDao.delete(selecteddetailsinputarticle.getId());
        Article a = article_dao.getArticle(selecteddetailsinputarticle.getArticle().getIdarticle());
        a.setQntarticle(a.getQntarticle() - selecteddetailsinputarticle.getQntlivre());
        article_dao.update(a);
        DetailsBcArticleHDao details_article_bc = new DetailsBcArticleHDao();
        Detailsbcarticle d_bc = details_article_bc.getDetailsbcarticle(new DetailsbcarticleId(selectedBonreception.getBoncommande().getNumbc(), selecteddetailsinputarticle.getArticle().getIdarticle()));
        d_bc.setQntlivre(d_bc.getQntlivre() - selecteddetailsinputarticle.getQntlivre());
        details_article_bc.update(d_bc);
        mediumInputdetailsModel = new details_input_sortie_article_DataModel(this.actualise_article(detailsInputArticleHDao.getAllDetailsbrarticles_id(selectedBonreception.getNumreception())));

    }

    public void onEdit(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Article Edited", ((Detailsbrarticle) event.getObject()).getArticle().getDescarticle());
        selecteddetailsinputarticle = ((Detailsbrarticle) event.getObject());
        DetailsInputArticleHDao detailssortie = new DetailsInputArticleHDao();
        Integer qnt_sortie_ancien = detailssortie.getDetailsbrarticle(selecteddetailsinputarticle.getId()).getQntlivre();
        // Integer qntretour_ancien = detailssortie.getDetailssortiearticle(selecteddetailssortiearticle.getId()).getQntretour();
        Integer resultat = selecteddetailsinputarticle.getQntlivre() - qnt_sortie_ancien;
        //Integer resultat_retour = selecteddetailssortiearticle.getQntretour() - qntretour_ancien;
        Integer qnt = selecteddetailsinputarticle.getArticle().getQntarticle();
        boolean etat = true;
        Article arc = selecteddetailsinputarticle.getArticle();
        DetailsBcArticleHDao comm = new DetailsBcArticleHDao();
        Detailsbcarticle dca = comm.getDetailsbcarticle(new DetailsbcarticleId(selectedBonreception.getBoncommande().getNumbc(), arc.getIdarticle()));
        if (resultat < 0) {
            if ((qnt + resultat) < 0) {
                etat = false;
            } else {
                dca.setQntlivre(dca.getQntlivre() + resultat);
                selecteddetailsinputarticle.setTotal_qntlivre(selecteddetailsinputarticle.getTotal_qntlivre() + resultat);
                arc.setQntarticle(qnt + resultat);
            }
        } else {
            Integer qnt_commande = selecteddetailsinputarticle.getQnt_commander();
            Integer diff = qnt_commande - (selecteddetailsinputarticle.getTotal_qntlivre() + resultat);
            if (diff < 0) {
                etat = false;
            } else {
                selecteddetailsinputarticle.setTotal_qntlivre(selecteddetailsinputarticle.getTotal_qntlivre() + resultat);

                dca.setQntlivre(dca.getQntlivre() + resultat);
                arc.setQntarticle(qnt + resultat);
            }
        }

        if (etat) {
            detailsInputArticleHDao.update(selecteddetailsinputarticle);
            article_dao.update(arc);
            comm.update(dca);
            FacesContext.getCurrentInstance().addMessage(null, msg);

        } else {
            selecteddetailsinputarticle.setQntlivre(qnt_sortie_ancien);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Qnt  de stock est Insuffisante ", "Veuillez changer Qnt."));
        }
    }
}