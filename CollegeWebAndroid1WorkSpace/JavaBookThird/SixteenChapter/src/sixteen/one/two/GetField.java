package sixteen.one.two;

import java.lang.reflect.Field;

public class GetField {
	public static void main(String[] args) {
		Example_02 example = new Example_02();
		Class exampleC = example.getClass();
		Field[] fields = exampleC.getDeclaredFields();
		for(int i = 0; i < fields.length; i++){
			Field field = fields[i];
			//��ó�Ա��������
			System.out.println("��������:"+field.getName());
			Class type = field.getType();
			System.out.println("�������ͣ�"+type);
			boolean isTrue = true;
			while (isTrue) {
				//����ó�ԱΪprivate�����׳��쳣 ��Ϊ�ɷ���
				try{
					isTrue = false;//ÿ��field ����һ�Σ�������Ϊprivate�Ĵ���
					System.out.println("�޸�ǰ������ֵ��"+field.get(example));//��ȡ������ֵ
					if(type == int.class){
						field.set(example, 2);
					} else if(type == float.class){
						field.set(example, 5.0F);
						
					} else if(type == boolean.class){
						field.set(example, true);
					} else {//�޸�string
						field.set(example, "MWQ");
					}
					System.out.println("�޸ĺ��ֵ" + field.get(example));
					
				}catch(Exception e){
					System.out.println("����setAccessible����");
					field.setAccessible(true);
					isTrue = true;
				}
			}
			System.out.println();
		}
	}
}
