package eighteen.two.two;

import java.awt.Container;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class TestScrollImg extends JFrame{
	
	int count = 10;
	public TestScrollImg(){
		super("Test");
		Container con = this.getContentPane();
		con.setBounds(300, 200, 250, 200);
		con.setLayout(null);
		
		JLabel jl = new JLabel();
//		URL url = TestScrollImg.class.getResource("/resource/1.jpg");
		URL url = TestScrollImg.class.getResource("1.jpg");
		Icon ic = new ImageIcon(url);
		jl.setIcon(ic);
		jl.setBounds(10,50,200,100);
		jl.setHorizontalAlignment(SwingConstants.LEFT);
		jl.setOpaque(true);
		
		Thread t = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(count <= 250){
					jl.setBounds(count,50,200,100);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					count += 25;
					if(count >= 190){
						count -= 25;
					}else if(count < 0){
						count += 25;
					}
					
					
				}
			}
		});
		t.start();
		con.add(jl);
		this.setSize(250, 200);
		this.setVisible(true);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}
	public static void main(String[] args) {
		new TestScrollImg();
	}
}
