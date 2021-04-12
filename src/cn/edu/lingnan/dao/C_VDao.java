package cn.edu.lingnan.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import cn.edu.lingnan.dto.C_VDto;
import cn.edu.lingnan.dto.CountryDto;
import cn.edu.lingnan.util.DataAccess;

/**
 * 对c_v表的数据操作类
 */
public class C_VDao {
	//查找所有接种情况
	public Vector<C_VDto> findAllVac_Over_Num() {
		Vector<C_VDto> v=new Vector<C_VDto>();
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			String sql = "select * from c_v";
			prep = conn.prepareStatement(sql);
			rs = prep.executeQuery();
			while (rs.next()) {
				C_VDto s = new C_VDto();
				s.setCountry_id(rs.getString("country_id"));
				s.setVac_id(rs.getString("vac_id"));
				s.setVac_Over_Num(rs.getString("vac_over_num"));
				v.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataAccess.closeConnection(conn, prep, rs);
		}
		return v;
	}


	// 实现按country_id和vac_id查找接种情况
	public String findVac_Over_NumByCountry_idAndVac_id(String _country_id, String _vac_id) {
		String _vac_over_num = null;
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DataAccess.getConnection();
			String sql = "select * from c_v where country_id=? and vac_id=?";
			prep = conn.prepareStatement(sql);
			prep.setString(1, _country_id);
			prep.setString(2, _vac_id);
			rs = prep.executeQuery();
			if (rs.next())
				_vac_over_num = rs.getString("vac_over_num");
		} catch (ClassNotFoundException e) {
			System.out.println("判断一下是不是你的MySql连接JAR包出了问题.....");
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
//				if (stat != null)
//					stat.close();
				if (prep != null)
					prep.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return _vac_over_num;
	}

	// 插入一条接种情况信息
	// 返回值的可能性：0、失败（没国家没疫苗）：1、成功：2、有国家没疫苗：3、有疫苗没国家4、主键约束

	public int insertInfotoC_V(C_VDto _sd) {
		int flag = 0;
		int flagCountry = 0;
		int flagVac = 0;
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		String _country_id = _sd.getCountry_id();
		String _vac_id = _sd.getVac_id();
		String _vac_over_num = _sd.getVac_Over_Num();
		try {
			conn = DataAccess.getConnection();
			// 查接种情况表
			prep = conn.prepareStatement("select * from c_v where country_id=? and vac_id=?");
			prep.setString(1, _country_id);
			prep.setString(2, _vac_id);
			rs = prep.executeQuery();
			if (rs.next())
				return 4;
			rs.close();
			prep.close();
			// 查国家表
			prep = conn.prepareStatement("select * from country where country_id=?");
			prep.setString(1, _country_id);
			rs = prep.executeQuery();
			if (rs.next())
				flagCountry = 1;
			rs.close();
			prep.close();
			// 查疫苗表
			prep = conn.prepareStatement("select * from vac where vac_id=?");
			prep.setString(1, _vac_id);
			rs = prep.executeQuery();
			if (rs.next())
				flagVac = 1;
			rs.close();
			prep.close();
			if (flagCountry == 1 && flagVac == 1) {// 意味着可以执行插入操作
				String sql = "insert into c_v values(?,?,?)";// 一条语句写错两处地方。。。
				prep = conn.prepareStatement(sql);
				prep.setString(1, _country_id);
				prep.setString(2, _vac_id);
				prep.setString(3, _vac_over_num);
				prep.executeUpdate();
				flag = 1;// 若上方prep.executeUpdate()失败将直接跳转到catch块，flag不会被置为1
			}else
				if(flagCountry == 0 && flagVac == 1)
					flag=3;
				else
					if(flagCountry == 1 && flagVac == 0)
					flag=2;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataAccess.closeConnection(conn, prep, rs);
		}
		return flag;
	}
	//更新接种情况表(C_V表)
	public int updataC_V(C_VDto _sd) {
		int flag=0;
		Connection conn = null;
		PreparedStatement prep = null;
		try {
			conn = DataAccess.getConnection();
			prep = conn.prepareStatement
	("update c_v set Vac_Over_Num =? where country_id=? and vac_id=?");
			prep.setString(1, _sd.getVac_Over_Num());
			prep.setString(2, _sd.getCountry_id());
			prep.setString(3, _sd.getVac_id());
			prep.executeUpdate();
			flag=1;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataAccess.closeConnection(conn, prep);
		}
		return flag;
	}
	//删除C_V表
	public boolean deleteVac(String _country_id,String _vac_id) throws SQLException {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement prep1 = null;
		try {
			conn = DataAccess.getConnection();
			String sql0 =
					"delete from c_v where country_id=? and vac_id=?";
			prep1 = conn.prepareStatement(sql0);
			prep1.setString(1, _country_id);
			prep1.setString(2, _vac_id);
			prep1.executeUpdate();
			flag = true;
			prep1.close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return flag;
	}
}
