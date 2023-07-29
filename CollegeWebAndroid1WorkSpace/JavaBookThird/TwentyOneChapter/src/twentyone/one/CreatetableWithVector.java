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
		super("���");
		
		Container con = getContentPane();
		Vector<Vector<String>> rowdata = new Vector<>();
		Vector<String> columndata = new Vector<>();
		
		for(int i = 0; i < 3; i++){
			columndata.add("����"+i);
		}
		
		
		for(int i = 0; i < 5; i++){
			Vector<String> vec = new Vector<>();
			for(int j = 0; j < 3; j++){
				vec.add("����"+j);
			}
			rowdata.add(vec);
		}
		
		JTable jt = new JTable(rowdata, columndata);
//		JScrollPane jsp = new JScrollPane(jt);
//		con.add(jsp, BorderLayout.CENTER);
		
		// �������ӵ��߽粼�ֵ��м䣬����ӵ�jscrollpane�� ��������ֱ�ͷ����Ϊ��ͷ��������
		con.add(jt, BorderLayout.CENTER);
		// �����ͷ��ӵ��߽粼�ֵ��Ϸ�
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
