package cn.edu.lingnan.dao;

import java.sql.*;
import java.util.Vector;

import cn.edu.lingnan.dto.CountryDto;
import com.sun.net.httpserver.Authenticator.Result;
import cn.edu.lingnan.dto.VacDto;
import cn.edu.lingnan.dto.ScoreDto;
import cn.edu.lingnan.util.DataAccess;

/**
 * 对课表vac的操作类
 */
public class VacDao {
    //通过vac_id找name
    public String findCnameByCid(String _vac_id) {
        String _vac_name = null;
        Connection conn = null;
        PreparedStatement prep = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DataAccess.getConnection();
            String sql = "select * from vac where vac_id=?";
            prep = conn.prepareStatement(sql);
            prep.setString(1, _vac_id);
            rs = prep.executeQuery();
            if (rs.next())
                _vac_name = rs.getString("vac_name");
        } catch (ClassNotFoundException e) {
            System.out.println("检查Mysql的jar导入是否正确");
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (prep != null)
                    prep.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return _vac_name;
    }


    //课程表插入一条信息
    public int insertInfoToVac(VacDto _cd) {
        int flag = 0;
        Connection conn = null;
        PreparedStatement prep = null;
        Result rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DataAccess.getConnection();
            String sql =
                    "insert into vac values(?,?)";
            prep = conn.prepareStatement(sql);
            prep.setString(1, _cd.getCid());
            prep.setString(2, _cd.getCname());
            int i = prep.executeUpdate();
            System.out.println("i=" + i);
            flag = 1;
        } catch (ClassNotFoundException e) {
            System.out.println("检查Mysql的jar导入是否正确");
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
//				if (rs!= null)
//					rs.close();
                if (prep != null)
                    prep.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return flag;
    }

    //更新课程表
    //vac_id是主键
    public int updataVac(VacDto _sd) {
        int flag = 0;
        Connection conn = null;
        PreparedStatement prep = null;
        try {
            conn = DataAccess.getConnection();
            prep = conn.prepareStatement
                    ("update vac set vac_name =? where vac_id=?");
            prep.setString(1, _sd.getCname());
            prep.setString(2, _sd.getCid());
            prep.executeUpdate();
            flag = 1;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DataAccess.closeConnection(conn, prep);
        }
        return flag;
    }


    //删除课程表(若该vac_id在c_v表中只有0条记录，则直接删除，否则不删除)
    public boolean deleteVac(String _vac_id) throws SQLException {
        boolean flag = false;
        Connection conn = null;
        PreparedStatement prep1 = null;
        PreparedStatement prep2 = null;
        Statement stat = null;
        ResultSet rs1 = null;
        ResultSet rs2 = null;
        try {
            conn = DataAccess.getConnection();
            //----------通过学生编号找到待删除的课程，存入动态数组中------------------------
//            Vector<String> v = new Vector<String>();
            String sql0 =
                    "select count(*) as num from c_v where vac_id=?";
            prep1 = conn.prepareStatement(sql0);
            prep1.setString(1, _vac_id);
            rs1 = prep1.executeQuery();
            rs1.next();
            if (Integer.parseInt(rs1.getString("num")) == 0) {
//                System.out.println("要删除的课程号：" + _vac_id);
                String sql1 = "delete from vac where vac_id=?";
                prep1 = conn.prepareStatement(sql1);
                prep1.setString(1, _vac_id);
                prep1.executeUpdate();
            flag=true;
            }
            prep1.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return flag;
    }
    // 查找所有的课程信息（改）
    public Vector<VacDto> findAllVac() {
        Vector<VacDto> v = new Vector<>();
        Connection conn = null;
        PreparedStatement prep = null;
        ResultSet rs = null;
        try {
            conn = DataAccess.getConnection();
            String sql = "select * from vac";
            prep = conn.prepareStatement(sql);
            rs = prep.executeQuery();
            while (rs.next()) {
                VacDto c = new VacDto();
                c.setCid(rs.getString("vac_id"));
                c.setCname(rs.getString("vac_name"));
                v.add(c);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            DataAccess.closeConnection(conn, prep, rs);
        }
        return v;
    }
}






