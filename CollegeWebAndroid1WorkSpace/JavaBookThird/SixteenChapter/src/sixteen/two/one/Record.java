package sixteen.two.one;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Record {
	//ע���ֶ�
	@Field_Method_Paramter_Annotion(describe = "���", type = int.class)
	int id;
	@Field_Method_Paramter_Annotion(describe = "����", type = String.class)
	String name;
	
	@Constructor_Annotation()
	//����Ĭ��ֵע�͹��췽��
	public Record(){
		
	}
	@Constructor_Annotation("������ʼ�����췽��")
	public Record(//ע�͹��췽��
		@Field_Method_Paramter_Annotion(describe = "���",type=int.class)
		@Field_Method_Paramter_Annotion2(describe = "���tion2",type=int.class)int id,
		@Field_Method_Paramter_Annotion(describe = "����",type=String.class)
		@Field_Method_Paramter_Annotion2(describe = "����tion2",type=String.class)String name){
			this.id = id;
			this.name = name;
	}

	
	@Field_Method_Paramter_Annotion(describe = "��ñ��", type = int.class)
	public int getId() {
		return id;
	}
	@Field_Method_Paramter_Annotion(describe = "���ñ��")
	public void setId(@Field_Method_Paramter_Annotion(describe = "���" ,type = int.class)
		int id) {
		this.id = id;
	}
	@Field_Method_Paramter_Annotion(describe = "�������", type = String.class)
	public String getName() {
		return name;
	}
	@Field_Method_Paramter_Annotion(describe = "��������" )
	public void setName(@Field_Method_Paramter_Annotion(describe = "����" ,type = String.class)
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
			// �Ƿ����ָ�����͵�ע��
			if(cons.isAnnotationPresent(Constructor_Annotation.class)){
				//���ָ�����͵�ע��
				Constructor_Annotation ca = (Constructor_Annotation)
							cons.getAnnotation(Constructor_Annotation.class);
				System.out.println(ca.value());//��ȡע����Ϣ
			}
			Annotation[][] parameterAnnotations = cons.getParameterAnnotations();//��ȡ������ע��
			for(int j = 0; j < parameterAnnotations.length; j++){
				//��ȡָ������ע�͵ĳ���
				int length = parameterAnnotations[j].length;
				System.out.println("constructor: "+length);
				//�������Ϊ 0 ��δ���annotion��Ϣ
				if(length == 0)
					System.out.println("δ��� Annotation����");
				else{
					for(int k = 0; k < length; k++){
						// ��ò�����ע��
						if( k == 0 ){
							Field_Method_Paramter_Annotion pa = (Field_Method_Paramter_Annotion) parameterAnnotations[j][k];
							System.out.println("Constructor:  "+pa.describe());//��ò���������
							System.out.println("Constructor:  "+pa.type());//��ò�������
						}else if( k == 1){
							Field_Method_Paramter_Annotion2 pa = (Field_Method_Paramter_Annotion2) parameterAnnotations[j][k];
							System.out.println("Constructor:  "+pa.describe());//��ò���������
							System.out.println("Constructor:  "+pa.type());//��ò�������
						}
						
					}
					
				} 
			}
			System.out.println();
		}
		//����д�����ֶε�Annotation ��Ϣ�Ĵ��� 
		Field[] declaredFields = recordc.getDeclaredFields();
		for(int i = 0; i < declaredFields.length; i++){
			Field field = declaredFields[i];
			//�鿴�Ƿ����ָ�����͵�ע��
			if(field.isAnnotationPresent(Field_Method_Paramter_Annotion.class)){
				//���ָ�����͵�ע��
				Field_Method_Paramter_Annotion fa = field.getAnnotation(Field_Method_Paramter_Annotion.class);
				System.out.println("declaredFields:  "+fa.describe());
				System.out.println("declaredFields:  "+fa.type());
			}
		}
		
		Method[] methods = recordc.getDeclaredMethods();
		for(int j = 0; j < methods.length; j++){
			Method method = methods[j];
			//�鿴�����Ƿ����ָ�����͵�ע��
			if(method.isAnnotationPresent(Field_Method_Paramter_Annotion.class)){
				Field_Method_Paramter_Annotion ma = method.getAnnotation(Field_Method_Paramter_Annotion.class);
				System.out.println(ma.describe());//
				System.out.println(ma.type());//
			}
			Annotation[][] parameterannos = method.getParameterAnnotations();// ��ȡ������ע��
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
					System.out.println("δ���Annotion�Ĳ���");
				}else{
					for(int k = 0; k < length; k++){
						//����ƶ����͵�ע��
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
