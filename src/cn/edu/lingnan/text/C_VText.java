package cn.edu.lingnan.text;

import cn.edu.lingnan.dao.C_VDao;
import cn.edu.lingnan.dto.C_VDto;

//对c_v类的测试
public class C_VText {
	public static void main(String[] args) {
//	C_VDao st=new C_VDao();
		C_VDao sd=new C_VDao();
		C_VDto s=new C_VDto();
//	System.out.println(st.findC_VBySidAndCid("s01", "c02"));
//		System.out.println(sd.findC_VBySidAndCid("s01", "c02"));
//		s.setSid("s05");
//		s.setCid("c05");
//		s.setC_V(99);
//		System.out.println(sd.insertInfotoC_V(s));
		s.setSid("s05");
		s.setCid("c05");
		s.setVac_Over_Num("66");
		System.out.println(sd.updataC_V(s));
	}
}
