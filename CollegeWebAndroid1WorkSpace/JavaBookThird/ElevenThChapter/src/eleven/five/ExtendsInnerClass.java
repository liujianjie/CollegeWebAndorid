package eleven.five;

public class ExtendsInnerClass extends ClassA.ClassB{
	public ExtendsInnerClass(ClassA a){
		a.super();
	}
}

class ClassA{
	class ClassB{
		
	}
}
