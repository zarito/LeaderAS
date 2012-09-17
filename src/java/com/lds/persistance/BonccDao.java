/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.persistance;

import com.lds.vo.Boncc;
import java.util.List;

/**
 *
 * @author zarito
 */
public interface BonccDao {
    
     public List getAllBoncc();

    public Boncc getBoncc(String id);

    public void update(Boncc boncc);

    public void insert(Boncc boncc);

    public void delete(String id);
    
}
