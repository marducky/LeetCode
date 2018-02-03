# 1. 服务简介

为用户提供成语接龙服务服务，认定发音相同的字为同一个字。

# 2.槽位

| **Slot\_Key** | **Description** | **Example** |
| --- | --- | --- |
| idiom | 成语 | 厚德载物 |
| any | 用户的输入\(不是成语\) |  |

# 3.意图

Play意图、Repeat意图和Replay的返回字段相同，在此统一说明

| **result** |  | **value** | **type** |
| --- | --- | --- | --- |
| hint |  | 机器人说的成语 | string |
| data | idiomToMatch | 机器人说的成语 | string |

\/Play

| **Slot Semantic Signatures** | **Example** |
| --- | --- |
|  | 成语接龙 |
| &lt;idiom&gt; | 厚德载物 |

返回样例

```
    "results": [
        {
            "hint": "好的，成语接龙马上开始喽！我先说一个，七情六欲",
            "data": {
                "idiomToMatch": "七情六欲"
            }
        }
    ]
```

用户接“欲壑难填”

```
    "results": [
        {
            "hint": "天大地大",
            "data": {
                "idiomToMatch": "天大地大"
            }
        }
    ]
```

\/Repeat

| **Slot Semantic Signatures** | **Example** |
| --- | --- |
|  | 再说一遍 |

返回样例

```
    "results": [
        {
            "hint": "天大地大",
            "data": {
                "idiomToMatch": "天大地大"
            }
        }
    ]
```

\/Replay

| **Slot Semantic Signatures** | **Example** |
| --- | --- |
|  | 重新开始 |

返回样例

```
    "results": [
        {
            "hint": "好的，成语接龙马上开始喽！我先说一个，阳奉阴违",
            "data": {
                "idiomToMatch": "阳奉阴违"
            }
        }
    ]
```

\/GiveTips

| **Slot Semantic Signatures** | **Example** |
| --- | --- |
|  | 给点儿提示 |

返回字段

| **result** |  | **value** | **type** |
| --- | --- | --- | --- |
| hint |  | 机器人给用户的二字提示 | string |
| data | idiomToMatct | 用户需要接上的成语 | string |

返回样例

```
    "results": [
        {
            "hint": "始终",
            "data": {
                "idiomToMatch": "有识之士"
            }
        }
    ]
```

\/GiveAnswer

| **Slot Semantic Signatures** | **Example** |
| --- | --- |
|  | 告诉我答案吧 |

返回字段

| **result** | **value** | **type** |
| --- | --- | --- |
| hint | 我告诉你吧，始终如一\(可以和机器人给出的成语匹配的成语\)，你输啦！不如咱们重新开始吧 | string |

返回样例

```
    "results": [
        {
            "hint": "我告诉你吧，始终如一，你输啦！不如咱们重新开始吧；",
        }
    ]
```

\*\*\*由于Pause意图和Save意图返回字段相同，再次统一说明

返回字段

| **result** | **value** | **type** |
| --- | --- | --- |
| hint | 当然啦，下次跟我说继续成语接龙就可以继续玩啦、已暂停，以后如果想继续你可以对我说：继续成语接龙 | string |

\/Pause

| **Slot Semantic Signatures** | **Example** |
| --- | --- |
|  | 暂停 |

返回样例

```
    "result": {
        "hint": "已暂停，以后如果想继续你可以对我说：继续成语接龙。"
    }
```

\/Save

| **Slot Semantic Signatures** | **Example** |
| --- | --- |
|  | 保存 |

返回样例

```
    "results": [
        {
            "hint": "当然啦，下次跟我说继续成语接龙就可以继续玩啦",
        }
    ]
```

\/Exit

| **Slot Semantic Signatures** | **Example** |
| --- | --- |
|  | 布丁布丁、我不想玩了 |

返回字段

| **result** | **value** | **type** |
| --- | --- | --- |
| hint | 好的 | string |

返回样例 

```
    "results": [
        {
            "hint": "好的",
        }
    ]
```
