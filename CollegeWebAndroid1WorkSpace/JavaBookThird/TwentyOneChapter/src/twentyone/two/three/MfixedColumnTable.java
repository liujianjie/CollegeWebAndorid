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
	private Vector<String> columnNameV; //表格表名数组
	private Vector<Vector<String>> tableValueV;// 表格数据数组
	private int fixedColumn = 1;// 固定列数量
	
	// 模型对象与表格对象
	// 固定的
	private JTable fixedColumnTable; 
//	private DefaultTableModel fixedcolumntablemodel;
	private FixedColumnTableModel fixedcolumntablemodel;
	// 浮动的
	private JTable floatColumnTable;
//	private DefaultTableModel floatColumnTablemodel;
	private FloatingColumnTableModel floatColumnTablemodel;
	
	public MfixedColumnTable(Vector<String> columnNameV,Vector<Vector<String>> tableValueV, int fixedColumn){
		super();
		setLayout(new BorderLayout());
		this.columnNameV = columnNameV;
		this.tableValueV = tableValueV;// 不管固定列或者浮动列其实属于同一个表格，但是实现了abstractTABLEmodel 自定义了 两个表格 定义的获取各种方法，并且利用JFrame组件分割了一下而已
		this.fixedColumn = fixedColumn;
		
//		Vector<String> columnNameV1 = new Vector<>();
//		columnNameV1.add("日期");
//		Vector<Vector<String>> tableValueV1 = new Vector<>();
//		for(int row = 1; row < 31; row++){
//			Vector<String> rowV1 = new Vector<>();
//			rowV1.add(row+"");// 第一列的固定数据
//			tableValueV1.add(rowV1);
//		}
//		
//		Vector<String> columnNameV2 = new Vector<>();
//		for(int i = 1; i < 21; i++){
//			columnNameV2.add("商品"+i);
//		}
//		Vector<Vector<String>> tableValueV2 = new Vector<>();
//		for(int row = 1; row < 31; row++){
//			Vector<String> rowV2 = new Vector<>();
//			for(int col = 0; col < 20; col++){
//				rowV2.add(((int)(Math.random() * 1000))+"");
//			}
//			tableValueV2.add(rowV2);
//		}
		
		//创建固定列表 表格模型对象 和表格
		fixedcolumntablemodel = new FixedColumnTableModel();
//		fixedcolumntablemodel = new DefaultTableModel(tableValueV1,columnNameV1);
		fixedColumnTable = new JTable(fixedcolumntablemodel);
		// 获得选择模型对象 进行设置单选
		ListSelectionModel selfix = fixedColumnTable.getSelectionModel();
		selfix.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// 添加行被选中的事件监听器
		selfix.addListSelectionListener(new MListSelectionListener(true));
		
		//创建浮动列表 表格模型对象 和表格
//		floatColumnTablemodel = new DefaultTableModel(tableValueV2,columnNameV2);
		floatColumnTablemodel = new FloatingColumnTableModel();
		floatColumnTable = new JTable(floatColumnTablemodel);
		// 获得选择模型对象 进行设置单选
		ListSelectionModel selfloat = floatColumnTable.getSelectionModel();
		selfloat.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// 添加行被选中的事件监听器
		selfloat.addListSelectionListener(new MListSelectionListener(false));
		// 创建可移动列表格对象
		floatColumnTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		// 用Jframe组件进行隔离这些操作
		JScrollPane scrollPanel = new JScrollPane(); 
		//将固定列表格头放到滚动面板的左上方 角落
		scrollPanel.setCorner(JScrollPane.UPPER_LEFT_CORNER, fixedColumnTable.getTableHeader());
		
		// 创建一个用来显示基础信息的试图对象
		JViewport viewport = new JViewport();
		viewport.setView(fixedColumnTable);// 固定列表添加到试图中
		// 设置试图大小为 表格大小
		viewport.setPreferredSize(fixedColumnTable.getPreferredSize());
		
		// 将试图添加到滚动面板的标题试图中
		scrollPanel.setRowHeaderView(viewport);
		
		// 将可移动表格添加默认试图
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
		
		
		// 固定表格需要重写的方法 返回固定列
		@Override
		public String getColumnName(int arg0) {
			// 
			return columnNameV.get(arg0);
		}
		
	}
	
	private class FloatingColumnTableModel extends AbstractTableModel{

		@Override
		public int getColumnCount() {	// 返回可移动列的数量
			return columnNameV.size() - fixedColumn; // 需要扣除固定列的数量
		}

		@Override
		public int getRowCount() {
			// TODO Auto-generated method stub
			return tableValueV.size();
		}

		@Override
		public Object getValueAt(int rowindex, int columnindex) {
			// TODO Auto-generated method stub
			return tableValueV.get(rowindex).get(columnindex + fixedColumn);// 为索引加上固定列的数量
		}
		// 
		@Override
		public String getColumnName(int arg0) {
			// 
			return columnNameV.get(arg0 + fixedColumn);// 需要为索引加上固定列的数量
		}
		
		
	}
	//需要一个 监听，选中固定列的行 浮动行也该选中
	private class MListSelectionListener implements ListSelectionListener{

		boolean isFixedColumnTable = true; // 默认由选中固定列表格中的行触发
		
		// 构造方法 为is....成员变量赋值
		public MListSelectionListener(boolean is) {
			// TODO Auto-generated constructor stub
			isFixedColumnTable = is;
		}
		
		
		@Override
		public void valueChanged(ListSelectionEvent arg0) {
			// TODO Auto-generated method stub
			if(isFixedColumnTable){// 由选固定列的行触发
				int row = fixedColumnTable.getSelectedRow();
				floatColumnTable.setRowSelectionInterval(row,row);
			} else {// 由移动
				int rwo = floatColumnTable.getSelectedRow();
				fixedColumnTable.setRowSelectionInterval(rwo, rwo);
			}
		}
		
	}
}
