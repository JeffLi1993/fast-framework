# fast-framework
轻量级 Java Web 框架

- 基于 Servlet 3.0 规范
- 零配置
- REST 服务接口 基于 JSON 传输
- 目前提供 MVC ... 解决方案

### 快速入门
##### 1. 必备环境
- [Git 环境搭建](http://)
- [Maven 环境搭建](http://)
##### 2. 下载 fast-framework 项目及 sample 案例
````
git clone https://github.com/JeffLi1993/fast-framework.git
````

##### 3. Maven 编译 sample 案例
````
cd fast-framework // cd 到工程根目录

mvn clean install // 编译工程
````

##### 4. 启动 sample 案例
````
cd fast-sample // cd 到 sample 案例工程根目录
mvn jetty:run  // 启动 sample 工程
````
Console 出现,表示服务器成功启动:
````
...
[INFO] Started ServerConnector@f1a45f8{HTTP/1.1}{0.0.0.0:8080}
[INFO] Started @5133ms
[INFO] Started Jetty Server
[INFO] Starting scanner at interval of 10 seconds.
````

##### 5. 访问 sample
在浏览器中打开:
````
http://localhost:8080/hello?name=BYSocket
````
会得到如下结果:
![sample结果图](http://www.bysocket.com/wp-content/uploads/2016/08/QQ20160810-0.png)