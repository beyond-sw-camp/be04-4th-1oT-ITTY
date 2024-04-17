CREATE USER 'swcamp'@'%' IDENTIFIED BY  'swcamp'; 

DROP DATABASE IF EXISTS itty;

CREATE DATABASE IF NOT EXISTS itty default CHARACTER SET UTF8;

-- root 로 접속해서 swcamp 계정의 권한 확인하기
SHOW GRANTS FOR 'swcamp'@'%';

GRANT ALL PRIVILEGES ON itty.* TO 'swcamp'@'%';   -- itty에 대한 모든 권한 부여

DROP DATABASE IF EXISTS itty;

DROP DATABASE IF EXISTS itty;

CREATE DATABASE IF NOT EXISTS itty default CHARACTER SET UTF8;

USE itty;

DROP TABLE IF EXISTS `article_tb` CASCADE;
DROP TABLE IF EXISTS `article_like_tb` CASCADE;
DROP TABLE IF EXISTS `follow_tb` CASCADE;
DROP TABLE IF EXISTS `reply_like_tb` CASCADE;
DROP TABLE IF EXISTS `reply_tb` CASCADE;
DROP TABLE IF EXISTS `scrap_tb` CASCADE;
DROP TABLE IF EXISTS `user_tb` CASCADE;

CREATE TABLE `article_tb`
(
    `article_code_pk`    INTEGER NOT NULL AUTO_INCREMENT COMMENT '게시글코드',
    `article_title`    VARCHAR(255) NOT NULL COMMENT '게시글제목',
    `article_content`    VARCHAR(255) NOT NULL COMMENT '게시글내용',
    `article_created_date`    DATETIME NOT NULL COMMENT '게시글작성일',
    `article_last_updated_date`    DATETIME NOT NULL COMMENT '게시글최종수정일',
    `user_code_fk`    INTEGER NOT NULL COMMENT '회원코드',
    `article_category`    INTEGER NOT NULL COMMENT '게시글카테고리',
    `article_view_count`    INTEGER NOT NULL COMMENT '게시글조회수',
 PRIMARY KEY ( `article_code_pk` )
)
 COMMENT = '게시글';


CREATE TABLE `article_like_tb`
(
    `article_like_code_pk`    INT NOT NULL AUTO_INCREMENT COMMENT '게시글좋아요코드',
    `article_code_fk`    INT NOT NULL COMMENT '게시글코드',
    `user_code_fk`    INT NOT NULL COMMENT '회원코드',
 PRIMARY KEY ( `article_like_code_pk` )
)
 COMMENT = '게시글좋아요';
 

CREATE TABLE `follow_tb`
(
    `follow_code_pk`    INTEGER NOT NULL AUTO_INCREMENT COMMENT '팔로우코드',
    `follower_code_fk`    INTEGER NOT NULL COMMENT '팔로워',
    `followee_code_fk`    INTEGER NOT NULL COMMENT '팔로위',
 PRIMARY KEY ( `follow_code_pk` )
)
 COMMENT = '팔로우';


CREATE TABLE `reply_like_tb`
(
    `reply_like_code_pk`    INT NOT NULL AUTO_INCREMENT COMMENT '댓글좋아요코드',
    `user_code_fk`    INT NOT NULL COMMENT '회원코드',
    `reply_code_fk`    INT NOT NULL COMMENT '댓글코드',
 PRIMARY KEY ( `reply_like_code_pk` )
)
 COMMENT = '댓글좋아요';


CREATE TABLE `reply_tb`
(
    `reply_code_pk`    INTEGER NOT NULL AUTO_INCREMENT COMMENT '댓글코드',
    `reply_content`    VARCHAR(255) NOT NULL COMMENT '댓글내용',
    `user_code_fk`    INTEGER NOT NULL COMMENT '회원코드',
    `article_code_fk`    INTEGER NOT NULL COMMENT '게시글코드',
    `reply_created_date`    DATETIME NOT NULL COMMENT '댓글작성일',
    `reply_last_updated_date`    DATETIME NOT NULL COMMENT '댓글최종수정일',
 PRIMARY KEY ( `reply_code_pk` )
)
 COMMENT = '댓글';


CREATE TABLE `scrap_tb`
(
    `scrap_code_pk`    INTEGER NOT NULL AUTO_INCREMENT COMMENT '스크랩코드',
    `user_code_fk`    INTEGER NOT NULL COMMENT '회원코드',
    `trend_article_code_fk`    INTEGER NOT NULL COMMENT '게시글코드',
 PRIMARY KEY ( `scrap_code_pk` )
)
 COMMENT = '스크랩';


CREATE TABLE `trend_article_tb`
(
    `trend_article_code_pk`    INT NOT NULL AUTO_INCREMENT COMMENT '트렌드게시글코드',
    `trend_article_url`    VARCHAR(255) NOT NULL COMMENT '트렌드게시글링크',
    `trend_article_title`    VARCHAR(255) NOT NULL COMMENT '트렌드게시글제목',
    `trend_article_image_url`    VARCHAR(255) COMMENT '트렌드게시글이미지링크',
    `trend_article_content`    VARCHAR(255) COMMENT '트렌드게시글내용',
    `trend_article_created_date`    DATETIME NOT NULL COMMENT '트렌드게시글생성일자',
    `trend_article_category`    VARCHAR(255) COMMENT '트렌드게시글카테고리',
 PRIMARY KEY ( `trend_article_code_pk` )
)
 COMMENT = '트렌드게시글';


CREATE TABLE `user_tb`
(
    `user_code_pk`    INTEGER NOT NULL AUTO_INCREMENT COMMENT '회원코드',
    `user_email`    VARCHAR(255) NOT NULL COMMENT '회원이메일',
    `user_phone_number`    VARCHAR(255) NOT NULL COMMENT '회원전화번호',
    `user_role`    VARCHAR(255) NOT NULL COMMENT '회원역할',
    `user_nickname`    VARCHAR(255) NOT NULL COMMENT '회원닉네임',
    `user_password`    VARCHAR(255) NOT NULL COMMENT '회원비밀번호',
    `user_introduction`    VARCHAR(255) NOT NULL COMMENT '회원소개글',
    `user_name`    VARCHAR(255) NOT NULL COMMENT '회원이름',
    `user_delete_status`    INT NOT NULL COMMENT '회원탈퇴여부',
 PRIMARY KEY ( `user_code_pk` )
)
 COMMENT = '회원';


ALTER TABLE `article_tb`
ADD CONSTRAINT `user_code_fk_1` FOREIGN KEY ( `user_code_fk` )
REFERENCES `user_tb` ( `user_code_pk` ) ON DELETE CASCADE;

ALTER TABLE `follow_tb`
ADD CONSTRAINT `user_code_fk_2` FOREIGN KEY ( `follower_code_fk` )
REFERENCES `user_tb` ( `user_code_pk` ) ON DELETE CASCADE;

ALTER TABLE `follow_tb`
ADD CONSTRAINT `user_code_fk_3` FOREIGN KEY ( `followee_code_fk` )
REFERENCES `user_tb` ( `user_code_pk` ) ON DELETE CASCADE;

ALTER TABLE `reply_like_tb`
ADD CONSTRAINT `user_code_fk_4` FOREIGN KEY ( `user_code_fk` )
REFERENCES `user_tb` ( `user_code_pk` ) ON DELETE CASCADE;

ALTER TABLE `reply_like_tb`
ADD CONSTRAINT `reply_code_fk_1` FOREIGN KEY ( `reply_code_fk` )
REFERENCES `reply_tb` ( `reply_code_pk` ) ON DELETE CASCADE;

ALTER TABLE `reply_tb`
ADD CONSTRAINT `user_code_fk_5` FOREIGN KEY ( `user_code_fk` )
REFERENCES `user_tb` ( `user_code_pk` ) ON DELETE CASCADE ;

ALTER TABLE `reply_tb`
ADD CONSTRAINT `article_code_fk_1` FOREIGN KEY ( `article_code_fk` )
REFERENCES `article_tb` ( `article_code_pk` ) ON DELETE CASCADE;

ALTER TABLE `scrap_tb`
ADD CONSTRAINT `user_code_fk_6` FOREIGN KEY ( `user_code_fk` )
REFERENCES `user_tb` ( `user_code_pk` ) ON DELETE CASCADE;

ALTER TABLE `scrap_tb`
ADD CONSTRAINT `trend_article_code_fk_1` FOREIGN KEY ( `trend_article_code_fk` )
REFERENCES `trend_article_tb` ( `trend_article_code_pk` ) ON DELETE CASCADE;

ALTER TABLE `article_like_tb`
ADD CONSTRAINT `user_code_fk_7` FOREIGN KEY ( `user_code_fk` )
REFERENCES `user_tb` ( `user_code_pk` ) ON DELETE CASCADE;

ALTER TABLE `article_like_tb`
ADD CONSTRAINT `article_code_fk_2` FOREIGN KEY ( `article_code_fk` )
REFERENCES `article_tb` ( `article_code_pk` ) ON DELETE CASCADE;
