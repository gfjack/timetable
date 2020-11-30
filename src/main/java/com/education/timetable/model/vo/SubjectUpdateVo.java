package com.education.timetable.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("更新学科vo")
public class SubjectUpdateVo {

	@ApiModelProperty("学科简介")
	private String subjectIntroduction;

	@ApiModelProperty("学科阶段")
	private Integer sprint;

}
