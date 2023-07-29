package sixteen.one.three;

import java.lang.reflect.Method;

public class GetMethod {
	public static void main(String[] args) {
		Example_03 example3 = new Example_03();
		Class examplec = example3.getClass();
		Method[] methods = examplec.getDeclaredMethods();
		for(int i = 0; i < methods.length; i++){
			Method method = methods[i];
			System.out.println("名称是："+method.getName());
			System.out.println("是否允许带可变数量的参数："+method.isVarArgs());
			System.out.println("入口参数类型依次为：");
			//获取所有参数类型
			Class[] paramTypes = method.getParameterTypes();
			for (int j = 0; j < paramTypes.length; j++) {
				System.out.println(" "+paramTypes[j]);
			}
			//获得方法的返回值类型
			System.out.println("返回值类型："+method.getReturnType());
			
			System.out.println("可能抛出的异常类型有：");
			//获得方法可能抛出的所有异常类型
			Class[] exceptions = method.getExceptionTypes();
			for (int j = 0; j < exceptions.length; j++) {
				System.out.println(" "+exceptions[j]);
			}
			boolean isTurn = true;
			while(isTurn){
				try{
					isTurn = false;
					if("staticMethod".equals(method.getName())){
						method.invoke(example3);//没有参数的
					} else if("publicMethod".equals(method.getName())){
						method.invoke(example3, 30);
					} else if("protectedMethod".equals(method.getName())){
						method.invoke(example3, "30",40);//这里小心 在方法里写的String 转为int了 所以这里应该写成数字不应该是String字符
					} else if("privateMethod".equals(method.getName())){
						Object[] param = new Object[]{new String[]{"M","V","Q"}};
//						method.invoke(example3, "test","test2");//必须二维数组
						method.invoke(example3, param);
					} 
				}catch(Exception e){
					e.printStackTrace();
					isTurn = true;
					System.out.println("执行setAceesble方法");
					method.setAccessible(true);
				}
			}
			System.out.println();
		}
	}
}
