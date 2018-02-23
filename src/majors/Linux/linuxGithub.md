###
``` 
ssh-keygen -t rsa -C "你自己的github对应的邮箱地址"
```
```
root@k8s-node-1:~/.ssh# ssh-keygen -t rsa -C "qihuaneng@163.com"
Generating public/private rsa key pair.
Enter file in which to save the key (/root/.ssh/id_rsa):
Enter passphrase (empty for no passphrase):
Enter same passphrase again:
Your identification has been saved in /root/.ssh/id_rsa.
Your public key has been saved in /root/.ssh/id_rsa.pub.
The key fingerprint is:
fd:50:75:3b:af:4d:3b:18:7c:44:5e:aa:d7:3d:be:d8 qihuaneng@163.com
The key's randomart image is:
+--[ RSA 2048]----+
|              ..o|
|             .ooo|
|            . .= |
|         . .....+|
|        S o .o.o=|
|           o .=+o|
|            ...+.|
|              o o|
|             . E |
+-----------------+
root@k8s-node-1:~/.ssh# ls
id_rsa  id_rsa.pub
root@k8s-node-1:~/.ssh#

```