#Learn k8s for stubby work 
## [1 install the k8s env]
## Resource
* **1 How to install the k8s**
>[利用K8S技术栈打造个人私有云（连载之：K8S集群搭建）](https://www.jianshu.com/p/7d1fb03b8925)<br>
* **2 How to use the K8s**
>[Kubernetes是什么?](http://docs.kubernetes.org.cn/227.html) <br>

* **3.1 The shell command to run k8s service in master node**
```
systemctl start etcd
systemctl start flanneld.service
service docker start
systemctl start kube-apiserver.service
systemctl start kube-controller-manager.service
systemctl start kube-scheduler.service
```
* **3.2 The shell command to run k8s service in slave node**
```
systemctl start kubelet.service
systemctl start kube-proxy.service
```
* **4 Failed to start the Docker service**
>failed code:
```
[root@k8s-master ~]# systemctl status docker.service
● docker.service - Docker Application Container Engine
   Loaded: loaded (/usr/lib/systemd/system/docker.service; disabled; vendor preset: disabled)
  Drop-In: /usr/lib/systemd/system/docker.service.d
           └─flannel.conf
   Active: failed (Result: exit-code) since Thu 2018-02-08 05:36:05 EST; 1min 9s ago
     Docs: http://docs.docker.com
  Process: 2409 ExecStart=/usr/bin/dockerd-current --add-runtime docker-runc=/usr/libexec/docker/docker-runc-current --default-runtime=docker-runc --exec-opt native.cgroupdriver=systemd --userland-proxy-path=/usr/libexec/docker/docker-proxy-current $OPTIONS $DOCKER_STORAGE_OPTIONS $DOCKER_NETWORK_OPTIONS $ADD_REGISTRY $BLOCK_REGISTRY $INSECURE_REGISTRY $REGISTRIES (code=exited, status=1/FAILURE)
 Main PID: 2409 (code=exited, status=1/FAILURE)

Feb 08 05:36:05 k8s-master systemd[1]: Starting Docker Application Container Engine...
Feb 08 05:36:05 k8s-master dockerd-current[2409]: time="2018-02-08T05:36:05-05:00" level=fatal msg="unable to configure the Docker daemon with file /etc/docker/daemon.json: invalid character...key string\n"
Feb 08 05:36:05 k8s-master systemd[1]: docker.service: main process exited, code=exited, status=1/FAILURE
Feb 08 05:36:05 k8s-master systemd[1]: Failed to start Docker Application Container Engine.
Feb 08 05:36:05 k8s-master systemd[1]: Unit docker.service entered failed state.
Feb 08 05:36:05 k8s-master systemd[1]: docker.service failed.
Hint: Some lines were ellipsized, use -l to show in full.
[root@k8s-master ~]#

```
>reason
I have modified the /etc/docker/daemon.json to make the docker hub quickly.
```
{"registry-mirrors": ["http://fc02b548.m.daocloud.io"],}
```
change it to 
```
```
but error code:
```
[root@k8s-master docker]# systemctl status docker
● docker.service - Docker Application Container Engine
   Loaded: loaded (/usr/lib/systemd/system/docker.service; disabled; vendor preset: disabled)
  Drop-In: /usr/lib/systemd/system/docker.service.d
           └─flannel.conf
   Active: failed (Result: exit-code) since Thu 2018-02-08 05:52:43 EST; 16s ago
     Docs: http://docs.docker.com
  Process: 2547 ExecStart=/usr/bin/dockerd-current --add-runtime docker-runc=/usr/libexec/docker/docker-runc-current --default-runtime=docker-runc --exec-opt native.cgroupdriver=systemd --userland                          -proxy-path=/usr/libexec/docker/docker-proxy-current $OPTIONS $DOCKER_STORAGE_OPTIONS $DOCKER_NETWORK_OPTIONS $ADD_REGISTRY $BLOCK_REGISTRY $INSECURE_REGISTRY $REGISTRIES (code=exited, status=1/FA                          ILURE)
 Main PID: 2547 (code=exited, status=1/FAILURE)

Feb 08 05:52:43 k8s-master systemd[1]: Starting Docker Application Container Engine...
Feb 08 05:52:43 k8s-master dockerd-current[2547]: time="2018-02-08T05:52:43-05:00" level=fatal msg="unable to configure the Docker daemon with file /etc/docker/daemon.json: the following direct...
Feb 08 05:52:43 k8s-master systemd[1]: docker.service: main process exited, code=exited, status=1/FAILURE
Feb 08 05:52:43 k8s-master systemd[1]: Failed to start Docker Application Container Engine.
Feb 08 05:52:43 k8s-master systemd[1]: Unit docker.service entered failed state.
Feb 08 05:52:43 k8s-master systemd[1]: docker.service failed.
Hint: Some lines were ellipsized, use -l to show in full.
```
um  I delete it 
<br>
then I add:
```
{
  "registry-mirrors": ["https://vddoqdne.mirror.aliyuncs.com"]
}
```
>[aliyun](https://cr.console.aliyun.com)<br>
``` 
sudo systemctl daemon-reload
sudo systemctl restart docker
```

>method to solver it:

```
remove it：
# yum list installed|grep docker 

# rpm -qa|grep docker 
 
 docker.x86_64 2:1.12.6-16.el7.centos @extras 
 docker-client.x86_64 2:1.12.6-16.el7.centos @extras 
 docker-common.x86_64 2:1.12.6-16.el7.centos @extra
 

#yum –y remove docker.x86_64 
#yum –y remove docker-client.x86_64 
#yum –y remove docker-common.x86_64 

# rm -rf /var/lib/docker 

# rm -rf /var/lib/docker 
# 
```
```
 yum install docker -y
```