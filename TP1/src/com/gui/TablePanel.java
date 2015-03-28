package com.gui;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import encapsulamiento.Frase;


public class TablePanel extends JPanel{
	private JTable table;
	private PalabraTableModel tableModel;
	private int row;
	
	public TablePanel() {
		tableModel = new PalabraTableModel();
		table = new JTable(tableModel);
		setLayout(new BorderLayout());
		add(new JScrollPane(table), BorderLayout.CENTER);
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
		
	}
	public void setData(List<Frase> db){
		tableModel.setData(db);
	}
	public int rows(){
		return tableModel.getRowCount();
	}
	
	public void refresh(){
		tableModel.fireTableDataChanged();
	}
	public String columna(int rowIndex, int columnIndex){
		return (String) tableModel.getValueAt(rowIndex, columnIndex);
	}
	
	

	
	
}
