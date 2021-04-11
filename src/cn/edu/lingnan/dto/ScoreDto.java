package cn.edu.lingnan.dto;

public class ScoreDto {
	private String country_id;
	private String vac_id;
	private String vac_over_num;
	public String getSid() {
		return country_id;
	}
	public void setSid(String country_id) {
		this.country_id = country_id;
	}
	public String getCid() {
		return vac_id;
	}
	public void setCid(String vac_id) {
		this.vac_id = vac_id;
	}
	public String getScore() {
		return vac_over_num;
	}
	public void setScore(String vac_over_num) {
		this.vac_over_num = vac_over_num;
	}
}
