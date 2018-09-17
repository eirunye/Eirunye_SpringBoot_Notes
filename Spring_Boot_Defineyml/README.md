---
title: Spring Boot 配置文件设置(三)
date: 2018-08-20 21:51:39
tags:
- Java
- Spring Boot
categories:
- 后台
- Spring Boot
---

# 简介

上篇我们做了一些简单的运行文件的配置，本篇带领大家来认识常用的一些配置，当然了关于Spring Boot 这些配置太多太多了，如果想了解更多的话直接上官网参考一下，了解相关案例如本篇的配置。 [application.properties配置官方指南参考](https://docs.spring.io/spring-boot/docs/2.0.4.RELEASE/reference/htmlsingle/#common-application-properties)。
<div align="center">
<img src="https://upload-images.jianshu.io/upload_images/3012005-2eecd990df12386f.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/300">
</div>

# Spring Boot有以下方式配置
## application.properties配置

在 [IntelliJ IDEA](https://www.jetbrains.com/idea/) 开发工具中创建项目的时候，默认的配置文件是*application.properties*，接下来我们就学习一下然后配置一些我们在开发中经常用到的配置项，进入带领我们揭开Spring Boot 项目的神秘的面纱。
在下面的文档中我会在每个配置中进行注解，这样能更好的了解，当然官方文档有我们所需的全部配置，大家如果项目开发中有需求那么可以进入[application.properties配置官方指南参考](https://docs.spring.io/spring-boot/docs/2.0.4.RELEASE/reference/htmlsingle/#common-application-properties)。

**英:** Appendix A. Common application properties
 ```
 Various properties can be specified inside your application.properties file, inside your application.yml file, or as command line switches.
 This appendix provides a list of common Spring Boot properties and references to the underlying classes that consume them.
 [Note]
 Property contributions can come from additional jar files on your classpath, so you should not consider this an exhaustive list.
 Also, you can define your own properties.
 [Warning]
 This sample file is meant as a guide only. Do not copy and paste the entire content into your application. Rather, pick only the properties that you need.
  ```
**译:** 官方指南者三段话概况了今天我们要讲得内容：
```
可以在application.properties文件中，application.yml文件中或命令行开关中指定各种属性。 本附录提供了常用Spring Boot属性的列表以及对使用它们的基础类的引用。
[注意]
属性贡献可以来自类路径上的其他jar文件，因此您不应将此视为详尽的列表。 此外，您可以定义自己的属性。
[警告]
此示例文件仅供参考。 不要将整个内容复制并粘贴到您的应用程序中。 相反，只选择您需要的属性。
```
所以我们在添加某些配置属性的时候，一定要根据自己的需要来添加，不然有时出错了，不知道哪里找问题。

### 常用的application.properties配置

一般情况下在src目录下的/main/resource文件夹中新建*`application.properties`*文件，目录结构如下：
```
|--src
   |--main
      |--resources
         |--application.properties
```
我们接下来编写一些常用的属性配置，大家在开发中需要到哪些就直接去查看一下:
```
#启用调试日志。
debug=false
#启用跟踪日志。
trace=false

#--------------------------------------
# LOGGING 日记
#--------------------------------------
# 日志配置文件的位置。 例如，Logback的classpath:logback.xml
logging.config=classpath:logback.xml
# 日志文件名（例如，`myapp.log`）。名称可以是精确位置或相对于当前目录。
logging.file=property.log
# 最大日志文件大小。 仅支持默认的logback设置
logging.file.max-size=10MB
# 日志文件的位置。 例如，`/ var / log`。
logging.path=/var/log

#---------------------------------
# AOP
#---------------------------------
# 使用AOP 切面编程
spring.aop.auto=true
#是否要创建基于子类的（CGLIB）代理（true），而不是基于标准Java接口的代理（false）
spring.aop.proxy-target-class=true

#--------------------------------
# Email
#--------------------------------
# 编码格式
spring.mail.default-encoding=UTF-8
# SMTP服务器主机
spring.mail.host=smtp.property.com
#SMTP服务器端口
spring.mail.port=7800
# 登录SMTP用户名
spring.mail.username=property
# 登录SMTP密码
spring.mail.password=123456

#--------------------------------
# WEB 属性配置
#--------------------------------
# 服务器应绑定的网络地址
server.address=127.0.0.1
# 是否启用了响应压缩
server.compression.enabled=false
# 连接器在关闭连接之前等待另一个HTTP请求的时间。 未设置时，将使用连接器的特定于容器的默认值。 使用值-1表示没有（即无限）超时
server.connection-timeout=2000
# 错误控制器的路径
server.error.path=/error
# 是否启用HTTP / 2支持，如果当前环境支持它。
server.http2.enabled=false
# 服务器端口默认为:8080
server.port=8084
# SP servlet的类名。
server.servlet.jsp.class-name=org.apache.jasper.servlet.JspServlet
# 主调度程序servlet的路径。
server.servlet.path=/home
# 会话cookie名称
server.servlet.session.cookie.name=propertydemo

#------------------------------
# HTTP encoding
#------------------------------
# HTTP请求和响应的字符集。 如果未明确设置，则添加到“Content-Type”标头。
spring.http.encoding.charset=UTF-8
# 是否启用http编码支持。
spring.http.encoding.enabled=true
#--------------------
# MULTIPART (MultipartProperties)
#--------------------
# 是否启用分段上传支持
spring.servlet.multipart.enabled=true
# 上传文件的中间位置
spring.servlet.multipart.location=/log
# 最大文件的大小
spring.servlet.multipart.max-file-size=1MB
# 最大请求大小
spring.servlet.multipart.max-request-size=10MB
# 是否在文件或参数访问时懒惰地解析多部分请求。
spring.servlet.multipart.resolve-lazily=false
#--------------------------------------------
# SPRING SESSION JDBC (JdbcSessionProperties)
#--------------------------------------------
# cron表达式用于过期的会话清理作业
spring.session.jdbc.cleanup-cron=0 * * * * *
# 数据库模式初始化模式
spring.session.jdbc.initialize-schema=embedded
# 用于初始化数据库模式的SQL文件的路径
spring.session.jdbc.schema=classpath:org/springframework/session/jdbc/schema-@@platform@@.sql
# 用于存储会话的数据库表的名称
spring.session.jdbc.table-name=SPRING_SESSION

#----------------------------------
# MONGODB 数据库配置
#----------------------------------
# 数据库名称
spring.data.mongodb.database=demo
# host 配置
spring.data.mongodb.host=127.0.0.1
# 登录用户名
spring.data.mongodb.username=property
# 登录密码
spring.data.mongodb.password=123456
# 端口号，自己根据安装的mongodb端口配置
spring.data.mongodb.port=9008
# 要启用的Mongo存储库的类型
spring.data.mongodb.repositories.type=auto
# 连接数据uri
spring.data.mongodb.uri=mongodb://localhost/test

#---------------------------------------
# DATASOURCE 数据库配置
#---------------------------------------
# MySql jdbc Driver
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
# 连接数据库
# demo表示的是你创建的数据库;
spring.datasource.url=jdbc:mysql://127.0.0.1:3306/demo?useSSL=false&requireSSL=false&characterEncoding=UTF-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
# 数据库用户名
spring.datasource.username=root
# 数据库密码
spring.datasource.password=123456
#-----------------------------------
# Jpa使用
#-----------------------------------
# 目标数据库进行操作，默认情况下自动检测。可以使用“databasePlatform”属性设置。
#spring.jpa.database= demo1
# 要操作的目标数据库的名称，默认情况下自动检测。 也可以使用“Database”枚举来设置。
#spring.jpa.database-platform=DEMO
# DDL模式 一般有这几种方式,Spring Boot会根据是否认为您的数据库是嵌入式的，为您选择一个默认值
# update: 更新架构时，使用;
spring.jpa.hibernate.ddl-auto=update
# 是否启用SQL语句的日志记录
spring.jpa.show-sql=true

#----------------------------------------
# TESTING PROPERTIES
#----------------------------------------
# 要替换的现有DataSource的类型
spring.test.database.replace=any
# MVC打印选项
spring.test.mockmvc.print=default

# ---------------大家查看文档进行配置，不一一列举了----------------------

#  各个属性注解在查看常用配置文件application.properties中

# FREEMARKER

# DEVTOOLS配置

# SPRING HATEOAS

# HTTP message conversion

# GSON

# JDBC

# JEST (Elasticsearch HTTP client) (JestProperties)

# CASSANDRA (CassandraProperties)
# --------------------------等等----------------------------------
```
> 查看常用配置文件[application.properties](https://github.com/eirunye/SpringBoot_Property/blob/master/src/main/resources/application.properties)

### 自定义属性

 由于有时为了方便项目的开发维护，我们可能需要到自定义配置属性，接下来我们也来搞一下自定义属性配置。

 >在**application.properties**自定义配置属性:

1.application.properties添加:

```
#--------------------------------
# 自定义属性
#--------------------------------
com.eirunye.defproname="root"
com.eirunye.defpropass="123456"
```

2.在**DefPropertyController.class**引用

```
@RestController
public class DefPropertyController {

    @Value("${com.eirunye.defproname}")
    private String defProName;

    @Value("${com.eirunye.defpropass}")
    private String defProPass;

    @RequestMapping(value = "/defproprety")
    public String defPropretyUser() {
        return "这个自定义属性名为: " + defProName + ", 密码为:" + defProPass;
    }
}
```

* **注意**
在获取自定义属性时一定要严格按照配置文件来获取并且Value里面的字符串一定是`$`+花括号`{***}`,花括号里面的`***`表示为:`application.properties里面自定义的字符串`，所以本例就是表示为:` @Value("${com.eirunye.defproname}")` 。
如果`application.properties`有自定义为` test.ok="haha" `,同样的获取方式为:`@Value("${test.ok}")`

3.测试`这里暂未使用测试代码的方式，后面的文章会讲到`

* IntelliJ IDEA访问
```
http://localhost:8084/defproprety
```

![def_idea.png](https://upload-images.jianshu.io/upload_images/3012005-d5479d7990d69320.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/600)

* [Postman访问](https://www.getpostman.com/)

![def_postman.png](https://upload-images.jianshu.io/upload_images/3012005-a52caf3352427bd0.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/600)

> 通过Bean的形式获取

假如我们遇到这样情况，自定义属性多，然后每个都是通过`@Value(${""})`方式的话可能会很容易出错，那么我们可以采用以下方式。

1.新建一个`Properties.class`
添加`@ConfigurationProperties(prefix = "com.eirunye")`//表示的是通过自定义属性查找，如果自定义是:`test.ok=haha`,则该这样表示:`@ConfigurationProperties(prefix = "test")`

```
@ConfigurationProperties(prefix = "com.eirunye")//添加该注解
public class Properties {
    private String defproname;
    private String defpropass;
//  get/set方法
    public String getDefproname() {
        return defproname;
    }
    public void setDefproname(String defproname) {
        this.defproname = defproname;
    }
    public String getDefpropass() {
        return defpropass;
    }
    public void setDefpropass(String defpropass) {
        this.defpropass = defpropass;
    }}
```

2.在controller包下创建 `DefBeanPropertyController.class`

```
@RestController
public class DefBeanPropertyController {
   //通过 Autowired注解来获取到 Properties属性，注:Autowired是按类型进行装配，可获取它所装配类的属性
    @Autowired
    Properties properties;

    @RequestMapping(value = "/bean/defproperty")
    public String getDefBeanProperties() {
        return "这是通过Bean注解的方式获取属性: " + properties.getDefproname() + ",密码为: " + properties.getDefpropass();
    }}
```

3.在项目的入口文件**Application**添加注解**@EnableConfigurationProperties**
最后加上包名不然可能找不到扫描文件如:`@EnableConfigurationProperties({com.eirunye.defpropertys.bean.Properties.class})`。

```
@SpringBootApplication
@EnableConfigurationProperties({com.eirunye.defpropertys.bean.Properties.class})//添加注解bean的扫描文件
public class DefpropertysApplication {

	public static void main(String[] args) {
		SpringApplication.run(DefpropertysApplication.class, args);
	}
}
```

4.测试
IntelliJ IDEA访问

![bean_def_idea.png](https://upload-images.jianshu.io/upload_images/3012005-e83c94a826f2309d.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/600)

 > 创建文件xxx.properties文件方式

我们可以自己创建一个自定义属性的文件如本例**def.properties**，(*注:一般都是以 **.properties** 文件结尾*)

1.添加自定义`def.properties`配置如下:

![def_file.png](https://upload-images.jianshu.io/upload_images/3012005-7730447bb95f7fee.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/500)

```
#--------------------------------
# 自定义属性
#--------------------------------
# 用户名
com.eirunye.defineuser="property"
# 年龄
com.eirunye.defineage=20
```

2.创建 `DefineProperties.class`

```
@Configuration
@ConfigurationProperties(prefix = "com.eirunye")//添加注解 ConfigurationProperties "com.eirunye"表示的是自定义属性
@PropertySource("classpath:defines.properties")// 添加注解 PropertySource 该注解能根据路径扫描到我们的文件
public class DefineProperties {
//    这里可以通过@Value("${}")方式添加,我已经屏蔽掉了，直接通过ConfigurationProperties注解的方式
//    @Value("${com.eirunye.defineuser}")
    private String defineuser;
//    @Value("${com.eirunye.defineage}")
    private int defineage;
// get/set方法
    public String getDefineuser() {
        return defineuser;
    }
    public void setDefineuser(String defineuser) {
        this.defineuser = defineuser;
    }
    public int getDefineage() {
        return defineage;
    }
    public void setDefineage(int defineage) {
        this.defineage = defineage;
    }}
```

3.在`DefinePropertiesController.class`引用

```
@RestController
public class DefinePropertiesController {
    @Autowired
    DefineProperties defineProperties;
    @RequestMapping(value = "define/Properties")
    public String getDefinePropertiesData(){
        return "新建文件自定义属性姓名："+defineProperties.getDefineuser()+",新建文件自定义属性年龄："+defineProperties.getDefineage();
    }
}
```

4.别忘了在Application里面添加配置`@EnableConfigurationProperties`,即：`@EnableConfigurationProperties({com.eirunye.defpropertys.bean.Properties.class,com.eirunye.defpropertys.bean.DefineProperties.class})
`

5.测试

```
http://localhost:8084/define/Properties
```

![def_idea_show.png](https://upload-images.jianshu.io/upload_images/3012005-9fb441bce0fc8ecf.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/600)

>**下载application.properties[案例demo](https://github.com/eirunye/SpringBoot_defpropertys)**


## application.yml配置

由于application.properties配置有点繁琐，简洁是我们非常喜欢的，那么在Spring Boot程序里面当然也是可以用.yml文件来配置的，接下来让我们进入对.yml文件的一些相关配置吧，官方文档[Using YAML Instead of Properties](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#boot-features-external-config-yaml)。

### 常见的配置

首先在src目录下的/main/resource文件夹中新建`application.yml、application-dev.yml、application-prod.yml`三个文件，删除`application.properties`文件，目录结构如下:
```
|--src
   |--main
      |--resources
         |--application.yml
         |--application-dev.yml
         |--application-prod.yml
```
相信很多人要骂街了，这什么情况不是说,yml配置很给力吗？怎么还有创建那么多文件，这不是比上面的  `application.properties`配置还多此一举吗？莫急接下来让我们来看看.yml的配置之后，我相信你肯定在项目中会喜欢用它。

常见的配置属性如下: 【注意: 这里属性之间的间隔必须按照要求而来,如:冒号后面要空格】
`application.yml` 配置

```
spring:
  profiles:
    active: dev   #引用 application-dev.yml文件,这里我们可以改为 prod,表示引用application-prod.yml文件
  datasource:
      driver-class-name: com.mysql.cj.jdbc.Driver
      url: jdbc:mysql://127.0.0.1:3306/demo?useSSL=false&requireSSL=false&characterEncoding=UTF-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
      username: root
      password: 12346
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
  data:
    mongodb:
      host: 127.0.0.1
      uri: mongodb://localhost/test
      username: root
      password: 123456
      database: test
  test:
    database:
      replace: any
    mockmvc:
      print: default
  servlet:
    multipart:
      enabled: true
```

`application-dev.yml` 可以当成正式服务器端口

```
server:
  port: 8084
```

`application-prod.yml` 可以当成测试服务器端口

```
server:
  port: 8080
```

* **查看更多[.yml配置](https://github.com/eirunye/SpringBoot_Property/blob/master/src/main/resources/application.yml)**

### 自定义yml配置
> 在application.yml配置

1.和上面的application.properties类似，但是需要注意的是*格式问题*
```
com:
  eirunye:
    ymlname: ymlroot
    ymlpass: yml123456
```

2.通过`@Value("${com.eirunye.ymlname}")`获取

```
@RestController
public class YmlPropertiesController{
    @Value("${com.eirunye.ymlname}")
    private String ymlname;

    @Value("${com.eirunye.ymlpass}")
    private String ymlpass;

    @RequestMapping(value = "yml/proprety")
    public String getYmlPropreties() {
        return "这个自定义属性名为: " + ymlname+ ", 密码为:" + ymlpass;
    }
}
```
3.测试—访问:

```
http://localhost:8084/yml/proprety
```

![yml_def.png](https://upload-images.jianshu.io/upload_images/3012005-eae9ed7abb04ee43.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/600)

> 通过Bean方式获取和application.properties方式一样

1.创建YmlPropertyBean.class

```
@ConfigurationProperties(prefix = "com.eirunye")//添加该注解
public class YmlPropertyBean {

    private String ymlname;
    private String ymlpass;
// get/set方法.....
}
```

2.在 `YmlPropertyBeanController.class`引用

```
@RestController
public class YmlPropertyBeanController {
    @Autowired
    YmlPropertyBean propertyBean;
    @RequestMapping(value = "/bean/ymlproperty")
    public String getYmlPropertyData(){
        return "这个bean自定义属性名为: " + propertyBean.getYmlname()+ ", 密码为:" + propertyBean.getYmlpass();
    }
}
```
3.测试-访问

```
http://localhost:8084/bean/ymlproperty
```

![yml_bean_def.png](https://upload-images.jianshu.io/upload_images/3012005-5551aabdebf638ee.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/600)


>下载.yml[案例demo](https://github.com/eirunye/SpringBoot_defineyml)

# 总结

   1.本篇主要讲得配置文件，到此就结束了，在开发中这是我们经常用到。
   2.在本篇有些相关配置，本例的代码实例还没涉及到，接下来会继续结合相关的配置案例继续更新。
   3.相信大家也有所掌握。

