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
		super("简单的树");
		
		Container con = getContentPane();
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("根节点");
		//创建一级根节点
		DefaultMutableTreeNode dmt1 = new DefaultMutableTreeNode("一级节点A");
		DefaultMutableTreeNode dmt2 = new DefaultMutableTreeNode("一级节点B");
		DefaultMutableTreeNode twoth = new DefaultMutableTreeNode("二级子节点",false);
		
		dmt1.add(twoth);
		root.add(dmt1);
		root.add(dmt2);
		JTree jt = new JTree(root);
		con.add(jt, BorderLayout.WEST);
		//用DefaultTreeModel
		DefaultTreeModel treemodel = new DefaultTreeModel(root);

		JTree jt2 = new JTree(treemodel);
		con.add(jt2, BorderLayout.CENTER);
		
		//非默认判断方式
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
