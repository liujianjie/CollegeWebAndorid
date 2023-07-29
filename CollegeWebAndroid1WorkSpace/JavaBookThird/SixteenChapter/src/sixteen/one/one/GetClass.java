package sixteen.one.one;

import java.lang.reflect.Constructor;

public class GetClass {
	public static void main(String[] args) {
		Example_01 ex = new Example_01();
		Class exc = ex.getClass();
//		System.out.println(exc.getPackage());
//		System.out.println(exc.getName());
		Constructor[] declaredConstructors = exc.getDeclaredConstructors();
		System.out.println(declaredConstructors.length);
		for(int i = 0; i < declaredConstructors.length; i++){
			Constructor constructor = declaredConstructors[i];
			System.out.println("查看是否允许带有可变数量的参数："+constructor.isVarArgs());
			System.out.println("该构造方法的入口参数类型依次为：");
			Class[] parameterTypes = constructor.getParameterTypes();// 获取所有参数类型
			for(int j = 0; j < parameterTypes.length; j++){
				System.out.println(" "+parameterTypes[j] + "/");
			}
			System.out.println("该构造方法的可能抛出的异常类型为：");
			// 获得所有可能抛出的异常类型信息
			Class[] exceptionTypes = constructor.getExceptionTypes();
			for(int j = 0; j < exceptionTypes.length; j++){
				System.out.println(" "+exceptionTypes[j]);
			}
			Example_01 example_02 = null;
			while (example_02 == null) {
				//如果该成员变量的访问权限为private ，则抛出异常，即不允许访问
				try{
					if(i == 2){
						example_02 = (Example_01) constructor.newInstance();
						
					}else if(i == 0){
						example_02 = (Example_01) constructor.newInstance("12", 32);
					}else if(i == 1){
						System.out.println("111111111111");
					
						Object[] string = new Object[]{
									new String[]{"23","24","25"}};// 这种写法？？？？ 什么gui 这种操作？？
						example_02 = (Example_01) constructor.newInstance(string);
						
					}
				}catch(Exception e){
//					System.out.println("执行setAccessible方法");
					//当创建对象抛出异常时，即设置这个参数为可允许访问
					constructor.setAccessible(true);
				}
			}
			example_02.print();
			System.out.println();
		}
	}
}





