package twentyone.two.three;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

public class MfixedColumnTable extends JPanel{
	private Vector<String> columnNameV; //����������
	private Vector<Vector<String>> tableValueV;// �����������
	private int fixedColumn = 1;// �̶�������
	
	// ģ�Ͷ����������
	// �̶���
	private JTable fixedColumnTable; 
//	private DefaultTableModel fixedcolumntablemodel;
	private FixedColumnTableModel fixedcolumntablemodel;
	// ������
	private JTable floatColumnTable;
//	private DefaultTableModel floatColumnTablemodel;
	private FloatingColumnTableModel floatColumnTablemodel;
	
	public MfixedColumnTable(Vector<String> columnNameV,Vector<Vector<String>> tableValueV, int fixedColumn){
		super();
		setLayout(new BorderLayout());
		this.columnNameV = columnNameV;
		this.tableValueV = tableValueV;// ���̶ܹ��л��߸�������ʵ����ͬһ����񣬵���ʵ����abstractTABLEmodel �Զ����� ������� ����Ļ�ȡ���ַ�������������JFrame����ָ���һ�¶���
		this.fixedColumn = fixedColumn;
		
//		Vector<String> columnNameV1 = new Vector<>();
//		columnNameV1.add("����");
//		Vector<Vector<String>> tableValueV1 = new Vector<>();
//		for(int row = 1; row < 31; row++){
//			Vector<String> rowV1 = new Vector<>();
//			rowV1.add(row+"");// ��һ�еĹ̶�����
//			tableValueV1.add(rowV1);
//		}
//		
//		Vector<String> columnNameV2 = new Vector<>();
//		for(int i = 1; i < 21; i++){
//			columnNameV2.add("��Ʒ"+i);
//		}
//		Vector<Vector<String>> tableValueV2 = new Vector<>();
//		for(int row = 1; row < 31; row++){
//			Vector<String> rowV2 = new Vector<>();
//			for(int col = 0; col < 20; col++){
//				rowV2.add(((int)(Math.random() * 1000))+"");
//			}
//			tableValueV2.add(rowV2);
//		}
		
		//�����̶��б� ���ģ�Ͷ��� �ͱ��
		fixedcolumntablemodel = new FixedColumnTableModel();
//		fixedcolumntablemodel = new DefaultTableModel(tableValueV1,columnNameV1);
		fixedColumnTable = new JTable(fixedcolumntablemodel);
		// ���ѡ��ģ�Ͷ��� �������õ�ѡ
		ListSelectionModel selfix = fixedColumnTable.getSelectionModel();
		selfix.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// ����б�ѡ�е��¼�������
		selfix.addListSelectionListener(new MListSelectionListener(true));
		
		//���������б� ���ģ�Ͷ��� �ͱ��
//		floatColumnTablemodel = new DefaultTableModel(tableValueV2,columnNameV2);
		floatColumnTablemodel = new FloatingColumnTableModel();
		floatColumnTable = new JTable(floatColumnTablemodel);
		// ���ѡ��ģ�Ͷ��� �������õ�ѡ
		ListSelectionModel selfloat = floatColumnTable.getSelectionModel();
		selfloat.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// ����б�ѡ�е��¼�������
		selfloat.addListSelectionListener(new MListSelectionListener(false));
		// �������ƶ��б�����
		floatColumnTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		// ��Jframe������и�����Щ����
		JScrollPane scrollPanel = new JScrollPane(); 
		//���̶��б��ͷ�ŵ������������Ϸ� ����
		scrollPanel.setCorner(JScrollPane.UPPER_LEFT_CORNER, fixedColumnTable.getTableHeader());
		
		// ����һ��������ʾ������Ϣ����ͼ����
		JViewport viewport = new JViewport();
		viewport.setView(fixedColumnTable);// �̶��б���ӵ���ͼ��
		// ������ͼ��СΪ ����С
		viewport.setPreferredSize(fixedColumnTable.getPreferredSize());
		
		// ����ͼ��ӵ��������ı�����ͼ��
		scrollPanel.setRowHeaderView(viewport);
		
		// �����ƶ�������Ĭ����ͼ
		scrollPanel.setViewportView(floatColumnTable);
		add(scrollPanel,BorderLayout.CENTER);
		
		
		
	}
	
	
	private class FixedColumnTableModel extends AbstractTableModel{

		@Override
		public int getColumnCount() {
			return fixedColumn;
		}

		@Override
		public int getRowCount() {
			// TODO Auto-generated method stub
			return tableValueV.size();
		}

		@Override
		public Object getValueAt(int rowindex, int columnindex) {
			// TODO Auto-generated method stub
			return tableValueV.get(rowindex).get(columnindex);
		}
		
		
		// �̶������Ҫ��д�ķ��� ���ع̶���
		@Override
		public String getColumnName(int arg0) {
			// 
			return columnNameV.get(arg0);
		}
		
	}
	
	private class FloatingColumnTableModel extends AbstractTableModel{

		@Override
		public int getColumnCount() {	// ���ؿ��ƶ��е�����
			return columnNameV.size() - fixedColumn; // ��Ҫ�۳��̶��е�����
		}

		@Override
		public int getRowCount() {
			// TODO Auto-generated method stub
			return tableValueV.size();
		}

		@Override
		public Object getValueAt(int rowindex, int columnindex) {
			// TODO Auto-generated method stub
			return tableValueV.get(rowindex).get(columnindex + fixedColumn);// Ϊ�������Ϲ̶��е�����
		}
		// 
		@Override
		public String getColumnName(int arg0) {
			// 
			return columnNameV.get(arg0 + fixedColumn);// ��ҪΪ�������Ϲ̶��е�����
		}
		
		
	}
	//��Ҫһ�� ������ѡ�й̶��е��� ������Ҳ��ѡ��
	private class MListSelectionListener implements ListSelectionListener{

		boolean isFixedColumnTable = true; // Ĭ����ѡ�й̶��б���е��д���
		
		// ���췽�� Ϊis....��Ա������ֵ
		public MListSelectionListener(boolean is) {
			// TODO Auto-generated constructor stub
			isFixedColumnTable = is;
		}
		
		
		@Override
		public void valueChanged(ListSelectionEvent arg0) {
			// TODO Auto-generated method stub
			if(isFixedColumnTable){// ��ѡ�̶��е��д���
				int row = fixedColumnTable.getSelectedRow();
				floatColumnTable.setRowSelectionInterval(row,row);
			} else {// ���ƶ�
				int rwo = floatColumnTable.getSelectedRow();
				fixedColumnTable.setRowSelectionInterval(rwo, rwo);
			}
		}
		
	}
}
