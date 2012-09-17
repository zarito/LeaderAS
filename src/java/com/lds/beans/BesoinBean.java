package com.lds.beans;

import com.lds.persistance.*;
import com.lds.vo.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.model.LazyDataModel;

public class BesoinBean implements Serializable {

    private BesoinHDao dao;
    private Besoin besoin;
    private List<Besoin> besoins;
    private List<Besoin> filtredvesoins;
    private List<Besoin> besoins_v;
    private Besoin selectedBesoin;
    private LazyDataModel<Besoin> mediumBesoinsModel;
    private LazyDataModel<Besoin> mediumBesoinsModel_v;
    private String id_projet;
    private BesoinarticleDataModel mediumbesoindetailsModel;
    private DetailsBesoinArticleHDao1 details_article_dao;
    private Detailsarticlbesoin selecteddetailsbesoinarticle;
    private String id_article;
    private String qnt_besoin;
    private String id_fourniture;
    private ArticleHDao article_dao;
    private String qnt_besoin2;
    private String id_tache;
    private String id_besoin;
    private String choix_projet;
    private String choix_trie;
    private LazyDataModel<Detailsarticlbesoin> mediumarticle;
    private LazyDataModel<Projet> mediumprojet;
    private Projet selectprojet;
    private Projet selectintervention;

    public BesoinBean() {

        besoin = new Besoin();
        besoins = new ArrayList<Besoin>();
        //selectedBesoin=new Besoin();
        //populateRandomCars(cars, 50);  
        dao = new BesoinHDao();
        besoins = dao.getAllBesoin();
        ArrayList<Besoin> all = new ArrayList<Besoin>();
        Iterator li = besoins.iterator();
        while (li.hasNext()) {
            //Recupération objet
            Besoin pu = (Besoin) li.next();
            if (pu.getTache().getProjet().getTypeprojet().equals("1")) {
                pu.setType("Projet");
            } else {
                pu.setType("Intervention");
            }
            all.add(pu);
        }
        besoins = all;
        all = new ArrayList<Besoin>();
        besoins_v = dao.getAllBesoin_v();
        li = besoins_v.iterator();
        while (li.hasNext()) {
            //Recupération objet
            Besoin pu = (Besoin) li.next();
            if (pu.getTache().getProjet().getTypeprojet().equals("1")) {
                pu.setType("Projet");
            } else {
                pu.setType("Intervention");
            }
            all.add(pu);
        }
        besoins_v = all;
        mediumBesoinsModel = new BesoinDataModel(besoins);
        mediumBesoinsModel_v = new BesoinDataModel(besoins_v);
        article_dao = new ArticleHDao();
        details_article_dao = new DetailsBesoinArticleHDao1();
        qnt_besoin = "";
    }

    public List<Besoin> affiche_type_projet(List<Besoin> bes) {
        ArrayList<Besoin> all = new ArrayList<Besoin>();
        Iterator li = bes.iterator();
        while (li.hasNext()) {
            //Recupération objet
            Besoin pu = (Besoin) li.next();
            if (pu.getTache().getProjet().getTypeprojet().equals("1")) {
                pu.setType("Affaire");
            } else {
                pu.setType("Intervention");
            }
            all.add(pu);
        }
        return all;
    }

    public List<Besoin> getFiltredvesoins() {
        return filtredvesoins;
    }

    public void setFiltredvesoins(List<Besoin> filtredvesoins) {
        this.filtredvesoins = filtredvesoins;
    }

    public Projet getSelectintervention() {
        return selectintervention;
    }

    public void setSelectintervention(Projet selectintervention) {
        this.selectintervention = selectintervention;
    }

    public Projet getSelectprojet() {
        return selectprojet;
    }

    public void setSelectprojet(Projet selectprojet) {
        this.selectprojet = selectprojet;
    }

    public LazyDataModel<Projet> getMediumprojet() {
        return mediumprojet;
    }

    public void setMediumprojet(LazyDataModel<Projet> mediumprojet) {
        this.mediumprojet = mediumprojet;
    }

    public LazyDataModel<Detailsarticlbesoin> getMediumarticle() {
        return mediumarticle;
    }

    public void setMediumarticle(LazyDataModel<Detailsarticlbesoin> mediumarticle) {
        this.mediumarticle = mediumarticle;
    }

    public String getChoix_trie() {

        return choix_trie;
    }

    public void setChoix_trie(String choix_trie) {

        this.choix_trie = choix_trie;
    }

    public String getChoix_projet() {
        return choix_projet;
    }

    public void setChoix_projet(String choix_projet) {
        this.choix_projet = choix_projet;
    }

    public LazyDataModel<Besoin> getMediumBesoinsModel_v() {
        return mediumBesoinsModel_v;
    }

    public void setMediumBesoinsModel_v(LazyDataModel<Besoin> mediumBesoinsModel_v) {
        this.mediumBesoinsModel_v = mediumBesoinsModel_v;
    }

    public String getId_besoin() {
        return id_besoin;
    }

    public void setId_besoin(String id_besoin) {
        this.id_besoin = id_besoin;
    }

    public String getId_tache() {
        return id_tache;
    }

    public void setId_tache(String id_tache) {
        this.id_tache = id_tache;
    }

    public String getQnt_besoin2() {
        return qnt_besoin2;
    }

    public void setQnt_besoin2(String qnt_besoin2) {
        this.qnt_besoin2 = qnt_besoin2;
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

    public String getQnt_besoin() {
        return qnt_besoin;
    }

    public void setQnt_besoin(String qnt_besoin) {
        this.qnt_besoin = qnt_besoin;
    }

    public BesoinarticleDataModel getMediumbesoindetailsModel() {
        return mediumbesoindetailsModel;
    }

    public void setMediumbesoindetailsModel(BesoinarticleDataModel mediumbesoindetailsModel) {
        this.mediumbesoindetailsModel = mediumbesoindetailsModel;
    }

    public Detailsarticlbesoin getSelecteddetailsbesoinarticle() {
        return selecteddetailsbesoinarticle;
    }

    public void setSelecteddetailsbesoinarticle(Detailsarticlbesoin selecteddetailsbesoinarticle) {
        this.selecteddetailsbesoinarticle = selecteddetailsbesoinarticle;
    }

    public String getId_projet() {
        return id_projet;
    }

    public void setId_projet(String id_projet) {
        this.id_projet = id_projet;
    }

    public List<Besoin> getBesoins() {
        return besoins;
    }

    public void setBesoins(List<Besoin> besoins) {
        this.besoins = besoins;
    }

    public Besoin getSelectedBesoin() {
        return selectedBesoin;
    }

    public void setSelectedBesoin(Besoin selectedBesoin) {
        this.selectedBesoin = selectedBesoin;
    }

    public LazyDataModel<Besoin> getMediumBesoinsModel() {
        return mediumBesoinsModel;
    }

    public Besoin getBesoin() {
        return besoin;
    }

    public void setBesoin(Besoin pers) {
        this.besoin = pers;
    }

    public void supprimer() {
        if (selectedBesoin == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Veuillez choisir un besoin", "Selectionnez une ligne avec les cercles!"));
        }
        List l = details_article_dao.getDetailsarticlbesoins_id(selectedBesoin.getIdbesoin());
        if (!l.isEmpty()) {
            details_article_dao.deleteAll(selectedBesoin.getIdbesoin());
        }
        dao.delete(selectedBesoin.getIdbesoin());
        besoins = dao.getAllBesoin();
        besoins = this.affiche_type_projet(besoins);
        mediumBesoinsModel = new BesoinDataModel(besoins);

    }

    public void valider() {
        if (selectedBesoin == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Veuillez choisir un besoin", "Selectionnez une ligne avec les cercles!"));
        }
        selectedBesoin.setValider("oui");
        dao.update(selectedBesoin);
        besoins = dao.getAllBesoin();
        besoins_v = dao.getAllBesoin_v();
        besoins = this.affiche_type_projet(besoins);
        besoins_v = this.affiche_type_projet(besoins_v);
        mediumBesoinsModel = new BesoinDataModel(besoins);
        mediumBesoinsModel_v = new BesoinDataModel(besoins_v);

    }

    public void archiver() {
        if (selectedBesoin == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Veuillez choisir un besoin", "Selectionnez une ligne avec les cercles!"));
        }
        selectedBesoin.setValider("archiver");
        dao.update(selectedBesoin);
        besoins = dao.getAllBesoin();
        besoins_v = dao.getAllBesoin_v();
        besoins = this.affiche_type_projet(besoins);
        besoins_v = this.affiche_type_projet(besoins_v);
        mediumBesoinsModel = new BesoinDataModel(besoins);
        mediumBesoinsModel_v = new BesoinDataModel(besoins_v);

    }

    public String ajouter() {
        //Si le login est dejà utilisé 
        besoins = dao.getAllBesoin_total();
        for (Besoin b : besoins) {
            if (b.getIdbesoin().equals(besoin.getIdbesoin())) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Ce Bon existe déjà !", "Veuillez changer le N°."));
                return "";
            }
        }
        //sinon


        // besoin.setTypeuser(new Typeuser(typeUser));
        TacheHDao tache_dao = new TacheHDao();
        besoin.setTache(tache_dao.getTache_nom(id_tache, id_projet));
        besoin.setValider("non");
        dao.insert(besoin);
        besoin = new Besoin();
        id_projet = "";
        id_tache = "";
        besoins = dao.getAllBesoin();
        besoins = this.affiche_type_projet(besoins);
        mediumBesoinsModel = new BesoinDataModel(besoins);
        return "succesAjout";

    }

    public void modif() {

        id_tache = selectedBesoin.getTache().getDesignationtache();
        id_projet = selectedBesoin.getTache().getProjet().getIdprojet();
        FacesContext fc = FacesContext.getCurrentInstance();
        ConfigurableNavigationHandler nav = (ConfigurableNavigationHandler) fc.getApplication().getNavigationHandler();
        nav.performNavigation("modif");

    }

    public String enrModif() {

        TacheHDao tache_dao = new TacheHDao();
        selectedBesoin.setTache(tache_dao.getTache_nom(id_tache, id_projet));
        dao.update(selectedBesoin);
        besoins = dao.getAllBesoin();
        id_projet = "";
        id_tache = "";
        besoins = this.affiche_type_projet(besoins);
        mediumBesoinsModel = new BesoinDataModel(besoins);
        return "succesAjout";
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

    public List<String> alltache() {
        List<String> all = new ArrayList<String>();
        TacheHDao tache_dao = new TacheHDao();
        ArrayList<Tache> l = (ArrayList<Tache>) tache_dao.getAllTache_id(id_projet);
        Iterator li = l.iterator();
        while (li.hasNext()) {
            //Recupération objet
            Tache pu = (Tache) li.next();
            all.add(pu.getDesignationtache());

        }
        return all;
    }

    public void details() {
        if (selectedBesoin == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Veuillez choisir un besoin", "Selectionnez une ligne avec les cercles!"));            
        } else {
            //typeUser=selectedBesoin.getTypeuser().getTypeuser();
            id_tache = selectedBesoin.getTache().getDesignationtache();
            id_projet = selectedBesoin.getTache().getProjet().getIdprojet();
            if (selectedBesoin.getTache().getProjet().getTypeprojet().equals("2")) {
                choix_projet = "Inventaire";
            } else {
                choix_projet = "Projet";
            }
            mediumbesoindetailsModel = new BesoinarticleDataModel(details_article_dao.getDetailsarticlbesoins_id1(selectedBesoin.getIdbesoin()));
            FacesContext fc = FacesContext.getCurrentInstance();
            ConfigurableNavigationHandler nav = (ConfigurableNavigationHandler) fc.getApplication().getNavigationHandler();
            nav.performNavigation("details");

        }
    }

    public String details_affaire() {
        if (selectprojet == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Veuillez choisir un besoin", "Selectionnez une ligne avec les cercles!"));
            return "";
        } else {
            List<Besoin> valider = dao.getAllBesoin_v();
            List<Detailsarticlbesoin> list_article = new ArrayList<Detailsarticlbesoin>();
            List<Detailsarticlbesoin> Resultat = new ArrayList<Detailsarticlbesoin>();
            int i = 0;
            do {

                list_article = details_article_dao.getDetailsarticlbesoins_id1(valider.get(i).getIdbesoin());
                //ArrayList<Tache> l = (ArrayList<Tache>) tache_dao.getAllTache_id(id_projet);
                Iterator li = list_article.iterator();
                while (li.hasNext()) {
                    //Recupération objet
                    Detailsarticlbesoin pu = (Detailsarticlbesoin) li.next();

                    Resultat.add(pu);
                }
                i++;
            } while (i < valider.size());
            //mediumarticle=new BesoinarticleDataModel(Resultat);
            Iterator li = Resultat.iterator();

            List<Detailsarticlbesoin> all = new ArrayList<Detailsarticlbesoin>();
            while (li.hasNext()) {
                Detailsarticlbesoin pu = (Detailsarticlbesoin) li.next();
                Besoin besoin_v = dao.getBesoin(pu.getId().getIdbesoin());
                if (besoin_v.getTache().getProjet().getIdprojet().equals(selectprojet.getIdprojet())) {
                    all.add(pu);
                }
            }
            List<Detailsarticlbesoin> all_1 = new ArrayList<Detailsarticlbesoin>();
            li = all.iterator();
            while (li.hasNext()) {
                // Boolean Test = true;
                //recupération de la demande de prix
                Detailsarticlbesoin dp = (Detailsarticlbesoin) li.next();
                Iterator li1 = all_1.iterator();
                // && Test
                while (li1.hasNext()) {
                    //Recuperation de la demande enregistree
                    Detailsarticlbesoin dp1 = (Detailsarticlbesoin) li1.next();
                    if (dp.getId().getIdarticle().equals(dp1.getId().getIdarticle())) {
                        // Test = false;
                        dp.setQntbesoin(dp1.getQntbesoin() + dp.getQntbesoin());
                        li1.remove();
                        //Test=true;
                    }
                }
                //if (Test == true) {
                all_1.add(dp);
                //}
            }
            mediumarticle = new BesoinarticleDataModel(all_1);
            valider = dao.getAllBesoin_v();
            return "details_affaire";
        }
    }

    public String details_intevention() {
        if (selectintervention == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Veuillez choisir une Intervention ", "Selectionnez une ligne avec les cercles!"));
            return "";
        } else {
            List<Besoin> valider = dao.getAllBesoin_v();
            List<Detailsarticlbesoin> list_article = new ArrayList<Detailsarticlbesoin>();
            List<Detailsarticlbesoin> Resultat = new ArrayList<Detailsarticlbesoin>();
            int i = 0;
            do {

                list_article = details_article_dao.getDetailsarticlbesoins_id1(valider.get(i).getIdbesoin());
                //ArrayList<Tache> l = (ArrayList<Tache>) tache_dao.getAllTache_id(id_projet);
                Iterator li = list_article.iterator();
                while (li.hasNext()) {
                    //Recupération objet
                    Detailsarticlbesoin pu = (Detailsarticlbesoin) li.next();

                    Resultat.add(pu);
                }
                i++;
            } while (i < valider.size());
            //mediumarticle=new BesoinarticleDataModel(Resultat);
            Iterator li = Resultat.iterator();

            List<Detailsarticlbesoin> all = new ArrayList<Detailsarticlbesoin>();
            while (li.hasNext()) {
                Detailsarticlbesoin pu = (Detailsarticlbesoin) li.next();
                Besoin besoin_v = dao.getBesoin(pu.getId().getIdbesoin());
                if (besoin_v.getTache().getProjet().getIdprojet().equals(selectintervention.getIdprojet())) {
                    all.add(pu);
                }
            }
            List<Detailsarticlbesoin> all_1 = new ArrayList<Detailsarticlbesoin>();
            li = all.iterator();
            while (li.hasNext()) {
                // Boolean Test = true;
                //recupération de la demande de prix
                Detailsarticlbesoin dp = (Detailsarticlbesoin) li.next();
                Iterator li1 = all_1.iterator();
                // && Test
                while (li1.hasNext()) {
                    //Recuperation de la demande enregistree
                    Detailsarticlbesoin dp1 = (Detailsarticlbesoin) li1.next();
                    if (dp.getId().getIdarticle().equals(dp1.getId().getIdarticle())) {
                        // Test = false;
                        dp.setQntbesoin(dp1.getQntbesoin() + dp.getQntbesoin());
                        li1.remove();
                        //Test=true;
                    }
                }
                //if (Test == true) {
                all_1.add(dp);
                //}
            }
            mediumarticle = new BesoinarticleDataModel(all_1);
            valider = dao.getAllBesoin_v();
            return "details_intervention";
        }
    }

    public void supprimer_details() {
        if (selecteddetailsbesoinarticle == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Veuillez choisir une article", "Selectionnez une ligne !"));
        }

        details_article_dao.delete(selecteddetailsbesoinarticle.getId());
        mediumbesoindetailsModel = new BesoinarticleDataModel(details_article_dao.getDetailsarticlbesoins_id1(selectedBesoin.getIdbesoin()));

    }

    public String enrDetails() {
        Article article = article_dao.getArticle(id_article);
        if (article == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "N° article n'exist pas  !", "Veuillez changer le Code d'article."));
            System.err.println("ggg");
            return "";
        } else {
            Integer t = new Integer(0);
            try {
                t = new Integer(qnt_besoin);
            } catch (Exception e) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Qnt doit étre numérique  !", "Veuillez changer la Qnt."));
                //System.err.println("aaaaaaaaa");
                return "";
            }
            // Article a = article_dao.getArticle(id_article);
            Detailsarticlbesoin details = new Detailsarticlbesoin(new DetailsarticlbesoinId(selectedBesoin.getIdbesoin(), id_article), t);
            details_article_dao.insert(details);
            // Integer  = article_dao.getArticle(id_article);
            mediumbesoindetailsModel = new BesoinarticleDataModel(details_article_dao.getDetailsarticlbesoins_id1(selectedBesoin.getIdbesoin()));

            return "details";

        }
    }

    public String trier() {

        if (choix_trie.equals("Affaire")) {
            this.trier_affaire();
            return "affaire";
        }
        if (choix_trie.equals("Intervention")) {
            this.trier_intervention();
            return "intervention";
        }
        if (choix_trie.equals("Article")) {
            this.trie_article();
            return "article";
        }

        return "";
    }

    public void trie_article() {
        // ArticleHDao dao_article=new ArticleHDao();
        List<Besoin> valider = dao.getAllBesoin_v();
        List<Detailsarticlbesoin> details_article;
        List<Detailsarticlbesoin> Resultat = new ArrayList<Detailsarticlbesoin>();
        int i = 0;
        do {

            details_article = details_article_dao.getDetailsarticlbesoins_id1(valider.get(i).getIdbesoin());
            //ArrayList<Tache> l = (ArrayList<Tache>) tache_dao.getAllTache_id(id_projet);
            Iterator li = details_article.iterator();
            while (li.hasNext()) {
                //Recupération objet
                Detailsarticlbesoin pu = (Detailsarticlbesoin) li.next();

                Resultat.add(pu);
            }
            i++;
        } while (i < valider.size());
        //mediumarticle=new BesoinarticleDataModel(Resultat);
        Iterator li = Resultat.iterator();
        List<Detailsarticlbesoin> all = new ArrayList<Detailsarticlbesoin>();
        while (li.hasNext()) {
            // Boolean Test = true;
            //recupération de la demande de prix
            Detailsarticlbesoin dp = (Detailsarticlbesoin) li.next();
            Iterator li1 = all.iterator();
            // && Test
            while (li1.hasNext()) {
                //Recuperation de la demande enregistree
                Detailsarticlbesoin dp1 = (Detailsarticlbesoin) li1.next();
                if (dp.getId().getIdarticle().equals(dp1.getId().getIdarticle())) {
                    // Test = false;
                    dp.setQntbesoin(dp1.getQntbesoin() + dp.getQntbesoin());
                    li1.remove();
                    //Test=true;
                }
            }
            //if (Test == true) {
            all.add(dp);
            //}
        }
        mediumarticle = new BesoinarticleDataModel(all);

    }

    public void trier_affaire() {
        List<Besoin> valider = dao.getAllBesoin_v();
        Iterator li = valider.iterator();
        List<Projet> allRef = new ArrayList<Projet>();
        while (li.hasNext()) {
            Boolean Test = true;
            //recupération de la demande de prix
            Besoin dp1 = (Besoin) li.next();
            Projet dp = dp1.getTache().getProjet();
            Iterator li1 = allRef.iterator();
            while (li1.hasNext() && Test) {
                //Recuperation de la demande enregistree
                Projet dp2 = (Projet) li1.next();
                if (dp.getIdprojet().equals(dp2.getIdprojet())) {
                    Test = false;
                }
            }
            if (Test == true) {
                allRef.add(dp);
            }
        }
        li = allRef.iterator();
        while (li.hasNext()) {
            Projet dp2 = (Projet) li.next();
            if (dp2.getTypeprojet().equals("2")) {
                li.remove();
            }
        }
        mediumprojet = new ProjetDataModel(allRef);
    }

    public void trier_intervention() {
        List<Besoin> valider = dao.getAllBesoin_v();
        Iterator li = valider.iterator();
        List<Projet> allRef = new ArrayList<Projet>();
        while (li.hasNext()) {
            Boolean Test = true;
            //recupération de la demande de prix
            Besoin dp1 = (Besoin) li.next();
            Projet dp = dp1.getTache().getProjet();
            Iterator li1 = allRef.iterator();
            while (li1.hasNext() && Test) {
                //Recuperation de la demande enregistree
                Projet dp2 = (Projet) li1.next();
                if (dp.getIdprojet().equals(dp2.getIdprojet())) {
                    Test = false;
                }
            }
            if (Test == true) {
                allRef.add(dp);
            }
        }
        li = allRef.iterator();
        while (li.hasNext()) {
            Projet dp2 = (Projet) li.next();
            if (dp2.getTypeprojet().equals("1")) {
                li.remove();
            }
        }
        mediumprojet = new ProjetDataModel(allRef);
    }
}