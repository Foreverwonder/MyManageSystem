package cn.edu.lingnan.dto;
/**
 *对学生表进行的信息传输 
 */
public class CountryDto {
	private String country_id;
	private String country_name;
	private String people;
	public String getSid() {
		return country_id;
	}
	public void setSid(String country_id) {
		this.country_id = country_id;
	}
	public String getSname() {
		return country_name;
	}
	public void setSname(String country_name) {
		this.country_name = country_name;
	}
	public String getPassword() {
		return people;
	}
	public void setPassword(String people) {
		this.people = people;
	}
	public int getSuperuser() {
		return vac_able;
	}
	public void setSuperuser(int vac_able) {
		this.vac_able = vac_able;
	}
	private int vac_able;
	
}
