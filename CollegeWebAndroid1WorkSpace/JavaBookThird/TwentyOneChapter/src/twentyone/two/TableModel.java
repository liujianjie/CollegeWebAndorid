package twentyone.two;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class TableModel extends JFrame{
	public TableModel(){
		super("表格模型");
		
		Container con = getContentPane();
		
		
		String [] column = {"A","B"};
		String [][] rowumn = {{"A1","B1"},{"A2","B2"},{"A3","B3"}};
		
		DefaultTableModel tableModel = new DefaultTableModel(rowumn,column);
		JTable table = new JTable(tableModel);
		table.setRowSorter(new TableRowSorter<>(tableModel));
		
		
		JScrollPane js = new JScrollPane();
		js.setViewportView(table);
		con.add(js, BorderLayout.CENTER);
		
		this.setSize(300, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	public static void main(String[] args) {
		new TableModel();
	}
}
