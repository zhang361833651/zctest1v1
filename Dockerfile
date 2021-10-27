FROM openjdk:8-jdk-alpine

MAINTAINER zhangchi

ADD http://console-cust92.netease.com/download/nsf/nsf-agent-v2.6.8-c2a5e1f9-20201203-141827.jar  /nsf-agent.jar
ADD ./target/zctest1v1-0.0.1-SNAPSHOT.jar /zctest1v1.jar
#ADD ./src/main/resources/nsf.yml /hdtest2.yml

#不带nsf-agent启动
ENTRYPOINT ["java","-jar","zctest1v1.jar"]

#带nsf-agent启动, nsf.yml是以configmap挂载的
#ENTRYPOINT ["java","-Dnsf.log.level=debug","-javaagent:/nsf-agent.jar=hdtest2","-jar","/hdtest2.jar"]
