public class 位操作
{
	public static void main(String sds[]){
		int a=0,b=0,c=0,d=0,e=0,f=0;
		//主要靠自己了解过程 与原理
		a=10&12;//与运算
		System.out.println(a);
		b=10|12;//或运算
		System.out.println(b);
		c=10^12;//异或运算
		System.out.println(c);
		d=~210;//取反运算
		System.out.println(d);
		e=15<<1;//左移
		System.out.println(e);
		f=15>>2;//右移
		System.out.println(f);//取整
	}
}
d