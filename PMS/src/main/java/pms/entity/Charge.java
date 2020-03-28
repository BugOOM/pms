package pms.entity;

public class Charge {
	private Integer chargeType;
	private String chargeName;
	private Integer chargeThreshold;
	private Integer chargeLow;
	private Integer chargeHigh;

	public Integer getChargeType() {
		return chargeType;
	}

	public void setChargeType(Integer chargeType) {
		this.chargeType = chargeType;
	}

	public String getChargeName() {
		return chargeName;
	}

	public void setChargeName(String chargeName) {
		this.chargeName = chargeName;
	}

	public Integer getChargeThreshold() {
		return chargeThreshold;
	}

	public void setChargeThreshold(Integer chargeThreshold) {
		this.chargeThreshold = chargeThreshold;
	}

	public Integer getChargeLow() {
		return chargeLow;
	}

	public void setChargeLow(Integer chargeLow) {
		this.chargeLow = chargeLow;
	}

	public Integer getChargeHigh() {
		return chargeHigh;
	}

	public void setChargeHigh(Integer chargeHigh) {
		this.chargeHigh = chargeHigh;
	}

}
