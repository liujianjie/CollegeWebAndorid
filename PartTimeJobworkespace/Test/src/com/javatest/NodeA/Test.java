package com.javatest.NodeA;  
  
/** 
 * Created by Joker on 2017/5/27. 
 */  
public class Test {  
  
    public static  void main(String args[]){  
  
        Node root = new Node("电影");  
        Node A = new Node("科幻电影");  
        Node Aa = new Node("太空科幻电影");  
  
        Node Ab  = new Node("地球科幻电影");  
        Node Ab1= new Node("《地球的起源》");  
        Node Ab2= new Node("《地球的终点》");  
  
        Node Ac = new Node("月球科幻电影");  
        Node Ad = new Node("宇宙科幻电影");  
  
        Node B = new Node("动作电影");  
        Node Ba = new Node("好莱坞电影");  
        Node Bb = new Node("大陆电影");  
        Node Bc = new Node("香港电影");  
  
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