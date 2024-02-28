// 对回复进行回复
function showReply(editor) {

    //清除main_summernote的富文本编辑器
    $(".main-summernote").destroy();
    //隐藏主回复区域
    $(".main-reply").attr("hidden","hidden");

    $(".onEdit").removeClass("onEdit");

    //提供父回复的Id
    var commentId=$(editor).attr('commentId');
    // //清空所有回复区的组件
    var commentReplys=$(".comment-reply");
    commentReplys.empty();
    //选择要回复的评论的回复区
    var reply=$(`div[commentId=${commentId}]`);
    //添加onEdit类进行标记
    reply.addClass("onEdit");

    //将回复区域长度置满（否则右侧出现不明空缺）
    reply.css("width","100%");

    //选择要回复的评论的提交按钮区域
    var admit=$(`div[admitId=${commentId}]`);
    //显示按钮
    admit.removeAttr("hidden");

    var replyTip=`<div><h2>评论内容：</h2></div>`;
    var summernote=`<div class="summernote" style="margin-top: 10px;overflow: hidden"></div>`;

    reply.append(replyTip);
    //添加回复区域的富文本框
    reply.append(summernote);
    //初始化富文本框
    $(".summernote").summernote({
        toolbar: [
            ['style', ['bold', 'italic', 'underline', 'clear']],
            ['color', ['color']],
            ['para', ['ul', 'ol']],
            ['insert', ['picture']]
        ],

        focus:true,
        // 重写图片上传与回显方法
        onImageUpload:function (files,editor,welEditable) {
            saveCommentImage(files,editor,welEditable);
        },
    });
    $("#admitComment").blur("click",admit);
    return false;
}
//生成主回复区的富文本编辑器
function generateMainSummernote(){
    //生成主回复区的富文本编辑器
    $(".main-summernote").summernote({
        toolbar: [
            ['style', ['bold', 'italic', 'underline', 'clear']],
            ['color', ['color']],
            ['para', ['ul', 'ol']],
            ['insert', ['picture']]
        ],

        focus:true,
        // 重写图片上传与回显方法
        onImageUpload:function (files,editor,welEditable) {
            saveCommentImage(files,editor,welEditable);
        },
    });
}
//放弃回复
function quit(){
    //清除当前的富文本输入区
    $(".summernote").destroy();
    //清空选中的富文本输入区
    $(".onEdit").empty();
    //清除富文本输入区的onEdit属性
    $(".onEdit").removeClass("onEdit");
    //给含有回复按钮的div添加hidden
    $("div[admitId]").attr("hidden","hidden");
    //令主回复区域显示
    $(".main-reply").removeAttr("hidden");
    //生成主回复区的富文本编辑器
    generateMainSummernote();
}
// 发送对评论回复
function admit(){
    //获取富文本编辑器的内容
    var commentContent=$('.summernote').code();
    var data={};
    //从界面的隐藏div中获取userId
    var userId=$("#userId").attr("userId");
    data['userId']=userId;
    console.log("userId"+$("#userId").attr("userId"))
    //从隐藏的div中获取articleId
    var articleId=$("#articleId").attr("articleId")
    data['articleId']=articleId;
    console.log("articleId"+$("#articleId").attr("articleId"))
    data['commentContent']=commentContent;
    //从onEdit中获取父回复的Id
    data['parentCommentId']=$(".onEdit").attr("commentId");

    //转化为json字符串
    data=JSON.stringify(data);
    $.ajax({
        type:"POST",
        url:"/comment/insertComment",
        data:data,
        contentType:"application/json",
        success:function (res) {
            if(res.code=0){
                alert("回复已提交");
            }
        }
    })
    //刷新评论区
    queryCommentByArticleIdAndPageNo(articleId,1);

    $(".summernote").destroy();
    //清空选中的富文本输入区
    $(".onEdit").empty();
    //清除富文本输入区的onEdit属性
    $(".onEdit").removeClass("onEdit");
    //给含有回复按钮的div添加hidden
    $("div[admitId]").attr("hidden","hidden");
}
// 发送对主题的回复
function mainAdmit(){
    //获取富文本编辑器的内容
    var commentContent=$('.main-summernote').code();
    var data={};
    //从界面的隐藏div中获取userId
    var userId=$("#userId").attr("userId");
    data['userId']=userId;
    console.log("userId"+$("#userId").attr("userId"))
    //从隐藏的div中获取articleId
    var articleId=$("#articleId").attr("articleId")
    data['articleId']=articleId;
    console.log("articleId"+$("#articleId").attr("articleId"))
    data['commentContent']=commentContent;
    //父回复的Id=0
    data['parentCommentId']=0;

    //转化为json字符串
    data=JSON.stringify(data);
    $.ajax({
        type:"POST",
        url:"/comment/insertComment",
        data:data,
        contentType:"application/json",
        success:function (res) {
            if(res.code=0){
                alert("回复已提交");
            }
        }
    })
    //刷新评论区
    queryCommentByArticleIdAndPageNo(articleId,1);

    console.log("do1");
    $(".main-summernote").code("");
    console.log("do2");

    console.log("do3");
    //清空选中的富文本输入区
    $(".onEdit").empty();
    //清除富文本输入区的onEdit属性
    $(".onEdit").removeClass("onEdit");
    //给含有回复按钮的div添加hidden
    $("div[admitId]").attr("hidden","hidden");
}
//summernote重写图片上传与回显方法
function saveCommentImage(files,editor, welEditable){
    var data = new FormData();
    data.append("file",files[0]);
    $.ajax({
        data:data,
        type:"POST",
        url:"/comment/saveCommentImage",
        cache:false,
        contentType:false,
        processData: false,

        success:function (url) {
            console.log(url);
            editor.insertImage(welEditable,url,'img');
        }
    })
}

