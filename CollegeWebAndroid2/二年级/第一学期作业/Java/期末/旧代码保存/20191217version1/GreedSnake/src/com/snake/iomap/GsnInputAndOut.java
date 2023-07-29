package com.snake.iomap;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import com.snake.bean.GsnMapBean;
import com.snake.bean.GsnRankBean;
import com.snake.mgameconfig.GsnMainGameConstants;


// 操作文件
public class GsnInputAndOut {
	public StringBuffer ranksb = new StringBuffer();
	// 从txt文件读取的字符
	public StringBuffer sb = new StringBuffer();
	String filename;
	public GsnInputAndOut(){
		
	}
	public StringBuffer altersb = new StringBuffer();
	public GsnInputAndOut(String filename){
		this.filename = filename;
	}
	// 读取文件
	// 用BufferReader字符读取
	public void readMapTxt(){
		sb.delete(0, sb.toString().length());// 清楚
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
	// 输出文件
	public void outTxt(String str){
		File f = new File("src/com/snake/maptxt/map.txt");
		FileWriter fir = null;
		BufferedWriter bf = null;
		try{
			fir = new FileWriter(f, true);
			bf = new BufferedWriter(fir);
			bf.write(str+"&关卡与关卡分割符&\n");// 这里控制换行和关卡分割符
//			for(int k = 0; k < strarr.length; k++){
//				bf.write(strarr[k]);
//				bf.newLine();
//			}
			
			// 要关闭
			bf.close();
			fir.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	// 修改输出
	public void alterText(GsnMapBean mapbean){// 参数是新的关卡
		altersb.delete(0, altersb.toString().length());
		// 用之前 要删除
		String appst = new String("&关卡与关卡分割符&\n");
		StringBuilder sbf = new StringBuilder();
		// 用当前关卡得到下标
		GsnMapBean oldbean = GsnMainGameConstants.gsngamemap[GsnMainGameConstants.currLevel - 1];
		// 需要重新读取把。因为两个对象，一个是修改地图的，一个是bottom里的
		readMapTxt();
		// 直接删除在添加过去
		// 开头
		// 以免报错 一些问题，如果没有找到先前的 就不要 对哦，蛇的位置会改变，再找的话，可能找不到，要换个方法.但是是旧的 保存在全局里的，按理应该不会变
		if(altersb.indexOf(oldbean.toString()) != -1){
			sbf.append(altersb.substring(0, altersb.indexOf(oldbean.toString())));
			// 末尾
			sbf.append(altersb.substring(altersb.indexOf(oldbean.toString()) + oldbean.toString().length() + appst.length()));
			System.out.println("-----------------");
			System.out.println(sbf.toString());
			System.out.println("-----------------");
			
			// 添加新的
			sbf.append(mapbean.toString());
	//		//4.再输出 false的就会删除再读取
			File f = new File("src/com/snake/maptxt/map.txt");
			FileWriter fir = null;
			BufferedWriter bf = null;
			try{
				fir = new FileWriter(f);// 清楚
				bf = new BufferedWriter(fir);
				// 太大不知道有没有问题
				bf.write(sbf.toString() + appst);// 这里控制换行和关卡分割符
				
				// 要关闭
				bf.close();
				fir.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	// 删除地图
	public void delMap(){
		// 根据当前选的关卡是哪个进行删除 ，再重新输出 和修改差不多 只不过没有新的添加
		altersb.delete(0, altersb.toString().length());
		// 用之前 要删除
		String appst = new String("&关卡与关卡分割符&\n");
		StringBuilder sbf = new StringBuilder();
		// 用当前关卡得到下标
		GsnMapBean oldbean = GsnMainGameConstants.gsngamemap[GsnMainGameConstants.currLevel - 1];
		// 需要重新读取把。因为两个对象，一个是修改地图的，一个是bottom里的
		readMapTxt();
		// 直接删除在添加过去
		// 不等于-1
		if(altersb.indexOf(oldbean.toString()) != -1){
			// 开头
			sbf.append(altersb.substring(0, altersb.indexOf(oldbean.toString())));
			// 末尾
			sbf.append(altersb.substring(altersb.indexOf(oldbean.toString()) + oldbean.toString().length() + appst.length()));
			System.out.println("-----------------");
			System.out.println(sbf.toString());
			System.out.println("-----------------");
			
//			//4.再输出 false的就会删除再读取
			File f = new File("src/com/snake/maptxt/map.txt");
			FileWriter fir = null;
			BufferedWriter bf = null;
			try{
				fir = new FileWriter(f);// 清楚
				bf = new BufferedWriter(fir);
				// 太大不知道有没有问题
				bf.write(sbf.toString());// 不要分隔符了
				
				// 要关闭
				bf.close();
				fir.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	// 读
	public void readRank(){
		ranksb.delete(0, ranksb.toString().length());// 清楚
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
	// 输出排行榜
	public void outRank(GsnRankBean grb){
		String appenst = "\n人人分割\n";
		File f = new File("src/com/snake/maptxt/rank.txt");
		FileWriter fir = null;
		BufferedWriter bf = null;
		try{
			fir = new FileWriter(f, true);// 附加
			bf = new BufferedWriter(fir);
			// 太大不知道有没有问题
			bf.write(grb.toString()+appenst);// 不要分隔符了
			
			// 要关闭
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
