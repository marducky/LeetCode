# docker
## how to use images
>command 
``` 
docker images

[root@k8s-node-1 ~]# docker images
REPOSITORY                                            TAG                 IMAGE ID            CREATED             SIZE
docker.io/mysql                                       latest              f008d8ff927d        3 weeks ago         408.5 MB
docker.io/nginx                                       latest              3f8a4339aadd        6 weeks ago         108.5 MB
registry.access.redhat.com/rhel7/pod-infrastructure   latest              99965fb98423        3 months ago        208.6 MB
docker.io/ubuntu                                      15.10               9b9cb95443b5        18 months ago       137.2 MB
docker.io/kubeguide/tomcat-app                        v1                  a29e200a18e9        19 months ago       358.2 MB
docker.io/training/webapp                             latest              6fae60ef3446        2 years ago         348.7 MB
[root@k8s-node-1 ~]#

```
>标签说明
``` 
各个选项说明:
REPOSITORY：表示镜像的仓库源
TAG：镜像的标签
IMAGE ID：镜像ID
CREATED：镜像创建时间
SIZE：镜像大小
同一仓库源可以有多个 TAG，代表这个仓库源的不同个版本，如ubuntu仓库源里，有15.10、14.04等多个不同的版本，我们使用 REPOSITORY:TAG 来定义不同的镜像。
```

>docker search mysql 
``` 

[root@k8s-node-1 ~]# docker search mysql
INDEX       NAME                                                             DESCRIPTION                                     STARS     OFFICIAL   AUTOMATED
docker.io   docker.io/mysql                                                  MySQL is a widely used, open-source relati...   5682      [OK]
docker.io   docker.io/mariadb                                                MariaDB is a community-developed fork of M...   1763      [OK]
docker.io   docker.io/mysql/mysql-server                                     Optimized MySQL Server Docker images. Crea...   390                  [OK]
docker.io   docker.io/zabbix/zabbix-server-mysql                             Zabbix Server with MySQL database support       79                   [OK]
docker.io   docker.io/hypriot/rpi-mysql                                      RPi-compatible Docker Image with Mysql          78
docker.io   docker.io/centurylink/mysql                                      Image containing mysql. Optimized to be li...   58                   [OK]
docker.io   docker.io/zabbix/zabbix-web-nginx-mysql                          Zabbix frontend based on Nginx web-server ...   41                   [OK]
docker.io   docker.io/tutum/mysql                                            Base docker image to run a MySQL database ...   31
docker.io   docker.io/1and1internet/ubuntu-16-nginx-php-phpmyadmin-mysql-5   ubuntu-16-nginx-php-phpmyadmin-mysql-5          25                   [OK]
docker.io   docker.io/mysql/mysql-cluster                                    Experimental MySQL Cluster Docker images. ...   19
docker.io   docker.io/centos/mysql-57-centos7                                MySQL 5.7 SQL database server                   18
docker.io   docker.io/schickling/mysql-backup-s3                             Backup MySQL to S3 (supports periodic back...   16                   [OK]

```
```
NAME:镜像仓库源的名称
DESCRIPTION:镜像的描述
OFFICIAL:是否docker官方发布
   ```
>创建镜像

1.从已经创建的容器中更新镜像，并且提交这个镜像；<br>
2.使用 Dockerfile 指令来创建一个新的镜像
>1.从已经创建的容器中更新镜像，并且提交这个镜像；
``` 
[root@k8s-node-1 ~]# docker run -t -i ubuntu:15.10 /bin/bash
root@4b59295fc634:/# apt-get update
Ign http://archive.ubuntu.com wily InRelease

```
``` 
root@4b59295fc634:/# exit
[root@k8s-node-1 ~]# docker commit -m="has update" -a="Neng Qi" 4b59295fc634 NengQi/ubuntu:v2
Error response from daemon: invalid reference format: repository name must be lowercase
[root@k8s-node-1 ~]# docker commit -m="has update" -a="Neng Qi" 4b59295fc634 janus/ubuntu:v2
sha256:2c6eeb4d8c7c5f9dcd2754a9353b15dbd1b6917bf98a06741e1b0feae7242476
[root@k8s-node-1 ~]#

[root@k8s-node-1 ~]# docker images
REPOSITORY                                            TAG                 IMAGE ID            CREATED             SIZE
janus/ubuntu                                          v2                  2c6eeb4d8c7c        3 minutes ago       137.2 MB

```
``` 
[root@k8s-node-1 ~]# docker run -t -i janus/ubuntu:v2 /bin/echo helloworld
helloworld
[root@k8s-node-1 ~]# docker run -t -i janus/ubuntu:v2 /bin/echo

[root@k8s-node-1 ~]# docker run -t -i janus/ubuntu:v2
root@e65437ec8022:/# exit
[root@k8s-node-1 ~]#

```
>2.使用 Dockerfile 指令来创建一个新的镜像
``` 

[root@k8s-node-1 dockerKn]# cat Dockerfile
FROM    centos:6.7
MAINTAINER      Neng.Qi "neng.qi@nuance.com"

RUN     /bin/echo 'root:123456'| chpasswd
RUN     useradd janus
RUN     /bin/echo 'root:123456'| chpasswd
RUN     /bin/echo -e "LANG=\"en_US.UTF-8\"" >/etc/default/local
EXPOSE  22
EXPOSE  80
CMD     /usr/sbin/sshd -D
[root@k8s-node-1 dockerKn]# docker build -t janus/centos:6.7
"docker build" requires exactly 1 argument(s).
See 'docker build --help'.

Usage:  docker build [OPTIONS] PATH | URL | -

Build an image from a Dockerfile
[root@k8s-node-1 dockerKn]# docker build -t janus/centos:6.7 .
Sending build context to Docker daemon 2.048 kB
Step 1 : FROM centos:6.7
Trying to pull repository docker.io/library/centos ...
6.7: Pulling from docker.io/library/centos
cbddbc0189a0: Pull complete
Digest: sha256:7248c96de4648749c7936f203d983530e7ebdd83c3db6d47278392f18bcd7baf
 ---> 000c5746fa52
Step 2 : MAINTAINER Neng.Qi "neng.qi@nuance.com"
 ---> Running in 6e32e3d0b14d
 ---> 1983728a9419
Removing intermediate container 6e32e3d0b14d
Step 3 : RUN /bin/echo 'root:123456'| chpasswd
 ---> Running in ec5e1b154383
 ---> f9239bfa747f
Removing intermediate container ec5e1b154383
Step 4 : RUN useradd janus
 ---> Running in 3296b7904a2b
 ---> f8fa184fce64
Removing intermediate container 3296b7904a2b
Step 5 : RUN /bin/echo 'root:123456'| chpasswd
 ---> Running in 6140eab37607
 ---> 7dfd71254d95
Removing intermediate container 6140eab37607
Step 6 : RUN /bin/echo -e "LANG=\"en_US.UTF-8\"" >/etc/default/local
 ---> Running in f0a2ae2d721e
 ---> 34628f44170c
Removing intermediate container f0a2ae2d721e
Step 7 : EXPOSE 22
 ---> Running in 9e2187105082
 ---> 31988443b3c4
Removing intermediate container 9e2187105082
Step 8 : EXPOSE 80
 ---> Running in ca9e0a2fb0ef
 ---> 74be778e2010
Removing intermediate container ca9e0a2fb0ef
Step 9 : CMD /usr/sbin/sshd -D
 ---> Running in 4dacfe7ea12d
 ---> 4cc6c3922128
Removing intermediate container 4dacfe7ea12d
Successfully built 4cc6c3922128
[root@k8s-node-1 dockerKn]#

```
>每一个指令都会在镜像上创建一个新的层，每一个指令的前缀都必须是大写的。
 第一条FROM，指定使用哪个镜像源
 RUN 指令告诉docker 在镜像内执行命令，安装了什么。。。
 然后，我们使用 Dockerfile 文件，通过 docker build 命令来构建一个镜像。
 参数说明：
 -t ：指定要创建的目标镜像名
 . ：Dockerfile 文件所在目录，可以指定Dockerfile 的绝对路径
``` 
[root@k8s-node-1 dockerKn]# docker images
REPOSITORY                                            TAG                 IMAGE ID            CREATED              SIZE
janus/centos                                          6.7                 4cc6c3922128        About a minute ago   190.6 MB
janus/ubuntu                                          v2                  2c6eeb4d8c7c        27 minutes ago       137.2 MB

```
``` 

[root@k8s-node-1 dockerKn]# docker run -t -i janus/centos:6.7 /bin/bash
[root@0f5c8b4b4860 /]# id janus
uid=500(janus) gid=500(janus) groups=500(janus)
[root@0f5c8b4b4860 /]#

```
>为镜像打标签 tag
``` 
[root@k8s-node-1 dockerKn]# docker tag 4cc6c3922128 janus/centos:dev
[root@k8s-node-1 dockerKn]# docker images
REPOSITORY                                            TAG                 IMAGE ID            CREATED             SIZE
janus/centos                                          6.7                 4cc6c3922128        4 minutes ago       190.6 MB
janus/centos                                          dev                 4cc6c3922128        4 minutes ago       190.6 MB
janus/ubuntu                                          v2                  2c6eeb4d8c7c        30 minutes ago      137.2 MB

```
