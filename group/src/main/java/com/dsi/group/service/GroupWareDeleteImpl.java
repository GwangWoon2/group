package com.dsi.group.service;

import org.springframework.stereotype.Service;

import com.dsi.group.mapper.GroupWareMapper;
import com.dsi.group.model.Emp;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class GroupWareDeleteImpl implements GroupWareServiceDelete {
	
	final GroupWareMapper gwMapper;
	
	@Override
	public void empDelete(Emp e) {
		
		String empId=e.getEmpId();
		
		gwMapper.upDeleteHobby(empId);
		gwMapper.upDeleteEmp(empId);
	}
	
	
}
