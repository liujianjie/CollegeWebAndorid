package sixteen.one.three;

import java.lang.reflect.Method;

public class GetMethod {
	public static void main(String[] args) {
		Example_03 example3 = new Example_03();
		Class examplec = example3.getClass();
		Method[] methods = examplec.getDeclaredMethods();
		for(int i = 0; i < methods.length; i++){
			Method method = methods[i];
			System.out.println("�����ǣ�"+method.getName());
			System.out.println("�Ƿ�������ɱ������Ĳ�����"+method.isVarArgs());
			System.out.println("��ڲ�����������Ϊ��");
			//��ȡ���в�������
			Class[] paramTypes = method.getParameterTypes();
			for (int j = 0; j < paramTypes.length; j++) {
				System.out.println(" "+paramTypes[j]);
			}
			//��÷����ķ���ֵ����
			System.out.println("����ֵ���ͣ�"+method.getReturnType());
			
			System.out.println("�����׳����쳣�����У�");
			//��÷��������׳��������쳣����
			Class[] exceptions = method.getExceptionTypes();
			for (int j = 0; j < exceptions.length; j++) {
				System.out.println(" "+exceptions[j]);
			}
			boolean isTurn = true;
			while(isTurn){
				try{
					isTurn = false;
					if("staticMethod".equals(method.getName())){
						method.invoke(example3);//û�в�����
					} else if("publicMethod".equals(method.getName())){
						method.invoke(example3, 30);
					} else if("protectedMethod".equals(method.getName())){
						method.invoke(example3, "30",40);//����С�� �ڷ�����д��String תΪint�� ��������Ӧ��д�����ֲ�Ӧ����String�ַ�
					} else if("privateMethod".equals(method.getName())){
						Object[] param = new Object[]{new String[]{"M","V","Q"}};
//						method.invoke(example3, "test","test2");//�����ά����
						method.invoke(example3, param);
					} 
				}catch(Exception e){
					e.printStackTrace();
					isTurn = true;
					System.out.println("ִ��setAceesble����");
					method.setAccessible(true);
				}
			}
			System.out.println();
		}
	}
}
