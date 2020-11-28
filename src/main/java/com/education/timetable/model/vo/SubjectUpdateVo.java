package com.education.timetable.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SubjectUpdateVo {

	@ApiModelProperty("学科简介")
	private String subjectIntroduction;

	@ApiModelProperty("学科阶段")
	private Integer sprint;

}
