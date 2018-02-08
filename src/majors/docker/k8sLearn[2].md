#Learn k8s for stubby work 
##[2 run helloword]
## Resource
>kubectl get nodes
<br>

>kubectl describe k8s-node-1

``` 
Name:                   k8s-node-1
Role:
Labels:                 beta.kubernetes.io/arch=amd64
                        beta.kubernetes.io/os=linux
                        kubernetes.io/hostname=k8s-node-1
Taints:                 <none>
CreationTimestamp:      Wed, 07 Feb 2018 12:02:22 -0500
Phase:
Conditions:
  Type                  Status  LastHeartbeatTime                       LastTransitionTime                      Reason                          Message
  ----                  ------  -----------------                       ------------------                      ------                          -------
  OutOfDisk             False   Thu, 08 Feb 2018 06:50:28 -0500         Thu, 08 Feb 2018 06:28:25 -0500         KubeletHasSufficientDisk        kubelet has sufficient disk space available
  MemoryPressure        False   Thu, 08 Feb 2018 06:50:28 -0500         Wed, 07 Feb 2018 12:02:32 -0500         KubeletHasSufficientMemory      kubelet has sufficient memory available
  DiskPressure          False   Thu, 08 Feb 2018 06:50:28 -0500         Wed, 07 Feb 2018 12:02:32 -0500         KubeletHasNoDiskPressure        kubelet has no disk pressure
  Ready                 True    Thu, 08 Feb 2018 06:50:28 -0500         Thu, 08 Feb 2018 06:28:36 -0500         KubeletReady                    kubelet is posting ready status
Addresses:              192.168.117.130,192.168.117.130,k8s-node-1
Capacity:
 alpha.kubernetes.io/nvidia-gpu:        0
 cpu:                                   1
 memory:                                483856Ki
 pods:                                  110
Allocatable:
 alpha.kubernetes.io/nvidia-gpu:        0
 cpu:                                   1
 memory:                                483856Ki
 pods:                                  110
System Info:
 Machine ID:                    5c4ff1bf35af4e7a90666d3c2be2b386
 System UUID:                   CFEC4D56-1D1F-E4B5-9E10-3523018345D3
 Boot ID:                       fed910d4-8983-49c5-bd78-1d6c0491e1cc
 Kernel Version:                3.10.0-514.el7.x86_64
 OS Image:                      CentOS Linux 7 (Core)
 Operating System:              linux
 Architecture:                  amd64
 Container Runtime Version:     docker://1.12.6
 Kubelet Version:               v1.5.2
 Kube-Proxy Version:            v1.5.2
ExternalID:                     k8s-node-1
Non-terminated Pods:            (2 in total)
  Namespace                     Name                                    CPU Requests    CPU Limits      Memory Requests Memory Limits
  ---------                     ----                                    ------------    ----------      --------------- -------------
  default                       my-nginx-379829228-33wq5                0 (0%)          0 (0%)          0 (0%)          0 (0%)
  default                       my-nginx-379829228-5zsbt                0 (0%)          0 (0%)          0 (0%)          0 (0%)
Allocated resources:
  (Total limits may be over 100 percent, i.e., overcommitted.
  CPU Requests  CPU Limits      Memory Requests Memory Limits
  ------------  ----------      --------------- -------------
  0 (0%)        0 (0%)          0 (0%)          0 (0%)
[root@k8s-master /]#
```\
```
create the yaml for mysql-rc
```
[root@k8s-master k8sInstance]# kubectl get pods
NAME                       READY     STATUS              RESTARTS   AGE
my-nginx-379829228-33wq5   0/1       ContainerCreating   0          19h
my-nginx-379829228-5zsbt   0/1       ContainerCreating   0          19h
mysql-vbm09                0/1       ContainerCreating   0          8m

```
>kubectl describe pod mysql 
```
Error syncing pod, skipping: failed to "StartContainer" for "POD" with ErrImagePull: "image pull failed for registry.access.redhat.com/rhel7/pod-infrastructure:latest, this may be because there are no credentials on this request.  details: (open /etc/docker/certs.d/registry.access.redhat.com/redhat-ca.crt: no such file or directory)"
```

manually
```
yum install *rhsm*
docker pull registry.access.redhat.com/rhel7/pod-infrastructure:latest

```

