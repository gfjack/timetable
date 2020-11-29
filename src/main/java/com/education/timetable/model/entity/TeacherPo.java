package com.education.timetable.model.entity;

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
import java.util.List;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@ApiModel("教师")
@Entity
@Table(name = "t_teacher")
@TypeDef(name = "json", typeClass = JsonStringType.class)
@Data
public class TeacherPo extends BasePo {

  @ApiModelProperty("教师id")
  @Id
  private Long teacherId;

  @ApiModelProperty("教师姓名")
  private String teacherName;

  @ApiModelProperty("联系方式")
  private String contact;

  @ApiModelProperty("教师简介")
  private String teacherInfo;

  @ApiModelProperty("任教学科id")
  private Long subjectIds;

  @ApiModelProperty("任教课程")
  @Type(type = "json")
  private List<UUID> courseIds;
}
