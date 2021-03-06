/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.beans;


import com.lds.persistance.ClientHDao;
import com.lds.vo.Client;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.model.LazyDataModel;
  
 
  
public class ClientBean implements Serializable {  
 
  
    private List<Client> filteredClients;  
  
    private List<Client> clients;  
  
    private Client selectedClient;        
    
    private  Client clt;
    private  ClientHDao dao;
    private  ClientDataModel mediumClientsModel;
  
    public ClientBean() {  
        
        clt = new Client();
        clients = new ArrayList<Client>();   
        dao = new ClientHDao();
        clients = dao.getAllClients();
        mediumClientsModel = new ClientDataModel(clients); 
    }  
  
    public Client getSelectedClient() {  
        return selectedClient;  
    }  
  
    public void setSelectedClient(Client selectedClient) {  
        this.selectedClient = selectedClient;  
    }  
       public LazyDataModel<Client> getMediumClientsModel() {
        return mediumClientsModel;
    }

    public Client getClt() {
        return clt;
    }

    public void setClt(Client clt) {
        this.clt = clt;
    }
         
    public List<Client> getFilteredClients() {  
        return filteredClients;  
    }  
  
    public void setFilteredClients(List<Client> filteredClients) {  
        this.filteredClients = filteredClients;  
    }  
  
    public List<Client> getClients() {  
        return clients;  
    }  
    
     public void supprimer() {
        if (selectedClient == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Veuillez choisir un client", "Selectionnez une ligne !"));
        }
        try{
        dao.delete(selectedClient.getIdclient());
        clients = dao.getAllClients();
        mediumClientsModel = new ClientDataModel(clients);
        }
        catch(Exception e)
        {
         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Impossible de supprimer le client", "le client Déja utilisé !")); 
        }

    }

    public String ajouter() {
        //Si le login est dejà utilisé 

        for (Client client : clients) {
            if (client.getIdclient().equals(clt.getIdclient())) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Ce client existe déjà!", "Veuillez changer le Code du client."));
                return "";
            }
        }
        //sinon
        
        dao.insert(clt);
        clt=new Client();
        clients = dao.getAllClients();
        mediumClientsModel = new ClientDataModel(clients);
        return "succesAjout";

    }
    
    

    public void modif() {
       FacesContext fc = FacesContext.getCurrentInstance();
        ConfigurableNavigationHandler nav = (ConfigurableNavigationHandler) fc.getApplication().getNavigationHandler();
        nav.performNavigation("modif");
    }
    
    public String enrModif(){
        dao.update(selectedClient);
        clients = dao.getAllClients();
        mediumClientsModel = new ClientDataModel(clients);
        return "succesAjout";
    }
    
       public List<String> allNomClients() {
        List<String> all = new ArrayList<String>();                
        Iterator li = clients.iterator();
        while (li.hasNext()) {
//RecupÃ©ration objet
            Client pu = (Client) li.next();
            all.add(pu.getNomclient());
        }

        return all;
    }
}   
   