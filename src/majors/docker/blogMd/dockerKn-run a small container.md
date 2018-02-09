# docker
## run a small container
Docker hello world 
```
[root@k8s-node-1 ~]# docker run ubuntu:15.10 /bin/echo "Hello world"
 
```
各个参数解析：
```
各个参数解析：
docker: Docker 的二进制执行文件。
run:与前面的 docker 组合来运行一个容器。
ubuntu:15.10指定要运行的镜像，Docker首先从本地主机上查找镜像是否存在，如果不存在，Docker 就会从镜像仓库 Docker Hub 下载公共镜像。
/bin/echo "Hello world": 在启动的容器里执行的命令
以上命令完整的意思可以解释为：Docker 以 ubuntu15.10 镜像创建一个新容器，然后在容器里执行 bin/echo "Hello world"，然后输出结果。 
```
>result:
```
Unable to find image 'ubuntu:15.10' locally
Trying to pull repository docker.io/library/ubuntu ...
15.10: Pulling from docker.io/library/ubuntu

7dcf5a444392: Pull complete
759aa75f3cee: Pull complete
3fa871dc8a2b: Pull complete
224c42ae46e7: Pull complete
Digest: sha256:02521a2d079595241c6793b2044f02eecf294034f31d6e235ac4b2b54ffc41f3
Hello world
[root@k8s-node-1 ~]#
 
```
>运行交互式的容器:我们通过docker的两个参数 -i -t，让docker运行的容器实现"对话"的能力
``` 
[root@k8s-node-1 ~]# docker run -i -t ubuntu:15.10
root@2b56be9d9926:/# /bin/echo hello
hello
root@2b56be9d9926:/#
root@2b56be9d9926:/# cat /proc/version
Linux version 3.10.0-514.el7.x86_64 (builder@kbuilder.dev.centos.org) (gcc version 4.8.5 20150623 (Red Hat 4.8.5-11) (GCC) ) #1 SMP Tue Nov 22 16:42:41 UTC 2016
root@2b56be9d9926:/# ls
bin  boot  dev  etc  home  lib  lib64  media  mnt  opt  proc  root  run  sbin  srv  sys  tmp  usr  var
root@2b56be9d9926:/#


```
>后台运行
``` 
[root@k8s-node-1 ~]# docker run -d ubuntu:15.10 /bin/sh -c "while true; do echo hello world; sleep 1; done"
b943d4e46eda743e148ffd8db8b1a3402569fecfe5b98f2d220e177eccd4b454
[root@k8s-node-1 ~]# docker ps
CONTAINER ID        IMAGE                                                        COMMAND                  CREATED             STATUS              PORTS               NAMES
b943d4e46eda        ubuntu:15.10                                                 "/bin/sh -c 'while tr"   12 seconds ago      Up 8 seconds                            focused_kalam
eb14e51e9c81        mysql                                                        "docker-entrypoint.sh"   About an hour ago   Up About an hour                        k8s_mysql.f6601b53_mysql-x49jl_default_1870df30-0d8c-11e8-aee2-000c293bc0a4_9e491028
ca4f6b7529c9        kubeguide/tomcat-app:v1                                      "catalina.sh run"        About an hour ago   Up About an hour                        k8s_myweb.b8944271_myweb-wm2qf_default_49508eaa-0d8c-11e8-aee2-000c293bc0a4_26b0808b
3ab7864b8a57        registry.access.redhat.com/rhel7/pod-infrastructure:latest   "/usr/bin/pod"           About an hour ago   Up About an hour                        k8s_POD.24f70ba9_myweb-wm2qf_default_49508eaa-0d8c-11e8-aee2-000c293bc0a4_75f16629
32ef1ad61814        nginx                                                        "nginx -g 'daemon off"   About an hour ago   Up About an hour                        k8s_my-nginx.a65fe6c_my-nginx-379829228-5zsbt_default_a43169ca-0c2c-11e8-8cec-000c293bc0a4_f30b4751
649596bf8018        nginx                                                        "nginx -g 'daemon off"   About an hour ago   Up About an hour                        k8s_my-nginx.a65fe6c_my-nginx-379829228-33wq5_default_a431e6ab-0c2c-11e8-8cec-000c293bc0a4_59f96cfc
8ec20f6830b9        registry.access.redhat.com/rhel7/pod-infrastructure:latest   "/usr/bin/pod"           About an hour ago   Up About an hour                        k8s_POD.1d520ba5_mysql-x49jl_default_1870df30-0d8c-11e8-aee2-000c293bc0a4_4527a0e2
88967cb40074        registry.access.redhat.com/rhel7/pod-infrastructure:latest   "/usr/bin/pod"           About an hour ago   Up About an hour                        k8s_POD.a8590b41_my-nginx-379829228-33wq5_default_a431e6ab-0c2c-11e8-8cec-000c293bc0a4_a8e25b0c
8eaab48caa4d        registry.access.redhat.com/rhel7/pod-infrastructure:latest   "/usr/bin/pod"           About an hour ago   Up About an hour                        k8s_POD.a8590b41_my-nginx-379829228-5zsbt_default_a43169ca-0c2c-11e8-8cec-000c293bc0a4_b6c3d4ff
[root@k8s-node-1 ~]# docker logs b943d4e46eda
hello world
hello world
hello world
hello world
...
[root@k8s-node-1 ~]# docker logs focused_kalam
hello world
hello world
hello world
hello world
...
```


