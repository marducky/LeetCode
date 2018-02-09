# docker
## how to use docker.
Docker hello world 

```

[root@k8s-node-1 ~]#  docker pull training/webapp
Using default tag: latest
Trying to pull repository docker.io/training/webapp ...
latest: Pulling from docker.io/training/webapp
e190868d63f8: Pull complete
909cd34c6fd7: Pull complete
0b9bfabab7c1: Pull complete
a3ed95caeb02: Pull complete
10bbbc0fc0ff: Pull complete
fca59b508e9f: Pull complete
e7ae2541b15b: Pull complete
9dd97ef58ce9: Pull complete
a4c1b0cb7af7: Pull complete
Digest: sha256:06e9c1983bd6d5db5fba376ccd63bfa529e8d02f23d5079b8f74a616308fb11d
[root@k8s-node-1 ~]# docker run -d -P training/webapp python app.py
240e2d44accc5206b00f0744cea8717b19cbfa66a59a3f2caaa1ce409cfec973
[root@k8s-node-1 ~]#

 ```
 >参数说明
 ``` 
 -d:让容器在后台运行。
 -P:将容器内部使用的网络端口映射到我们使用的主机上。
 
[root@k8s-node-1 ~]# docker ps
CONTAINER ID        IMAGE                                                        COMMAND                  CREATED              STATUS              PORTS                     NAMES
240e2d44accc        training/webapp                                              "python app.py"          About a minute ago   Up About a minute   0.0.0.0:32768->5000/tcp   boring_mclean

 ```
 >run the web container
 ```
 [root@k8s-node-1 ~]# curl http://192.168.117.130:32768/
 Hello world![root@k8s-node-1 ~]#
 
 ```
 >-p
 ```
 [root@k8s-node-1 ~]# docker run -d -p 5000:5000 training/webapp python app.py
 6f382cb32d896005fec89ec94137a45ec05849d1fa15230dca307d3ad0268a23
 [root@k8s-node-1 ~]# docker ps
 CONTAINER ID        IMAGE                                                        COMMAND                  CREATED             STATUS              PORTS                     NAMES
 6f382cb32d89        training/webapp                                              "python app.py"          46 seconds ago      Up 42 seconds       0.0.0.0:5000->5000/tcp    serene_blackwell
 240e2d44accc        training/webapp                                              "python app.py"          7 minutes ago       Up 7 minutes        0.0.0.0:32768->5000/tcp   boring_mclean


```
>other command 
``` 
docker rm 
docker start
docker  run -d -P (no port : prot)
docker run -d -p 222:222
```
 

