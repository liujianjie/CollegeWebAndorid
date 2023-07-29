package sixteen.two.one;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Record {
	//注释字段
	@Field_Method_Paramter_Annotion(describe = "编号", type = int.class)
	int id;
	@Field_Method_Paramter_Annotion(describe = "姓名", type = String.class)
	String name;
	
	@Constructor_Annotation()
	//采用默认值注释构造方法
	public Record(){
		
	}
	@Constructor_Annotation("立即初始化构造方法")
	public Record(//注释构造方法
		@Field_Method_Paramter_Annotion(describe = "编号",type=int.class)
		@Field_Method_Paramter_Annotion2(describe = "编号tion2",type=int.class)int id,
		@Field_Method_Paramter_Annotion(describe = "姓名",type=String.class)
		@Field_Method_Paramter_Annotion2(describe = "姓名tion2",type=String.class)String name){
			this.id = id;
			this.name = name;
	}

	
	@Field_Method_Paramter_Annotion(describe = "获得编号", type = int.class)
	public int getId() {
		return id;
	}
	@Field_Method_Paramter_Annotion(describe = "设置编号")
	public void setId(@Field_Method_Paramter_Annotion(describe = "编号" ,type = int.class)
		int id) {
		this.id = id;
	}
	@Field_Method_Paramter_Annotion(describe = "获得姓名", type = String.class)
	public String getName() {
		return name;
	}
	@Field_Method_Paramter_Annotion(describe = "设置姓名" )
	public void setName(@Field_Method_Paramter_Annotion(describe = "姓名" ,type = String.class)
		String name) {
		this.name = name;
	}
	
	@Field_Method_Paramter_Annotion(describe = "addmethod" )
	public void addmethod(@Field_Method_Paramter_Annotion(describe = "adddescribeAnnotion" ,type = String.class)
		@Field_Method_Paramter_Annotion2(describe = "adddescribeAnnotion2" ,type = String.class) String name,
		@Field_Method_Paramter_Annotion(describe = "addmethoddescribeAnnotion" ,type = int.class)
	int id) {
		
	}
	
	public static void main(String[] args) {
		Record records = new Record();
		Class recordc = records.getClass();
		Constructor[] decalredConstructors = recordc.getDeclaredConstructors();
		for(int i = 0; i < decalredConstructors.length; i++){
			Constructor cons = decalredConstructors[i];
			// 是否具有指定类型的注释
			if(cons.isAnnotationPresent(Constructor_Annotation.class)){
				//获得指定类型的注释
				Constructor_Annotation ca = (Constructor_Annotation)
							cons.getAnnotation(Constructor_Annotation.class);
				System.out.println(ca.value());//获取注释信息
			}
			Annotation[][] parameterAnnotations = cons.getParameterAnnotations();//获取参数的注释
			for(int j = 0; j < parameterAnnotations.length; j++){
				//获取指定参数注释的长度
				int length = parameterAnnotations[j].length;
				System.out.println("constructor: "+length);
				//如果长度为 0 则未添加annotion信息
				if(length == 0)
					System.out.println("未添加 Annotation参数");
				else{
					for(int k = 0; k < length; k++){
						// 获得参数的注释
						if( k == 0 ){
							Field_Method_Paramter_Annotion pa = (Field_Method_Paramter_Annotion) parameterAnnotations[j][k];
							System.out.println("Constructor:  "+pa.describe());//获得参数的描述
							System.out.println("Constructor:  "+pa.type());//获得参数类型
						}else if( k == 1){
							Field_Method_Paramter_Annotion2 pa = (Field_Method_Paramter_Annotion2) parameterAnnotations[j][k];
							System.out.println("Constructor:  "+pa.describe());//获得参数的描述
							System.out.println("Constructor:  "+pa.type());//获得参数类型
						}
						
					}
					
				} 
			}
			System.out.println();
		}
		//最后编写访问字段的Annotation 信息的代码 
		Field[] declaredFields = recordc.getDeclaredFields();
		for(int i = 0; i < declaredFields.length; i++){
			Field field = declaredFields[i];
			//查看是否具有指定类型的注释
			if(field.isAnnotationPresent(Field_Method_Paramter_Annotion.class)){
				//获得指定类型的注释
				Field_Method_Paramter_Annotion fa = field.getAnnotation(Field_Method_Paramter_Annotion.class);
				System.out.println("declaredFields:  "+fa.describe());
				System.out.println("declaredFields:  "+fa.type());
			}
		}
		
		Method[] methods = recordc.getDeclaredMethods();
		for(int j = 0; j < methods.length; j++){
			Method method = methods[j];
			//查看方法是否具有指定类型的注释
			if(method.isAnnotationPresent(Field_Method_Paramter_Annotion.class)){
				Field_Method_Paramter_Annotion ma = method.getAnnotation(Field_Method_Paramter_Annotion.class);
				System.out.println(ma.describe());//
				System.out.println(ma.type());//
			}
			Annotation[][] parameterannos = method.getParameterAnnotations();// 获取参数的注释
//			for(int i = 0; i < parameterannos.length; i++){
//				System.out.println("testi: "+i);
//				for(int n = 0; n < parameterannos[i].length; n++){
//					System.out.println("testn: "+n);
//				}
//			}
//			System.out.println("/////////////////");
			System.out.println("parameterannos: "+parameterannos.length);
			for(int i = 0; i < parameterannos.length; i++){
				int length = parameterannos[i].length;
				System.out.println("methods: "+length);
				if(length == 0){
					System.out.println("未添加Annotion的参数");
				}else{
					for(int k = 0; k < length; k++){
						//获得制定类型的注释
						System.out.println("methods k: "+k);
						if(k == 0){
							Field_Method_Paramter_Annotion pa = (Field_Method_Paramter_Annotion)parameterannos[i][k];
							System.out.println("methods:   "+pa.describe());
							System.out.println("methods:   "+pa.type());
						}else if(k == 1){
							Field_Method_Paramter_Annotion2 pa = (Field_Method_Paramter_Annotion2)parameterannos[i][k];
							System.out.println("methods:   "+pa.describe());
							System.out.println("methods:   "+pa.type());
						}
					}
				}
			}
		}
		System.out.println();
	}
}
