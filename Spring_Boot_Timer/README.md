# <div align=center>Spring boot 定时器(九)</div>
  
# 简介

在项目中我们有时需要做定时任务，那么我们在Spring Boot项目中如何添加定时任务呢？非常简单，让我们一起学习吧。

<div align=center>
<img src="https://upload-images.jianshu.io/upload_images/3012005-06639c85d05db900.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/330">
</div>

#本篇案例分析在这里

[**Spring boot 定时器(九)**]()

# 简单实现

## Spring boot 定时器的运用
      
>主要是添加注解的方式进行

```      
         
1、在Application中添加
    @MapperScan("com.example.myjpa.dao")//mybatis的注解
    @EnableScheduling//定时器注解
          
2、创建 ScheduledTasks.class添加注解：
    @Configuration //1.主要用于标记配置类，兼备Component的效果。
    @EnableScheduling // 2.开启定时任务
          
3、创建config定时器配置 CompleteScheduleConfig.class
    @Configuration
    @EnableScheduling
          
4、代码如下：
          
    private static String DEFAULT_CRON = "0 0/2 * * * ?";//表示间隔2分钟
          //cron的时间间隔语法：0 0/2 * * * ?;
    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {

          //        scheduledTaskRegistrar.scheduleFixedDelayTask(new FixedDelayTask(() -> {
          //
          //        }, 10000, 1000 * 60));

     scheduledTaskRegistrar.addTriggerTask(() -> {
         Student student = new Student();
         student.setName("ok");
         student.setAge(12);
         student.setSex("nan");
         studentRepository.save(student);//jpa插入数据
         }, triggerContext -> {
            return new CronTrigger(DEFAULT_CRON).nextExecutionTime(triggerContext);
        });
    }
          
```        
# 推荐

* [**我的博客https://eirunye.github.io**](https://eirunye.github.io)进行浏览相关技术文章，大家一起相互探讨技术。

* 如果大家想了解更多的Spring Boot相关博文请进入我的[**Spring Boot系列博客栈**](https://eirunye.github.io/categories/%E5%90%8E%E5%8F%B0/Spring-Boot/)
  
  
