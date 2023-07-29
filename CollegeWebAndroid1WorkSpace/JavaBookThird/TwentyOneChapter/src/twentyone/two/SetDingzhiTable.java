package twentyone.two;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.ScrollPane;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

public class SetDingzhiTable  extends JFrame{
	public SetDingzhiTable(){
		super("���");
		
		Container con = getContentPane();
		Vector<Vector<String>> rowdata = new Vector<>();
		Vector<String> columndata = new Vector<>();
		
		for(int i = 0; i < 7; i++){
			columndata.add("����"+i);
		}
		
		
		for(int i = 0; i < 21; i++){
			Vector<String> vec = new Vector<>();
			for(int j = 0; j < 7; j++){
				vec.add("����"+j);
			}
			rowdata.add(vec);
		}
		
		JTable table = new Mytable(rowdata, columndata);
		
		// 5.�رձ���Զ���������
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		// 4.ѡ��ģʽΪ��ѡ
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		// ��ѡ���еı�����ɫΪ��ɫ
		table.setSelectionBackground(Color.YELLOW);
		
		// ��ѡ���е�ǰ��ɫ ��������ɫ��Ϊ��ɫ
		table.setSelectionForeground(Color.RED);
		table.setRowHeight(30); // �и� 30
		
		// �������ӵ��߽粼�ֵ��м䣬����ӵ�jscrollpane�� ��������ֱ�ͷ����Ϊ��ͷ��������
		con.add(table, BorderLayout.CENTER);
		// �����ͷ��ӵ��߽粼�ֵ��Ϸ�
		JTableHeader jth = table.getTableHeader();
		con.add(jth, BorderLayout.NORTH);
		
		final JScrollPane scrollPane = new JScrollPane();
		con.add(scrollPane, BorderLayout.CENTER);
		scrollPane.setViewportView(table);
		
		
//		JScrollPane jsp = new JScrollPane(jt);
//		con.add(jsp, BorderLayout.CENTER);

		this.setVisible(true);
		this.setSize(500,375);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	public static void main(String[] args) {
		new SetDingzhiTable();
	}
	
	class Mytable extends JTable{
		
		// ���췽�� �����������
		public Mytable(Vector<Vector<String>> rowData, Vector<String> columnNames){
			super(rowData,columnNames);
		}
		
		@Override
		public JTableHeader getTableHeader() {
			// TODO Auto-generated method stub
			
			// 3.��ñ��ͷ�Ķ���
			JTableHeader tableheader = super.getTableHeader();
			tableheader.setReorderingAllowed(false);// 3.���ñ�񲻿�����
			// ���ͷ�ĵ�Ԫ�����
			DefaultTableCellRenderer hr = (DefaultTableCellRenderer) tableheader.getDefaultRenderer();
			// ������������ 2
			hr.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
			
			return tableheader;
		}
		
		@Override
		public TableCellRenderer getDefaultRenderer(Class<?> arg0) {
			// TODO Auto-generated method stub
			
			// ��ñ��ĵ�Ԫ�����
			DefaultTableCellRenderer cr = (DefaultTableCellRenderer) super.getDefaultRenderer(arg0);
			
			// ���õ�Ԫ�����ݾ�����ʾ
			cr.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
			
			return cr;
		}
		@Override
		public boolean isCellEditable(int arg0, int arg1) {
			// 1.��񲻿ɱ༭
			return false;
		}
	}
	
}
