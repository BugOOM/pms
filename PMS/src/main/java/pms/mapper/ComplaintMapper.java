package pms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pms.entity.Complaint;

public interface ComplaintMapper {
	void insertComplaint(Complaint complaint);

	List<Complaint> findMyComplaint(@Param("complaint") Complaint complaint, @Param("username") String username);

	Integer countComplaint(@Param("complaint") Complaint complaint, @Param("username") String username);

	void handleComplaint(@Param("complaintId") String complaintId, @Param("complaintStatus") String complaintStatus);

}
