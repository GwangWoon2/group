package com.dsi.group.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Emp {
	
	private String empId;
	private String empNm;
	private String deptId;
	private String deptNm;
	private String jbgdNm;
	private String mblTelNo;
	private String roadNmAdd;
	private String hobbyCode;
	private String hobbyNm;
	private String upDeptId;
	
}