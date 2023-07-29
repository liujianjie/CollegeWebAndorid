package fifteen.seven.one;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

//mdfuck 一直有错 不知道怎么办
public class ZipOutputStreamTestClass {
	private void zip(String zipOutName,File f) throws Exception{
		
		ZipOutputStream zo = new ZipOutputStream(new FileOutputStream(zipOutName));
		zip(zo,f,"");
		System.out.println("压缩中。。。");
		zo.close();
	}
	private void zip(ZipOutputStream zo,File f,String base) throws Exception{
		if(f.isDirectory()){
			File[] fl = f.listFiles();
			zo.putNextEntry(new ZipEntry(base + "/"));
			base = base.length() == 0 ? "":base + "/";//重要
			for(int i = 0; i < fl.length; i++){
				zip(zo,fl[i],base + fl[i]);
			}
		}else{
			zo.putNextEntry(new ZipEntry(base));
			FileInputStream fi = new FileInputStream(f);
			
			int b;
			System.out.println(base);
			while((b = fi.read())!= -1){
				zo.write(b);
			}
			fi.close();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			new ZipOutputStreamTestClass().zip("E:/ONE.zip",new File("E:/testzip"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		try {
//			File zipfile = new File("E:/testzip");
//			
//			
//			if(zipfile.isDirectory()){
//				File fl[] = zipfile.listFiles();
//				System.out.println(fl.length);
//				String base = "";
//				for(int i = 0; i < fl.length; i++){
//					zo.putNextEntry(new ZipEntry(base+"/"));
//					
//					String newfile = base += fl[i] + "/";
//					zo.putNextEntry(new ZipEntry(newfile));
//					
//					FileInputStream in = new FileInputStream(fl[i]);
//					int b;
//					while ((b = in.read()) != -1){
//						zo.write(b);
//					}
//					in.close();
//				}
//				
//				
//			}
//
//			zo.close();
//			
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
}
