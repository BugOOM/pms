package pms.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import pms.entity.Model;
import pms.entity.PayHouse;
import pms.entity.SysUser;
import pms.mapper.PayHouseMapper;
import pms.mapper.UserMapper;
import pms.service.MailService;
import pms.service.PayHouseService;

@Service
public class PayHouseServiceImpl implements PayHouseService {
	@Autowired
	private PayHouseMapper payHouseMapper;
	@Autowired
	private UserMapper userMapper;

	@Autowired
	private MailService mailService;

	@Override
	public Model findAllPay(Integer page, Integer limit, String ownerName, String ownerPhoen, Integer chargeType,
			Integer payStatus, Integer ownerId) {
		// TODO Auto-generated method stub
		Model model = new Model();
		PageHelper.startPage(page, limit);
		List<PayHouse> list = payHouseMapper.findAllPay(ownerName, ownerPhoen, chargeType, payStatus, ownerId);
		if (list.size() == 0) {
			model.setCode(1);
			model.setMsg("没有查找到相关数据哦");
		} else {
			model.setData(list);
			model.setCode(0);
			model.setCount(payHouseMapper.countAllPay(ownerName, ownerPhoen, chargeType, payStatus, ownerId));
		}
		return model;
	}

	@Override
	public Model reminder(PayHouse payHouse) {
		// TODO Auto-generated method stub
		int ownerId = payHouse.getOwnerId();
		SysUser user = userMapper.findUserByOwnerId(ownerId);
		String content = "尊敬的 " + payHouse.getOwnerName() + " 用户您好，您在 " + payHouse.getDeptName() + " 栋，门牌号 "
				+ payHouse.getHouseNum() + " 的房子现 " + payHouse.getChargeName() + " 欠费 " + payHouse.getPayTotal()
				+ " 元，请及时缴费";
		String email = user.getEmail();
		mailService.sendSimpleMail(email, "缴费提醒", content);
		Model model = new Model();
		model.setMsg("提醒成功");
		return model;
	}

	@Override
	public Model pay(Integer payId) {
		// TODO Auto-generated method stub
		payHouseMapper.pay(payId, new Date());
		Model model = new Model();
		model.setMsg("缴费成功");
		return model;
	}

}
