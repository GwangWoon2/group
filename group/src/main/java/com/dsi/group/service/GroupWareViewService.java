package com.dsi.group.service;

import java.util.List;

import com.dsi.group.model.Dept;
import com.dsi.group.model.Hobby;

public interface GroupWareViewService {

	List<Hobby> hobbyCode();
	List<Dept> deptCode();

}
