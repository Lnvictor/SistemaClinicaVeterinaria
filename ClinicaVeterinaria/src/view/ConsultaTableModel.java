/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Controller;
import java.sql.Date;
import java.util.ArrayList;
import model.Consulta;
import model.ConsultaDAO;
import model.Tratamento;
import model.Veterinario;

/**
 *
 * @author vh141
 */
public class ConsultaTableModel extends GenericTableModel{

    public ConsultaTableModel(ArrayList vDados) {
        super(vDados, new String[] {"Veterinario", "Data", "Historico"});
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return String.class;
            case 1:
                return Date.class;
            case 2:
                return String.class;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Consulta consulta = (Consulta) vDados.get(rowIndex);
        
        switch (columnIndex) {
            case 0:
                return consulta.getVeterinario().getNom_vet();
            case 1:
                return consulta.getDate_con();
            case 2:
                return consulta.getHistorico();
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
    	Consulta consulta = (Consulta) vDados.get(rowIndex);

        switch (columnIndex) {
            case 0:
            	consulta.setVeterinario((Veterinario)aValue);
                break;
            case 1:
            	consulta.setDate_con((Date)aValue);
                break;
            case 2:
                consulta.setHistorico((String) aValue);
                break;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
        
        ConsultaDAO.getInstance().update(consulta);
    }    
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }
    
    public Consulta getConsultaByRow(int rowIndex) {
        return (Consulta) vDados.get(rowIndex);
    }
}
