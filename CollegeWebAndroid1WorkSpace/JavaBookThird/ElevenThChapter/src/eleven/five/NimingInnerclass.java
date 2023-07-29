package eleven.five;

//匿名内部类
public class NimingInnerclass {
	public outinterface doit(){
		return new outinterface() {//其实有一个内部类实现了 接口但没有显示出来
			
			@Override
			public void doit() {
				// TODO Auto-generated method stub
				
			}
		};
	}
}
