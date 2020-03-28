package pms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import pms.entity.DeptHouse;
import pms.entity.Model;
import pms.mapper.DeptHouseMapper;
import pms.service.DeptHouseService;

@Service
public class DeptHouseServiceImpl implements DeptHouseService {

	@Autowired
	private DeptHouseMapper deptHouseMapper;

	@Override
	public Model findDeptHouse(Integer deptId, String houseNum, String ownerName, String ownerPhone, Integer page,
			Integer limit) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, limit);
		List<DeptHouse> list = deptHouseMapper.findDeptHouse(deptId, houseNum, ownerName, ownerPhone);
		Model model = new Model();
		if (list.size() == 0) {
			model.setCode(1);
			model.setMsg("没有数据哦");
		} else {
			model.setCode(0);
			model.setCount(deptHouseMapper.countDeptHouse(deptId, houseNum, ownerName, ownerPhone));
			model.setData(list);
		}
		return model;
	}

	@Override
	public Model findUserDeptHouse(Integer deptId, String houseNum, Integer page, Integer limit) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, limit);
		List<DeptHouse> list = deptHouseMapper.findUserDeptHouse(deptId, houseNum);
		Model model = new Model();
		if (list.size() == 0) {
			model.setCode(1);
			model.setMsg("没有数据哦");
		} else {
			model.setCode(0);
			model.setCount(deptHouseMapper.countUserDeptHouse(deptId, houseNum));
			model.setData(list);
		}
		return model;
	}

}
