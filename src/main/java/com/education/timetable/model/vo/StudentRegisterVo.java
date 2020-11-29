package com.education.timetable.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@ApiModel("学生报名课程vo")
@Data
public class StudentRegisterVo {

	@ApiModelProperty("学生id")
	private Long studentId;

	@ApiModelProperty("课程id")
	private UUID courseId;

	@ApiModelProperty("课程名称")
	private String courseName;

	@ApiModelProperty("课程开始时间")
	private Date startTime;

	@ApiModelProperty("课程结束时间")
	private Date endTime;

	@ApiModelProperty("是否报名成功")
	private boolean isSuccess;

}
