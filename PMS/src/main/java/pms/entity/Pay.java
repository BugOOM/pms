package pms.entity;

import java.util.Date;

public class Pay {
	private Integer payId;
	private Integer chargeType;
	private Integer payUse;
	private Integer payTotal;
	private Integer payStatus;
	private Integer houseId;
	private Date payTime;

	public Integer getPayId() {
		return payId;
	}

	public Date getPayTime() {
		return payTime;
	}

	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}

	public void setPayId(Integer payId) {
		this.payId = payId;
	}

	public Integer getChargeType() {
		return chargeType;
	}

	public void setChargeType(Integer chargeType) {
		this.chargeType = chargeType;
	}

	public Integer getPayUse() {
		return payUse;
	}

	public void setPayUse(Integer payUse) {
		this.payUse = payUse;
	}

	public Integer getPayTotal() {
		return payTotal;
	}

	public void setPayTotal(Integer payTotal) {
		this.payTotal = payTotal;
	}

	public Integer getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(Integer payStatus) {
		this.payStatus = payStatus;
	}

	public Integer getHouseId() {
		return houseId;
	}

	public void setHouseId(Integer houseId) {
		this.houseId = houseId;
	}

}
