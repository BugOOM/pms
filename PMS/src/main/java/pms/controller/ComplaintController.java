package pms.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import pms.entity.AdminModel;
import pms.entity.Complaint;
import pms.entity.Model;
import pms.service.ComplaintService;

@Controller
@RequestMapping("/complaint")
public class ComplaintController {
	@Autowired
	private ComplaintService complaintService;

	@RequestMapping("/push")
	@ResponseBody
	public AdminModel push(String content, String title, HttpSession session) {
		AdminModel model = new AdminModel();
		String username = ((AdminModel) session.getAttribute("user")).getData().getUsername();
		Complaint complaint = new Complaint();
		complaint.setComplaintContent(content);
		complaint.setComplaintTitle(title);
		complaint.setComplaintUser(username);
		complaint.setComplaintStatus(0);
		complaint.setComplaintTime(new Date());
		complaintService.insertComplaint(complaint);
		model.setCode(0);
		model.setMsg("投诉成功,等待解决 ");
		return model;
	}

	@RequestMapping("/findMyComplaint")
	@ResponseBody
	public Model findMyComplaint(@RequestParam(value = "page", defaultValue = "10") Integer page,
			@RequestParam(value = "limit", defaultValue = "10") Integer limit, HttpSession session, Complaint complaint,
			String admin) {

		String username = ((AdminModel) session.getAttribute("user")).getData().getUsername();
		if (admin != null)
			username = null;
		Model model = new Model();
		PageHelper.startPage(page, limit);
		List<Complaint> list = complaintService.findMyComplaint(complaint, username);
		PageInfo<Complaint> facilityInfo = new PageInfo<>(list);
		if (list.size() == 0) {
			model.setCode(1);
			model.setMsg("没有数据哦");
		} else {
			model.setCode(0);
			model.setCount(complaintService.countComplaint(complaint, username));
			model.setData(list);
		}
		return model;
	}

	@RequestMapping("/handle")
	@ResponseBody
	public AdminModel handle(String complaintId, String complaintStatus) {
		AdminModel model = new AdminModel();
		complaintService.handleComplaint(complaintId, complaintStatus);
		model.setMsg("操作成功");
		return model;
	}

}
