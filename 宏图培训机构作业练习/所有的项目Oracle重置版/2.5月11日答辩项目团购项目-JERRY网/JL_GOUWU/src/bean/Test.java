package bean;

import java.sql.Connection;

import conne.DBconnection;

public class Test {
	public static void main(String[] args) {
		System.out.println(testreture());
	}
	
	public static int testreture(){
		try {
			System.out.println("try");
			return 0;
		}catch(Exception e){
			System.out.println("catch");
		} finally {
			System.out.println("finally");
		}
		return 1;
	}
}
