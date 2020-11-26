package com.education.timetable.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.annotations.Type;

import java.util.Date;
import java.util.List;

@Data
public class CourseCreateVo {

	@ApiModelProperty("课程名称")
	private String courseName;

	@ApiModelProperty("学科名称")
	private String subjectName;

	@ApiModelProperty("课程人数")
	private Integer courseNumOfStudents;

	@ApiModelProperty("参与学生")
	@Type(type = "json")
	private List<Long> registeredStudents;

	@ApiModelProperty("开始时间")
	private Date startTime;

	@ApiModelProperty("结束时间")
	private Date endTime;

}
