# JVS后端服务器 API 手册

---

# API 概述

**接口**: /video/insert

**方法**: POST

**参数**:

**返回**:

**返回数据**:

---

# API 数据字典

---

# API 接口字典

---

# 视频(Video)

## 查询所有视频

**接口**: /video/getAll

**方法**: GET

**参数**: 无

**返回**:
```json
{
    "code": 0,
    "message": "成功",
    "data": [
        {
            "vid": 1,
            "name": "名称",
            "info": "-",
            "type": 1
        },
        {
            "vid": 2,
            "name": "视频名称",
            "info": "-",
            "gid": 1,
            "type": 1
        }
    ]
}
```

**返回数据**

|列|说明|备注|
|---|---|---|
|vid|视频ID|-|
|name|视频名称|-|
|info|视频简介|-|
|type|视频类型|1:视频,2:番剧,3:电影|
|gid|视频所属分组|如果不属于任何分组则不返回|

## 查询指定视频

**接口**: /video/get/{id}

**方法**: GET

**参数**: id: 视频的编号

**返回**:

```json
{
    "code": 0,
    "message": "成功",
    "data": {
        "name": "测试名称修改2",
        "info": "-",
        "type": 1,
        "epList": [
            {
                "eid": 1,
                "name": "视频1P1",
                "link": "/t1.mp4"
            },
            {
                "eid": 7,
                "name": "测试名称",
                "link": "/cc01ad49-37b0-49b1-a557-5bbfef44a54c-unprocessed.mp4"
            }
        ]
    }
}
```

**返回数据**:

|列|说明|备注|
|---|---|---|
|name|视频ID|-|
|info|视频简介|-|
|type|视频的类型|1:视频,2:番剧,3:电影|
|**epList**|该视频的分P|Array类型|
|eid|分P ID|-|
|name|分P名称|-|
|link|分P的播放地址|续拼接流媒体服务器的地址访问|

## 添加视频

**接口**: /video/insert

**方法**: POST

**参数**: 

|参数|数据类型|必须|说明|备注|
|---|---|---|---|---|
|name|String|*|视频名称|-|
|info|String| |视频简介|-|
|uploaderId|Integer|*|上传者uid|-|
|gid|Integer| |所属分组gid|-|
|type|Integer| |视频类别|1、视频，2、番剧，3、电影，默认值:1|

**返回**:

```json
{
    "code": 0,
    "message": "成功",
    "data": {
        "vid": 10,
        "name": "测试",
        "uploaderId": 1,
        "type": 1
    }
}
```

**返回数据**:

|列|说明|备注|
|---|---|---|
|vid|视频vid|-|
|name|视频名称|-|
|uploaderId|上传者id|-|
|type|视频类型|见上方|

## 修改视频

**接口**: /video/update/{id}

**方法**: PUT

**参数**: {id} 待修改的视频vid

|参数|数据类型|必须|说明|备注|
|---|---|---|---|---|
|name|String| |名称|-|
|info|String| |简介|-|
|gid|Integer| |所属分组|-|
|type|Integer| |视频类型|上述的参数至少修改一个|

**返回**:

```json
{
    "code": 0,
    "message": "成功",
    "data": 1
}
```

**返回数据**: 空

## 删除视频

**接口**: /video/delete/{id}

**方法**: DELETE

**参数**: {id} 删除的视频id

**返回**:

```json
{
    "code": 0,
    "message": "成功",
    "data": 0
}
```

**返回数据**: 无

---

# 分P操作(Ep)

## 上传视频

## 修改视频的信息

## 视频换源

## 删除视频(未做)