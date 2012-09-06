package com.lds.beans;

import com.lds.vo.Client;
import com.lds.vo.Soustache;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

/**
 * Dummy implementation of LazyDataModel that uses a list to mimic a real datasource like a database.
 */
public class SousTacheDataModel extends LazyDataModel<Soustache> {
    
    private List<Soustache> datasource;
       
    public SousTacheDataModel(List<Soustache> datasource) {
        this.datasource = datasource;
    }
    
    @Override
    public Soustache getRowData(String rowKey) {
        for(Soustache soustache : datasource) {
            if(soustache.getIdsousprojet().equals(rowKey))
                return soustache;
        }

        return null;
    }

    @Override
    public Object getRowKey(Soustache soustache) {
        return soustache.getIdsousprojet();
    }

    @Override
    public List<Soustache> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,String> filters) {
        List<Soustache> data = new ArrayList<Soustache>();

        //filter
        for(Soustache soustache : datasource) {
            boolean match = true;

            for(Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {
                try {
                    String filterProperty = it.next();
                    String filterValue = filters.get(filterProperty);
                    String fieldValue = String.valueOf(soustache.getClass().getField(filterProperty).get(soustache));

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
                data.add(soustache);
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