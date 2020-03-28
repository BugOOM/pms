package pms.service;

import java.util.List;

import pms.entity.Complaint;

public interface ComplaintService {
	void insertComplaint(Complaint complaint);

	List<Complaint> findMyComplaint(Complaint complaint, String username);

	Integer countComplaint(Complaint complaint, String username);

	void handleComplaint(String complaintId, String complaintStatus);
}
