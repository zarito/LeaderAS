package com.lds.beans;

import com.lds.persistance.PersonnelDao;
import com.lds.persistance.PersonnelHDao;
import com.lds.vo.Personnel;
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
public class PersonnelConverter implements Converter {
    
    public PersonnelConverter(){        
    }
    
    PersonnelDao pd = new PersonnelHDao();

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        return pd.getPersonnel(string);
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        return ((Personnel) o).getIdpersonnel().toString();
    }
    
}
