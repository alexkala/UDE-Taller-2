package grafica.auxiliares;

import javax.swing.table.AbstractTableModel;

public class MyTableModel extends AbstractTableModel {
	
	public boolean isCellEditable(int row, int col) {
		return false;
	}
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}
    /*
	private String[] nombreColumnas = {
    		"POSICIÓN",
            "NOMBRE",
            "PUNTOS",
            "ACIERTOS",
            "ERRORES",
            "PARTIDAS"};
    
    private Object[][] data;

    public MyTableModel() {
    	super();
    }
    
    public String[] getNombreColumnas() {
		return nombreColumnas;
	}

	public void setNombreColumnas(String[] nombreColumnas) {
		this.nombreColumnas = nombreColumnas;
	}

	public Object[][] getData() {
		return data;
	}

	public void setData(Object[][] data) {
		this.data = data;
	}

	public int getColumnCount() {
        return nombreColumnas.length;
    }

    public int getRowCount() {
        return data.length;
    }

    public String getColumnName(int col) {
        return nombreColumnas[col];
    }

    public Object getValueAt(int row, int col) {
        return data[row][col];
    }

    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
    
    public void setValueAt(Object value, int row, int col) {
        data[row][col] = value;
        fireTableCellUpdated(row, col);
    }
    */
    
}
