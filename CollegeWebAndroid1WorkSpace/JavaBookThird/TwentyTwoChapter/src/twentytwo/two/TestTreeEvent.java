package twentytwo.two;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;


public class TestTreeEvent extends JFrame{
	TreeSelectionModel treeselectmodel;
	public TestTreeEvent(){
		super("简单的树 处理选中节点事件");
		
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
		
		treeselectmodel = jt3.getSelectionModel();
		treeselectmodel.setSelectionMode(2);//连续
		
		jt3.addTreeSelectionListener(new TreeSelectionListener() {
			
			@Override
			public void valueChanged(TreeSelectionEvent e) {
				// TODO Auto-generated method stub
				if(!jt3.isSelectionEmpty()){
					// 获得所有被选中节点的路径
					TreePath[] treePath = jt3.getSelectionPaths();
					for(int i = 0; i < treePath.length; i++){
						TreePath treep = treePath[i];
						//以object数组形式返回该路径中的所有节点对象
						Object[] ob = treep.getPath();
						for(int j = 0; j < ob.length; j++){
							DefaultMutableTreeNode node;
									node = (DefaultMutableTreeNode) ob[j];//这里小心别写错
							String s = node.getUserObject()+(j == (ob.length - 1) ? "" :"--->");
							System.out.print(s);
						}
						System.out.println();
					}
					System.out.println();
				}
			}
		});
		
		
		this.setSize(300, 300);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {
		TestTreeEvent st = new TestTreeEvent();
		
	}
}
