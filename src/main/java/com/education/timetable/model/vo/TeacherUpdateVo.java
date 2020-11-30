package com.education.timetable.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NonNull;

import java.util.List;
import java.util.UUID;

@Data
@ApiModel("更新老师vo")
public class TeacherUpdateVo {

	@ApiModelProperty("联系方式")
	private String contact;

	@ApiModelProperty("老师简介")
	private String teacherInfo;

	@ApiModelProperty("任教学科")
	@NonNull
	private Long subjectIds;

	@ApiModelProperty("任教课程")
	private List<UUID> courseIds;

}
