package grafica.auxiliares;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TablaRanking extends JPanel {

	public TablaRanking() {
		super(new GridLayout(1,0));
		JTable table = new JTable(new MyTableModel());
		table.setPreferredScrollableViewportSize(new Dimension(500, 70));
		table.setFillsViewportHeight(true);
	
	}
	
	
	
}
