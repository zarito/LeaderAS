/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.beans;

import com.lds.persistance.ClientDao;
import com.lds.persistance.ClientHDao;
import com.lds.vo.Client;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 *
 * @author zarito
 */
public class ClientConverter implements Converter {

    public ClientConverter() {
    }
    
    ClientDao cd = new ClientHDao();

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        System.out.println("dssssssssss" + string);        
        return cd.getClient(string);    
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if (o == null || o.equals("")) {
            return "";
        } else {
            return ((Client) o).getIdclient().toString();
        }
    }
}
