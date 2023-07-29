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
		super("表格");
		
		Container con = getContentPane();
		Vector<Vector<String>> rowdata = new Vector<>();
		Vector<String> columndata = new Vector<>();
		
		for(int i = 0; i < 7; i++){
			columndata.add("标题"+i);
		}
		
		
		for(int i = 0; i < 21; i++){
			Vector<String> vec = new Vector<>();
			for(int j = 0; j < 7; j++){
				vec.add("数据"+j);
			}
			rowdata.add(vec);
		}
		
		JTable table = new Mytable(rowdata, columndata);
		
		// 5.关闭表格自动调整功能
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		// 4.选择模式为单选
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		// 被选择行的背景颜色为黄色
		table.setSelectionBackground(Color.YELLOW);
		
		// 被选择行的前景色 （文字颜色）为红色
		table.setSelectionForeground(Color.RED);
		table.setRowHeight(30); // 行高 30
		
		// 将表格添加到边界布局的中间，不添加到jscrollpane上 将不会出现表头，因为表头被覆盖了
		con.add(table, BorderLayout.CENTER);
		// 将表格头添加到边界布局的上方
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
		
		// 构造方法 创建表格行列
		public Mytable(Vector<Vector<String>> rowData, Vector<String> columnNames){
			super(rowData,columnNames);
		}
		
		@Override
		public JTableHeader getTableHeader() {
			// TODO Auto-generated method stub
			
			// 3.获得表格头的对象
			JTableHeader tableheader = super.getTableHeader();
			tableheader.setReorderingAllowed(false);// 3.设置表格不可重排
			// 表格头的单元格对象
			DefaultTableCellRenderer hr = (DefaultTableCellRenderer) tableheader.getDefaultRenderer();
			// 设置列名居中 2
			hr.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
			
			return tableheader;
		}
		
		@Override
		public TableCellRenderer getDefaultRenderer(Class<?> arg0) {
			// TODO Auto-generated method stub
			
			// 获得表格的单元格对象
			DefaultTableCellRenderer cr = (DefaultTableCellRenderer) super.getDefaultRenderer(arg0);
			
			// 设置单元格内容居中显示
			cr.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
			
			return cr;
		}
		@Override
		public boolean isCellEditable(int arg0, int arg1) {
			// 1.表格不可编辑
			return false;
		}
	}
	
}
