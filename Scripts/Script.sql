DROP TABLE IF EXISTS `blobTest`.`picbox` RESTRICT


DROP SCHEMA IF EXISTS `blobTest`



CREATE SCHEMA `blobTest`



CREATE TABLE `blobTest`.`picbox` (
	`no`   INTEGER     NOT NULL COMMENT 'no',
	`name` VARCHAR(10) NOT NULL COMMENT 'name'
)
COMMENT '임시테이블'




ALTER TABLE `blobTest`.`picbox`
	ADD CONSTRAINT `PK_picbox`
		PRIMARY KEY (
			`no`
		)




ALTER TABLE `blobTest`.`picbox`
	MODIFY COLUMN `no` INTEGER NOT NULL AUTO_INCREMENT COMMENT 'no'

	
desc picbox;

insert into picbox values(1,'주형');
insert into picbox values(2,'문한');
insert into picbox values(3,'경아');
insert into picbox values(4,'상훈');

select * from picbox;

delete from picbox;
