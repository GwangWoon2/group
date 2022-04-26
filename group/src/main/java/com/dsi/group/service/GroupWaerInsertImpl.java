package com.dsi.group.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dsi.group.mapper.GroupWareMapper;
import com.dsi.group.model.Emp;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GroupWaerInsertImpl implements GroupWaerInsertService {

	final GroupWareMapper gwMapper;
	
	
	
	@Transactional
	@Override
	public void insertEmp(Emp e) {
		
		Emp en = new Emp().builder().empNm(e.getEmpNm()).deptId(e.getDeptId()).jbgdNm(e.getJbgdNm())
				.mblTelNo(e.getMblTelNo()).roadNmAdd(e.getRoadNmAdd()).build();
					
		gwMapper.insertEmp(en);
		
		List<Emp> empList = gwMapper.curentEmpId();
		
		String empId = empList.get(0).getEmpId();
		String hobby = e.getHobbyCode();
		String[] arrhob = hobby.split(",");
		
		for (int i = 0; i < arrhob.length; i++) {
			if (!(arrhob[i].equals("undefined"))) {
				gwMapper.insertHobby(arrhob[i],empId);
			}
		}
	
	}
	
	@Override
	public void updateEmp(Emp e,String hobbyscheck) {
		
		
		Emp newEmp = new Emp().builder().empId(e.getEmpId()).empNm(e.getEmpNm()).deptId(e.getDeptId())
				.mblTelNo(e.getMblTelNo()).roadNmAdd(e.getRoadNmAdd()).jbgdNm(e.getJbgdNm()).build();
		String empId=newEmp.getEmpId();
		
	
		gwMapper.upDeleteHobby(empId);

		gwMapper.upDeleteEmp(empId);

		gwMapper.updateEmp(newEmp);
		
		String hobby = hobbyscheck;
		String[] arrhob = hobby.split(",");

		for (int i = 0; i < arrhob.length; i++) {
			gwMapper.updateHobby(arrhob[i],empId);
		}
		
		
	}
}
