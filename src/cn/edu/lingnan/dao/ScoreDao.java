package cn.edu.lingnan.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import cn.edu.lingnan.dto.ScoreDto;
import cn.edu.lingnan.dto.CountryDto;
import cn.edu.lingnan.util.DataAccess;

/**
 * 对c_v表的数据操作类
 */
public class ScoreDao {
	//查找所有成绩
	public Vector<ScoreDto> findAllScore() {
		Vector<ScoreDto> v=new Vector<ScoreDto>();
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			String sql = "select * from c_v";
			prep = conn.prepareStatement(sql);
			rs = prep.executeQuery();
			while (rs.next()) {
				ScoreDto s = new ScoreDto();
				s.setSid(rs.getString("country_id"));
				s.setCid(rs.getString("vac_id"));
				v.add(s);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataAccess.closeConnection(conn, prep, rs);
		}
		return v;
	}


	// 实现按country_id和vac_id查找成绩
	public String findScoreBySidAndCid(String _country_id, String _vac_id) {
		String _vac_over_num = null;
		Connection conn = null;
//		Statement stat = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DataAccess.getConnection();
//			stat = conn.createStatement();
//			String sql = "select * from c_v where country_id='" + _country_id + "' and vac_id='" + _vac_id + "'";
			String sql = "select * from c_v where country_id=? and vac_id=?";
			prep = conn.prepareStatement(sql);
			prep.setString(1, _country_id);
			prep.setString(2, _vac_id);
//			rs = stat.executeQuery(sql);
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

	// 插入一条分数信息
	// 返回值的可能性：0、失败（没学生没课程）：1、成功：2、有学生没课程：3、有课程没学生4、主键约束

	public int insertInfotoScore(ScoreDto _sd) {
		int flag = 0;
		int flagCountry = 0;
		int flagVac = 0;
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		String _country_id = _sd.getSid();
		String _vac_id = _sd.getCid();
		String _vac_over_num = _sd.getScore();
		try {
			conn = DataAccess.getConnection();
			// 查分数表
			prep = conn.prepareStatement("select * from c_v where country_id=? and vac_id=?");
			prep.setString(1, _country_id);
			prep.setString(2, _vac_id);
			rs = prep.executeQuery();
			if (rs.next())
				return 4;
			rs.close();
			prep.close();
			// 查学生表
			prep = conn.prepareStatement("select * from country where country_id=?");
			prep.setString(1, _country_id);
			rs = prep.executeQuery();
			if (rs.next())
				flagCountry = 1;
			rs.close();
			prep.close();
			// 查课程表
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
	//更新分数表
	public int updataScore(ScoreDto _sd) {
		int flag=0;
		Connection conn = null;
		PreparedStatement prep = null;
		try {
			conn = DataAccess.getConnection();
			prep = conn.prepareStatement
	("update c_v set c_v =? where country_id=? and vac_id=?");
			prep.setString(1, _sd.getScore());
			prep.setString(2, _sd.getSid());
			prep.setString(3, _sd.getCid());
			prep.executeUpdate();
			flag=1;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataAccess.closeConnection(conn, prep);
		}
		return flag;
	}
}
