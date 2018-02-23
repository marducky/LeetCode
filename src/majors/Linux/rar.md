``` 
yum install lrzsz 
mkdir -p  /home/oldboy/tools
cd /home/oldboy/tools
wget http://www.rarlab.com/rar/rarlinux-3.8.0.tar.gz
tar zxvf rarlinux-3.8.0.tar.gz
cd rar
make
make install 
rar a etc.rar /etc
rar x etc.rar 
unrar -e etc.tar
```
``` 
  279  wget http://www.rarsoft.com/rar/rarlinux-x64-5.4.0.tar.gz
  280  ls
  281  tar -zxvf rarlinux-x64-5.4.0.tar.gz
  282  ls
  283  cd rar
  284  make
  285  make install
```