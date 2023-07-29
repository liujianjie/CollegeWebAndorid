package com.snake.iomap;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import com.snake.bean.GsnMapBean;
import com.snake.bean.GsnRankBean;
import com.snake.mgameconfig.GsnMainGameConstants;


// �����ļ�
public class GsnInputAndOut {
	public StringBuffer ranksb = new StringBuffer();
	// ��txt�ļ���ȡ���ַ�
	public StringBuffer sb = new StringBuffer();
	String filename;
	public GsnInputAndOut(){
		
	}
	public StringBuffer altersb = new StringBuffer();
	public GsnInputAndOut(String filename){
		this.filename = filename;
	}
	// ��ȡ�ļ�
	// ��BufferReader�ַ���ȡ
	public void readMapTxt(){
		sb.delete(0, sb.toString().length());// ���
		File f = new File("src/com/snake/maptxt/map.txt");
		try{
			FileReader fir = new FileReader(f);
			BufferedReader bf = new BufferedReader(fir);
			String s;
			while((s = bf.readLine()) != null){
				sb.append(s);
				altersb.append(s+"\n");
			}
			fir.close();
			bf.close();
//			System.out.println(sb.toString());
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	// ����ļ�
	public void outTxt(String str){
		File f = new File("src/com/snake/maptxt/map.txt");
		FileWriter fir = null;
		BufferedWriter bf = null;
		try{
			fir = new FileWriter(f, true);
			bf = new BufferedWriter(fir);
			bf.write(str+"&�ؿ���ؿ��ָ��&\n");// ������ƻ��к͹ؿ��ָ��
//			for(int k = 0; k < strarr.length; k++){
//				bf.write(strarr[k]);
//				bf.newLine();
//			}
			
			// Ҫ�ر�
			bf.close();
			fir.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	// �޸����
	public void alterText(GsnMapBean mapbean){// �������µĹؿ�
		altersb.delete(0, altersb.toString().length());
		// ��֮ǰ Ҫɾ��
		String appst = new String("&�ؿ���ؿ��ָ��&\n");
		StringBuilder sbf = new StringBuilder();
		// �õ�ǰ�ؿ��õ��±�
		GsnMapBean oldbean = GsnMainGameConstants.gsngamemap[GsnMainGameConstants.currLevel - 1];
		// ��Ҫ���¶�ȡ�ѡ���Ϊ��������һ�����޸ĵ�ͼ�ģ�һ����bottom���
		readMapTxt();
		// ֱ��ɾ������ӹ�ȥ
		// ��ͷ
		// ���ⱨ�� һЩ���⣬���û���ҵ���ǰ�� �Ͳ�Ҫ ��Ŷ���ߵ�λ�û�ı䣬���ҵĻ��������Ҳ�����Ҫ��������.�����Ǿɵ� ������ȫ����ģ�����Ӧ�ò����
		if(altersb.indexOf(oldbean.toString()) != -1){
			sbf.append(altersb.substring(0, altersb.indexOf(oldbean.toString())));
			// ĩβ
			sbf.append(altersb.substring(altersb.indexOf(oldbean.toString()) + oldbean.toString().length() + appst.length()));
			System.out.println("-----------------");
			System.out.println(sbf.toString());
			System.out.println("-----------------");
			
			// ����µ�
			sbf.append(mapbean.toString());
	//		//4.����� false�ľͻ�ɾ���ٶ�ȡ
			File f = new File("src/com/snake/maptxt/map.txt");
			FileWriter fir = null;
			BufferedWriter bf = null;
			try{
				fir = new FileWriter(f);// ���
				bf = new BufferedWriter(fir);
				// ̫��֪����û������
				bf.write(sbf.toString() + appst);// ������ƻ��к͹ؿ��ָ��
				
				// Ҫ�ر�
				bf.close();
				fir.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	// ɾ����ͼ
	public void delMap(){
		// ���ݵ�ǰѡ�Ĺؿ����ĸ�����ɾ�� ����������� ���޸Ĳ�� ֻ����û���µ����
		altersb.delete(0, altersb.toString().length());
		// ��֮ǰ Ҫɾ��
		String appst = new String("&�ؿ���ؿ��ָ��&\n");
		StringBuilder sbf = new StringBuilder();
		// �õ�ǰ�ؿ��õ��±�
		GsnMapBean oldbean = GsnMainGameConstants.gsngamemap[GsnMainGameConstants.currLevel - 1];
		// ��Ҫ���¶�ȡ�ѡ���Ϊ��������һ�����޸ĵ�ͼ�ģ�һ����bottom���
		readMapTxt();
		// ֱ��ɾ������ӹ�ȥ
		// ������-1
		if(altersb.indexOf(oldbean.toString()) != -1){
			// ��ͷ
			sbf.append(altersb.substring(0, altersb.indexOf(oldbean.toString())));
			// ĩβ
			sbf.append(altersb.substring(altersb.indexOf(oldbean.toString()) + oldbean.toString().length() + appst.length()));
			System.out.println("-----------------");
			System.out.println(sbf.toString());
			System.out.println("-----------------");
			
//			//4.����� false�ľͻ�ɾ���ٶ�ȡ
			File f = new File("src/com/snake/maptxt/map.txt");
			FileWriter fir = null;
			BufferedWriter bf = null;
			try{
				fir = new FileWriter(f);// ���
				bf = new BufferedWriter(fir);
				// ̫��֪����û������
				bf.write(sbf.toString());// ��Ҫ�ָ�����
				
				// Ҫ�ر�
				bf.close();
				fir.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	// ��
	public void readRank(){
		ranksb.delete(0, ranksb.toString().length());// ���
		File f = new File("src/com/snake/maptxt/rank.txt");
		try{
			FileReader fir = new FileReader(f);
			BufferedReader bf = new BufferedReader(fir);
			String s;
			while((s = bf.readLine()) != null){
				ranksb.append(s);
			}
			fir.close();
			bf.close();
//			System.out.println(sb.toString());
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	// ������а�
	public void outRank(GsnRankBean grb){
		String appenst = "\n���˷ָ�\n";
		File f = new File("src/com/snake/maptxt/rank.txt");
		FileWriter fir = null;
		BufferedWriter bf = null;
		try{
			fir = new FileWriter(f, true);// ����
			bf = new BufferedWriter(fir);
			// ̫��֪����û������
			bf.write(grb.toString()+appenst);// ��Ҫ�ָ�����
			
			// Ҫ�ر�
			bf.close();
			fir.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
//	public static void main(String[] args) {
//		GsnMapBean oldsbean = GsnMainGameConstants.gsngamemap[GsnMainGameConstants.currLevel - 1];
//		new GsnInputAndOut().alterText(oldsbean, null);
//	}
}
