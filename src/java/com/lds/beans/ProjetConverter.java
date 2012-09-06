/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.beans;

import com.lds.persistance.ProjetDao;
import com.lds.persistance.ProjetHDao;
import com.lds.vo.Projet;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 *
 * @author zarito
 */
public class ProjetConverter implements Converter {

    public ProjetConverter() {
    }
    
    ProjetDao cd = new ProjetHDao();

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {            
        return cd.getProjet(string)    ;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if (o == null || o.equals("")) {
            return "";
        } else {
            return ((Projet) o).getIdprojet().toString();
        }
    }
}
