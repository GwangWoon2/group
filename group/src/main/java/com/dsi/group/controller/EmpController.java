package com.dsi.group.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dsi.group.model.Dept;
import com.dsi.group.model.Emp;
import com.dsi.group.model.Hobby;
import com.dsi.group.service.GroupWaerInsertService;
import com.dsi.group.service.GroupWaerSelectService;
import com.dsi.group.service.GroupWareServiceDelete;
import com.dsi.group.service.GroupWareViewService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class EmpController {

	final GroupWaerSelectService gwSeService;
	final GroupWaerInsertService gwInService;
	final GroupWareViewService gwViewService;
	final GroupWareServiceDelete gwDeService;
	
	
	@GetMapping(value = "/hobbylist")
	public List<String> hobbyList(String empId) {

		List<String> hobbylists = gwSeService.hobbyList(empId);

		return hobbylists;
	}
	
	@GetMapping("/orgChartList")
	public List<Emp> orgChart() {
		
		List<Emp> orgDeptList = gwSeService.orgDeptList();
		
		return orgDeptList;
	}
	
	
	@GetMapping("/selectNm")
	public ModelAndView selectemp(@ModelAttribute("empNm") String empNm) {

		List<Emp> emps = gwSeService.selectEmp2(empNm);

		ModelAndView mav = new ModelAndView();
		List<Hobby> hobbys = gwViewService.hobbyCode();
		List<Dept> depts = gwViewService.deptCode();

		mav.addObject("depts", depts);
		mav.addObject("hobbys", hobbys);
		mav.setViewName("content/home");
		mav.addObject("emps", emps);
		return mav;

	}
	
	
	@PostMapping("/insertEmp")
	public ModelAndView insertEmp(String empNm, String jbgdNm, String deptId, String mblTelNo, String roadNmAdd,
			String hobbyCode) {
			
		ModelAndView mav = new ModelAndView();
		Emp e = new Emp().builder().empNm(empNm).jbgdNm(jbgdNm).deptId(deptId).mblTelNo(mblTelNo).roadNmAdd(roadNmAdd)
				.hobbyCode(hobbyCode).build();
		
		List<Hobby> hobbys = gwViewService.hobbyCode();
		List<Dept> depts = gwViewService.deptCode();

		mav.addObject("depts", depts);
		mav.addObject("hobbys", hobbys);
		mav.setViewName("content/home");
		gwInService.insertEmp(e);

		return mav;
	}
	

	@PostMapping("/updateEmp")
	public ModelAndView updateEmp(Emp e, String hobbycheck) {
		ModelAndView mav = new ModelAndView();
		gwInService.updateEmp(e, hobbycheck);
		mav.setViewName("content/home");
		return mav;

	}
	

	@PostMapping("/deleteEmp")
	public ModelAndView delteEmp(Emp e) {
		ModelAndView mav = new ModelAndView();
		gwDeService.empDelete(e);
		mav.setViewName("content/home");
		
		return mav;

	}
	

}
