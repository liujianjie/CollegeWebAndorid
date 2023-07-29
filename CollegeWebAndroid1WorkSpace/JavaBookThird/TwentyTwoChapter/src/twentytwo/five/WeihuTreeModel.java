package twentytwo.five;

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
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;


public class WeihuTreeModel extends JFrame implements ActionListener{
	TreeSelectionModel treeselectmodel;
	DefaultTreeModel treemodel2;
	JTextField jt1;JTree jt3;
	public WeihuTreeModel(){
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
		
		JPanel jp1 = new JPanel();
		jp1.setLayout(new FlowLayout());
		
		jt1 = new JTextField(15);
		jp1.add(jt1);
		
		JButton jb1 = new JButton("���");jb1.addActionListener(this);
		JButton jb2 = new JButton("�޸�");jb2.addActionListener(this);
		JButton jb3 = new JButton("ɾ��");jb3.addActionListener(this);
		jp1.add(jb1);
		jp1.add(jb2);
		jp1.add(jb3);
		
		con.add(jp1,BorderLayout.SOUTH);
		this.setSize(400, 300);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {
		WeihuTreeModel st = new WeihuTreeModel();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String selectAction = e.getActionCommand();
		if(selectAction.equals("���")){
			String text = jt1.getText();
			if(!(text.equals(""))){
				DefaultMutableTreeNode node = new DefaultMutableTreeNode(text);// �½ڵ�
				TreePath sele = jt3.getSelectionPath();// ���ѡ�еĸ��ڵ�·��
				System.out.println(sele);
				
				DefaultMutableTreeNode parentNode = (DefaultMutableTreeNode)
						sele.getLastPathComponent();// ���ѡ�еĸ��ڵ�
				System.out.println(parentNode.getUserObject());
				treemodel2.insertNodeInto(node, parentNode, parentNode.getChildCount());
				
				//�������ӽڵ��·��
				TreePath path = sele.pathByAddingChild(node);
//				System.out.println(path + "isvisible :"+jt3.isVisible(path));
				if(!jt3.isVisible(path))
					jt3.makeVisible(path);/// ����ýڵ㲻�ɼ�������Ϊ�ɼ�
			}
		} else if(selectAction.equals("�޸�")){
			String text = jt1.getText();
			if(!(text.equals(""))){
				TreePath treepath = jt3.getSelectionPath();//���ѡ�еĽڵ�
				DefaultMutableTreeNode setnode = (DefaultMutableTreeNode) treepath.getLastPathComponent();
				setnode.setUserObject(text);
				treemodel2.nodeChanged(setnode);
				jt3.setSelectionPath(treepath);
			}
		} else if(selectAction.equals("ɾ��")){
			TreePath treepath = jt3.getSelectionPath(); 
			DefaultMutableTreeNode getnode = (DefaultMutableTreeNode) 
					treepath.getLastPathComponent();
			if(!getnode.isRoot()){
				DefaultMutableTreeNode nextsibnode = (DefaultMutableTreeNode) getnode.getNextSibling(); // ��һ���ڵ���ѡ�нڵ�
				if(nextsibnode == null){
					nextsibnode  = (DefaultMutableTreeNode) getnode.getParent(); // �����ھ�ѡ�񸸽ڵ�
				}
				treemodel2.removeNodeFromParent(getnode);
				jt3.setSelectionPath(new TreePath(nextsibnode.getPath()));
			}
			
		}
	}
}
