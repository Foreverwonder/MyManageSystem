package cn.edu.lingnan.dto;
/**
 *对国家表进行的信息传输
 */
public class CountryDto {
	private String country_id;
	private String country_name;
	private String people;
	public String getCountry_id() {
		return country_id;
	}
	public void setCountry_id(String country_id) {
		this.country_id = country_id;
	}
	public String getCountry_name() {
		return country_name;
	}
	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}
	public String getPeople() {
		return people;
	}
	public void setPeople(String people) {
		this.people = people;
	}
	public int getVac_able() {
		return vac_able;
	}
	public void setVac_able(int vac_able) {
		this.vac_able = vac_able;
	}
	private int vac_able;
	
}
