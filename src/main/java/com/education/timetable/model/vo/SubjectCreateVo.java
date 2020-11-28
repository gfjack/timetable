package com.education.timetable.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SubjectCreateVo {

	@ApiModelProperty("学科名称")
	private String subjectName;

	@ApiModelProperty("学科简介")
	private String subjectIntroduction;

	@ApiModelProperty("学科阶段")
	private Integer sprint;

}
