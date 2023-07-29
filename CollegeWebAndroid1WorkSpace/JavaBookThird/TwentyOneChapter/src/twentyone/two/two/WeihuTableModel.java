package twentyone.two.two;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class WeihuTableModel extends JFrame implements ActionListener {
	DefaultTableModel tableModel;
	JTable table;
	JTextField t1, t2;

	public WeihuTableModel() {
		super("维护表格模型");

		Container con = getContentPane();

		String[] column = { "A", "B" };
		String[][] rowumn = { { "A1", "B1" }, { "A2", "B2" }, { "A3", "B3" } };

		tableModel = new DefaultTableModel(rowumn, column);
		table = new JTable(tableModel);
		table.setRowSorter(new TableRowSorter<>(tableModel));

		table.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				// 获得选中行的索引
				int selectRow = table.getSelectedRow();
				// 获取指定单元格的值
				String oa = (String) tableModel.getValueAt(selectRow, 1);
				Object oa2 = tableModel.getValueAt(selectRow, 0);
				t1.setText(oa2.toString());
				t2.setText(oa);
			}
		});
		
		JScrollPane js = new JScrollPane();
		js.setViewportView(table);

		JPanel jp1 = new JPanel();
		t1 = new JTextField(10);
		t2 = new JTextField(10);
		JLabel jl1 = new JLabel("A:");
		JLabel jl2 = new JLabel("B:");
		JButton jb1 = new JButton("添加");
		JButton jb2 = new JButton("修改");
		JButton jb3 = new JButton("删除");

		jp1.setLayout(new FlowLayout());
		jp1.add(jl1);
		jp1.add(t1);
		jp1.add(jl2);
		jp1.add(t2);
		jp1.add(jb1);
		jp1.add(jb2);
		jp1.add(jb3);

		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jb3.addActionListener(this);
		con.add(js, BorderLayout.CENTER);
		con.add(jp1, BorderLayout.SOUTH);
		this.setSize(500, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new WeihuTableModel();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String type = arg0.getActionCommand();
		int selectionRow = table.getSelectedRow();
		String str1 = t1.getText();
		String str2 = t2.getText();
		if (str1.trim() != "" && str2.trim() != "") {
			if (type.equals("添加")) {

				String[] rowvalues = { str1, str2 };
				tableModel.addRow(rowvalues);// 用模型添加
				int rowCount = table.getRowCount() + 1;
				t1.setText("A" + rowCount);
				t2.setText("B" + rowCount);
			} else if (type.equals("修改")) {

				if (selectionRow != -1) {
					tableModel.setValueAt(str1, selectionRow, 0);
					tableModel.setValueAt(str2, selectionRow, 1);
				}

			} else if (type.equals("删除")) {
				if (selectionRow != -1) {
					tableModel.removeRow(selectionRow);
				}
			}
		}
	}
}
