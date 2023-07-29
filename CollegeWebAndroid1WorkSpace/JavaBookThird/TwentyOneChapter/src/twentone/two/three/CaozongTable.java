package twentone.two.three;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

public class CaozongTable  extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CaozongTable(){
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
		
		JTable table = new JTable(rowdata, columndata);
		
		// 5.�رձ���Զ���������
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		// 4.ѡ��ģʽΪ��ѡ
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		
		// ��ѡ���еı�����ɫΪ��ɫ
		table.setSelectionBackground(Color.YELLOW);
		
		// ��ѡ���е�ǰ��ɫ ��������ɫ��Ϊ��ɫ
		table.setSelectionForeground(Color.RED);
		table.setRowHeight(30); // �и� 30
				
		//���ݱ�������� ��ע����Ȱ� ���ѡ��ģʽ������ȥ ���� ��ѡ����Ȼ����
		table.setRowSelectionInterval(1, 3);
		table.addRowSelectionInterval(5, 5);
		final JScrollPane scrollPane = new JScrollPane();
		con.add(scrollPane, BorderLayout.CENTER);
		scrollPane.setViewportView(table);
		
		
		
		JButton b1 = new JButton("ȫ��ѡ��");
		JButton b2 = new JButton("ȡ��ѡ��");
		
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				table.selectAll();
			}
		});
		b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				table.clearSelection();
			}
		});
		System.out.println("����У�"+table.getRowCount()+"��"+table.getColumnCount()+"��");
		System.out.println("����У�"+table.getSelectedRowCount()+"�б�ѡ��");
		System.out.println("�����е�ѡ��״̬Ϊ��"+table.isRowSelected(2));
		System.out.println("��5�е�ѡ��״̬Ϊ��"+table.isRowSelected(4));
		System.out.println("��ѡ�е�һ�е������ǣ�"+table.getSelectedRow());//*
		//���б�ѡ���е�����
		int [] selectindex = table.getSelectedRows();//*
		System.out.println("���б�ѡ���е�������");
		for(int row = 0; row < selectindex.length; row++){
			System.out.print(selectindex[row] + " ");
		}
		System.out.println();
		
		System.out.println("���ƶ�ǰ��2�е������ǣ�"+table.getColumnName(1));
		System.out.println("���ƶ�ǰ��2�е�2�е�ֵ�ǣ�"+table.getValueAt(1,1));
		
		System.out.println("����2���Ƶ���6��ȥ");
		table.move(1, 5);//*
		System.out.println("���ƶ����2�е������ǣ�"+table.getColumnName(1));
		System.out.println("���ƶ����2�е�2�е�ֵ�ǣ�"+table.getValueAt(1,1));
		
		// �������ӵ��߽粼�ֵ��м䣬����ӵ�jscrollpane�� ��������ֱ�ͷ����Ϊ��ͷ��������
		con.add(table, BorderLayout.CENTER);
		// �����ͷ��ӵ��߽粼�ֵ��Ϸ�
		JTableHeader jth = table.getTableHeader();
		con.add(jth, BorderLayout.NORTH);
		
		JPanel jp1 = new JPanel();
		jp1.add(b1);
		jp1.add(b2);
		jp1.setLayout(new FlowLayout());
		con.add(jp1, BorderLayout.SOUTH);
		
		this.setVisible(true);
		this.setSize(500,375);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	public static void main(String[] args) {
		new CaozongTable();
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

