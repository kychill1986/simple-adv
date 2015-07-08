此项目是simple项目升级版，在simple的基础上增加了mybatis，spring，redis

此项目集成了spring-boot的基本业务

说明:
1. application.properties是spring boot的默认配置文件,其中包含tomcat的配置，spring-boot通过此文件对集成在其中的一些框架进行配置

2. 不编译，在cmd中直接启动项目使用命令：mvn spring-boot:run

3. 打包使用 mvn clean assembly:assembly -Pproduct，在target目录下会生成一个simple.jar，运行jar：java -jar simple.jar，来启动服务，测试访问 http://localhost:8081/hello