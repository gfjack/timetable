package com.education.timetable.model.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@ApiModel("学科信息")
@Entity
@Table(name = "t_subject")
@Data
public class SubjectPo extends BasePo implements Serializable {

  @ApiModelProperty("学科id")
  @Id
  @Type(type = "uuid-char")
  private UUID subjectId;

  @ApiModelProperty("学科名称")
  private String subjectName;

  @ApiModelProperty("学科简介")
  private String subjectIntroduction;

  @ApiModelProperty("学科阶段")
  private Integer sprint;
}
