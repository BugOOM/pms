package pms.entity;

import java.util.Date;

public class Dept {
	private Integer deptId;
	private String deptName;
	private Integer deptFloor;
	private Integer deptNum;
	private Date deptTime;
	private Integer deptArea;

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Integer getDeptFloor() {
		return deptFloor;
	}

	public void setDeptFloor(Integer deptFloor) {
		this.deptFloor = deptFloor;
	}

	public Integer getDeptNum() {
		return deptNum;
	}

	public void setDeptNum(Integer deptNum) {
		this.deptNum = deptNum;
	}

	public Date getDeptTime() {
		return deptTime;
	}

	public void setDeptTime(Date deptTime) {
		this.deptTime = deptTime;
	}

	public Integer getDeptArea() {
		return deptArea;
	}

	public void setDeptArea(Integer deptArea) {
		this.deptArea = deptArea;
	}

}
