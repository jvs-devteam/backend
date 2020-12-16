-- 警告：请不要在生产服务器上运行此脚本，运行此脚本将会导致大量数据丢失!
-- WARING: DO NOT RUN THIS SCRIPT IN PRODUCTION SERVER, RUN THIS SCRIPT WILL DROP ALL TABLE!

INSERT INTO t_user (username, password)
VALUES ('番剧中心', '123456');

INSERT INTO t_group (name, creator)
VALUES ('测试分组', 1);

INSERT INTO t_video (name, info, uploader, gid, type)
VALUES ('测试视频数据1', '-', 1, NULL, 1),
       ('测试视频数据2', '-', 1, 1, 1),
       ('测试视频数据3', '-', 1, 1, 1),
       ('测试视频数据4', '-', 1, NULL, 1);

INSERT INTO t_ep (name, link, vid)
VALUES ('视频1P1', '/t1.mp4', 1),
       ('视频2P1', '/t1.mp4', 2),
       ('视频2P2', '/t2.mp4', 2),
       ('视频3P1', '/t1.mp4', 3),
       ('视频4P1', '/t1.mp4', 4),
       ('视频4P2', '/t2.mp4', 4);