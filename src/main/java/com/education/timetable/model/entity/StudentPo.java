package com.education.timetable.model.entity;

import com.vladmihalcea.hibernate.type.json.JsonStringType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@ApiModel("学生")
@Entity
@Table(name = "t_student")
@TypeDef(name = "json", typeClass = JsonStringType.class)
@Data
public class StudentPo extends BasePo implements Serializable {

  @ApiModelProperty("学生id")
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long studentId;

  @ApiModelProperty("学生信息")
  private String studentInfo;

  @ApiModelProperty("学生联系方式")
  private String studentContactInfo;

  @ApiModelProperty("学生姓名")
  private String studentName;

  @ApiModelProperty("家长姓名")
  private String parentName;

  @ApiModelProperty("家长联系方式")
  private String parentContactInfo;

  @ApiModelProperty("年级")
  private String gradeLevel;

  @ApiModelProperty("学校名称")
  private String schoolName;
}
