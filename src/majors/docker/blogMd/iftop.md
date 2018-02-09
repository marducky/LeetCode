#iftop
### **install**
```

yum install -y gcc flex byacc libpcap ncurses ncurses-devel libpcap-devel tcpdump
cd /usr/local/src
wget http://www.ex-parrot.com/pdw/iftop/download/iftop-0.17.tar.gz
tar zxvf iftop-0.17.tar.gz
cd iftop-0.17
./configure --prefix=/usr/local/iftop
make
make install
chmod 700 /usr/local/iftop/sbin/iftop
```
### **run**
```
/usr/local/iftop/sbin/iftop
/usr/local/iftop/sbin/iftop -i eth0 -n 就可以看到eth0网卡的流量状况


#阿里云默认的iftop，执行查看的是第一个，即内网的IP，以下二个命令效果相同
iftop
iftop -i eth0
#如果查看外网带宽，则需要选择外网配置的eth，默认命令
iftop -i eth1
```

### **command**
```
TX：发送流量
RX：接收流量
TOTAL：总流量
cumm：运行iftop以来的总流量
peak：峰值流量
rates：分别表示过去 2s 10s 40s时间内网卡总的平均流量
iftop常用参数摘录
-i设定监测的网卡，如：# iftop -i eth1
-B 以bytes为单位显示流量(默认是bits)，如：# iftop -B
-n使host信息默认直接都显示IP，如：# iftop -n
-N使端口信息默认直接都显示端口号，如: # iftop -N
-F显示特定网段的进出流量，如# iftop -F 192.168.1.0/24或# iftop -F 192.168.1.0/255.255.255.0
-h（display this message），帮助，显示参数信息
-p使用这个参数后，中间的列表显示的本地主机信息，出现了本机以外的IP信息;
-b使流量图形条默认就显示;
-f过滤计算包;
-P使host信息及端口信息默认就都显示;
-m设置界面最上边的刻度的最大值，刻度分五个大段显示，例：# iftop -m 100M
进入iftop画面后的一些操作命令(注意大小写)
按n切换显示本机的IP或主机名;
按s切换是否显示本机的host信息;
按d切换是否显示远端目标主机的host信息;
按t切换显示格式为2行/1行/只显示发送流量/只显示接收流量;
按N切换显示端口号或端口服务名称;
按S切换是否显示本机的端口信息;
按D切换是否显示远端目标主机的端口信息;
按p切换是否显示端口信息;
按P切换暂停/继续显示;
按b切换是否显示平均流量图形条;
按B切换计算2秒或10秒或40秒内的平均流量;
按T切换是否显示每个连接的总流量;
按l打开屏幕过滤功能，输入要过滤的字符，比如ip,按回车后，屏幕就只显示这个IP相关的流量信息;
按L切换显示画面上边的刻度;刻度不同，流量图形条会有变化;
按j或按k可以向上或向下滚动屏幕显示的连接记录;
按1或2或3可以根据右侧显示的三列流量数据进行排序;
按<根据左边的本机名或IP排序;
按>根据远端目标主机的主机名或IP排序;
按o切换是否固定只显示当前的连接;
按q退出监控 
```