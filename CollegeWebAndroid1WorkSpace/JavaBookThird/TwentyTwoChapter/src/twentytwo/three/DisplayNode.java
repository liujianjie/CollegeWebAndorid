package twentytwo.three;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

import twentytwo.two.TestTreeEvent;

public class DisplayNode extends JFrame implements ActionListener{
	DefaultMutableTreeNode root;
	
	public DisplayNode(){
		super("遍历");
		Container con = getContentPane();
		root = new DefaultMutableTreeNode("根节点");
		//创建一级根节点
		DefaultMutableTreeNode dmt1 = new DefaultMutableTreeNode("一级节点A");
		DefaultMutableTreeNode dmt2 = new DefaultMutableTreeNode("一级节点B");
		DefaultMutableTreeNode dmt3 = new DefaultMutableTreeNode("二级子节点A",true);
		DefaultMutableTreeNode dmt4 = new DefaultMutableTreeNode("二级子节点B",true);
		DefaultMutableTreeNode dmt5 = new DefaultMutableTreeNode("二级子节点C",true);
		dmt1.add(dmt3);
		dmt1.add(dmt4);
		dmt2.add(dmt5);
		root.add(dmt1);
		root.add(dmt2);
		
		//非默认判断方式
//		DefaultTreeModel treemodel2 = new DefaultTreeModel(root,true);

		JTree jt3 = new JTree(root);
		con.add(jt3, BorderLayout.WEST);
		
		JPanel jp = new JPanel();
		jp.setLayout(new FlowLayout());
		
		JButton jb1,jb2,jb3,jb4,jb5;
		jb1 = new JButton("按前序遍历节点");
		jb2 = new JButton("按后序遍历节点");
		jb3 = new JButton("以广度优先遍历");
		jb4 = new JButton("以深度优先遍历");
		jb5 = new JButton("遍历直属子节点");
		jp.add(jb1);jp.add(jb2);jp.add(jb3);jp.add(jb4);jp.add(jb5);
		
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jb3.addActionListener(this);
		jb4.addActionListener(this);
		jb5.addActionListener(this);
		
		con.add(jp, BorderLayout.EAST);
		this.setSize(300, 300);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	public static void main(String[] args) {
		DisplayNode st = new DisplayNode();
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Enumeration<?> enumeration;
		String mode = e.getActionCommand();
		if(mode.equals("按前序遍历节点")){
			enumeration = root.preorderEnumeration();
			System.out.println("按前序遍历节点");
		}else if(mode.equals("按后序遍历节点")){
			enumeration = root.postorderEnumeration();
			System.out.println("按后序遍历节点");
		}else if(mode.equals("以广度优先遍历")){
			enumeration = root.breadthFirstEnumeration();
			System.out.println("以广度优先遍历");
		}else if(mode.equals("以深度优先遍历")){
			enumeration = root.depthFirstEnumeration();
			System.out.println("以深度优先遍历");
		}else {
			enumeration = root.children();
		}
		while(enumeration.hasMoreElements()){
				DefaultMutableTreeNode node;
				node = (DefaultMutableTreeNode)enumeration.nextElement();
				
				//根据节点级别输出站位符
				for (int i = 0; i < node.getLevel(); i++){
					System.out.print("----");
				}
				//输出节点标签
				System.out.println(node.getUserObject());
		}
	}
}
