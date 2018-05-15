# 小程序后台api接口文档

### 请求地址

环境  |  地址
----  | ----
开发环境  | http://localhost:8000
测试环境  | http://api2.woohelps.com
生产环境  | https://api.woohelps.com

### 返回码errcode说明

接口请求出错时会返回错误码等信息，JSON数据示例如下：

    {"errcode": 101, "errmsg": "参数错误"}
    
以下是一些通用的返回码

返回码   |   说明
-------- | --------
-1       | 系统繁忙，请稍后再试
0        | 请求成功
101      | 参数错误，请检查所需参数是否完整
102      | 无效的session
500      | 服务器错误，具体原因不详


**除接口1.1.1之外，其他所有接口调用都需要带上参数：Login-Session，这个参数在下文中接口的参数列表中是省略的，请调用的时候不要遗漏,添加到请求的header里面去，否则请求将返回403错误**

### 目录

	|-- 1 基础接口
		|-- 1.1 微信相关
            |-- 1.1.1 获取登陆session检查登陆session
            |-- 1.1.2 获取小程序码
            |-- 1.1.3 检查登陆session
            |-- 1.1.4 上传微信Form ID
        |-- 1.2 位置
            |-- 1.2.1 获取用户当前定位
            |-- 1.2.2 获取推荐城市
            |-- 1.2.3 获取精选内容
            |-- 1.2.4 查询城市
            |-- 1.2.5 获取热门城市
            |-- 1.2.6 获取城市信息接口
            |-- 1.2.7 查询国家下的城市列表
            |-- 1.2.8 获取国家列表
        |-- 1.3 搜索
            |-- 1.3.1 获取热门搜索
            |-- 1.3.2 分类搜索接口
        |-- 1.4 留言
            |-- 1.4.1 获取留言信息
            |-- 1.4.2 提交留言
        |-- 1.5 验证码
            |-- 1.5.1 发送邮箱验证码
            |-- 1.5.2 发送短信验证码
            |-- 1.5.3 验证验证码是否有效
        |-- 1.6 用户账号
            |-- 1.6.1 同步用户信息到后台
            |-- 1.6.2 获取用户信息
            |-- 1.6.3 修改用户信息接口
        |-- 1.7 广告
            |-- 1.7.1 获取广告列表
        |-- 1.8 上传
            |-- 1.8.1 获取上传到腾讯云COS的sign
        |-- 1.9 辅助
        	|-- 1.9.1 获取随机图片
        	|-- 1.9.2 获取热门标签
			|-- 1.9.3 获取标签
	|-- 2 商品服务
        |-- 2.1 商品/服务展示、购买
            |-- 2.1.1 获取推荐店铺
            |-- 2.1.2 获取店铺商品/服务列表(分页、分类)
            |-- 2.1.3 获取当前店铺内的商品分类
            |-- 2.1.4 提交订单接口
            |-- 2.1.5 查看订单评论概况
            |-- 2.1.6 查看商品/服务评论
            |-- 2.1.7 获取顾客订单收货地址历史记录
            |-- 2.1.8 获取店铺详情
            |-- 2.1.9 获取商品/服务详情
            |-- 2.1.10 用户发布投票（点赞）
            |-- 2.1.11 用户发布点评
            |-- 2.1.12 获取用户点评列表
            |-- 2.1.13 获取用户点赞列表
            |-- 2.1.14 用户上传图片
            |-- 2.1.15 获得用户上传图片            
        |-- 2.2 客户订单管理
            |-- 2.2.1 客户获取自己的订单列表（分类、分页）
            |-- 2.2.2 客户评价订单
        |-- 2.3 店铺管理
            |-- 2.3.1 查询当前用户的店铺信息
            |-- 2.3.2 申请开店
            |-- 2.3.3 修改店铺申请资料
            |-- 2.3.4 商家获取自己的店铺列表
            |-- 2.3.5 商家获取自己店铺商品/服务列表
            |-- 2.3.6 添加新商品
            |-- 2.3.7 修改商品
            |-- 2.3.8 删除商品
            |-- 2.3.9 商家获取自己店铺商品/服务分类列表
            |-- 2.3.10 新增商品分类
            |-- 2.3.11 修改商品分类
            |-- 2.3.11-1 调换商品分类排序
            |-- 2.3.12 删除商品分类
            |-- 2.3.13 修改店铺信息
            |-- 2.3.14 商家获取顾客订单列表（分类、分页）
            |-- 2.3.15 商家确认收货
            |-- 2.3.16 商家取消订单
            |-- 2.3.17 商家发送订单信息到自己邮箱
            |-- 2.3.18 商家查看订单评价
            |-- 2.3.19 商家回复订单评价
            |-- 2.3.20 商家修改订单运费
        |-- 2.4 账户相关
            |-- 2.4.1 发送重置密码用的验证码
            |-- 2.4.2 重置商户登录密码
            |-- 2.4.3 商户使用Email登录
	|-- 3 活动及团购
		|-- 3.1 活动团购展示/报名
			|-- 3.1.1 获取某个时间范围内的活动列表
			|-- 3.1.2 获取某个时间范围内的团购列表
			|-- 3.1.3 报名活动
			|-- 3.1.4 取消活动报名
			|-- 3.1.5 获取活动详情
			|-- 3.1.6 报名团购
			|-- 3.1.7 获取团购详情
			|-- 3.1.8 取消团购报名
			|-- 3.1.9 获取用户在团购中的报名信息
			|-- 3.1.10 商户删除团购商品
		|-- 3.2 活动管理
			|-- 3.2.1 发布活动
			|-- 3.2.2 获取用户已发布的活动列表
			|-- 3.2.3 获取用户已报名的活动列表
			|-- 3.2.4 编辑活动内容
			|-- 3.2.5 发送活动报名信息到邮箱
		|-- 3.3 团购管理
			|-- 3.3.1 发布团购
			|-- 3.3.2 获取用户已发布的团购列表
			|-- 3.3.3 获取用户已报名的团购列表
			|-- 3.3.4 发送团购短信
			|-- 3.3.5 获取团购的报名信息
			|-- 3.3.6 取消团购活动
	|-- 4 文章
		|-- 4.1 文章查看
			|-- 4.1.1 分页获取当前服务店铺的文章列表
			|-- 4.1.2 获取文章详情
		|-- 4.2 文章管理
			|-- 4.2.1 添加新文章
			|-- 4.2.2 修改文章
			|-- 4.2.3 删除文章
			|-- 4.2.4 获取用户/服务商自己的文章列表
			|-- 4.2.5 将文章绑定到店铺
			|-- 4.2.6 移除店铺绑定的文章
	|-- 5 问答
		|-- 5.1 问答展示/回答
			|-- 5.1.1 发布新的问题
			|-- 5.1.2 获取问题列表（分页）
			|-- 5.1.3 获取问题的回答列表（分页）
			|-- 5.1.3-1 获取问题的回答详情
			|-- 5.1.4 获取问题详情
			|-- 5.1.5 关注/取关问题
			|-- 5.1.6 回答问题
			|-- 5.1.7 赞同/取消赞同答案
			|-- 5.1.8 反对/取消反对答案
		|-- 5.2 问答管理
			|-- 5.2.2 获取我发布的问题列表（分页）
			|-- 5.2.3 获取我参与的问题列表
			|-- 5.2.4 获取我关注的问题列表
	|-- 6 二手
		|-- 6.1 二手商品展示
			|-- 6.1.1 获取当前城市的二手商品（分页）
			|-- 6.1.2 获取二手商品详情
		|-- 6.2 二手商品管理
			|-- 6.2.1 发布二手商品
			|-- 6.2.2 修改二手商品信息
			|-- 6.2.3 删除该二手商品
			|-- 6.2.4 获取用户自己的二手商品（分页）
			|-- 6.2.5 刷新二手商品
    |-- 7 租房
		|-- 7.1 二手商品展示
			|-- 7.1.1 获取当前城市的二手商品（分页）
			|-- 7.1.2 获取二手商品详情
		|-- 7.2 二手商品管理
			|-- 7.2.1 发布二手商品
			|-- 7.2.2 修改二手商品信息
			|-- 7.2.3 删除该二手商品
			|-- 7.2.4 获取用户自己的二手商品（分页）
			|-- 7.2.5 刷新二手商品
	|-- 8 机器人相关
		|-- 8.1 机器人信息
			|-- 8.1.1 获取机器人信息
			|-- 8.1.2 列出所有机器人
			|-- 8.1.3 登录机器人
			|-- 8.1.4 删除机器人信息
			|-- 8.1.5 更新机器人信息
			|-- 8.1.6 获取机器人登录二维码
			|-- 8.1.7 检查机器人登录状态
			|-- 8.1.8 注销登录（停止机器人）
		|-- 8.2 群
			|-- 8.2.1 将机器人的群导入数据库
			|-- 8.2.2 更新群信息
			|-- 8.2.3 删除群
			|-- 8.2.4 按条件筛选群（分类，可选选项）
			|-- 8.2.5 获取单个群信息
		|-- 8.3 自动回复
			|-- 8.3.1 添加自动回复
			|-- 8.3.2 获取某条自动回复的信息
			|-- 8.3.3 列出机器人拥有的所有自动回复
			|-- 8.3.4 更新自动回复设置
			|-- 8.3.5 删除自动回复设置
    |-- 9 评比活动相关
		|-- 9.1 评比活动展示/报名
			|-- 9.1.1 获取评比活动详情
			|-- 9.1.2 报名评比活动
			|-- 9.1.3 取消评比活动报名
			|-- 9.1.4 评比活动报名信息
			|-- 9.1.5 对评比活动选手投票
			|-- 9.1.6 取消对评比活动选手的投票
			|-- 9.1.7 对评比活动选手评论
			|-- 9.1.8 对评比活动选手投票用户列表（需要分页）
			|-- 9.1.9 对评比活动选手评论列表（需要分页）
			|-- 9.1.10 获取评比活动报名详情


## 1 基础接口

### 1.1 微信相关

#### 1.1.1 获取登陆session		

#### 接口调用说明

	请求方式：GET
	请求uri：/api/applet/login/session/get

#### 请求参数说明

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
code  |   是     |   str    |   xxx       | 小程序调用wx.login()接口获得的登陆凭证
type  |   否     |   str    |   overseasbuy       | 当type为overseasbuy，将获得海外新团购的登陆session

#### 返回说明

正常情况下，会返回下述JSON数据：

	{
		"login_session": "xxx",
	}
	
错误返回说明：

返回码  |  说明
-----  |  -----
201    |  无效的code

#### 1.1.2 生成小程序码

#### 接口调用说明

	请求方式：GET
	请求uri: /api/applet/wx/qrcode/get
	
#### 请求参数说明

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
path  |  是  |  str  |  'pages/index?query=1'  |  小程序内路径，如果type='B',微信限制不超过32个字符, 可以不实用完整页面path,只要能定位即可，如果type为A、C，请使用完整path
width  |  否  |  int  |  430  |  二维码
type  |  是  |  str  |  'B'  |  生成的二维码类型，'A', 'B', 'C'三种，默认是B

#### 返回说明

	{ img_path: '/user/image/xxx.png' }


#### 1.1.3 检查登陆session		

#### 接口调用说明

	请求方式：GET
	请求uri：/api/applet/login/session/check

#### 请求参数说明

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
session  |   是     |   str    |   xxx       | 用户登录时返回的session key

#### 返回说明

正常情况下，会返回下述JSON数据：

	{'is_valid': False}  # True表示有效，False表示无效
	
错误返回说明：

返回码  |  说明
-----  |  -----
101    |  缺少参数session


#### 1.1.4 上传微信Form ID		

#### 接口调用说明

	请求方式：POST
	请求uri：/api/applet/wx/add_form_id

#### 请求参数说明

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
fid  |   是     |   str    |   xxx       | 小程序中生成的Form ID

#### 返回说明

	{
		'errcode': 0, 'errmsg': 'ok'
	}
	
错误返回说明：

返回码  |  说明
-----  |  -----
101    |  缺少参数form id

    
### 1.2 位置
    
#### 1.2.1 获取用户当前定位
根据前端提供的经纬度查询用户当前所在的城市

#### 接口调用说明

	请求方式：GET
	请求uri：/api/applet/location/get
	
#### 请求参数说明

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
latitude  |   是     |   float    |   18.23    | 纬度
longitude  |   是     |   float    |   158.5    | 经度

#### 返回说明

正常情况下，会返回下述JSON数据：

	{
		country_id: 123,
		conutry_name: "xxx"
		country_eng_name: "xxx",
		city_id: 432,
		city_name: "xxx",
		city_img: "http://xxx",
		timezone: -8,
		city_eng_name: "xxx",
		currency: "美元”，
		currency_sign: "$"，
		calling_code: "0100" // 国家电话区号
	}

错误返回说明：	

返回码  |  说明
-----  |  -----
201    |  获取定位失败

#### 1.2.2 获取推荐城市

首页根据当前定位获取推荐的城市列表

#### 接口调用说明

	请求方式：GET
	请求uri：/api/applet/city/recommend/get
	
#### 请求参数说明

	无

#### 返回说明

正常情况下，会返回下述JSON数据：

	{
		"cities": [
			{
				city_id: 123,
				city_name: "纽约",
				city_eng_name: "new york",
				city_img: "http://xxx",
				country_id: 21,
				country_name: "美国",
				country_eng_name: "USA",
				timezone: -8,
				currency: "美元”，
				currency_sign: "$"，
				calling_code: "0100" // 国家电话区号

			},
		]
	}


#### 1.2.3 获取精选内容

首页根据定位获取当前城市的精选内容，包括商品、服务、活动等

#### 接口调用说明

	请求方式：GET
	请求uri： /api/applet/content/recommend/get
	
#### 请求参数说明

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
city_id  |   是     |   int    |   123    | 当前城市id

#### 返回说明

正常情况下，会返回下述JSON数据：

	{
		product_shops: [
			{	
				id: 321,
				name: "大洋海产",
				description: "xxx",
				merchant_id: 432,
				priority: 999,
				status: 2,
				type: 1,
				phone: "13243423424",
				address: "xxx",
				img: "http://xxx",
				owner_qrcode: "http://xxx",
				shop_qrcode: "http://xxx",
				owner_avatar: "http://xxx",  // 店主头像
				permanent_transport_fee: 0,  // 固定运费
				free_transport_fee: 0,  // 免运费金额
				display_shop_cart: 1,
				display_product_tag: 1,
				tags: []
			},
		]，
		service_shops: [
			{
				id: 321,
				name: "东方会计",
				description: "xxx",
				merchant_id: 432,
				priority: 999,
				status: 2,
				type: 2,
				phone: "13243423424",
				address: "xxx",
				img: "http://xxx",
				owner_qrcode: "http://xxx",
				shop_qrcode: "http://xxx",
				owner_avatar: "http://xxx",  // 店主头像
				permanent_transport_fee: 0,  // 固定运费
				free_transport_fee: 0,  // 免运费金额
				display_shop_cart: 1,
				display_product_tag: 1,
				tags: []
			}
		],
		activities: [
			{
				id: 231,
				name: '周末登山',
				description: '爬紫金山',
				status: 1, // 活动状态，1：等待开始，2：已开始，3：已完成，4：已关闭
				phone: '134232434234',
				address: '白马公园',
				img: '/user/image/ca.png',
				start_time: '1440751417',
				end_time: '1440751576',
				fee_type: 1, // 费用类型，1：不需要付费，2：需要付费
				fee: 12,
				remind_type: 1, // 提醒时间类型，1：不提醒，2：5分钟前，3：15分钟前，4：30分钟前，5：1小时前，6：2小时前，7：1天前，8：2天前，9：1周前
				enroll_type: 1, // 报名类型，1：不需要报名，2：需要报名
				groupon_type: 2, // 是否团购，1：否，2：是
				need_enroll_amount: 1,
				need_enroll_phone: 1,
				need_enroll_groupon_amount: 1,
				need_enroll_comment: 1,
				sponsor: {
					id: 121,
					name: 'kun',
					phone: '134343534554',
					avatar: '/user/image/abc.png'
				},
				"enrolls": [
			        {
			          "amount": 1,
			          "comment": "",
			          "groupon_amount": 0,
			          "id": 1,
			          "is_anonymous": 2,
			          "phone": "12324234",
			          "user": {
			            "avatar": "http://xadfafas",
			            "id": 2,
			            "name": "markaii"
			          }
			        }
			     ]
			}
		]
	}
	如果没有数据，则goods或services或activities的列表内为空

#### 1.2.4 查询城市

根据输入的关键字查询匹配的城市

#### 接口调用说明

	请求方式：GET
	请求uri：/api/applet/city/search
	
#### 请求参数说明

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
keyword  |   是     |   str    |   纽约    | 查询的关键字

#### 返回说明

正常情况下，会返回下述JSON数据：

	{
		"cities": [
			{
				city_id: 123,
				city_name: "纽约",
				city_eng_name: "new york",
				city_img: "http://xxx",
				country_id: 21,
				country_name: "美国",
				country_eng_name: "USA",
				timezone: -8,
				currency: "美元”，
				currency_sign: "$"，
				calling_code: "0100" // 国家电话区号
			},
		]
	}
	若没有查询到相关城市，则cities列表为空

#### 1.2.5 获取热门城市

102地区选择页面推荐的热门城市，需要根据国家进行归类

#### 接口调用说明

	请求方式：GET
	请求uri：/api/applet/city/hot/get
	
#### 请求参数说明

	无
	
#### 返回说明

	{
		countries: [
			{
				"id": 234,
				"name": "加拿大",
				"eng_name": "canada",
				"currency": "CAD",
				"currency_sign": "$"
				"calling_code": "0100"
				"cities": [
					{
						id: 21,
						name: "多伦多"
						eng_name: "toloto",
						img: "http://xxx",
						timezone: -8,
					},
					{
						id: 22,
						name: "温哥华"
						eng_name: "wengehua",
						img: "http://xxx",
						timezone: -8,
					}
				]
			}
		]
	}
	

#### 1.2.6 获取城市信息接口

根据city_id获取所在的城市的信息

#### 接口调用说明

	请求方式：GET
	请求uri：/api/applet/city/info/get
	
#### 请求参数说明

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
city_id  |   是     |   int    |   18   | 城市id

#### 返回说明

正常情况下，会返回下述JSON数据：

	{
		city_name: "xxx",
		city_img: "http://xxx",
		timezone: -8,
		city_eng_name: "xxx",
		country_id: 123,
		conutry_name: "xxx"
		country_eng_name: "xxx",
		currency: "美元”，
		currency_sign: "$"，
		calling_code: "0100" // 国家电话区号
	}


#### 1.2.7 查询国家下的城市列表

根据国家名查询国家下的城市列表

#### 接口调用说明

	请求方式：GET
	请求uri：/api/applet/country/cities/get

#### 请求参数说明

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
country_name  |   是     |   str    |   加拿大   | 国家名

#### 返回说明

正常情况下，会返回下述JSON数据：

	{
		"cities": [
			{
				city_id: 123,
				city_name: "纽约",
				city_eng_name: "new york",
				city_img: "http://xxx",
				country_id: 21,
				country_name: "美国",
				country_eng_name: "USA",
				timezone: -8,
				currency: "美元”，
				currency_sign: "$"，
				calling_code: "0100" // 国家电话区号
			},
		]
	}
	
	
#### 1.2.8 获取国家列表

获取国家列表

#### 接口调用说明

	请求方式：GET
	请求uri：/api/applet/countries/get

#### 请求参数说明

无

#### 返回说明

正常情况下，会返回下述JSON数据：

	{
		countries: [
			{
				id: 123,
				name: "中国",
				eng_name: "China",
				currency: "CNY",
				currency_sign: "￥",
				calling_code: "86"
			}
		]
	}
	
### 1.3 搜索
	
#### 1.3.1 获取热门搜索

从后台获取5个最近热门的搜索关键字，需要指定搜索的类型，比如商品（店铺）、服务...

#### 接口调用说明

	请求方式：GET
	请求uri：/api/applet/search/hot/get
	
#### 请求参数说明

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
type  |   是     |   int    |   1    | 搜索的类型，1：商品（店铺），2：服务，3：活动，4:文章，5：问答，6：二手，7：租房
city_id  |  是   |   int    |  32    | 所属城市id

#### 返回说明

	{
		hot_keywords: [
			"西装裤", "跑鞋", "电脑", "手机", "围巾"
		]
	}
	
#### 1.3.2 分类搜索接口

根据当前指定的类型，搜索对应的内容；如指定”商品“类型，则搜索出匹配的商品和店铺；如指定”问答“，则搜索出匹配的问答记录

#### 接口调用说明

	请求方式：GET
	请求uri：/api/applet/content/search
	
#### 请求参数说明

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
keyword  |   是   |  str  |  短裤  |  搜索的关键字
type  |   是     |   int    |   1    | 搜索的类型，1：商品（店铺），2：服务，3：活动，4：文章，5：问答，6：二手，7：租房
city_id  |  是   |   int    |  32    | 所属城市id

#### 返回说明

	如果type=1和2，返回products和shops，type=3活动，返回activities，后续做的时候会补充该文档;
	products/shops或者其他数据，最多50组

	{
		products: [
			{
				id: 123,
				name: "短裤",
				description: "xxx",
				price: 32.3,
				shop_name: "三年二班",
				type: 1,  //1：单规格，2：多规格
				status: 1, // 1：上架，2：下架 
				stock: 10,
				imgs: ["http://xxx", ]
				total_sales: 5,
				priority: 999,
				specs: [  // 规格，多规格商品才有
					{ id: 123, name: "小份", price: 23.2 }，
					{ id: 124, name: "大份", price: 32.2 }  
				]，
				tag_id: 231，  // 所属商品
				display_shop_cart: 1,
				display_product_tag: 1
			}
		],
		shops: [
			{
				id: 321,
				name: "三年二班",
				merchant_id: 432,
				priority: 999,
				status: 2,
				type: 1,
				phone: "13243423424",
				address: "xxx",
				img: "http://xxx",
				owner_qrcode: "http://xxx",
				shop_qrcode: "http://xxx",
				owner_avatar: "http://xxx",
				permanent_transport_fee: 0,  // 固定运费
				free_transport_fee: 0,  // 免运费金额
				display_shop_cart: 1,
				display_product_tag: 1,
				tags: []
			}
		]

	}
	
	
	
### 1.4 留言

#### 1.4.1 获取留言信息(分页）

获取归属于某个事物（商品、服务、活动）的留言信息

#### 接口调用说明

	请求方式：GET
	请求uri：/api/applet/comments/get
	
#### 请求参数说明

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
owner_id  |  是  |  int  |  987  | 所属的对象，如果是商品和服务，就是product_id，如果是活动，就是activity_id
type  |  是  |  int  |  1  |  所属对象类型，1：商品，2：服务，3：活动，4：文章，5：问答，6：二手，7：租房，8：团购
page  |  否  |  int  |  2  |  分页获取数据中的页数，如不指定，则默认是第1页
size  |  否  |  int  |  10  | 分页获取数据中每页的个数，如不指定，则默认是10个

#### 返回说明

	{
		current_page: 1, 
		total_page: 3,
		total_count: 27,
		comments: [
			{
				id: 231,
				content: "留言内容",
				user_name: "xxx",
				user_id: 132,
				user_avatar: "/user/image/xxx.jpg",
				create_time: "1440751417",
				replys: [
					{
						id: 231,
						content: "留言回复内容",
						user_name: "xxx",
						user_id: 214,
						user_avatar: "xxx",
						create_time: "1440751876"
					}
				]
			}
		]
	}


#### 1.4.2 提交留言

用户提交对某个事物（商品、服务、活动）的留言

#### 接口调用说明

	请求方式：POST
	请求uri：/api/applet/comment/submit
	
#### 请求参数说明

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
owner_id  |  是  |  int  |  987  | 所属的对象，如果是商品和服务，就是product_id，如果是活动，就是activity_id
type  |  是  |  int  |  1  |  所属对象类型，1：商品，2：服务，3：活动，4：文章，5：问答，6：二手，7：租房，8：团购
content  |  是  |  str  |  回复@李明：很好看，点赞  |  留言内容，如果是回复，把回复的头部也加上
parent_id  |  否  |  int  |  435  |  父评论id，留言回复需带上该参数

#### 返回码说明

	{
		comment_id: 321
	}
	
### 1.5 验证码

#### 1.5.1 发送邮箱验证码

根据当前指定的地址发送验证码到邮箱，返回验证码供前端验证（验证码有效期半小时，如超过半小时，则需要重新获取）

#### 接口调用说明

	请求方式：POST
	请求uri：/api/applet/email/verify/token
	
#### 请求参数说明

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
email  |   是   |  str  |  xx@qq.com  | 邮箱

#### 返回说明

	{
		'errcode': 0, 'errmsg': 'ok'
	}

#### 1.5.2 发送短信验证码

根据当前指定的电话号发送短信验证码，验证过程同邮箱验证

#### 接口调用说明

	请求方式：POST
	请求uri：/api/applet/phone/verify/token
	
#### 请求参数说明

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
phone  |   是   |  str  |  13627362343  | 手机号

#### 返回说明

	{
		'errcode': 0, 'errmsg': 'ok'
	}
	
#### 1.5.3 验证验证码是否有效

验证通过短信或者邮箱获取到的验证码

#### 接口调用说明

	请求方式：POST
	请求uri：/api/applet/verify/token/check
	
#### 请求参数说明

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
token  |   是   |  str  |  643986  | 6位数字验证码

#### 返回说明

	正确返回：
	
		{ 'errcode': 0, 'errmsg': 'ok' }
		
	错误返回：
	
		{ 'errcode': 201, 'errmsg': '错误的验证码' }
		{ 'errcode': 202, 'errmsg': '验证码已过期' }
	
### 1.6 用户账号

#### 1.6.1 同步用户信息

用户每次重新授权登陆后，同步用户信息到服务器

#### 接口调用说明

	请求方式：POST
	请求uri：/api/applet/user/info/sync
	
#### 请求参数说明

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
name  |   是   |  str  |  john  |  微信名
avatar |  是   |  str  |  http://xxx  |  头像链接
gender  |  是  |  int  |  1  | 性别，0：未知，1：男，2：女
cur_city  |  是  |  int  |  6  | 用户定位当前城市id

#### 返回说明

正确情况下，返回以下JSON数据：

	{ user_id: 232 }
	
错误返回说明：	

返回码  |  说明
-----  |  -----
201    |  同步失败

#### 1.6.2 获取用户信息

根据user_id获取用户信息

#### 接口调用说明

	请求方式：GET
	请求uri：/api/applet/user/info/get
	
#### 请求参数说明

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
user_id  |   是   |  int  |  132  |  用户id

#### 返回说明

正常情况下，返回以下JSON数据：

	{
		id: 232,
		name: 'messi',
		avatar: 'http://xxx',
		gender: 1, // 性别，0：未知，1：男，2：女
		real_name: '胡泊',
		phone: '148323243534',
		email: '28793745@qq.com',
		cur_city: {
    		calling_code: '1',
    		city_eng_name: 'Saskatoon',
    		cur_city: 6,
    		city_img: '/city_image/saskatoon.jpg',
    		city_name: '萨斯卡通',
    		country_eng_name': 'Canada',
    		country_id: 3,
    		country_name: '加拿大',
    		currency: 'CAD',
    		currency_sign: '$',
    		timezone: -6
		}
	}
	
#### 1.6.3 修改用户信息接口

修改指定用户的用户信息

#### 接口调用说明

	请求方式：POST
	请求uri：/api/applet/user/info/update
	
#### 请求参数说明

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
user_id  |   是   |  int  |  132  |  用户id
real_name  |  否  |  str  |  胡泊  |  用户姓名
phone  |  否  |  str  | 1354535353  |  电话
email  |  否  |  str  | 232341443  |  邮箱
cur_city  |   否   |  int  |  6  |  用户定位当前城市id

#### 返回说明

正常情况下，返回以下JSON数据：

	{ errcode: 0, errmsg: 'ok' }


### 1.7 广告

#### 1.7.1 获取广告列表

首页的广告模块通过这个接口获取当前位置的广告数据，需要当前的位置参数获取限定区域的广告

#### 接口请求说明

	请求方式：GET
	请求uri：/api/applet/ads/list/get
	
#### 请求参数

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
city_id  |  是  |  int  |  321  |  城市id
country_id  |  是  |  int  |  234  |  国家id
page_type  |  是  |  int  |  234  |  页面类型-在数据库里定义

#### 返回说明

正常情况下，返回如下json数据：

	{
		ads: [
			{
				id: 321,
				owner: '58同城',
				description: '这是一个神奇的网站',
				img: 'http://xxx',
				redirect_url: 'http://xxx',
			}
		]
	}
	
### 1.8 上传

#### 1.8.1 获取上传到腾讯云COS的signature

小程序前端通过这个签名上传文件到腾讯云COS，该签名可以重复使用

#### 接口请求说明

	请求方式：GET
	请求uri：/api/applet/cos/sign/get
	
#### 请求参数

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
file_name  |  是  |  str  |  a.jpg  |  文件名
file_type  |  是  |  int  |  1   | 文件类型，1：图片，2：语音，3、视频，4、文档

#### 返回说明

正常情况下，返回如下json数据：

	{
		"signature": "xxx"，
		”expire_time": 1231314131  // 过期时间，unix时间戳；30分钟内有效
	}
	
### 1.9 辅助

#### 1.9.1 获取随机图片

获取随机生成的图片

#### 接口请求说明

	请求方式：GET
	请求uri: /api/applet/random/img/get
	
#### 请求参数

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
width  |  是  |  int  |  750  |  图片宽度，默认是750
length  |  是  |  int  |  356  |  图片长度，默认是356
keywords  |  是  |  str  |  activity  |  关键词，可以有多个，用逗号分隔，比如：shop,city

#### 返回说明

	{ img_path: '/user/image/xxx.png' }

#### 1.9.2 获取热门标签

根据指定的类别获取当前的热门标签

#### 接口请求说明

	请求方式：GET
	请求uri: /api/applet/tags/hot/get
	
#### 请求参数

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
type  |  是  |  int  |  1  |  标签的类型，1：商品，2：服务，3：活动，4：文章，5：问答，6：二手，7：租房，8：团购

#### 返回说明

	{
		tags:[
			{
				id: 123,
				name: '电脑'
			}
		] 
	}

#### 1.9.3 获取标签

根据指定的类别获取当前的标签

#### 接口请求说明

       请求方式：GET
       请求uri: /api/applet/tags/get

#### 请求参数

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
type  |  是  |  int  |  1  |  标签的类型，1：商品，2：服务，3：活动，4：文章，5：问答，6：二手，7：租房，8：团购
type  |  否  |  owner_id  |  0  |  店铺ID

#### 返回说明

       {
           "tags": [
               {
                   "id": 66,
                   "name": "初始标签"
                   "url": "http://overseas-1252412068.costj.myqcloud.com/icons/food-recommend.png"
               },
               {
                   "id": 138,
                   "name": "餐饮美食"
                   "url": "http://overseas-1252412068.costj.myqcloud.com/icons/shop-grocery.png"
               },
               {
                   "id": 144,
                   "name": "推荐餐馆"
                   "url": ""
               },
               {
                   "id": 145,
                   "name": "海鲜食品"
                   "url": ""
               },
               {
                   "id": 146,
                   "name": "商品购物"
                   "url": ""
               }
           ]
       }


## 2 商品/服务

### 2.1 商品/服务展示、购买

该部分提供客户查看店铺、商品，并购买的相关接口

#### 2.1.1 获取推荐店铺（分页）

根据当前所在城市，分页获取店铺列表，根据优先级倒序排列

#### 接口调用说明

	请求方式：GET
	请求uri：/api/applet/shop/recommend/get
	
#### 请求参数说明

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
city_id  |  是   |   int    |  32    | 所属城市id
type  |  是  |  int  |  1  | 店铺类型，1：商品店铺，2：服务店铺
page  |  否  |  int  |  2  |  分页获取数据中的页数，如不指定，则默认是第1页
size  |  否  |  int  |  10  | 分页获取数据中每页的个数，如不指定，则默认是10个

#### 返回说明

	{
		current_page: 1, 
		total_page: 3,
		total_count: 27,
		shops: [
			{
				id: 321,
				name: "三年二班",
				description: "xxx",
				merchant_id: 432,
				priority: 999,
				status: 2,
				type: 1,
				phone: "13243423424",
				phone_code: '86',
				address: "xxx",
				img: "http://xxx",
				free_transport_fee: 100, //免运费金额
				permanent_transport_fee: 20, //固定运费
				file_url: "user/image/a.png',
				owner_qrcode: "http://xxx",
				shop_qrcode: "http://xxx",
				owner_avatar: "http://xxx",  // 店主头像
				tags: []
			}
		]
	}

#### 2.1.2 获取店铺商品/服务列表（分页、分类）

203商品首页获取分类的商品/服务列表（当前正在销售的商品）

#### 接口调用说明

	请求方式：GET
	请求uri：/api/applet/shop/products/get
	
#### 请求参数说明

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
shop_id  |  是   |   int    |  32    | 店铺id
tag_id  |  否  |  int  |  43  | 指定的商品分类id，如果不指定，则获取全部
page  |  否  |  int  |  2  |  分页获取数据中的页数，如不指定，则默认是第1页
size  |  否  |  int  |  10  | 分页获取数据中每页的个数，如不指定，则默认是10个

#### 返回说明

	{
		current_page: 1, 
		total_page: 3,
		total_count: 27,
		products: [
			{
				id: 123,
				name: "短裤",
				description: "xxx",
				price: 32.3,  // 如果是多规格，则该数据为空
				type: 1,  //1：单规格，2：多规格
				status: 1, // 1：上架，2：下架 
				stock: 10,
				imgs: ["http://xxx", ]
				total_sales: 5,
				priority: 999,
				tag_id: 231  // 所属商品类别id
				specs: [  // 规格，多规格商品才有
					{ id: 123, name: "小份", price: 23.2 }，
					{ id: 124, name: "大份", price: 32.2 }  
				]，
			},
			{}...
		],
	}

#### 2.1.3 获取当前店铺内的商品/服务分类

203获取当前店铺的分类列表

#### 接口调用说明

	请求方式：GET
	请求uri：/api/applet/product/tags/get
	
#### 请求参数说明

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
shop_id  |  是   |   int    |  32    | 店铺id

#### 返回说明

		
	{
		tags: [
			id: 234,
			name: '短裤',
			type: 1, // 1:商品，2：服务，3：活动，4：文章，5：问答，6：二手，7：租房
			product_count: 5
		]
	}
	// 其中product_count是该分类下的商品数量
	
	
#### 2.1.4 提交订单接口

207购物车中的商品/服务结算，生成最终订单

#### 接口调用说明

	请求方式：POST
	请求uri：/api/applet/shop/order/submit
	
#### 请求参数说明

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
shop_id  |  是   |   int    |  32    | 店铺id
user_id  |  是   |   int    |  23    | 用户id
shipping_method  |  是  |  int  | 1  |  配送方式，1：货到付款，2：上门自提
receiver_name  |  是  |  str  |  徐晓  |  收货人姓名
purchase_records |  是  | JSON str  |  [{ "product_id": 321， "amount": 2, "product_spec_id": 3 }，]  |  购买的产品, JSON格式，需要先序列化，如果是多规格商品，需要product_spec_id，否则不需要
phone  |  是  | str  |  132278663  | 电话
phone_code  |  否  |  str  |  86  |  电话区号
address  |  否  |  str  |  南京市雨花区软件大道  | 收货地址，配送方式为货到付款需要
transportation_cost  |  是  |  float  |  23.4  |  快递运费，需要根据店铺的运费规则计算
comment  |  否  |  str  |  需要黑色s码  |  给卖家留言
total_price  |  是  |  float  |  总价  |  订单的总价，包括运费
form_id  |  否  |  str  |  fjowirqu543  |  提交订单的form_id

#### 返回说明

	{ errcode: 0, errmsg: "ok" }

#### 2.1.5 查看评论概况

204商品详情页面中，调用该接口查看商品评论概况

#### 接口调用说明

	请求方式：GET
	请求uri：/api/applet/product/rate/overview
	
#### 请求参数说明

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
product_id  |  是   |   int    |  32    | 商品id

#### 返回说明

	{
		total_rate_num: 6,  // 总的评价数
		average_rate: 3  // 综合评价
	}

#### 2.1.6 查看商品/服务评论

204分页查看商品评论信息

#### 接口调用说明

	请求方式：GET
	请求uri：/api/applet/product/rates/get
	
#### 请求参数说明

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
product_id  |  是   |   int    |  32    | 商品id
page  |  否  |  int  |  2  |  分页获取数据中的页数，如不指定，则默认是第1页
size  |  否  |  int  |  10  | 分页获取数据中每页的个数，如不指定，则默认是10个

#### 返回说明

	{
		current_page: 1, 
		total_page: 3,
		total_count: 27,
		rates: [
			{
				id: 123,
				rate: 4,
				comment: "很棒的产品",
				create_time: "1496202688"
				user：{
					id: 343,
					name: "mike",
					avatar: "http://xxx"
				}
				reply: {
					id: 213,
					reply: "感谢您的回复",
					create_time: "1496202688"
				}
				
			}
		]
	}
	
#### 2.1.7 获取顾客订单收货地址历史记录

顾客提交订单时的查看历史选项

#### 接口调用说明
	
	请求方式：GET
	请求uri：/api/applet/user/order/address/history
	
#### 请求参数说明

	无
	
#### 返回说明

	[{"address": "北京中关村"}, {"address": "南京珠江路"}]
	

#### 2.1.8 获取店铺详情

通过shop_id获取店铺详情

#### 接口调用说明

	请求方式：GET
	请求uri：/api/applet/shop/info/get
	
#### 请求参数说明

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
shop_id  |  是   |   int    |  32    | 店铺id

#### 返回说明

	{
        "address": "58-110 Keevil Crse",
        "avg_rate": 4.5,
        "business_hour": "周一到周五 8:00 - 18:00",
        "city": {
            "country_name": "加拿大",
            "id": 6,
            "name": "萨斯卡通"
        },
        "display_product_tag": 1,
        "display_shop_cart": 1,
        "display_style": 1,
        "file_url": null,
        "free_transport_fee": 0,
        "id": 235,
        "img": "/user/image/tmp_8fea2af5c5a33e1992b868ea652360fd.jpg",
        "intro_video": "http://www.baidu.com",
        "merchant_id": 141,
        "merchant_name": "武宁江",
        "merchant_wechat_id": null,
        "name": "老武私房菜",
        "owner_avatar": "https://wx.qlogo.cn/mmopen/vi_32/xzufAux1U2wjUS8WFshh2fOYuza2vunZ6dyicz3D3O8wqWhPKXAiboHOHECWuDIcibDNhC0icTial0qP13qmh8WO2kQ/0",
        "owner_qrcode": "/user/image/tmp_f47db9bce8455b6284c862d66f12398d.jpg",
        "permanent_transport_fee": 0,
        "phone": "3068809858",
        "phone_code": "1",
        "priority": 1,
        "rate_count": 1,
        "shop_qrcode": null,
        "status": 2,
        "tags": [
            {
                "id": 247,
                "name": "私房菜"
            }
        ],
        "type": 1,
        "vote_count": 1,
        "vote_users": [
            {
                "avatar": "https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIRYmb8O0nKjwTFkRootmmmaj8qkxaUbEde3PjtxoYhhsiaXptqKFlLdCEIkgaUiaAV7IGCibLBWR2aw/0",
                "id": 1269
            }
        ]
    }


#### 2.1.9 获取商品/服务详情

查询商品、服务详情信息

#### 接口调用说明

	请求方式：GET
	请求uri：/api/applet/shop/product/info/get
	
#### 请求参数说明

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
product_id  |  是   |   int    |  32    | 商品/服务id

#### 返回说明

	{
		id: 123,
		name: "短裤",
		description: "xxx",
		price: 32.3,  // 如果是多规格，则该数据为空
		type: 1,  //1：单规格，2：多规格
		status: 1, // 1：上架，2：下架 
		stock: 10,
		imgs: ["http://xxx", ]
		total_sales: 5,
		priority: 999,
		transportation_cost: 5.3,
		tag_id: 231  // 所属商品类别id
		specs: [  // 规格，多规格商品才有
			{ id: 123, name: "小份", price: 23.2 }，
			{ id: 124, name: "大份", price: 32.2 }  
		]，
		"shop": {
		    "address": "南京市新街口新百广场",
		    "display_product_tag": 1,
		    "display_shop_cart": 1,
		    "id": 6,
		    "img": "http://xxx",
		    "name": "cookie",
		    "owner_qrcode": null,
		    "phone": '14736635236',
		    "phone_code": '86',
		    "file_url": "a.png",
		    "priority": 999,
		    free_transport_fee: 100, //免运费金额
	         permanent_transport_fee: 20, //固定运费
		    "shop_qrcode": null,
		    "status": 2,
		    "tags": [],
		    "type": 1
		},
		"city": {
		     "country_name": "中国",
		     "id": 8,
		     "name": "南昌市"
	     },
	}

#### 2.1.10 用户发布投票（点赞）

#### 接口调用说明

	请求方式：POST
	请求uri：/api/applet/user_vote/submit
	
#### 请求参数说明

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
owner_id  |  是   |   int    |  235    | 关联对象ID，比如店铺ID
type  |  是  |  int  |  1  |  关联对象类型，1：店铺，2：景点
v_type  |  是  |  int  |  1  | 投票类型，1：赞同，2：反对，目前应该都是传1

#### 返回说明

	{
		vote_id: 3
	}

#### 2.1.11 用户发布点评

#### 接口调用说明

	请求方式：POST
	请求uri：/api/applet/user_rate/submit
	
#### 请求参数说明

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
owner_id  |  是   |   int    |  235    | 关联对象ID，比如店铺ID
type  |  是  |  int  |  1  |  关联对象类型，1：店铺，2：景点
rate  |  是  |  string  |  4.5  |  评分
title  |  否  |  string  |  test  |  点评标题
comment  |  否  |  string  |  very good!  |  点评内容

#### 返回说明

	{
		rate_id: 3
	}

#### 2.1.12 获取用户点评列表

#### 接口调用说明

	请求方式：GET
	请求uri：/api/applet/user_rates/get
	
#### 请求参数说明

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
owner_id  |  是   |   int    |  235    | 关联对象ID，比如店铺ID
type  |  是  |  int  |  1  |  关联对象类型，1：店铺，2：景点
page  |  否  |  int  |  2  |  分页获取数据中的页数，如不指定，则默认是第1页
size  |  否  |  int  |  10  | 分页获取数据中每页的个数，如不指定，则默认是10个

#### 返回说明

	{
        "current_page": 1,
        "rates": [
            {
                "comment": "very good!!!!",
                "create_time": "2018/01/29 03:18:56",
                "id": 1,
                "rate": 4.5,
                "title": "test",
                "user": {
                    "avatar": "https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIRYmb8O0nKjwTFkRootmmmaj8qkxaUbEde3PjtxoYhhsiaXptqKFlLdCEIkgaUiaAV7IGCibLBWR2aw/0",
                    "id": 1269,
                    "name": "旅行者降龙"
                }
            }
        ],
        "total_count": 1,
        "total_page": 1
    }

#### 2.1.13 获取用户点赞列表

#### 接口调用说明

	请求方式：GET
	请求uri：/api/applet/user_votes/get
	
#### 请求参数说明

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
owner_id  |  是   |   int    |  235    | 关联对象ID，比如店铺ID
type  |  是  |  int  |  1  |  关联对象类型，1：店铺，2：景点
page  |  否  |  int  |  2  |  分页获取数据中的页数，如不指定，则默认是第1页
size  |  否  |  int  |  10  | 分页获取数据中每页的个数，如不指定，则默认是10个

#### 返回说明

   {
        "current_page": 1,
        "votes": [
            {
                "create_time": "2018/02/18 06:28:27",
                "id": 1,
                "user": {
                    "avatar": "https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83eqZCXfepZv9QwpQrm5yicXiba1mSoypMKPXV9yGUqEYJZWJ17KKuY0Qdm3cMX4CQVNYJyH84yewd4zw/0",
                    "id": 36,
                    "name": "海风"
                }
            }
        ],
        "total_count": 1,
        "total_page": 1
    }

#### 2.1.14 保存用户上传照片地址

#### 接口调用说明

	请求方式：POST
	请求uri：/api/applet/shop/images/add
	
#### 请求参数说明

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
shop_id  |  否   |   int    |  235    | 关联对象ID，店铺ID
rate_id  |  否   |   int    |  235    | 关联对象ID，点评ID
imgs  |  是  |  JSON str  |  ["user/image/xxx", "xxx", "xxx"]  |  JSON格式的图片列表

#### 返回说明

	{
		'errcode': 0, 'errmsg': 'ok'
	}

#### 2.1.15 获取图片列表

#### 接口调用说明

	请求方式：GET
	请求uri：/api/applet/shop/images/get
	
#### 请求参数说明

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
user_id  |  否   |   int    |  235    | 关联对象ID，用户ID
shop_id  |  否   |   int    |  235    | 关联对象ID，店铺ID
rate_id  |  否   |   int    |  235    | 关联对象ID，点评ID
page  |  否  |  int  |  2  |  分页获取数据中的页数，如不指定，则默认是第1页
size  |  否  |  int  |  10  | 分页获取数据中每页的个数，如不指定，则默认是10个

#### 返回说明

    {
        "current_page": 1,
        "images": [
            {
                "create_time": "2018/02/23 20:33:41",
                "image_path": "/user/image/tmp_d0983022e2477910c5eb307fd3f2df71.jpg",
                "user": {
                    "avatar": "https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83eqZCXfepZv9QwpQrm5yicXiba1mSoypMKPXV9yGUqEYJZWJ17KKuY0Qdm3cMX4CQVNYJyH84yewd4zw/0",
                    "id": 36,
                    "name": "海风"
                }
            },
            {
                "create_time": "2018/02/23 20:33:41",
                "image_path": "/user/image/tmp_7fce28828b52a7ae623127400c0c4ab7.jpg",
                "user": {
                    "avatar": "https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83eqZCXfepZv9QwpQrm5yicXiba1mSoypMKPXV9yGUqEYJZWJ17KKuY0Qdm3cMX4CQVNYJyH84yewd4zw/0",
                    "id": 36,
                    "name": "海风"
                }
            }
        ],
        "total_count": 2,
        "total_page": 1
    }

### 2.2 客户订单管理

该部分提供客户管理自己下的订单的相关接口

#### 2.2.1 客户获取自己的订单列表（分类、分页）

702我的订单页面分类获取客户订单

#### 接口调用说明

	请求方式：GET
	请求uri：/api/applet/user/orders/get
	
#### 请求参数

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
status  |  是  |  int  |  1  |  订单状态，0：全部订单，1：待收货，2：待评价，3：交易完成，4：已关闭，
page  |  否  |  int  |  2  |  分页获取数据中的页数，如不指定，则默认是第1页
size  |  否  |  int  |  5  | 分页获取数据中每页的个数，如不指定，则默认是5个

#### 返回说明

	{
		current_page: 1, 
		total_page: 3,
		total_count: 27,
		orders: [
			{
				id: 134,
				serial_num: 12837364221  // 订单号
				shipping_method: 1, // 配送方式，1：货到付款，2：上门自提
				receiver_name: "徐晓",
				phone: "134342243",
				phone_code: "86",
				status: 1, //   订单状态， 1：待收货，2：待评价，3：交易完成，4：已关闭
				comment: "xxx", // 客户留言
				address: "xxx",
				total_price: 13.2, // 总价
				transportation_cost: 12.3
				shop_id: 321,
				shop_name: 'ta的小店',  // 店铺名
				purchase_records: [
					{
						id: 321,
						amount: 2,
						product: {
							id: 321,
							name: "短裤",
							description: "xxx",
							imgs: ["http://xxx", ],
							type: 2, // 商品类型，1：单规格，2：多规格
							price: 32.3, 
							spec_name: "小份",  // 商品规格名，type=2时需要
						},
						rate:	{  // 已评价的订单才有
							id: 123,
							rate: 4,
							comment: "很棒的产品",
							reply: {
								id: 213,
								comment: "感谢您的回复",
							}
							
						}
					}
				],

			}
		]
	}


#### 2.2.2 客户评价订单

702 客户评论已完成订单，如该订单有多个商品，需要同时评价多个商品

#### 接口调用说明

	请求方式：POST
	请求uri：/api/applet/user/order/rate
	
#### 请求参数

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
order_id  |  是  |  int  |  432  |  订单id
rates  |  是  |  JSON str  |  [{ product_id: 321, rate: 4, comment: "非常棒，送货也很快" }]  |  多个商品的评价信息，需要先序列化为字符串

#### 返回说明
	
	{ errcode: 0, errmsg: "ok" }

### 2.3 店铺管理

该部分提供商家店铺管理的相关接口


#### 2.3.1 查询当前用户的店铺信息

在701个人中心页面查询当前用户的店铺信息，是否是普通用户，或已申请开店，或已有店铺

#### 接口调用说明

	请求方式：GET
	请求uri：/api/applet/merchant/shop/info/get
	
#### 请求参数

	无
	
#### 返回说明

若用户不是商家，返回如下数据：

	{
		is_merchant: false
	}
	
若用户是商家，返回如下数据：

	{
		is_merchant: true,
		is_applied: true,  // 是否已申请开店
		merchant: {
			id: 233,
			contact_name: "xxx",
			status: 1, 1: 待审核， 2：活跃， 3：禁用
			phone: "xxx",
			phone_code: "86",
			email: "xxx",
		},
		shops: [
			{
				id: 123,
				name: "xxx",
				phone: "xxx",
				phone_code: "86",
				address: "xxx",
				priority: 999
				status: 1, 1: 待审核，2：活跃，3：禁用
				enable_robot: 0, 0:禁用机器人功能，1：提供机器人
				type: 1, 1: 商品店铺，2：服务店铺，3：移民公司，4：海淘卖家
				city: { id: 21, name: "xxx", country_name: "xxx" },
				owner_qrcode: "xxx",
				shop_qrcode: "xxx"
				img: "http://xxx",
				file_url: "user/image/a.png",
				display_shop_cart: 1,  // 是否显示购物车（1：显示，2：不显示）
				display_product_tag: 1,  // 是否显示商品分类（1：显示，2：不显示）
				tags: []
			}
		]
	}

#### 2.3.2 申请开店

提交申请开店的商家&&店铺信息到后台

#### 接口调用说明

	请求方式：POST
	请求uri：/api/applet/merchant/shop/apply
	
#### 请求参数

参数名    |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
type   |  是   |   int  |  1  |  申请类型，1：首次开店，2：重复开店
merchant_id  |  否  |  int  |  328  |  商家id，type=1首次开店时不需要，type=2时必须
`merchant_contact_name`  |   否   |  str  |  林毅  |  商家联系人，首次开店时必须
merchant_phone  |  否  |  str  |  1343232123  | 商家电话，首次开店时必填
merchant_phone_code | 否  |  str  |  86  |  商家电话国家区号，中国是86
merchant_email  |  否  |  str  |  xx@qq.com       | 商家邮箱，首次开店时必须
city_id  |  是   |  int  |  432  | 城市id
shop_type  |  是  |  int  |  1  |  店铺类型， 1：商品提供商，2：服务提供商，3：移民公司，4：海淘卖家， 5: 餐饮提供商
shop_name  |  是  |  str  |  王小二的杂货铺  |  店铺名
shop_address  | 是  |  str  |  xxx   | 店铺地址
shop_phone  |  是  |  str  |  12323134242  |  店铺电话
shop_phone_code | 否  |  str  |  86  |  店铺电话国家区号
shop_img  | 是  |  str  |  http://xxx  |  店铺图片链接（先上传到腾讯云，获取到图片地址）
`shop_file_url` |  是  |  str  |  http://xxx  |  店铺资料链接


#### 返回说明

申请成功，返回如下：

	{ errcode: 0, errmsg: "ok" }
	
错误返回：

	{ 'errcode': 201, 'errmsg': '店铺名已被其他用户使用' }

#### 2.3.3 修改店铺申请资料

若是已申请开店，使用此接口修改申请资料

#### 接口调用说明

	请求方式：POST
	请求uri：/api/applet/merchant/shop/apply/update
	
#### 请求参数

参数名    |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
type   |  是   |   int  |  1  |  申请类型，1：首次开店，2：重复开店
merchant_id  |  否  |  int  |  123  |  商家id，type=1时必须，type=2时不需要
`merchant_contact_name`  |   否   |  str  |  林毅  |  商家联系人，type=1时必须，type=2时不需要
merchant_phone  |  否  |  str  |  1343232123  | 商家电话，type=1时必须，type=2时不需要
merchant_phone_code | 否  |  str  |  86  |  商家电话国家区号，中国是86
merchant_email  |  否  |  str  |  xx@qq.com       | 商家邮箱，type=1时必须，type=2时不需要
city_id  |  是   |  int  |  432  | 城市id
shop_id  |  是  |  int  | 234  |  店铺id
shop_type  |  是  |  int  |  1  |  店铺类型， 1：商品提供商，2：服务提供商，3：移民公司，4：海淘卖家
shop_name  |  是  |  str  |  王小二的杂货铺  |  店铺名
shop_phone  |  是  |  str  |  123231342342  |  店铺电话
shop_phone_code | 否  |  str  |  86  |  店铺电话国家区号
shop_address  | 是  |  str  |  xxx   | 店铺地址
shop_img  | 是  |  str  |  http://xxx  |  店铺图片链接（先上传到腾讯云，获取到图片地址）
`shop_file_url` |  是  |  str  |  http://xxx  |  店铺资料链接


#### 返回说明

申请成功，返回如下：

	{ errcode: 0, errmsg: "ok" }
	
错误返回：

	{ 'errcode': 201, 'errmsg': '店铺名已被其他用户使用' }


#### 2.3.4 商家获取自己的店铺列表

704店铺管理，商家获取自己管理的店铺列表

#### 接口调用说明

	请求方式：GET
	请求uri：/api/applet/merchant/shops
	
#### 请求参数

	无（实际上需要带上通用的参数login_session)
	
#### 返回说明

	{
		shops: [
			{
				id: 321,
				name: "三年二班",
				merchant_id: 432,
				priority: 9999,
				status: 2,
				enable_robot: 0,
				type: 1,
				phone: "13243423424",
				phone_code: "86",
				address: "xxx",
				img: "http://xxx",
				file_url: "user/image/a.png",
				city: { id: 21, name: "xxx", country_name: "xxx" },
				owner_qrcode: "http://xxx",
				shop_qrcode: "http://xxx",
				display_shop_cart: 1,  // 是否显示购物车（1：显示，2：不显示）
				display_product_tag: 1,  // 是否显示商品分类（1：显示，2：不显示）
				tags: []
			}
		]
	}

#### 2.3.5 商家获取自己店铺商品/服务列表

705商品/服务管理，分类型获取商品/服务列表

#### 接口调用说明

	请求方式：GET
	请求uri：/api/applet/merchant/products

#### 请求参数

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
shop_id  |  是   |   int    |  32    | 店铺id
status   |  否   |   int    |  1     | 商品状态，1：在售，2：已下架
page  |  否  |  int  |  2  |  分页获取数据中的页数，如不指定，则默认是第1页
size  |  否  |  int  |  10  | 分页获取数据中每页的个数，如不指定，则默认是10个

#### 返回说明

	{
		current_page: 1, 
		total_page: 3,
		total_count: 27,
		products: [
			{
				id: 123,
				name: "短裤",
				description: "xxx",
				price: 32.3,  // 如果是多规格，则该数据为空
				type: 1,  //1：单规格，2：多规格
				status: 1, // 1：上架，2：下架 
				stock: 10,
				imgs: ["http://xxx", ]
				total_sales: 5,
				priority: 999,
				transportation_cost: 21.2,
				specs: [  // 规格，多规格商品才有
					{ id: 123, name: "小份", price: 23.2 }，
					{ id: 124, name: "大份", price: 32.2 }  
				]，
				tags: []
			}
		]
	}
	
#### 2.3.6 添加新商品/服务

705商品/服务管理中添加新商品

#### 接口调用说明

	请求方式：POST
	请求uri：/api/applet/merchant/product/add
	
#### 请求参数

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
shop_id  | 是  | int  | 43  |  店铺id
name  |  是  |  str  |  牛仔裤  |  商品名称
type  |  是  |  int  |  类型  |  商品类型，1：单规格，2：多规格
description  |  否  |  str  | 李维斯的牛仔裤  |  商品描述
tag_id  |  否  | int  |  54  | 商品分类id，若选择了店内分类则需加上
price  |  否  |  float  |  43.2  | 商品价格，如果是单规格则必须，若是多规格，每个规格带上独立的价格
imgs  |  否  |  JSON str  |  ["http://xxx", "http://xxx", "http://xxx"]  |  JSON格式的图片列表，第一张图为主图
specs  |  否  |  JSON str  |  [{ name: "小份", price: 23.2 }, { name: "中份", price: 32.1 }]  |  JSON格式的商品规格列表，需要先序列化
stock  |  否  |  int  |  999  | 商品库存，如果不提供，默认是999

#### 返回说明

	{ errcode: 0, errmsg: "ok", product_id: 34 }

#### 2.3.7 修改商品/服务

705商品/服务管理中修改商品信息

#### 接口调用说明

	请求方式：POST
	请求uri：/api/applet/merchant/product/update
	
#### 请求参数

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
product_id  | 是  |  int  |  564  |  商品id
shop_id  | 是  | int  | 43  |  店铺id
name  |  是  |  str  |  牛仔裤  |  商品名称
type  |  是  |  int  |  类型  |  商品类型，1：单规格，2：多规格
status  |  是  |  int  |  状态  |  商品状态，1：在售，2：下架
description  |  否  |  str  | 李维斯的牛仔裤  |  商品描述
tag_id  |  否  | int  |  54  | 商品分类id，若选择了店内分类则需加上
price  |  否  |  float  |  43.2  | 商品价格，如果是单规格则必须，若是多规格，每个规格带上独立的价格
imgs  |  否  |  JSON str  |  ["http://xxx", "http://xxx", "http://xxx"]  |  JSON格式的图片列表，第一张图为主图
specs  |  否  |  JSON str  |  [{ name: "小份", price: 23.2 }, { name: "中份", price: 32.1 }]  |  JSON格式的商品规格列表，需要先序列化

#### 返回说明

	{ errcode: 0, errmsg: "ok" }


#### 2.3.8 删除商品/服务

705商品/服务管理中删除商品

#### 接口调用说明

	请求方式：POST
	请求uri：/api/applet/merchant/product/del
	
#### 请求参数

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
shop_id  | 是  | int  | 43  |  店铺id
product_id  |  是  |  int  |  32  |  商品id

#### 返回说明

	{ errcode: 0, errmsg: "ok" }
	
#### 2.3.9 商家获取自己店铺商品/服务分类列表

	请求方式：GET
	请求uri：/api/applet/merchant/product/tags
	
#### 请求参数

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
shop_id  | 是  | int  | 43  |  店铺id

#### 返回说明

	{
		tags: [
			{
				id: 234,
				name: '短裤',
				type: 1, // 1:商品，2：服务，3：活动，4：文章，5：问答，6：二手，7：租房
				product_count: 5,
				priority: 2,  // 排序优先级，值越大优先级越高
			}
		]
	}

#### 2.3.10 新增商品/服务分类

#### 接口调用说明

	请求方式：POST
	请求uri：/api/applet/merchant/product/tag/add
	
#### 请求参数

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
shop_id  | 是  | int  | 43  |  店铺id
type   |  是  |  int  |  1  |  类型，1：商品，2：服务
name   |  是  | str  | 短裤  |  店内产品分类名称
priority  |  否  |  int  |  3  |  排序优先级，优先级越高，顺序越靠前；默认新添加的分类优先级最高

#### 返回说明

	{ errcode: 0, errmsg: "ok"，tag_id: 432， priority: 5 }

#### 2.3.11 修改商品/服务分类

#### 接口调用说明

	请求方式：POST
	请求uri：/api/applet/merchant/product/tag/update
	
#### 请求参数
	
参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
shop_id  | 是  | int  | 43  |  店铺id
tag_id  |  是  |  int  |  32  |  产品分类id
name   |  是  | str  | 短裤  |  店内产品分类名称

#### 返回说明

	{ errcode: 0, errmsg: "ok" }
	
#### 2.3.11-1 调换商品/服务分类排序

调换2个商品分类的排序优先级priority

#### 接口调用说明

	请求方式：POST
	请求uri：/api/applet/merchant/product/tag/switch

#### 请求参数

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
a_tag_id  |  是  |  int  |  32  |  第一个tag_id
b_tag_id  |  是  |  int  |  31  |  第二个tag_id

##### 返回说明

{ errcode: 0, errmsg: 'ok' }


#### 2.3.12 删除商品分类

要求该分类下当前商品数为0

#### 接口调用说明

	请求方式：POST
	请求uri：/api/applet/merchant/product/tag/del
	
#### 请求参数
	
参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
shop_id  | 是  | int  | 43  |  店铺id
tag_id  |  是  |  int  |  32  |  产品分类id

#### 返回说明

	{ errcode: 0, errmsg: "ok" }
	
	
#### 2.3.13 修改店铺信息

707店铺设置

#### 接口调用说明

	请求方式：POST
	请求uri：/api/applet/merchant/shop/info/update
	
#### 请求参数

参数名    |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
id  |  是  |  int  |  432  |  店铺id  
name  |  是  |  str  |  王小二的杂货铺  |  店铺名
address  | 是  |  str  |  xxx   | 店铺地址
phone  |  是  |  str  |  132432424|  店铺联系电话
phone_code  |  否  |  str  |  86  |  电话国家区号
img  | 是  |  str  |  http://xxx  |  店铺图片链接（先上传到腾讯云，获取到图片地址）
owner_qrcode |  是  |  str  |  http://xxx  |  店主二维码图片链接
shop_qrcode |  否  |  str  |  http://xxx  |  店铺二维码图片链接，小程序二维码
display_shop_cart  |  是  |  int  |  1  |  是否显示购物车，1：显示，2：不显示
display_product_tag  |  是  | int  |  2  |  是否显示类别，1：显示，2：不显示
free_transport_fee  | 是  |  float  |  30  |  免运费金额
permanent_transport_fee  | 是  |  float  |  20  |  固定运费金额

#### 返回说明

	{ errcode: 0, errmsg: "ok" }
	
#### 2.3.14 商家获取顾客订单列表（分类、分页）

706商家订单管理，获取当前订单列表

#### 接口调用说明

	请求方式：GET
	请求uri：/api/applet/merchant/orders/get
	
#### 请求参数

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
shop_id  |  是    |   int   |  453  |  店铺id
status  |  否  |  int  |  1  |  订单状态， 1：进行中，3：已完成，4：已关闭
page  |  否  |  int  |  2  |  分页获取数据中的页数，如不指定，则默认是第1页
size  |  否  |  int  |  5  | 分页获取数据中每页的个数，如不指定，则默认是5个

#### 返回说明

	{
		current_page: 1, 
		total_page: 3,
		total_count: 27,
		orders: [
			{
				id: 134,
				serial_num: 12837364221  // 订单号
				shipping_method: 1, // 配送方式，1：货到付款，2：上门自提
				receiver_name: "徐晓",
				phone: "134342243",
				phone_code: "86",
				status: 1, //   订单状态， 1：待收货，2：待评价，3：交易完成，4：已关闭
				comment: "xxx", // 客户留言
				address: "xxx",
				total_price: 13.2, // 总价
				transportation_cost: 12.3
				purchase_records: [
					{
						id: 232,
						amount: 2,
						product: {
							id: 2322,
							name: "短裤",
							imgs: ["http://xxx", ],
							description: "xxx",
							type: 1, // 规格类型，1：单规格，2：多规格
							price: 32.3,  // 如果是多规格，则该数据为空
							spec_name: "小份",
						}
					}
				]
			}
		]
	}


#### 2.3.15 商家确认收货

#### 接口调用说明

	请求方式：POST
	请求uri：/api/applet/merchant/order/confirm
	
#### 请求参数

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
order_id  |  是  |  int  |  312  |  订单id

#### 返回说明

	{ errcode: 0, errmsg: "ok" }

#### 2.3.16 商家取消订单

#### 接口调用说明

	请求方式：POST
	请求uri：/api/applet/merchant/order/cancel
	
#### 请求参数

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
order_id  |  是  |  int  |  312  |  订单id

#### 返回说明

	{ errcode: 0, errmsg: "ok" }

#### 2.3.17 商家发送订单信息到自己邮箱

#### 接口调用说明

	请求方式：POST
	请求uri：/api/applet/merchant/order/email/send
	
#### 请求参数

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
order_id  |  是  |  int  |  312  |  订单id

#### 返回说明

	{ errcode: 0, errmsg: "ok" }

#### 2.3.18 商家查看订单评价

#### 接口调用说明

	请求方式：GET
	请求uri：/api/applet/merchant/order/rate/get
	
#### 请求参数

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
order_id  |  是  |  int  |  312  |  订单id
product_id  |  是  |  int  |  321  |  商品id

#### 返回说明

	{
		id: 213,
		rate: 5,
		comment: "产品非常棒",
		reply: { id: 323, reply: "xxx" }  // 只有当商家回复了之后才存在
	}

#### 2.3.19 商家回复订单评价

#### 接口调用说明

	请求方式：POST
	请求uri：/api/applet/merchant/order/rate/reply
	
#### 请求参数

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
rate_id  |  是  |  int  |  312  |  订单id
reply  |  是  |  str  |  感谢您的评价  |  商家对用户评价的回复

#### 返回说明

	{ errcode: 0, errmsg: "ok" }


#### 2.3.20 商家修改订单运费

#### 接口调用说明

    请求方式：POST
    请求uri：/api/applet/merchant/order/trans_cost/update

#### 请求参数

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
order_id  |  是  |  int  |  312  |  订单id
transportation_cost  |  是  |  float  |  25  |  订单运费
form_id  |  否  |  str  |  fjdiqfakj23  |  小程序form的id

#### 返回说明

	{ errcode: 0, errmsg: "ok" }

#### 2.3.21 商家确认用户已付款

#### 接口调用说明

	请求方式：POST
	请求uri：/api/applet/merchant/order/paid
	
#### 请求参数

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
order_id  |  是  |  int  |  312  |  订单id

#### 返回说明

	{ errcode: 0, errmsg: "ok" }

### 2.4 账户相关

该部分提供商家PC端登录/重置密码/发送验证码相关接口

#### 2.4.1 发送重置密码用的验证码

#### 接口调用说明

	请求方式：POST
	请求uri：/api/applet/merchant/account/send_reset_token
	
#### 请求参数

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
email   |  是  | str  | 627030035@qq.com  |  商户注册的Eamil地址

#### 返回说明

	正确返回：
	
		{ 'errcode': 0, 'errmsg': 'ok' }
		
	错误返回：
	
	    {'errcode': 101, 'errmsg': '用户Email不能为空'}
		{'errcode': 201, 'errmsg': '发送验证码邮件失败'}
		{'errcode': 202, 'errmsg': '邮件已发送，请在5分钟后重试'}
		{'errcode': 203, 'errmsg': '用户Email未注册'}

#### 2.4.2 重置商户登录密码

#### 接口调用说明

	请求方式：POST
	请求uri：/api/applet/merchant/account/reset_pwd
	
#### 请求参数

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
email   |  是  | str  | 627030035@qq.com  |  商户注册的Eamil地址
pwd   |  是  | str  | 123456  |  重置新密码
token   |  是  | str  | 887438  |  验证码

#### 返回说明

	正确返回：
	
		{ 'errcode': 0, 'errmsg': 'ok' }
		
	错误返回：
	
		{'errcode': 101, 'errmsg': '用户Email不能为空'}
		{'errcode': 101, 'errmsg': '密码不能为空'}
		{'errcode': 101, 'errmsg': '验证码不能为空'}
		{'errcode': 201, 'errmsg': '验证码错误'}
		{'errcode': 500, 'errmsg': '商家信息不存在'}

#### 2.4.3 商户使用Email登录

#### 接口调用说明

	请求方式：POST
	请求uri：/api/applet/merchant/account/login
	
#### 请求参数

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
email   |  是  | str  | 627030035@qq.com  |  商户注册的Eamil地址
pwd   |  是  | str  | 123456  |  密码

#### 返回说明

	正确返回：
	
		{ 'errcode': 0, 'errmsg': 'ok' }
		
	错误返回：
	
		{'errcode': 101, 'errmsg': '用户Email不能为空'}
		{'errcode': 101, 'errmsg': '密码不能为空'}
		{'errcode': 201, 'errmsg': '用户密码错误'}
		{'errcode': 500, 'errmsg': '商家信息不存在'}


## 3 活动及团购

### 3.1 活动团购展示/报名
#### 3.1.1 获取某个时间范围内的活动列表

按照时间范围，获取当前城市尚未结束的活动，要求制定的时间范围是UTC时间

#### 接口调用说明

	请求方式：GET
	请求uri：/api/applet/activities/waiting/get
	
#### 请求参数

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
city_id  |  是  |  int  |  22  |  城市id
start_date  |  是  |  str  |  2017-06-12  |  起始日期（utc)
end_date  |  是  |  str  |  2017-06-18  |  结束日期（utc）
page  |  否  |  int  |  2  |  分页获取数据中的页数，如不指定，则默认是第1页
size  |  否  |  int  |  10  | 分页获取数据中每页的个数，如不指定，则默认是10个

#### 返回说明

	{
		current_page: 1,
		total_page: 3,
		total_count: 27,
		activities: [
			{
				id: 231,
				name: '周末登山',
				description: '爬紫金山',
				status: 1, // 活动状态，1：等待开始，2：已开始，3：已完成，4：已关闭
				phone: '134232434234',
				phone_code: '86',
				address: '白马公园',
				img: '/user/image/ca.png',
				start_time: '1496202688',
				end_time: '1496202897',
				fee_type: 1, // 费用类型，1：不需要付费，2：需要付费
				fee: 12,
				remind_type: 1, // 提醒时间类型，1：不提醒，2：5分钟前，3：15分钟前，4：30分钟前，5：1小时前，6：2小时前，7：1天前，8：2天前，9：1周前
				enroll_type: 1, // 报名类型，1：不需要报名，2：需要报名
				groupon_type: 2, // 是否团购，1：否，2：是
				need_enroll_amount: 1,
				need_enroll_phone: 1,
				need_enroll_groupon_amount: 1,
				need_enroll_comment: 1,
				sponsor: {
					id: 121,
					name: 'kun',
					phone: '134343534554',
					avatar: '/user/image/abc.png'
				},
				"enrolls": [
			        {
			          "amount": 1,
			          "comment": "",
			          "groupon_amount": 0,
			          "id": 1,
			          "is_anonymous": 2,
			          "phone": "12324234",
			          "user": {
			            "avatar": "http://xadfafas",
			            "id": 2,
			            "name": "markaii"
			          }
			        }
			      ],
			}
		]
	}
	
#### 3.1.2 获取某个时间范围内的团购列表

按照时间范围，获取当前城市尚未结束的团购，要求制定的时间范围是UTC时间

#### 接口调用说明

	请求方式：GET
	请求uri：/api/applet/groupons/waiting/get
	
#### 请求参数

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
city_id  |  *   |  int  |  22  |  城市id
shop_type  |  *   |  int  |  4   |  店铺类型
start_date  |  是  |  str  |  2017-06-12  |  起始日期（utc)
shop_id |  *   |  int  |  22  |  店铺id
page  |  否  |  int  |  2  |  分页获取数据中的页数，如不指定，则默认是第1页
size  |  否  |  int  |  10  | 分页获取数据中每页的个数，如不指定，则默认是10个

* 在查询海淘商家的团购信息时不需要city_id。
  如果指定了city_id，不需要shop_type，接口返回商品或服务店铺
  如果没有city_id，shop_type=4，接口返回海淘店铺类型的团购。

#### 返回说明

	{
		current_page: 1,
		total_page: 3,
		total_count: 27,
		groupons: [
        {
            id: 231,
            shop:{'id': 1, 'name': 'xxx'},
            name: '2017中秋晚会团购票',
            description: '团购入场票八折优惠',
            status: 1, // 团购状态，1：未开始，2：进行中，3：已结束
            img: '/user/image/ca.png',
            start_time: '1496202688',
            end_time: '1496202987',
            delivery: 1 // 送货方式，1=自提，2=送货上门
        }
    ]
	}	

#### 3.1.3 报名活动

#### 接口调用说明

	请求方式：POST
	请求uri：/api/applet/activity/enroll
	
#### 请求参数

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
activity_id  |  是  |  int  |  435  |  活动id
amount  |  否  |  int  |  2  |  报名人数，若活动需要设置报名人数时必填
phone  |  否  |  str  |  123233423423|  报名电话，活动需要设置报名电话时必填
phone_code  |  否  |  str  |  86  |  报名电话国家区号
guoupon_amount  |  否  |  int  |  3  |  团购个数，活动需要设置团购数量是必填
comment  |  否  | str  |  准时集合  |  活动备注，活动需要设置时必填
is_anonymous  |  是  |  int  |  1  |  是否匿名，1：匿名，2：不匿名
form_id  |  否  |  str  |  fjdiqfakj23  |  小程序form的id，用以发送模板消息

#### 返回说明

	{ errcode:0, errmsg: 'ok' }

#### 3.1.4 取消活动报名

#### 接口调用说明

	请求方式：POST
	请求uri：/api/applet/activity/enroll/cancel
	
#### 请求参数

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
enroll_id  |  是  |  int  |  12  |  报名id

#### 返回说明

	{ errcode: 0, errmsg: 'ok' }
	
#### 3.1.5 获取活动详情

#### 接口调用说明

	请求方式：GET
	请求uri：/api/applet/activity/info/get
	
#### 请求参数

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
activity_id  |  是  |  int  |  22  |  活动id

#### 返回说明

	{
		
		id: 231,
		name: '周末登山',
		description: '爬紫金山',
		status: 1, // 活动状态，1：等待开始，2：已开始，3：已完成，4：已关闭
		phone: '134232434234',
		phone_code: '86',
		address: '白马公园',
		img: '/user/image/ca.png',
		start_time: '1496202688',
		end_time: '1496202908',
		fee_type: 1, // 费用类型，1：不需要付费，2：需要付费
		fee: 12,
		remind_type: 1, // 提醒时间类型，1：不提醒，2：5分钟前，3：15分钟前，4：30分钟前，5：1小时前，6：2小时前，7：1天前，8：2天前，9：1周前
		enroll_type: 1, // 报名类型，1：不需要报名，2：需要报名
		groupon_type: 2, // 是否团购，1：否，2：是
		need_enroll_amount: 1,
		need_enroll_phone: 1,
		need_enroll_groupon_amount: 1,
		need_enroll_comment: 1,
		sponsor: {
			id: 121,
			name: 'kun',
			phone: '134343534554',
			avatar: '/user/image/abc.png'
		},
		"enrolls": [
	        {
	          "amount": 1,
	          "comment": "",
	          "groupon_amount": 0,
	          "id": 1,
	          "is_anonymous": 2,
	          "phone": "12324234",
	          "user": {
	            "avatar": "http://xadfafas",
	            "id": 2,
	            "name": "markaii"
	          }
	        }
	      ],	
	      "city": {
	          "eng_name": "Nanchang",
	          "id": 8,
	          "img": "xxx",
	          "name": "南昌市",
	          "timezone": 8
	      }
	}

#### 3.1.6 报名团购

#### 接口调用说明

	请求方式：POST
	请求uri：/api/applet/groupon/enroll
	
#### 请求参数

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
groupon_id  |  是  |  int  |  435  |  团购id
products  |  是  |  JSON str  |  { "1": 10， "2": 4}  |   用户选择的商品，Key是product_id，value是选购数量
phone  |  是  |  str  |  18627144098  |  手机号
phone_code  |  是  |  str  |  86  |  手机国家代码
comment  |  否  |  str  |  test  |  备注信息
address  |  *   |  str  |  1234  |  收货地址，如果报名的团购送货上门那么此项必填

#### 返回说明

	{ errcode:0, errmsg: 'ok' }
	

#### 3.1.7 更新团购报名信息

#### 接口调用说明

	请求方式：POST
	请求uri：/api/applet/groupon/enroll/update
	
#### 请求参数

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
groupon_id  |  是  |  int  |  435  |  团购id
products  |  是  |  JSON str  |  { "1": 10， "2": 4}  |   用户选择的商品，Key是product_id，value是选购数量
phone  |  是  |  str  |  18627144098  |  手机号
phone_code  |  是  |  str  |  86  |  手机国家代码
comment  |  否  |  str  |  test  |  备注信息
address  |  *   |  str  |  test   | 收货地址，参见3.1.6

#### 返回说明

	{ errcode:0, errmsg: 'ok' }	
	
	
#### 3.1.8 获取团购详情

#### 接口调用说明

	请求方式：GET
	请求uri：/api/applet/groupon/info/get
	
#### 请求参数

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
groupon_id  |  是  |  int  |  435  |  团购id

#### 返回说明

    {
        "description": "团购描述，更多商品",
        "end_time": 1505606400,
        "enrolls": [
            {
                "comment": "\"\"",
                "id": 1,
                "phone": "3068505587",
                "phone_code": "1",
                "address": "123",
                "products": [
                    {
                        "amount": 3,
                        "description": "",
                        "id": 2,
                        "img": "",
                        "left": 200,
                        "limit": 50,
                        "name": "VIP票",
                        "price": 45
                    },
                    {
                        "amount": 4,
                        "description": "",
                        "id": 3,
                        "img": "",
                        "left": 200,
                        "limit": 250,
                        "name": "一等票",
                        "price": 35
                    }
                ],
                "user": {
                    "avatar": "https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83eqZCXfepZv9QwpQrm5yicXiba1mSoypMKPXV9yGUqEYJZWJ17KKuY0Qdm3Xl5ibb6DRRHcqsgVqcibxwQ/0",
                    "id": 36,
                    "name": "海风"
                }
            }
        ],
        "id": 2,
        "img": "/user/image/4c292883b1fba59e91b5b330358f7b38.jpg",
        "name": "团购二",
        "products": [
            {
                "description": "",
                "id": 4,
                "img": "",
                "left": 200,
                "limit": 450,
                "name": "二等票",
                "price": 15
            },
            {
                "description": "",
                "id": 3,
                "img": "",
                "left": 200,
                "limit": 250,
                "name": "一等票",
                "price": 35
            },
            {
                "description": "",
                "id": 2,
                "img": "",
                "left": 200,
                "limit": 50,
                "name": "VIP票",
                "price": 45
            }
        ],
        "shop": {
            "id": 82,
            "name": "海外计算机软件开发"
        },
        "city": {
    	    "eng_name": "Nanchang",
    	    "id": 8,
    	    "img": "xxx",
    	    "name": "南昌市",
    	    "timezone": 8
    	},
    	"has_enrolled": True,  // True or False
        "start_time": 1504742400,
        "status": 1,
        "delivery": 2
    }
    
#### 3.1.8 取消团购报名

    请求方式：GET
    请求uri：/api/applet/groupon/enroll/cancel

#### 请求参数    

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
groupon_id  |  是  |  int  |  435  |  团购id

#### 返回说明

	{ errcode: 0, errmsg: 'ok' }

#### 3.1.9 获取用户在团购中的报名信息

    请求方式：GET
    请求uri：/api/applet/groupon/enroll/get

#### 请求参数    

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
groupon_id  |  是  |  int  |  435  |  团购id

#### 返回说明

	{
        "address": "",
        "comment": "川大教师d",
        "id": 499,
        "phone": "1234545",
        "phone_code": "86",
        "products": [
            {
                "amount": 1,
                "description": "",
                "id": 1,
                "img": null,
                "left": 7,
                "limit": 8,
                "name": "VIP",
                "price": 28
            }
        ],
        "user": {
            "avatar": "https://wx.qlogo.cn/mmopen/vi_32/naPefiaibwicCtLMJXCa1rmVPxjrMrviaNQp39PxUbxmXLic07ZFp8YJvUPlYdbv1UYrxMLH7qLHJd7m6wfQETJwo9Q/0",
            "id": 8347,
            "name": "虚幻"
        }
    }

#### 3.1.10 商户删除团购商品

    请求方式：GET
    请求uri：/api/applet/groupon/product/delete

#### 请求参数    

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
groupon_id  |  是  |  int  |  435  |  团购id
product_id  |  是  |  int  |  1  |  商品id

#### 返回说明

	{ errcode: 0, errmsg: 'ok' }


#### 3.1.11 获取店铺相关的活动列表

#### 接口调用说明

	请求方式：GET
	请求uri：/api/applet/activities/shop/get/
	
#### 请求参数

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
shop_id  |  是  |  int  |  22  |  店铺id
page  |  否  |  int  |  2  |  分页获取数据中的页数，如不指定，则默认是第1页
size  |  否  |  int  |  10  | 分页获取数据中每页的个数，如不指定，则默认是10个

#### 返回说明

	{
		current_page: 1,
		total_page: 3,
		total_count: 27,
		activities: [
			{
				id: 231,
				name: '周末登山',
				description: '爬紫金山',
				status: 1, // 活动状态，1：等待开始，2：已开始，3：已完成，4：已关闭
				phone: '134232434234',
				phone_code: '86',
				address: '白马公园',
				img: '/user/image/ca.png',
				start_time: '1496202688',
				end_time: '1496202897',
				fee_type: 1, // 费用类型，1：不需要付费，2：需要付费
				fee: 12,
				remind_type: 1, // 提醒时间类型，1：不提醒，2：5分钟前，3：15分钟前，4：30分钟前，5：1小时前，6：2小时前，7：1天前，8：2天前，9：1周前
				enroll_type: 1, // 报名类型，1：不需要报名，2：需要报名
				groupon_type: 2, // 是否团购，1：否，2：是
				need_enroll_amount: 1,
				need_enroll_phone: 1,
				need_enroll_groupon_amount: 1,
				need_enroll_comment: 1,
				sponsor: {
					id: 121,
					name: 'kun',
					phone: '134343534554',
					avatar: '/user/image/abc.png'
				},
				"enrolls": [
			        {
			          "amount": 1,
			          "comment": "",
			          "groupon_amount": 0,
			          "id": 1,
			          "is_anonymous": 2,
			          "phone": "12324234",
			          "user": {
			            "avatar": "http://xadfafas",
			            "id": 2,
			            "name": "markaii"
			          }
			        }
			      ],
			}
		]
	}
	

### 3.2 活动管理

#### 3.2.1 发布活动

发布活动，要求开始和结束时间是UTC时间

#### 接口调用说明

	请求方式：POST
	请求uri：/api/applet/activity/release
	
#### 请求参数

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
city_id  |  是   |   int   |  343   |  活动所在城市的id
name  |  是  |  str  |  周末爬山  |  活动名
description  |  是  |  str  |  爬珠峰  |  活动描述
address  |  是  |  str  |  珠峰大本营  |  活动地点
img  |  否  |  str  | /user/image/abc.png  |  活动图片
remind_type  |  是  |  int  |  1  |  活动提醒时间类型，1：不提醒，2：5分钟前，3：15分钟前，4：30分钟前，5：1小时前，6：2小时前，7：1天前，8：2天前，9：1周前
start_time |  是  |  str  |  2017-06-07 12:00  |  活动开始时间（utc）
end_time |  是  |  str  |  2017-06-07 12:00  |  活动结束时间（utc）
phone  |  否  |  str  |  13434234243  |  发起人电话
phone_code  |  否  |  str  |  86  |  电话国家区号
fee_type  |  是  |  int  |  1  | 费用类型，1：不需要费用，2：需要费用
fee  |  否  |  float  |  25.0  |  费用，当fee_type=2是必须
enroll_type  |  是  |  int  |  1  |  报名类型，1：不需要报名，2：需要报名
groupon_type  |  是  |  int  | 2  |  是否团购，1：否，2：是
need_enroll_amount  |  否  |  int  |  是否需要设置报名人数，1：不需要，2：需要，enroll_type=2必填
need_enroll_phone  |  否  |  int  |  是否需要设置报名电话，1：不需要，2：需要，enroll_type=2必填need_enroll_groupon_amount  |  否  |  int  |  是否需要设置团购数量，1：不需要，2：需要，enroll_type=2必填need_enroll_comment  |  否  |  int  |  是否需要设置报名备注，1：不需要，2：需要，enroll_type=2必填

#### 返回说明

	{ errcode: 0, errmsg: 'ok' }


#### 3.2.2 获取用户已发布的活动列表

#### 接口调用说明

	请求方式：GET
	请求uri：/api/applet/activities/released/get
	
#### 请求参数

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
page  |  否  |  int  |  2  |  分页获取数据中的页数，如不指定，则默认是第1页
size  |  否  |  int  |  10  | 分页获取数据中每页的个数，如不指定，则默认是10个

#### 返回说明

	{
		current_page: 1,
		total_page: 3,
		total_count: 27,
		activities: [
			{
				id: 231,
				name: '周末登山',
				description: '爬紫金山',
				status: 1, // 活动状态，1：等待开始，2：已开始，3：已完成，4：已关闭
				phone: '134232434234',
				phone_code: '86',
				address: '白马公园',
				img: '/user/image/ca.png',
				start_time: '1496202688',
				end_time: '1496202987',
				fee_type: 1, // 费用类型，1：不需要付费，2：需要付费
				fee: 12,
				remind_type: 1, // 提醒时间类型，1：不提醒，2：5分钟前，3：15分钟前，4：30分钟前，5：1小时前，6：2小时前，7：1天前，8：2天前，9：1周前
				enroll_type: 1, // 报名类型，1：不需要报名，2：需要报名
				groupon_type: 2, // 是否团购，1：否，2：是
				need_enroll_amount: 1,
				need_enroll_phone: 1,
				need_enroll_groupon_amount: 1,
				need_enroll_comment: 1,
				"enrolls": [
			        {
			          "amount": 1,
			          "comment": "",
			          "groupon_amount": 0,
			          "id": 1,
			          "is_anonymous": 2,
			          "phone": "12324234",
			          "phone_code": "86",
			          "user": {
			            "avatar": "http://xadfafas",
			            "id": 2,
			            "name": "markaii"
			          }
			        }
			      ],
			}
		]
	}

	
#### 3.2.3 获取用户已报名的活动列表

#### 接口调用说明

	请求方式：GET
	请求uri：/api/applet/activities/enrolled/get
	
#### 请求参数

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
page  |  否  |  int  |  2  |  分页获取数据中的页数，如不指定，则默认是第1页
size  |  否  |  int  |  10  | 分页获取数据中每页的个数，如不指定，则默认是10个


#### 返回说明

	{
		current_page: 1,
		total_page: 3,
		total_count: 27,
		activities: [
			{
				id: 231,
				name: '周末登山',
				description: '爬紫金山',
				status: 1, // 活动状态，1：等待开始，2：已开始，3：已完成，4：已关闭
				phone: '134232434234',
				phone_code: '86',
				address: '白马公园',
				img: '/user/image/ca.png',
				start_time: '1496202688',
				end_time: '1496202986',
				fee_type: 1, // 费用类型，1：不需要付费，2：需要付费
				fee: 12,
				remind_type: 1, // 提醒时间类型，1：不提醒，2：5分钟前，3：15分钟前，4：30分钟前，5：1小时前，6：2小时前，7：1天前，8：2天前，9：1周前
				enroll_type: 1, // 报名类型，1：不需要报名，2：需要报名
				groupon_type: 2, // 是否团购，1：否，2：是
				need_enroll_amount: 1,
				need_enroll_phone: 1,
				need_enroll_groupon_amount: 1,
				need_enroll_comment: 1,
				sponsor: {
					id: 121,
					name: 'kun',
					phone: '134343534554',
					avatar: '/user/image/abc.png'
				},
				"enrolls": [
			        {
			          "amount": 1,
			          "comment": "",
			          "groupon_amount": 0,
			          "id": 1,
			          "is_anonymous": 2,
			          "phone": "12324234",
			          "user": {
			            "avatar": "http://xadfafas",
			            "id": 2,
			            "name": "markaii"
			          }
			        }
			      ],
			}
		]
	}
	
	
#### 3.2.4 编辑活动内容

修改活动相关内容

#### 接口调用说明

	请求方式：POST
	请求uri：/api/applet/activity/update
	
#### 请求参数

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
activity_id  |  是  |  int  |  143  |  活动id
city_id  |  是   |   int   |  343   |  活动所在城市的id
name  |  是  |  str  |  周末爬山  |  活动名
description  |  是  |  str  |  爬珠峰  |  活动描述
address  |  是  |  str  |  珠峰大本营  |  活动地点
img  |  否  |  str  | /user/image/abc.png  |  活动图片
remind_type  |  是  |  int  |  1  |  活动提醒时间类型，1：不提醒，2：5分钟前，3：15分钟前，4：30分钟前，5：1小时前，6：2小时前，7：1天前，8：2天前，9：1周前
start_time |  是  |  str  |  2017-06-07 12:00  |  活动开始时间（utc）
end_time |  是  |  str  |  2017-06-07 12:00  |  活动结束时间（utc）
phone  |  否  |  str  |  13434234243  |  发起人电话
phone_code  |  否  |  str  |  86  |  电话国家区号
fee_type  |  是  |  int  |  1  | 费用类型，1：不需要费用，2：需要费用
fee  |  否  |  float  |  25.0  |  费用，当fee_type=2是必须
enroll_type  |  是  |  int  |  1  |  报名类型，1：不需要报名，2：需要报名
groupon_type  |  是  |  int  |  2  |  是否团购，1：否，2：是
need_enroll_amount  |  否  |  int  |  是否需要设置报名人数，1：不需要，2：需要，enroll_type=2必填
need_enroll_phone  |  否  |  int  |  是否需要设置报名电话，1：不需要，2：需要，enroll_type=2必填need_enroll_groupon_amount  |  否  |  int  |  是否需要设置团购数量，1：不需要，2：需要，enroll_type=2必填need_enroll_comment  |  否  |  int  |  是否需要设置报名备注，1：不需要，2：需要，enroll_type=2必填

#### 返回说明

	{ errcode: 0, errmsg: 'ok' }
	
#### 3.2.5 发送活动报名信息到邮箱

#### 接口调用说明

	请求方式：POST
	请求uri：/api/applet/activity/enroll/email/send
	
#### 请求参数

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
email  |  是  |  str  |  27846287642@qq.com  |  邮箱
activity_id  |  是  |  int  |  23424  |  活动id

#### 返回说明

	{ errcode: 0, errmsg: 'ok' }

### 3.3 团购管理

#### 3.3.1 发布团购

发布团购，要求开始和结束时间是UTC时间

#### 接口调用说明

	请求方式：POST
	请求uri：/api/applet/groupon/release
	
#### 请求参数

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
shop_id  |  是   |   int   |  343   |  发起团购的店铺
name  |  是  |  str  |  2017中秋晚会团购票  |  团购名
description  |  是  |  str  |  团购入场票八折优惠  |  活动描述
img  |  否  |  str  | /user/image/abc.png  |  活动图片
start_date |  是  |  str  |  2017-06-07  |  起团日期（utc）
end_date |  是  |  str  |  2017-06-17  |  截团日期（utc）
products  |  是  |  JSON str  |  [{"name": "VIP票","price": 25, "description": "最佳位置", "limit": 50,"image":"/user/image/4c292883b1fba59e91b5b330358f7b38.jpg"}]  |   团购的商品详细，JSON格式，需要先序列化,(商品名， 价格， 规格和描述［可选］，限购数量［可选］，商品图片［可选), limit为0表示不限购
delivery  |  是  |   int   |   1     |  1=自提，2=送货上门

#### 返回说明

	{ errcode: 0, errmsg: 'ok' }
	
	
#### 3.3.2 更新团购

更新团购，要求开始和结束时间是UTC时间

#### 接口调用说明

	请求方式：POST
	请求uri：/api/applet/groupon/update
	
#### 请求参数

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
shop_id  |  是   |   int   |  343   |  发起团购的店铺
groupon_id |  是   |   int   |  34   |  发起团购ID
name  |  是  |  str  |  2017中秋晚会团购票  |  团购名
description  |  是  |  str  |  团购入场票八折优惠  |  活动描述
img  |  否  |  str  | /user/image/abc.png  |  活动图片
start_date |  是  |  str  |  2017-06-07  |  起团日期（utc）
end_date |  是  |  str  |  2017-06-17  |  截团日期（utc）
products  |  是  |  JSON str  |  [{"name": "VIP票","price": 25, "description": "最佳位置", "limit": 50,"image":"/user/image/4c292883b1fba59e91b5b330358f7b38.jpg"}]  |   团购的商品详细，JSON格式，需要先序列化,(商品名， 价格， 规格和描述［可选］，限购数量［可选］，商品图片［可选), limit为0表示不限购
delivery  |  是  |   int   |   1     |  1=自提，2=送货上门

#### 返回说明

	{ errcode: 0, errmsg: 'ok' }
	


#### 3.3.3 获取用户已发布的团购列表

#### 接口调用说明

	请求方式：GET
	请求uri：/api/applet/groupons/released/get
	
#### 请求参数

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
page  |  否  |  int  |  2  |  分页获取数据中的页数，如不指定，则默认是第1页
size  |  否  |  int  |  10  | 分页获取数据中每页的个数，如不指定，则默认是10个

#### 返回说明

	{
	    "current_page": 1,
	    "groupons": [
	        {
	            "description": "团购描述，更多商品",
	            "end_time": 1505606400,
	            "id": 2,
	            "img": "/user/image/4c292883b1fba59e91b5b330358f7b38.jpg",
	            "name": "团购二",
	            "shop": {
	                "id": 82,
	                "name": "海外计算机软件开发"
	            },
	            "start_time": 1504742400,
	            "status": 1,
	            "delivery": 1
	        },
	        {
	            "description": "团购描述",
	            "end_time": 1505606400,
	            "id": 1,
	            "img": "/user/image/4c292883b1fba59e91b5b330358f7b38.jpg",
	            "name": "团购一",
	            "shop": {
	                "id": 82,
	                "name": "海外计算机软件开发"
	            },
	            "start_time": 1504742400,
	            "status": 1,
	            "delivery": 2
	        }
	    ],
	    "total_count": 2,
	    "total_page": 1
	}



	
#### 3.3.4 获取用户已报名的团购列表

#### 接口调用说明

	请求方式：GET
	请求uri：/api/applet/groupons/enrolled/get
	
#### 请求参数

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
page  |  否  |  int  |  2  |  分页获取数据中的页数，如不指定，则默认是第1页
size  |  否  |  int  |  10  | 分页获取数据中每页的个数，如不指定，则默认是10个


#### 返回说明

	{
		current_page: 1,
		total_page: 3,
		total_count: 27,
		groupons: [
			{
				id: 231,
                shop:{'id': 1, 'name': 'xxx'},
                name: '2017中秋晚会团购票',
                description: '团购入场票八折优惠',
                status: 1, // 团购状态，1：未开始，2：进行中，3：已结束
                delivery: 1,
                img: '/user/image/ca.png',
                start_time: '1496202688',
                end_time: '1496202987',
                enroll: {
                    "comment": "",
                    "id": 1,
                    "phone": "131219196",
                    "phone_code": "1",
                    "products": [
                        {
                            "amount": 2,
                            "description": "",
                            "id": 2,
                            "img": "",
                            "left": 0,
                            "limit": 0,
                            "name": "商品1",
                            "price": 20
                        }
                    ],
                    "user": {
                        "avatar": "https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83er4LTSsQjSDsb1XZ8iavYFXQJURh1HtMtRxDUFQnhgRiaAFsS5vh6Rh4Xb8KbloQiaicuMib7SLKCggO4w/0",
                        "id": 847,
                        "name": "啊😲陶然🍃"
                    }
                },
			}
		]
	}

#### 3.3.5 发送团购短信

发送团购短信

#### 接口调用说明

	请求方式：POST
	请求uri：/api/applet/groupon/enrolled/send_sms
	
#### 请求参数

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
groupon_id  |  是   |   int   |  123   |  团购ID
content  |  是  |  str  |  2017中秋晚会马上开始  |  短信内容

#### 返回说明

	{ errcode: 0, errmsg: 'ok' }

#### 3.3.6 获取团购的报名信息

#### 接口调用说明

	请求方式：GET
	请求uri：/api/applet/groupon/enroll_info/get
	
#### 请求参数

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
groupon_id  |  是   |   int   |  123   |  团购ID
page  |  否  |  int  |  2  |  分页获取数据中的页数，如不指定，则默认是第1页
size  |  否  |  int  |  10  | 分页获取数据中每页的个数，如不指定，则默认是10个


#### 返回说明

	{
        "current_page": 1,
        "enrolls": [
            {
                "comment": "",
                "id": 21,
                "phone": "15902273852",
                "phone_code": "1",
                "products": [
                    {
                        "amount": 1,
                        "description": "",
                        "id": 23,
                        "img": "",
                        "left": 199,
                        "limit": 200,
                        "name": "B区票",
                        "price": 20
                    }
                ],
                "user": {
                    "avatar": "https://wx.qlogo.cn/mmopen/vi_32/U3Lk8ER2iaTDKQpJ6W4DzNgkkw35X2Wr0mTUg6ZMYOhEoGodoiauYmjIqhUsTQBumXRauJhNzNkzoMjRRYC19dZQ/0",
                    "id": 982,
                    "name": "虚幻"
                }
            }
        ],
        "total_count": 1,
        "total_page": 1
    }

#### 3.3.7 取消团购

#### 接口调用说明

    请求方式：GET
    请求uri：/api/applet/groupon/cancel
    
#### 请求参数

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
groupon_id  |  是  |  int  |  435  |  团购id

#### 返回说明

    { 'errcode': 0, 'errmsg': 'ok' }

## 4 文章

### 4.1 文章查看
#### 4.1.1 分页获取当前服务店铺的文章列表(分页)

#### 接口调用说明

	请求方式：GET
	请求uri：/api/applet/shop/articles/get
	
#### 请求参数

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
shop_id  |  是  |  int  |  231  |  店铺id
page  |  否  |  int  |  2  |  分页获取数据中的页数，如不指定，则默认是第1页
size  |  否  |  int  |  10  | 分页获取数据中每页的个数，如不指定，则默认是10个

#### 返回说明

	{
		current_page: 1,
		total_page: 3,
		total_count: 27,
		articles: [
			{
				id: 123,
				title: "xxx",
				content: [
					{
						type: 1,
						text: "这是文字内容"
					},
					{
						type: 2,
						text: "/user/image/a.png"
					}
				],
				status: 1,  // 状态，1：有效，2：禁用
				update_time: "1496202688"
			}
		]
	}
	
#### 4.1.2 获取文章详情

#### 接口调用说明
	
	请求方式：GET
	请求uri：/api/applet/article/info/get
	
#### 请求参数

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
article_id  |  是  |  int  |  23  |  文章id

#### 返回说明

	{
		id: 123,
		title: "xxx",
		content: [
			{
				type: 1,
				text: "这是文字内容"
			},
			{
				type: 2,
				text: "/user/image/a.png"
			}
		],
		status: 1,
		update_time: "1496202688"
	}
	
#### 4.1.3 分页获取所有的文章列表(分页)

#### 接口调用说明

	请求方式：GET
	请求uri：/api/applet/articles/get
	
#### 请求参数

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
keyword  |  是  |  string  |  '教育'  |  指定关键词后搜索Tag,文章标题，文章内容
page  |  否  |  int  |  2  |  分页获取数据中的页数，如不指定，则默认是第1页
size  |  否  |  int  |  10  | 分页获取数据中每页的个数，如不指定，则默认是10个
country_id  |  是  |  int  |  234  |  国家id
city_id  |  是   |   int    |  32    | 所属城市id

#### 返回说明

	{
		current_page: 1,
		total_page: 3,
		total_count: 27,
		articles: [
			{
				id: 123,
				title: "xxx",
				content: [
					{
						type: 1,
						text: "这是文字内容"
					},
					{
						type: 2,
						text: "/user/image/a.png"
					}
				],
				status: 1,  // 状态，1：有效，2：禁用
				update_time: "1496202688"
			}
		]
	}

### 4.2 文章管理
#### 4.2.1 添加新文章

#### 接口调用说明

	请求方式：POST
	请求uri：/api/applet/article/release
	
#### 请求参数

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
title  |  是  |  str  |  落花流水  |  文章标题
content  |  是  |  json_str  | [{"type": 1, "text": "这是一段内容"}, { "type": 2, "text": "/user/image/abc.jpg"} ]   |  文章内容, JSON格式，需要先序列化；内部的type表示内容类型，1：文字内容，2：图片内容
shop_id  |  否   |   int   |  343   |  文章绑定的店铺id，如果从服务店铺跳转的，需要该参数

#### 返回说明

	{ errcode: 0, errmsg: 'ok' }

#### 4.2.2 修改文章

#### 接口调用说明

	请求方式：POST
	请求uri：/api/applet/article/update

#### 请求参数

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
article_id  |  是  |  int  |  123  |  文章id
title  |  是  |  str  |  落花流水  |  文章标题
content  |  是  |  json_str  | [{"type": 1, "text": "这是一段内容"}, { "type": 2, "text": "/user/image/abc.jpg"} ]   |  文章内容, JSON格式，需要先序列化；内部的type表示内容类型，1：文字内容，2：图片内容

#### 返回说明

	{ errcode: 0, errmsg: 'ok' }

#### 4.2.3 删除文章

#### 接口调用说明

	请求方式：POST
	请求uri：/api/applet/article/del

#### 请求参数

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
article_id  |  是  |  int  |  123  |  文章id

#### 返回说明

	{ errcode: 0, errmsg: 'ok' }
	
#### 4.2.4 获取用户/服务商自己的文章列表

#### 接口调用说明

	请求方式：GET
	请求uri：/api/applet/own/articles/get
	
#### 请求参数

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
page  |  否  |  int  |  2  |  分页获取数据中的页数，如不指定，则默认是第1页
size  |  否  |  int  |  10  | 分页获取数据中每页的个数，如不指定，则默认是10个
shop_id  |  否  | int  |  1  |  如果是从服务店铺管理中进入的，则需要带上该参数，否则不用带上

#### 返回说明

	{
		current_page: 1,
		total_page: 3,
		total_count: 27,
		articles: [
			{
				id: 123,
				title: "xxx",
				content: [
					{
						type: 1,
						text: "这是文字内容"
					},
					{
						type: 2,
						text: "/user/image/a.png"
					}
				],
				status: 1,
				update_time: "1496202688"
			}
		]
	}

#### 4.2.5 将文章绑定到店铺

#### 接口调用说明

	请求方式：POST
	请求uri：/api/applet/articles/bind
	
#### 请求参数

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
shop_id  |  是   |   int   |  343   |  文章绑定的店铺id
article_ids  |  是  |  json_str  |  '[ 12, 23, 34]'  |  需要绑定的文章id列表

#### 返回说明

	{ errcode: 0, errmsg: 'ok' }
	
#### 4.2.6 移除店铺绑定的文章

#### 接口调用说明

	请求方式：POST
	请求uri：/api/applet/article/unbind
	
#### 请求参数

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
shop_id  |  是   |   int   |  343   |  文章绑定的店铺id
article_id  |  是  |  int  |  12  |  解绑的文章id
country_id  |  是  |  int  |  234  |  国家id
city_id  |  是   |   int    |  32    | 所属城市id

#### 返回说明

	{ errcode: 0, errmsg: 'ok' }

## 5 问答

### 5.1 问答展示/回答

#### 5.1.1 发布新的问题

#### 接口调用说明

	请求说明：POST
	请求uri：/api/applet/question/release
	
#### 请求参数

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
title  |  是  |  str  |  1+1等于几  |  问题标题
description  |  是  |  str  |  这是个哲学问题  |  问题描述
tags  |  否  |  JSON str  |  [{ id: 123, name: '标签一' }, { name: '自定义标签' }]   //如果是自定义的tag，就只有name，如果是选择的tag，还有id
city_id  |  否  |  int  |  22  |  城市id

#### 返回说明

	{ errcode: 0, errmsg: '0k' }


#### 5.1.2 获取问题列表（分页）

#### 接口调用说明
	请求方式：GET
	请求uri：/api/applet/newest/questions/get
	
#### 请求参数

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
city_id  |  否  |  int  |  22  |  城市id
status  |  是  |  int  |  1  |  问题的状态，1：待回答，2：已回答
page  |  否  |  int  |  2  |  分页获取数据中的页数，如不指定，则默认是第1页
size  |  否  |  int  |  10  | 分页获取数据中每页的个数，如不指定，则默认是10个

#### 返回说明

	{
		current_page: 1,
		total_page: 3,
		total_count: 27,
		questions: [
			{
				id: 231,
				title: '1+1等于几',
				description: '8成新二手mac电脑',
				status: 1, // 问题状态，1：待回答，2：已回答
				create_time: '112312414',
				tags: [{id: 123, name: '电子产品'}, {id:143, name: '历史'}],
				answer_count: 55,
				follow_count: 30,
				is_followed: 1, // 当前用户是否已关注，1：尚未关注，2：已关注
				user: {
					id: 123,
					name: 'kun',
					avatar: 'user/image/abc.png'
				},
				best_answer: {
					id: 43,
					content: 'xxx',
					user_intro: 'xxx',
					agree_count: 66,
					user: {
						id: 245,
						name: 'xxx',
						avatar: '/user/image/a.png'
					}
				}
			}
		]
	}
	

#### 5.1.3 获取问题的回答列表（分页）

获取指定问题的回答列表，包括回答对应的评论

#### 接口调用说明

	请求方式：GET
	请求uri：/api/applet/question/answers/get
	
#### 请求参数

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
question_id  |  是  |  int  |  1  |  问题的id
page  |  否  |  int  |  2  |  分页获取数据中的页数，如不指定，则默认是第1页
size  |  否  |  int  |  10  | 分页获取数据中每页的个数，如不指定，则默认是5个

#### 返回说明

	{
		current_page: 1,
		total_page: 3,
		total_count: 27,
		answers: [
			{
				id: 231,
				content: '1+1等于11',
				user_intro: 'java程序员 产品经理',
				agree_count: 45,
				against_count: 13,
				comment_count:10,
				user: {
					id: 123,
					name: 'kun',
					avatar: 'user/image/abc.png'
				}
			}
		]
	}


#### 5.1.3-1 获取问题的回答详情

获取指定问题的回答列表，包括回答对应的评论

#### 接口调用说明

	请求方式：GET
	请求uri：/api/applet/question/answer/info
	
#### 请求参数

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
answer_id  |  是  |  int  |  434  |  回答id

#### 返回说明

	{
		id: 324,
		content: '1+1等于11',
		user_intro: 'java程序员 产品经理',
		agree_count: 45,
		against_count: 13,
		is_agreed: true,
		is_againsted: false,
		user: {
			id: 123,
			name: 'kun',
			avatar: 'user/image/abc.png'
		},
		question: {
			title: '1+1=?',
			description: '这是一个哲学问题',
		},
		comments: [
			{
				id: 231,
				content: "留言内容",
				user_name: "xxx",
				user_id: 132,
				user_avatar: "/user/image/xxx.jpg",
				create_time: "412313123113",
				replys: [
					{
						id: 231,
						content: "留言回复内容",
						user_name: "xxx",
						user_id: 214,
						user_avatar: "xxx",
						create_time: "123124141341"
					}
				]
			}
		]
	}


#### 5.1.4 获取问题详情

获取问题的详情

#### 接口调用说明

	请求方式：GET
	请求uri：/api/applet/question/info/get
	
#### 请求参数

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
question_id  |  是  |  int  |  123  |  问题id

#### 返回说明

	{
		id: 134,
		title: "1+1等于几",
		description: "这是一个哲学问题",
		status: 1, // 问题状态，1：待回答，2：已回答
		create_time: '1231413423',
		tags: [{id: 123, name: '电子产品'}, {id:143, name: '历史'}],
		answer_count: 55,
		follow_count: 30,
		is_followed: 1, // 当前用户是否已关注，1：尚未关注，2：已关注
		user: {
			id: 123,
			name: 'kun',
			avatar: 'user/image/abc.png'
		},
	}

#### 5.1.5 关注/取关问题

#### 接口调用说明

	请求说明：POST
	请求uri：/api/applet/question/follow
	
#### 请求参数

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
question_id  |  是  |  int  |  123  |  问题id
type  |  是  |  int  |  1  |  操作类型，1：关注问题，2：取消关注

#### 返回说明

	{ errcode: 0, errmsg: '0k' }

#### 5.1.6 回答问题

#### 接口调用说明

	请求说明：POST
	请求uri：/api/applet/question/answer
	
#### 请求参数

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
question_id  |  是  |  int  |  123  |  问题id
content  |  是  |  str  |  这是一个号答案  |  回答内容
user_intro  |  用户介绍  |  str  |  java程序员，产品经理  |  回答问题用户的个人介绍

#### 返回说明

	{ errcode: 0, errmsg: '0k' }

#### 5.1.7 赞同/取消赞同答案

#### 接口调用说明

	请求说明：POST
	请求uri：/api/applet/answer/agree
	
#### 请求参数

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
answer_id  |  是  |  int  |  123  |  问题id
type  |  是  |  int  |  1  |  操作类型，1：赞同答案，2：取消赞同

#### 返回说明

	{ errcode: 0, errmsg: '0k' }


#### 5.1.8 反对/取消反对答案

#### 接口调用说明

	请求说明：POST
	请求uri：/api/applet/answer/against
	
#### 请求参数

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
answer_id  |  是  |  int  |  123  |  问题id
type  |  是  |  int  |  1  |  操作类型，1：反对答案，2：取消反对

#### 返回说明

	{ errcode: 0, errmsg: '0k' }


### 5.2 问答管理

#### 5.2.1 获取我发布的问题列表（分页）

#### 接口调用说明
	请求方式：GET
	请求uri：/api/applet/released/questions/get
	
#### 请求参数

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
page  |  否  |  int  |  2  |  分页获取数据中的页数，如不指定，则默认是第1页
size  |  否  |  int  |  10  | 分页获取数据中每页的个数，如不指定，则默认是10个

#### 返回说明

	{
		current_page: 1,
		total_page: 3,
		total_count: 27,
		questions: [
			{
				id: 231,
				title: '1+1等于几',
				description: '8成新二手mac电脑',
				status: 1, // 问题状态，1：待回答，2：已回答
				tags: [{id: 123, name: '电子产品'}, {id:143, name: '历史'}],
				answer_count: 55,
				follow_count: 30,
				create_time: '1498632538'
			}
		]
	}


#### 5.2.2 获取我参与的问题列表

#### 接口调用说明
	请求方式：GET
	请求uri：/api/applet/answered/questions/get
	
#### 请求参数

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
page  |  否  |  int  |  2  |  分页获取数据中的页数，如不指定，则默认是第1页
size  |  否  |  int  |  10  | 分页获取数据中每页的个数，如不指定，则默认是10个

#### 返回说明

	{
		current_page: 1,
		total_page: 3,
		total_count: 27,
		questions: [
			{
				id: 231,
				title: '1+1等于几',
				description: '8成新二手mac电脑',
				status: 1, // 问题状态，1：待回答，2：已回答
				tags: [{id: 123, name: '电子产品'}, {id:143, name: '历史'}],
				answer_count: 55,
				follow_count: 30,
				create_time: '1498632538'
			}
		]
	}


#### 5.2.3 获取我关注的问题列表

#### 接口调用说明
	请求方式：GET
	请求uri：/api/applet/followed/questions/get
	
#### 请求参数

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
page  |  否  |  int  |  2  |  分页获取数据中的页数，如不指定，则默认是第1页
size  |  否  |  int  |  10  | 分页获取数据中每页的个数，如不指定，则默认是10个

#### 返回说明

	{
		current_page: 1,
		total_page: 3,
		total_count: 27,
		questions: [
			{
				id: 231,
				title: '1+1等于几',
				description: '8成新二手mac电脑',
				status: 1, // 问题状态，1：待回答，2：已回答
				tags: [{id: 123, name: '电子产品'}, {id:143, name: '历史'}],
				answer_count: 55,
				follow_count: 30,
				create_time: '1498632538'
			}
		]
	}



## 6 二手

### 6.1 二手商品展示

#### 6.1.1 获取当前城市的二手商品（分页）

#### 接口调用说明

	请求方式：GET
	请求uri：/api/applet/onsale/secondhands/get
	
#### 请求参数

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
city_id  |  是  |  int  |  123  |  当前城市id
page  |  否  |  int  |  2  |  分页获取数据中的页数，如不指定，则默认是第1页
size  |  否  |  int  |  10  | 分页获取数据中每页的个数，如不指定，则默认是10个

#### 返回说明

	{
		current_page: 1,
		total_page: 3,
		total_count: 27,
		secondhands: [
			{
				id: 231,
				name: 'mac电脑',
				description: '8成新二手mac电脑',
				status: 1, // 活动状态，1：在售，2：已出售
				phone: '134232434234',
				phone_code: '86',
				email: '289740876@qq.com',
				price: 3000,
				price_type: 1,
				priority: 21, // 排序优先级
				tags: [{id: 123, name: '电脑'}, {id:143, name: '手机'}],
				imgs: ['user/image/a.png', 'user/image/b.png'],
				update_time: '1分钟前',
				user_name: 'mike',
				user_avatar: '/user/image/a.png'
			}
		]
	}

#### 6.1.2 获取二手商品详情

#### 接口调用说明

	请求方式：GET
	请求uri：/api/applet/secondhand/info/get
	
#### 请求参数

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
secondhand_id  |  是  |  int  |  123  |  二手商品id

#### 返回说明

	{
		id: 123,
		name: 'mac电脑',
		description: '8成新二手mac电脑',
		status: 1, // 活动状态，1：在售，2：已出售
		phone: '134232434234',
		phone_code: '86',
		email: '289740876@qq.com',
		price: 3000,
		price_type: 1,
		priority: 21, // 排序优先级
		tags: [{id: 123, name: '电脑'}, {id:143, name: '手机'}],
		imgs: ['user/image/a.png', 'user/image/b.png'],
		update_time: '1分钟前',
		user_name: 'mike',
		user_avatar: '/user/image/a.png'
	}

### 6.2 二手商品管理

#### 6.2.1 发布二手商品

#### 接口调用说明

	请求方式：POST
	请求uri：/api/applet/secondhand/release
	
#### 请求参数

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
name  |  是  |  str  |  mac电脑  |  二手商品名
description  |  是  |  str  |  7成新，只要3k  |  商品描述
price  |  否  | float  |  3000  |  价格
price_type  |  是  |  int  |  1  |  价格类型，1：需要价格，2：面谈
phone  |  是  |  str  | 13762534322  |  电话
phone_code  | 否  |  str  |  86  |  电话区号
email  |  是  |  str  |  289740765@qq.com  |  邮箱
city_id  |  是   |   int   |  343   |  活动所在城市的id
imgs  |  是  |  JSON str  |  ["user/image/xxx", "xxx", "xxx"]  |  JSON格式的图片列表，第一张图为主图
tags  |  否  |  JSON str  | [{ "id": 32, "name": "标签1"}, { "name": "自定义标签" }]  |  JSON格式的标签列表，若是自定义的tag，则只有name；若是选中的tag，则还需要tag的id

#### 返回说明

	{ errcode: 0, errmsg: 'ok' }


#### 6.2.2 修改二手商品信息

#### 接口调用说明

	请求方式：POST
	请求uri：/api/applet/secondhand/update
	
#### 请求参数

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
secondhand_id  |  是  |  int  |  32  |  二手商品id
name  |  是  |  str  |  mac电脑  |  二手商品名
description  |  是  |  str  |  7成新，只要3k  |  商品描述
price  |  否  | float  |  3000  |  价格
price_type  |  是  |  int  |  1  |  价格类型，1：需要价格，2：面谈
phone  |  是  |  str  | 13762534322  |  电话
phone_code  |  是  |  str  |  86  |  电话区号
email  |  是  |  str  |  289740765@qq.com  |  邮箱
city_id  |  是   |   int   |  343   |  活动所在城市的id
imgs  |  是  |  JSON str  |  ["user/image/xxx", "xxx", "xxx"]  |  JSON格式的图片列表，第一张图为主图
tag_ids  |  否  |  JSON str  | ['32', '56']  |  JSON格式的标签列表

#### 返回说明

	{ errcode: 0, errmsg: 'ok' }

#### 6.2.3 删除该二手商品

#### 接口调用说明

	请求方式：POST
	请求uri：/api/applet/secondhand/del
	
#### 请求参数

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
secondhand_id  |  是  |  int  |  32  |  二手商品id

#### 返回说明

	{ errcode: 0, errmsg: 'ok' }

#### 6.2.4 获取用户自己的二手商品（分页)

#### 接口调用说明

	请求方式：GET
	请求uri：/api/applet/user/secondhands/get
	
#### 请求参数

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
page  |  否  |  int  |  2  |  分页获取数据中的页数，如不指定，则默认是第1页
size  |  否  |  int  |  10  | 分页获取数据中每页的个数，如不指定，则默认是10个

#### 返回说明

	{
		current_page: 1,
		total_page: 3,
		total_count: 27,
		secondhands: [
			{
				id: 231,
				name: 'mac电脑',
				description: '8成新二手mac电脑',
				status: 1, // 活动状态，1：在售，2：已出售
				phone: '134232434234',
				email: '289740876@qq.com',
				price: 3000,
				price_type: 1,
				priority: 21, // 排序优先级
				tags: [{id: 123, name: '电脑'}, {id:143, name: '手机'}],
				imgs: ['user/image/a.png', 'user/image/b.png'],
			}
		]
	}


#### 6.2.5 刷新二手商品

#### 接口调用说明

	请求方式：POST
	请求uri：/api/applet/secondhand/refresh
	
#### 请求参数

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
secondhand_id  |  是  |  int  |  32  |  二手商品id

#### 返回说明

	{ errcode: 0, errmsg: 'ok' }


## 7 租房

### 7.1 租房展示

#### 7.1.1 获取当前城市的租房信息（分页）

#### 接口调用说明

	请求方式：GET
	请求uri：/api/applet/onsale/rentals/get
	
#### 请求参数

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
city_id  |  是  |  int  |  123  |  当前城市id
page  |  否  |  int  |  2  |  分页获取数据中的页数，如不指定，则默认是第1页
size  |  否  |  int  |  10  | 分页获取数据中每页的个数，如不指定，则默认是10个

#### 返回说明

	{
		current_page: 1,
		total_page: 3,
		total_count: 27,
		rentals: [
			{
				id: 231,
				name: '房子',
				description: '8成新房',
				status: 1, // 活动状态，1：在售，2：已出售
				phone: '134232434234',
				phone_code: '86',
				email: '289740876@qq.com',
				price: 3000,
				price_type: 1,
				priority: 21, // 排序优先级
				tags: [{id: 123, name: '电脑'}, {id:143, name: '手机'}],
				imgs: ['user/image/a.png', 'user/image/b.png'],
				update_time: '1分钟前',
				user_name: 'mike',
				user_avatar: '/user/image/a.png'
			}
		]
	}

#### 7.1.2 获取租房信息详情

#### 接口调用说明

	请求方式：GET
	请求uri：/api/applet/rental/info/get
	
#### 请求参数

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
rental_id |  是  |  int  |  123  |  租房信息id

#### 返回说明

	{
		id: 123,
		name: 'mac电脑',
		description: '8成新二手mac电脑',
		status: 1, // 活动状态，1：在售，2：已出售
		phone: '134232434234',
		phone_code: '86',
		email: '289740876@qq.com',
		price: 3000,
		price_type: 1,
		priority: 21, // 排序优先级
		tags: [{id: 123, name: '电脑'}, {id:143, name: '手机'}],
		imgs: ['user/image/a.png', 'user/image/b.png'],
		update_time: '1分钟前',
		user_name: 'mike',
		user_avatar: '/user/image/a.png'
	}

### 7.2 租房信息管理

#### 7.2.1 发布租房信息

#### 接口调用说明

	请求方式：POST
	请求uri：/api/applet/rental/release
	
#### 请求参数

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
name  |  是  |  str  |  mac电脑  |  商品名
description  |  是  |  str  |  7成新，只要3k  |  商品描述
price  |  否  | float  |  3000  |  价格
price_type  |  是  |  int  |  1  |  价格类型，1：需要价格，2：面谈
phone  |  是  |  str  | 13762534322  |  电话
phone_code  | 否  |  str  |  86  |  电话区号
email  |  是  |  str  |  289740765@qq.com  |  邮箱
city_id  |  是   |   int   |  343   |  活动所在城市的id
imgs  |  是  |  JSON str  |  ["user/image/xxx", "xxx", "xxx"]  |  JSON格式的图片列表，第一张图为主图
tags  |  否  |  JSON str  | [{ "id": 32, "name": "标签1"}, { "name": "自定义标签" }]  |  JSON格式的标签列表，若是自定义的tag，则只有name；若是选中的tag，则还需要tag的id

#### 返回说明

	{ errcode: 0, errmsg: 'ok' }


#### 7.2.2 修改租房信息

#### 接口调用说明

	请求方式：POST
	请求uri：/api/applet/rental/update
	
#### 请求参数

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
rental_id |  是  |  int  |  32  |  租房id
name  |  是  |  str  |  mac电脑  |  商品名
description  |  是  |  str  |  7成新，只要3k  |  商品描述
price  |  否  | float  |  3000  |  价格
price_type  |  是  |  int  |  1  |  价格类型，1：需要价格，2：面谈
phone  |  是  |  str  | 13762534322  |  电话
phone_code  |  是  |  str  |  86  |  电话区号
email  |  是  |  str  |  289740765@qq.com  |  邮箱
city_id  |  是   |   int   |  343   |  活动所在城市的id
imgs  |  是  |  JSON str  |  ["user/image/xxx", "xxx", "xxx"]  |  JSON格式的图片列表，第一张图为主图
tag_ids  |  否  |  JSON str  | ['32', '56']  |  JSON格式的标签列表

#### 返回说明

	{ errcode: 0, errmsg: 'ok' }

#### 7.2.3 删除该租房信息

#### 接口调用说明

	请求方式：POST
	请求uri：/api/applet/rental/del
	
#### 请求参数

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
rental_id  |  是  |  int  |  32  |  租房信息id

#### 返回说明

	{ errcode: 0, errmsg: 'ok' }

#### 7.2.4 获取用户自己的租房信息（分页)

#### 接口调用说明

	请求方式：GET
	请求uri：/api/applet/user/rentals/get
	
#### 请求参数

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
page  |  否  |  int  |  2  |  分页获取数据中的页数，如不指定，则默认是第1页
size  |  否  |  int  |  10  | 分页获取数据中每页的个数，如不指定，则默认是10个

#### 返回说明

	{
		current_page: 1,
		total_page: 3,
		total_count: 27,
		rentals: [
			{
				id: 231,
				name: 'mac电脑',
				description: '8成新二手mac电脑',
				status: 1, // 活动状态，1：在售，2：已出售
				phone: '134232434234',
				email: '289740876@qq.com',
				price: 3000,
				price_type: 1,
				priority: 21, // 排序优先级
				tags: [{id: 123, name: '电脑'}, {id:143, name: '手机'}],
				imgs: ['user/image/a.png', 'user/image/b.png'],
			}
		]
	}


#### 7.2.5 刷新租房信息

#### 接口调用说明

	请求方式：POST
	请求uri：/api/applet/rental/refresh
	
#### 请求参数

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
rental_id  |  是  |  int  |  32  |  租房信息id

#### 返回说明

	{ errcode: 0, errmsg: 'ok' }

## 8 机器人相关

### 此处专用返回码errcode说明

接口请求出错时会返回错误码等信息，JSON数据示例如下：

    {"errcode": 500, "errmsg": "参数错误"}
    
以下是一些通用的返回码

返回码   |   说明
-------- | --------
0        | 请求成功
403      | 验证失败，可能是因为: 1)用户不是商家 2)店铺没有开通机器人 3)店铺不存在或不属于该用户
404      | 请求的资源并不存在，如店铺还没有创建机器人，或还没有登录以产生Robot实例
408      | 机器人账号的登陆状态已过期，但Robot实例的数据仍然存在
500      | 操作出于非认证的原因失败

### 8.1 机器人信息

#### 8.1.1 获取机器人信息

	请求方式：GET
	请求URI：/api/applet/robot/get

#### 请求参数

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
shop_id  |  是     |  int    |  82       |  机器人对应店铺的id

#### 返回说明
	
	{
	    "auto_verify": 1, 		// 是否自动加好友，默认1
	    "create_time": "2017-10-11 14:40:07",
	    "id": 1,				// 机器人ID
	    "merchant": 30,			// 商家ID
	    "session": "tw2src48vzzqnii6ztwgbe818uisyvk2", // 专用Session Key
	    "shop": 82,				// 店铺ID
	    "update_time": "2017-10-11 14:44:29", 
	    "welcome_msg": "Hello World!"  // 加好友后发送的信息
	}

#### 8.1.2 列出所有机器人

	请求方式：GET
	请求URI：/api/applet/robot/list

#### 请求参数

	无

#### 返回说明

	[
	    {
	        "auto_verify": 1,
	        "create_time": "2017-10-11 14:40:07",
	        "id": 1,
	        "merchant": 30,
	        "session": "tw2src48vzzqnii6ztwgbe818uisyvk2",
	        "shop": 82,
	        "update_time": "2017-10-11 14:44:29",
	        "welcome_msg": "Hello World!"
	    }
	]

#### 8.1.3 机器人登录

	请求方式：GET
	请求URI：/api/applet/robot/login

#### 请求参数

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ------- | ---------
shop_id  |  是     |  integer  |  10 	| 店铺ID
timeout  |  否	  |  integer  |  30 	| 登陆超时时间（秒），默认30

#### 返回说明

	{
		'errcode': 0,
		'errmsg': 'ok',
	}
	返回后服务端异步执行后续操作，需要前端调用相应接口检测登陆状态，如果未登录则需要获取验证码登录
	登录存在时间限制，目前是30s，如果超时登录线程会被强制销毁。
	这是为了防止用户长时间不登录导致进程挂起，不断写入Session并消耗资源导致后端卡死
	如果店铺没有允许使用机器人，调用此接口将返回errcode=403.

#### 8.1.4 删除机器人信息

	请求方式：GET
	请求URI：/api/applet/robot/del

#### 请求参数

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
shop_id  |  是      |  int     |  82     |  店铺id

#### 返回说明

	注意：删除机器人操作同时也会删除它所属的群
	{
		'errcode': 0,
		'errmsg': 'ok'
	}

#### 8.1.5 更新机器人信息

	请求方式：POST
	请求URI：/api/applet/robot/update

#### 请求参数

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
shop_id	 |  是      |  int     |  1         | 店铺ID
auto_verify | 是    |  int     |  1       | 1=自动加好友，0=不加好友
welcome_msg | 是    |  string  | Hello    | 加好友后自动发送的欢迎消息

#### 返回说明

	{
		'errcode': 0,
		'errmsg': 'ok'
	}

#### 8.1.6 获取机器人微信登录的二维码

	请求方式：GET
	请求URI：/api/applet/robot/qrcode/get

#### 请求参数

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
shop_id   |  是    |   int  |  1  |  店铺id
encode    |  否    |  string | base64 | 编码格式，值为base64后返回
		  |        |          |        | 编码后数据，否则为二进制图片

#### 返回说明

	如果二维码已生成，则直接返回图片数据，Content-Type为application/base64或image/jpeg
	如果没有二维码，则返回{'errcode': 0, 'errmsg': 'ok', 'has_qrcode': False}

#### 8.1.7 检查机器人登录状态

	请求方式：GET
	请求URI：/api/applet/robot/check

#### 请求参数

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
shop_id   |  是     |  int     |  1        | 店铺id 

#### 返回说明

	{
		'errcode': 0,
		'errmsg': 'ok',
		'logged_in': True,
		'desc': '已登录'
	}
	errcode和errmsg都是OK状态
	logged_in表示是否登陆
	desc是文字描述信息

#### 8.1.8 注销机器人的登录（停止机器人）

	请求方式：GET
	请求URI：/api/applet/robot/logout

#### 请求参数

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
shop_id       |  是  |  int  |  1  |  店铺id 

#### 返回说明

	{
		'errcode': 0,
		'errmsg': 'ok'
	}


### 8.2 群

#### 8.2.1 将机器人账户上的群导入数据库

	请求方式：GET
	请求URI：/api/applet/robot/group/load

#### 请求参数

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
shop_id       |  是  |  int  |  1  |  店铺id
	
#### 返回说明

	调用此接口将更新群信息，首次调用会导入账号上保存的群，默认[禁用机器人]但在群导航[不可见]
	多次调用：删除数据库中的原群信息，并与获取的新群列表进行比较，对于名称一致的群会保留设置（描述，公告，可见，激活）
			对于不一致/新群则使用默认设置
	注意：不应该使用多个名称相同的群处理业务，这种情况配置信息会被保留但顺序可能出错
	{
		'errcode': 0,
		'errmsg': 'ok'
	}

#### 8.2.2 更新群信息

	请求方式：POST
	请求URI：/api/applet/robot/group/update

#### 请求参数

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
id		 |	是	   |  int     |  1         | 群ID
name         |  否  |  string  |  test group  | 群名称 
desc		|  否  |   text	  |  description | 群描述
notice		|  否  |   text    |	 notice		| 群公告
visible		|  否  |   int	  |  1			| 是否显示到群导航，0：不显示，1：显示
active		|  否  |   int	  |  1			| 是否激活机器人，0：禁用，1：激活

PS：除id外字段都是可选，没有输入的字段不会被更新或清空

#### 返回说明

	{
		'errcode': 0,
		'errmsg': 'ok'
	}

#### 8.2.3 删除群

	请求方式：GET
	请求URI：/api/applet/robot/group/del

#### 请求参数

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
id       |  是  |  int  |  1  |  群ID 

#### 返回说明

	{
		'errcode': 0,
		'errmsg': 'ok'
	}

#### 8.2.4 筛选符合条件的群

	请求方式：GET
	请求URI：/api/applet/robot/group/search

#### 请求参数

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
shop_id     |  是  |  int     |  1         |  店铺ID
name         |  否  |  string  |  test group  | 群名称 
visible		|  否  |   int	  |  1			| 是否显示到群导航，0：不显示，1：显示
active		|  否  |   int	  |  1			| 是否激活机器人，0：禁用，1：激活
page		|  否  |   int     |  1			| 页数，默认1
size		|  否  |   int	  |  10			| 每页数量，默认10

PS：除shop_id外字段都是可选，不指定可选字段相当于列出该机器人拥有的所有群

#### 返回说明

	[
	    {
	        "active": false,
	        "create_time": "2017-10-05 15:21:19",
	        "desc": "Hello Cat!",
	        "id": 2,
	        "name": "Test Group 2",
	        "notice": "喵喵喵喵喵",
	        "robot": 1,
			"group_uid": '@fdsabf3j2rd',
	        "update_time": "2017-10-05 15:21:19",
	        "visible": 1
	    },
	    {
	        "active": true,
	        "create_time": "2017-10-05 14:31:06",
	        "desc": "Hello Meow!",
	        "id": 1,
	        "name": "测试Group",
	        "notice": "啊，恒定电流",
	        "robot": 1,
			"group_uid": '@dsafh4u3iqrdewa',
	        "update_time": "2017-10-05 14:31:06",
	        "visible": 1
	    }
	]

#### 8.2.5 获取某个群的信息

	请求方式：GET
	请求URI：/api/applet/robot/group/get

#### 请求参数

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
id       |  是  |  int  |  1  |  群id

#### 返回说明

	{
	    "active": false,
	    "create_time": "2017-10-05 15:21:19",
	    "desc": "Hello Cat!",
	    "id": 2,
	    "name": "Test Group 2",
	    "notice": "喵喵喵喵喵",
	    "robot": 1,
		"group_uid": "@fdsanu3i2jrfeow",
	    "update_time": "2017-10-05 15:21:19",
	    "visible": 1
	}

### 8.3 自动回复

P.S: 接口设置的自动回复都是与机器人绑定的，Django Admin里面可以设置全局自动回复

#### 8.3.1 添加自动回复

	请求方式：POST
	请求URI：/api/applet/robot/autoreply/add

#### 请求参数

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
shop_id  |  是      |  int    |  1      |  店铺id
keyword  |  是	   |  string | hello   |  关键词
reply    |  是      |  string | world   |  回复内容
match    |  否      |   int   |  1      |  匹配方式，1=全字匹配（默认），0=包含匹配
active   |  否      |   int   |  1      |  是否启用，1=激活（默认），0=禁用
scope    |  否      |   int   |  3      |  适用范围，1=仅用户，2=仅群，3=全部适用

#### 返回说明

	{
		'errcode': 0,
		'errmsg': 'ok'
	}

#### 8.3.2 获取某条自动回复的信息

	请求方式：GET
	请求URI：/api/applet/robot/autoreply/get

#### 请求参数

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
id       |  是  |  int  |  1  |  自动回复id

#### 返回说明

	{
	    "active": 1,
	    "create_time": "2017-10-11 15:00:27",
	    "id": 4,
	    "keyword": "meow",
	    "match": 0,
	    "reply": "喵~o( =∩ω∩= )m",
	    "robot": 1,
	    "scope": 3,
	    "update_time": "2017-10-11 15:00:27"
	}

#### 8.3.3 列出某个机器人的所有自动回复

	请求方式：GET
	请求URI：/api/applet/robot/autoreply/list

#### 请求参数

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
shop_id       |  是  |  int  |  1  |  店铺id 

#### 返回说明

	[
	    {
	        "active": 1,
	        "create_time": "2017-10-11 15:00:27",
	        "id": 4,
	        "keyword": "meow",
	        "match": 0,
	        "reply": "喵~o( =∩ω∩= )m",
	        "robot": 1,
	        "scope": 3,
	        "update_time": "2017-10-11 15:00:27"
	    },
	    {
	        "active": 1,
	        "create_time": "2017-10-11 14:54:25",
	        "id": 3,
	        "keyword": "world",
	        "match": 1,
	        "reply": "meow~",
	        "robot": 1,
	        "scope": 3,
	        "update_time": "2017-10-11 14:54:25"
	    },
	    {
	        "active": 1,
	        "create_time": "2017-10-11 14:54:12",
	        "id": 2,
	        "keyword": "hello",
	        "match": 1,
	        "reply": "喵~",
	        "robot": 1,
	        "scope": 3,
	        "update_time": "2017-10-11 14:54:12"
	    }
	]

#### 8.3.4 更新自动回复

	请求方式：POST
	请求URI：/api/applet/robot/autoreply/update

#### 请求参数

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
id       |  是      |  int    |  1      |  自动回复id
keyword  |  否	   |  string | hello   |  关键词
reply    |  否      |  string | world   |  回复内容
match    |  否      |   int   |  1      |  匹配方式
active   |  否      |   int   |  1      |  是否启用
scope    |  否      |   int   |  3      |  适用范围

#### 返回说明

	{
		'errcode': 0,
		'errmsg': 'ok'
	}

PS：除id外字段都是可选，没有输入的字段不会被更新或清空


#### 返回说明

	{
		'errcode': 0,
		'errmsg': 'ok'
	}

#### 8.3.5 删除自动回复

	请求方式：GET
	请求URI：/api/applet/robot/autoreply/del

#### 请求参数

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
id      |  是      |  int     |  2      |  自动回复id

#### 返回说明

	{
		'errcode': 0,
		'errmsg': 'ok'
	}


## 9 评比活动相关

### 9.1 评比活动展示/报名
#### 9.1.1 获取评比活动详情

#### 接口调用说明

	请求方式：GET
	请求uri：/api/applet/contest/info/get
	
#### 请求参数

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
contest_id  |  是  |  int  |  1  |  评比活动id

#### 返回说明

	{
        "city": {
            "eng_name": "Edmonton",
            "id": 7,
            "img": "/city_image/edmonton.jpg",
            "name": "埃德蒙顿",
            "timezone": -6
        },
        "description": "“萨省歌王”卡拉OK大赛规则\r\n\r\n1. 第一阶段，海选：\r\n参赛选手自行选歌，以30秒左右的时长以音频为主视频为辅的形式记录自己的作品，题材不限。自行录制好作品以后，统一发送到指定平台。我们将采用评委团打分（占70%）+公众打分（占30%）选取出成绩最佳的36名选手参加预选赛。\r\n\r\n2. 第二阶段，预选赛：\r\n参加预选赛的歌手，需要自备音频背景音乐，在截止日期前各自将准备歌颂的背景音乐资料递交给主办方，资料一旦递交，选定歌曲将不可再修改。预选赛作品仅需提供一首曲目的资料，题材不限。预选赛将会从海选出来的36名歌手中脱颖而出18位参加总决赛。36名海选出的歌手将会在比赛地点演唱准备作品，结果将会由现场的4名评委评分，以评分高低进行排名，塞选出晋级决赛的18名歌手。\r\n\r\n3. 第三阶段，总决赛：\r\n“萨斯卡通新年之夜暨萨省歌王总决赛”，将角逐出“萨省十佳歌手”，以及“萨省歌王”的冠亚季军。晋级决赛的歌手均有奖品，奖品会在预选赛时公布。",
        "enrolls": [
            {
                "audio_link": "http://www.baidu.com",
                "comment": "朋友2",
                "has_rate": true,
                "id": 1,
                "img_link": "",
                "phone": "18627144098",
                "phone_code": "86",
                "rate_count": 1,
                "rate_users": [
                    {
                        "avatar": "https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIRYmb8O0nKjwTFkRootmmmaj8qkxaUbEde3PjtxoYhhsiaXptqKFlLdCEIkgaUiaAV7IGCibLBWR2aw/0",
                        "id": 1269,
                        "name": "旅行者降龙"
                    }
                ],
                "real_name": "降龙",
                "user": {
                    "avatar": "https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIRYmb8O0nKjwTFkRootmmmaj8qkxaUbEde3PjtxoYhhsiaXptqKFlLdCEIkgaUiaAV7IGCibLBWR2aw/0",
                    "id": 1269,
                    "name": "旅行者降龙"
                },
                "video_link": ""
            }
        ],
        "has_enrolled": true,
        "id": 1,
        "img": "http://overseas-1252412068.costj.myqcloud.com/user/image/1509515303144-WechatIMG141.jpeg",
        "name": "“萨省歌王”卡拉OK大赛",
        "need_enroll_audio": 2,
        "need_enroll_img": 1,
        "need_enroll_video": 1
    }

#### 9.1.2 报名评比活动

#### 接口调用说明

	请求方式：POST
	请求uri：/api/applet/contest/enroll
	
#### 请求参数

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
contest_id  |  是  |  int  |  1  |  评比活动id
real_name  |  否  |  str  |  zhangsan  |  真实姓名
phone  |  否  |  str  |  123233423423|  报名电话，活动需要设置报名电话时必填
phone_code  |  否  |  str  |  86  |  报名电话国家区号
video_link  |  否  |  str  |  http://xx  |  视频链接
audio_link  |  否  |  str  |  http://xx  |  音频链接
img_link  |  否  |  str  |  http://xx  |  图片链接
comment  |  否  | str  |  准时集合  |  活动备注，活动需要设置时必填

#### 返回说明

	{ errcode:0, errmsg: 'ok' }

#### 9.1.3 取消评比活动报名

#### 接口调用说明

	请求方式：POST
	请求uri：/api/applet/contest/enroll/cancel
	
#### 请求参数

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
contest_id  |  是  |  int  |  1  |  评比活动id

#### 返回说明

	{ errcode: 0, errmsg: 'ok' }
	
#### 9.1.4 评比活动报名信息

#### 接口调用说明

	请求方式：GET
	请求uri：/api/applet/contest/enroll_info/get
	
#### 请求参数

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
contest_id  |  是  |  int  |  1  |  评比活动id
page  |  否  |  int  |  2  |  分页获取数据中的页数，如不指定，则默认是第1页
size  |  否  |  int  |  10  | 分页获取数据中每页的个数，如不指定，则默认是10个

#### 返回说明

    {
        "current_page": 1,
        "enrolls": [
            {
                "audio_link": "http://www.baidu.com",
                "comment": "朋友2",
                "has_rate": true,
                "id": 1,
                "img_link": "",
                "phone": "18627144098",
                "phone_code": "86",
                "rate_count": 1,
                "rate_users": [
                    {
                        "avatar": "https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIRYmb8O0nKjwTFkRootmmmaj8qkxaUbEde3PjtxoYhhsiaXptqKFlLdCEIkgaUiaAV7IGCibLBWR2aw/0",
                        "id": 1269,
                        "name": "旅行者降龙"
                    }
                ],
                "real_name": "降龙",
                "user": {
                    "avatar": "https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIRYmb8O0nKjwTFkRootmmmaj8qkxaUbEde3PjtxoYhhsiaXptqKFlLdCEIkgaUiaAV7IGCibLBWR2aw/0",
                    "id": 1269,
                    "name": "旅行者降龙"
                },
                "video_link": ""
            }
        ],
        "total_count": 1,
        "total_page": 1
    }

#### 9.1.5 对评比活动选手投票

#### 接口调用说明

	请求方式：POST
	请求uri：/api/applet/contest/enroll/rate
	
#### 请求参数

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
enroll_id  |  是  |  int  |  1  |  报名id

#### 返回说明

	{ errcode: 0, errmsg: 'ok' }

#### 9.1.6 取消对评比活动选手的投票

#### 接口调用说明

	请求方式：POST
	请求uri：/api/applet/contest/enroll/rate/cancel
	
#### 请求参数

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
enroll_id  |  是  |  int  |  1  |  报名id

#### 返回说明

	{ errcode: 0, errmsg: 'ok' }

#### 9.1.7 对评比活动选手评论

#### 接口调用说明

	请求方式：POST
	请求uri：/api/applet/contest/enroll/comment
	
#### 请求参数

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
enroll_id  |  是  |  int  |  1  |  报名id
content  |  是  |  str  |  test  |  评论内容

#### 返回说明

	{ comment_id: 1}

#### 9.1.8 对评比活动选手投票用户列表（需要分页）

#### 接口调用说明

	请求方式：POST
	请求uri：/api/applet/contest/enroll/rate_infos
	
#### 请求参数

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
enroll_id  |  是  |  int  |  1  |  报名id
page  |  否  |  int  |  2  |  分页获取数据中的页数，如不指定，则默认是第1页
size  |  否  |  int  |  10  | 分页获取数据中每页的个数，如不指定，则默认是10个

#### 返回说明

    {
        "current_page": 1,
        "rates": [
            {
                "avatar": "https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIRYmb8O0nKjwTFkRootmmmaj8qkxaUbEde3PjtxoYhhsiaXptqKFlLdCEIkgaUiaAV7IGCibLBWR2aw/0",
                "create_time": 1510209239,
                "id": 1269,
                "name": "旅行者降龙"
            }
        ],
        "total_count": 1,
        "total_page": 1
    }

#### 9.1.9 对评比活动选手评论列表（需要分页）

#### 接口调用说明

	请求方式：GET
	请求uri：/api/applet/comments/get
	
#### 请求参数说明

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
owner_id  |  是  |  int  |  987  | 报名信息ID
type  |  是  |  int  |  9  |  这里传9, 表示评比活动 
page  |  否  |  int  |  2  |  分页获取数据中的页数，如不指定，则默认是第1页
size  |  否  |  int  |  10  | 分页获取数据中每页的个数，如不指定，则默认是10个

#### 返回说明

	{
		current_page: 1, 
		total_page: 3,
		total_count: 27,
		comments: [
			{
				id: 231,
				content: "留言内容",
				user_name: "xxx",
				user_id: 132,
				user_avatar: "/user/image/xxx.jpg",
				create_time: "1440751417",
				replys: [
					{
						id: 231,
						content: "留言回复内容",
						user_name: "xxx",
						user_id: 214,
						user_avatar: "xxx",
						create_time: "1440751876"
					}
				]
			}
		]
	}

#### 9.1.10 获取评比活动报名详情

#### 接口调用说明

	请求方式：GET
	请求uri：/api/applet/contest/enroll/info
	
#### 请求参数说明

参数名   |   必填   |   类型   |  示例值    | 描述
-------- | -------- | -------- | ---------- | ---------
enroll_id  |  是  |  int  |  1  | 报名信息ID

#### 返回说明

    {
        "age": 0,
        "audio_link": "http://dl.stream.kg.qq.com/szkge/08219f78df58d889cd31086888b8e5bcb5953931?ftnrkey=7d4c440bcbe87c5d174918dec9940f155e8eafe2ce3f983d2c9870a70b39d70f7f366b00abeb054fe91279717c11f82476bac3fdd90cd3929df4071658eca378&vkey=584288E22FB77327D7A551C3B7C280A62D9F8013092F43443890E805682487790FF5A596D297A541EE8242E5085FD71947284C4F96C94101D919EE881C623070D8251CC7FEDFA59B9F506C9FD00D352472A696714424055C&fname=1021_3c93abefebb92fac547e47ef80f987fc7581d6ae.0.m4a&fromtag=1006&sdtfrom=v1006",
        "comment": "味道－磨刀石版",
        "has_rate": true,
        "id": 14,
        "img_link": "/user/image/tmp_1463143650o6zAJs2Nq7bx1n1P9Xi52mOM_hVY66afecaeaac3946795241103bdb1e3ee.png",
        "phone": "3068505587",
        "phone_code": "+1",
        "rate_count": 21,
        "rate_users": [
            {
                "avatar": "https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83eqZCXfepZv9QwpQrm5yicXiba1mSoypMKPXV9yGUqEYJZWJ17KKuY0QdmhsSHp2unicR84FqgC9uswrw/0",
                "id": 36,
                "name": "海风"
            },
            {
                "avatar": "https://wx.qlogo.cn/mmopen/vi_32/U3Lk8ER2iaTDKQpJ6W4DzNgkkw35X2Wr0mTUg6ZMYOhEoGodoiauYmjIqhUsTQBumXRauJhNzNkzoMjRRYC19dZQ/0",
                "id": 1672,
                "name": "虚幻"
            },
            {
                "avatar": "https://wx.qlogo.cn/mmopen/vi_32/XboqrzByF4V005iaxUfkGx2qF73AVicKe7Iiawpol92rHibvjsmQnfSxO9miaicn631w32sd2g1Qq8XZFgwgqumXdZgQ/0",
                "id": 1738,
                "name": "天赐雨"
            },
            {
                "avatar": "https://wx.qlogo.cn/mmopen/vi_32/ajNVdqHZLLBs6lwwczB4h0uDmT0OckNjoCym5auESgLUTD4ztADIJje4TQO3IYB1iamZGYbyx59BlWm98XXavhQ/0",
                "id": 506,
                "name": "\u202dZiven"
            },
            {
                "avatar": "https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJGHGcIwT7Lm34fDv45Ul2xKgaLweUsJ1dUYicic3lnN2Ce7RZQGG3wiaCKwuoZGcz7OicOW0lRM3DMPQ/0",
                "id": 508,
                "name": "andy wjc"
            },
            {
                "avatar": "https://wx.qlogo.cn/mmopen/vi_32/iaAJicLpvCxETkWkNLhEzRBsMYd73gbdU4dgD6oyM8MexU5JR3nk25icr11etl7GxNUbRrOPogR8xqKibpUdniacZDw/0",
                "id": 507,
                "name": "大勇"
            }
        ],
        "real_name": "海风6",
        "user": {
            "avatar": "https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83eqVwVLvTEWExF5rajq4HNDJzRK7YMTUNybupzMiaFrbpVYMfGQlAoHMo6TF44Jr101ib2A7cQksuFGw/0",
            "id": 49,
            "name": "二少爷。"
        },
        "video_link": ""
    }
