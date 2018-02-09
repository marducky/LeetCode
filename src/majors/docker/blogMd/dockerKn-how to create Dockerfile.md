#docker
## Dockerfile
``` 
[root@k8s-node-1 dockerKn]# wget http://nginx.org/download/nginx-1.12.2.tar.gz
--2018-02-09 09:54:45--  http://nginx.org/download/nginx-1.12.2.tar.gz
Resolving nginx.org (nginx.org)... 95.211.80.227, 206.251.255.63, 2001:1af8:4060:a004:21::e3, ...
Connecting to nginx.org (nginx.org)|95.211.80.227|:80... connected.
HTTP request sent, awaiting response... 200 OK
Length: 981687 (959K) [application/octet-stream]
Saving to: ‘nginx-1.12.2.tar.gz’

100%[==============================================================================================================================================================================================>] 981,687     22.1KB/s   in 29s

2018-02-09 09:55:16 (32.7 KB/s) - ‘nginx-1.12.2.tar.gz’ saved [981687/981687]

[root@k8s-node-1 dockerKn]# ls
Dockerfile  Dockerfile1  nginx-1.12.2.tar.gz
[root@k8s-node-1 dockerKn]# ls
Dockerfile  Dockerfile1  nginx-1.12.2.tar.gz
[root@k8s-node-1 dockerKn]# ls
Dockerfile  Dockerfile1  nginx-1.12.2.tar.gz
[root@k8s-node-1 dockerKn]# vi Dockerfile
[root@k8s-node-1 dockerKn]# vi Dockerfile
[root@k8s-node-1 dockerKn]# cat Dockerfile
FROM centos:6.7
MAINTAINER janus "neng.qi@nuance.com"
ADD nginx-1.12.2.tar.gz /usr/local/src
RUN yum install -y gcc gcc-c++ glibc make autoconf openssl openssl-devel
RUN yum install -y libxslt-devel -y gd gd-devel GeoIP GeoIP-devel pcre pcre-devel
RUN useradd -M -s /sbin/nologin nginx
WORKDIR /usr/local/src/nginx-1.12.2
RUN ./configure --user=nginx --group=nginx --prefix=/usr/local/nginx --with-file-aio --with-http_ssl_module --with-http_realip_module --with-http_addition_module --with-http_xslt_module --with-http_image_filter_module --with-http_geoip_module --with-http_sub_module --with-http_dav_module --with-http_flv_module --with-http_mp4_module --with-http_gunzip_module --with-http_gzip_static_module --with-http_auth_request_module --with-http_random_index_module --with-http_secure_link_module --with-http_degradation_module --with-http_stub_status_module && make && make install
EXPOSE 80
[root@k8s-node-1 dockerKn]#

```
``` 
# base image
FROM centos

# MAINTAINER
MAINTAINER json_hc@163.com

# put nginx-1.12.2.tar.gz into /usr/local/src and unpack nginx
ADD nginx-1.12.2.tar.gz /usr/local/src

# running required command
RUN yum install -y gcc gcc-c++ glibc make autoconf openssl openssl-devel 
RUN yum install -y libxslt-devel -y gd gd-devel GeoIP GeoIP-devel pcre pcre-devel
RUN useradd -M -s /sbin/nologin nginx

# change dir to /usr/local/src/nginx-1.12.2
WORKDIR /usr/local/src/nginx-1.12.2

# execute command to compile nginx
RUN ./configure --user=nginx --group=nginx --prefix=/usr/local/nginx --with-file-aio --with-http_ssl_module --with-http_realip_module --with-http_addition_module --with-http_xslt_module --with-http_image_filter_module --with-http_geoip_module --with-http_sub_module --with-http_dav_module --with-http_flv_module --with-http_mp4_module --with-http_gunzip_module --with-http_gzip_static_module --with-http_auth_request_module --with-http_random_index_module --with-http_secure_link_module --with-http_degradation_module --with-http_stub_status_module && make && make install

EXPOSE 80
```
