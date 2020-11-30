package com.education.timetable.model.vo;

import com.education.timetable.constants.enums.Week;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.annotations.Type;

import java.util.Date;
import java.util.List;

@Data
@ApiModel("课程创建vo")
public class CourseCreateVo {

	@ApiModelProperty("课程名称")
	private String courseName;

	private String courseIntroduction;

	@ApiModelProperty("学科名称")
	private String subjectName;

	@ApiModelProperty("教师id")
	private Long teacherId;

	@ApiModelProperty("参与学生")
	@Type(type = "json")
	private List<Long> registeredStudents;

	@ApiModelProperty("开始时间")
	private Date startTime;

	@ApiModelProperty("结束时间")
	private Date endTime;

	@ApiModelProperty(value = "日期", example = "周日, 周一, 周二")
	private Week day;

}
