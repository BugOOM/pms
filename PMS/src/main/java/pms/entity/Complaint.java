package pms.entity;

import java.util.Date;

public class Complaint {
	private Integer complaintId;
	private String complaintUser;
	private String complaintTitle;
	private String complaintContent;
	private Date complaintTime;
	private Integer complaintStatus;

	@Override
	public String toString() {
		return "Complaint [complaintId=" + complaintId + ", complaintUser=" + complaintUser + ", complaintTitle="
				+ complaintTitle + ", complaintContent=" + complaintContent + ", complaintTime=" + complaintTime
				+ ", complaintStatus=" + complaintStatus + "]";
	}

	public String getComplaintTitle() {
		return complaintTitle;
	}

	public void setComplaintTitle(String complaintTitle) {
		this.complaintTitle = complaintTitle;
	}

	public Integer getComplaintId() {
		return complaintId;
	}

	public void setComplaintId(Integer complaintId) {
		this.complaintId = complaintId;
	}

	public String getComplaintUser() {
		return complaintUser;
	}

	public void setComplaintUser(String complaintUser) {
		this.complaintUser = complaintUser;
	}

	public String getComplaintContent() {
		return complaintContent;
	}

	public void setComplaintContent(String complaintContent) {
		this.complaintContent = complaintContent;
	}

	public Date getComplaintTime() {
		return complaintTime;
	}

	public void setComplaintTime(Date complaintTime) {
		this.complaintTime = complaintTime;
	}

	public Integer getComplaintStatus() {
		return complaintStatus;
	}

	public void setComplaintStatus(Integer complaintStatus) {
		this.complaintStatus = complaintStatus;
	}

}
