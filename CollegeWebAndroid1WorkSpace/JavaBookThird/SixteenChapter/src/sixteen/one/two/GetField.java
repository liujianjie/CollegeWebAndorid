package sixteen.one.two;

import java.lang.reflect.Field;

public class GetField {
	public static void main(String[] args) {
		Example_02 example = new Example_02();
		Class exampleC = example.getClass();
		Field[] fields = exampleC.getDeclaredFields();
		for(int i = 0; i < fields.length; i++){
			Field field = fields[i];
			//获得成员变量名称
			System.out.println("变量名称:"+field.getName());
			Class type = field.getType();
			System.out.println("变量类型："+type);
			boolean isTrue = true;
			while (isTrue) {
				//如果该成员为private类型抛出异常 设为可访问
				try{
					isTrue = false;//每个field 遍历一次，但是因为private的存在
					System.out.println("修改前变量的值："+field.get(example));//获取变量的值
					if(type == int.class){
						field.set(example, 2);
					} else if(type == float.class){
						field.set(example, 5.0F);
						
					} else if(type == boolean.class){
						field.set(example, true);
					} else {//修改string
						field.set(example, "MWQ");
					}
					System.out.println("修改后的值" + field.get(example));
					
				}catch(Exception e){
					System.out.println("设置setAccessible方法");
					field.setAccessible(true);
					isTrue = true;
				}
			}
			System.out.println();
		}
	}
}
