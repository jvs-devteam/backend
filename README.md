# JVS后端服务器

## 配置:

**此处以macOS举例**

### 一、环境配置

JVS后端配置所需环境

**编译环境**

- JDK1.8
- Maven

**运行环境**

- Nginx
- redis
- MySQL
- JRE 1.8

### 二、配置文件

- /src/resources/application.yml

```yaml
spring:
  datasource:
    type: com.alibaba.druid.pool.DruidDataSource
    url: jdbc:mysql:///jvs # 数据库地址，单机部署默认即可
    username: root # mySQL用户名
    password: justice@2001 # MySQL密码
    driver-class-name: com.mysql.cj.jdbc.Driver
  jackson:
    default-property-inclusion: non_null
  servlet:
    multipart:
      max-file-size: 1024MB
      max-request-size: 1024MB
server:
  port: 23333 # 后端服务器端口号

mybatis:
  config-location: classpath:config/mybatis-config.xml
  mapper-locations: classpath:mapper/*.xml
  type-aliases-package: top.mczhengyi.jvs.bean

logging:
  level:
    top.mczhengyi.jvs.mapper: debug # 日志模式

swagger:
  base-package: top.mczhengyi.jvs.controller
  enable: true
```

- /src/resources/config/config.properties

```properties
# 文件服务的地址
videoServer.url=http://localhost/files
# 文件存储位置
videoServer.path=/Users/justiceliu/server-file/jvs

# ffmpeg二进制文件位置（废弃）
ffmpeg.rootPath=null

# Redis相关配置
redis.host=127.0.0.1:6379
redis.port=6379
redis.expire=604800
redis.timeout=5000
```

### 三、配置文件服务器

文件服务器指向文件存储位置，务必相同

### 四、导入数据库

使用SQL管理软件执行dbCreator.sql

此操作将会创建JVS数据库，并且会覆盖原有的JVS数据库

### 五、启动服务

运行编译打包配置好的JvsApplication

## 问题

[-] 配置文件脱离源码  