package pms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;

import pms.entity.Dept;
import pms.entity.Model;
import pms.mapper.DeptMapper;
import pms.mapper.HouseMapper;
import pms.service.DeptService;

@Service
public class DeptServiceImpl implements DeptService {
	@Autowired
	private DeptMapper deptMapper;

	@Autowired
	private HouseMapper houseMapper;

	@Override
	@Transactional
	public void insertDept(Dept dept) {
		// TODO Auto-generated method stub
		deptMapper.insertDept(dept);
		int deptId = dept.getDeptId();
		int floor = dept.getDeptFloor();
		int num = dept.getDeptNum();
		for (int i = 1; i <= floor; i++)
			for (int j = 1; j <= num; j++) {
				houseMapper.insertHouse("" + i + "-" + j, deptId);
			}
	}

	@Override
	public Model findDept(Integer deptId, Integer page, Integer limit) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, limit);
		List<Dept> deptList = deptMapper.findDept(deptId);
		Model model = new Model();
		if (deptList.size() == 0) {
			model.setCode(1);
			model.setMsg("没有数据哦");
		} else {
			model.setCode(0);
			model.setCount(deptMapper.countDept(deptId));
			model.setData(deptList);
		}
		return model;
	}

	@Override
	public Integer findFloor(Integer deptId) {
		// TODO Auto-generated method stub
		return deptMapper.findFloor(deptId);
	}

}
