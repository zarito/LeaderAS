package com.lds.beans;

import com.lds.vo.Tache;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

/**
 * Dummy implementation of LazyDataModel that uses a list to mimic a real datasource like a database.
 */
public class TacheDataModel extends LazyDataModel<Tache> {
    
    private List<Tache> datasource;
       
    public TacheDataModel(List<Tache> datasource) {
        this.datasource = datasource;
    }
    
    @Override
    public Tache getRowData(String rowKey) {
        for(Tache tache : datasource) {
            if(tache.getNumtache().equals(rowKey))
                return tache;
        }

        return null;
    }

    @Override
    public Object getRowKey(Tache tache) {
        return tache.getNumtache();
    }

    @Override
    public List<Tache> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,String> filters) {
        List<Tache> data = new ArrayList<Tache>();

        //filter
        for(Tache tache : datasource) {
            boolean match = true;

            for(Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {
                try {
                    String filterProperty = it.next();
                    String filterValue = filters.get(filterProperty);
                    String fieldValue = String.valueOf(tache.getClass().getField(filterProperty).get(tache));

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
                data.add(tache);
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