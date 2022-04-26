package com.dsi.group.controller;

import java.util.List;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;

import com.dsi.group.model.Dept;
import com.dsi.group.model.Hobby;

import com.dsi.group.service.GroupWareViewService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ViewController {
	
	final GroupWareViewService gwViewService;
	
	@RequestMapping("/")
	public ModelAndView home(ModelAndView mav) {
		
		List<Hobby> hobbys = gwViewService.hobbyCode();
		List<Dept> depts = gwViewService.deptCode();
		mav.addObject("depts", depts);
		mav.addObject("hobbys", hobbys);
		mav.addObject("empNm", new String());
		mav.setViewName("/content/home");
		return mav;
	}
	
	@RequestMapping("/orgChart")
	public String orgChart() {
		
		
		return "/content/orgChart";
	}
	
}
