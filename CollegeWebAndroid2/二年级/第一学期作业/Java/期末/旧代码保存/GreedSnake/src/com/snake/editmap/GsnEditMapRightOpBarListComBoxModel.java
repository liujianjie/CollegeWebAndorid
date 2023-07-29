package com.snake.editmap;
import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class GsnEditMapRightOpBarListComBoxModel extends AbstractListModel implements ComboBoxModel {
  private Object selectedItem;

  private ArrayList anArrayList;

  public GsnEditMapRightOpBarListComBoxModel(ArrayList arrayList) {
    anArrayList = arrayList;
  }

  public Object getSelectedItem() {
    return selectedItem;
  }

  public void setSelectedItem(Object newValue) {
    selectedItem = newValue;
  }

  public int getSize() {
    return anArrayList.size();
  }

  public Object getElementAt(int i) {
    return anArrayList.get(i);
  }
  public static void main(String args[]) {
	    JFrame frame = new JFrame("ArrayListComboBoxModel");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    ArrayList<Object> arrayList = new ArrayList<Object>();
	    arrayList.add("");
	    arrayList.add("A");
	    arrayList.add("B");
	    arrayList.add("C");
	    GsnEditMapRightOpBarListComBoxModel model = new GsnEditMapRightOpBarListComBoxModel(arrayList);

	    JList<Object> comboBox = new JList<Object>(model);
	    JScrollPane js = new JScrollPane(comboBox);
	    frame.add(js, BorderLayout.CENTER);
	    frame.setSize(300, 225);
	    frame.setVisible(true);
	  }
}

//public class GsnEditMapRightOpBarListComBoxModel {
//  public static void main(String args[]) {
//    JFrame frame = new JFrame("ArrayListComboBoxModel");
//    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    ArrayList<Object> arrayList = new ArrayList<Object>();
//    arrayList.add("");
//    arrayList.add("A");
//    arrayList.add("B");
//    arrayList.add("C");
//    ArrayListComboBoxModel model = new ArrayListComboBoxModel(arrayList);
//
//    JComboBox<Object> comboBox = new JComboBox<Object>(model);
//
//    frame.add(comboBox, BorderLayout.NORTH);
//    frame.setSize(300, 225);
//    frame.setVisible(true);
//  }
//}
