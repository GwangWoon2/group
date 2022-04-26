package com.dsi.group.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dsi.group.model.Dept;
import com.dsi.group.model.Emp;
import com.dsi.group.model.Hobby;
import com.dsi.group.model.HobbyList;


public interface GroupWareMapper {
	
	List<String> empIdList();
	List<Emp> selectEmp2(String n);
	List<Emp> orgDeptList();
	void insertEmp(Emp ew);
	List<Emp> curentEmpId();
	void insertHobby(@Param("hoblist")String hoblist , @Param("empId")String empId);
	List<Hobby> hobbyCode();
	List<Dept> deptCode();
	List<String> hobbyList(String empId);
	void upDeleteHobby(String empId);
	void upDeleteEmp(String empId);
	void updateEmp(Emp newEmp);
	void updateHobby(@Param("arrHob")String arrHob, @Param("empId")String empId);
	
}