package twenty.six;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Enumeration;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.event.TreeExpansionEvent;
import javax.swing.event.TreeExpansionListener;
import javax.swing.event.TreeWillExpandListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.ExpandVetoException;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;


public class ChuliTreeModel extends JFrame implements TreeExpansionListener,TreeWillExpandListener{
	TreeSelectionModel treeselectmodel;
	DefaultTreeModel treemodel2;
	JTextField jt1;JTree jt3;
	public ChuliTreeModel(){
		super("ά����");
		
		Container con = getContentPane();
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("���ڵ�");
		//����һ�����ڵ�
		DefaultMutableTreeNode dmt1 = new DefaultMutableTreeNode("һ���ڵ�A");
		DefaultMutableTreeNode dmt2 = new DefaultMutableTreeNode("һ���ڵ�B");
		DefaultMutableTreeNode dmt4 = new DefaultMutableTreeNode("һ���ڵ�C");
		DefaultMutableTreeNode dmt5 = new DefaultMutableTreeNode("һ���ڵ�D");
		DefaultMutableTreeNode dmt6 = new DefaultMutableTreeNode("�����ӽڵ�A",true);
		DefaultMutableTreeNode dmt7 = new DefaultMutableTreeNode("һ���ӽڵ�B",true);
		DefaultMutableTreeNode dmt8 = new DefaultMutableTreeNode("һ���ӽڵ�C",true);
		DefaultMutableTreeNode dmt9 = new DefaultMutableTreeNode("�����ӽڵ�D",true);
		DefaultMutableTreeNode dmt10 = new DefaultMutableTreeNode("�����ӽڵ�E",true);
		DefaultMutableTreeNode dmt11 = new DefaultMutableTreeNode("�����ӽڵ�F",true);
		dmt1.add(dmt4);
		dmt1.add(dmt5);
		dmt2.add(dmt6);
		dmt9.add(dmt10);
		dmt9.add(dmt11);
		
		root.add(dmt1);
		root.add(dmt2);
		root.add(dmt7);
		root.add(dmt8);
		root.add(dmt9);
		
		treemodel2 = new DefaultTreeModel(root,false);
		
		jt3 = new JTree(treemodel2);
		con.add(jt3, BorderLayout.CENTER);
		jt3.setShowsRootHandles(true);
		
		// ���չ�����������
		jt3.addTreeExpansionListener(this);
		jt3.addTreeWillExpandListener(this);
			
		
		Enumeration<?> enumeration;
		enumeration = root.preorderEnumeration();
		while(enumeration.hasMoreElements()){
			DefaultMutableTreeNode node;
			node = (DefaultMutableTreeNode) enumeration.nextElement();
			if(!node.isLeaf()){
				// �����ýڵ��·��
				TreePath path = new TreePath(node.getPath());
				System.out.println(path);
				jt3.expandPath(path);
			}
		}
		
		treeselectmodel = jt3.getSelectionModel();
		treeselectmodel.setSelectionMode(2);//����
		
		this.setSize(400, 300);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {
		ChuliTreeModel st = new ChuliTreeModel();
		
	}

	// ��Ҫ��
	@Override
	public void treeWillCollapse(TreeExpansionEvent event) throws ExpandVetoException {
		// TODO Auto-generated method stub
		TreePath path = event.getPath();
		DefaultMutableTreeNode node =  (DefaultMutableTreeNode) path.getLastPathComponent();
		System.out.println("�ڵ� "+node+"��Ҫ�ر�");
	}

	@Override
	public void treeWillExpand(TreeExpansionEvent event) throws ExpandVetoException {
		// TODO Auto-generated method stub
		TreePath path = event.getPath();
		DefaultMutableTreeNode node =  (DefaultMutableTreeNode) path.getLastPathComponent();
		System.out.println("�ڵ� "+node+"��Ҫչ��");
	}
 
	// �Ѿ��ر�
	@Override
	public void treeCollapsed(TreeExpansionEvent event) {
		// TODO Auto-generated method stub
		TreePath path = event.getPath();
		DefaultMutableTreeNode node =  (DefaultMutableTreeNode) path.getLastPathComponent();
		System.out.println("�ڵ� "+node+"�Ѿ��ر�");
	}

	@Override
	public void treeExpanded(TreeExpansionEvent event) {
		// TODO Auto-generated method stub
		TreePath path = event.getPath();
		DefaultMutableTreeNode node =  (DefaultMutableTreeNode) path.getLastPathComponent();
		System.out.println("�ڵ� "+node+"�Ѿ�չ��");
	}

}
