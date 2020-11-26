package com.education.timetable.model.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@ApiModel("学科信息")
@Entity
@Table(name = "t_subject")
@Data
public class SubjectPo {

  @ApiModelProperty("学科id")
  @Id
  @Type(type = "uuid-char")
  private UUID subjectId;

  @ApiModelProperty("学科名称")
  private String subjectName;

  @ApiModelProperty("学科总人数")
  private Integer totalStudents;

}
