package twentytwo.one;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class SimplyTree extends JFrame{
	public SimplyTree(){
		super("�򵥵���");
		
		Container con = getContentPane();
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("���ڵ�");
		//����һ�����ڵ�
		DefaultMutableTreeNode dmt1 = new DefaultMutableTreeNode("һ���ڵ�A");
		DefaultMutableTreeNode dmt2 = new DefaultMutableTreeNode("һ���ڵ�B");
		DefaultMutableTreeNode twoth = new DefaultMutableTreeNode("�����ӽڵ�",false);
		
		dmt1.add(twoth);
		root.add(dmt1);
		root.add(dmt2);
		JTree jt = new JTree(root);
		con.add(jt, BorderLayout.WEST);
		//��DefaultTreeModel
		DefaultTreeModel treemodel = new DefaultTreeModel(root);

		JTree jt2 = new JTree(treemodel);
		con.add(jt2, BorderLayout.CENTER);
		
		//��Ĭ���жϷ�ʽ
		DefaultTreeModel treemodel2 = new DefaultTreeModel(root,true);

		JTree jt3 = new JTree(treemodel2);
		con.add(jt3, BorderLayout.EAST);
		
		this.setSize(300, 300);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {
		SimplyTree st = new SimplyTree();
		
	}
}
