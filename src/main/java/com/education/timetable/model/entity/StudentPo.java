package com.education.timetable.model.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@ApiModel("学生")
@Entity
@Table(name = "t_student")
@Data
public class StudentPo {

  @ApiModelProperty("学生id")
  @Id
  private Long studentId;

  @ApiModelProperty("学生信息")
  private String studentInfo;

  @ApiModelProperty("学生姓名")
  private String studentName;

  @ApiModelProperty("家长姓名")
  private String parentName;

  @ApiModelProperty("家长联系方式")
  private String parentContactInfo;

  @ApiModelProperty("拥有的学科")
  @Type(type = "json")
  private List<Long> subjects;

}
