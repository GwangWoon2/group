package com.dsi.group.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dsi.group.mapper.GroupWareMapper;
import com.dsi.group.model.Emp;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GroupWaerSelectImpl implements GroupWaerSelectService {

	final GroupWareMapper gwMapper;

	@Override
	public List<Emp> orgDeptList() {

		return gwMapper.orgDeptList();
	}

	@Transactional
	@Override
	public List<Emp> selectEmp2(String empNm) {

		return gwMapper.selectEmp2(empNm);
	}

	@Override
	public List<String> empIdList() {

		return gwMapper.empIdList();
	}

	@Override
	public List<String> hobbyList(String empId) {

		return gwMapper.hobbyList(empId);
	}

}
