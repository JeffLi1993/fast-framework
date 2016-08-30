泥瓦匠本意：<br>
    " 生产暂时不要用fast-framework,
      是想让大家如何理解 MVC 框架的核心,
      以后会带上系列实现文章"

[![maven-central](https://img.shields.io/maven-central/v/com.bladejava/blade-core.svg?style=flat-square)](http://search.maven.org/#search%7Cga%7C1%7Cg%3A%22com.bladejava%22)
[![License](https://img.shields.io/badge/license-Apache%202-4EB1BA.svg?style=flat-square)](https://www.apache.org/licenses/LICENSE-2.0.html)
<br>
[[English Document]](https://github.com/JeffLi1993/fast-framework/blob/master/README_EN.md)

# fast-framework
轻量级 Java Web 框架

- 基于 JDK 8 规范
- 基于 Servlet 3.0 规范
- 零配置
- REST 服务接口 基于 JSON 传输
- 目前提供 MVC ... 解决方案
<br><br>

## 作者与学习乐园
源码地址：我的[GitHub地址](https://github.com/JeffLi1993 "GitHub")<br>
作者： [李强强](http://www.bysocket.com/ "李强强") 也叫 泥瓦匠<br>
QQ群：编程之美 365234583  [立即加入](http://jq.qq.com/?_wv=1027&k=Sx4s4U "编程之美")<br>
欢迎阅读以下博文：<br>
Fast-FrameWork系列文章：[传送门](http://www.bysocket.com/?cat=102)
<br><br>

## 快速入门
#### 1. 必备环境
- [Git 环境搭建](http://)
- [Maven 环境搭建](http://www.bysocket.com/?p=1267)<br>

#### 2. 下载 fast-framework 项目及 sample 案例
````
git clone https://github.com/JeffLi1993/fast-framework.git
````

#### 3. Maven 编译 sample 案例
````
cd fast-framework // cd 到工程根目录

mvn clean install // 编译工程
````

#### 4. 启动 sample 案例
````
cd fast-sample // cd 到 sample 案例工程根目录
mvn jetty:run  // 启动 sample 工程
````
Console 出现如下结果,表示服务器成功启动:
````
...
[INFO] Started ServerConnector@f1a45f8{HTTP/1.1}{0.0.0.0:8080}
[INFO] Started @5133ms
[INFO] Started Jetty Server
[INFO] Starting scanner at interval of 10 seconds.
````

#### 5. 访问 sample
##### GET 方式
在浏览器中打开 - text/plain; charset=UTF-8 :
````
GET http://localhost:8080/hello?name=BYSocket
````
会得到如下结果:<br>
![sample结果图](https://github.com/JeffLi1993/fast-framework/blob/master/doc/img/sample-result.png)

在浏览器中打开 - application/json; charset=UTF-8 :
````
GET http://localhost:8080/json?name=BYSocket
````
会得到如下结果:<br>
![sample结果图](https://github.com/JeffLi1993/fast-framework/blob/master/doc/img/sample-json-result.png)

##### POST 方式
在 POSTMan 或者 HTTP 客户端 :
````
POST localhost:8080/user/add HTTP/1.1
Content-Type: application/json
Cache-Control: no-cache
{
    "name":"BYSocket",
    "age":23
}
````
会得到如下结果:<br>
![sample结果图](https://github.com/JeffLi1993/fast-framework/blob/master/doc/img/json-post.png)
