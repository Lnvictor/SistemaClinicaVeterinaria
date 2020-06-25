/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;
import model.Veterinario;
import model.VeterinarioDAO;

/**
 *
 * @author vh141
 */
public class VeterinarioTableModel extends GenericTableModel{
    public VeterinarioTableModel(ArrayList vDados) {
        super(vDados, new String[] {"Nome", "Endereço", "Telefone"});
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return String.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Veterinario v = (Veterinario) vDados.get(rowIndex);
        
        switch (columnIndex) {
            case 0:
                return v.getNom_vet();
            case 1:
                return v.getEnd_vet();
            case 2:
                return v.getTel_vet();
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
    	Veterinario veterinario = (Veterinario) vDados.get(rowIndex);

        switch (columnIndex) {
            case 0:
            	veterinario.setNom_vet((String) aValue);
                break;
            case 1:
            	veterinario.setEnd_vet((String) aValue);
                break;
            case 2:
            	veterinario.setTel_vet((String) aValue);
                break;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
        
        VeterinarioDAO.getInstance().update(veterinario);
    }    
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }
    
    public Veterinario getVeterinarioByRow(int rowIndex) {
        return (Veterinario) vDados.get(rowIndex);
    }
}
