/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Controller;
import java.util.ArrayList;
import model.Exame;
import model.ExameDAO;

/**
 *
 * @author vh141
 */
public class ExameTableModel extends GenericTableModel{

    public ExameTableModel(ArrayList vDados) {
        super(vDados, new String[]{"Consulta", "Descricao"});
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return String.class;
            case 1:
                return Integer.class;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Exame exame = (Exame) vDados.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return exame.getDes_exame();
            case 1:
                return exame.getConsulta().getId();
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
    	Exame exame = (Exame) vDados.get(rowIndex);

        switch (columnIndex) {
            case 0:
            	exame.setDes_exame((String) aValue);
                break;
            case 1:
            	exame.setConsulta(Controller.getConsultaById((Integer) aValue));
                break;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
        
        ExameDAO.getInstance().update(exame);
    }    
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }
    
    
    public Exame getTratamentoByRow(int rowIndex) {
        return (Exame) vDados.get(rowIndex);
    }
    
}
