package pms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pms.entity.Complaint;
import pms.mapper.ComplaintMapper;
import pms.service.ComplaintService;

@Service
public class ComplaintServiceImpl implements ComplaintService {

	@Autowired
	private ComplaintMapper complaintMapper;

	@Override
	public void insertComplaint(Complaint complaint) {
		// TODO Auto-generated method stub
		complaintMapper.insertComplaint(complaint);
	}

	@Override
	public List<Complaint> findMyComplaint(Complaint complaint, String username) {
		// TODO Auto-generated method stub
		return complaintMapper.findMyComplaint(complaint, username);
	}

	@Override
	public Integer countComplaint(Complaint complaint, String username) {
		// TODO Auto-generated method stub
		return complaintMapper.countComplaint(complaint, username);
	}

	@Override
	public void handleComplaint(String complaintId, String complaintStatus) {
		// TODO Auto-generated method stub
		complaintMapper.handleComplaint(complaintId, complaintStatus);
	}

}
