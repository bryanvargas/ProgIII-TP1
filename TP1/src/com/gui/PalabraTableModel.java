package com.gui;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import com.persistencia.Frase;

public class PalabraTableModel extends AbstractTableModel {
	private List<Frase> db;
	private String[] colName = {"Articulo", "Sustantivo", "Verbo", "Preposicion"};  
	
	public PalabraTableModel() {		
	}
	
	public void setData(List<Frase> db){
		this.db = db;
	}	
	@Override
	public String getColumnName(int column) {		
		return colName[column];
	}


	@Override
	public int getColumnCount() {		
		return colName.length;
	}


	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {		
		Frase palabra  = db.get(rowIndex);
		switch(columnIndex){
		case 0:
			return palabra.getArticulo();
		case 1:
			return palabra.getSustantivo();
		case 2:
			return palabra.getVerbo();			
		case 3:
			return palabra.getPreposicion();
		}
		return null;
	}

	@Override
	public int getRowCount() {

		return db.size();
	}





}
