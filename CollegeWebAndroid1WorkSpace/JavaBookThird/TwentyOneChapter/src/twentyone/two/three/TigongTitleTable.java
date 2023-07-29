package twentyone.two.three;

import java.awt.BorderLayout;
import java.util.Vector;

import javax.swing.JFrame;

public class TigongTitleTable extends JFrame{
	MfixedColumnTable MF;
	public TigongTitleTable(){
		super("�Զ��帡���͹̶����");
		Vector<String> columnNameV = new Vector<>();
		columnNameV.add("����");
		for(int i = 1; i < 21; i++){
			columnNameV.add("��Ʒ"+i);
		}
		Vector<Vector<String>> tableValueV = new Vector<>();
		for(int row = 1; row < 31; row++){
			Vector<String> rowV = new Vector<>();
			rowV.add(row+"");// ��һ�еĹ̶�����
			for(int col = 0; col < 20; col++){
				rowV.add(((int)(Math.random() * 1000))+"");
			}
			tableValueV.add(rowV);
		}
		MF = new MfixedColumnTable(columnNameV, tableValueV, 1);
		getContentPane().add(MF, BorderLayout.CENTER);
		
		setSize(400,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		new TigongTitleTable();
	}
}

