/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.persistance;


import com.lds.vo.Detailsarticlbesoin;
import com.lds.vo.DetailsarticlbesoinId;
import java.util.List;

/**
 *
 * @author zarito
 */
public interface DetailsBesoinArticleDao {
    
     public List getAllDetailsarticlebesoins();

    public Detailsarticlbesoin getDetailsarticlebesoin(DetailsarticlbesoinId id);
    
    public void update(Detailsarticlbesoin detailsarticlebesoin);

    public void insert(Detailsarticlbesoin detailsarticlebesoin);

    public void delete(DetailsarticlbesoinId id);
    
}
