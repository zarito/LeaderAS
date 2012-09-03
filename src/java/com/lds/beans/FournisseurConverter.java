package com.lds.beans;

import com.lds.persistance.FournisseurDao;
import com.lds.vo.Fournisseur;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author zarito
 */
public class FournisseurConverter implements Converter {
    
    public FournisseurConverter(){        
    }
    
    FournisseurDao fd;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        return fd.getFournisseur(string);
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        return ((Fournisseur) o).getIdfournisseur().toString();
    }
    
}
