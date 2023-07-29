package action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.struts2.ServletActionContext;

public class FileAction {
	
	//上传的文件对象
	private File[] file;
	
	//上传的文件名称
	private String[] fileFileName;
	
	//上传的文件类型	  
	private String []fileContentType;
	
	//获取系统盘符路径的分隔符（windows:\ linux:/）
	//private String savePath="E:"+System.getProperty("file.separator");
	
	//将文件保存到项目发布路径
	//先获取项目发布路径：ServletActionContext.getRequest().getRealPath("files")
	private String savePath=ServletActionContext.getRequest().getRealPath("files")+"\\";
	public String execute(){
		
		System.out.println("进来了。。。");
		System.out.println("文件名称："+fileFileName);
		System.out.println("文件类型："+fileContentType);
		System.out.println("路径:"+savePath);
//		
		//保存文件
		//保存本地的路径
		for(int i=0;i<fileFileName.length;i++){
			try {
				FileOutputStream fos=new FileOutputStream(this.savePath+this.fileFileName[i]);
				//读取文件对象i
				FileInputStream fil=new FileInputStream(this.file[i]);
				//每次读入 写出的大小
				byte[] b=new byte[1024];
				int real=fil.read(b);
				int ii=0;
				while(real>0){
					fos.write(b, 0, real);
					
					real=fil.read(b);//每次读入 写出 文件对象就会少去这部分，所以这样1kb1kb写出 知道 读入不了了
					
					ii++;
				}
				System.out.println(ii);
				fos.close();fil.close();

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return null;
	}
	public File[] getFile() {
		return file;
	}
	public void setFile(File[] file) {
		this.file = file;
	}
	public String[] getFileFileName() {
		return fileFileName;
	}
	public void setFileFileName(String[] fileFileName) {
		this.fileFileName = fileFileName;
	}
	public String[] getFileContentType() {
		return fileContentType;
	}
	public void setFileContentType(String[] fileContentType) {
		this.fileContentType = fileContentType;
	}
	
}
