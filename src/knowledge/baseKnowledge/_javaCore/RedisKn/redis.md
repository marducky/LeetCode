###Redis
####use
```
redis-server.exe redis.windows.conf

```

``` 
G:\info\NLPS_Code_Repos\git\LeetCode\src\knowledge\baseKnowledge\_javaCore\RedisKn\RedisX64>redis-cli.exe -h 127.0.0.1 -p 6379
127.0.0.1:6379>
127.0.0.1:6379> set myKey abc
OK
127.0.0.1:6379> get myKey
"abc"
127.0.0.1:6379>

```
####conf
``` 
G:\info\NLPS_Code_Repos\git\LeetCode\src\knowledge\baseKnowledge\_javaCore\RedisKn\RedisX64>redis 127.0.0.1:6379> CONFIG GET CONFIG_SETTING_NAME
'redis' is not recognized as an internal or external command,
operable program or batch file.

G:\info\NLPS_Code_Repos\git\LeetCode\src\knowledge\baseKnowledge\_javaCore\RedisKn\RedisX64>redis-cli.exe -h 127.0.0.1 -p 6379
127.0.0.1:6379> CONFIG GET CONFIG_SETTING_NAME
(empty list or set)
127.0.0.1:6379> CONFIG GET loglevel
1) "loglevel"
2) "notice"
127.0.0.1:6379> CONFIG GET *

```
``` 
参数说明
redis.conf 配置项说明如下：
1. Redis默认不是以守护进程的方式运行，可以通过该配置项修改，使用yes启用守护进程
    daemonize no
2. 当Redis以守护进程方式运行时，Redis默认会把pid写入/var/run/redis.pid文件，可以通过pidfile指定
    pidfile /var/run/redis.pid
3. 指定Redis监听端口，默认端口为6379，作者在自己的一篇博文中解释了为什么选用6379作为默认端口，因为6379在手机按键上MERZ对应的号码，而MERZ取自意大利歌女Alessia Merz的名字
    port 6379
4. 绑定的主机地址
    bind 127.0.0.1
5.当 客户端闲置多长时间后关闭连接，如果指定为0，表示关闭该功能
    timeout 300
6. 指定日志记录级别，Redis总共支持四个级别：debug、verbose、notice、warning，默认为verbose
    loglevel verbose
7. 日志记录方式，默认为标准输出，如果配置Redis为守护进程方式运行，而这里又配置为日志记录方式为标准输出，则日志将会发送给/dev/null
    logfile stdout
8. 设置数据库的数量，默认数据库为0，可以使用SELECT <dbid>命令在连接上指定数据库id
    databases 16
9. 指定在多长时间内，有多少次更新操作，就将数据同步到数据文件，可以多个条件配合
    save <seconds> <changes>
    Redis默认配置文件中提供了三个条件：
    save 900 1
    save 300 10
    save 60 10000
    分别表示900秒（15分钟）内有1个更改，300秒（5分钟）内有10个更改以及60秒内有10000个更改。
 
10. 指定存储至本地数据库时是否压缩数据，默认为yes，Redis采用LZF压缩，如果为了节省CPU时间，可以关闭该选项，但会导致数据库文件变的巨大
    rdbcompression yes
11. 指定本地数据库文件名，默认值为dump.rdb
    dbfilename dump.rdb
12. 指定本地数据库存放目录
    dir ./
13. 设置当本机为slav服务时，设置master服务的IP地址及端口，在Redis启动时，它会自动从master进行数据同步
    slaveof <masterip> <masterport>
14. 当master服务设置了密码保护时，slav服务连接master的密码
    masterauth <master-password>
15. 设置Redis连接密码，如果配置了连接密码，客户端在连接Redis时需要通过AUTH <password>命令提供密码，默认关闭
    requirepass foobared
16. 设置同一时间最大客户端连接数，默认无限制，Redis可以同时打开的客户端连接数为Redis进程可以打开的最大文件描述符数，如果设置 maxclients 0，表示不作限制。当客户端连接数到达限制时，Redis会关闭新的连接并向客户端返回max number of clients reached错误信息
    maxclients 128
17. 指定Redis最大内存限制，Redis在启动时会把数据加载到内存中，达到最大内存后，Redis会先尝试清除已到期或即将到期的Key，当此方法处理 后，仍然到达最大内存设置，将无法再进行写入操作，但仍然可以进行读取操作。Redis新的vm机制，会把Key存放内存，Value会存放在swap区
    maxmemory <bytes>
18. 指定是否在每次更新操作后进行日志记录，Redis在默认情况下是异步的把数据写入磁盘，如果不开启，可能会在断电时导致一段时间内的数据丢失。因为 redis本身同步数据文件是按上面save条件来同步的，所以有的数据会在一段时间内只存在于内存中。默认为no
    appendonly no
19. 指定更新日志文件名，默认为appendonly.aof
     appendfilename appendonly.aof
20. 指定更新日志条件，共有3个可选值： 
    no：表示等操作系统进行数据缓存同步到磁盘（快） 
    always：表示每次更新操作后手动调用fsync()将数据写到磁盘（慢，安全） 
    everysec：表示每秒同步一次（折衷，默认值）
    appendfsync everysec
 
21. 指定是否启用虚拟内存机制，默认值为no，简单的介绍一下，VM机制将数据分页存放，由Redis将访问量较少的页即冷数据swap到磁盘上，访问多的页面由磁盘自动换出到内存中（在后面的文章我会仔细分析Redis的VM机制）
     vm-enabled no
22. 虚拟内存文件路径，默认值为/tmp/redis.swap，不可多个Redis实例共享
     vm-swap-file /tmp/redis.swap
23. 将所有大于vm-max-memory的数据存入虚拟内存,无论vm-max-memory设置多小,所有索引数据都是内存存储的(Redis的索引数据 就是keys),也就是说,当vm-max-memory设置为0的时候,其实是所有value都存在于磁盘。默认值为0
     vm-max-memory 0
24. Redis swap文件分成了很多的page，一个对象可以保存在多个page上面，但一个page上不能被多个对象共享，vm-page-size是要根据存储的 数据大小来设定的，作者建议如果存储很多小对象，page大小最好设置为32或者64bytes；如果存储很大大对象，则可以使用更大的page，如果不 确定，就使用默认值
     vm-page-size 32
25. 设置swap文件中的page数量，由于页表（一种表示页面空闲或使用的bitmap）是在放在内存中的，，在磁盘上每8个pages将消耗1byte的内存。
     vm-pages 134217728
26. 设置访问swap文件的线程数,最好不要超过机器的核数,如果设置为0,那么所有对swap文件的操作都是串行的，可能会造成比较长时间的延迟。默认值为4
     vm-max-threads 4
27. 设置在向客户端应答时，是否把较小的包合并为一个包发送，默认为开启
    glueoutputbuf yes
28. 指定在超过一定的数量或者最大的元素超过某一临界值时，采用一种特殊的哈希算法
    hash-max-zipmap-entries 64
    hash-max-zipmap-value 512
29. 指定是否激活重置哈希，默认为开启（后面在介绍Redis的哈希算法时具体介绍）
    activerehashing yes
30. 指定包含其它的配置文件，可以在同一主机上多个Redis实例之间使用同一份配置文件，而同时各个实例又拥有自己的特定配置文件
    include /path/to/local.conf
```
>[Redis 的 5 个常见应用场景](https://www.tuicool.com/articles/UVnyaqU)
``` 
前言

Redis 是一个强大的内存型存储，具有丰富的数据结构，使其可以应用于很多方面，包括作为数据库、缓存、消息队列等等。

如果你的印象中Redis只是一个 key-value 存储，那就错过了Redis很多强大的功能，下面就是实际应用场景中5个最普遍的案例。

1. 全页面缓存

如果你使用的是服务器端内容渲染，你又不想为每个请求重新渲染每个页面，就可以使用 Redis 把常被请求的内容缓存起来，能够大大的降低页面请求的延迟，已经有很多框架用Redis来缓存页面，这就是页面静态化的一种方式。
// Set the page that will last 1 minute
SET key "<html>...</html>" EX 60

// Get the page
GET key
2. 排行榜

Redis 基于内存，可以非常快速高效的处理增加和减少的操作，相比于使用 SQL 请求的处理方式，性能的提升是非常巨大的。

Redis 的有序集合可以轻松实现“从一个大型列表中取得排名最高的N个元素”，毫秒级，而且非常简单。
// Add an item to the sorted set
ZADD sortedSet 1 "one"

// Get all items from the sorted set
ZRANGE sortedSet 0 -1

// Get all items from the sorted set with their score
ZRANGE sortedSet 0 -1 WITHSCORES
3. Session 存储

这可能是应用最广的点了，相比较于类似 memcache 的 session 存储，Redis 具有缓存数据持久化的能力，当缓存因出现问题而重启后，之前的缓存数据还在那儿，这个就比较实用，避免了因为session突然消失带来的用户体验问题。

// Set session that will last 1 minute
SET randomHash "{userId}" EX 60

// Get userId
GET randomHash
4. 队列

例如 email 的发送队列、等待被其他应用消费的数据队列，Redis 可以轻松而自然的创建出一个高效的队列。

// Add a Message
HSET messages <id> <message>
ZADD due <due_timestamp> <id>

// Recieving Message
ZRANGEBYSCORE due -inf <current_timestamp> LIMIT 0 1
HGET messages <message_id>

// Delete  Message
ZREM due <message_id>
HDEL messages <message_id>
5. 发布/订阅

pub/sub   是 Redis 内置的一个非常强大的特性，例如可以创建一个实时的聊天系统、社交网络中的通知触发器等等。

// Add a message to a channel
PUBLISH channel message

// Recieve messages from a channel
SUBSCRIBE channel
```