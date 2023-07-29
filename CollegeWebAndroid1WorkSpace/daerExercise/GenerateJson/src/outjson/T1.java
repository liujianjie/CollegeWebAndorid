package outjson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
/*
'洛'=>array(
"name"=>"洛",
"title"=>"幻翎",
"life"=>"60",
"physical"=>"10",
"magic"=>"60",
"difficulty"=>"50",
"tags"=>array("辅助","法师"),
"story"=>"对洛特兰部落而言，瓦斯塔亚的洛是臭名远播的捣蛋鬼，同时也是有史以来最为出色的战舞舞者。他风流潇洒，魅力无穷，同时却令人难以捉摸。在艾欧尼亚高地的居民眼中，“洛”这个名字一直都跟热闹非凡的节日庆典、热火朝天的狂欢派对和杂乱无章的音乐划上等号。很少人知道，这个精力充沛的浪荡子和叛逆的霞是一对儿，而他的一举一动就是为了全力配合她的行动。“自由为伍，佳人为伴，还有值得献身的道义。”",
"skin"=>(array("http://ossweb-img.qq.com/images/lol/web201310/skin/big497000.jpg",
      "http://ossweb-img.qq.com/images/lol/web201310/skin/big497001.jpg",
      "http://ossweb-img.qq.com/images/lol/web201310/skin/big497002.jpg",
      "http://ossweb-img.qq.com/images/lol/web201310/skin/big497003.jpg",
      "http://ossweb-img.qq.com/images/lol/web201310/skin/big497004.jpg")),
"skinhead"=>(array( "http://ossweb-img.qq.com/images/lol/web201310/skin/small497000.jpg",
      "http://ossweb-img.qq.com/images/lol/web201310/skin/small497001.jpg",
      "http://ossweb-img.qq.com/images/lol/web201310/skin/small497002.jpg",
      "http://ossweb-img.qq.com/images/lol/web201310/skin/small497003.jpg",
      "http://ossweb-img.qq.com/images/lol/web201310/skin/small497004.jpg"))
),
*/
public class T1 {
	static StringBuffer outstr = new StringBuffer();
	public static void main(String[] args) throws Exception {
		StringBuffer sb = new StringBuffer();
		T1 t = new T1();
		String s1 = t.getClass().getResource("/lol_details_duowan.js").getPath();
		BufferedReader br = null;
		FileInputStream fis = null;
		InputStreamReader isr = null;
		try {
			fis = new FileInputStream(s1);
			isr = new InputStreamReader(fis, "utf-8");
			br = new BufferedReader(isr);
			
			String cline = br.readLine();
			while(cline!=null){
//				System.out.println(cline);
				cline = br.readLine();
				if(cline != null){
					cline = cline.replaceAll(" ","");
					sb.append(cline);
				}
			}
			br.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String s = sb.toString();
		System.out.println(s.split("\\}\\,\\{").length);
		String news[] = s.split("\\}\\,\\{");
		
		String stringi;
		String stringj;
		String gname = "name:";
		String gtitle = "title:";
		String glife = "life:";
		String gphysical = "physical:";
		String gmagic = "magic:";
		String gdifficulty = "difficulty:";
		String gtags = "tags:";
		String gstory = "story:";
		String gbgs = "bgs:[";
		String gbgs_thumbnail = "bgs_thumbnail:[";
		String gAbility = "Ability:";
		String[] tagarr;
		for(int i = 0; i < news.length; i++){
//			System.out.println(news[i]);
			// 组成string
			stringi = news[i];
			String name = stringi.substring(stringi.indexOf(gname) + gname.length(), stringi.indexOf(gbgs) - 1);
			String title = stringi.substring(stringi.indexOf(gtitle) + gtitle.length(), stringi.indexOf(gname) - 1);
			String life = stringi.substring(stringi.indexOf(glife) + glife.length(), stringi.indexOf(gphysical) - 1);
			String physical = stringi.substring(stringi.indexOf(gphysical) + gphysical.length(), stringi.indexOf(gmagic) - 1);
			String magic = stringi.substring(stringi.indexOf(gmagic) + gmagic.length(), stringi.indexOf(gdifficulty) - 1);
			// 特殊点
			String difficulty = stringi.substring(stringi.indexOf(gdifficulty) + gdifficulty.length(), stringi.indexOf(gstory) - 2);
			String story = stringi.substring(stringi.indexOf(gstory) + gstory.length(), stringi.length());
//			System.out.println(name + title + life + physical + magic + difficulty + story);
			
			// tag
			String tag = stringi.substring(stringi.indexOf(gtags) + gtags.length() + 1, stringi.indexOf(gbgs_thumbnail) - 2);
//			System.out.println(tag);
			// 皮肤
			String bgs = stringi.substring(stringi.indexOf(gbgs) + gbgs.length(), stringi.indexOf(gtags) - 2);
//			System.out.println(bgs);
			// 皮肤头像
			String bgsh = stringi.substring(stringi.indexOf(gbgs_thumbnail) + gbgs_thumbnail.length(), stringi.indexOf(gAbility) - 2);
//			System.out.println(bgsh);
			
			// 组成
			outstr.append(name);
			// 开头
			outhead();
			
			outname();
			outstr.append(name+",\r\n");
			
			outtitle();
			outstr.append(title+",\r\n");
			
			outlife();
			outstr.append(life+",\r\n");
			
			outphysical();
			outstr.append(physical+",\r\n");
			
			outmagic();
			outstr.append(magic+",\r\n");
			
			outdifficulty();
			outstr.append(difficulty+",\r\n");
			
			outstory();
			outstr.append(story+",\r\n");
			
			outtags();
			outstr.append(tag+"),\r\n");
			
			outskin();
			outstr.append(bgs+"),\r\n");
			
			outskinhead();
			outstr.append(bgsh+")\r\n");
			
			// 末尾
			outstr.append("),\r\n");
		}
		System.out.println(outstr.toString());
		
		charOutStream();
	}
	
	public static void outhead(){
		String s = "=>array(\r\n";
		outstr.append(s);
	}
	public static void outname(){
		String s = "\"name\"=>";
		outstr.append(s);
	}
	public static void outtitle(){
		String s = "\"title\"=>";
		outstr.append(s);
	}
	public static void outlife(){
		String s = "\"life\"=>";
		outstr.append(s);
	}
	public static void outphysical(){
		String s = "\"physical\"=>";
		outstr.append(s);
	}
	public static void outmagic(){
		String s = "\"magic\"=>";
		outstr.append(s);
	}
	public static void outdifficulty(){
		String s = "\"difficulty\"=>";
		outstr.append(s);
	}

	public static void outstory(){
		String s = "\"story\"=>";
		outstr.append(s);
	}
	public static void outtags(){
		String s = "\"tags\"=>array(";
		outstr.append(s);
	}
	public static void outskin(){
		String s = "\"skin\"=>array(";
		outstr.append(s);
	}
	public static void outskinhead(){
		String s = "\"skinhead\"=>array(";
		outstr.append(s);
	}
	
	public static void charOutStream() throws Exception{
//		// 1：利用File类找到要操作的对象
//        File file = new File("E:\\test.txt");
//        if(!file.getParentFile().exists()){
//            file.getParentFile().mkdirs();
//        }
//        
//        //2：准备输出流
//        Writer out = new FileWriter();
//        out.write(outstr.toString());
//        out.close();.FileOutputStream s = new FileOutputStream("abc.txt");
		FileOutputStream s = new FileOutputStream("E:\\test.txt");
		OutputStreamWriter w = new OutputStreamWriter(s, "utf-8");
		PrintWriter pw = new PrintWriter(w);
		
		pw.println(outstr.toString());
//		pw.println("1");
//		pw.println("12");
		pw.flush();
		pw.close();
        
    }
}
