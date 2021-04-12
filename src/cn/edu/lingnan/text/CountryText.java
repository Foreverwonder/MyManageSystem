package cn.edu.lingnan.text;

import java.sql.SQLException;
import java.util.Vector;

import cn.edu.lingnan.dao.CountryDao;
import cn.edu.lingnan.dto.CountryDto;

public class CountryText {
		public static void main(String[] args) throws SQLException {
			CountryDao sd=new CountryDao();
//			System.out.println(sd.findCountryByNameAndPeople("zhangsan2","123"));
//			Vector<CountryDto> v=new Vector<CountryDto>();
//			v=sd.findAllCountry();
//			for(CountryDto s:v)
//				System.out.println(s.getCountry_name());
			CountryDto s=new CountryDto();
//			s.setCountry_id("s01");
//			s.setCountry_name("zhangsan5");
//			s.setPeople("123");
//			s.setVac_able(1);
//			System.out.println(sd.insertInfoToCountry(s));
//			System.out.println(sd.updataCountryCountry_name(s));
//			System.out.println(sd.updataCountryPeople(s));
//			System.out.println(sd.updataCountryVac_able(s));
			System.out.println(sd.deleteCountry("s05"));
		}
}
