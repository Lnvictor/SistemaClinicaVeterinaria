/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.sql.Date;
import java.util.ArrayList;
import model.Tratamento;
import model.TratamentoDAO;

/**
 *
 * @author vh141
 */
public class TratamentoTableModel extends GenericTableModel{

    public TratamentoTableModel(ArrayList vDados) {
        super(vDados, new String[] {"dat_ini", "dat_fim"});
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return Date.class;
            case 1:
                return Date.class;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Tratamento tratamento = (Tratamento) vDados.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return tratamento.getDat_ini();
            case 1:
                return tratamento.getDat_fim();
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
    	Tratamento tratamento = (Tratamento) vDados.get(rowIndex);

        switch (columnIndex) {
            case 0:
            	tratamento.setDat_ini((Date)aValue);
                break;
            case 1:
            	tratamento.setDat_fim((Date)aValue);
                break;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
        
        TratamentoDAO.getInstance().update(tratamento);
    }    
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }
    
}
