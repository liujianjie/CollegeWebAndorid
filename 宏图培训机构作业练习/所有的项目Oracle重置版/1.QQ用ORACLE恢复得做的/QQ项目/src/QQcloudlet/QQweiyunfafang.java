package QQcloudlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import QQcloudlet.QQweiyun;
import 封装数据库链接.连接数据库;

public class QQweiyunfafang implements QQweiyunjiekou{
	//微云方法
	//查询是否存在文件
	public Vector<Vector> selfile(String qqnum,String layout) {
		Vector<Vector> vec=new Vector<Vector>();
		Connection conn=连接数据库.shujuku();
		String sql="select * from weiyun where qqnum=? and filelayout=?";
		PreparedStatement pre;
		try {
			pre = conn.prepareStatement(sql);
			pre.setString(1, qqnum);//qq号
			pre.setString(2, layout);//qq号
			ResultSet rs=pre.executeQuery();
			while(rs.next()){//如果存在 返回自己的信息
				Vector zy=new Vector();
				zy.add(rs.getString("filenames"));
				zy.add(rs.getString("filelayout"));
				vec.add(zy);
			}
			rs.close();
			pre.close();
			conn.close();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		return vec;
	}

		@Override
		public boolean updfile2(QQweiyun wy) {
			Connection conn=连接数据库.shujuku();
			String sql="insert into weiyun values(?,?,?,?,?,?)";//这个是没有主键的 无需序列
			try {
				PreparedStatement pre=conn.prepareStatement(sql);
				int i=1;
				pre.setString(i++,wy.getQqnum());
				pre.setString(i++,wy.getQqname());
				pre.setString(i++,wy.getFilepath());
				pre.setString(i++,wy.getFilenames());
				pre.setString(i++,wy.getDate());
				pre.setString(i++,wy.getFilelayout());
				int ii=pre.executeUpdate();
				if(ii>0){
					return true;
				}
				pre.close();
				conn.close();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			
			return false;
		}

		@Override
		public QQweiyun selfile2(String qqnum, String filename,String layout) {
			
			Connection conn=连接数据库.shujuku();
			String sql="select * from weiyun where qqnum=? and filelayout=? and filenames=?";
			PreparedStatement pre;
			try {
				pre = conn.prepareStatement(sql);
				pre.setString(1, qqnum);//qq号
				pre.setString(2, layout);//qq号
				pre.setString(3, filename);//qq号
				ResultSet rs=pre.executeQuery();
				while(rs.next()){//如果存在 返回自己的信息
					QQweiyun wy=new QQweiyun();
					wy.setQqnum(rs.getString("qqnum"));
					wy.setQqname(rs.getString("qqname"));
					wy.setFilepath(rs.getString("filepath"));
					wy.setFilenames(rs.getString("filenames"));
					wy.setDate(rs.getString("dateremix"));
					wy.setFilelayout(rs.getString("filelayout"));
					return wy;
				}
				rs.close();
				pre.close();
				conn.close();
			} catch (Exception e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			
			return null;
		}

}
