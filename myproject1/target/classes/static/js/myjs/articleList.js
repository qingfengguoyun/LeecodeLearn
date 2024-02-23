

function queryAllArticlesView() {
    $.ajax({
        url:"/article/queryAllArticlesView",
        type:"Get",
        success:function (html) {
            $("#articleShow").html(html);
        }
    });
    //显示发布新主题按钮
    $(".newArticle").removeAttr("hidden");
}

function queryArticleByPageNo(pageNo) {

    // 检测是否有搜索记录
    var articleTitle=$("#searchRecord").attr("searchRecord");

    var articleShow=$("#articleShow");
    var data={};
    data['pageNo']=pageNo;
    //若搜索记录存在且不为空则添加articleTitle参数
    if(articleTitle!=null && articleTitle!=""){
        data['articleTitle']=articleTitle;
    }
    alert(JSON.stringify(data));
    $.ajax({
        url:"/article/queryArticleByPageNoView",
        type:"GET",
        data:data,
        success:function (html) {
            console.log(html)
            articleShow.html(html);
        }
    })
    //显示发布新主题按钮
    $(".newArticle").removeAttr("hidden");
}

function newArticle() {
    //导入添加界面
    $.ajax({
        type:"GET",
        url:"/article/newArticleView",
        success:function (html) {
            $("#articleShow").html(html);
        }
    })
    //将发布新主题按钮隐藏
    $(".newArticle").attr("hidden","hidden");
}
function recordSearchElement() {
    //获取上方搜索框框的值
    $("#searchRecord").attr("searchRecord",$("#top-search").val());

    //显示搜索结果的第一页
    queryArticleByPageNo(1);
}

//主题summernote的上传图片方法的重写
function saveArticleImage(files,editor, welEditable) {
    var data = new FormData();
    data.append("file",files[0]);
    $.ajax({
        data:data,
        type:"POST",
        url:"/article/saveArticleImage",
        cache:false,
        contentType:false,
        processData: false,

        success:function (url) {
            console.log(url);
            editor.insertImage(welEditable,url,'img');
        }
    })
}
function admitArticle() {
    //获取富文本输入框的内容
    var articleContent=$('.article-summernote').code()
    var data={};
    //从界面的隐藏div中获取userId
    var userId=$("#userId").attr("userId");
    data['userId']=userId;
    console.log("userId"+$("#userId").attr("userId"))
    //获取主题Title
    data['articleTitle']=$(".newArticleTitle").val();
    //获取主题的Content
    data['articleContent']=articleContent;
    //转化为json字符串
    data=JSON.stringify(data);
    $.ajax({
        type:"POST",
        url:"/article/insertArticle",
        data:data,
        contentType: "application/json",
        success:function (res) {
            console.log(res.code);
        }
    })
    //提交完成后显示文章列表
    queryAllArticlesView();
}