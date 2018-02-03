# 1.服务背景

增加，查询，删除，延迟闹钟的语义服务。

# 2.槽位

| Slot key | Description | Application | Example |
| --- | --- | --- | --- |
| specific\_time | 具体时刻 | 用户设置，删除，查询闹钟等 | 9点20分 |
| specific\_date | 具体日期 | 用户设置，删除，查询闹钟等 | 2月20日 |
| periodic\_time | 周期时刻 | 用户设置，删除，查询闹钟等 | 每天10点 |
| periodic\_date | 周期日期 | 用户设置，删除，查询闹钟等 | 每周五下午 |
| event\_name | 事件名称 | 用户设置提醒时 | 做作业 |
| duration | 时段 | 延迟闹钟 | 10分钟 |

# 3.意图

## 3.1 SetClock\_设置闹钟

设置闹钟前缀1：\[你\|\]\[请在\|估计\|到\|在\|\]\[过\|\]

设置闹钟前缀2： \[我\|\]\[需要\|想要\|\]\[现在\|马上\|立刻\|\]\[就\|\]\[设定\|设置\|定\|订\|上\|开启\|打\|设\|打上\]\[一\|\]\[个\|下\|\]

设置闹钟后缀1：\[别忘了\|就要\|\]\[叫醒\|喊醒\|叫\|喊\]\[我\|\]

设置闹钟后缀2： \[的\|\]\[闹钟\|闹铃\|叫醒\]\[服务\|\]

| **Support\_semantic** | **Example** |
| --- | --- |
| 设置闹钟前缀1 +&lt;specific\_time&gt;+ 设置闹钟后缀1 | 请在9点叫醒我 |
| 设置闹钟前缀1 +&lt;periodic\_time&gt;+ 设置闹钟后缀1 | 请在每周五8点叫我 |
| 设置闹钟前缀2 +&lt;specific\_time&gt;+ 设置闹钟后缀2 | 设置9点的闹钟 |
| 设置闹钟前缀2 +&lt;periodic\_time&gt;+ 设置闹钟后缀2 | 设置每周一8点的闹钟 |

## 3.2 SetAlarm\_设置提醒

设置提醒前缀1：\[你\|\]\[请在\|估计\|到\|在\|\]\[过\|\]

设置提醒前缀2：\[提醒\|叫\|喊\|叫醒\]\[我\|\]\[过\|\]

设置提醒后缀1：\[别忘了\|就要\|\]\[叫醒\|喊醒\|叫\|喊\]\[我\|\]

| **Support\_semantic** | **Example** |
| --- | --- |
| 设置提醒前缀1 +&lt;specific\_time&gt;+ 设置提醒后缀1+&lt;event\_name&gt; | 请在早上8点叫我读书 |
| 设置提醒前缀1 +&lt;periodic\_time&gt;+ 设置提醒后缀1+&lt;event\_name&gt; | 请在每周五9点叫我做作业 |
| 设置提醒前缀1 +&lt;specific\_time&gt; | 别忘了6点叫我活动 |
| 设置提醒前缀1  +&lt;periodic\_time&gt; | 每周一8点提醒我做饭 |

## 3.3 GetClock\_查询闹钟

查询闹钟前缀1：\[我想\|我要\|\]\[查\|查询\|查寻\|查看\|播报\|播\|报\|说\]\[一\|\]\[下\|\]

查询闹钟后缀2：\[设定\|设置了\|开启\|设置\|有\|订\|的\]\[的\|\]\[几个\|多少\]\[闹铃\|闹钟\|叫醒\|提醒\]\[服务\|\]

| **Support\_semantic** | **Example** |
| --- | --- |
| 查询闹钟前缀1+&lt;specific\_date&gt;+ 查询闹钟后缀2 | 查询明天有几个闹钟 |
| 查询闹钟前缀1+&lt;periodic\_date&gt; 查询闹钟后缀2 | 查询每周三有多少提醒服务 |

## 3.4 DeleteClock\_删除闹钟

删除闹钟前缀1：\[删除\|取消\|关闭\|停止\]

删除闹钟后缀1：\[的\]\[闹铃\|闹钟\|提醒\|叫醒\]\[服务\|\]

| **Support\_semantic** | **Example** |
| --- | --- |
| 删除闹钟前缀1+&lt;specific\_date&gt;+ 删除闹钟后缀2 | 删除明天的闹钟 |
| 删除闹钟前缀1+&lt;specific\_time&gt;+ 删除闹钟后缀2 | 删除后天9点的闹钟 |
| 删除闹钟前缀1+&lt;periodic\_date&gt;+ 删除闹钟后缀2 | 删除每周六的闹钟 |
| 删除闹钟前缀1+&lt;periodic\_time&gt;+ 删除闹钟后缀2 | 关闭每周五晚上10点的提醒 |

## 3.5 DelayClock\_延迟闹钟

延迟闹钟前缀1：\[请在\|估计\|\]\[过\|\]

延迟闹钟后缀1：\[别忘了\|就要\|\]\[再\]\[振铃\|响铃\|叫我\]

| **Support\_semantic** | **Example** |
| --- | --- |
| 延迟闹钟前缀1+&lt;duration&gt;+延迟闹钟后缀1 | 请在过10分钟再响铃 |
| 延迟闹钟前缀1+&lt;specific\_time&gt;+延迟闹钟后缀1 | 请在9点30再响铃 |

# 4.返回结果

返回结果说明：

operation： set为新增，list为列表，delete为删除，delay为停止当前并新增新闹钟

repeat\_mode：提醒模式，为0表示特定时刻闹钟，非0表示重复闹钟，按日提醒格式从左到右为

（预留 周一 周二 周三 周四 周五 周六 周日），例如00100000代表的数字是32，代表每周二

## 4.1 SetClock\_设置闹钟\(SetAlarm\_设置提醒\)

| **Field name** | **Sub field** | **Field value** | **Field example** |
| --- | --- | --- | --- |
| hint |  | 提示语 | 已为你设定2017-07-19 22:00的闹钟 |
| data |  |  |  |
|  | alarm\_time | 闹钟时间 | 2017-07-19 22:00:00 |
|  | content | 提醒事件 | 做游戏 |
|  | id | 闹钟id | 423 |
|  | operation | 操作 | set |
|  | repeat\_mode | 重复类型 | 0 |

```
 "result": {
        "hint": "好的主人，已为你设定2017-07-19 22:00的闹钟。",
        "data": {
            "alarm_time": "2017-07-19 22:00:00",
            "content": "",
            "id": 423,
            "operation": "set",
            "repeat_mode": 0
        }
    }
```

## 4.2 GetClock\_查询闹钟

| **Field name** | **Sub field** | **Field value** | **Field example** |
| --- | --- | --- | --- |
| hint |  | 提示语 | 你有以下这2个闹钟 |
| data |  |  |  |
|  | alarm\_time | 闹钟时间 | 2017-07-19 22:00:00 |
|  | content | 提醒事件 | 做游戏 |
|  | id | 闹钟id | 423 |
|  | operation | 操作 | list |
|  | repeat\_mode | 重复类型 | 0 |

```
 "result": {
        "hint": "你有以下这2个闹钟",
        "data": [
            {
                "alarm_time": "2017-07-19 21:00:00",
                "content": "",
                "id": 4205,
                "operation": "list",
                "repeat_mode": 0
            },
            {
                "alarm_time": "2017-07-19 22:00:00",
                "content": "",
                "id": 423,
                "operation": "list",
                "repeat_mode": 0
            }
        ]
    }
```

## 4.3 DeleteClock\_删除闹钟

| **Field name** | **Sub field** | **Field value** | **Field example** |
| --- | --- | --- | --- |
| hint |  | 提示语 | 已为您删除下午9点的1条闹钟记录 |
| data |  |  |  |
|  | alarm\_time | 闹钟时间 | 2017-07-19 21:00:00 |
|  | content | 提醒事件 | 做游戏 |
|  | id | 闹钟id | 423 |
|  | operation | 操作 | delete |
|  | repeat\_mode | 重复类型 | 0 |

```
 "result": {
        "hint": "已为您删除下午9点的1条闹钟记录",
        "data": [
            {
                "alarm_time": "2017-07-19 21:00:00",
                "content": "",
                "id": 423,
                "operation": "delete",
                "repeat_mode": 0
            }
        ]
    }
```

## 4.4 DelayClock\_延迟闹钟

| **Field name** | **Sub field** | **Field value** | **Field example** |
| --- | --- | --- | --- |
| hint |  | 提示语 | 我会在10分钟后在提醒你 |
| data |  |  |  |
|  | alarm\_time | 闹钟时间 | 2017-07-19 21:10:00 |
|  | content | 提醒事件 | 做游戏 |
|  | id | 闹钟id | 423 |
|  | operation | 操作 | delay |
|  | repeat\_mode | 重复类型 | 0 |

```
"result": {
    "hint": "我会在10分钟后再提醒你",        
    "data": [            
       {
                "alarm_time": "2017-07-19 21:10:00",
                "content": "",
                "id": 423,
                "operation": "delay",
                "repeat_mode": 0
            }
        ]
    }
```

# 5.服务接入

服务地址：[http:\/\/api.ros.ai\/bot\/v1\/query\/](http://api.ros.ai/bot/v1/query/)


请求方式：post


参数示意：

```
{
 "agentId": "83jpeekghlsktpwZWY0YUF5T0d",
 "token": "02e4297de964ec34354sdwwr",
 "clientId": "1015000000000099",
 "contexts": [
 ],
 "query": "设置11点的闹钟",
 "sessionId": "845551266544522"
}
```

