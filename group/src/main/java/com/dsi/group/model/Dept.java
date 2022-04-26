package com.dsi.group.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Dept {

	private String deptId;
	private String upDeptId;
	private String deptNm;
	
	
}
