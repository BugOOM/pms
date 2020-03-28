package pms.entity;

import java.util.Date;

public class PayHouse {
	private Integer payId;
	private String deptName;
	private String houseNum;
	private String ownerName;
	private String ownerPhone;
	private String chargeName;
	private Integer payUse;
	private Integer payTotal;
	private Integer payStatus;
	private Date payTime;
	private Integer ownerId;// 用于提醒发邮件时使用

	public Date getPayTime() {
		return payTime;
	}

	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}

	public Integer getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
	}

	public Integer getPayId() {
		return payId;
	}

	public void setPayId(Integer payId) {
		this.payId = payId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getHouseNum() {
		return houseNum;
	}

	public void setHouseNum(String houseNum) {
		this.houseNum = houseNum;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getOwnerPhone() {
		return ownerPhone;
	}

	public void setOwnerPhone(String ownerPhone) {
		this.ownerPhone = ownerPhone;
	}

	public String getChargeName() {
		return chargeName;
	}

	public void setChargeName(String chargeName) {
		this.chargeName = chargeName;
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

}
