package action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.struts2.ServletActionContext;

public class FileAction {
	
	//�ϴ����ļ�����
	private File[] file;
	
	//�ϴ����ļ�����
	private String[] fileFileName;
	
	//�ϴ����ļ�����	  
	private String []fileContentType;
	
	//��ȡϵͳ�̷�·���ķָ�����windows:\ linux:/��
	//private String savePath="E:"+System.getProperty("file.separator");
	
	//���ļ����浽��Ŀ����·��
	//�Ȼ�ȡ��Ŀ����·����ServletActionContext.getRequest().getRealPath("files")
	private String savePath=ServletActionContext.getRequest().getRealPath("files")+"\\";
	public String execute(){
		
		System.out.println("�����ˡ�����");
		System.out.println("�ļ����ƣ�"+fileFileName);
		System.out.println("�ļ����ͣ�"+fileContentType);
		System.out.println("·��:"+savePath);
//		
		//�����ļ�
		//���汾�ص�·��
		for(int i=0;i<fileFileName.length;i++){
			try {
				FileOutputStream fos=new FileOutputStream(this.savePath+this.fileFileName[i]);
				//��ȡ�ļ�����i
				FileInputStream fil=new FileInputStream(this.file[i]);
				//ÿ�ζ��� д���Ĵ�С
				byte[] b=new byte[1024];
				int real=fil.read(b);
				int ii=0;
				while(real>0){
					fos.write(b, 0, real);
					
					real=fil.read(b);//ÿ�ζ��� д�� �ļ�����ͻ���ȥ�ⲿ�֣���������1kb1kbд�� ֪�� ���벻����
					
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
