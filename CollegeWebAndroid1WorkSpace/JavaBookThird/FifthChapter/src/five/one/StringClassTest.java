package five.one;

public class StringClassTest {
	public static void main(String[] args) {
//		String str = null;
//		System.out.println(str);
//		
//		char c[] = {'g','o','d','d','!'};
//		String str2 = new String(c);
//		System.out.println(str2);
//		
//		String str3 = new String(c,2,3);
//		System.out.println(str3);
//		
		String str4,str5;
		str4 = "we are";
		str5 = "we are";
		System.out.println(str4.hashCode());
		System.out.println(str5.hashCode());
		System.out.println(str5 == str4);
//		
//		int booktime = 4;
//		float parctice = 2.5f;
//		System.out.println("Œ“"+parctice+booktime+"..");
//		
//		
//		System.out.println(str4.indexOf(0,2));
//		
//		String str6 = "  java  class  ";
//		System.out.println(str6.trim());
//		
//		System.out.println(str6.replace("ja", "c++"));
//		
		String str7 = new String("we are new");
		String str8 = new String("we are new");
		System.out.println(str7.hashCode());
		System.out.println(str8.hashCode());
		System.out.println(str7==str8);
		
		String str10 = new String("a");
		String str11 = new String("b");
		System.out.println(str10.compareTo(str11));
		
		String str12 = "abc,def,ghi,gkl";
		String[] str13 = str12.split(",",3);
//		for(String str14:str13){
//			System.out.println(str14);
//		}
		System.out.println(str13[2]);
	}
}
