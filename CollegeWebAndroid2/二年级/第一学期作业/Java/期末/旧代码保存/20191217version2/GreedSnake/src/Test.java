import java.util.Arrays;
import java.util.Date;
import java.util.Stack;

import com.snake.bean.GsnMapSnakeBean;

public class Test {
	public static void main(String[] args) {
		Stack<Integer> s = new Stack<Integer>();
		s.push(1);
		s.push(4);
		s.push(6);
		System.out.println(s.size());
		System.out.println(s.pop());
		System.out.println(s.size());
		System.out.println(s.peek());
		System.out.println(s.size());
		int testar [] = {1,2};
		System.out.println(Arrays.toString(testar));
		GsnMapSnakeBean gm1 = new GsnMapSnakeBean();
		gm1.snmapdirection = 2;
		gm1.snmapi[0] = 1;
		gm1.snmapi[1] = 2;
		gm1.snmapj[0] = 1;
		gm1.snmapj[1] = 2;
		gm1.snnode = 3;
		System.out.println(gm1.toString());
		
		Date da = new Date();
		System.out.println(da.toLocaleString());
	}
}
