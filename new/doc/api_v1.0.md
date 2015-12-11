[toc]

basepath = http://115.28.40.128:8080/news

##文章
####获取某类别文章
	url=basepath+/article/getArticleList
   	参数：
    {
        "key":"dua系统中app的key,是一个32位的字符串"，
        "dua":"64位的整型：bigint/long long"，
        "channel":"文章的类型。int型数字"，
        "latestN":"int整形，要获取最近的多少篇文章",
        "localid":"客户端上次更新的文章的最新id"
    }
    返回值：
    1.失败{"status":"error","data":"news服务器维护12：00~3：00中"}//有可能是key值不存在，dua_id无权限。
    2.成功{"status":"ok","data":[
    {
        "id":"1",
        "title":"题目",
        "brief":"简介",
        "digest":"摘要信息",
        "content":"文章内容",
        "image":"文章缩略图路径",
        "keywords":"关键词",
        "istop":"是否置顶0不置顶 1置顶",
        "original":"是否原创0否1是",
        "views":"阅读数量",
        "likes":"点赞数",
        "hate":"点才数",
        "comments":"评论数",
        "status":"状态0删除1未审核2审核未通过3审核通过",
        "copyfrom":"版权来自",
        "author":"作者名字",
        "time":"创建日期",
    },
    {....}
    ]}
    
####文章点赞一次|点踩一次
	url=basepath+/article/putArticle
    参数：
    {"article_id":"文章id",
    "type":"0是踩 1是赞"}
    返回值：
    1.失败{"error":"错误信息"}
    2.成功{"reslut":"ok"}

##评论
####获取一篇嗯张的所有评论
	url=basepath+/article/getCommentList
    参数：
    {"article_id":"文章id"}
    返回值：
    1.失败{"error":"错误信息"}
    2.成功{"reslut":"ok","commentList":[
    {"id":"评论id",
    "content":"评论内容",
    "time":"评论时间",
    "userid":"评论用户dua_id",
    "username":"评论用户用户名",
    "location":"写评论地点",
    "like":"评论点赞量",
    "hate":"评论点踩量",
    },{...}
    ]}

####根据评论id获取一条评论
	url=basepath+/article/getCommentOne
    参数：
    {"article_id":"文章id",
    "comment_id":"某条评论的id"}
    返回值：
    1.失败{"error":"错误信息"}
    2.成功{"reslut":"ok","commentList":[
    {"id":"评论id",
    "content":"评论内容",
    "time":"评论时间",
    "userid":"评论用户dua_id",
    "username":"评论用户用户名",
    "location":"写评论地点",
    "like":"评论点赞量",
    "hate":"评论点踩量",
    }]}

####添加评论
	url=basepath+/article/postComment
    参数：
    {"article_id":"文章id",
    "content":"评论内容",
    "userid":"评论用户dua_id",
    "username":"评论用户用户名",
    "location":"写评论地点",
    "lonlat":"评论地点的经纬度double,double的方式提交",
    "ip":"评论客户端的ip地址"}
    返回值：
    1.失败{"error":"错误信息"}
    2.成功{"reslut":"ok"}

####评论点赞一次|点踩一次
	url=basepath+/article/putComment
    参数：
    {"article_id":"文章id",
    "comment_id":"评论id",
    "type":"0是踩 1是赞"}
    返回值：
    1.失败{"error":"错误信息"}
    2.成功{"reslut":"ok"}