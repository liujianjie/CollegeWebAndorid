public class 异常 extends Exception{

	public 异常(String mmm){//重写子类的方法
		super(mmm);//调用父类的方法

	}

	public String getExceptionMessage(){//接收父类的错误信息
		return super.getMessage();
	}
}