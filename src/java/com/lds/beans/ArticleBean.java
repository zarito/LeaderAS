/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.beans;


import com.lds.persistance.ArticleHDao;
import com.lds.vo.Article;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.model.LazyDataModel;
  
 
//Pour donner un autre nom à mon bean : @ManagedBean("autrenom")  
public class ArticleBean implements Serializable {  
 
  
    private List<Article> filteredArticles;  
  
    private List<Article> articles;  
  
    private Article selectedArticle;  
  
    
    private  Article elt;
    private  ArticleHDao dao;
      private  ArticleDataModel mediumArticlesModel;
    private String id_article;

    public void setId_article(String id_article) {
        this.id_article = id_article;
    }

    public String getId_article() {
        return id_article;
    }
  
    public ArticleBean() {          
        elt = new Article();
        articles = new ArrayList<Article>();
        //selectedArticle=new Article();
        //populateRandomCars(cars, 50);  
        dao = new ArticleHDao();
        articles = dao.getAllArticle();
        mediumArticlesModel = new ArticleDataModel(articles); 
    }  
  
    public Article getSelectedArticle() {  
        return selectedArticle;  
    }  
  
    public void setSelectedArticle(Article selectedArticle) {  
        this.selectedArticle = selectedArticle;  
    }  
       public LazyDataModel<Article> getMediumArticlesModel() {
        return mediumArticlesModel;
    }

    public Article getElt() {
        return elt;
    }

    public void setElt(Article elt) {
        this.elt = elt;
    }
         
    public List<Article> getFilteredArticles() {  
        return filteredArticles;  
    }  
  
    public void setFilteredArticles(List<Article> filteredArticles) {  
        this.filteredArticles = filteredArticles;  
    }  
  
    public List<Article> getArticles() {  
        return articles;  
    }  
    public void supprimer() {
        if (selectedArticle == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Veuillez choisir un article", "Selectionnez une ligne !"));
        }
        try{
        dao.delete(selectedArticle.getIdarticle());
        //dao1.delete(selectedArticle.getId().getIdarticle());
        articles = dao.getAllArticle();
        mediumArticlesModel = new ArticleDataModel(articles);
        }catch(Exception e)
        {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Imposible de supprimer l'article N° :"+selectedArticle.getIdarticle(), "Article déja utilisée")); 
        }

    }

    public String ajouter() {
        //Si le login est dejà utilisé 

        for (Article article : articles) {
            if (article.getIdarticle().equals(elt.getIdarticle())) {
               FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Cette article existe déjà !", "Veuillez changer le Code de article."));
                return "";
            }
        }
        //elt.setIdarticle(id_article);
        elt.setQntarticle(0);
        //dao1.insert(new Element(id_article));
        dao.insert(elt);
        elt = new Article();
        articles = dao.getAllArticle();
        id_article=new String();
        mediumArticlesModel = new ArticleDataModel(articles);
        return "succesAjout";

    }
    
    

    public void modif() {
        FacesContext fc = FacesContext.getCurrentInstance();
        ConfigurableNavigationHandler nav = (ConfigurableNavigationHandler) fc.getApplication().getNavigationHandler();
        nav.performNavigation("modif_stock");
    }
    
    public String enrModif(){
        //selectedArticle.setTypeuser(new Typeuser(typeUser));
        dao.update(selectedArticle);
        articles = dao.getAllArticle();
        mediumArticlesModel = new ArticleDataModel(articles);
        return "succesAjout";
    }
    public List<String> allNomArticles() {
        List<String> all = new ArrayList<String>();                
        Iterator li = articles.iterator();
        while (li.hasNext()) {
//RecupÃ©ration objet
            Article pu = (Article) li.next();
            all.add(pu.getIdarticle());
        }

        return all;
    }
} 