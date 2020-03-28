package pms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pms.mapper.HouseMapper;
import pms.service.HouseService;

@Service
public class HouseServiceImpl implements HouseService {
	@Autowired
	private HouseMapper mapper;

	@Override
	public void updateHouse(Integer houseId, Integer ownerId) {
		// TODO Auto-generated method stub
		mapper.updateHouse(houseId, ownerId);
	}

}
