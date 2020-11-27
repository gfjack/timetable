CREATE TABLE `t_course` (
  `course_id` varchar(255) NOT NULL DEFAULT '' COMMENT '课程id',
  `course_name` varchar(60) NOT NULL DEFAULT '' COMMENT '课程名称',
  `subject_id` varchar(255) NOT NULL DEFAULT '' COMMENT '学科id',
  `subject_name` varchar(60) NOT NULL DEFAULT '' COMMENT '学科名称',
  `course_num_of_students` int(100) DEFAULT NULL COMMENT '学生数量',
  `registered_students` text COMMENT '报名的学生',
  `start_time` datetime DEFAULT NULL COMMENT '开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '结束时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` bigint(20) DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_by` bigint(20) DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;