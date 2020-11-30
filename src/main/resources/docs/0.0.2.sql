CREATE TABLE `t_course` (
  `course_id` varchar(255) NOT NULL DEFAULT '' COMMENT '课程id',
  `course_name` varchar(60) NOT NULL DEFAULT '' COMMENT '课程名称',
  `course_introduction` VARCHAR(255) DEFAULT '' COMMENT '课程简介',
  `subject_id` varchar(255) NOT NULL DEFAULT '' COMMENT '学科id',
  `subject_name` varchar(60) NOT NULL DEFAULT '' COMMENT '学科名称',
  `teacher_id` BIGINT NOT NULL DEFAULT 0 COMMENT '老师id',
  `registered_students` text COMMENT '报名的学生',
  `start_time` datetime DEFAULT NULL COMMENT '开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '结束时间',
  `day` tinyint(7) NOT NULL COMMENT '周几',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` bigint(20) DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_by` bigint(20) DEFAULT NULL COMMENT '更新人'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `t_teacher`(
`teacher_id` BIGINT NOT NULL DEFAULT 0 COMMENT '老师id',
`teacher_name`VARCHAR(60) NOT NULL DEFAULT '' COMMENT'老师名字',
`contact` VARCHAR(60) NOT NULL 	DEFAULT '' COMMENT'联系方式',
`teacher_info` VARCHAR(255) DEFAULT '' COMMENT '教师简介',
`subject_ids` VARCHAR(255) NOT NULL DEFAULT '' COMMENT '任教学科id',
`course_ids` text COMMENT '任教课程id',
`create_time` datetime DEFAULT NULL COMMENT '创建时间',
`create_by` bigint(20) DEFAULT NULL COMMENT '创建人',
`update_time` datetime DEFAULT NULL COMMENT '更新时间',
`update_by` bigint(20) DEFAULT NULL COMMENT '更新人'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
