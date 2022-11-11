use t_contest;

create table t_contest (
	id int(11) auto_increment COMMENT '竞赛id',
	college_name varchar(255) default null comment '学院名称',
	level_name varchar(255) default null comment '级别名称',
	detail_information varchar(255) default null comment '详细信息',
	comment_link varchar(255) default null comment '评论链接',
	·subject varchar(255) default null comment '学科',
	contest_name VARCHAR(255) default null comment '竞赛名称',
	abbreviation varchar(255) default null comment '简称',
	s_student varchar(255) default NULL COMMENT '适合学生',
	deadline_time DATETIME COMMENT '报名截止时间',
	contest_time DATETIME COMMENT '比赛时间',
	contest_place varchar(255) default null comment '比赛地点',
	r_period DATETIME COMMENT '预估出成绩周期',
	sponsor varchar(255) default null comment '主办方',
	d_level varchar(255) default null comment '难度等级,比如A、B',
	state INT  COMMENT '是否删除：0-未删除，1-已删除,2-审核状态',
	created_user varchar(255) default null COMMENT '管理者',
	created_time  timestamp NULL NOT NULL DEFAULT current_timestamp COMMENT '管理时间',
	modified_user VARCHAR(20) COMMENT '修改者',
	modified_time  timestamp NULL NOT NULL DEFAULT current_timestamp COMMENT '修改时间',
	other_information varchar(255) default null comment '其他信息',
	PRIMARY KEY (id)
)ENGINE=INNODB DEFAULT CHARSET=utf8mb4;

ALTER TABLE t_contest ALTER state SET DEFAULT 0;
ALTER TABLE t_contest ADD unique(`contest_name`);

