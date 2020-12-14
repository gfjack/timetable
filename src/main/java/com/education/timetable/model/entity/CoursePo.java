package com.education.timetable.model.entity;

import com.education.timetable.constants.enums.Week;
import com.vladmihalcea.hibernate.type.json.JsonStringType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@ApiModel("课程")
@Entity
@Table(name = "t_course")
@TypeDef(name = "json", typeClass = JsonStringType.class)
@Data
public class CoursePo extends BasePo implements Serializable {

  @ApiModelProperty("课程id")
  @Id
  @Type(type = "uuid-char")
  private UUID courseId;

  @ApiModelProperty("课程名称")
  private String courseName;

  @ApiModelProperty("课程简介")
  private String courseIntroduction;

  @ApiModelProperty("学科id")
  @Type(type = "uuid-char")
  private UUID subjectId;

  @ApiModelProperty("学科名称")
  private String subjectName;

  @ApiModelProperty("老师id")
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
