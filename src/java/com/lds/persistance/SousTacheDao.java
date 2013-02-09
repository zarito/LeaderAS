/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.persistance;

import com.lds.vo.Soustache;
import java.util.List;

/**
 *
 * @author zarito
 */
public interface SousTacheDao {

    public List getAllSoustache();

    public Soustache getSoustache(String id);

    public void update(Soustache soustache);

    public void insert(Soustache soustache);

    public void delete(String id);
}
