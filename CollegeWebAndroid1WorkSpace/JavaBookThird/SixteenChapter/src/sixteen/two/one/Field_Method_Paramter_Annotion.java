package sixteen.two.one;

import java.lang.annotation.ElementType;
import java.lang.annotation.*;

@Target({ElementType.FIELD,ElementType.METHOD,ElementType.PARAMETER})//方法 变量 参数
@Retention(RetentionPolicy.RUNTIME)//在运行时加载到JVM中


public @interface Field_Method_Paramter_Annotion {
	String describe(); // 没有默认值的string 类型成员
	Class type() default void.class;//定义一个具有默认值的Class型成员
}
