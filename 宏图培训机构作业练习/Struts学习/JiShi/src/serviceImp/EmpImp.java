package serviceImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.taglibs.standard.tag.common.core.ParamParent;

import common.Dbconnection;
import form.EmpForm;
import serviceI.EmpI;

public class EmpImp implements EmpI{

	@Override
	public List selemp() {
		List list=new ArrayList();
		Connection conn=Dbconnection.getconnection();
		String sql="select * from jsemp";
		try {
			PreparedStatement prst=conn.prepareStatement(sql);
			ResultSet rs=prst.executeQuery();
			while(rs.next()){
				EmpForm emp=new EmpForm();
				emp.setEmp_id(rs.getInt("emp_id"));
				emp.setEmp_name(rs.getString("emp_name"));
				emp.setEmp_sex(rs.getString("emp_sex"));
				emp.setEmp_salary(rs.getFloat("emp_salary"));
				emp.setJoin_date(rs.getString("join_date"));
				list.add(emp);
			}
			
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return list;
		
	}

	@Override
	public void delemp(int id) {
		Connection conn=Dbconnection.getconnection();
		String sql="delete from jsemp where emp_id=?";
		try {
			PreparedStatement prst=conn.prepareStatement(sql);
			prst.setInt(1, id);
			prst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}

	@Override
	public EmpForm toalter(int id) {
		EmpForm emp=new EmpForm();
		Connection conn=Dbconnection.getconnection();
		String sql="select * from jsemp where emp_id=?";
		try {
			PreparedStatement prst=conn.prepareStatement(sql);
			prst.setInt(1, id);
			ResultSet rs=prst.executeQuery();
			while(rs.next()){
				emp.setEmp_id(rs.getInt("emp_id"));
				emp.setEmp_name(rs.getString("emp_name"));
				emp.setEmp_sex(rs.getString("emp_sex"));
				emp.setEmp_salary(rs.getFloat("emp_salary"));
				emp.setJoin_date(rs.getString("join_date"));
			}
			
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return emp;
	}

	@Override
	public void alter(EmpForm emp) {
		Connection conn=Dbconnection.getconnection();
		String sql="update jsemp set emp_name=?,emp_sex=?,emp_salary=?,join_date=to_date(?,'yyyy-mm-dd hh24:mi:ss') where emp_id=?";
		try {
			PreparedStatement prst=conn.prepareStatement(sql);
			prst.setString(1, emp.getEmp_name());
			prst.setString(2, emp.getEmp_sex());
			prst.setFloat(3, emp.getEmp_salary());
			prst.setString(4, emp.getJoin_date());
			prst.setInt(5, emp.getEmp_id());
			prst.executeUpdate();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	@Override
	public void addemp(EmpForm emp) {
		Connection conn=Dbconnection.getconnection();
		String sql="insert into jsemp values(?,?,?,?,to_date(?,'yyyy-mm-dd hh24:mi:ss'))";
		try {
			PreparedStatement prst=conn.prepareStatement(sql);
			prst.setInt(1, emp.getEmp_id());
			prst.setString(2, emp.getEmp_name());
			prst.setString(3, emp.getEmp_sex());
			prst.setFloat(4, emp.getEmp_salary());
			prst.setString(5, emp.getJoin_date());
			prst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

}
