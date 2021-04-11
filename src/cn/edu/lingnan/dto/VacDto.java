package cn.edu.lingnan.dto;
/**
 * 对课程表vac进行信息传输
 */
public class VacDto {
	private String vac_id;
	private String vac_name;
	public String getCid() {
		return vac_id;
	}
	public void setCid(String vac_id) {
		this.vac_id = vac_id;
	}
	public String getCname() {
		return vac_name;
	}
	public void setCname(String vac_name) {
		this.vac_name = vac_name;
	}
}
