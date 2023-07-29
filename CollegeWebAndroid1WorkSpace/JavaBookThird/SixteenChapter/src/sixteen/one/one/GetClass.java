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
			System.out.println("�鿴�Ƿ�������пɱ������Ĳ�����"+constructor.isVarArgs());
			System.out.println("�ù��췽������ڲ�����������Ϊ��");
			Class[] parameterTypes = constructor.getParameterTypes();// ��ȡ���в�������
			for(int j = 0; j < parameterTypes.length; j++){
				System.out.println(" "+parameterTypes[j] + "/");
			}
			System.out.println("�ù��췽���Ŀ����׳����쳣����Ϊ��");
			// ������п����׳����쳣������Ϣ
			Class[] exceptionTypes = constructor.getExceptionTypes();
			for(int j = 0; j < exceptionTypes.length; j++){
				System.out.println(" "+exceptionTypes[j]);
			}
			Example_01 example_02 = null;
			while (example_02 == null) {
				//����ó�Ա�����ķ���Ȩ��Ϊprivate �����׳��쳣�������������
				try{
					if(i == 2){
						example_02 = (Example_01) constructor.newInstance();
						
					}else if(i == 0){
						example_02 = (Example_01) constructor.newInstance("12", 32);
					}else if(i == 1){
						System.out.println("111111111111");
					
						Object[] string = new Object[]{
									new String[]{"23","24","25"}};// ����д���������� ʲôgui ���ֲ�������
						example_02 = (Example_01) constructor.newInstance(string);
						
					}
				}catch(Exception e){
//					System.out.println("ִ��setAccessible����");
					//�����������׳��쳣ʱ���������������Ϊ���������
					constructor.setAccessible(true);
				}
			}
			example_02.print();
			System.out.println();
		}
	}
}





