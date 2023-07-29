package QQcloudlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import QQcloudlet.QQweiyun;
import ��װ���ݿ�����.�������ݿ�;

public class QQweiyunfafang implements QQweiyunjiekou{
	//΢�Ʒ���
	//��ѯ�Ƿ�����ļ�
	public Vector<Vector> selfile(String qqnum,String layout) {
		Vector<Vector> vec=new Vector<Vector>();
		Connection conn=�������ݿ�.shujuku();
		String sql="select * from weiyun where qqnum=? and filelayout=?";
		PreparedStatement pre;
		try {
			pre = conn.prepareStatement(sql);
			pre.setString(1, qqnum);//qq��
			pre.setString(2, layout);//qq��
			ResultSet rs=pre.executeQuery();
			while(rs.next()){//������� �����Լ�����Ϣ
				Vector zy=new Vector();
				zy.add(rs.getString("filenames"));
				zy.add(rs.getString("filelayout"));
				vec.add(zy);
			}
			rs.close();
			pre.close();
			conn.close();
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
		return vec;
	}

		@Override
		public boolean updfile2(QQweiyun wy) {
			Connection conn=�������ݿ�.shujuku();
			String sql="insert into weiyun values(?,?,?,?,?,?)";//�����û�������� ��������
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
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
			
			return false;
		}

		@Override
		public QQweiyun selfile2(String qqnum, String filename,String layout) {
			
			Connection conn=�������ݿ�.shujuku();
			String sql="select * from weiyun where qqnum=? and filelayout=? and filenames=?";
			PreparedStatement pre;
			try {
				pre = conn.prepareStatement(sql);
				pre.setString(1, qqnum);//qq��
				pre.setString(2, layout);//qq��
				pre.setString(3, filename);//qq��
				ResultSet rs=pre.executeQuery();
				while(rs.next()){//������� �����Լ�����Ϣ
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
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
			
			return null;
		}

}
