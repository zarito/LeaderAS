package com.lds.beans;

import com.lds.vo.Detailsarticlbesoin;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

/**
 * Dummy implementation of LazyDataModel that uses a list to mimic a real datasource like a database.
 */
public class BesoinarticleDataModel extends LazyDataModel<Detailsarticlbesoin> {
    
    private List<Detailsarticlbesoin> datasource;
       
    public BesoinarticleDataModel(List<Detailsarticlbesoin> datasource) {
        this.datasource = datasource;
    }
    
    @Override
    public Detailsarticlbesoin getRowData(String rowKey) {
        for(Detailsarticlbesoin article : datasource) {
            if(article.getId().getIdarticle().equals(rowKey))
                return article;
        }

        return null;
    }

    @Override
    public Object getRowKey(Detailsarticlbesoin article) {
        return article.getId().getIdarticle();
    }

    @Override
    public List<Detailsarticlbesoin> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,String> filters) {
        List<Detailsarticlbesoin> data = new ArrayList<Detailsarticlbesoin>();

        //filter
        for(Detailsarticlbesoin article : datasource) {
            boolean match = true;

            for(Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {
                try {
                    String filterProperty = it.next();
                    String filterValue = filters.get(filterProperty);
                    String fieldValue = String.valueOf(article.getClass().getField(filterProperty).get(article));

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
                data.add(article);
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