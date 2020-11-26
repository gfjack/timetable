package com.education.timetable.model.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel("教师")
@Entity
@Table(name = "t_teacher")
@Data
public class TeacherPo {

  @ApiModelProperty("教师id")
  @Id
  private Long teacherId;

  @ApiModelProperty("教师姓名")
  private String teacherName;

  @ApiModelProperty("联系方式")
  private String contact;

}
