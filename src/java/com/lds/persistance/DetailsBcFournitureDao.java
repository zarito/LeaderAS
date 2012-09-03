/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.persistance;


import com.lds.vo.Detailsbcfourniture;
import com.lds.vo.DetailsbcfournitureId;
import java.util.List;

/**
 *
 * @author zarito
 */
public interface DetailsBcFournitureDao {
    
     public List getAllDetailsbcfournitures();

    public Detailsbcfourniture getDetailsbcfourniture(DetailsbcfournitureId id);
    
    public void update(Detailsbcfourniture detailsbcfourniture);

    public void insert(Detailsbcfourniture detailsbcfourniture);

    public void delete(DetailsbcfournitureId id);
    
}
