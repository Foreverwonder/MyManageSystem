package cn.edu.lingnan.text;

import cn.edu.lingnan.dao.C_VDao;
import cn.edu.lingnan.dto.C_VDto;

import java.sql.SQLException;

//对c_v类的测试
public class C_VText {
	public static void main(String[] args) throws SQLException {
//	C_VDao st=new C_VDao();
		C_VDao sd=new C_VDao();
		System.out.println(sd.deleteVac("c12","v05"));
//		C_VDto s=new C_VDto();
//	System.out.println(st.findC_VByCountry_idAndVac_id("s01", "c02"));
//		System.out.println(sd.findC_VByCountry_idAndVac_id("s01", "c02"));
//		s.setCountry_id("s05");
//		s.setVac_id("c05");
//		s.setC_V(99);
//		System.out.println(sd.insertInfotoC_V(s));
//		s.setCountry_id("s05");
//		s.setVac_id("c05");
//		s.setVac_Over_Num("66");
//		System.out.println(sd.updataC_V(s));
	}
}
