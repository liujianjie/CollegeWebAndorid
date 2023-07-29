public class 变量{
	public static void main(String a[]){
		System.out.println("开始练习变量");
	//布尔类型 boolean
	boolean b=false;
		System.out.println("结果为:"+b);
	//byte类型 
	byte c=122;//-128~127
		System.out.println("byte："+c);
	//int类型
	int d=46548;
		System.out.println("int:"+d);
	//long类型 需要转换 想浮点型一样 默认为int类型 虽然不影响 但数据的范围受	影响
	long i=23L;
		System.out.println("long:"+i);
	//浮点型float
	float e=10.0f;
	double f=10.0;
		System.out.println("e="+e);
		System.out.println("f="+f);
		System.out.println("e+f="+e+f);//混合的数据类型 以数据类型高级的 输出 其它类型自动转换
	//字符类型
	char g='c';
		System.out.println("g="+g);
	//字符串类型
	String h="乐极哀来大家离开";
		System.out.println("字符串输出："+h);
	//数据类型转换 long类型i 转换 int类型的d 
	i=d;
	i=(int)d;
		System.out.println("强制转换："+i);
	//基本转换 隐形转换 和 字符串拼接
	char z='x';
		System.out.println(z+1);//隐形转换
		System.out.println(""+z+1);//字符串拼接
	}	
}