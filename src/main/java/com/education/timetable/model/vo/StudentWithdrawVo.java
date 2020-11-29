package com.education.timetable.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.UUID;


@ApiModel("学生撤销报名课程vo")
@Data
public class StudentWithdrawVo {

	@ApiModelProperty("学生id")
	private Long studentId;

	@ApiModelProperty("课程id")
	private UUID courseId;

	@ApiModelProperty("课程名称")
	private String courseName;

	@ApiModelProperty("是否撤销成功")
	private boolean isSuccess;

}
