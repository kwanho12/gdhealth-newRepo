package com.tree.gdhealth.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class EmployeeImg {
	private Integer employeeImgNo;
	private Integer employeeNo;
	private String employeeImgOriginName;
	private String employeeImgFilename;
	private long employeeImgSize;
	private String employeeImgType;
	private String createdate;
	private String updatedate;	
}
