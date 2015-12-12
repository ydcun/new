[toc]

basepath = http://xxxxx:8080/news

##文章
####获取某类别文章
	url=$basepath/articles
	method:get
	参数：
	{
    "key":"dua系统中app的key,是一个32位的字符串"，
    "dua":"64位的整型：bigint/long long"，
    “channel”:"文章的类型。int型数字"，
    “num”:“int整形，要获取多少篇文章”,
    "lid":"查询数据库aid以后的文章"
    }
    返回值：
    1.失败{"status":"error","data":"news服务器维护12：00~3：00中"}
    //有可能是key值不存在，dua_id无权限。
    2.成功{"status":"ok","data":[
		{
        "id":"1",
        "title":"题目",
        "brief":"简介",
        "digest":"摘要信息",
        //"content":"文章内容",
        "image":"文章缩略图路径",
        "keywords":"关键词",
        "top":"是否置顶0不置顶 1置顶",
        "original":"是否原创0否1是",
        "views":"阅读数量",
        "likes":"点赞数",
        "hates":"点踩数",
        "comments":"评论数",
        "copyfrom":"版权来自",
        "author":"作者名字",
        "time":"创建日期",
        },{....}]}
    
	测试值： {key:"dd","dua":"555","channel":"1",num:"10",lid:"10"}   正确
		{key:"ddsss","dua":"555","channel":"1",num:"10",lid:"10"}  失败 没有权限
		{key:"dd","dua":"555d","channel":"1",num:"10",lid:"10"} 失败 dua必须是数子
		{key:"dd","dua":"555","channel":"1",num:"10d",lid:"10"} 失败 num必须是整形
		{key:"dd","dua":"555","channel":"1",num:"10",lid:"10d"} 失败 lid必须是整形

####获取一篇文章
	url=$basepath/articles
	method:getOne
	参数：
    {
        "key":"dua系统中app的key,是一个32位的字符串"，
        "dua":"64位的整型：bigint/long long"， 
        "aid":"查询指定id的文章"
    }
	返回值：
    1.失败{"status":"error","data":"news服务器维护12：00~3：00中"}
    //有可能是key值不存在，dua_id无权限。
    2.成功{"status":"ok","data":
    {
        "id":"1",
        "title":"题目",
        "brief":"简介",
        "digest":"摘要信息",
        //"content":"文章内容",
        "image":"文章缩略图路径",
        "keywords":"关键词",
        "top":"是否置顶0不置顶 1置顶",
        "original":"是否原创0否1是",
        "views":"阅读数量",
        "likes":"点赞数",
        "hates":"点踩数",
    "comments":"评论数",
    "copyfrom":"版权来自",
        "author":"作者名字",
        "time":"创建日期",
        }}
    测试值：
    {key:"dd","dua":"555","aid":'2'} 成功
    {key:"dddds","dua":"555","aid":'2'} 失败 没有权限
    {key:"dd","dua":"555","aid":'1'} 失败 没有找到对应的文章

####获取头条文章
    url=$basepath/articles
    method: getHead
    参数：
    {
    "key":"dua系统中app的key,是一个32位的字符串"，
    "dua":"64位的整型：bigint/long long"， 
    "channel":"查询指定文章的类型code"
    }
    返回值：
    1.失败{"status":"error","data":"news服务器维护12：00~3：00中"}
    //有可能是key值不存在，dua_id无权限。
    2.成功{"status":"ok","data":
    {
        "id":"1",
        "title":"题目",
        "brief":"简介",
        "digest":"摘要信息",
        //"content":"文章内容",
        "image":"文章缩略图路径",
        "keywords":"关键词",
        "top":"是否置顶0不置顶 1置顶",
        "original":"是否原创0否1是",
        "views":"阅读数量",
        "likes":"点赞数",
        "hates":"点踩数",
    "comments":"评论数",
    "copyfrom":"版权来自",
        "author":"作者名字",
        "time":"创建日期",
        }}
    测试值：
    {key:"dd","dua":"555","aid":'2'} 成功
    {key:"dddds","dua":"555","aid":'2'} 失败 没有权限
    {key:"dd","dua":"555","aid":'1'} 失败 没有找到对应的文章

####文章点赞一次|点踩一次
    url=$basepath/articles
    method=put
    参数：
    {
    "key":"dua系统中app的key,是一个32位的字符串"，
    "dua":"64位的整型：bigint/long long"，
    "aid":"文章id",
    "action":"1: 点击阅读2是赞 3是踩",
    }
    返回值：
    1.失败{"status":"error","data":"原因"}
        2.成功{"status":"ok"}
    测试案例
    {key:"dd","dua":"555","aid":'345',"action":"1"}  成功
    {key:"ddsss","dua":"555","aid":'345',"action":"1"}  失败 没有权限
    {key:"dd","dua":"555","aid":'adf',"action":"1"} 失败 aid不是数字



##评论
####获取一篇文章的评论
    url=$baseurl/comments
    method=get
    参数：
    {
    "key":"dua系统中app的key,是一个32位的字符串"，
    "dua":"64位的整型：bigint/long long"，
    “aid“:”文章id”
    "page":"第几页的数据",
    “num”:”一页多少条”
    }
    返回值：
    1.失败{"status":"error","data":"错误信息"}
    2.成功{"status":"ok","data":[
    {	
    "id":"评论id",
        "content":"评论内容",
        "time":"评论时间",
        "dua":"评论用户dua_id",
        "name":"评论用户用户名",
        "location":"写评论地点",
        "likes":"评论点赞量",
        "hates":"评论点踩量",
        },{...}
        ]}
    测试值;
    {key:"dd","dua":"555","aid":'2',"page":1,num:10} 正确 获取的是第一页每页10条
    {key:"dsssd","dua":"555","aid":'2',"page":1,num:10} 失败 没有权限
    {key:"dd","dua":"555","aid":'2',"page":-1,num:10} 失败 没有查找数据
####添加评论
    url=$basepath/comments
    method:post
    参数：
    {
    "key":"dua系统中app的key,是一个32位的字符串"，
    “dua”: "64位的整型：bigint/long long"，
    "aid":"文章id",
                "content":"评论内容",
                "username":"评论用户用户名",
                "location":"写评论地点",
                "lonlat":"评论地点的经纬度double,double的方式提交",
            "ip":"评论客户端的ip地址"
    }
        返回值：
        1.失败{ status:”error”,"data":"错误信息"}
        2.成功{status:”ok”}
    测试值：
    {key:"dd","dua":"555","aid":'2',"content":"很不粗哦的呀",username:"王伟",'location':'北京海淀','lonlat':"0,0",ip:"127.0.0.1"} 成功
    {key:"ddddssd","dua":"555","aid":'2',"content":"很不粗哦的呀",username:"王伟",'location':'北京海淀','lonlat':"0,0",ip:"127.0.0.1"}  失败没有权限
    
####评论点赞一次|点踩一次
    url=basepath+/comments
    method:put
        参数：
        {
    "key":"dua系统中app的key,是一个32位的字符串"，
    "dua":"64位的整型：bigint/long long"，
    "aid":"文章id",
                "cid":"评论id",
                " action":"0是踩 1是赞"
    }
        返回值：
        1.失败{"status":"error","data":"错误信息"}
	2.成功{”status”:”ok”}
    测试值
    {key:"dd","dua":"555","aid":'2',cid:3,"action":"1"}  成功 踩
    {key:"dd","dua":"555","aid":'2',cid:3,"action":"0"}  成功 赞
    {key:"dsssd","dua":"555","aid":'2',cid:3,"action":"0"}  失败 没有权限
    {key:"dd","dua":"555","aid":'d2',cid:3,"action":"1"} 失败 aid不是数字

