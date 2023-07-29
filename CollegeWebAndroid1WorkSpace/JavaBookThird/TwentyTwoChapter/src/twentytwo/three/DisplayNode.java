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
		super("����");
		Container con = getContentPane();
		root = new DefaultMutableTreeNode("���ڵ�");
		//����һ�����ڵ�
		DefaultMutableTreeNode dmt1 = new DefaultMutableTreeNode("һ���ڵ�A");
		DefaultMutableTreeNode dmt2 = new DefaultMutableTreeNode("һ���ڵ�B");
		DefaultMutableTreeNode dmt3 = new DefaultMutableTreeNode("�����ӽڵ�A",true);
		DefaultMutableTreeNode dmt4 = new DefaultMutableTreeNode("�����ӽڵ�B",true);
		DefaultMutableTreeNode dmt5 = new DefaultMutableTreeNode("�����ӽڵ�C",true);
		dmt1.add(dmt3);
		dmt1.add(dmt4);
		dmt2.add(dmt5);
		root.add(dmt1);
		root.add(dmt2);
		
		//��Ĭ���жϷ�ʽ
//		DefaultTreeModel treemodel2 = new DefaultTreeModel(root,true);

		JTree jt3 = new JTree(root);
		con.add(jt3, BorderLayout.WEST);
		
		JPanel jp = new JPanel();
		jp.setLayout(new FlowLayout());
		
		JButton jb1,jb2,jb3,jb4,jb5;
		jb1 = new JButton("��ǰ������ڵ�");
		jb2 = new JButton("����������ڵ�");
		jb3 = new JButton("�Թ�����ȱ���");
		jb4 = new JButton("��������ȱ���");
		jb5 = new JButton("����ֱ���ӽڵ�");
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
		if(mode.equals("��ǰ������ڵ�")){
			enumeration = root.preorderEnumeration();
			System.out.println("��ǰ������ڵ�");
		}else if(mode.equals("����������ڵ�")){
			enumeration = root.postorderEnumeration();
			System.out.println("����������ڵ�");
		}else if(mode.equals("�Թ�����ȱ���")){
			enumeration = root.breadthFirstEnumeration();
			System.out.println("�Թ�����ȱ���");
		}else if(mode.equals("��������ȱ���")){
			enumeration = root.depthFirstEnumeration();
			System.out.println("��������ȱ���");
		}else {
			enumeration = root.children();
		}
		while(enumeration.hasMoreElements()){
				DefaultMutableTreeNode node;
				node = (DefaultMutableTreeNode)enumeration.nextElement();
				
				//���ݽڵ㼶�����վλ��
				for (int i = 0; i < node.getLevel(); i++){
					System.out.print("----");
				}
				//����ڵ��ǩ
				System.out.println(node.getUserObject());
		}
	}
}
