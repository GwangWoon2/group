package com.dsi.group.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dsi.group.mapper.GroupWareMapper;
import com.dsi.group.model.Dept;
import com.dsi.group.model.Hobby;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GroupWareViewServiceImpl implements GroupWareViewService {

	final GroupWareMapper gwMapper;
	
	@Override
	public List<Hobby> hobbyCode() {

		return gwMapper.hobbyCode();
	};

	@Override
	public List<Dept> deptCode() {

		return gwMapper.deptCode();
	};

}
