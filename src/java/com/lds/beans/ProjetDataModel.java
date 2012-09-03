package com.lds.beans;

import com.lds.vo.Projet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

/**
 * Dummy implementation of LazyDataModel that uses a list to mimic a real datasource like a database.
 */
public class ProjetDataModel extends LazyDataModel<Projet> {
    
    private List<Projet> datasource;
       
    public ProjetDataModel(List<Projet> datasource) {
        this.datasource = datasource;
    }
    
    @Override
    public Projet getRowData(String rowKey) {
        for(Projet projet : datasource) {
            if(projet.getIdprojet().equals(rowKey))
                return projet;
        }

        return null;
    }

    @Override
    public Object getRowKey(Projet projet) {
        return projet.getIdprojet();
    }

    @Override
    public List<Projet> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,String> filters) {
        List<Projet> data = new ArrayList<Projet>();

        //filter
        for(Projet projet : datasource) {
            boolean match = true;

            for(Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {
                try {
                    String filterProperty = it.next();
                    String filterValue = filters.get(filterProperty);
                    String fieldValue = String.valueOf(projet.getClass().getField(filterProperty).get(projet));

                    if(filterValue == null || fieldValue.startsWith(filterValue)) {
                        match = true;
                    }
                    else {
                        match = false;
                        break;
                    }
                } catch(Exception e) {
                    match = false;
                } 
            }

            if(match) {
                data.add(projet);
            }
        }

        //sort
        /*if(sortField != null) {
            Collections.sort(data, new LazySorter(sortField, sortOrder));
        }*/

        //rowCount
        int dataSize = data.size();
        this.setRowCount(dataSize);

        //paginate
        if(dataSize > pageSize) {
            try {
                return data.subList(first, first + pageSize);
            }
            catch(IndexOutOfBoundsException e) {
                return data.subList(first, first + (dataSize % pageSize));
            }
        }
        else {
            return data;
        }
    }
}