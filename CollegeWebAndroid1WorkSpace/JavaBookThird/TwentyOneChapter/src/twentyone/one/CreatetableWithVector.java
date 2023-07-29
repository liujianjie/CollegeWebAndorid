package twentyone.one;

import java.awt.BorderLayout;
import java.awt.Container;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;

public class CreatetableWithVector  extends JFrame{
	public CreatetableWithVector(){
		super("表格");
		
		Container con = getContentPane();
		Vector<Vector<String>> rowdata = new Vector<>();
		Vector<String> columndata = new Vector<>();
		
		for(int i = 0; i < 3; i++){
			columndata.add("标题"+i);
		}
		
		
		for(int i = 0; i < 5; i++){
			Vector<String> vec = new Vector<>();
			for(int j = 0; j < 3; j++){
				vec.add("数据"+j);
			}
			rowdata.add(vec);
		}
		
		JTable jt = new JTable(rowdata, columndata);
//		JScrollPane jsp = new JScrollPane(jt);
//		con.add(jsp, BorderLayout.CENTER);
		
		// 将表格添加到边界布局的中间，不添加到jscrollpane上 将不会出现表头，因为表头被覆盖了
		con.add(jt, BorderLayout.CENTER);
		// 将表格头添加到边界布局的上方
		JTableHeader jth = jt.getTableHeader();
		con.add(jth, BorderLayout.NORTH);

		this.setVisible(true);
		this.setSize(300,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	public static void main(String[] args) {
		new CreatetableWithVector();
	}
	
}
