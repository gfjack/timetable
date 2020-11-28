package com.education.timetable.model.vo;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NonNull;

import java.util.Date;

@Data
public class CourseSearchVo {

	@ApiModelProperty("学生id")
	private Long studentId;

	@NonNull
	@ApiModelProperty("开始时间")
	private Date startTime;

	@NonNull
	@ApiModelProperty("结束时间")
	private Date endTime;

}
