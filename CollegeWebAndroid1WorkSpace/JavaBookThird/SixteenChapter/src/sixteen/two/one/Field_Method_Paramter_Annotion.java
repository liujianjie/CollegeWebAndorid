package sixteen.two.one;

import java.lang.annotation.ElementType;
import java.lang.annotation.*;

@Target({ElementType.FIELD,ElementType.METHOD,ElementType.PARAMETER})//���� ���� ����
@Retention(RetentionPolicy.RUNTIME)//������ʱ���ص�JVM��


public @interface Field_Method_Paramter_Annotion {
	String describe(); // û��Ĭ��ֵ��string ���ͳ�Ա
	Class type() default void.class;//����һ������Ĭ��ֵ��Class�ͳ�Ա
}
