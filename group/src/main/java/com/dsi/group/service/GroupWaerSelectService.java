package com.dsi.group.service;

import java.util.List;

import com.dsi.group.model.Emp;

public interface GroupWaerSelectService {
	
	List<Emp> orgDeptList();
	List<Emp> selectEmp2(String empNm);
	List<String> empIdList();
	List<String> hobbyList(String empId);
	
}
