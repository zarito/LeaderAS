package com.lds.beans;

import com.lds.vo.Personnel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

/**
 * Dummy implementation of LazyDataModel that uses a list to mimic a real datasource like a database.
 */
public class PersonnelDataModel extends LazyDataModel<Personnel> {
    
    private List<Personnel> datasource;
       
    public PersonnelDataModel(List<Personnel> datasource) {
        this.datasource = datasource;
    }
    
    @Override
    public Personnel getRowData(String rowKey) {
        for(Personnel personnel : datasource) {
            if(personnel.getIdpersonnel().equals(rowKey))
                return personnel;
        }

        return null;
    }

    @Override
    public Object getRowKey(Personnel personnel) {
        return personnel.getIdpersonnel();
    }

    @Override
    public List<Personnel> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,String> filters) {
        List<Personnel> data = new ArrayList<Personnel>();

        //filter
        for(Personnel personnel : datasource) {
            boolean match = true;

            for(Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {
                try {
                    String filterProperty = it.next();
                    String filterValue = filters.get(filterProperty);
                    String fieldValue = String.valueOf(personnel.getClass().getField(filterProperty).get(personnel));

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
                data.add(personnel);
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