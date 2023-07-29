package twenty.four;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.net.URL;
import java.util.Enumeration;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

public class SetTreenode extends JFrame{
	TreeSelectionModel treeselectmodel;
	
	public SetTreenode(){
		super("定制树");
		
		Container con = getContentPane();
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("根节点");
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
		con.add(jt3, BorderLayout.CENTER);
		jt3.setShowsRootHandles(true);
//		jt3.setRootVisible(false);
		jt3.setRowHeight(20);
		jt3.setFont(new Font("宋体", Font.BOLD, 14));
		jt3.putClientProperty("JTree.lineStyle", "None");
		
		URL url = SetTreenode.class.getResource("1.jpg");
		Icon ic1 = new ImageIcon(url);
		DefaultTreeCellRenderer treecell = (DefaultTreeCellRenderer) jt3.getCellRenderer();
		treecell.setLeafIcon(null);
		treecell.setClosedIcon(null);
		treecell.setOpenIcon(ic1);
		
		Enumeration<?> enumeration;
		enumeration = root.preorderEnumeration();
		while(enumeration.hasMoreElements()){
			DefaultMutableTreeNode node;
			node = (DefaultMutableTreeNode) enumeration.nextElement();
			if(!node.isLeaf()){
				// 创建该节点的路径
				TreePath path = new TreePath(node.getPath());
				System.out.println(path);
				jt3.expandPath(path);
			}
		}
		
		treeselectmodel = jt3.getSelectionModel();
		treeselectmodel.setSelectionMode(2);//连续
		
		this.setSize(300, 300);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {
		SetTreenode st = new SetTreenode();
		
	}
}
