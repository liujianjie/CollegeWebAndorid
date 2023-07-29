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
		super("维护树");
		
		Container con = getContentPane();
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("根节点");
		//创建一级根节点
		DefaultMutableTreeNode dmt1 = new DefaultMutableTreeNode("一级节点A");
		DefaultMutableTreeNode dmt2 = new DefaultMutableTreeNode("一级节点B");
		DefaultMutableTreeNode dmt4 = new DefaultMutableTreeNode("一级节点C");
		DefaultMutableTreeNode dmt5 = new DefaultMutableTreeNode("一级节点D");
		DefaultMutableTreeNode dmt6 = new DefaultMutableTreeNode("二级子节点A",true);
		DefaultMutableTreeNode dmt7 = new DefaultMutableTreeNode("一级子节点B",true);
		DefaultMutableTreeNode dmt8 = new DefaultMutableTreeNode("一级子节点C",true);
		DefaultMutableTreeNode dmt9 = new DefaultMutableTreeNode("二级子节点D",true);
		DefaultMutableTreeNode dmt10 = new DefaultMutableTreeNode("二级子节点E",true);
		DefaultMutableTreeNode dmt11 = new DefaultMutableTreeNode("二级子节点F",true);
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
				// 创建该节点的路径
				TreePath path = new TreePath(node.getPath());
				System.out.println(path);
				jt3.expandPath(path);
			}
		}
		
		treeselectmodel = jt3.getSelectionModel();
		treeselectmodel.setSelectionMode(2);//连续
		
		JPanel jp1 = new JPanel();
		jp1.setLayout(new FlowLayout());
		
		jt1 = new JTextField(15);
		jp1.add(jt1);
		
		JButton jb1 = new JButton("添加");jb1.addActionListener(this);
		JButton jb2 = new JButton("修改");jb2.addActionListener(this);
		JButton jb3 = new JButton("删除");jb3.addActionListener(this);
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
		if(selectAction.equals("添加")){
			String text = jt1.getText();
			if(!(text.equals(""))){
				DefaultMutableTreeNode node = new DefaultMutableTreeNode(text);// 新节点
				TreePath sele = jt3.getSelectionPath();// 获得选中的父节点路径
				System.out.println(sele);
				
				DefaultMutableTreeNode parentNode = (DefaultMutableTreeNode)
						sele.getLastPathComponent();// 获得选中的父节点
				System.out.println(parentNode.getUserObject());
				treemodel2.insertNodeInto(node, parentNode, parentNode.getChildCount());
				
				//获得新添加节点的路径
				TreePath path = sele.pathByAddingChild(node);
//				System.out.println(path + "isvisible :"+jt3.isVisible(path));
				if(!jt3.isVisible(path))
					jt3.makeVisible(path);/// 如果该节点不可见，设置为可见
			}
		} else if(selectAction.equals("修改")){
			String text = jt1.getText();
			if(!(text.equals(""))){
				TreePath treepath = jt3.getSelectionPath();//获得选中的节点
				DefaultMutableTreeNode setnode = (DefaultMutableTreeNode) treepath.getLastPathComponent();
				setnode.setUserObject(text);
				treemodel2.nodeChanged(setnode);
				jt3.setSelectionPath(treepath);
			}
		} else if(selectAction.equals("删除")){
			TreePath treepath = jt3.getSelectionPath(); 
			DefaultMutableTreeNode getnode = (DefaultMutableTreeNode) 
					treepath.getLastPathComponent();
			if(!getnode.isRoot()){
				DefaultMutableTreeNode nextsibnode = (DefaultMutableTreeNode) getnode.getNextSibling(); // 下一个节点做选中节点
				if(nextsibnode == null){
					nextsibnode  = (DefaultMutableTreeNode) getnode.getParent(); // 不存在就选择父节点
				}
				treemodel2.removeNodeFromParent(getnode);
				jt3.setSelectionPath(new TreePath(nextsibnode.getPath()));
			}
			
		}
	}
}
