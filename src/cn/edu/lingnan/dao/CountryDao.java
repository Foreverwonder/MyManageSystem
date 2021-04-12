package cn.edu.lingnan.dao;

import cn.edu.lingnan.dto.CountryDto;
import cn.edu.lingnan.util.DataAccess;

import java.sql.*;
import java.util.Vector;

/**
 * 完成对国家表的数据操作类
 */
public class CountryDao {
    //通过country_id找国家
    public String findCountryByCountry_id(String _country_id) {
        String _country_name = null;
        Connection conn = null;
        PreparedStatement prep = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DataAccess.getConnection();
            String sql = "select * from country where country_id=?";
            prep = conn.prepareStatement(sql);
            prep.setString(1, _country_id);
            rs = prep.executeQuery();
            if (rs.next())
                _country_name = rs.getString("country_name");
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
        return _country_name;
    }
    // 实现按国家名和人口进行查找，存在即返回1。
    public boolean findCountryByNameAndPeople(String _country_name, String _people) {
        boolean flag = false;
        Connection conn = null;
        PreparedStatement prep = null;
        ResultSet rs = null;
        //---------------------------------省去了数据库连接的try写法:
        try {
            conn = DataAccess.getConnection();
            String sql = "select * from country where country_name=? and people =?";// 写'"
            prep = conn.prepareStatement(sql);
            prep.setString(1, _country_name);
            prep.setString(2, _people);
            rs = prep.executeQuery();
            if (rs.next())
                flag = true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DataAccess.closeConnection(conn, prep, rs);
        }
        return flag;
    }


    // 查找所有的国家信息
    public Vector<CountryDto> findAllCountry() {
        Vector<CountryDto> v = new Vector<CountryDto>();
        Connection conn = null;
//		Statement stat = null;
        PreparedStatement prep = null;
        ResultSet rs = null;
        try {
            conn = DataAccess.getConnection();
            String sql = "select * from country";
            prep = conn.prepareStatement(sql);
            rs = prep.executeQuery();
            while (rs.next()) {
                CountryDto s = new CountryDto();
                s.setCountry_id(rs.getString("country_id"));
                s.setCountry_name(rs.getString("country_name"));
                s.setPeople(rs.getString("people"));
                s.setVac_able(rs.getInt("vac_able"));
                v.add(s);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            DataAccess.closeConnection(conn, prep, rs);
        }
        return v;
    }


    //插入一条国家记录
    public int insertInfoToCountry(CountryDto _sd) {
        int flag = 0;
        Connection conn = null;
        PreparedStatement prep = null;
        ResultSet rs = null;
        try {
            conn = DataAccess.getConnection();
            String sql =
                    "insert into country values(?,?,?,?)";//一条语句写错两处地方。。。
            prep = conn.prepareStatement(sql);
            prep.setString(1, _sd.getCountry_id());
            prep.setString(2, _sd.getCountry_name());
            prep.setString(3, _sd.getPeople());
            prep.setInt(4, _sd.getVac_able());
            int i = prep.executeUpdate();
            System.out.println("i=" + i);
            flag = 1;//若上方prep.executeUpdate()失败将直接跳转到catch块，flag不会被置为1
        }
        catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DataAccess.closeConnection(conn, prep, rs);
        }
        return flag;
    }

    //更新国家表_国家名字
    public int updataCountryCountry_name(CountryDto _sd) {
        int flag = 0;
        Connection conn = null;
        PreparedStatement prep = null;
        try {
            conn = DataAccess.getConnection();
            prep = conn.prepareStatement
                    ("update country set country_name =? where country_id=?");
            prep.setString(1, _sd.getCountry_name());
            prep.setString(2, _sd.getCountry_id());
            prep.executeUpdate();
            flag = 1;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DataAccess.closeConnection(conn, prep);
        }
        return flag;
    }


    //更新国家表_国家人口
    public int updataCountryPeople(CountryDto _sd) {
        int flag = 0;
        Connection conn = null;
        PreparedStatement prep = null;
        try {
            conn = DataAccess.getConnection();
            prep = conn.prepareStatement
                    ("update country set people =? where country_id=?");
            prep.setString(1, _sd.getPeople());
            prep.setString(2, _sd.getCountry_id());
            prep.executeUpdate();
            flag = 1;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DataAccess.closeConnection(conn, prep);
        }
        return flag;
    }

    //更新国家表_国家是否研发疫苗
    public int updataCountryVac_able(CountryDto _sd) {
        int flag = 0;
        Connection conn = null;
        PreparedStatement prep = null;
        try {
            conn = DataAccess.getConnection();
            prep = conn.prepareStatement
                    ("update country set vac_able =? where country_id=?");
            prep.setInt(1, _sd.getVac_able());
            prep.setString(2, _sd.getCountry_id());
            prep.executeUpdate();
            flag = 1;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DataAccess.closeConnection(conn, prep);
        }
        return flag;
    }


    //删除一条国家记录
    public boolean deleteCountry(String _country_id) throws SQLException {
        boolean flag = false;
        Connection conn = null;
        PreparedStatement prep1 = null;
        PreparedStatement prep2 = null;
        Statement stat = null;
        ResultSet rs1 = null;
        ResultSet rs2 = null;
        try {
            conn = DataAccess.getConnection();
            //----------通过国家编号找到待删除的疫苗，存入动态数组中------------------------
            Vector<String> v = new Vector<String>();
            String sql0 =
                    "select * from c_v where country_id=?";
            prep1 = conn.prepareStatement(sql0);
            prep1.setString(1, _country_id);
            rs1 = prep1.executeQuery();
            System.out.println("567567");

            while (rs1.next()) {
                //这里已经找到s01国家所选的疫苗编号，C01，C02
                String cid = rs1.getString("cid");
                System.out.println(cid);
                //找一下这个疫苗编号对应多少条记录，如果只有一条，就删除对应的疫苗编号
                String sql01 =
                        "select count(*) as num from c_v where cid=? ";
                prep2 = conn.prepareStatement(sql01);
                prep2.setString(1, cid);
                rs2 = prep2.executeQuery();
                rs2.next();
                if (Integer.parseInt(rs2.getString("num")) == 1) {
                    System.out.println("要删除的编号：" + cid);
                    //找到了，用不了，先存起来
                    v.add(cid);
                }
            }
            if (prep2 != null) {
                prep2.close();
            }
            prep1.close();
            rs1.close();
            if (rs2 != null) {
                rs2.close();
            }
            //-----------------------------------------------------------------------------
            conn.setAutoCommit(false);
            //先删接种情况表
            String sql1 =
                    "delete from c_v where country_id=?";
            prep1 = conn.prepareStatement(sql1);
            prep1.setString(1, _country_id);
            prep1.executeUpdate();
            prep1.close();
            //再删国家表
            String sql2 =
                    "delete from country where country_id=?";//------------------------
            prep1 = conn.prepareStatement(sql2);
            prep1.setString(1, _country_id);
            prep1.executeUpdate();
            //最后删疫苗表
            for (String s : v) {
                stat = conn.createStatement();
                stat.executeUpdate
                        ("delete from course where cid= '" + s + "'");
            }
            conn.commit();
            conn.setAutoCommit(true);
            flag = true;


        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            } finally {
                DataAccess.closeConnection(conn, prep1, rs1);
            }

        }
        return flag;
    }
}
