import java.awt.Button;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class T1 extends java.applet.Applet implements ActionListener{
	Label label1 = new Label("+");
		Label label2 = new Label("=");
	TextField field1 = new TextField(6);
	TextField field2 = new TextField(6);
	TextField field3 = new TextField(6);

	Button button1 = new Button("add");

	public void init(){
		add(field1);
		add(label1);
		add(field2);
		add(label2);
		add(field3);
		add(button1);
		button1.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e){
		int x = Integer.parseInt(field1.getText())+Integer.parseInt(field2.getText());
		field3.setText(Integer.toString(x));
	}

}