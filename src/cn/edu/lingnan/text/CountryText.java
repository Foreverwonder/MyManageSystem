package cn.edu.lingnan.text;

import java.sql.SQLException;
import java.util.Vector;

import cn.edu.lingnan.dao.CountryDao;
import cn.edu.lingnan.dto.CountryDto;

public class CountryText {
		public static void main(String[] args) throws SQLException {
			CountryDao sd=new CountryDao();
//			System.out.println(sd.findCountryByNameAndPassword("zhangsan2","123"));
//			Vector<CountryDto> v=new Vector<CountryDto>();
//			v=sd.findAllCountry();
//			for(CountryDto s:v)
//				System.out.println(s.getSname());
			CountryDto s=new CountryDto();
//			s.setSid("s01");
//			s.setSname("zhangsan5");
//			s.setPassword("123");
//			s.setSuperuser(1);
//			System.out.println(sd.insertInfoToCountry(s));
//			System.out.println(sd.updataCountrySname(s));
//			System.out.println(sd.updataCountryPassword(s));
//			System.out.println(sd.updataCountrySuperuser(s));
			System.out.println(sd.deleteCountry("s05"));
		}
}
