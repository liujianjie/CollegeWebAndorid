package com.javatest.NodeA;  
  
/** 
 * Created by Joker on 2017/5/27. 
 */  
public class Test {  
  
    public static  void main(String args[]){  
  
        Node root = new Node("��Ӱ");  
        Node A = new Node("�ƻõ�Ӱ");  
        Node Aa = new Node("̫�տƻõ�Ӱ");  
  
        Node Ab  = new Node("����ƻõ�Ӱ");  
        Node Ab1= new Node("���������Դ��");  
        Node Ab2= new Node("��������յ㡷");  
  
        Node Ac = new Node("����ƻõ�Ӱ");  
        Node Ad = new Node("����ƻõ�Ӱ");  
  
        Node B = new Node("������Ӱ");  
        Node Ba = new Node("�������Ӱ");  
        Node Bb = new Node("��½��Ӱ");  
        Node Bc = new Node("��۵�Ӱ");  
  
        root.addChildNode(A);  
            A.addChildNode(Aa);  
            A.addChildNode(Ab);  
                Ab.addChildNode(Ab1);  
                Ab.addChildNode(Ab2);  
            A.addChildNode(Ac);  
            A.addChildNode(Ad);  
        root.addChildNode(B);  
            B.addChildNode(Ba);  
            B.addChildNode(Bb);  
            B.addChildNode(Bc);  
  
        System.out.println(root.getNodeEntity());  
        printNodeTree(root);  
  
    }  
  
    public static void printNodeTree(Node<String> node){  
        for (Node<String> childNode: node.getChildNodes()) {  
            System.out.println(childNode.getNodeEntity().toString());  
            if (childNode.getChildNodes()!=null){  
                printNodeTree(childNode);  
            }  
        }  
    }  
  
  
}  