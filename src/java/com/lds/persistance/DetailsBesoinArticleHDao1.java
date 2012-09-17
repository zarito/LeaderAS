/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.persistance;



import com.lds.vo.Detailsarticlbesoin;
import com.lds.vo.DetailsarticlbesoinId;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author zarito
 */
public class DetailsBesoinArticleHDao1 implements DetailsBesoinArticleDao {
    private List<Detailsarticlbesoin> detailsarticlebesoinList;
    private Detailsarticlbesoin detailsarticlebesoin;
    
    @Override
    public List getAllDetailsarticlebesoins() {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            detailsarticlebesoinList = session.createQuery("from Detailsarticlbesoin").list();
            return detailsarticlebesoinList;
        } catch (HibernateException e) {
            throw e;
        } finally {
            session.close();
        }
    }
 public List getDetailsarticlbesoins_id(String id_bc) {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            detailsarticlebesoinList = session.createQuery("from Detailsarticlbesoin where idbesoin='"+id_bc+"'").list();
            return detailsarticlebesoinList;
        } catch (HibernateException e) {
            throw e;
        } finally {
            session.close();
        }
    }
 public List getDetailsarticlbesoins_id1(String id_bc) {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            detailsarticlebesoinList = session.createQuery("from Detailsarticlbesoin where idbesoin='"+id_bc+"'").list();
           // List<Detailsarticlbesoin> details=details_article_dao.getDetailsarticlbesoins_id(selectedBesoin.getIdbesoin());
       List<Detailsarticlbesoin> all = new ArrayList<Detailsarticlbesoin>();
        Iterator li = detailsarticlebesoinList.iterator();
        ArticleHDao article_dao=new ArticleHDao();
        while (li.hasNext()) {
            //Recupération objet
            
            Detailsarticlbesoin pu = (Detailsarticlbesoin) li.next();
            pu.setNom_article(article_dao.getArticle(pu.getId().getIdarticle()).getDescarticle());
            pu.setQntarticle(article_dao.getArticle(pu.getId().getIdarticle()).getQntarticle());
            all.add(pu);
        }
            return all;
        } catch (HibernateException e) {
            throw e;
        } finally {
            session.close();
        }
    }
 
    @Override
    public Detailsarticlbesoin getDetailsarticlebesoin(DetailsarticlbesoinId id) {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            Query q = session.createQuery("from Detailsarticlbesoin  where idbesoin =:idbesoin and idarticle =:idarticle");
            q.setString("idbesoin", id.getIdbesoin());
            q.setString("idarticle", id.getIdarticle());
            return (Detailsarticlbesoin) q.uniqueResult();
        } finally {
            session.close();
        }
    }

    @Override
    public void update(Detailsarticlbesoin detailsarticlebesoin) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(detailsarticlebesoin);
            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null) {
                tx.rollback();
            }
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public void insert(Detailsarticlbesoin detailsarticlebesoin) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.save(detailsarticlebesoin);
            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null) {
                tx.rollback();
            }
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public void delete(DetailsarticlbesoinId id) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            detailsarticlebesoin = (Detailsarticlbesoin) session.get(Detailsarticlbesoin.class, id);
            session.delete(detailsarticlebesoin);
            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null) {
                tx.rollback();
            }
            throw e;
        } finally {
            session.close();
        }

    }
    public void deleteAll(String id) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        int i=0;
        try {
            List<Detailsarticlbesoin> l=this.getDetailsarticlbesoins_id(id);
            do{
            tx = session.beginTransaction();
            //detailsarticlebesoin = (Detailsarticlbesoin) session.get(Detailsarticlbesoin.class, id);
            session.delete(l.get(i));
            tx.commit();
            i++;
            }while(i<l.size());
        } catch (RuntimeException e) {
            if (tx != null) {
                tx.rollback();
            }
            throw e;
        } finally {
            session.close();
        }

    }
}

