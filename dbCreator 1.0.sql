DROP DATABASE IF EXISTS jvs;

CREATE DATABASE jvs;

USE jvs;

-- 用户表
CREATE TABLE t_user
(
    uid      INT PRIMARY KEY AUTO_INCREMENT COMMENT 'User ID',
    username VARCHAR(100) NOT NULL COMMENT 'User Name',
    password VARCHAR(200) NOT NULL DEFAULT 'password' COMMENT 'Password'
);
-- 分组表
CREATE TABLE t_group
(
    gid     INT PRIMARY KEY AUTO_INCREMENT COMMENT 'Group ID',
    name    VARCHAR(100) NOT NULL COMMENT 'Group Name',
    info    VARCHAR(300) DEFAULT '-' COMMENT 'Group Information',
    creator INT          DEFAULT NULL COMMENT 'Creator User Id',
    FOREIGN KEY (creator) REFERENCES t_user (uid)
);
-- 视频表
CREATE TABLE t_video
(
    vid      INT PRIMARY KEY AUTO_INCREMENT COMMENT 'VideoId',
    name     VARCHAR(128) NOT NULL COMMENT 'Video Name',
    info     VARCHAR(300) DEFAULT '-' COMMENT 'Video Information',
    uploader INT          DEFAULT NULL COMMENT 'Uploader uid',
    gid      INT          DEFAULT NULL COMMENT 'GroupId',
    type     INT          DEFAULT 1 COMMENT 'Video Type: 1. Video 2. Anime 3. Movie',
    FOREIGN KEY (uploader) REFERENCES t_user (uid),
    FOREIGN KEY (gid) REFERENCES t_group (gid),
    CHECK ( type IN (1, 2, 3) )
);
-- 分p表
CREATE TABLE t_ep
(
    eid  INT PRIMARY KEY AUTO_INCREMENT COMMENT 'Ep ID',
    name VARCHAR(200) NOT NULL COMMENT 'Ep Name',
    link VARCHAR(500) NOT NULL DEFAULT '/no-video.mp4' COMMENT 'Ep Play Link',
    vid  INT          NOT NULL COMMENT 'Video ID',
    FOREIGN KEY (vid) REFERENCES t_video (vid)
);
-- 关注番剧表
CREATE TABLE r_fav
(
    uid        INT COMMENT 'User ID',
    vid        INT COMMENT 'Video ID',
    process_ep INT DEFAULT 1 COMMENT 'Played Eps',
    FOREIGN KEY (uid) REFERENCES t_user (uid),
    FOREIGN KEY (vid) REFERENCES t_video (vid),
    PRIMARY KEY (uid, vid)
)